package ru.vood.mock.external.reply

import kotlinx.serialization.json.Json
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import ru.vood.dmgen.annotation.FlowEntityType
import ru.vood.dmgen.datamodel.deal.DealDetail
import ru.vood.dmgen.datamodel.metaEnum.UniqueKeyEnum
import ru.vood.dmgen.datamodel.metaEnum.UniqueKeyEnum.Companion.uniqueKeyMap
import ru.vood.mock.external.reply.data.DataOk
import java.util.stream.Stream

@Disabled
internal class ReplyGeneratorImplTest {

    private val replyGeneratorImpl = ReplyGeneratorImpl()

    val asda = Json { }

    @ParameterizedTest
    @MethodSource("ru.vood.mock.external.reply.ReplyGeneratorImplTest#testCases")
    fun generate(uk: UniqueKeyEnum) {
        val ukData = uk.ukData()
        val ukMap = ukValues[uk] ?: error("нет начального зн для первичного ключа $uk с колонками ${ukData.columns.map { it.value }}")


        val generate = replyGeneratorImpl.generateAggregate(1, uk.name, ukMap)
        val map = generate.map {
            println(generate)
            val decodeFromString = asda.decodeFromString(ukData.entity.entityData().serializerSynthetic, (it.payload as DataOk).payload)
            println(1)
        }

    }

    companion object{
        val testCaseList = uniqueKeyMap.values
            .filter { ukEnum -> ukEnum.entity.entityData().entityType==FlowEntityType.AGGREGATE }
            .map { it.ukName }

        @JvmStatic
        private fun testCases(): Stream<Arguments> {
            return testCaseList
                .stream()
                .map { Arguments.of(it) }
        }

        val ukValues = mapOf(
            UniqueKeyEnum.Deal_PK to mapOf("id" to "1"),
            UniqueKeyEnum.DealExtendData_PK to mapOf("dealId" to "1"),
            UniqueKeyEnum.Product_PK to mapOf("dealId" to "1", "id" to "1"),
            UniqueKeyEnum.ProductPayments_PK to mapOf("dealId" to "1", "productId" to "1"),
        )
    }

}