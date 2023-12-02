package ru.vood.dmgen.run

import org.springframework.boot.CommandLineRunner
import org.springframework.jdbc.core.JdbcOperations
import org.springframework.stereotype.Service
import ru.vood.dmgen.dao.EntityDao
import ru.vood.dmgen.datamodel.runtime.dataclasses.context.Deal_PKContext
import ru.vood.dmgen.datamodel.runtime.dataclassesOrigin.DealEntity
import ru.vood.dmgen.datamodel.runtime.dataclassesOrigin.DealExtendDataEntity
import ru.vood.dmgen.datamodel.runtime.dataclassesOrigin.DealParamOneToOneEntity
import ru.vood.dmgen.datamodel.runtime.dataclassesSynthetic.DealExtendDataSynthetic
import ru.vood.dmgen.datamodel.runtime.dataclassesSynthetic.DealParamOneToOneSynthetic
import ru.vood.dmgen.datamodel.runtime.dataclassesSynthetic.DealSynthetic
import ru.vood.dmgen.datamodel.valueClasses.DealId

@Service
class RunAggregateSave(
    val entity: EntityDao,
    val jdbcOperations: JdbcOperations
) : CommandLineRunner {
    override fun run(vararg args: String?) {
        jdbcOperations.update("delete from entity_context")

        val dealId = DealId("12")
        val paramDate = "asd"
        val dealParamOneToOneEntity = DealParamOneToOneSynthetic(DealParamOneToOneEntity(dealId, paramDate))

        val aggregate = DealSynthetic(DealEntity(dealId, "asd", null, true, null), dealParamOneToOneEntity, null, setOf())
//        entity.saveAggregate(aggregate)
//        val dealExtendDataEntity = DealExtendDataEntity(DealId("11"), "jhvjkhfg")
        val dealExtendDataEntity = DealExtendDataSynthetic(DealExtendDataEntity( dealId, "jhvjkhfg"))
//        entity.saveAggregate(dealExtendDataEntity)
//        entity.saveAggregate(aggregate)

//        val findByUk1 = entity.findByUk(Deal_PKContext(dealId))

//        println(findByUk1)

    }
}