package ru.vood.processor.datamodel.abstraction.model

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import ru.vood.dmgen.annotation.FlowEntityType
import ru.vood.processor.datamodel.abstraction.AbstractGeneratorTest
import ru.vood.processor.datamodel.gen.syntheticFieldInfos

internal class MetaInformationTest: AbstractGeneratorTest("DataModel.json") {

    @Test
    fun getRootPackage() {
    }

    @Test
    fun getAggregateInnerDep() {
    }

    @Test
    fun getEntityDependency() {
        metaInformation.entities.values
            .forEach {me ->
                val filter = metaInformation.metaForeignKeys
//                    .filter { fk -> fk.fromEntity.flowEntityType != FlowEntityType.AGGREGATE }
                    .filter { fk -> fk.toEntity == me }
                    .map { it.fromEntity }

                val syntheticFieldInfos = syntheticFieldInfos(filter, metaInformation.metaForeignKeys, me)

                val childrenSyntheticFieldsInfo = metaInformation.entityDependency[me.designPoetClassName]?.childrenSyntheticFieldsInfo?: listOf()

                assertEquals(syntheticFieldInfos, childrenSyntheticFieldsInfo)

            }

    }

    @Test
    fun getMetaForeignKeys() {
    }

    @Test
    fun getEntities() {
    }

    @Test
    fun getNullableProbSetDefaultNull() {
    }
}