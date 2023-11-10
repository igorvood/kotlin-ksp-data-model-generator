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
    val jdbcOperations: JdbcOperations,
    val entityUkDao: EntityUkDao
) {

    val json = Json

    final inline fun <reified T : IEntity<T>> saveEntity(entity: T) {
        val entityName = entity.designEntityName
        val uks = uniqueKeyMap.values.filter { it.entity == entityName }
        val pkMeta = uks.first { it.typeUk == TypeUk.PK } as UKEntityData<T>
        val pkDto = pkMeta.extractContext(entity)
        val pkSerializer = pkDto.ktSerializer() as KSerializer<IContextOf<T>>
        val entitySerializer = entity.ktSerializer() as KSerializer<IEntity<T>>
        val pkJson = json.encodeToString(pkSerializer, pkDto)
        val entityJson = json.encodeToString(entitySerializer, entity)

        jdbcOperations.update(
            """insert into entity_context(pk, entity_type, payload) VALUES (?, ?, ?) """,
            pkJson, entityName.value, entityJson
        )

        uks.forEach { ukMeta ->
            val ukMetaData = ukMeta as UKEntityData<T>
            val ukData = ukMetaData.extractContext(entity)
            entityUkDao.saveEntityUkDto(entityName, ukData, pkJson)
        }
    }

    final inline fun <reified T : IEntity<T>> findByUk(uk: IContextOf<T>): IEntity<out T> {
        val ktSerializer = uk.ktSerializer() as KSerializer<IContextOf<T>>
        val encodeToString = Json.encodeToString(ktSerializer, uk)
        val ukName = uk.ukName
        val query = jdbcOperations.query(
            """select e.entity_type, e.pk, e.payload
                from entity_uk_context uc
                join entity_context e on (uc.entity_type, uc.pk) = ((e.entity_type, e.pk))
                where uc.entity_type_uk = ? and uc.uk = ?
                """,
            { rs, _ -> ET(rs.getString(1), rs.getString(2), rs.getString(3)) },
            ukName.value, encodeToString
        )
        val et = query[0]
        val entityData = entityDataMap[EntityName(et.entity_type)] as EntityData<T>
        val serializer = entityData.serializer
        return json.decodeFromString(serializer, et.payload)
    }

}

data class ET(
    val entity_type: String,
    val pk: String,
    val payload: String
)