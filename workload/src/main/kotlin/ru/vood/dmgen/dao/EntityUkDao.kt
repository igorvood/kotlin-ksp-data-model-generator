package ru.vood.dmgen.dao

import kotlinx.serialization.json.Json
import org.springframework.jdbc.core.JdbcOperations
import org.springframework.stereotype.Repository
import ru.vood.dmgen.annotation.UkName
import ru.vood.dmgen.intf.EntityName
import ru.vood.dmgen.intf.IContextOf
import ru.vood.dmgen.intf.IEntity
import ru.vood.dmgen.intf.Serializer

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

//    final inline fun <reified T>  saveEntityUkDto(ukData: IContextOf< IEntity< T>>) {
//
//        saveEntityUk()
//        TODO("Not yet implemented")
//    }

}