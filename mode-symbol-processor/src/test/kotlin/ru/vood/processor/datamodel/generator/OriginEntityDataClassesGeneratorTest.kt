package ru.vood.processor.datamodel.generator

import com.google.devtools.ksp.processing.KSPLogger
import com.squareup.kotlinpoet.FileSpec
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import ru.vood.processor.datamodel.abstraction.AbstractGeneratorTest
import ru.vood.processor.datamodel.util.readFile

internal class OriginEntityDataClassesGeneratorTest : AbstractGeneratorTest("DataModel.json") {

    lateinit var generatedFiles: List<FileSpec>

    @BeforeAll
    fun beforeAllT() {
        val generator = OriginEntityDataClassesGenerator(metaInformation, mockk<KSPLogger>(relaxUnitFun = true))
        generatedFiles = generator.files()
    }


    @Test
    fun compareTestedFiles() {
        val generatedNames = generatedFiles.map { it.name }.sorted()
        val testcaseData = testData.map { it.expectedClassFile }.sorted()

        assertEquals(testcaseData, generatedNames)
    }


    @ParameterizedTest
    @MethodSource("ru.vood.processor.datamodel.generator.OriginEntityDataClassesGeneratorTest#testCaseData")
    fun textFileTest(testCase: TestCase) {
        compareTextFile(generatedFiles, testCase.expectedClassFile, testCase.getText())
    }

    companion object {
        private val testData = listOf(
            TestCase("DealEntity"),
            TestCase("DealOneDataEntity"),
            TestCase("DealTwoDataEntity"),
            TestCase("NoFKAndUkEntity"),
            TestCase("OneOfDtoEntity"),
            TestCase("OptionalDealParamEntity"),
            TestCase("DealParamaggregateEntity"),

            )

        @JvmStatic
        private fun testCaseData() = testData.map { Arguments.of(it) }

    }

    data class TestCase(val expectedClassFile: String) {

        fun getText() = this::class.java.readFile(expectedClassFile)

    }
}