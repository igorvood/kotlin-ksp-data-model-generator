package ru.vood.processor.datamodel.newG.meta

import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.plusParameter
import ru.vood.dmgen.annotation.FlowEntityType
import ru.vood.dmgen.dto.RelationType
import ru.vood.model.generator.ksp.common.CommonClassNames
import ru.vood.model.generator.ksp.common.CommonClassNames.entityEnum
import ru.vood.model.generator.ksp.common.CommonClassNames.fullColumnNameEnum
import ru.vood.model.generator.ksp.common.CommonClassNames.simpleColExtractFunction
import ru.vood.model.generator.ksp.common.CommonClassNames.simpleColumnEntityData
import ru.vood.model.generator.ksp.common.CommonClassNames.simpleColumnName
import ru.vood.model.generator.ksp.common.CommonClassNames.simpleColumnType
import ru.vood.model.generator.ksp.common.CommonClassNames.synthetic
import ru.vood.model.generator.ksp.common.CommonClassNames.syntheticColumnEntityData
import ru.vood.model.generator.ksp.common.CommonClassNames.syntheticSet
import ru.vood.model.generator.ksp.common.KspCommonUtils.generated
import ru.vood.model.generator.ksp.common.dto.PackageName
import ru.vood.processor.datamodel.abstraction.model.MetaInformation
import ru.vood.processor.datamodel.abstraction.model.dto.SyntheticFieldInfo
import ru.vood.processor.datamodel.gen.CollectName.entityClassName
import ru.vood.processor.datamodel.gen.CollectName.syntheticClassName
import ru.vood.processor.datamodel.gen.syntheticFieldInfos
import ru.vood.processor.datamodel.newG.abstraction.AbstractSingleFileGenerator

