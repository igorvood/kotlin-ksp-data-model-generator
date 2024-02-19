package ru.vood.processor.datamodel.generator.common

import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.TypeSpec
import ru.vood.model.generator.ksp.common.CommonClassNames.boolean
import ru.vood.model.generator.ksp.common.CommonClassNames.columnEntityData
import ru.vood.model.generator.ksp.common.CommonClassNames.entityEnum
import ru.vood.model.generator.ksp.common.CommonClassNames.simpleColumnName
import ru.vood.model.generator.ksp.common.CommonClassNames.string
import ru.vood.model.generator.ksp.common.dto.PackageName
import ru.vood.processor.datamodel.generator.abstraction.AbstractIntfSingleFileGenerator

class ColumnEntityDataSingleFileGenerator(rootPackage: PackageName) : AbstractIntfSingleFileGenerator(
    rootPackage = rootPackage,
    moduleName = columnEntityData,
    kModifier = KModifier.SEALED
) {
    override fun fillInterfaceBuilder(classBuilder: TypeSpec.Builder): TypeSpec.Builder {
        return classBuilder
            .addKdoc("Мета данные по реквизиту сущности")
            .addProperty(entityPropertySpec)
            .addProperty(simpleColumnNamePropertySpec)
            .addProperty(isOptionalPropertySpec)
            .addProperty(commentPropertySpec)
    }

    companion object {
        private val entityPropertySpec = PropertySpec.builder("entity", entityEnum)
            .addKdoc("имя сущности")
            .build()
        private val simpleColumnNamePropertySpec = PropertySpec.builder("simpleColumnName", simpleColumnName)
            .addKdoc("имя колонки")
            .build()
        private val isOptionalPropertySpec = PropertySpec.builder("isOptional", boolean)
            .addKdoc("признак опциональности колонки")
            .build()
        private val commentPropertySpec = PropertySpec.builder("comment", string)
            .addKdoc("коментарий колонки")
            .build()

        val columnEntityDataGeneratorPropSpec =
            setOf(entityPropertySpec, simpleColumnNamePropertySpec, isOptionalPropertySpec, commentPropertySpec)

    }


}