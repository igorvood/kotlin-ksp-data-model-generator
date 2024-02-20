package ru.vood.processor.datamodel.abstraction

import kotlinx.serialization.decodeFromString
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance
import ru.vood.processor.datamodel.abstraction.model.MetaInformation
import ru.vood.processor.datamodel.generator.config.jsonSerializer
import ru.vood.processor.datamodel.generator.util.readFile

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
abstract class AbstractGeneratorTest(val modelFileName: String) {

    lateinit var metaInformation: MetaInformation

    @BeforeAll
    fun  beforeAll(){
        val readFile = AbstractGeneratorTest::class.java.readFile(modelFileName)
        metaInformation = jsonSerializer.decodeFromString<MetaInformation>(readFile)

    }
}