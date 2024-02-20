package ru.vood.processor.datamodel.abstraction

import com.squareup.kotlinpoet.FileSpec
import kotlinx.serialization.decodeFromString
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance
import ru.vood.processor.datamodel.abstraction.model.MetaInformation
import ru.vood.processor.datamodel.generator.config.jsonSerializer
import ru.vood.processor.datamodel.util.readFile

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
abstract class AbstractGeneratorTest(val modelFileName: String) {

    lateinit var metaInformation: MetaInformation

    @BeforeAll
    protected fun beforeAll() {
        val readFile = AbstractGeneratorTest::class.java.readFile(modelFileName)
        metaInformation = jsonSerializer.decodeFromString<MetaInformation>(readFile)

    }

    protected fun compareTextFile(
        generatedFiles1: List<FileSpec>,
        expectedClassFile: String,
        text: String,
    ) {
        val files: List<FileSpec> = generatedFiles1
            .filter {
                it.name == expectedClassFile
            }

        Assertions.assertEquals(1, files.size)

        val fileSpec = files[0]


        Assertions.assertEquals(text, fileSpec.toJavaFileObject().getCharContent(false))
    }
}