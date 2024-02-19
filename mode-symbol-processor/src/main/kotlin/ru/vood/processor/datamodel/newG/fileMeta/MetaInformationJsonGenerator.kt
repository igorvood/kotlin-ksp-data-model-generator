package ru.vood.processor.datamodel.newG.fileMeta

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.Dependencies
import com.squareup.kotlinpoet.FileSpec
import kotlinx.serialization.json.Json
import ru.vood.processor.datamodel.abstraction.model.MetaInformation
import ru.vood.processor.datamodel.gen.appendText
import ru.vood.processor.datamodel.newG.abstraction.AbstractGenerator

class MetaInformationJsonGenerator(
    val codeGenerator: CodeGenerator,
    val metaInformation: MetaInformation,
) : AbstractGenerator() {

    private val json = Json {
        prettyPrint = true
        allowStructuredMapKeys = true
    }

    override fun files(): List<FileSpec> {

        json.encodeToString(MetaInformation.serializer(), metaInformation)

        kotlin.runCatching {
            val file = codeGenerator.createNewFile(
                Dependencies.ALL_FILES,
                "Meta",
                "meta", "json"
            )

            file.appendText(json.encodeToString(MetaInformation.serializer(), metaInformation))
            file.close()
        }
        return listOf()

    }


}