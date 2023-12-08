package ru.vood.dmgen.dao


import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json
import org.springframework.jdbc.core.JdbcOperations
import org.springframework.stereotype.Repository
import ru.vood.dmgen.datamodel.metaEnum.entityDataMap
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


    final fun <T : IEntityOrigin> saveAggregate(aggregate: IEntitySynthetic<T>) {
        val entityName = aggregate.designEntityName
        val indexesDto = entitiesUkMap[entityName] ?: error("Почему то не найдена сущность ${entityName.value}")
        val pkSerializer = indexesDto.pkEntityData.serializer as KSerializer<Any>
        val entityData = entityDataMap[entityName] ?: error("Почему то не найдена сущность ${entityName.value}")
        val serializerSynthetic = entityData.serializerSynthetic as KSerializer<Any>
        checkFk(entityName, aggregate.origin)


        val pkMeta = indexesDto.pkEntityData as UKEntityData<T>
        val pkDto = pkMeta.extractContext(aggregate.origin)
        val pkJson = json.encodeToString(pkSerializer, pkDto)
        val entityJson = json.encodeToString(serializerSynthetic, aggregate as Any)

        jdbcOperations.update(
            """insert into entity_context(pk, entity_type, payload) VALUES (?, ?, ?) """,
            pkJson, entityName.value, entityJson
        )


        indexesDto.ukAndPkMap.values
            .forEach { ukMeta ->
                val ukMetaData = ukMeta as UKEntityData<T>
                val ukData = ukMetaData.extractContext(aggregate.origin)
                entityUkDao.saveEntityUkDto(entityName, ukData, pkJson, ukMetaData)
            }
    }

    final fun <T : IEntityOrigin> saveAggregateByPart(aggregate: IEntitySynthetic<T>) {
        val entityName = aggregate.designEntityName
        val indexesDto = entitiesUkMap[entityName] ?: error("Почему то не найдена сущность ${entityName.value}")
        val pkSerializer = indexesDto.pkEntityData.serializer as KSerializer<Any>
        val entityData = entityDataMap[entityName] ?: error("Почему то не найдена сущность ${entityName.value}")
        val entitySerializer = entityData.serializer as KSerializer<Any>

        checkFk(entityName, aggregate.origin)


        val pkMeta = indexesDto.pkEntityData as UKEntityData<T>
        val pkDto = pkMeta.extractContext(aggregate.origin)
        val pkJson = json.encodeToString(pkSerializer, pkDto)
        val entityJson = json.encodeToString(entitySerializer, aggregate.origin)

        jdbcOperations.update(
            """insert into entity_context(pk, entity_type, payload) VALUES (?, ?, ?) """,
            pkJson, entityName.value, entityJson
        )


        indexesDto.ukAndPkMap.values
            .forEach { ukMeta ->
                val ukMetaData = ukMeta as UKEntityData<T>
                val ukData = ukMetaData.extractContext(aggregate.origin)
                entityUkDao.saveEntityUkDto(entityName, ukData, pkJson, ukMetaData)
            }


        val childEntityNames = DerivativeColumns.entitiesColumnsMap[aggregate.designEntityName]
            ?.entries
            ?.filter { it.value.iColKind !is Simple }?.map { it.value.outEntity!! }
            ?.map { it to aggregate.syntheticField(it) }
            ?.filter { it.second.isNotEmpty() }
            ?.toMap()
            ?: mapOf()

        saveChildEntities(childEntityNames)


        val entitiesSyntheticColumnsMap1 = entitiesSyntheticColumnsMap

//
        val size = entitiesSyntheticColumnsMap1.size
//        saveEntity(aggregate.origin)
    }

    fun saveChildEntities(childEntityNames: Map<EntityName, Set<IEntitySynthetic<out IEntityOrigin>>>) {
        childEntityNames.map { entry ->
            val entityName = entry.key
            val entitySynthetics = entry.value
            val entityData = entityDataMap[entityName] ?: error("Почему то не найдена сущность ${entityName.value}")
            val indexesDto = entitiesUkMap[entityName] ?: error("Почему то не найдена сущность ${entityName.value}")


            entitySynthetics.forEach { synth: IEntitySynthetic<out IEntityOrigin> ->
                val pkMeta: UKEntityData<IEntityOrigin> = indexesDto.pkEntityData as UKEntityData<IEntityOrigin>
                val origin = synth.origin
                val pkDto = pkMeta.extractContext(origin)
                val pkSerializer = pkMeta.serializer as KSerializer<Any>
                val pkJson = json.encodeToString(pkSerializer, pkDto)

                val entitySerializer = entityData.serializer as KSerializer<Any>
                val entityJson = json.encodeToString(entitySerializer, synth.origin)

                jdbcOperations.update(
                    """insert into entity_context(pk, entity_type, payload) VALUES (?, ?, ?) """,
                    pkJson, entityName.value, entityJson
                )

                indexesDto.ukAndPkMap.values
                .forEach { ukMeta ->
                    val ukMetaData = ukMeta as UKEntityData<IEntityOrigin>
                    val ukData = ukMetaData.extractContext(origin)
                    entityUkDao.saveEntityUkDto(entityName, ukData, pkJson, ukMetaData)
                    println(ukMetaData)
                }
//
            }


//
//
//            jdbcOperations.update(
//                """insert into entity_context(pk, entity_type, payload) VALUES (?, ?, ?) """,
//                pkJson, entityName.value, entityJson
//            )
//
//
//            indexesDto.ukSet.plus(indexesDto.pkEntityData)
//                .forEach { ukMeta ->
//                    val ukMetaData = ukMeta as UKEntityData<T>
//                    val ukData = ukMetaData.extractContext(aggregate.origin)
//                    entityUkDao.saveEntityUkDto(entityName, ukData, pkJson)
//                }

        }

        println(1)

    }


    @Suppress("UNCHECKED_CAST")
    final inline fun <reified T : IEntityOrigin> saveEntity(entity: T) {
        val entityName = entity.designEntityName
        val indexesDto = entitiesUkMap[entityName] ?: error("Почему то не найдена сущность ${entityName.value}")
        val pkSerializer = indexesDto.pkEntityData.serializer as KSerializer<Any>
        val entityData = entityDataMap[entityName] ?: error("Почему то не найдена сущность ${entityName.value}")
        val entitySerializer = entityData.serializer as KSerializer<Any>


        // тут очень не оптимально, нужно собрать мапу с правильным key
        checkFk(entityName, entity)


        val pkMeta = indexesDto.pkEntityData as UKEntityData<T>
        val pkDto = pkMeta.extractContext(entity)
        val pkJson = json.encodeToString(pkSerializer, pkDto)
        val entityJson = json.encodeToString(entitySerializer, entity)

        jdbcOperations.update(
            """insert into entity_context(pk, entity_type, payload) VALUES (?, ?, ?) """,
            pkJson, entityName.value, entityJson
        )


        indexesDto.ukAndPkMap.values
            .forEach { ukMeta ->
                val ukMetaData = ukMeta as UKEntityData<T>
                val ukData = ukMetaData.extractContext(entity)
                entityUkDao.saveEntityUkDto(entityName, ukData, pkJson, ukMetaData)
            }
    }

    fun <T : IEntityOrigin> checkFk(entityName: EntityName, entity: T) {
        // тут очень не оптимально, нужно собрать мапу с правильным key
        foreignKeyMap.values
            .filter { it.fromEntity == entityName }
            .forEach { we ->
                val fkContextFunction = we.extractJsonContext as (T) -> IContextOf<out IEntityOrigin>

//                val fkContextFunction1 = fkContextFunction(entity).toJson(Json)
//                entityUkDao.existUk(we.uk, fkContextFunction1.value)
            }
    }

    final inline fun <reified T : IEntityOrigin> findSyntheticEntityCollectPartByUk(uk: IContextOf<T>): IEntitySynthetic<out IEntityOrigin> {
        val entityName = uk.designEntityName
        val indexesDto = entitiesUkMap[entityName] ?: error("Почему то не найдена сущность ${entityName.value}")
        val ktSerializer = indexesDto.pkEntityData.serializer as KSerializer<IContextOf<T>>
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

        println(1)

        TODO()

    }

    @Suppress("UNCHECKED_CAST")
    final inline fun <reified T : IEntityOrigin> findSyntheticEntityOneRowByUk(uk: IContextOf<T>): IEntitySynthetic<out IEntityOrigin> {
        val entityName = uk.designEntityName
        val indexesDto = entitiesUkMap[entityName] ?: error("Почему то не найдена сущность ${entityName.value}")
        val ktSerializer = indexesDto.pkEntityData.serializer as KSerializer<IContextOf<T>>
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
    final inline fun <reified T : IEntityOrigin> findEntityByUk(uk: IContextOf<T>): IEntityOrigin {
        val entityName = uk.designEntityName
        val indexesDto = entitiesUkMap[entityName] ?: error("Почему то не найдена сущность ${entityName.value}")

        val ktSerializer = indexesDto.pkEntityData.serializer as KSerializer<IContextOf<T>>
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

