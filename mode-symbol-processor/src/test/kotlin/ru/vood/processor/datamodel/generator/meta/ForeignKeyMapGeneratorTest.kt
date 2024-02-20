package ru.vood.processor.datamodel.generator.meta

import com.squareup.kotlinpoet.FileSpec
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import ru.vood.model.generator.ksp.common.dto.PackageName
import ru.vood.processor.datamodel.abstraction.AbstractGeneratorTest
import ru.vood.processor.datamodel.util.readFile

internal class ForeignKeyMapGeneratorTest : AbstractGeneratorTest("DataModel.json") {

    lateinit var generatedFiles: List<FileSpec>

    @BeforeAll
    fun beforeAllT() {
        val columnEntityDataSingleFileGenerator = ForeignKeyMapGenerator(PackageName("test"), metaInformation)
        generatedFiles = columnEntityDataSingleFileGenerator.files()
    }

    @Test
    fun compareTestedFiles() {
        val generatedNames = generatedFiles.map { it.name }.sorted()
        val testcaseData = testData.map { it.expectedClassFile }.sorted()

        assertEquals(testcaseData, generatedNames)
    }

    @ParameterizedTest
    @MethodSource("ru.vood.processor.datamodel.generator.meta.ForeignKeyMapGeneratorTest#testCaseData")
    fun textFileTest(testCase: TestCase) {
        compareTextFile(generatedFiles, testCase.expectedClassFile, testCase.getText())
    }


    companion object {
        private val testData = listOf(TestCase("FkNameEnum"))

        @JvmStatic
        private fun testCaseData() = testData.map { Arguments.of(it) }

    }

    data class TestCase(val expectedClassFile: String) {

        fun getText() = this::class.java.readFile(expectedClassFile)

    }
}