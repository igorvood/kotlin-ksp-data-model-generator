package ru.vood.processor.datamodel

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Disabled
import ru.vood.processor.datamodel.abstraction.AbstractKoraAppProcessorTest

@Disabled
internal class DataModelConfigProcessorProviderTest: AbstractKoraAppProcessorTest() {

    @Test
    fun create() {
        val draw = compile(
            """package ru.vood.a

import ru.vood.dmgen.annotation.*

@Comment("Это сущность Сделка")
@FlowEntity(FlowEntityType.AGGREGATE)
interface Deal {
    @Pk
    @Comment("Это ее идентификатор")
    val id: Int
}
""".trimIndent(),
        )
    }
}