package ru.vood.processor.datamodel.newG

import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.plusParameter
import ru.vood.model.generator.ksp.common.CommonClassNames
import ru.vood.model.generator.ksp.common.CommonClassNames.iEntityDetail
import ru.vood.model.generator.ksp.common.CommonClassNames.typeVariableIEntityDetail
import ru.vood.model.generator.ksp.common.CommonClassNames.typeVariableIEntityOrigin
import ru.vood.model.generator.ksp.common.CommonClassNames.typeVariableIEntityOriginOut
import ru.vood.model.generator.ksp.common.CommonClassNames.typeVariableOUT
import ru.vood.model.generator.ksp.common.CommonClassNames.typeVariableSinthIn
import ru.vood.model.generator.ksp.common.dto.PackageName
import ru.vood.processor.datamodel.gen.runtime.intf.InterfaceGenerator
import ru.vood.processor.datamodel.newG.abstraction.AbstractDataClassGenerator

class SyntheticSetGenerator(rootPackage: PackageName) : AbstractDataClassGenerator(
    rootPackage = rootPackage,
    moduleName = InterfaceGenerator.GeneratedClasses.SyntheticSet.name,
    modifiers = KModifier.VALUE
) {
    override fun fillInterfaceBuilder(classBuilder: TypeSpec.Builder): TypeSpec.Builder {
        val constructor: FunSpec.Builder = FunSpec.constructorBuilder()

        columnEntityDataGeneratorPropSpecConstructorImplemented(
            classBuilder,
            constructor,
            simpleColExtractFunctionGeneratorPropSpec
        )


        return classBuilder
            .addTypeVariable(typeVariableIEntityOrigin)
            .addTypeVariable(typeVariableIEntityDetail)
            .addTypeVariable(typeVariableIEntityOriginOut)
            .addSuperinterface(CommonClassNames.iSyntheticColExtractFunction.plusParameter(typeVariableSinthIn). plusParameter(
                SET.plusParameter(iEntityDetail.plusParameter(typeVariableOUT))))
//            .addKdoc("Мета данные по простому реквизиту сущности")
            .primaryConstructor(constructor.build())
    }


    companion object {


        val extractFieldValue = PropertySpec.builder(IColExtractFunctionGenerator.extractFieldValue.name, CommonClassNames.typeVariableFQ)
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