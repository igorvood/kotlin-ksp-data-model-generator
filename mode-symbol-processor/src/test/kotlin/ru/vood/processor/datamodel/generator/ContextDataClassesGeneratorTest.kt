package ru.vood.processor.datamodel.generator

import com.squareup.kotlinpoet.FileSpec
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import ru.vood.processor.datamodel.abstraction.AbstractGeneratorTest
import ru.vood.processor.datamodel.generator.common.ColumnEntityDataSingleFileGeneratorTest
import ru.vood.processor.datamodel.generator.util.readFile

internal class ContextDataClassesGeneratorTest: AbstractGeneratorTest("DataModel.json") {

    lateinit var generatedFiles: List<FileSpec>

    @BeforeAll
    fun beforeAllT() {
        val generator = ContextDataClassesGenerator(metaInformation, )
        generatedFiles = generator.files()
    }

    @ParameterizedTest
    @MethodSource("ru.vood.processor.datamodel.generator.ContextDataClassesGeneratorTest#testCaseData")
    fun textFileTest(testCase: TestCase) {
        val files: List<FileSpec> = generatedFiles
            .filter { it.name == testCase.expectedClassFile }

        Assertions.assertEquals(1, files.size)

        val fileSpec = files[0]

        Assertions.assertEquals(testCase.getText(), fileSpec.toJavaFileObject().getCharContent(false))

    }

    companion object {
        private val testData = listOf(
            TestCase("Deal_PKContext"),
            TestCase("OneOfDto_PKContext"),
            TestCase("DealOneData_PKContext"),
            TestCase("DealTwoData_PKContext"),
        )

        @JvmStatic
        private fun testCaseData() = testData.map { Arguments.of(it) }

    }

    data class TestCase(val expectedClassFile: String) {

        fun getText() = this::class.java.readFile(expectedClassFile)

    }
}