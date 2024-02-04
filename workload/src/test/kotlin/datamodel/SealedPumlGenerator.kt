package datamodel

import org.junit.jupiter.api.Test
import ru.vood.dmgen.annotation.FlowEntityType

import ru.vood.dmgen.datamodel.sealedData.metaEnum.EntityEnum
import ru.vood.dmgen.datamodel.sealedData.metaEnum.FkNameEnum
import ru.vood.dmgen.datamodel.sealedData.metaEnum.FullColumnNameEnum
import ru.vood.dmgen.dto.RelationType
import java.io.File
import java.util.*

class SealedPumlGenerator {

    @Test
    fun asdasdsa() {

        val columnEntityDataMap = EnumMap(FullColumnNameEnum.values().map { it to it.columnData() }.toMap())

        val entitiesColumnsMap = EnumMap(columnEntityDataMap.values
            .map { column ->
                column.entity to column
            }
            .groupBy { it.first }
            .map {
                it.key to it.value.map { ass -> ass.second }
                    .map { asdsa -> asdsa.simpleColumnName to asdsa }.toMap()
            }
            .toMap()
        )

        val foreignKeyMapFromEntity = EnumMap(
            FkNameEnum.foreignKeyMap.values
            .map {
                it.fromEntity to it
            }
            .groupBy { it.first }
            .map { it.key to it.value.map { q -> q.second }.toSet() }
            .toMap()
        )


        val entities = EntityEnum.values()
            .map { en ->
                val colourName = when (val entityData = en.entityData().entityType) {
                    FlowEntityType.ONE_OF -> "Yellow"
                    FlowEntityType.INNER -> "Green"
                    FlowEntityType.AGGREGATE -> "Red"
                }
                val culumns =
                    entitiesColumnsMap[en]!!.values
                        .map { col: ru.vood.dmgen.datamodel.sealedData.intf.ColumnEntityData ->
                            val question = if (col.isOptional) {
                                "?"
                            } else {
                                ""
                            }

                            val typeCol = when (val c = col) {
                                is ru.vood.dmgen.datamodel.sealedData.intf.SimpleColumnEntityData <*>-> c.simpleColumnType.value
                                is ru.vood.dmgen.datamodel.sealedData.intf.SyntheticColumnEntityData<*> -> c.outEntity
                                is ru.vood.dmgen.datamodel.sealedData.intf.SealedSyntheticColumnEntityData -> c.outEntities.map { it }.joinToString(",")
                            }
                            "${col.simpleColumnName.value}: $typeCol$question"
                        }
                        .joinToString("\\n")

                """${en} [label="{<f0> ${en}|<f1> $culumns }" shape=Mrecord color=$colourName];"""
            }
            .joinToString("\n")


        val arrows = foreignKeyMapFromEntity.entries
            .flatMap { e ->
                val entityName = e.key
                val toEntities = e.value
                toEntities.map { fkMetaData ->
                    val arrowColor = when (fkMetaData.relationType) {
                        RelationType.MANY_TO_ONE -> "color=Indigo"//"color=Yellow"
                        RelationType.ONE_TO_ONE_OPTIONAL -> "color=Green"
                        RelationType.ONE_TO_ONE_MANDATORY -> "color=Red"
                    }
                    """${entityName} -> ${fkMetaData.toEntity}[ $arrowColor];"""
                }

            }
            .joinToString("\n")

        File("SealedPumlGenerator.puml").printWriter().use { out ->

            out.println(head)
            out.println(entities)
            out.println("")
            out.println(arrows)
            out.println(tail)

        }

    }


    companion object {
        val head = """@startuml
digraph dfd{
	node[shape=record]"""
    }


    val tail = """
}
@enduml"""
}