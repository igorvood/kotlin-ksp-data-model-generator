package ru.vood.dmgen.run

import org.springframework.boot.CommandLineRunner
import org.springframework.jdbc.core.JdbcOperations
import org.springframework.stereotype.Service
import ru.vood.dmgen.dao.EntityDao
import ru.vood.dmgen.datamodel.DealParamOneToOne
import ru.vood.dmgen.datamodel.runtime.dataclasses.DealParamOneToOneEntity
import ru.vood.dmgen.datamodel.valueClasses.DealId

@Service
class Run(
    val entity: EntityDao,
    val jdbcOperations: JdbcOperations
): CommandLineRunner {
    override fun run(vararg args: String?) {
        jdbcOperations.update("delete from entity_context")

        entity.saveEntity(DealParamOneToOneEntity(DealId("12"), "asd"))

    }
}