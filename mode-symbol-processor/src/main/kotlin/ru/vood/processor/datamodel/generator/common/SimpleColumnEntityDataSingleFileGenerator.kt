package ru.vood.processor.datamodel.generator.common

import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.plusParameter
import ru.vood.model.generator.ksp.common.CommonClassNames
import ru.vood.model.generator.ksp.common.CommonClassNames.simpleColExtractFunction
import ru.vood.model.generator.ksp.common.CommonClassNames.simpleColumnEntityData
import ru.vood.model.generator.ksp.common.CommonClassNames.simpleColumnType
import ru.vood.model.generator.ksp.common.CommonClassNames.typeVariableStar
import ru.vood.model.generator.ksp.common.CommonClassNames.typeVariableT
import ru.vood.model.generator.ksp.common.dto.PackageName
import ru.vood.processor.datamodel.generator.abstraction.AbstractDataClassSingleFileGenerator
import ru.vood.processor.datamodel.generator.common.ColumnEntityDataSingleFileGenerator.Companion.columnEntityDataGeneratorPropSpec

class SimpleColumnEntityDataSingleFileGenerator(rootPackage: PackageName) : AbstractDataClassSingleFileGenerator(
    rootPackage = rootPackage,
    moduleName = simpleColumnEntityData,
) {
    override fun fillInterfaceBuilder(classBuilder: TypeSpec.Builder): TypeSpec.Builder {
        val constructor: FunSpec.Builder = FunSpec.constructorBuilder()

        columnEntityDataGeneratorPropSpecConstructorImplemented(classBuilder, constructor)


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
                PropertySpec.builder("simpleColumnType", simpleColumnType)
                    .initializer("%N", "simpleColumnType")
                    .addKdoc("Тип простого реквизита")
                    .build()
            )
            .plus(
                PropertySpec.builder(
                    "iColExtractFunction",
                    simpleColExtractFunction.plusParameter(typeVariableT).plusParameter(typeVariableStar)
                )
                    .initializer("%N", "iColExtractFunction")
                    .addKdoc("ф-ция экстрактор значения колонки")
                    .build()
            )

        private fun columnEntityDataGeneratorPropSpecConstructorImplemented(
            classBuilder: TypeSpec.Builder,
            constructor: FunSpec.Builder,
        ) = simpleColumnEntityDataGeneratorPropSpec
            .forEach { ps ->
                constructor.addParameter(
                    ParameterSpec.builder(ps.name, ps.type)
                        .build()
                )
                classBuilder.addProperty(ps)
            }
    }

}