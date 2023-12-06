package ru.vood.dmgen.run

import kotlinx.serialization.json.Json
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Service
import ru.vood.dmgen.datamodel.valueClasses.DealId
import ru.vood.dmgen.delete.DealEntity1
import ru.vood.dmgen.delete.DealEntitySyntetic

@Service
class RunTest : CommandLineRunner {
    override fun run(vararg args: String?) {

        val encodeToString = Json.encodeToString(
            DealEntitySyntetic.serializer(),
            DealEntitySyntetic(DealEntity1(DealId("12"), "ASd", "asd", true, true), null)
        )


        val decodeFromString =
            Json.decodeFromString<DealEntitySyntetic>(DealEntitySyntetic.serializer(), encodeToString)

//        println(encodeToString)
//        println(decodeFromString)

    }
}