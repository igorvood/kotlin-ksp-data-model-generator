package ru.vood.processor.datamodel.generator.abstraction

import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.TypeSpec
import ru.vood.model.generator.ksp.common.CommonClassNames
import ru.vood.model.generator.ksp.common.CommonClassNames.subPackageIntfGenerator
import ru.vood.model.generator.ksp.common.KspCommonUtils.generated
import ru.vood.model.generator.ksp.common.dto.PackageName

abstract class AbstractDataClassSingleFileGenerator(
    rootPackage: PackageName,
    moduleName: ClassName,
    val modifiers: KModifier = KModifier.DATA,
) : AbstractSingleFileGenerator(
    rootPackage = rootPackage,
    subPackage = subPackageIntfGenerator,
    moduleName = moduleName,
) {

    override fun files(): List<FileSpec> {
        val classBuilder = TypeSpec.classBuilder(moduleName)
            .generated(this::class)
            .addModifiers(modifiers)

        if (modifiers == KModifier.VALUE) {
            classBuilder
                .addAnnotation(CommonClassNames.jvmInline)
        }
        return listOf(fileSpec.addType(fillInterfaceBuilder(classBuilder).build()).build())
    }

    abstract fun fillInterfaceBuilder(classBuilder: TypeSpec.Builder): TypeSpec.Builder


}
