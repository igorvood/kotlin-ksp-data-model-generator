package ru.vood.dmgen.dao

import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json
import org.springframework.jdbc.core.JdbcOperations
import org.springframework.stereotype.Repository
import ru.vood.dmgen.datamodel.metaEnum.uniqueKeyMap
import ru.vood.dmgen.intf.IContextOf
import ru.vood.dmgen.intf.IEntity
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
        val pkDto= pkMeta.extractContext(entity)
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
//            val ukSerializer = ukData.ktSerializer() as KSerializer<IContextOf<T>>
//            val ukJson = Json.encodeToString(ukSerializer, ukData)
//            entityUkDao.saveEntityUk(entityName, ukData.ukName, pkJson, ukJson)

            entityUkDao.saveEntityUkDto(entityName, ukData, pkJson)

        }


    }

}