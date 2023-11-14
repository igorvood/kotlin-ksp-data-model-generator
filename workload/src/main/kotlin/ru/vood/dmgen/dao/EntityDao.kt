package ru.vood.dmgen.dao

import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json
import org.springframework.jdbc.core.JdbcOperations
import org.springframework.stereotype.Repository
import ru.vood.dmgen.datamodel.metaEnum.foreignKeyMap
import ru.vood.dmgen.datamodel.metaEnum.uniqueKeyMap
import ru.vood.dmgen.intf.IAggregate
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


    final inline fun <reified T : IAggregate<T>> saveAggregate(aggregate: T) {
        saveEntity(aggregate)

//        val simpleColumns = entitiesColumnsMap[aggregate.designEntityName]!!
//            .filter { col -> col.value.columnKind == ColumnKind.SIMPLE }
//        val entityName = aggregate.designEntityName
//        val uks = uniqueKeyMap.values.filter { it.entity == entityName }
//        val pkMeta = uks.first { it.typeUk == TypeUk.PK } as UKEntityData<T>
//        val pkDto = pkMeta.extractContext(aggregate)
//        val pkSerializer = pkDto.ktSerializer() as KSerializer<IContextOf<T>>
//        val entitySerializer = aggregate.ktSerializer() as KSerializer<IEntity<T>>

    }


    @Suppress("UNCHECKED_CAST")
    final inline fun <reified T : IEntity<T>> saveEntity(entity: T) {
        val entityName = entity.designEntityName

        // тут очень не оптимально, нужно собрать мапу с правильным key
        foreignKeyMap.values
            .filter { it.fromEntity == entityName }
            .forEach { we ->
                val function = we.extractContext as (T) -> String
                we.uk to function(entity)
                entityUkDao.existUk(we.uk, function(entity))
            }


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

    @Suppress("UNCHECKED_CAST")
    final inline fun <reified T : IEntity<T>> findByUk(uk: IContextOf<T>): IEntity<out T> {
        val ktSerializer = uk.ktSerializer() as KSerializer<IContextOf<T>>
        val ktEntitySerializer = uk.ktEntitySerializer as KSerializer<T>
        val ukJson = Json.encodeToString(ktSerializer, uk)
        val query = jdbcOperations.query(
            """
                select e.payload
                    from entity_uk_context uc
                join entity_context e on (uc.entity_type, uc.pk) = ((e.entity_type, e.pk))
                where uc.entity_type_uk = ? and uc.uk = ?
                """,
            { rs, _ ->
                json.decodeFromString(ktEntitySerializer, rs.getString(1))
            },
            uk.ukName.value, ukJson
        )
        return query[0]
    }


}

