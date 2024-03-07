package ru.vood.mock.external.reply

import kotlinx.serialization.json.Json
import org.junit.jupiter.api.Test
import ru.vood.dmgen.datamodel.deal.DealDetail
import ru.vood.dmgen.datamodel.metaEnum.UniqueKeyEnum
import ru.vood.mock.external.reply.data.DataOk

internal class ReplyGeneratorImplTest {

    private val replyGeneratorImpl = ReplyGeneratorImpl()

    val asda = Json { }

    @Test
//    @Disabled
    fun generate() {


        val generate = replyGeneratorImpl.generate(1, UniqueKeyEnum.Deal_PK.name, mapOf("id" to "1"))
        val map = generate.map {
            println(generate)
            val decodeFromString = asda.decodeFromString(DealDetail.serializer(), (it.payload as DataOk).payload)
            println(1)
        }

    }
}