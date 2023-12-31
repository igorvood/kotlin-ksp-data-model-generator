package ru.vood.dmgen.run

import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Service
import ru.vood.dmgen.datamodel.a.DealEntity
import ru.vood.dmgen.meta.DerivativeColumns.entitiesColumnsMap
import ru.vood.dmgen.meta.DerivativeDependencyMap.aggregateChildDependencyMap
import ru.vood.dmgen.meta.DerivativeDependencyMap.aggregateParentDependencyMap
import ru.vood.dmgen.meta.DerivativeDependencyMap.entityDependencyChildMap
import ru.vood.dmgen.meta.DerivativeDependencyMap.entityDependencyParentMap

@Service
@Order(100)
class RunDependency : CommandLineRunner {

    private val log = LoggerFactory.getLogger(this.javaClass)
    override fun run(vararg args: String?) {
        log.info("=============RUN Dependency ================================")
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

    }
}