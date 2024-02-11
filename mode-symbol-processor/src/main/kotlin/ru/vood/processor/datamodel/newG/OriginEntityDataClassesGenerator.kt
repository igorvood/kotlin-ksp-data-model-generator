package ru.vood.processor.datamodel.newG

import com.google.devtools.ksp.processing.KSPLogger
import com.squareup.kotlinpoet.*
import ru.vood.dmgen.annotation.FlowEntityType
import ru.vood.model.generator.ksp.common.CommonClassNames.iEntityOrigin
import ru.vood.model.generator.ksp.common.CommonClassNames.modelEntity
import ru.vood.model.generator.ksp.common.CommonClassNames.serializable
import ru.vood.model.generator.ksp.common.KspCommonUtils.generated
import ru.vood.processor.datamodel.abstraction.model.Dependency
import ru.vood.processor.datamodel.abstraction.model.MetaEntity
import ru.vood.processor.datamodel.abstraction.model.MetaForeignKey
import ru.vood.processor.datamodel.abstraction.model.MetaInformation
import ru.vood.processor.datamodel.gen.CollectName.entityClassName
import ru.vood.processor.datamodel.newG.SerializableEntityGenerator.Companion.designEntityNamePropertySpec
import ru.vood.processor.datamodel.newG.abstraction.AbstractEntityGenerator

