package ru.vood.processor.datamodel.newG.common

import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.plusParameter
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.SET
import com.squareup.kotlinpoet.TypeSpec
import ru.vood.model.generator.ksp.common.CommonClassNames
import ru.vood.model.generator.ksp.common.CommonClassNames.entityEnum
import ru.vood.model.generator.ksp.common.CommonClassNames.fKMetaData
import ru.vood.model.generator.ksp.common.CommonClassNames.typeVariableFConOfIEntityOrigin
import ru.vood.model.generator.ksp.common.CommonClassNames.uniqueKeyEnum
import ru.vood.model.generator.ksp.common.dto.PackageName
import ru.vood.processor.datamodel.newG.abstraction.AbstractDataClassGenerator
import ru.vood.processor.datamodel.newG.abstraction.propertyInConstructor

class FKMetaDataGenerator(rootPackage: PackageName) : AbstractDataClassGenerator(
    rootPackage = rootPackage,
    moduleName = fKMetaData,
) {
    override fun fillInterfaceBuilder(classBuilder: TypeSpec.Builder): TypeSpec.Builder {
        val constructor: FunSpec.Builder = FunSpec.constructorBuilder()

        propertyInConstructor(
            classBuilder,
            constructor,
            fkPairGeneratorPropertySpecCons
        )

        return classBuilder
            .addTypeVariable(CommonClassNames.typeVariableIEntityOrigin)
            .primaryConstructor(constructor.build())
            .addKdoc("Мета данные по внешнему ключу")

    }


    companion object {
        private val fromEntity = PropertySpec.builder(
            name = "fromEntity",
            type = entityEnum
        )
            .addKdoc("Сущность из которой идет внешний ключ")
            .build()

        private val toEntity = PropertySpec.builder(
            name = "toEntity",
            type = entityEnum
        )
            .addKdoc("Сущность к которой идет внешний ключ")
            .build()

        private val uk = PropertySpec.builder(
            name = "uk",
            type = uniqueKeyEnum
        )
            .addKdoc("Имя уникального индекса из toEntity на которой нацелен внешний ключ")
            .build()
        private val relationType = PropertySpec.builder(
            name = "relationType",
            type = CommonClassNames.relationType
        )
            .addKdoc("Тип связи TODO по идеи величина вычисляемая, сейчас задается разработчиком")
            .build()
        private val fkCols = PropertySpec.builder(
            name = "fkCols",
            type = SET.plusParameter(CommonClassNames.fkPair)
        )
            .addKdoc("Коллекция колонок входящих во внешний ключ ")
            .build()

        private val сontextExtractor = PropertySpec.builder(
            name = "сontextExtractor",
            type = typeVariableFConOfIEntityOrigin
        )
            .addKdoc("Ф-ция вытаскивающая из fromEntity, экземпляр уникального ключа toEntity -> uk. Хорошо подходит для поиска")
            .build()


        val fkPairGeneratorPropertySpec = listOf(fromEntity, toEntity, uk, relationType, fkCols, сontextExtractor)

        private val fkPairGeneratorPropertySpecCons = fkPairGeneratorPropertySpec
            .map { ps ->
                PropertySpec.builder(ps.name, ps.type)
                    .initializer("%N", ps.name)
//                    .addModifiers(KModifier.OVERRIDE)
                    .addKdoc(ps.kdoc)
                    .build()
            }


    }

}