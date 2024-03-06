package ru.vood.processor.datamodel

import com.squareup.kotlinpoet.ClassName
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import ru.vood.dmgen.annotation.FlowEntityType
import ru.vood.dmgen.dto.RelationType
import ru.vood.dmgen.dto.SimpleColumnName
import ru.vood.dmgen.dto.TypeUk
import ru.vood.dmgen.dto.UkName
import ru.vood.model.generator.ksp.common.dto.PackageName
import ru.vood.processor.datamodel.abstraction.AbstractKoraAppProcessorTest
import ru.vood.processor.datamodel.abstraction.TestFileGeneratorFactory
import ru.vood.processor.datamodel.abstraction.model.ForeignKeyName
import ru.vood.processor.datamodel.abstraction.model.MetaEntity
import ru.vood.processor.datamodel.abstraction.model.MetaEntityColumn
import ru.vood.processor.datamodel.abstraction.model.MetaForeignKey
import ru.vood.processor.datamodel.abstraction.model.dto.ModelClassName
import ru.vood.processor.datamodel.abstraction.model.dto.UkDto

@Disabled
internal class DataModelConfigProcessorProviderTest :
    AbstractKoraAppProcessorTest(
        listOf(DataModelConfigProcessorProvider(TestFileGeneratorFactory())),
        listOf("Deal.kt", "DealParam.kt")
    ) {

    @Test
    open fun create() {
        val draw = compile()
        val symbolProcessorProvider = symbolProcessors[0] as DataModelConfigProcessorProvider
        val metaInformation = symbolProcessorProvider.dataModelConfigProcessor.metaInformation


        assertFks(metaInformation.metaForeignKeys)

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

    private fun assertFks(metaForeignKeys: Set<MetaForeignKey>) {
        Assertions.assertEquals(3, metaForeignKeys.size)
        metaForeignKeys.first { it.name == ForeignKeyName("DealParamOneToOne_Deal_FK") }
            .assertFk(
                fromEntity = "DealParamOneToOne".withDefaultPackage(),
                toEntity = "Deal".withDefaultPackage(),
                fkCols = listOf(SimpleColumnName(value = "dealId") to SimpleColumnName(value = "id")),
                ukTo = UkDto(
                    name = UkName(value = "Deal_PK"),
                    cols = listOf(SimpleColumnName(value = "id")),
                    typeUk = TypeUk.PK
                ),
                ukFrom = UkDto(name=UkName(value="DealParamOneToOne_PK"), cols=listOf(SimpleColumnName(value="dealId")), typeUk= TypeUk.PK),
                relationType = RelationType.ONE_TO_ONE_MANDATORY
            )

        metaForeignKeys.first { it.name == ForeignKeyName("DealParamOneToOneOptional_Deal_FK") }
            .assertFk(
                fromEntity = "DealParamOneToOneOptional".withDefaultPackage(),
                toEntity = "Deal".withDefaultPackage(),
                fkCols = listOf(SimpleColumnName(value = "dealId") to SimpleColumnName(value = "id")),
                ukTo = UkDto(
                    name = UkName(value = "Deal_PK"),
                    cols = listOf(SimpleColumnName(value = "id")),
                    typeUk = TypeUk.PK
                ),
                ukFrom = UkDto(name=UkName(value="DealParamOneToOneOptional_PK"), cols=listOf(SimpleColumnName(value="dealId")), typeUk= TypeUk.PK),
                relationType = RelationType.ONE_TO_ONE_OPTIONAL
            )

        metaForeignKeys.first { it.name == ForeignKeyName("DealParamSet_Deal_FK") }
            .assertFk(
                fromEntity = "DealParamSet".withDefaultPackage(),
                toEntity = "Deal".withDefaultPackage(),
                fkCols = listOf(SimpleColumnName(value = "dealId") to SimpleColumnName(value = "id")),
                ukTo = UkDto(
                    name = UkName(value = "Deal_PK"),
                    cols = listOf(SimpleColumnName(value = "id")),
                    typeUk = TypeUk.PK
                ),
                ukFrom = UkDto(name=UkName(value="DealParamSet_PK"), cols=listOf(SimpleColumnName(value="dealId"), SimpleColumnName(value="id")), typeUk= TypeUk.PK),
                relationType = RelationType.MANY_TO_ONE
            )
    }

    private fun MetaForeignKey.assertFk(
        fromEntity: ClassName,
        toEntity: ClassName,

        fkCols: List<Pair<SimpleColumnName, SimpleColumnName>>,
        ukTo: UkDto,
        ukFrom: UkDto?,
        relationType: RelationType,
    ) {
        Assertions.assertEquals(fromEntity, this.fromEntity.designPoetClassName)
        Assertions.assertEquals(toEntity, this.toEntity.designPoetClassName)
        Assertions.assertEquals(fkCols, this.fkCols.map { it.from.name to it.to.name }.toList())
        Assertions.assertEquals(ukTo, this.uk)
        Assertions.assertEquals(ukFrom, this.ukFrom)
        Assertions.assertEquals(relationType, this.relationType)
    }

    private fun String.withDefaultPackage(): ClassName =
        ClassName("ru.vood.processor.datamodel.packageForDataModelConfigProcessorProviderTest.create", this)
}