package ru.vood.processor.datamodel.generator.meta

import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.plusParameter
import ru.vood.dmgen.annotation.FlowEntityType
import ru.vood.model.generator.ksp.common.CommonClassNames
import ru.vood.model.generator.ksp.common.CommonClassNames.entityData
import ru.vood.model.generator.ksp.common.CommonClassNames.entityEnum
import ru.vood.model.generator.ksp.common.CommonClassNames.enumMap
import ru.vood.model.generator.ksp.common.CommonClassNames.flowEntityType
import ru.vood.model.generator.ksp.common.CommonClassNames.iEntityData
import ru.vood.model.generator.ksp.common.CommonClassNames.sealedEntityData
import ru.vood.model.generator.ksp.common.CommonClassNames.string
import ru.vood.model.generator.ksp.common.KspCommonUtils.generated
import ru.vood.model.generator.ksp.common.dto.PackageName
import ru.vood.model.generator.ksp.common.util.KotlinPoetUtils.controlFlow
import ru.vood.processor.datamodel.abstraction.model.MetaInformation
import ru.vood.processor.datamodel.gen.CollectName.entityClassName
import ru.vood.processor.datamodel.gen.CollectName.syntheticClassName
import ru.vood.processor.datamodel.generator.abstraction.AbstractSingleFileGenerator

class EntityMapGenerator(
    rootPackage: PackageName,
    private val metaInformation: MetaInformation,
) : AbstractSingleFileGenerator(
    rootPackage,
//    PackageName("metaEnumP"),//
    CommonClassNames.subPackageAbstractDataDictionaryGenerator,
    entityEnum
) {

    override fun files(): List<FileSpec> {

        val classBuilder = TypeSpec.enumBuilder(moduleName)
            .generated(this::class)
            .addAnnotation(CommonClassNames.metaEntities)

        metaInformation.entities.values
            .sortedBy { it.designPoetClassName.simpleName }
            .forEach {
                classBuilder.addEnumConstant(it.designPoetClassName.simpleName)
            }


        val companionObjectBuilder = TypeSpec.companionObjectBuilder()
        val entityMetaByStrFunSpec = FunSpec.builder("entityMetaByStr")
            .returns(entityEnum)
            .addParameter(ParameterSpec("value", string))
            .addCode(
                CodeBlock.builder()
                    .controlFlow("return when(value)") {
                        metaInformation.entities.values
                            .forEach { me ->
                                addStatement(
                                    "%S -> %L",
                                    me.designPoetClassName.simpleName,
                                    me.designPoetClassName.simpleName
                                )
                            }
                        addStatement("""else -> error(""${'"'}In ${'$'}{EntityEnum::class.java.simpleName} not found enum with name ${'$'}value""${'"'})""")

                    }
                    .build()
            )
            .build()

        val cb = CodeBlock.builder()
            .addStatement("""%T(""", enumMap)
            .indent()
            .addStatement("mapOf(")
            .indent()
            .indent()
            .indent()
        metaInformation.entities.values.forEach { me ->
            when (me.flowEntityType) {
                FlowEntityType.ONE_OF -> {
                    val distinct = metaInformation.metaForeignKeys
                        .filter { fk -> fk.toEntity.designClassFullClassName == me.designClassFullClassName }
                        .map { fk -> fk.fromEntity.designPoetClassName }
                        .toSet()

                    cb.addStatement(
                        """%L to %T(""",
                        me.designPoetClassName.simpleName,
                        sealedEntityData,
                    )
                        .addStatement(
                            """designClass = %T::class,""",
                            me.designPoetClassName,
                        )
                        .addStatement(
                            """runtimeClass = %T::class,""", entityClassName(me.designPoetClassName),
                        )
                        .addStatement(
                            """runtimeSyntheticClass = %T::class,""", syntheticClassName(me.designPoetClassName),
                        )
                        .addStatement(
                            """serializer = %T.serializer(),""", entityClassName(me.designPoetClassName),
                        )
                        .addStatement(
                            """serializerSynthetic = %T.serializer(),""", syntheticClassName(me.designPoetClassName),
                        )
                        .addStatement(
                            """entityName = %L,""",
                            me.designPoetClassName.simpleName,
                        )
                        .addStatement(
                            """comment = %S,""", me.comment,
                        )
                        .addStatement(
                            """entityType = %T.%L,""",
                            flowEntityType,
                            me.flowEntityType.name,
                        )
                        .addStatement(
                            """children = setOf("""
                        )
                    cb
                        .indent()
                        .indent()
                        .indent()
                    distinct.forEach { cn ->
                        cb.addStatement("%L,", cn.simpleName)
                    }
                    cb.unindent()
                        .unindent()
                        .unindent()
                        .addStatement(")")
                        .addStatement("),")
                }
                FlowEntityType.INNER, FlowEntityType.AGGREGATE -> {
                    cb.addStatement(
                        """%L to %T(
                 |designClass = %T::class,
                 |runtimeClass = %T::class,
                 |runtimeSyntheticClass = %T::class,
                 |serializer = %T.serializer(),
                 |serializerSynthetic = %T.serializer(),
                 |entityName = %L,
                 |comment = %S,
                 |entityType = %T.%L
                 |),""".trimMargin(),
                        me.designPoetClassName.simpleName,
                        entityData,
                        me.designPoetClassName,
                        entityClassName(me.designPoetClassName),
                        syntheticClassName(me.designPoetClassName),
                        entityClassName(me.designPoetClassName),
                        syntheticClassName(me.designPoetClassName),
                        me.designPoetClassName.simpleName,
                        me.comment,
                        flowEntityType,
                        me.flowEntityType.name,
                    )
                }
            }
        }
        cb.add(""")""")
        cb.add(""")""")
        val typeEnumMap = enumMap.plusParameter(entityEnum).plusParameter(iEntityData)
        val entityDataMapPropertySpec =
            PropertySpec.builder("entityDataMap", typeEnumMap)
                .addModifiers(KModifier.PRIVATE)
                .initializer(cb.build())
                .build()
        companionObjectBuilder
            .addFunction(entityMetaByStrFunSpec)
            .addProperty(entityDataMapPropertySpec)

        classBuilder
            .addType(companionObjectBuilder.build())
            .addFunction(
                FunSpec.builder("entityData")
                    .returns(iEntityData)
                    .addCode(
                        CodeBlock.builder()
                            .addStatement("return %L[this]!!", entityDataMapPropertySpec.name)
                            .build()
                    )
                    .build()
            )
        // надо добавить только что сгенерированный класс к его потомкам
        return listOf(fileSpec.addType(classBuilder.build()).build())


    }
}