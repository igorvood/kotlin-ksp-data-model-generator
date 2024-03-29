package ru.vood.processor.datamodel.generator.common

import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.plusParameter
import ru.vood.model.generator.ksp.common.CommonClassNames
import ru.vood.model.generator.ksp.common.CommonClassNames.simpleColExtractFunction
import ru.vood.model.generator.ksp.common.CommonClassNames.typeVariableOUT
import ru.vood.model.generator.ksp.common.CommonClassNames.typeVariableT
import ru.vood.model.generator.ksp.common.dto.PackageName
import ru.vood.processor.datamodel.generator.abstraction.AbstractDataClassSingleFileGenerator
import ru.vood.processor.datamodel.generator.abstraction.propertyInConstructor
import ru.vood.processor.datamodel.generator.common.IColExtractFunctionSingleFileGenerator.Companion.iColExtractFunctionGeneratorPropertySpec

class SimpleColExtractFunctionSingleFileGenerator(rootPackage: PackageName) : AbstractDataClassSingleFileGenerator(
    rootPackage = rootPackage,
    moduleName = simpleColExtractFunction,
    modifiers = KModifier.VALUE
) {
    override fun fillInterfaceBuilder(classBuilder: TypeSpec.Builder): TypeSpec.Builder {
        val constructor: FunSpec.Builder = FunSpec.constructorBuilder()

        propertyInConstructor(
            classBuilder,
            constructor,
            simpleColExtractFunctionGeneratorPropSpec
        )


        return classBuilder
            .addTypeVariable(TypeVariableName(typeVariableT.name, KModifier.IN))
            .addTypeVariable(TypeVariableName(typeVariableOUT.name, KModifier.OUT))
            .addSuperinterface(
                CommonClassNames.iColExtractFunction.plusParameter(typeVariableT).plusParameter(typeVariableOUT)
            )
            .addKdoc("Мета данные по простому реквизиту сущности")
            .primaryConstructor(constructor.build())
    }


    companion object {

        private val simpleColExtractFunctionGeneratorPropSpec = iColExtractFunctionGeneratorPropertySpec
            .map { ps ->
                PropertySpec.builder(ps.name, ps.type)
                    .initializer("%N", ps.name)
                    .addModifiers(KModifier.OVERRIDE)
                    .addKdoc(ps.kdoc)
                    .build()
            }

    }

}