package ru.vood.dmgen.run

import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.core.annotation.Order
import org.springframework.jdbc.core.JdbcOperations
import org.springframework.stereotype.Service
import ru.vood.dmgen.dao.EntityDaoController
import ru.vood.dmgen.datamodel.*
import ru.vood.dmgen.datamodel.a.DealDetail
import ru.vood.dmgen.datamodel.a.DealEntity
import ru.vood.dmgen.datamodel.a.Deal_PKContext
import ru.vood.dmgen.datamodel.b.DealExtendDataDetail
import ru.vood.dmgen.datamodel.b.DealExtendDataEntity
import ru.vood.dmgen.datamodel.valueClasses.DealId
import ru.vood.dmgen.intf.IEntityDetail

@Service
@Order(210)
class RunFullAggregateSave(
    val entity: EntityDaoController,
    val jdbcOperations: JdbcOperations
) : CommandLineRunner {

    private val log = LoggerFactory.getLogger(this.javaClass)
    override fun run(vararg args: String?) {

        jdbcOperations.update("delete from entity_context")

        val dealId = DealId("12")
        val paramDate = "asd"
        val dealParamOneToOneEntity = DealParamOneToOneDetail(
            DealParamOneToOneEntity(dealId, paramDate), InnerToDealParamOneToOneDetail(
                InnerToDealParamOneToOneEntity(dealId, paramDate)
            )
        )

        val aggregate: IEntityDetail<DealEntity> =
            DealDetail(DealEntity(dealId, "asd", null, true, null), dealParamOneToOneEntity, null, setOf())
        val dealExtendDataEntity = DealExtendDataDetail(DealExtendDataEntity(dealId, "jhvjkhfg"))
        entity.saveAggregate(aggregate)
        entity.saveAggregate(dealExtendDataEntity)


        val findByUk1 = entity.findSyntheticEntityOneRowByUk(Deal_PKContext(dealId))
        log.info("=============RUN FULL  Aggregate save and find ================================")
        log.info(findByUk1.toString())

    }
}