class OriginEntityDataClassesGenerator(
    private val metaInformation: MetaInformation,
    private val kspLogger: KSPLogger,

    ) : AbstractEntityGenerator() {

    override fun files(): List<FileSpec> {
        return collectEntityFile(metaInformation.metaForeignKeys, metaInformation.aggregateInnerDep)
    }

    /**рекурсивная ф-ция по генерации чистых сущностей*/
    private fun collectEntityFile(
        metaForeignKeys: Set<MetaForeignKey>,
        aggregateInnerDep: Dependency,
        collector: Set<FileSpec> = setOf(),
    ): List<FileSpec> {
        val metaEntity = aggregateInnerDep.metaEntity
        // Имя создаваемого класса
        val classNameStr = entityClassName(metaEntity.designPoetClassName) //+ "Temp"

        //Создам Файл для класса
        val fileSpec = FileSpec.builder(
            packageName = metaEntity.designPoetClassName.packageName,
            fileName = classNameStr.simpleName
        )

        // selaed и иные классы создаются по разному
        val classBuilder = when (metaEntity.flowEntityType) {
            FlowEntityType.INNER, FlowEntityType.AGGREGATE -> dataClassBuilder(
                classNameStr,
                metaEntity,
                metaForeignKeys
            )
            FlowEntityType.ONE_OF -> sealedInterfaceBuilder(
                classNameStr,
                metaEntity,
                metaForeignKeys
            )
        }


        // для всех потомков текущего класса рекурсивно вызвать формирование сущностей
        val childrenFiles = aggregateInnerDep.children
            .map { df -> collectEntityFile(metaForeignKeys, df, collector) }
            .flatten()
            .toSet()

        // надо добавить только что сгенерированный класс к его потомкам
        return listOf(fileSpec.addType(classBuilder.build()).build()).plus(childrenFiles)
    }

    private fun sealedInterfaceBuilder(
        classNameStr: ClassName,
        metaEntity: MetaEntity,
        metaForeignKeys: Set<MetaForeignKey>,
    ): TypeSpec.Builder {
        // Создам интерфейс, что будет описываться в файле
        val classBuilder = TypeSpec.interfaceBuilder(classNameStr)
            .generated(this::class)
            .addAnnotation(serializable)
            .addAnnotation(modelEntity)
            .addKdoc(metaEntity.comment ?: "Empty comment")
            .addModifiers(KModifier.SEALED)
            .addSuperinterface(metaEntity.designPoetClassName)
            .addSuperinterface(iEntityOrigin)

        // надо переопределить геттер из интерфейса iEntityOrigin
        val designPoetClassNameGetter = designEntityNamePropertySpec(metaEntity)

        return classBuilder
            .addProperty(designPoetClassNameGetter)
    }

    private fun dataClassBuilder(
        classNameStr: ClassName,
        metaEntity: MetaEntity,
        metaForeignKeys: Set<MetaForeignKey>,
    ): TypeSpec.Builder {
        // Создам класс, что будет описываться в файле
        val classBuilder = TypeSpec.classBuilder(classNameStr)
            .generated(this::class)
            .addAnnotation(serializable)
            .addAnnotation(modelEntity)
            .addKdoc(metaEntity.comment ?: "Empty comment")
            .addModifiers(KModifier.DATA)

        // Определить есть ли форены на sealed сущность
        val sealedForeign = metaForeignKeys.filter { fk ->
            fk.fromEntity.designClassFullClassName == metaEntity.designClassFullClassName &&
                    when (fk.toEntity.flowEntityType) {
                        FlowEntityType.INNER -> false
                        FlowEntityType.AGGREGATE -> false
                        FlowEntityType.ONE_OF -> true
                    }
        }

        when (sealedForeign.size) {
            // форенов нет, прописываю стандартные интерфейсы
            0 -> classBuilder
                .addSuperinterface(metaEntity.designPoetClassName)
                .addSuperinterface(iEntityOrigin)
            // форен один, прописываю стандартные интерфейсы + sealed интерфейс
            1 -> classBuilder
                .addSuperinterface(metaEntity.designPoetClassName)
                .addSuperinterface(iEntityOrigin)
                .addSuperinterface(entityClassName(sealedForeign[0].toEntity.designPoetClassName))
            // форенов несколько и такую ситуацию не могу обработать
            else -> kspLogger.error(
                "for $classNameStr found several foreign on sealed interface",
                metaEntity.ksAnnotated
            )
        }


        //поместить все проперти из наследуемого интерфеса (его имя тут хранится metaEntity.designPoetClassName) в дефолтный конструктор
        val propSpec = metaEntity.fields
            .sortedBy { it.position }
            .map { col ->
                PropertySpec.builder(col.name.value, col.typePoetClassName.copy(nullable = col.isNullable))
                    .initializer("%N", col.name.value)
                    .addKdoc(col.comment ?: "Empty comment")
                    .addModifiers(KModifier.OVERRIDE)
                    .mutable(false)
                    .build()
            }
        //надо добавить все свойства в конструктор
        val constructor: FunSpec.Builder = FunSpec.constructorBuilder()
        propSpec
            .forEach { ps ->
                val parameterSpec = ParameterSpec.builder(ps.name, ps.type)
                    .addKdoc(ps.kdoc)
                // если включена настройка по генерации значения по умолчанию для опциональных полей
                // и поле опциональное, надо проставить зн по умолчанию
                if (metaInformation.nullableProbSetDefaultNull && ps.type.isNullable) {
                    parameterSpec
                        .defaultValue(CodeBlock.of("%S", null))
                }

                // надо добавить параметры в конструктор
                constructor.addParameter(
                    parameterSpec.build()
                )
                // и также надо добавить эти же св-ва в класс
                classBuilder.addProperty(ps)
            }

        // надо переопределить геттер из интерфейса iEntityOrigin
        val designPoetClassNameGetter = designEntityNamePropertySpec(metaEntity)

        // добавить в класс конструктор и геттер
        classBuilder
            .primaryConstructor(constructor.build())
            .addProperty(designPoetClassNameGetter)
        return classBuilder
    }

    companion object {
        fun designEntityNamePropertySpec(metaEntity: MetaEntity) =
            PropertySpec.builder(designEntityNamePropertySpec.name, designEntityNamePropertySpec.type)
                .addKdoc(designEntityNamePropertySpec.kdoc)
                .addModifiers(KModifier.OVERRIDE)
                .getter(
                    FunSpec.getterBuilder()
                        .addCode(
                            "return %T.%L",
                            designEntityNamePropertySpec.type,
                            metaEntity.designPoetClassName.simpleName
                        )
                        .build()
                )
                .build()
    }
}