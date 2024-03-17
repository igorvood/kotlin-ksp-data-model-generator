package ru.vood.processor.datamodel.generator.common

import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.plusParameter
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.TypeSpec
import com.squareup.kotlinpoet.WildcardTypeName
import ru.vood.model.generator.ksp.common.CommonClassNames.any
import ru.vood.model.generator.ksp.common.CommonClassNames.entityEnum
import ru.vood.model.generator.ksp.common.CommonClassNames.flowEntityType
import ru.vood.model.generator.ksp.common.CommonClassNames.iEntityData
import ru.vood.model.generator.ksp.common.CommonClassNames.iEntityDetail
import ru.vood.model.generator.ksp.common.CommonClassNames.iEntityOrigin
import ru.vood.model.generator.ksp.common.CommonClassNames.kClass
import ru.vood.model.generator.ksp.common.CommonClassNames.kSerializer
import ru.vood.model.generator.ksp.common.CommonClassNames.string
import ru.vood.model.generator.ksp.common.dto.PackageName
import ru.vood.processor.datamodel.generator.abstraction.AbstractIntfSingleFileGenerator

class IEntityDataSingleFileGenerator(rootPackage: PackageName) : AbstractIntfSingleFileGenerator(
    rootPackage = rootPackage,
    moduleName = iEntityData,
    kModifier = KModifier.SEALED
) {
    override fun fillInterfaceBuilder(classBuilder: TypeSpec.Builder): TypeSpec.Builder {
        return classBuilder.addKdoc("Мета данные по сущности")
            .addProperties(iEntityDataGeneratorPropertySpec)
    }


    companion object {
        private val designClass = PropertySpec.builder(
            name = "designClass",
            type = kClass.plusParameter(WildcardTypeName.producerOf(any))
        )
            .addKdoc("интрефейс описывающий структуру сущности")
            .build()
        private val runtimeClass = PropertySpec.builder(
            name = "runtimeClass",
            type = kClass.plusParameter(WildcardTypeName.producerOf(iEntityOrigin))
        )
            .addKdoc("класс описывающий сущность")
            .build()

        private val runtimeSyntheticClass = PropertySpec.builder(
            name = "runtimeSyntheticClass",
            type = kClass.plusParameter(WildcardTypeName.producerOf(iEntityDetail.plusParameter(WildcardTypeName.producerOf(
                iEntityOrigin))))
        )
            .addKdoc("синтетический класс описывающий сущность, включает в себя все сущности, которорые имею форен на текущую")
            .build()


        private val serializer = PropertySpec.builder(
            name = "serializer",
            type = kSerializer.plusParameter(WildcardTypeName.producerOf(iEntityOrigin))
        )
            .addKdoc("сериализатор оригинальной сущности")
            .build()

        private val entityName = PropertySpec.builder(
            name = "entityName",
            type = entityEnum
        )
            .addKdoc("Имя сущности")
            .build()

        private val comment = PropertySpec.builder(
            name = "comment",
            type = string
        )
            .addKdoc("коментарий сущности")
            .build()

        private val entityType = PropertySpec.builder(
            name = "entityType",
            type = flowEntityType
        )
            .addKdoc("тип сущности")
            .build()

        private val serializerSynthetic = PropertySpec.builder(
            name = "serializerSynthetic",
            type = kSerializer.plusParameter(
                WildcardTypeName.producerOf(
                    iEntityDetail.plusParameter(
                        WildcardTypeName.producerOf(
                            iEntityOrigin
                        )
                    )
                )
            )
        )
            .addKdoc("сериализатор синтетической сущности")
            .build()

        val iEntityDataGeneratorPropertySpec =
            listOf(
                designClass,
                runtimeClass,
                runtimeSyntheticClass,
                serializer,
                serializerSynthetic,
                entityName,
                comment,
                entityType
            )
    }

}