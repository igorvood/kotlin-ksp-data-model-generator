package ru.vood.processor.datamodel.newG.common

import com.squareup.kotlinpoet.*
import ru.vood.model.generator.ksp.common.CommonClassNames
import ru.vood.model.generator.ksp.common.CommonClassNames.typeVariableF
import ru.vood.model.generator.ksp.common.CommonClassNames.typeVariableOUT
import ru.vood.model.generator.ksp.common.CommonClassNames.typeVariableT
import ru.vood.model.generator.ksp.common.dto.PackageName
import ru.vood.processor.datamodel.newG.abstraction.AbstractIntfSingleFileGenerator

class IColExtractFunctionSingleFileGenerator(rootPackage: PackageName) : AbstractIntfSingleFileGenerator(
    rootPackage = rootPackage,
    moduleName = CommonClassNames.iColExtractFunction,
    kModifier = KModifier.SEALED
) {
    override fun fillInterfaceBuilder(classBuilder: TypeSpec.Builder): TypeSpec.Builder {
        return classBuilder
            .addTypeVariable(
                TypeVariableName(typeVariableT.name, KModifier.IN)
            )
            .addTypeVariable(
                TypeVariableName(typeVariableOUT.name, KModifier.OUT)
            )
            .addProperty(extractFieldValue)
    }

    companion object {


        val extractFieldValue = PropertySpec.builder("extractFieldValue", typeVariableF)
            .build()

        private val extractFieldValueF = FunSpec.builder("extractFieldValueF")
            .addParameter(
                ParameterSpec.builder("entity", typeVariableF)
                    .build()
            )
            .returns(typeVariableOUT)
            .addModifiers(KModifier.ABSTRACT)
//            .addCode("""TODO("method need implementation")""")
            .build()
        val iColExtractFunctionGeneratorPropertySpec = setOf(extractFieldValue)

    }


}