package ru.vood.processor.datamodel.generator

import com.squareup.kotlinpoet.FileSpec
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import ru.vood.processor.datamodel.abstraction.AbstractGeneratorTest
import ru.vood.processor.datamodel.util.readFile

internal class ContextDataClassesGeneratorTest : AbstractGeneratorTest("DataModel.json") {

    lateinit var generatedFiles: List<FileSpec>

    @BeforeAll
    fun beforeAllT() {
        val generator = ContextDataClassesGenerator(metaInformation)
        generatedFiles = generator.files()
    }


    @Test
    fun compareTestedFiles() {
        val generatedNames = generatedFiles.map { it.name }.sorted()
        val testcaseData = testData.map { it.expectedClassFile }.sorted()

        Assertions.assertEquals(testcaseData, generatedNames)
    }


    @ParameterizedTest
    @MethodSource("ru.vood.processor.datamodel.generator.ContextDataClassesGeneratorTest#testCaseData")
    fun textFileTest(testCase: TestCase) {
        compareTextFile(generatedFiles, testCase.expectedClassFile, testCase.getText())
    }

    companion object {
        private val testData = listOf(
            TestCase("Deal_PKContext"),
            TestCase("OneOfDto_PKContext"),
            TestCase("DealOneData_PKContext"),
            TestCase("DealTwoData_PKContext"),
            TestCase("OptionalDealParam_PKContext"),
        )

        @JvmStatic
        private fun testCaseData() = testData.map { Arguments.of(it) }

    }

    data class TestCase(val expectedClassFile: String) {

        fun getText() = this::class.java.readFile(expectedClassFile)

    }
}