package ru.vood.processor.datamodel.abstraction.model.abstraction.metadto

import ru.vood.processor.datamodel.abstraction.model.gen.dto.GeneratedFile
import ru.vood.processor.datamodel.abstraction.model.gen.dto.PackageName
import java.io.File
import java.nio.file.Files
import java.nio.file.Paths
import javax.annotation.processing.Messager
import javax.annotation.processing.ProcessingEnvironment
import javax.tools.Diagnostic

abstract class AbstractGenerator<META>(
    val messager: Messager,
    val processingEnv: ProcessingEnvironment,
    val rootPackage: PackageName
) {

    abstract fun textGenerator(generatedClassData: META): Set<GeneratedFile>
    fun createFiles(generatedClassData: META) {
        val textGenerator = textGenerator(generatedClassData)
        textGenerator
            .forEach { genFile ->
                val (fileName, code) = genFile

                Files.createDirectories(Paths.get(generationDirectory))

                val file = File(generationDirectory, "${fileName.value}.kt")
                file.writeText(code.value)
            }
    }

    private val kaptKotlinGeneratedDir by lazy {
        processingEnv.options[KAPT_KOTLIN_GENERATED_OPTION_NAME]!!
    }

    abstract val subPackage: PackageName

    val packageName = PackageName(rootPackage.value  + subPackage.value)

    private val subDir by lazy {
        (rootPackage.value + "." + subPackage.value)
            .replace(".", "/")
    }

    val generationDirectory by lazy {
        "$kaptKotlinGeneratedDir/$subDir"
    }

    protected fun log(kind: Diagnostic.Kind, msg: CharSequence?) {

        messager.printMessage(kind, "${this.javaClass.canonicalName}: $msg")
    }

    companion object {
        const val KAPT_KOTLIN_GENERATED_OPTION_NAME = "kapt.kotlin.generated"
    }
}