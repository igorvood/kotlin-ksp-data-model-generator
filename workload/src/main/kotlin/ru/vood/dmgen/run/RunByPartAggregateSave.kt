package ru.vood.dmgen.run

import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.core.annotation.Order
import org.springframework.jdbc.core.JdbcOperations
import org.springframework.stereotype.Service
import ru.vood.dmgen.dao.EntityDaoController
import ru.vood.dmgen.datamodel.*
import ru.vood.dmgen.datamodel.a.DealEntity
import ru.vood.dmgen.datamodel.a.DealSynthetic
import ru.vood.dmgen.datamodel.a.Deal_PKContext
import ru.vood.dmgen.datamodel.b.DealExtendDataEntity
import ru.vood.dmgen.datamodel.b.DealExtendDataSynthetic
import ru.vood.dmgen.datamodel.valueClasses.DealId
import ru.vood.dmgen.intf.IEntitySynthetic

@Service
@Order(200)
class RunByPartAggregateSave(
    val entity: EntityDaoController,
    val jdbcOperations: JdbcOperations
) : CommandLineRunner {

    private val log = LoggerFactory.getLogger(this.javaClass)
    override fun run(vararg args: String?) {
        log.info("=============RUN BY part Aggregate save and find ================================")
        val json = Json

        val serializer: KSerializer<Any> = D.serializer() as KSerializer<Any>

        jdbcOperations.update("delete from entity_context")

        val dealId = DealId("12")
        val paramDate = "asd"
        val dealParamOneToOneEntity = DealParamOneToOneSynthetic(
            DealParamOneToOneEntity(dealId, paramDate), InnerToDealParamOneToOneSynthetic(
                InnerToDealParamOneToOneEntity(dealId, paramDate)
            )
        )

        val aggregate: IEntitySynthetic<DealEntity> =
            DealSynthetic(
                DealEntity(dealId, "asd", null, true, null), dealParamOneToOneEntity, null, setOf(
                    DealParamSetSynthetic(DealParamSetEntity(dealId, 1, "1")),
                    DealParamSetSynthetic(DealParamSetEntity(dealId, 2, "2")),
                )
            )
        val dealExtendDataEntity = DealExtendDataSynthetic(DealExtendDataEntity(dealId, "extendData"))
        entity.saveAggregateByPart(aggregate)
        entity.saveAggregateByPart(dealExtendDataEntity)


        val findByUk1 = entity.findSyntheticEntityCollectPartByUk<DealEntity, DealSynthetic>(Deal_PKContext(dealId))
        val findByUk2 = entity.findSyntheticEntityCollectPartByUk(Deal_PKContext(dealId))

        val findByUk3 = entity.findSyntheticEntityCollectPartByUk<DealParamOneToOneEntity, DealParamOneToOneSynthetic>(DealParamOneToOne_PKContext(dealId))

        log.info(aggregate.toString())
        log.info(findByUk1.toString())
        log.info(findByUk2.toString())
        log.info(findByUk3.toString())


    }
}

@kotlinx.serialization.Serializable
data class D(val df: String)