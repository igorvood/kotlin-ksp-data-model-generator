package ru.vood.processor.datamodel.gen

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.KSPLogger
import ru.vood.model.generator.ksp.common.dto.PackageName

abstract class AbstractDataDictionaryGenerator<META>(
    codeGenerator: CodeGenerator,
    rootPackage: PackageName,
    logger: KSPLogger,

    ) : AbstractGenerator<META>(codeGenerator, rootPackage, logger) {

    override val subPackage: PackageName
        get() = subPackageAbstractDataDictionaryGenerator

    abstract val nameClass: String

    companion object {
        val subPackageAbstractDataDictionaryGenerator = PackageName("metaEnum")
    }

}