class ColumnEntityMapGenerator(
    rootPackage: PackageName,
    private val metaInformation: MetaInformation,
) : AbstractSingleFileGenerator(
    rootPackage,
//    PackageName("metaEnumP"),//
    CommonClassNames.subPackageAbstractDataDictionaryGenerator,
    fullColumnNameEnum
) {

    override fun files(): List<FileSpec> {
        val classBuilder = TypeSpec.enumBuilder(moduleName)
            .generated(this::class)
            .addAnnotation(CommonClassNames.metaColumns)

        val cb = CodeBlock.builder()
            .addStatement("""%T(""", CommonClassNames.enumMap)
            .indent()
            .addStatement("mapOf(")
            .indent()
            .indent()
            .indent()


        val addEnumConstants = metaInformation.entities.values
            .sortedBy { it.designPoetClassName.simpleName }
            .flatMap { me ->
                val sortedBy = me.fields.sortedBy { ec -> ec.position }
                val simpleCols = sortedBy.map { col -> me to col.name.value }
                val filter = metaInformation.metaForeignKeys
                    .filter { fk -> fk.fromEntity.flowEntityType != FlowEntityType.AGGREGATE }
                    .filter { fk -> fk.toEntity == me }
                    .map { it.fromEntity }

                sortedBy.forEach { mcol ->
                    cb.addStatement(
                        "%T.%L_%L to %T(",
                        fullColumnNameEnum,
                        me.designPoetClassName.simpleName,
                        mcol.name.value,
                        simpleColumnEntityData,
                    )
                        .indent()
                        .indent()
                        .addStatement(
                            "entity = %T.%L,",
                            entityEnum,
                            me.designPoetClassName.simpleName,
                        )
                        .addStatement(
                            "simpleColumnName = %T(%S),",
                            simpleColumnName,
                            mcol.name.value,
                        )
                        .addStatement(
                            "isOptional = %L,",
                            mcol.isNullable,
                        )
                        .addStatement(
                            "comment = %S,",
                            mcol.comment,
                        )
                        .addStatement(
                            "iColExtractFunction = %T<%T, %T> { it.%L },",
                            simpleColExtractFunction,
                            me.designPoetClassName,
                            mcol.typePoetClassName,
                            mcol.name.value,
                        )
                        .addStatement(
                            """simpleColumnType = %T(%S)),""",
                            simpleColumnType,
                            mcol.typePoetClassName,
                        )
                        .unindent()
                        .unindent()

                }

                val syntheticFieldInfos = syntheticFieldInfos(filter, metaInformation.metaForeignKeys, me)
                    .filterIsInstance<SyntheticFieldInfo>()
                    .map {
                        cb.addStatement(
                            "%T.%L_%L to %T(",
                            fullColumnNameEnum,
                            me.designPoetClassName.simpleName,
                            it.metaEntity.entityFieldName,
                            syntheticColumnEntityData,
                        )
                            .addStatement(
                                "entity = %T.%L,",
                                entityEnum,
                                me.designPoetClassName.simpleName,
                            )
                            .addStatement(
                                "outEntity = %T.%L,",
                                entityEnum,
                                it.metaEntity.designPoetClassName.simpleName,
                            )
                            .addStatement(
                                "simpleColumnName = %T(%S),",
                                simpleColumnName,
                                it.metaEntity.entityFieldName,
                            )
                            .addStatement(
                                "isOptional = %L,",
                                it.relationType == RelationType.ONE_TO_ONE_OPTIONAL,
                            )
                            .addStatement("""comment = %S,""", it.metaEntity.comment)

                        when (it.relationType) {
                            RelationType.ONE_TO_ONE_MANDATORY ->
                                cb.addStatement(
                                    "iColExtractFunction = %T<%T, %T, %T> {setOf(it.%L)},",
                                    synthetic,
                                    entityClassName(me.designPoetClassName),
                                    syntheticClassName(me.designPoetClassName),
                                    entityClassName(it.metaEntity.designPoetClassName),
                                    it.metaEntity.entityFieldName
                                )
                            RelationType.ONE_TO_ONE_OPTIONAL ->
                                cb.addStatement(
                                    "iColExtractFunction = %T<%T, %T, %T>{it.%L?.let{q->setOf(q)}?:setOf()},",
                                    synthetic,
                                    entityClassName(me.designPoetClassName),
                                    syntheticClassName(me.designPoetClassName),
                                    entityClassName(it.metaEntity.designPoetClassName),
                                    it.metaEntity.entityFieldName
                                )
                            RelationType.MANY_TO_ONE -> cb.addStatement(
                                "iColExtractFunction = %T<%T, %T, %T>{it.%L},",
                                syntheticSet,
                                entityClassName(me.designPoetClassName),
                                syntheticClassName(me.designPoetClassName),
                                entityClassName(it.metaEntity.designPoetClassName),
                                it.metaEntity.entityFieldName

                            )
                        }
                        cb.addStatement("""),""")

                        me to it.metaEntity.entityFieldName
                    }


                simpleCols.plus(syntheticFieldInfos)
            }

        addEnumConstants
            .forEach {
                classBuilder.addEnumConstant("${it.first.designPoetClassName.simpleName}_${it.second}")
            }


        val typeEnumMap = CommonClassNames.enumMap.plusParameter(fullColumnNameEnum).plusParameter(
            CommonClassNames.columnEntityData
        )



        cb.addStatement(""")""")
        cb.addStatement(""")""")

        val columnEntityDataMapPropertySpec =
            PropertySpec.builder("columnEntityDataMap", typeEnumMap)
                .addModifiers(KModifier.PRIVATE)
                .initializer(cb.build())
                .build()

        val companionObjectBuilder = TypeSpec.companionObjectBuilder()
            .addProperty(columnEntityDataMapPropertySpec)
            .build()

        classBuilder
            .addType(companionObjectBuilder)
            .addFunction(
                FunSpec.builder("columnData")
//                    .returns(CommonClassNames.iEntityData)
                    .addCode(
                        CodeBlock.builder()
                            .addStatement("return %L[this]!!", columnEntityDataMapPropertySpec.name)
                            .build()
                    )
                    .build()
            )
        // надо добавить только что сгенерированный класс к его потомкам
        return listOf(fileSpec.addType(classBuilder.build()).build())

    }
}