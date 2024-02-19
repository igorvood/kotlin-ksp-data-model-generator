package ru.vood.processor.datamodel.generator.common

import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.plusParameter
import ru.vood.model.generator.ksp.common.CommonClassNames
import ru.vood.model.generator.ksp.common.CommonClassNames.iEntityDetail
import ru.vood.model.generator.ksp.common.CommonClassNames.synthetic
import ru.vood.model.generator.ksp.common.CommonClassNames.typeVariableIEntityDetail
import ru.vood.model.generator.ksp.common.CommonClassNames.typeVariableIEntityOrigin
import ru.vood.model.generator.ksp.common.CommonClassNames.typeVariableIEntityOriginOut
import ru.vood.model.generator.ksp.common.CommonClassNames.typeVariableOUT
import ru.vood.model.generator.ksp.common.CommonClassNames.typeVariableSinthIn
import ru.vood.model.generator.ksp.common.dto.PackageName
import ru.vood.processor.datamodel.generator.abstraction.AbstractDataClassSingleFileGenerator
import ru.vood.processor.datamodel.generator.abstraction.propertyInConstructor

class SyntheticSingleFileGenerator(rootPackage: PackageName) : AbstractDataClassSingleFileGenerator(
    rootPackage = rootPackage,
    moduleName = synthetic,
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
            .addTypeVariable(typeVariableIEntityOrigin)
            .addTypeVariable(typeVariableIEntityDetail)
            .addTypeVariable(typeVariableIEntityOriginOut)
            .addSuperinterface(
                CommonClassNames.iSyntheticColExtractFunction.plusParameter(typeVariableSinthIn).plusParameter(
                    SET.plusParameter(iEntityDetail.plusParameter(typeVariableOUT))
                )
            )
//            .addKdoc("Мета данные по простому реквизиту сущности")
            .primaryConstructor(constructor.build())
    }


    companion object {


        val extractFieldValue =
            PropertySpec.builder(
                IColExtractFunctionSingleFileGenerator.extractFieldValue.name,
                CommonClassNames.typeVariableFQ
            )
                .build()

        private val simpleColExtractFunctionGeneratorPropSpec = listOf(extractFieldValue)
            .map { ps ->
                PropertySpec.builder(ps.name, ps.type)
                    .initializer("%N", ps.name)
                    .addModifiers(KModifier.OVERRIDE)
                    .addKdoc(ps.kdoc)
                    .build()
            }

    }

}