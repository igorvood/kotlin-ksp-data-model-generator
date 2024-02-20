package ru.vood.processor.datamodel.generator.common

import com.squareup.kotlinpoet.FileSpec
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import ru.vood.model.generator.ksp.common.dto.PackageName
import ru.vood.processor.datamodel.abstraction.AbstractGeneratorTest
import ru.vood.processor.datamodel.generator.util.readFile

internal class ColumnEntityDataSingleFileGeneratorTest : AbstractGeneratorTest("DataModel.json") {

    lateinit var generatedFiles: List<FileSpec>

    @BeforeAll
    fun asd(){
        val columnEntityDataSingleFileGenerator = ColumnEntityDataSingleFileGenerator(PackageName("test"))
        generatedFiles = columnEntityDataSingleFileGenerator.files()
    }

    @ParameterizedTest
    @MethodSource("ru.vood.processor.datamodel.generator.common.ColumnEntityDataSingleFileGeneratorTest#testCaseData")
    fun textFileTest(testCase: TestCase) {

        val files: List<FileSpec> = generatedFiles
            .filter { it.name == testCase.expectedClassFile }


        assertEquals(1, files.size)

        val fileSpec = files[0]

        assertEquals(testCase.getText(), fileSpec.toJavaFileObject().getCharContent(false))

    }

    companion object {
        private val testData = listOf(TestCase("ColumnEntityData"))

        @JvmStatic
        private fun testCaseData() = testData.map{Arguments.of(it)}


        val s = """package test.intf

import javax.`annotation`.processing.Generated
import kotlin.Boolean
import kotlin.String
import ru.vood.dmgen.datamodel.sealedData.metaEnum.EntityEnum
import ru.vood.dmgen.dto.SimpleColumnName

/**
 * Мета данные по реквизиту сущности
 */
@Generated(value =
    ["ru.vood.processor.datamodel.generator.common.ColumnEntityDataSingleFileGenerator"])
public sealed interface ColumnEntityData {
  /**
   * имя сущности
   */
  public val entity: EntityEnum

  /**
   * имя колонки
   */
  public val simpleColumnName: SimpleColumnName

  /**
   * признак опциональности колонки
   */
  public val isOptional: Boolean

  /**
   * коментарий колонки
   */
  public val comment: String
}
"""

    }

    data class TestCase(val expectedClassFile: String) {

        fun getText() = this::class.java.readFile(expectedClassFile)

    }
}