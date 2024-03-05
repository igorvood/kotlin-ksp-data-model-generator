package ru.vood.mock.external.reply

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import ru.vood.dmgen.datamodel.metaEnum.UniqueKeyEnum

internal class ReplyGeneratorImplTest {

    private val replyGeneratorImpl = ReplyGeneratorImpl()

    @Test
    fun generate() {


        replyGeneratorImpl.generate(UniqueKeyEnum.Deal_PK.name, mapOf("id" to "1") )

    }
}