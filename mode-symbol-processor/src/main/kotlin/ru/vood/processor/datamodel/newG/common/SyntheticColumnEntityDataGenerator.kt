package ru.vood.processor.datamodel.newG.common

import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.plusParameter
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.TypeSpec
import ru.vood.model.generator.ksp.common.CommonClassNames
import ru.vood.model.generator.ksp.common.CommonClassNames.entityEnum
import ru.vood.model.generator.ksp.common.CommonClassNames.iSyntheticColExtractFunction
import ru.vood.model.generator.ksp.common.CommonClassNames.syntheticColumnEntityData
import ru.vood.model.generator.ksp.common.CommonClassNames.typeVariableStar
import ru.vood.model.generator.ksp.common.CommonClassNames.typeVariableT
import ru.vood.model.generator.ksp.common.dto.PackageName
import ru.vood.processor.datamodel.newG.common.ColumnEntityDataGenerator.Companion.columnEntityDataGeneratorPropSpec
import ru.vood.processor.datamodel.newG.abstraction.AbstractDataClassGenerator
import ru.vood.processor.datamodel.newG.abstraction.propertyInConstructor

class SyntheticColumnEntityDataGenerator(rootPackage: PackageName) : AbstractDataClassGenerator(
    rootPackage = rootPackage,
    moduleName = syntheticColumnEntityData,
) {
    override fun fillInterfaceBuilder(classBuilder: TypeSpec.Builder): TypeSpec.Builder {
        val constructor: FunSpec.Builder = FunSpec.constructorBuilder()
        propertyInConstructor(
            classBuilder,
            constructor,
            simpleColumnEntityDataGeneratorPropSpec
        )
        return classBuilder
            .addTypeVariable(CommonClassNames.typeVariableIEntityOrigin)
            .addSuperinterface(CommonClassNames.columnEntityData)
            .addKdoc("Мета данные по простому реквизиту сущности")
            .primaryConstructor(constructor.build())
    }


    companion object {

        val simpleColumnEntityDataGeneratorPropSpec = columnEntityDataGeneratorPropSpec
            .map { ps ->
                PropertySpec.builder(ps.name, ps.type)
                    .initializer("%N", ps.name)
                    .addModifiers(KModifier.OVERRIDE)
                    .addKdoc(ps.kdoc)
                    .build()
            }
            .plus(
                PropertySpec.builder("outEntity", entityEnum)
                    .initializer("%N", "outEntity")
                    .addKdoc("Тип синтетического реквизита")
                    .build()
            )
            .plus(
                PropertySpec.builder(
                    "iColExtractFunction",
                    iSyntheticColExtractFunction.plusParameter(typeVariableT).plusParameter(typeVariableStar)
                )
                    .initializer("%N", "iColExtractFunction")
                    .addKdoc("ф-ция экстрактор значения колонки")
                    .build()
            )


    }

}