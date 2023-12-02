package ru.vood.dmgen.dao

import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json
import org.springframework.jdbc.core.JdbcOperations
import org.springframework.stereotype.Repository
import ru.vood.dmgen.annotation.UkName
import ru.vood.dmgen.intf.EntityName
import ru.vood.dmgen.intf.IContextOf
import ru.vood.dmgen.intf.IEntityOrigin

@Repository
class EntityUkDao(
    val jdbcOperations: JdbcOperations
) {

    val json = Json

    final fun saveEntityUk(contextOf: EntityName, ukName: UkName, pkJson: String, ukJson: String) {
        jdbcOperations.update(
            """insert into entity_uk_context(entity_type, entity_type_uk, pk, uk) VALUES (?, ?, ?, ?) """,
            contextOf.value, ukName.value, pkJson, ukJson
        )

    }

    final inline fun <reified T : IEntityOrigin<T>> saveEntityUkDto(
        entityName: EntityName,
        ukData: IContextOf<T>,
        pkJson: String
    ) {
        val ukSerializer = ukData.ktSerializer() as KSerializer<IContextOf<T>>
        val ukJson = Json.encodeToString(ukSerializer, ukData)
        saveEntityUk(entityName, ukData.ukName, pkJson, ukJson)
    }


    final fun existUk(uk: UkName, function: String): Boolean {
//        jdbcOperations.queryForObject()
        val queryForObject = jdbcOperations.queryForObject(
            """select count(1) from entity_uk_context where entity_type_uk = ? and uk = ? """,
            Int::class.java,
            uk.value, function
        )
        val let = queryForObject ?: 0
        val b = if (let != 1) {
            error("вай - вай - вай - нет форена ${function} для uk ${uk.value}")
        } else true
        return b
    }
}