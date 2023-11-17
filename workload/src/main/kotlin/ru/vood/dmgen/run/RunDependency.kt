package ru.vood.dmgen.run

import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Service
import ru.vood.dmgen.datamodel.metaEnum.columnEntityDataMap
import ru.vood.dmgen.datamodel.runtime.dataclasses.DealEntity
import ru.vood.dmgen.meta.DerivativeColumns.entitiesColumnsMap
import ru.vood.dmgen.meta.DerivativeDependencyMap.aggregateChildDependencyMap
import ru.vood.dmgen.meta.DerivativeDependencyMap.aggregateParentDependencyMap
import ru.vood.dmgen.meta.DerivativeDependencyMap.entityDependencyChildMap
import ru.vood.dmgen.meta.DerivativeDependencyMap.entityDependencyParentMap

@Service
class RunDependency : CommandLineRunner {
    override fun run(vararg args: String?) {

        val serializer = DealEntity.serializer()
        val descriptor = serializer.descriptor


        val message = entityDependencyParentMap
        println(message)
        val message1 = aggregateParentDependencyMap
        println(message1)
        val message2 = entityDependencyChildMap
        println(message2)

        val message3 = aggregateChildDependencyMap
        println(message3)


        val message4 = entitiesColumnsMap
        println(message4)

        val groupBy = columnEntityDataMap.values
            .map { column ->
                column.entity to column
            }
            .groupBy { it.first }
            .map { it.key to it.value.map { ass -> ass.second }.toSet() }
            .toMap()

    }
}