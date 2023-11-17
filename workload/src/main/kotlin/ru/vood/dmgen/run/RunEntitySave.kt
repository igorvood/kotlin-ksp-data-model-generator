package ru.vood.dmgen.run

import org.springframework.boot.CommandLineRunner
import org.springframework.jdbc.core.JdbcOperations
import org.springframework.stereotype.Service
import ru.vood.dmgen.dao.EntityDao
import ru.vood.dmgen.datamodel.runtime.dataclasses.DealEntity
import ru.vood.dmgen.datamodel.runtime.dataclasses.DealParamOneToOneEntity
import ru.vood.dmgen.datamodel.runtime.dataclasses.context.DealParamOneToOne_PKContext
import ru.vood.dmgen.datamodel.runtime.dataclasses.context.DealParamOneToOne_UKContext
import ru.vood.dmgen.datamodel.runtime.dataclasses.context.Deal_PKContext
import ru.vood.dmgen.datamodel.valueClasses.DealId

@Service
class RunEntitySave(
    val entity: EntityDao,
    val jdbcOperations: JdbcOperations
) : CommandLineRunner {
    override fun run(vararg args: String?) {
        jdbcOperations.update("delete from entity_context")

        val dealId = DealId("12")
        val paramDate = "asd"
        val dealParamOneToOneEntity = DealParamOneToOneEntity(dealId, paramDate)
//        entity.saveEntity(dealParamOneToOneEntity)

//        val findByUk = entity.findByUk(DealParamOneToOne_PKContext(dealId))
//        println(findByUk)
//        val findByUk2 =
//            entity.findByUk<DealParamOneToOneEntity>(DealParamOneToOne_UKContext(dealId, paramDate))
//        println(findByUk2)

        entity.saveEntity(DealEntity(dealId, "asd", null, true, null, dealParamOneToOneEntity, null, setOf()))

        val findByUk1 = entity.findByUk(Deal_PKContext(dealId))

        println(findByUk1)

    }
}