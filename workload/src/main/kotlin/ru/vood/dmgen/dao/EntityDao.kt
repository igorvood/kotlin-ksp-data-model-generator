package ru.vood.dmgen.dao

import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json
import org.springframework.jdbc.core.JdbcOperations
import org.springframework.stereotype.Repository
import ru.vood.dmgen.datamodel.metaEnum.entityDataMap
import ru.vood.dmgen.datamodel.metaEnum.uniqueKeyMap
import ru.vood.dmgen.intf.EntityName
import ru.vood.dmgen.intf.IContextOf
import ru.vood.dmgen.intf.IEntity
import ru.vood.dmgen.intf.newIntf.EntityData
import ru.vood.dmgen.intf.newIntf.TypeUk
import ru.vood.dmgen.intf.newIntf.UKEntityData

@Repository
class EntityDao(
    val jdbcOperations: JdbcOperations
) {

    val json = Json

    final fun < T : IEntity<T>> saveEntity(entity: T) {
        val entityName = entity.designEntityName

        val entityData = entityDataMap[entityName]!! as EntityData<out IEntity<T>>
        val uks = uniqueKeyMap.values.filter { it.entity == entityName }

        val first = uks.filter { it.typeUk == TypeUk.PK }.first() as UKEntityData<IEntity<T>>

        val extractContext= first.extractContext(entity)
        val serializer = extractContext.ktSerializer() as KSerializer<IContextOf<IEntity<T>>>
        val serializer1 = entity.ktSerializer() as KSerializer<IEntity<T>>
//        val extractContext: IContextOf<IEntity<T>> = first.extractContext(entity)
//        val serializer: KSerializer<IContextOf<IEntity<T>>> = extractContext.ktSerializer()

        val pkJson = json.encodeToString(serializer, extractContext)

        val entityJson = json.encodeToString(serializer1, entity)


        jdbcOperations.update(
            """insert into entity_context(pk, entity_type, payload) VALUES (?, ?, ?) """,
            pkJson, entityName.value, entityJson
        )
    }

}