package ru.vood.processor.datamodel.newG

import com.google.devtools.ksp.processing.KSPLogger
import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.plusParameter
import ru.vood.dmgen.annotation.FlowEntityType
import ru.vood.dmgen.dto.RelationType
import ru.vood.model.generator.ksp.common.CommonClassNames
import ru.vood.model.generator.ksp.common.CommonClassNames.entityEnum
import ru.vood.model.generator.ksp.common.KspCommonUtils.generated
import ru.vood.model.generator.ksp.common.util.KotlinPoetUtils.controlFlow
import ru.vood.processor.datamodel.abstraction.model.Dependency
import ru.vood.processor.datamodel.abstraction.model.MetaForeignKey
import ru.vood.processor.datamodel.abstraction.model.MetaInformation
import ru.vood.processor.datamodel.abstraction.model.dto.SyntheticFieldInfo
import ru.vood.processor.datamodel.gen.CollectName
import ru.vood.processor.datamodel.gen.CollectName.syntheticClassName
import ru.vood.processor.datamodel.newG.abstraction.AbstractGenerator
import ru.vood.processor.datamodel.newG.common.IEntityDetailSingleFileGenerator.Companion.originPropertySpec
import ru.vood.processor.datamodel.newG.common.IEntityDetailSingleFileGenerator.Companion.syntheticFieldMandatoryFunSpec
import ru.vood.processor.datamodel.newG.common.IEntityDetailSingleFileGenerator.Companion.syntheticFieldOptionalFunSpec
import ru.vood.processor.datamodel.newG.common.IEntityDetailSingleFileGenerator.Companion.syntheticFieldSetFunSpec

