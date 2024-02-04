package ru.vood.processor.datamodel.newG

import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.TypeSpec
import ru.vood.model.generator.ksp.common.CommonClassNames.entityEnum
import ru.vood.model.generator.ksp.common.KspCommonUtils.generated
import ru.vood.model.generator.ksp.common.dto.PackageName
import ru.vood.processor.datamodel.gen.runtime.intf.InterfaceGenerator

class NewInterfaceAbstractGenerator(rootPackage: PackageName) : AbstractGenerator(
    rootPackage,
    PackageName("newintf"),
    InterfaceGenerator.GeneratedClasses.SerializableEntity.name
) {

    fun files(): List<FileSpec> {
        val classBuilder = TypeSpec.interfaceBuilder(moduleName)
            .addKdoc("Сериализуемая сущность")
            .generated(NewInterfaceAbstractGenerator::class)
            .addProperty(
                PropertySpec.builder("designEntityName", entityEnum)
                    .addKdoc("Мета информация по сущности")
                    .build()
            )

        return listOf(fileSpec.addType(classBuilder.build()).build())
    }
}