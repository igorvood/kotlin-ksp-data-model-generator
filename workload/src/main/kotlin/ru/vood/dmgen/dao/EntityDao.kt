package ru.vood.dmgen.dao


import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json
import org.springframework.jdbc.core.JdbcOperations
import org.springframework.stereotype.Repository
import ru.vood.dmgen.datamodel.metaEnum.foreignKeyMap
import ru.vood.dmgen.intf.*
import ru.vood.dmgen.intf.newIntf.Simple
import ru.vood.dmgen.intf.newIntf.UKEntityData
import ru.vood.dmgen.meta.DerivativeColumns
import ru.vood.dmgen.meta.DerivativeColumns.entitiesSyntheticColumnsMap
import ru.vood.dmgen.meta.DerivativeUk.entitiesUkMap

@Repository
class EntityDao(
    val jdbcOperations: JdbcOperations,
    val entityUkDao: EntityUkDao
) {

    val json = Json


    final inline fun <T : IEntityOrigin<T>> saveAggregate(aggregate: IEntitySynthetic<T>) {
        val entityName = aggregate.designEntityName

        val indexesDto = entitiesUkMap[entityName] ?: error("Почему то не найдена сущность ${entityName.value}")

        val pkMeta = indexesDto.pkEntityData as UKEntityData<T>
        val pkDto = pkMeta.extractContext(aggregate.origin)
        val pkSerializer = pkDto.ktSerializer() as KSerializer<IContextOf<T>>
        val entitySerializer = aggregate.ktSerializer() as KSerializer<IEntitySynthetic<T>>
        val pkJson = json.encodeToString(pkSerializer, pkDto)
        val entityJson = json.encodeToString(entitySerializer, aggregate)

        jdbcOperations.update(
            """insert into entity_context(pk, entity_type, payload) VALUES (?, ?, ?) """,
            pkJson, entityName.value, entityJson
        )


        indexesDto.ukSet.plus(indexesDto.pkEntityData)
            .forEach { ukMeta ->
                val ukMetaData = ukMeta as UKEntityData<T>
                val ukData = ukMetaData.extractContext(aggregate.origin)
                entityUkDao.saveEntityUkDto(entityName, ukData, pkJson)
            }
    }

    final inline fun <T : IEntityOrigin<T>> saveAggregateByPart(aggregate: IEntitySynthetic<T>) {
        val entityName = aggregate.designEntityName

        val indexesDto = entitiesUkMap[entityName] ?: error("Почему то не найдена сущность ${entityName.value}")

        val pkMeta = indexesDto.pkEntityData as UKEntityData<T>
        val pkDto = pkMeta.extractContext(aggregate.origin)
        val pkSerializer = pkDto.ktSerializer() as KSerializer<IContextOf<T>>
        val entitySerializer = aggregate.ktSerializer() as KSerializer<IEntitySynthetic<T>>
        val pkJson = json.encodeToString(pkSerializer, pkDto)
        val entityJson = json.encodeToString(entitySerializer, aggregate)

        jdbcOperations.update(
            """insert into entity_context(pk, entity_type, payload) VALUES (?, ?, ?) """,
            pkJson, entityName.value, entityJson
        )


        indexesDto.ukSet.plus(indexesDto.pkEntityData)
            .forEach { ukMeta ->
                val ukMetaData = ukMeta as UKEntityData<T>
                val ukData = ukMetaData.extractContext(aggregate.origin)
                entityUkDao.saveEntityUkDto(entityName, ukData, pkJson)
            }


        val map = DerivativeColumns.entitiesColumnsMap[aggregate.designEntityName]
            ?.entries
            ?.filter { it.value.iColKind !is Simple }?.map { it.key to it.value }


        val entitiesSyntheticColumnsMap1 = entitiesSyntheticColumnsMap

//
        val size = entitiesSyntheticColumnsMap1.size
//        saveEntity(aggregate.origin)
    }


    @Suppress("UNCHECKED_CAST")
    final inline fun <reified T : IEntityOrigin<T>> saveEntity(entity: T) {
        val entityName = entity.designEntityName

        // тут очень не оптимально, нужно собрать мапу с правильным key
        foreignKeyMap.values
            .filter { it.fromEntity == entityName }
            .forEach { we ->
                val fkContextFunction = we.extractJsonContext as (T) -> IContextOf<out IEntityOrigin<*>>
                val fkContextFunction1 = fkContextFunction(entity).toJson(Json)
                entityUkDao.existUk(we.uk, fkContextFunction1.value)
            }


        val indexesDto = entitiesUkMap[entityName] ?: error("Почему то не найдена сущность ${entityName.value}")

        val pkMeta = indexesDto.pkEntityData as UKEntityData<T>
        val pkDto = pkMeta.extractContext(entity)
        val pkSerializer = pkDto.ktSerializer() as KSerializer<IContextOf<T>>
        val entitySerializer = entity.ktSerializer() as KSerializer<IEntityOrigin<T>>
        val pkJson = json.encodeToString(pkSerializer, pkDto)
        val entityJson = json.encodeToString(entitySerializer, entity)

        jdbcOperations.update(
            """insert into entity_context(pk, entity_type, payload) VALUES (?, ?, ?) """,
            pkJson, entityName.value, entityJson
        )


        indexesDto.ukSet.plus(indexesDto.pkEntityData)
            .forEach { ukMeta ->
                val ukMetaData = ukMeta as UKEntityData<T>
                val ukData = ukMetaData.extractContext(entity)
                entityUkDao.saveEntityUkDto(entityName, ukData, pkJson)
            }
    }


    @Suppress("UNCHECKED_CAST")
    final inline fun <reified T : IEntityOrigin<T>> findSyntheticEntityByUk(uk: IContextOf<T>): IEntitySynthetic<out IEntityOrigin<out T>> {
        val ktSerializer = uk.ktSerializer() as KSerializer<IContextOf<T>>
        val ktEntitySerializer = uk.ktSyntheticEntitySerializer as KSerializer<IEntitySynthetic<T>>
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

        if (query.size == 1)
            query[0]
        else error("Not found uk ${uk.ukName.value} with value ${ukJson}")

        return query[0]
    }

    @Suppress("UNCHECKED_CAST")
    final inline fun <reified T : IEntityOrigin<T>> findEntityByUk(uk: IContextOf<T>): IEntityOrigin<out T> {
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

        if (query.size == 1)
            query[0]
        else error("Not found uk ${uk.ukName.value} with value ${ukJson}")

        return query[0]
    }


}

