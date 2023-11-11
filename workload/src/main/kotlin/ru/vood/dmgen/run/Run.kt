package ru.vood.dmgen.run

import org.springframework.boot.CommandLineRunner
import org.springframework.jdbc.core.JdbcOperations
import org.springframework.stereotype.Service
import ru.vood.dmgen.dao.EntityDao
import ru.vood.dmgen.datamodel.runtime.dataclasses.DealParamOneToOneEntity
import ru.vood.dmgen.datamodel.runtime.dataclasses.context.DealParamOneToOne_Context_DealParamOneToOne_PK
import ru.vood.dmgen.datamodel.runtime.dataclasses.context.DealParamOneToOne_Context_DealParamOneToOne_UK
import ru.vood.dmgen.datamodel.valueClasses.DealId

@Service
class Run(
    val entity: EntityDao,
    val jdbcOperations: JdbcOperations
) : CommandLineRunner {
    override fun run(vararg args: String?) {
        jdbcOperations.update("delete from entity_context")

        val dealId = DealId("12")
        val paramDate = "asd"
        val entity1 = DealParamOneToOneEntity(dealId, paramDate)
        entity.saveEntity(entity1)

        val findByUk = entity.findByUk(DealParamOneToOne_Context_DealParamOneToOne_PK(dealId))
        println(findByUk)
        val findByUk2 =
            entity.findByUk<DealParamOneToOneEntity>(DealParamOneToOne_Context_DealParamOneToOne_UK(dealId, paramDate))
        println(findByUk2)
    }
}