class SyntheticEntityGenerator(
    private val metaInfo: MetaInformation,
    private val kspLogger: KSPLogger,
) : AbstractGenerator() {
    override fun files(): List<FileSpec> {
        return collectEntityFile(metaInfo.metaForeignKeys, metaInfo.aggregateInnerDep)
    }

    private fun collectEntityFile(
        metaForeignKeys: Set<MetaForeignKey>,
        aggregateInnerDep: Dependency,
        collector: Set<FileSpec> = setOf(),
    ): List<FileSpec> {
        val metaEntity = aggregateInnerDep.metaEntity

        val syntheticFieldInfos = aggregateInnerDep.childrenSyntheticFieldsInfo.filterIsInstance<SyntheticFieldInfo>()


        // Имя создаваемого класса
        val classNameStr = syntheticClassName(metaEntity.designPoetClassName)

        //Создам Файл для класса
        val fileSpec = FileSpec.builder(
            packageName = metaEntity.designPoetClassName.packageName,
            fileName = classNameStr.simpleName// + "Temp"
        )

        // Создам класс, что будет описываться в файле
        val entityClassName = CollectName.entityClassName(metaEntity.designPoetClassName)
        val classBuilder = TypeSpec.classBuilder(
            classNameStr.simpleName// + "Temp"
        )
            .generated(this::class)
            .addAnnotation(CommonClassNames.serializable)
            .addAnnotation(CommonClassNames.modelEntityDetail)
            .addKdoc(metaEntity.comment)
            .addModifiers(KModifier.DATA)
            .addSuperinterface(CommonClassNames.iEntityDetail.plusParameter(entityClassName))


        //поместить все проперти из наследуемого интерфеса (его имя тут хранится metaEntity.designPoetClassName) в дефолтный конструктор
        val propSpec = listOf(originPropertySpec)
            .map { col ->
                PropertySpec.builder(col.name, entityClassName)
                    .initializer("%N", col.name)
                    .addKdoc(col.kdoc.toBuilder().build())
                    .addModifiers(KModifier.OVERRIDE)
                    .mutable(false)
                    .build()
            }

        val syntheticFieldOptionalFunSpecOverrideBuilder = whenCodeGen(
            errText = """Not found optional synthetic field for entity""",
            syntheticFieldInfos,
            RelationType.ONE_TO_ONE_OPTIONAL
        )


        val syntheticFieldMandatoryFunSpecOverrideBuilder =
            whenCodeGen(
                errText = """Not found mandatory synthetic field for entity""",
                syntheticFieldInfos = syntheticFieldInfos,
                oneToOneOptional = RelationType.ONE_TO_ONE_MANDATORY
            )


        val syntheticFieldSetFunSpecOverrideBuilder =
            whenCodeGen(
                errText = """Not found mandatory Set synthetic field for entity""",
                syntheticFieldInfos = syntheticFieldInfos,
                oneToOneOptional = RelationType.MANY_TO_ONE
            )

        val syntheticFieldOptionalFunSpecOverride = overrideFunBuilder(syntheticFieldOptionalFunSpec)
            .addCode(syntheticFieldOptionalFunSpecOverrideBuilder.build())
            .build()
        val syntheticFieldMandatoryFunSpecFunSpecOverride = overrideFunBuilder(syntheticFieldMandatoryFunSpec)
            .addCode(syntheticFieldMandatoryFunSpecOverrideBuilder.build())
            .build()
        val syntheticFieldSetFunSpecFunSpecFunSpecOverride = overrideFunBuilder(syntheticFieldSetFunSpec)
            .addCode(syntheticFieldSetFunSpecOverrideBuilder.build())
            .build()

        //надо добавить все свойства в конструктор
        val constructor: FunSpec.Builder = FunSpec.constructorBuilder()


        val propertySpecs = when (metaEntity.flowEntityType) {
            FlowEntityType.INNER, FlowEntityType.AGGREGATE -> syntheticFieldInfos
                .map { syntheticFieldInfo ->
                    val type = when (syntheticFieldInfo.relationType) {
                        RelationType.MANY_TO_ONE -> SET.plusParameter(syntheticClassName(syntheticFieldInfo.metaEntity.designPoetClassName))
                        RelationType.ONE_TO_ONE_OPTIONAL -> syntheticClassName(syntheticFieldInfo.metaEntity.designPoetClassName).copy(
                            nullable = true
                        )
                        RelationType.ONE_TO_ONE_MANDATORY -> syntheticClassName(syntheticFieldInfo.metaEntity.designPoetClassName)
                    }

                    PropertySpec.builder(
                        syntheticFieldInfo.metaEntity.entityFieldName,
                        type
                    )
                        .initializer("%N", syntheticFieldInfo.metaEntity.entityFieldName)
                        .addKdoc(syntheticFieldInfo.metaEntity.comment)
                        .build()
                }


            FlowEntityType.ONE_OF ->
                syntheticFieldInfos
                    .map { syntheticFieldInfo ->
                        PropertySpec.builder(
                            syntheticFieldInfo.metaEntity.entityFieldName,
                            syntheticFieldInfo.metaEntity.designPoetClassName
                        )
                            .build()
                    }


        }

        // надо переопределить геттер из интерфейса iEntityOrigin
        val designPoetClassNameGetter = OriginEntityDataClassesGenerator.designEntityNamePropertySpec(metaEntity)


        propSpec.plus(propertySpecs)
            .forEach { ps ->
                val parameterSpec = ParameterSpec.builder(ps.name, ps.type)
                    .addKdoc(ps.kdoc)
                // надо добавить параметры в конструктор
                constructor.addParameter(
                    parameterSpec.build()
                )
                // и также надо добавить эти же св-ва в класс
                classBuilder.addProperty(ps)
            }

        // добавить в класс конструктор и геттер
        classBuilder
            .primaryConstructor(constructor.build())
            .addFunction(syntheticFieldOptionalFunSpecOverride)
            .addFunction(syntheticFieldMandatoryFunSpecFunSpecOverride)
            .addFunction(syntheticFieldSetFunSpecFunSpecFunSpecOverride)
            .addProperty(designPoetClassNameGetter)

        // для всех потомков текущего класса рекурсивно вызвать формирование сущностей
        val childrenFiles = aggregateInnerDep.children
            .map { df -> collectEntityFile(metaForeignKeys, df, collector) }
            .flatten()
            .toSet()
        // надо добавить только что сгенерированный класс к его потомкам
        return listOf(
            fileSpec
                .addType(classBuilder.build())
                .build()
        )
            .plus(childrenFiles)

    }

    private fun whenCodeGen(
        errText: String,
        syntheticFieldInfos: List<SyntheticFieldInfo>,
        oneToOneOptional: RelationType,
    ): CodeBlock.Builder {
        val filter = syntheticFieldInfos
            .filter {
                it.relationType == oneToOneOptional
            }
        return CodeBlock.builder()
            .controlFlow("return when(entityName)") {
                filter.forEach { syntheticFieldInfo ->
                    when (oneToOneOptional) {
                        RelationType.ONE_TO_ONE_OPTIONAL, RelationType.ONE_TO_ONE_MANDATORY, RelationType.MANY_TO_ONE ->
                            addStatement(
                                "%T.%L -> %L",
                                entityEnum,
                                syntheticFieldInfo.metaEntity.designPoetClassName.simpleName,
                                syntheticFieldInfo.metaEntity.entityFieldName
                            )
                    }
                }
                addStatement("""else -> error(""${'"'}In Entity ${'$'}{designEntityName} $errText ${'$'}{entityName}""${'"'})""")

            }
    }

    private fun overrideFunBuilder(syntheticFieldOptionalFunSpec1: FunSpec) =
        FunSpec.builder(syntheticFieldOptionalFunSpec1.name)
            .addKdoc(syntheticFieldOptionalFunSpec1.kdoc)
            .addParameters(syntheticFieldOptionalFunSpec1.parameters)
            .returns(syntheticFieldOptionalFunSpec1.returnType!!)
            .addModifiers(KModifier.OVERRIDE)

}