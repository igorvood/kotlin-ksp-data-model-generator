package ru.vood.processor.datamodel.generator.common

import com.squareup.kotlinpoet.FileSpec
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import ru.vood.model.generator.ksp.common.dto.PackageName
import ru.vood.processor.datamodel.abstraction.AbstractGeneratorTest
import ru.vood.processor.datamodel.util.readFile

internal class ColumnEntityDataSingleFileGeneratorTest : AbstractGeneratorTest("DataModel.json") {

    lateinit var generatedFiles: List<FileSpec>

    @BeforeAll
    fun beforeAllT() {
        val columnEntityDataSingleFileGenerator = ColumnEntityDataSingleFileGenerator(PackageName("test"))
        generatedFiles = columnEntityDataSingleFileGenerator.files()
    }

    @Test
    fun compareTestedFiles() {
        val generatedNames = generatedFiles.map { it.name }.sorted()
        val testcaseData = testData.map { it.expectedClassFile }.sorted()

        assertEquals(testcaseData, generatedNames)
    }

    @ParameterizedTest
    @MethodSource("ru.vood.processor.datamodel.generator.common.ColumnEntityDataSingleFileGeneratorTest#testCaseData")
    fun textFileTest(testCase: TestCase) {
        compareTextFile(generatedFiles, testCase.expectedClassFile, testCase.getText())
    }


    companion object {
        private val testData = listOf(TestCase("ColumnEntityData"))

        @JvmStatic
        private fun testCaseData() = testData.map { Arguments.of(it) }

    }

    data class TestCase(val expectedClassFile: String) {

        fun getText() = this::class.java.readFile(expectedClassFile)

    }
}