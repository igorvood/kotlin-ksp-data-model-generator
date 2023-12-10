package ru.vood.dmgen.dao

import kotlinx.serialization.KSerializer
import org.springframework.jdbc.core.JdbcOperations
import org.springframework.stereotype.Repository
import ru.vood.dmgen.annotation.UkName
import ru.vood.dmgen.dao.dto.PKJsonVal
import ru.vood.dmgen.dao.dto.PayLoadJsonVal
import ru.vood.dmgen.dao.dto.UKJsonVal
import ru.vood.dmgen.intf.EntityName
import ru.vood.dmgen.serial.ModelJsonSerializer

@Repository
class EntityDao(
    private val jdbcOperations: JdbcOperations,
    val serializer: ModelJsonSerializer,
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

    fun <TT> findEnt(
        ktEntitySerializer: KSerializer<TT>,
        ukName: UkName,
        ukJson: UKJsonVal
    ): TT {
        val query = jdbcOperations.query(
            """
                        select e.payload
                            from entity_uk_context uc
                        join entity_context e on (uc.entity_type, uc.pk) = ((e.entity_type, e.pk))
                        where uc.entity_type_uk = ? and uc.uk = ?
                        """,
            { rs, _ ->
                serializer.modelJsonSerializer.decodeFromString(ktEntitySerializer, rs.getString(1))
            },
            ukName.value, ukJson.value
        )
        return if (query.size == 1)
            query[0]
        else error("Not found uk ${ukName.value} with value ${ukJson.value}")
    }

}