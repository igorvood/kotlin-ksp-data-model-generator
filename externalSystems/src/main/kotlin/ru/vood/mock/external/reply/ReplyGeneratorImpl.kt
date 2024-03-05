package ru.vood.mock.external.reply

import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonObjectBuilder
import org.springframework.stereotype.Service
import ru.vood.dmgen.datamodel.metaEnum.EntityEnum
import ru.vood.dmgen.datamodel.metaEnum.FullColumnNameEnum
import ru.vood.dmgen.datamodel.metaEnum.UniqueKeyEnum
import ru.vood.dmgen.datamodel.metaEnum.UniqueKeyEnum.Companion.uniqueKeyMap
import ru.vood.mock.external.reply.data.Response

@Service
class ReplyGeneratorImpl : IReplyGenerator {
    override fun generate(payloadClass: String, uk: Map<String, String>): List<Response> {

        val entityEnum = uniqueKeyMap[UniqueKeyEnum.valueOf(payloadClass)]!!.entity

        val map = FullColumnNameEnum.values().filter { it.columnData().entity == entityEnum }.map { it.columnData() }

        val jsonObject = JsonObject
        map.forEach {cd ->

        }


        Json {  }


        println(1)
        TODO("Not yet implemented")
    }
}