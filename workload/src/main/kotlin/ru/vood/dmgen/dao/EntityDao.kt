package ru.vood.dmgen.dao

import org.springframework.jdbc.core.JdbcOperations
import org.springframework.stereotype.Repository
import ru.vood.dmgen.dao.dto.PKJsonVal
import ru.vood.dmgen.dao.dto.PayLoadJsonVal
import ru.vood.dmgen.intf.EntityName

@Repository
class EntityDao(
    private val jdbcOperations: JdbcOperations,
) {

    fun saveFullAggregateNoParent(
        pkJson: PKJsonVal,
        entityName: EntityName,
        entityJson: PayLoadJsonVal
    ) {
        jdbcOperations.update(
            """insert into entity_context(pk, entity_type, payload) VALUES (?, ?, ?) """,
            pkJson.value, entityName.value, entityJson.value
        )
    }

}