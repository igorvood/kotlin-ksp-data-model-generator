package ru.vood.processor.datamodel.newG.meta

import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.plusParameter
import ru.vood.model.generator.ksp.common.CommonClassNames
import ru.vood.model.generator.ksp.common.CommonClassNames.entityData
import ru.vood.model.generator.ksp.common.CommonClassNames.entityEnum
import ru.vood.model.generator.ksp.common.CommonClassNames.enumMap
import ru.vood.model.generator.ksp.common.CommonClassNames.iEntityData
import ru.vood.model.generator.ksp.common.CommonClassNames.string
import ru.vood.model.generator.ksp.common.KspCommonUtils.generated
import ru.vood.model.generator.ksp.common.dto.PackageName
import ru.vood.model.generator.ksp.common.util.KotlinPoetUtils.controlFlow
import ru.vood.processor.datamodel.abstraction.model.MetaInformation
import ru.vood.processor.datamodel.newG.abstraction.AbstractSingleFileGenerator

class EntityMapGenerator(
    rootPackage: PackageName,
    private val metaInformation: MetaInformation,
) : AbstractSingleFileGenerator(
    rootPackage,
    PackageName("metaEnumP"),//CommonClassNames.subPackageAbstractDataDictionaryGenerator,
    entityEnum
) {

    override fun files(): List<FileSpec> {

        val classBuilder = TypeSpec.enumBuilder(entityEnum)
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
                            .forEach {me ->
                                addStatement(
                                    "%S -> %T.%L",
                                    me.designPoetClassName.simpleName,
                                    entityEnum,
                                    me.designPoetClassName.simpleName
                                )
                            }
                        addStatement("""else -> error(""${'"'}In ${'$'}{EntityEnum::class.java.simpleName} not found enum with name ${'$'}value""${'"'})""")

                    }
                    .build()
            )
            .build()

        val cb = CodeBlock.builder()
         metaInformation.entities.values.forEach {  me ->
             cb.add(CodeBlock.builder().addStatement("%T.%L to %T,\n", entityEnum, me.designPoetClassName.simpleName, entityData).build())
//             cb.indent()

//            cb.addStatement("%T.%L to %T", entityEnum, me.designPoetClassName.simpleName, entityData)
        }
//        cb.
        val entityDataMapPropertySpec =  PropertySpec.builder("entityDataMap", enumMap.plusParameter(entityEnum).plusParameter(iEntityData))
            .addModifiers(KModifier.PRIVATE)
            .initializer(CodeBlock.builder()
                .addStatement(
                    """%T(%T.%L to %T(
                        |designClass = ru.vood.dmgen.datamodel.sealedData.Deal::class, 
                        |runtimeClass = DealEntity::class,
                        |runtimeSyntheticClass = DealDetail::class,
                        |serializer =DealEntity.serializer(),
                        |serializerSynthetic =DealDetail.serializer(),
                        |entityName = EntityEnum.Deal, 
                        |comment ="Это сущность Сделка",
                        |entityType =AGGREGATE
                        |))""".trimMargin(),
                    enumMap,
                    entityEnum,
                    "Deal",
                    entityData
//                    cb.build()
                )
                .build())

//        val entityDataMapPropertySpec =  PropertySpec.builder("entityDataMap", string)
//            .addModifiers(KModifier.PRIVATE)
//            .initializer(CodeBlock.builder().addStatement("%S", "qwe").build())

        companionObjectBuilder
            .addFunction(entityMetaByStrFunSpec)
            .addProperty(entityDataMapPropertySpec.build())

        classBuilder.addType(companionObjectBuilder.build())
        // надо добавить только что сгенерированный класс к его потомкам
        return listOf(fileSpec.addType(classBuilder.build()).build())


    }
}