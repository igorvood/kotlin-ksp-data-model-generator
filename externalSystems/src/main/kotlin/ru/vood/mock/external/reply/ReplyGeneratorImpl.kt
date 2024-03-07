package ru.vood.mock.external.reply

import kotlinx.serialization.json.*
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import ru.vood.dmgen.datamodel.intf.*
import ru.vood.dmgen.datamodel.metaEnum.EntityEnum
import ru.vood.dmgen.datamodel.metaEnum.FkNameEnum.Companion.fromToFkMap
import ru.vood.dmgen.datamodel.metaEnum.FullColumnNameEnum
import ru.vood.dmgen.datamodel.metaEnum.UniqueKeyEnum
import ru.vood.dmgen.datamodel.metaEnum.UniqueKeyEnum.Companion.uniqueKeyMap
import ru.vood.dmgen.dto.RelationType
import ru.vood.mock.external.reply.data.DataOk
import ru.vood.mock.external.reply.data.Response

@Service
class ReplyGeneratorImpl : IReplyGenerator {
    private val logger = LoggerFactory.getLogger(this.javaClass)

    private val json = Json { }
    override fun generateAggregate(cnt: Int, payloadClass: String, uk: Map<String, String>): List<Response> {

        val payload = genRecursive(cnt, payloadClass, uk, TypeJsonObjectEnum.OBJECT).toString()
        return listOf(Response(payloadClass, DataOk(payload)))

    }

    private fun genRecursive(
        cnt: Int,
        payloadClass: String,
        uk: Map<String, String>,
        typeJsonObject: TypeJsonObjectEnum,
    ): JsonElement {

        when (typeJsonObject) {
            TypeJsonObjectEnum.COLLECTION -> require(cnt >= 0) { "for $typeJsonObject cnt must be zero or more" }
            TypeJsonObjectEnum.OBJECT -> require(cnt == 1) { "for $typeJsonObject cnt must be only 1" }
        }

        logger.info("payloadClass -> $payloadClass uk -> $uk")
        val ukEntityData = uniqueKeyMap[UniqueKeyEnum.valueOf(payloadClass)]!!
        val entityEnum = ukEntityData.entity
        val allFields =
            FullColumnNameEnum.values().filter { it.columnData().entity == entityEnum }.map { it.columnData() }


        val jsonElement = when (typeJsonObject) {
            TypeJsonObjectEnum.OBJECT -> jsonObject(uk, allFields, ukEntityData, entityEnum)
            TypeJsonObjectEnum.COLLECTION -> jsonObject(uk, allFields, ukEntityData, entityEnum)
        }


        return jsonElement
    }

    private fun jsonObject(
        uk: Map<String, String>,
        allFields: List<ColumnEntityData>,
        ukEntityData: UKEntityData<out IEntityOrigin>,
        entityEnum: EntityEnum,
    ): JsonObject {
        val ukJson = uk.map { it.key to JsonPrimitive(it.value) }.toMap()
        val otherSimpleFields = allFields.filterIsInstance<SimpleColumnEntityData<*>>()
            .filter { !ukJson.containsKey(it.simpleColumnName.value) }
            .map { sced ->
                val value = uk.hashCode() + sced.simpleColumnName.value.hashCode()
                val jPrim = when (sced.simpleColumnType.value) {
                    "kotlin.String" -> JsonPrimitive(value.toString())
                    "kotlin.Int" -> JsonPrimitive(value)
                    "kotlin.Double" -> JsonPrimitive(value.toDouble())
                    "kotlin.Float" -> JsonPrimitive(value.toFloat())
                    "kotlin.Long" -> JsonPrimitive(value.toLong())

                    "kotlin.Boolean" -> {
                        if (value % 2 == 1)
                            JsonPrimitive(true)
                        else JsonPrimitive(false)
                    }
                    else -> {
                        error("unable to generate value for column ${sced.simpleColumnName.value} with type ${sced.simpleColumnType.value}")
                    }
                }
                sced.simpleColumnName.value to jPrim
            }.toMap()


        val otherSyntheticFields = allFields.filterIsInstance<SyntheticColumnEntityData<*>>()
            .map { sced ->
                val fkMetaData = fromToFkMap[sced.outEntity]!![entityEnum]!!
                val jsonObject = when (fkMetaData.relationType) {
                    RelationType.ONE_TO_ONE_MANDATORY -> {
                        val newUk = fkMetaData.fkCols.map { fkColsPair ->
                            val value = uk[fkColsPair.to.columnData().simpleColumnName.value]
                            fkColsPair.from.columnData().simpleColumnName.value to value!!
                        }
                            .toMap()

                        sced.simpleColumnName.value to genRecursive(
                            1,
                            fkMetaData.ukFrom!!.name,
                            newUk,
                            TypeJsonObjectEnum.OBJECT
                        )
                    }
                    RelationType.ONE_TO_ONE_OPTIONAL -> {
                        val newUk = fkMetaData.fkCols.map { fkColsPair ->
                            val value = uk[fkColsPair.to.columnData().simpleColumnName.value]
                            fkColsPair.from.columnData().simpleColumnName.value to value!!
                        }
                            .toMap()

                        sced.simpleColumnName.value to genRecursive(
                            1,
                            fkMetaData.ukFrom!!.name,
                            newUk,
                            TypeJsonObjectEnum.OBJECT
                        )
                    }
                    RelationType.MANY_TO_ONE -> {
                        val newUk = fkMetaData.fkCols.map { fkColsPair ->
                            val value = uk[fkColsPair.to.columnData().simpleColumnName.value]
                            fkColsPair.from.columnData().simpleColumnName.value to value!!
                        }
                            .toMap()

                        sced.simpleColumnName.value to JsonArray(
                            listOf(
                                genRecursive(
                                    1,
                                    fkMetaData.ukFrom!!.name,
                                    newUk,
                                    TypeJsonObjectEnum.COLLECTION
                                )
                            )
                        )
                        //
                    }
                }
                jsonObject
            }.toMap()

        val jsonObject: JsonObject =
            JsonObject(mapOf("origin" to JsonObject(ukJson.plus(otherSimpleFields))).plus(otherSyntheticFields))
        return jsonObject
    }


}