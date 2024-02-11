package ru.vood.processor.datamodel.newG.abstraction

import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.FileSpec
import ru.vood.model.generator.ksp.common.dto.PackageName

abstract class AbstractSingleFileGenerator(
    val rootPackage: PackageName,
    val subPackage: PackageName,
    val moduleName: ClassName,
) : AbstractGenerator() {

    val fileSpec = FileSpec.builder(
        packageName = rootPackage.value + "." + subPackage.value,
        fileName = moduleName.simpleName
    )


}