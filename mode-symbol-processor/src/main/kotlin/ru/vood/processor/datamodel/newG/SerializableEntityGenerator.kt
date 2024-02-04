package ru.vood.processor.datamodel.newG

import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.TypeSpec
import ru.vood.model.generator.ksp.common.CommonClassNames.entityEnum
import ru.vood.model.generator.ksp.common.dto.PackageName
import ru.vood.processor.datamodel.gen.runtime.intf.InterfaceGenerator
import ru.vood.processor.datamodel.newG.abstraction.AbstractIntfGenerator

class SerializableEntityGenerator(rootPackage: PackageName) : AbstractIntfGenerator(
    rootPackage,
    InterfaceGenerator.GeneratedClasses.SerializableEntity.name
) {
    override fun fillInterfaceBuilder(classBuilder: TypeSpec.Builder): TypeSpec.Builder =
        classBuilder
            .addKdoc("Сериализуемая сущность")
            .addProperty(
                PropertySpec.builder("designEntityName", entityEnum)
                    .addKdoc("Мета информация по сущности")
                    .build()
            )
}