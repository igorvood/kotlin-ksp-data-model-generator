package datamodel

import org.junit.jupiter.api.Test
import ru.vood.dmgen.annotation.FlowEntityType
import ru.vood.dmgen.datamodel.metaEnum.entityDataMap
import ru.vood.dmgen.meta.DerivativeDependencyMap.entityDependencyParentMap
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

                """${en.value} [label="${en.value}" shape=box color=$s];"""
            }
            .joinToString("\n")


        val map = entityDependencyParentMap.entries
            .flatMap { e ->
                val entityName = e.key
                val toEntities = e.value


                toEntities.map { to ->
                    """${entityName.value} -> ${to.toEntity.value}[label="earliest"]"""
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
            out.println(map)
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