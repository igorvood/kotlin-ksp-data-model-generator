package ru.vood.processor.datamodel.newG.abstraction

import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.TypeSpec
import ru.vood.model.generator.ksp.common.CommonClassNames.subPackageIntfGenerator
import ru.vood.model.generator.ksp.common.KspCommonUtils.generated
import ru.vood.model.generator.ksp.common.dto.PackageName

abstract class AbstractIntfGenerator(
    rootPackage: PackageName,
    moduleName: ClassName,
    private val kModifier: KModifier? = null,
) : AbstractGenerator(
    rootPackage = rootPackage,
    subPackage = subPackageIntfGenerator,
    moduleName = moduleName,

    ) {

    override fun files(): List<FileSpec> {


        val classBuilder = TypeSpec.interfaceBuilder(moduleName)
            .generated(this::class)
        kModifier?.let {
            classBuilder.addModifiers(it)
        }

        return listOf(fileSpec.addType(fillInterfaceBuilder(classBuilder).build()).build())
    }

    abstract fun fillInterfaceBuilder(classBuilder: TypeSpec.Builder): TypeSpec.Builder
}
