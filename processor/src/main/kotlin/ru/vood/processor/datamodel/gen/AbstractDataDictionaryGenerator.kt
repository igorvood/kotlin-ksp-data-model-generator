package ru.vood.processor.datamodel.gen

import javax.annotation.processing.Messager
import javax.annotation.processing.ProcessingEnvironment

abstract class AbstractDataDictionaryGenerator<META>(
    messager: Messager,
    processingEnv: ProcessingEnvironment,
    rootPackage: PackageName

) : AbstractGenerator<META>(messager, processingEnv, rootPackage) {

    override val subPackage: PackageName
        get() = subPackageAbstractDataDictionaryGenerator

    abstract val nameClass: String

    companion object {
        val subPackageAbstractDataDictionaryGenerator = PackageName("metaEnum")
    }

}