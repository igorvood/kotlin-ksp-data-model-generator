package ru.vood.dmgen.run

import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json
import org.slf4j.LoggerFactory
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

import ru.vood.dmgen.intf.IEntitySynthetic

@Service
class RunAggregateSave(
    val entity: EntityDao,
    val jdbcOperations: JdbcOperations
) : CommandLineRunner {

    private val log = LoggerFactory.getLogger(this.javaClass)
    override fun run(vararg args: String?) {
        val json = Json

        val serializer: KSerializer<Any> = D.serializer() as KSerializer<Any>

        val encodeToString = json.encodeToString(serializer, D("ASd"))

        jdbcOperations.update("delete from entity_context")

        val dealId = DealId("12")
        val paramDate = "asd"
        val dealParamOneToOneEntity = DealParamOneToOneSynthetic(DealParamOneToOneEntity(dealId, paramDate))

        val aggregate: IEntitySynthetic<DealEntity> =
            DealSynthetic(DealEntity(dealId, "asd", null, true, null), dealParamOneToOneEntity, null, setOf())
        val dealExtendDataEntity = DealExtendDataSynthetic(DealExtendDataEntity(dealId, "jhvjkhfg"))
        entity.saveAggregateByPart(aggregate)
        entity.saveAggregateByPart(dealExtendDataEntity)



        val findByUk1 = entity.findSyntheticEntityByUk(Deal_PKContext(dealId))
        log.info("=============RUN Aggregate save and find ================================")
        log.info(findByUk1.toString())

    }
}

@kotlinx.serialization.Serializable
data class D(val df: String)