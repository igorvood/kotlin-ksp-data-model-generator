package ru.vood.processor.datamodel.newG

import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.plusParameter
import com.squareup.kotlinpoet.TypeSpec
import com.squareup.kotlinpoet.TypeVariableName
import ru.vood.model.generator.ksp.common.CommonClassNames
import ru.vood.model.generator.ksp.common.CommonClassNames.iSyntheticColExtractFunction
import ru.vood.model.generator.ksp.common.CommonClassNames.typeVariableOUT
import ru.vood.model.generator.ksp.common.CommonClassNames.typeVariableT
import ru.vood.model.generator.ksp.common.dto.PackageName
import ru.vood.processor.datamodel.newG.abstraction.AbstractIntfGenerator

class ISyntheticColExtractFunctionGenerator(rootPackage: PackageName) : AbstractIntfGenerator(
    rootPackage = rootPackage,
    moduleName = iSyntheticColExtractFunction,
    kModifier = KModifier.SEALED
) {
    override fun fillInterfaceBuilder(classBuilder: TypeSpec.Builder): TypeSpec.Builder {

        return classBuilder
            .addSuperinterface(
                CommonClassNames.iColExtractFunction.plusParameter(typeVariableT).plusParameter(typeVariableOUT)
            )
            .addTypeVariable(
                TypeVariableName(typeVariableT.name, KModifier.IN)
            )
            .addTypeVariable(
                TypeVariableName(typeVariableOUT.name, KModifier.OUT)
            )


    }


}