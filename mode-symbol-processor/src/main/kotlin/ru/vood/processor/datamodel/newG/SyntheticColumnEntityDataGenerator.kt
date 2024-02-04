package ru.vood.processor.datamodel.newG

import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.plusParameter
import ru.vood.model.generator.ksp.common.CommonClassNames
import ru.vood.model.generator.ksp.common.CommonClassNames.entityEnum
import ru.vood.model.generator.ksp.common.CommonClassNames.iSyntheticColExtractFunction
import ru.vood.model.generator.ksp.common.CommonClassNames.simpleColExtractFunction
import ru.vood.model.generator.ksp.common.CommonClassNames.simpleColumnType
import ru.vood.model.generator.ksp.common.CommonClassNames.typeVariableStar
import ru.vood.model.generator.ksp.common.CommonClassNames.typeVariableT
import ru.vood.model.generator.ksp.common.dto.PackageName
import ru.vood.processor.datamodel.gen.runtime.intf.InterfaceGenerator
import ru.vood.processor.datamodel.newG.ColumnEntityDataGenerator.Companion.columnEntityDataGeneratorPropSpec

import ru.vood.processor.datamodel.newG.abstraction.AbstractDataClassGenerator

class SyntheticColumnEntityDataGenerator(rootPackage: PackageName) : AbstractDataClassGenerator(
    rootPackage = rootPackage,
    moduleName = InterfaceGenerator.GeneratedClasses.SyntheticColumnEntityData.name,
) {
    override fun fillInterfaceBuilder(classBuilder: TypeSpec.Builder): TypeSpec.Builder {
        val constructor: FunSpec.Builder = FunSpec.constructorBuilder()
        columnEntityDataGeneratorPropSpecConstructorImplemented(classBuilder, constructor, simpleColumnEntityDataGeneratorPropSpec)
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
                PropertySpec.builder("iColExtractFunction", iSyntheticColExtractFunction.plusParameter(typeVariableT).plusParameter(typeVariableStar))
                    .initializer("%N", "iColExtractFunction")
                    .addKdoc("ф-ция экстрактор значения колонки")
                    .build()
            )


    }

}