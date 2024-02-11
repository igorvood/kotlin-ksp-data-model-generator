package ru.vood.processor.datamodel.newG.common

import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.plusParameter
import ru.vood.model.generator.ksp.common.CommonClassNames
import ru.vood.model.generator.ksp.common.CommonClassNames.entityEnum
import ru.vood.model.generator.ksp.common.CommonClassNames.sealedSyntheticColumnEntityData
import ru.vood.model.generator.ksp.common.dto.PackageName
import ru.vood.processor.datamodel.newG.abstraction.AbstractDataClassSingleFileGenerator
import ru.vood.processor.datamodel.newG.abstraction.propertyInConstructor
import ru.vood.processor.datamodel.newG.common.ColumnEntityDataSingleFileGenerator.Companion.columnEntityDataGeneratorPropSpec

class SealedSyntheticColumnEntityDataSingleFileGenerator(rootPackage: PackageName) : AbstractDataClassSingleFileGenerator(
    rootPackage = rootPackage,
    moduleName = sealedSyntheticColumnEntityData,
) {
    override fun fillInterfaceBuilder(classBuilder: TypeSpec.Builder): TypeSpec.Builder {
        val constructor: FunSpec.Builder = FunSpec.constructorBuilder()
        propertyInConstructor(
            classBuilder,
            constructor,
            simpleColumnEntityDataGeneratorPropSpec
        )
        return classBuilder
//            .addTypeVariable(CommonClassNames.typeVariableIEntityOrigin)
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
                PropertySpec.builder("outEntities", SET.plusParameter(entityEnum))
                    .initializer("%N", "outEntities")
                    .addKdoc("Тип синтетического реквизита")
                    .build()
            )
    }

}