package ru.vood.processor.datamodel.newG

import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.TypeSpec
import ru.vood.model.generator.ksp.common.KspCommonUtils.generated
import ru.vood.processor.datamodel.gen.PackageName
import ru.vood.processor.datamodel.gen.runtime.intf.InterfaceGenerator

class NewInterfaceGenerator(val rootPackage: PackageName) {
    fun files(): List<FileSpec> {
        val moduleName = InterfaceGenerator.GeneratedClasses.SerializableEntity.name
        val fileSpec = FileSpec.builder(
            packageName = rootPackage.value + "newintf",
            fileName = moduleName
        )

        val classBuilder = TypeSpec.classBuilder(moduleName)
//            .addOriginatingKSFile(containingFile)
            .generated(NewInterfaceGenerator::class)
            .addModifiers(KModifier.PUBLIC, KModifier.OPEN)
//            .addSuperinterface(declaration.toClassName())


        return listOf(fileSpec.addType(classBuilder.build()).build())
    }
}