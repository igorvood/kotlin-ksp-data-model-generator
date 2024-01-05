package datamodel

import org.junit.jupiter.api.Test
import ru.vood.dmgen.annotation.FlowEntityType
import ru.vood.dmgen.datamodel.intf.SealedSyntheticColumnEntityData
import ru.vood.dmgen.datamodel.intf.SimpleColumnEntityData
import ru.vood.dmgen.datamodel.intf.SyntheticColumnEntityData
import ru.vood.dmgen.dto.RelationType
import ru.vood.dmgen.meta.DerivativeColumns.entitiesColumnsMap
import ru.vood.dmgen.meta.DerivativeDependencyMap.entityDependencyParentMap
import ru.vood.dmgen.meta.DerivativeFKs.foreignKeyMapFromEntity
import java.io.File

class PumlGenerator {

    @Test
    fun asdasdsa() {

        val keys = entityDependencyParentMap.keys

        val entities = entityDependencyParentMap.keys
            .map { en ->
                val colourName = when (val entityData = en.entityData().entityType) {
                    FlowEntityType.ONE_OF -> "Yellow"
                    FlowEntityType.INNER -> "Green"
                    FlowEntityType.AGGREGATE -> "Red"
                }
                val culumns =
                    entitiesColumnsMap[en]!!.values
                        .map { col ->
                            val question = if (col.isOptional) {
                                "?"
                            } else {
                                ""
                            }

                            val typeCol = when (val c = col) {
                                is SimpleColumnEntityData -> c.simpleColumnType.value
                                is SyntheticColumnEntityData -> c.outEntity
                                is SealedSyntheticColumnEntityData -> c.outEntities.map { it }.joinToString(",")
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

        File("depTree.puml").printWriter().use { out ->

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