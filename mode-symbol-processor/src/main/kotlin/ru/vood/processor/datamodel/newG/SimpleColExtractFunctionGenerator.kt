package ru.vood.processor.datamodel.newG

import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.plusParameter
import ru.vood.model.generator.ksp.common.CommonClassNames
import ru.vood.model.generator.ksp.common.CommonClassNames.simpleColExtractFunction
import ru.vood.model.generator.ksp.common.CommonClassNames.typeVariableOUT
import ru.vood.model.generator.ksp.common.CommonClassNames.typeVariableT
import ru.vood.model.generator.ksp.common.dto.PackageName
import ru.vood.processor.datamodel.newG.IColExtractFunctionGenerator.Companion.iColExtractFunctionGeneratorPropertySpec
import ru.vood.processor.datamodel.newG.abstraction.AbstractDataClassGenerator
import ru.vood.processor.datamodel.newG.abstraction.propertyInConstructor

class SimpleColExtractFunctionGenerator(rootPackage: PackageName) : AbstractDataClassGenerator(
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