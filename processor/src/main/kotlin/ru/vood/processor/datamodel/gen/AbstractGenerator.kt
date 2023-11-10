package ru.vood.processor.datamodel.gen

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.Dependencies
import com.google.devtools.ksp.processing.KSPLogger
import com.strukov.processor.extensions.appendText
import java.io.OutputStream
import kotlin.properties.Delegates

abstract class AbstractGenerator<META>(
    val codeGenerator: CodeGenerator,
    val rootPackage: PackageName,
    val logger: KSPLogger
) {

    private var file by Delegates.notNull<OutputStream>()
    abstract fun textGenerator(metaInfo: META): Set<GeneratedFile>
    fun createFiles(generatedClassData: META) {
        val textGenerator1 = textGenerator(generatedClassData)

        textGenerator1.forEach { genFile ->

            logger.info("Generate File! PackageName ${genFile.packageName.value} fileName${genFile.fileName.value}")

            kotlin.runCatching {

                file = codeGenerator.createNewFile(
                    Dependencies(
                        false,
//                classDeclaration.containingFile!!
                    ),
                    genFile.packageName.value,
                    genFile.fileName.value
                )

                file.appendText(genFile.generatedCode.value)

                file.close()

            }.fold({},
                {
                    logger.warn(it.message ?: "unknow msg")
                }
            )

        }

//
//        val textGenerator = textGenerator(generatedClassData)
//        textGenerator
//            .forEach { genFile ->
//                val (fileName, code) = genFile
//
//                Files.createDirectories(Paths.get(generationDirectory))
//
//                val file = File(generationDirectory, "${fileName.value}.kt")
//                file.writeText(code.value)
//            }
    }

//    private val kaptKotlinGeneratedDir by lazy {
//        processingEnv.options[KAPT_KOTLIN_GENERATED_OPTION_NAME]!!
//    }

    abstract val subPackage: PackageName

    val packageName by lazy {
        logger.info("PPPPPackage $rootPackage     $subPackage")


        PackageName(rootPackage.value + "." + subPackage.value)

    }

    private val subDir by lazy {
        (rootPackage.value + "." + subPackage.value)
            .replace(".", "/")
    }

//    val generationDirectory by lazy {
//        "$kaptKotlinGeneratedDir/$subDir"
//    }

    companion object {
        const val KAPT_KOTLIN_GENERATED_OPTION_NAME = "kapt.kotlin.generated"
    }
}