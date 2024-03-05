package ru.vood.mock.external.reply

import ru.vood.mock.external.reply.data.Response

interface IReplyGenerator {

    fun generate(cnt: Int, parentPayloadClass: String, uk: Map<String, String>): List<Response>

}
