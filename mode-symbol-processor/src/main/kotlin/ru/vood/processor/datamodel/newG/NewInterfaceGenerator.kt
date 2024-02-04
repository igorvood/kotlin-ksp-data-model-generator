package ru.vood.processor.datamodel.newG

import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.TypeSpec
import ru.vood.model.generator.ksp.common.KspCommonUtils.generated
import ru.vood.model.generator.ksp.common.dto.PackageName
import ru.vood.processor.datamodel.gen.runtime.intf.InterfaceGenerator

class NewInterfaceGenerator(val rootPackage: PackageName) {
    fun files(): List<FileSpec> {
        val moduleName = InterfaceGenerator.GeneratedClasses.SerializableEntity.name
        val fileSpec = FileSpec.builder(
            packageName = rootPackage.value + "newintf",
            fileName = moduleName
        )

        val classBuilder = TypeSpec.interfaceBuilder(moduleName)
//            .addOriginatingKSFile(containingFile)
            .generated(NewInterfaceGenerator::class)
//            .addProperty(    PropertySpec.builder("designEntityName", "EntityEnum")
//                .initializer("object : %T {}", "moduleClass")
//                .build())
//        val designEntityName: EntityEnum

//            .addModifiers(KModifier.PUBLIC, KModifier.OPEN)

//            .addSuperinterface(declaration.toClassName())

//        classBuilder.addProperty()


        return listOf(fileSpec.addType(classBuilder.build()).build())
    }
}