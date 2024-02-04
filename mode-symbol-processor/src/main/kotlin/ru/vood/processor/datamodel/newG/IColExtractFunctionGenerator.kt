package ru.vood.processor.datamodel.newG

import com.squareup.kotlinpoet.*
import ru.vood.model.generator.ksp.common.CommonClassNames.entityEnum
import ru.vood.model.generator.ksp.common.CommonClassNames.typeVariableF
import ru.vood.model.generator.ksp.common.CommonClassNames.typeVariableOUT
import ru.vood.model.generator.ksp.common.CommonClassNames.typeVariableT
import ru.vood.model.generator.ksp.common.dto.PackageName
import ru.vood.processor.datamodel.gen.runtime.intf.InterfaceGenerator
import ru.vood.processor.datamodel.newG.abstraction.AbstractIntfGenerator

class IColExtractFunctionGenerator(rootPackage: PackageName) : AbstractIntfGenerator(
    rootPackage = rootPackage,
    moduleName = InterfaceGenerator.GeneratedClasses.IColExtractFunction.name ,
    kModifier = KModifier.SEALED
) {
    override fun fillInterfaceBuilder(classBuilder: TypeSpec.Builder): TypeSpec.Builder {

        val consumerOf = WildcardTypeName.consumerOf(typeVariableT).copy()
        TypeVariableName(typeVariableT.name, KModifier.IN)
        return classBuilder
            .addTypeVariable(
                TypeVariableName(typeVariableT.name, KModifier.IN)
            )
            .addTypeVariable(
                TypeVariableName(typeVariableOUT.name, KModifier.OUT)
            )
            .addProperty(extractFieldValue)
//            .addFunction(extractFieldValueF)
    }

    companion object {


        private val extractFieldValue = PropertySpec.builder("extractFieldValue", typeVariableF)
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
        val iColExtractFunctionGeneratorFunSpec = setOf(extractFieldValueF)

    }


}