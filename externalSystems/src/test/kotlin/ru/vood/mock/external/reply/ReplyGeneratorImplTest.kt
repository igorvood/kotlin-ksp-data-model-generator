package ru.vood.mock.external.reply

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Disabled
import ru.vood.dmgen.datamodel.metaEnum.UniqueKeyEnum

internal class ReplyGeneratorImplTest {

    private val replyGeneratorImpl = ReplyGeneratorImpl()

    @Test
    @Disabled
    fun generate() {


        replyGeneratorImpl.generate(1, UniqueKeyEnum.Deal_PK.name, mapOf("id" to "1") )

    }
}