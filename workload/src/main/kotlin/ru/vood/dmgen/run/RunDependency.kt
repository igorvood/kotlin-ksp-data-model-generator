package ru.vood.dmgen.run

import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Service
import ru.vood.dmgen.meta.DependencyMap.aggregateDependencyMap
import ru.vood.dmgen.meta.DependencyMap.entityDependencyMap

@Service
class RunDependency : CommandLineRunner {
    override fun run(vararg args: String?) {
        val message = entityDependencyMap
        println(message)
        val message1 = aggregateDependencyMap
        println(message1)
        println("sadfdsfjkhsflkgjhl")

    }
}