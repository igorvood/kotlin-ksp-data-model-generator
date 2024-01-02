package datamodel

import org.junit.jupiter.api.Test
import ru.vood.dmgen.annotation.FlowEntityType
import ru.vood.dmgen.annotation.RelationType
import ru.vood.dmgen.datamodel.metaEnum.entityDataMap
import ru.vood.dmgen.intf.newIntf.SimpleColumnEntityData
import ru.vood.dmgen.intf.newIntf.SyntheticColumnEntityData
import ru.vood.dmgen.meta.DerivativeColumns.entitiesColumnsMap
import ru.vood.dmgen.meta.DerivativeDependencyMap.entityDependencyParentMap
import ru.vood.dmgen.meta.DerivativeFKs.foreignKeyMapFromEntity
import java.io.File

class PumlGenerator {

    @Test
    fun asdasdsa() {

        val entities = entityDependencyParentMap.keys
            .map { en ->
                val colourName = when (val entityData = entityDataMap[en]!!.entityType) {
//                    FlowEntityType.INNER -> "Yellow"
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
                                is SimpleColumnEntityData<*> -> c.simpleColumnName.value
                                is SyntheticColumnEntityData -> c.entity.value
                            }

//                            val typeCol = col.outEntity?.let {
//                                when(col.iColExtractFunction){
//                                    is Simple -> error("такого быть не должно, никогда")
//                                    is Synthetic<*,*,*> -> it.value
//                                    is SyntheticSet<*,*,*> -> "SetOf(${it.value})"
//                                }
//                            }?:col.simpleColumnType!!.value
                            "${col.simpleColumnName.value}: $typeCol$question"
                        }
                        .joinToString("\\n")

                """${en.value} [label="{<f0> ${en.value}|<f1> $culumns }" shape=Mrecord color=$colourName];"""
            }
            .joinToString("\n")


        val arrows = foreignKeyMapFromEntity.entries
            .flatMap { e ->
                val entityName = e.key
                val toEntities = e.value
                toEntities.map { fkMetaData ->
                    val arrowStr = when (fkMetaData.relationType) {
                        RelationType.MANY_TO_ONE -> "->"
//                        RelationType.UNNOWN -> error("ASdasdasdasfasdf")
                        RelationType.ONE_TO_ONE_OPTIONAL -> "->"
                        RelationType.ONE_TO_ONE_MANDATORY -> "->"
                    }
                    """${entityName.value} ${arrowStr} ${fkMetaData.toEntity.value}[label="${fkMetaData.relationType}"];"""
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