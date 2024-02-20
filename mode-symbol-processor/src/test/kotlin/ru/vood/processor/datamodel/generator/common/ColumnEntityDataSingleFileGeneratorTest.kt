package ru.vood.processor.datamodel.generator.common

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import ru.vood.model.generator.ksp.common.dto.PackageName
import ru.vood.processor.datamodel.abstraction.AbstractGeneratorTest

internal class ColumnEntityDataSingleFileGeneratorTest : AbstractGeneratorTest("DataModel.json") {


    @Test
    fun textFileTest() {

        val columnEntityDataSingleFileGenerator = ColumnEntityDataSingleFileGenerator(PackageName("test"))

        val files = columnEntityDataSingleFileGenerator.files()
        assertEquals(1, files.size)

        val fileSpec = files[0]

        assertEquals(s, fileSpec.toJavaFileObject().getCharContent(false))

    }

    companion object {
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
}