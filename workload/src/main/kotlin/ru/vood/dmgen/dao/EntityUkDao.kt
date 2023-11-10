package ru.vood.dmgen.dao

import kotlinx.serialization.json.Json
import org.springframework.jdbc.core.JdbcOperations
import org.springframework.stereotype.Repository
import ru.vood.dmgen.intf.EntityName
import ru.vood.dmgen.intf.IContextOf
import ru.vood.dmgen.intf.IEntity

@Repository
class EntityUkDao(
    val jdbcOperations: JdbcOperations
) {

    val json = Json

    //    IContextOf<ENT : IEntity<out ENT>>
    final fun  saveEntityUk(contextOf: EntityName) {

//        val ktSerializer = contextOf.ktSerializer()
//        val entityName = entity.designEntityName
//        val uks = uniqueKeyMap.values.filter { it.entity == entityName }
//        val pkMeta = uks.first { it.typeUk == TypeUk.PK } as UKEntityData<IEntity<T>>
//        val pkDto= pkMeta.extractContext(entity)
//        val pkSerializer = pkDto.ktSerializer() as KSerializer<IContextOf<IEntity<T>>>
//        val entitySerializer = entity.ktSerializer() as KSerializer<IEntity<T>>
//        val pkJson = json.encodeToString(pkSerializer, pkDto)
//        val entityJson = json.encodeToString(entitySerializer, entity)
//
//        jdbcOperations.update(
//            """insert into entity_uk_context(entity_type, entity_type_uk, pk, uk) VALUES (?, ?, ?, ?) """,
//            pkJson, entityName.value, entityJson
//        )

    }

}