package ru.vood.processor.datamodel.newG

import com.squareup.kotlinpoet.FileSpec
import ru.vood.model.generator.ksp.common.dto.PackageName

abstract class AbstractGenerator (
    val rootPackage: PackageName,
    val subPackage: PackageName,
    val moduleName: String
){

    val fileSpec = FileSpec.builder(
        packageName = rootPackage.value + "."+subPackage.value,
        fileName = moduleName
    )
}