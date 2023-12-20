package ru.vood.dmgen.run

import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.core.annotation.Order
import org.springframework.jdbc.core.JdbcOperations
import org.springframework.stereotype.Service
import ru.vood.dmgen.dao.EntityDaoController
import ru.vood.dmgen.datamodel.a.DealEntity
import ru.vood.dmgen.datamodel.a.Deal_PKContext
import ru.vood.dmgen.datamodel.valueClasses.DealId

@Service
@Order(300)
class RunEntitySave(
    val entity: EntityDaoController,
    val jdbcOperations: JdbcOperations
) : CommandLineRunner {

    private val log = LoggerFactory.getLogger(this.javaClass)
    override fun run(vararg args: String?) {
        jdbcOperations.update("delete from entity_context")
        log.info("=============RUN entity save and find ================================")
        val dealId = DealId("12")
        val paramDate = "asd"
//        val dealParamOneToOneEntity = DealParamOneToOneEntity(dealId, paramDate)
//        entity.saveEntity(dealParamOneToOneEntity)

//        val findByUk1 = entity.findEntityByUk(DealParamOneToOne_PKContext(dealId))
//        val findByUk2 =
//            entity.findEntityByUk<DealParamOneToOneEntity>(DealParamOneToOne_UKContext(dealId, paramDate))


        entity.saveEntity(DealEntity(dealId, "asd", null, true, null))

        val findByUk = entity.findEntityByUk(Deal_PKContext(dealId))
        log.info("$findByUk")

    }
}