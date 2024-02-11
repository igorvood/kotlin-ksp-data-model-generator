package ru.vood.processor.datamodel.newG.common

import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.TypeSpec
import ru.vood.model.generator.ksp.common.CommonClassNames.entityEnum
import ru.vood.model.generator.ksp.common.CommonClassNames.serializableEntity
import ru.vood.model.generator.ksp.common.dto.PackageName
import ru.vood.processor.datamodel.newG.abstraction.AbstractIntfSingleFileGenerator

class SerializableEntitySingleFileGenerator(rootPackage: PackageName) : AbstractIntfSingleFileGenerator(
    rootPackage,
    serializableEntity
) {
    override fun fillInterfaceBuilder(classBuilder: TypeSpec.Builder): TypeSpec.Builder {
        return classBuilder
            .addKdoc("Сериализуемая сущность")
            .addProperty(designEntityNamePropertySpec)
    }

    companion object {
        val designEntityNamePropertySpec = PropertySpec.builder("designEntityName", entityEnum)
            .addKdoc("Мета информация по сущности")
            .build()

    }
}