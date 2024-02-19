package ru.vood.processor.datamodel.generator.meta

import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.plusParameter
import ru.vood.model.generator.ksp.common.CommonClassNames
import ru.vood.model.generator.ksp.common.CommonClassNames.entityEnum
import ru.vood.model.generator.ksp.common.CommonClassNames.enumMap
import ru.vood.model.generator.ksp.common.CommonClassNames.fKMetaData
import ru.vood.model.generator.ksp.common.CommonClassNames.fkPair
import ru.vood.model.generator.ksp.common.CommonClassNames.fullColumnNameEnum
import ru.vood.model.generator.ksp.common.CommonClassNames.iEntityOrigin
import ru.vood.model.generator.ksp.common.CommonClassNames.relationType
import ru.vood.model.generator.ksp.common.CommonClassNames.uniqueKeyEnum
import ru.vood.model.generator.ksp.common.KspCommonUtils.generated
import ru.vood.model.generator.ksp.common.dto.PackageName
import ru.vood.processor.datamodel.abstraction.model.MetaInformation
import ru.vood.processor.datamodel.gen.CollectName
import ru.vood.processor.datamodel.generator.abstraction.AbstractSingleFileGenerator

class ForeignKeyMapGenerator(
    rootPackage: PackageName,
    private val metaInformation: MetaInformation,
) : AbstractSingleFileGenerator(
    rootPackage,
//    PackageName("metaEnumP"),//
    CommonClassNames.subPackageAbstractDataDictionaryGenerator,
    CommonClassNames.fkNameEnum
) {
    override fun files(): List<FileSpec> {
        val classBuilder = TypeSpec.enumBuilder(moduleName)
            .generated(this::class)
            .addAnnotation(CommonClassNames.metaFKs)

        metaInformation.metaForeignKeys
            .map {
                classBuilder.addEnumConstant(it.name.value)
            }

        val typeEnumMap = enumMap.plusParameter(CommonClassNames.fkNameEnum).plusParameter(
            fKMetaData.plusParameter(WildcardTypeName.producerOf(iEntityOrigin))
        )

        val cb = CodeBlock.builder()
            .addStatement("""%T(""", enumMap)
            .indent()
            .addStatement("mapOf(")
            .indent()
            .indent()
            .indent()

        metaInformation.metaForeignKeys
            .sortedBy { it.fromEntity.designPoetClassName }
            .forEach { mf ->
                cb.addStatement(
                    "%T.%L to %T(",
                    CommonClassNames.fkNameEnum,
                    mf.name.value,
                    fKMetaData,
                )
                    .addStatement(
                        "fromEntity = %T.%L,",
                        entityEnum,
                        mf.fromEntity.designPoetClassName.simpleName
                    )
                    .addStatement(
                        "toEntity = %T.%L,",
                        entityEnum,
                        mf.toEntity.designPoetClassName.simpleName
                    )
                    .addStatement(
                        "uk = %T.%L,",
                        uniqueKeyEnum,
                        mf.uk.name.value
                    )
                    .addStatement(
                        "relationType = %T.%L,",
                        relationType,
                        mf.relationType.name
                    )
                cb.addStatement(
                    "fkCols = setOf(",
                )

                mf.fkCols
                    .forEach { fcol ->
                        cb.addStatement(
                            "%T(%T.%L_%L, %T.%L_%L),",
                            fkPair,
                            fullColumnNameEnum,
                            mf.fromEntity.designPoetClassName.simpleName,
                            fcol.from.name.value,
                            fullColumnNameEnum,
                            mf.toEntity.designPoetClassName.simpleName,
                            fcol.to.name.value
                        )
                    }

                cb.addStatement("),")
                cb.addStatement(
                    "сontextExtractor = {data: %T -> %T(",
                    CollectName.entityClassName(mf.fromEntity.designPoetClassName),
                    CollectName.ukClassName(mf.toEntity.designPoetClassName, mf.uk.name)
                )

                mf.fkCols.forEach { fkCol ->
                    cb.addStatement(
                        "data.%L,",
                        fkCol.from.name.value
                    )

                }

                cb.addStatement(") }")
                    .addStatement("),")

            }

        cb.addStatement(""")""")
        cb.addStatement(""")""")

        val columnEntityDataMapPropertySpec =
            PropertySpec.builder("foreignKeyMap", typeEnumMap)
//                .addModifiers(KModifier.PRIVATE)
                .initializer(cb.build())
                .build()


        val companionObjectBuilder = TypeSpec.companionObjectBuilder()
            .addProperty(columnEntityDataMapPropertySpec)
            .addProperty(fromToFkMapPropertySpec())
            .addProperty(foreignKeyMapFromEntityPropertySpec())
            .addFunction(getFkPropertySpec())
            .build()


        classBuilder
            .addType(companionObjectBuilder)

        // надо добавить только что сгенерированный класс к его потомкам
        return listOf(fileSpec.addType(classBuilder.build()).build())

    }

    private fun fromToFkMapPropertySpec(): PropertySpec {
        val cbFromToFkMap = CodeBlock.builder()
            .addStatement("%T(", enumMap)
            .addStatement(
                """foreignKeyMap.values
                    .map { fk ->
                        fk.fromEntity to %T(foreignKeyMap.values.filter { it.fromEntity == fk.fromEntity }
                            .map { fk2 -> fk2.toEntity to fk2 }.toMap())
                    }.toMap()""", enumMap
            )
            .addStatement(")")

        val typeEnumMapfromToFkMap = enumMap.plusParameter(entityEnum).plusParameter(
            enumMap.plusParameter(entityEnum)
                .plusParameter(fKMetaData.plusParameter(WildcardTypeName.producerOf(iEntityOrigin)))
        )

        val fromToFkMapPropertySpec =
            PropertySpec.builder("fromToFkMap", typeEnumMapfromToFkMap)
                .addKdoc("В качестве ключа первой мапки выступает идентификатор сущности от которой идет FK. В качестве ключа второй, вложенной мапки, выступает идентификатор сущности в которую идет FK")
                .addModifiers(KModifier.PUBLIC)
                .initializer(cbFromToFkMap.build())
                .build()
        return fromToFkMapPropertySpec
    }

    private fun foreignKeyMapFromEntityPropertySpec(): PropertySpec {
        val cbFromToFkMap = CodeBlock.builder()
            .addStatement("%T(", enumMap)
            .addStatement(
                """foreignKeyMap.values
        .map {fkMetaData->
            fkMetaData.fromEntity to fkMetaData
        }
        .groupBy { it.first }
        .map { it.key to it.value.map { q -> q.second }.toSet() }
        .toMap()"""
            )
            .addStatement(")")
//        EnumMap<EntityEnum, Set<FKMetaData<out IEntityOrigin>>>
        val typeEnumMapfromToFkMap = enumMap.plusParameter(entityEnum).plusParameter(
            CommonClassNames.set.plusParameter(fKMetaData.plusParameter(WildcardTypeName.producerOf(iEntityOrigin)))

        )

        val fromToFkMapPropertySpec =
            PropertySpec.builder("foreignKeyMapFromEntity", typeEnumMapfromToFkMap)
                .addModifiers(KModifier.PUBLIC)
                .initializer(cbFromToFkMap.build())
                .build()
        return fromToFkMapPropertySpec
    }

    private fun getFkPropertySpec(): FunSpec {
        val cbFromToFkMap = CodeBlock.builder()
            .addStatement(
                """return (fromToFkMap[fromEntity] ?: 
                |error(""${'"'}Not found any foreign key from entity ${'$'}fromEntity""${'"'}))[toEntity]?: 
                |error(""${'"'}Not found any foreign key from entity ${'$'}fromEntity to entity ${'$'}toEntity""${'"'})""".trimMargin()
            )

        val fromToFkMapPropertySpec =
            FunSpec.builder("getFk")
                .addModifiers(KModifier.PUBLIC)
                .addParameter(ParameterSpec("fromEntity", entityEnum))
                .addParameter(ParameterSpec("toEntity", entityEnum))
                .addCode(cbFromToFkMap.build())
                .build()
        return fromToFkMapPropertySpec
    }
}