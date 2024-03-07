package ru.vood.processor.datamodel.generator.meta

import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.plusParameter
import ru.vood.model.generator.ksp.common.CommonClassNames
import ru.vood.model.generator.ksp.common.CommonClassNames.entityEnum
import ru.vood.model.generator.ksp.common.CommonClassNames.enumMap
import ru.vood.model.generator.ksp.common.CommonClassNames.iEntityOrigin
import ru.vood.model.generator.ksp.common.CommonClassNames.simpleColumnName
import ru.vood.model.generator.ksp.common.CommonClassNames.typeUk
import ru.vood.model.generator.ksp.common.CommonClassNames.uKEntityData
import ru.vood.model.generator.ksp.common.CommonClassNames.uniqueKeyEnum
import ru.vood.model.generator.ksp.common.KspCommonUtils.generated
import ru.vood.model.generator.ksp.common.dto.PackageName
import ru.vood.processor.datamodel.abstraction.model.MetaInformation
import ru.vood.processor.datamodel.gen.CollectName.entityClassName
import ru.vood.processor.datamodel.gen.CollectName.ukClassName
import ru.vood.processor.datamodel.generator.abstraction.AbstractSingleFileGenerator

class UniqueKeyMapGenerator(
    rootPackage: PackageName,
    private val metaInformation: MetaInformation,
) : AbstractSingleFileGenerator(
    rootPackage,
//    PackageName("metaEnumP"),//
    CommonClassNames.subPackageAbstractDataDictionaryGenerator,
    uniqueKeyEnum
) {

    override fun files(): List<FileSpec> {

        val classBuilder = TypeSpec.enumBuilder(moduleName)
            .generated(this::class)
            .addAnnotation(CommonClassNames.metaUKs)

        val cb = CodeBlock.builder()
            .addStatement("%T(", enumMap)
            .addStatement("mapOf(")

        metaInformation.entities.values
            .forEach { metaEnt ->
                metaEnt.uniqueKeysFields.keys
                    .forEach { ukDto ->
                        classBuilder.addEnumConstant(ukDto.name.value)

                        cb.addStatement(
                            "%L to %T(",
                            ukDto.name.value,
                            uKEntityData
                        )
                            .addStatement(
                                "ukName = %L,",
                                ukDto.name.value,
                            )

                        cb.addStatement("columns = listOf(")
                        ukDto.cols.forEach {
                            cb.addStatement("""%T(%S),""", simpleColumnName, it.value)
                        }
                        cb.addStatement("),")

                        cb.addStatement(
                            "serializer = %T.serializer(),",
                            ukClassName(metaEnt.designPoetClassName, ukDto.name)
                        )
                            .addStatement(
                                "ukClass = %T::class,",
                                ukClassName(metaEnt.designPoetClassName, ukDto.name)
                            )
                            .addStatement(
                                "entity = %T.%L,",
                                entityEnum,
                                metaEnt.designPoetClassName.simpleName
                            )

                        cb.addStatement(
                            "extractContext = {data: %T -> %T(",
                            entityClassName(metaEnt.designPoetClassName),
                            ukClassName(metaEnt.designPoetClassName, ukDto.name)
                        )

                        ukDto.cols.sortedBy { it.value }
                            .forEach {
                                cb.addStatement("data.%L,", it.value)
                            }

                        cb
                            .addStatement(")")
                            .addStatement("},")

                        cb.addStatement("typeUk = %T.%L", typeUk, ukDto.typeUk.name)
                        cb.addStatement("),")

                    }
            }

        cb.addStatement(")")
            .addStatement(")")

        val typeEnumMap = enumMap.plusParameter(uniqueKeyEnum).plusParameter(
            uKEntityData.plusParameter(WildcardTypeName.producerOf(iEntityOrigin))
        )

        val uniqueKeyMapPropertySpec = PropertySpec.builder("uniqueKeyMap", typeEnumMap)
            .initializer(cb.build())
            .build()
        val companionObjectBuilder = TypeSpec.companionObjectBuilder()
            .addProperty(
                uniqueKeyMapPropertySpec
            )
            .build()

        classBuilder
            .addType(companionObjectBuilder)
            .addFunction(
                FunSpec.builder("ukData")
                    .returns(CommonClassNames.uKEntityData.plusParameter(WildcardTypeName.producerOf(iEntityOrigin)))
                    .addCode(
                        CodeBlock.builder()
                            .addStatement("return %L[this]!!", uniqueKeyMapPropertySpec.name)
                            .build()
                    )
                    .build()
            )

        // надо добавить только что сгенерированный класс к его потомкам
        return listOf(fileSpec.addType(classBuilder.build()).build())
    }
}