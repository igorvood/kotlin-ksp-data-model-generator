package datamodel

import org.junit.jupiter.api.Test
import ru.vood.dmgen.annotation.FlowEntityType
import ru.vood.dmgen.annotation.RelationType
import ru.vood.dmgen.datamodel.metaEnum.entityDataMap
import ru.vood.dmgen.meta.DerivativeDependencyMap.entityDependencyParentMap
import ru.vood.dmgen.meta.DerivativeFKs.foreignKeyMapFromEntity
import java.io.File

class PumlGenerator {

    @Test
    fun asdasdsa() {

        val entities = entityDependencyParentMap.keys
            .map { en ->
                val s = when (val entityData = entityDataMap[en]!!.entityType) {
                    FlowEntityType.INNER_OPTIONAL, FlowEntityType.INNER_MANDATORY -> "Green"
                    FlowEntityType.AGGREGATE -> "Red"
                }
//                uasp_streaming_unp_convertor_unp_convertor_aggregate_ca [
//label="{<f0> uasp_streaming_unp_convertor |<f1> unp_convertor_aggregate_ca|<f2> Описание не заполнено.\n\n\n}" shape=Mrecord];
//ProductPayments [label="{<f0> ProductPayments}" shape=box color=Red];
                """${en.value} [label="{<f0> ${en.value}|<f1> asd }" shape=Mrecord color=$s];"""
            }
            .joinToString("\n")


        val arrows = foreignKeyMapFromEntity.entries
            .flatMap { e ->
                val entityName = e.key
                val toEntities = e.value
                toEntities.map { fkMetaData ->
                    val arrowStr = when (fkMetaData.relationType) {
                        RelationType.MANY_TO_ONE -> "->"
                        RelationType.UNNOWN -> error("ASdasdasdasfasdf")
                        RelationType.ONE_TO_ONE_OPTIONAL -> "->"
                    }
                    """${entityName.value} ${arrowStr} ${fkMetaData.toEntity.value}[label="${fkMetaData.relationType}"];"""
                }

            }
            .joinToString("\n")

//        ProductPayments -> Product[label="earliest"]

//        dev_bevents__realtime__case_71__uaspdto [label="dev_bevents__realtime__case_71__uaspdto" shape=box color=Green];

        println(entityDependencyParentMap)


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