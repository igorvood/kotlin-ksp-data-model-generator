package ru.vood.mock.external.reply

import ru.vood.mock.external.reply.data.Response

interface IReplyGenerator {

    fun generateAggregate(cnt: Int, parentPayloadClass: String, uk: Map<String, String>): List<Response>

}
