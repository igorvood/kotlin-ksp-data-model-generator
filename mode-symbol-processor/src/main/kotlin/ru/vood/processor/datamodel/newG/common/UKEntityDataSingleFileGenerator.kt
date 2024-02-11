package ru.vood.processor.datamodel.newG.common

import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.plusParameter
import ru.vood.model.generator.ksp.common.CommonClassNames
import ru.vood.model.generator.ksp.common.CommonClassNames.entityEnum
import ru.vood.model.generator.ksp.common.CommonClassNames.kClass
import ru.vood.model.generator.ksp.common.CommonClassNames.kSerializer
import ru.vood.model.generator.ksp.common.CommonClassNames.typeVariableT
import ru.vood.model.generator.ksp.common.CommonClassNames.uKEntityData
import ru.vood.model.generator.ksp.common.CommonClassNames.uniqueKeyEnum
import ru.vood.model.generator.ksp.common.dto.PackageName
import ru.vood.processor.datamodel.newG.abstraction.AbstractDataClassSingleFileGenerator
import ru.vood.processor.datamodel.newG.abstraction.propertyInConstructor

class UKEntityDataSingleFileGenerator(rootPackage: PackageName) : AbstractDataClassSingleFileGenerator(
    rootPackage = rootPackage,
    moduleName = uKEntityData,
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
        private val ukName = PropertySpec.builder(
            name = "ukName",
            type = uniqueKeyEnum
        )
            .addKdoc("Имя уникального ключа")
            .build()

        private val columns = PropertySpec.builder(
            name = "columns",
            type = LIST.plusParameter(CommonClassNames.simpleColumnName)
        )
            .addKdoc("Колонки входящие в ключ")
            .build()

        private val serializer = PropertySpec.builder(
            name = "serializer",
            type = kSerializer.plusParameter(
                WildcardTypeName.producerOf(
                    CommonClassNames.iContextOf.plusParameter(
                        WildcardTypeName.producerOf(typeVariableT)
                    )
                )
            )
        )
            .addKdoc("Сериализатор уникального ключа")
            .build()
        private val ukClass = PropertySpec.builder(
            name = "ukClass",
            type = kClass.plusParameter(
                WildcardTypeName.producerOf(
                    CommonClassNames.iContextOf.plusParameter(
                        WildcardTypeName.producerOf(typeVariableT)
                    )
                )
            )
        )
            .addKdoc("Класс уникального ключа")
            .build()

        private val entity = PropertySpec.builder(
            name = "entity",
            type = entityEnum
        )
            .addKdoc("Имя сушности, к которой относится уникальный ключ")
            .build()

        private val extractContext = PropertySpec.builder(
            name = "extractContext",
            type = CommonClassNames.typeVariableFConOfT
        )
            .addKdoc("Экстрактор уникального ключа из ДТО")
            .build()

        private val typeUk = PropertySpec.builder(
            name = "typeUk",
            type = CommonClassNames.typeUk
        )
            .addKdoc("Тип уникального ключа PK, UK")
            .build()

        val fkPairGeneratorPropertySpec = listOf(ukName, columns, serializer, ukClass, entity, extractContext, typeUk)

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