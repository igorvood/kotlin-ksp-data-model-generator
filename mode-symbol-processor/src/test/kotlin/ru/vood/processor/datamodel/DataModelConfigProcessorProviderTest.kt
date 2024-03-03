package ru.vood.processor.datamodel

import com.squareup.kotlinpoet.ClassName
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import ru.vood.dmgen.annotation.FlowEntityType
import ru.vood.dmgen.dto.SimpleColumnName
import ru.vood.dmgen.dto.TypeUk
import ru.vood.dmgen.dto.UkName
import ru.vood.model.generator.ksp.common.dto.PackageName
import ru.vood.processor.datamodel.abstraction.AbstractKoraAppProcessorTest
import ru.vood.processor.datamodel.abstraction.TestFileGeneratorFactory
import ru.vood.processor.datamodel.abstraction.model.MetaEntity
import ru.vood.processor.datamodel.abstraction.model.MetaEntityColumn
import ru.vood.processor.datamodel.abstraction.model.dto.ModelClassName
import ru.vood.processor.datamodel.abstraction.model.dto.UkDto

@Disabled
internal class DataModelConfigProcessorProviderTest :
    AbstractKoraAppProcessorTest(listOf(DataModelConfigProcessorProvider(TestFileGeneratorFactory()))) {

    @Test
    open fun create() {
        val draw = compile(
            """

import ru.vood.dmgen.annotation.*

@Comment("Это сущность Сделка")
@FlowEntity(FlowEntityType.AGGREGATE)
interface Deal {
    @Pk
    @Comment("Это ее идентификатор")
    val id: Int
}
""".trimIndent(),
        )
        val symbolProcessorProvider = symbolProcessors[0] as DataModelConfigProcessorProvider
        val metaInformation = symbolProcessorProvider.dataModelConfigProcessor.metaInformation

        Assertions.assertEquals(
            PackageName(value = "ru.vood.processor.datamodel.packageForDataModelConfigProcessorProviderTest.create"),
            metaInformation.rootPackage
        )

        val dealEntityMeta =
            metaInformation.entities[ModelClassName(value = "ru.vood.processor.datamodel.packageForDataModelConfigProcessorProviderTest.create.Deal")]!!
        Assertions.assertEquals(
            ClassName("ru.vood.processor.datamodel.packageForDataModelConfigProcessorProviderTest.create", "Deal"),
            dealEntityMeta.designPoetClassName
        )
        Assertions.assertEquals(
            FlowEntityType.AGGREGATE,
            dealEntityMeta.flowEntityType
        )

        mapOf(
            ModelClassName(
                value = "ru.vood.processor.datamodel.packageForDataModelConfigProcessorProviderTest.create.Deal"
            ) to MetaEntity(
                designPoetClassName = ClassName(
                    "ru.vood.processor.datamodel.packageForDataModelConfigProcessorProviderTest.create",
                    "Deal"
                ),
                flowEntityType = FlowEntityType.AGGREGATE,
                comment = "Это сущность Сделка",
                foreignKeysAnnotations = listOf(),
                pkColumns = UkDto(
                    name = UkName(value = "Deal_PK"),
                    cols = listOf(SimpleColumnName(value = "id")),
                    typeUk = TypeUk.PK
                ) to listOf(
                    MetaEntityColumn(
                        name = SimpleColumnName(value = "id"),
                        inPk = true,
                        isNullable = false,
                        type = "Int",
                        typePoetClassName = ClassName("kotlin", "Int"),
                        position = 0,
                        comment = "Это ее идентификатор"
                    )
                ),
                uniqueKeysFields = mapOf(
                    UkDto(
                        name = UkName(value = "Deal_PK"),
                        cols = listOf(SimpleColumnName(value = "id")),
                        typeUk = TypeUk.PK
                    ) to listOf(
                        MetaEntityColumn(
                            name = SimpleColumnName(value = "id"),
                            inPk = true,
                            isNullable = false,
                            type = "Int",
                            typePoetClassName = ClassName("kotlin", "Int"),
                            position = 0,
                            comment = "Это ее идентификатор"
                        )
                    )
                ),
                fields = listOf(
                    MetaEntityColumn(
                        name = SimpleColumnName(value = "id"),
                        inPk = true,
                        isNullable = false,
                        type = "kotlin.Int",
                        typePoetClassName = ClassName("kotlin", "Int"),
                        position = 0,
                        comment = "Это ее идентификатор"
                    )
                ), ksAnnotated = null
            )
        )

    }
}