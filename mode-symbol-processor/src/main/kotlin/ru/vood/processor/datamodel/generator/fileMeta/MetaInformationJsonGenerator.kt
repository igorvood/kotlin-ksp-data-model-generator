package ru.vood.processor.datamodel.generator.fileMeta

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.Dependencies
import com.squareup.kotlinpoet.FileSpec
import ru.vood.processor.datamodel.abstraction.model.MetaInformation
import ru.vood.processor.datamodel.gen.appendText
import ru.vood.processor.datamodel.generator.abstraction.AbstractGenerator
import ru.vood.processor.datamodel.generator.config.jsonSerializer

class MetaInformationJsonGenerator(
    val codeGenerator: CodeGenerator,
    val metaInformation: MetaInformation,
) : AbstractGenerator() {

    override fun files(): List<FileSpec> {

        jsonSerializer.encodeToString(MetaInformation.serializer(), metaInformation)

        kotlin.runCatching {
            val file = codeGenerator.createNewFile(
                Dependencies.ALL_FILES,
                "Meta",
                "meta", "json"
            )

            file.appendText(jsonSerializer.encodeToString(MetaInformation.serializer(), metaInformation))
            file.close()
        }
        return listOf()

    }


}