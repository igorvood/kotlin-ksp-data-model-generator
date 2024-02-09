package ru.vood.processor.datamodel.newG

import com.google.devtools.ksp.processing.KSPLogger
import com.squareup.kotlinpoet.*
import ru.vood.model.generator.ksp.common.CommonClassNames.iEntityOrigin
import ru.vood.model.generator.ksp.common.KspCommonUtils.generated
import ru.vood.processor.datamodel.abstraction.model.Dependency
import ru.vood.processor.datamodel.abstraction.model.MetaForeignKey
import ru.vood.processor.datamodel.abstraction.model.MetaInformation
import ru.vood.processor.datamodel.gen.CollectName
import ru.vood.processor.datamodel.newG.SerializableEntityGenerator.Companion.designEntityNamePropertySpec
import ru.vood.processor.datamodel.newG.abstraction.AbstractEntityGenerator

class OriginEntityDataClassesGenerator(
    private val metaInformation: MetaInformation,
    private val kspLogger: KSPLogger,

    ) : AbstractEntityGenerator() {

    override fun files(): List<FileSpec> {
        return collectEntityFile(metaInformation.metaForeignKeys, metaInformation.aggregateInnerDep(kspLogger))
    }

    private fun collectEntityFile(
        metaForeignKeys: Set<MetaForeignKey>,
        aggregateInnerDep: Dependency,
        collector: Set<FileSpec> = setOf(),
    ): List<FileSpec> {
        val metaEntity = aggregateInnerDep.metaEntity
        // Имя создаваемого класса
        val classNameStr = CollectName.entityClassName(metaEntity) + "Temp"

        //Создам Файл для класса
        val fileSpec = FileSpec.builder(
            packageName = metaEntity.designPoetClassName.packageName,
            fileName = classNameStr
        )

        // Создам класс, что будет описываться в файле
        val classBuilder = TypeSpec.classBuilder(classNameStr)
            .generated(this::class)
            .addKdoc(metaEntity.comment ?: "Empty comment")
            .addSuperinterface(metaEntity.designPoetClassName)
            .addSuperinterface(iEntityOrigin)
            .addModifiers(KModifier.DATA)

        //поместить все проперти из наследуемого интерфеса (его имя тут хранится metaEntity.designPoetClassName) в дефолтный конструктор
        val propSpec = metaEntity.fields
            .sortedBy { it.position }
            .map { col ->
                PropertySpec.builder(col.name.value, col.typePoetClassName)
                    .initializer("%N", col.name.value)
                    .addKdoc(col.comment ?: "Empty comment")
                    .addModifiers(KModifier.OVERRIDE)
                    .build()
            }
        val constructor: FunSpec.Builder = FunSpec.constructorBuilder()
        propSpec
            .forEach { ps ->
                constructor.addParameter(
                    ParameterSpec.builder(ps.name, ps.type)
                        .addKdoc(ps.kdoc)
                        .build()
                )
                classBuilder.addProperty(ps)
            }

        // надо переопределить геттер из интерфейса iEntityOrigin
        val getter = PropertySpec.builder(designEntityNamePropertySpec.name, designEntityNamePropertySpec.type)
            .addKdoc(designEntityNamePropertySpec.kdoc)
            .addModifiers(KModifier.OVERRIDE)
            .getter(
                FunSpec.getterBuilder()
                    .addCode("return %T.%L", designEntityNamePropertySpec.type, metaEntity.designPoetClassName.simpleName)
                    .build()
            )
            .build()

        // добавить в класс конструктор и геттер
        classBuilder
            .primaryConstructor(constructor.build())
            .addProperty(getter)

        // для всех потомков текущего класса рекурсивно вызвать формирование сущностей
        val childrenFiles = aggregateInnerDep.children
            .map { df -> collectEntityFile(metaForeignKeys, df, collector) }
            .flatten()
            .toSet()


        return listOf(fileSpec.addType(classBuilder.build()).build()).plus(childrenFiles)
    }
}