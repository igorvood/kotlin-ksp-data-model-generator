package ru.vood.mock.external.reply

import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import ru.vood.dmgen.datamodel.intf.SimpleColumnEntityData
import ru.vood.dmgen.datamodel.intf.SyntheticColumnEntityData
import ru.vood.dmgen.datamodel.metaEnum.FkNameEnum.Companion.fromToFkMap
import ru.vood.dmgen.datamodel.metaEnum.FullColumnNameEnum
import ru.vood.dmgen.datamodel.metaEnum.UniqueKeyEnum
import ru.vood.dmgen.datamodel.metaEnum.UniqueKeyEnum.Companion.uniqueKeyMap
import ru.vood.dmgen.dto.RelationType
import ru.vood.mock.external.reply.data.DataOk
import ru.vood.mock.external.reply.data.Response
import kotlin.random.Random

@Service
class ReplyGeneratorImpl : IReplyGenerator {
    private val logger = LoggerFactory.getLogger(this.javaClass)

    private val  json = Json {  }
    override fun generate(cnt: Int, payloadClass: String, uk: Map<String, String>): List<Response> {

        fun genRecursive(cnt: Int, payloadClass: String, uk: Map<String, String>): JsonObject{

            logger.info("payloadClass -> $payloadClass uk -> $uk")
            val ukEntityData = uniqueKeyMap[UniqueKeyEnum.valueOf(payloadClass)]!!
            ukEntityData.columns

            val entityEnum = ukEntityData.entity

            val allFields = FullColumnNameEnum.values().filter { it.columnData().entity == entityEnum }.map { it.columnData() }


            val ukJson = uk.map { it.key to JsonPrimitive(it.value) }.toMap()

            val simpleFields = allFields.filterIsInstance<SimpleColumnEntityData<*>>()
                .filter { !ukEntityData.columns.contains(it.simpleColumnName) }
            val otherFields = simpleFields
                .map { sced ->
                    val jPrim = when (sced.simpleColumnType.value) {
                        "kotlin.String" -> JsonPrimitive(Random.nextInt(111))
                        "Int" -> JsonPrimitive(Random.nextInt(111))
                        else -> error("unable to generate value for column ${sced.simpleColumnName.value} with type ${sced.simpleColumnType.value}")
                    }
                    sced.simpleColumnName.value to jPrim
                }.toMap()





            allFields.filterIsInstance<SyntheticColumnEntityData<*>>()
                .map {sced ->
                    val fkMetaData = fromToFkMap[sced.outEntity]!![entityEnum]!!
                    when(fkMetaData.relationType){
                        RelationType.ONE_TO_ONE_MANDATORY -> {
                            val newUk = fkMetaData.fkCols.map {fkColsPair->
                                val value = uk[fkColsPair.to.columnData().simpleColumnName.value]
                                fkColsPair.from.columnData().simpleColumnName.value to value!!
                            }
                                .toMap()

                            genRecursive(1, fkMetaData.ukTo.name, newUk)
                        }
                        RelationType.MANY_TO_ONE, RelationType.ONE_TO_ONE_OPTIONAL -> error("relation type ${fkMetaData.relationType} not supported for column ${sced.simpleColumnName.value}")
                    }
                }

            val jsonObject: JsonObject =
                JsonObject(mapOf("origin" to JsonObject(ukJson.plus(otherFields))))

            return jsonObject
        }






        val payload = genRecursive(cnt, payloadClass, uk).toString()
        return listOf( Response(payloadClass, DataOk(payload) ))

    }




}