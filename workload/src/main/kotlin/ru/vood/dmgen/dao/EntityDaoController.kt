package ru.vood.dmgen.dao


import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.*
import kotlinx.serialization.json.internal.decodeStringToJsonTree
import org.springframework.jdbc.core.JdbcOperations
import org.springframework.stereotype.Repository
import ru.vood.dmgen.dao.dto.ChildEntityDto
import ru.vood.dmgen.dao.dto.PKJsonVal
import ru.vood.dmgen.dao.dto.PayLoadJsonVal
import ru.vood.dmgen.dao.dto.UKJsonVal
import ru.vood.dmgen.datamodel.metaEnum.entityDataMap
import ru.vood.dmgen.intf.*
import ru.vood.dmgen.intf.newIntf.Simple
import ru.vood.dmgen.intf.newIntf.Synthetic
import ru.vood.dmgen.intf.newIntf.SyntheticSet
import ru.vood.dmgen.intf.newIntf.UKEntityData
import ru.vood.dmgen.meta.DerivativeColumns
import ru.vood.dmgen.meta.DerivativeColumns.entitiesSyntheticColumnsByEntityMap
import ru.vood.dmgen.meta.DerivativeColumns.entitiesSyntheticColumnsMap
import ru.vood.dmgen.meta.DerivativeFKs.foreignKeyMapFromEntity
import ru.vood.dmgen.meta.DerivativeUk.entitiesUkMap
import ru.vood.dmgen.meta.IndexesDto
import ru.vood.dmgen.serial.ModelJsonSerializer

@Repository
class EntityDaoController(
    val jdbcOperations: JdbcOperations,
    val entityDao: EntityDao,
    val entityUkDao: EntityUkDaoController,
    val serializer: ModelJsonSerializer,


    ) {

    /**Сохранение агрегата полностью, в одной строке, при это сохраняется только первичный и уникальные ключи,
     * оригинальной ДТО, связанной с аггрегатом
     * */
    final fun <T : IEntityOrigin> saveAggregate(aggregate: IEntitySynthetic<T>) {
//        Вытаскиваю мету
        val entityNameOrigin = aggregate.designEntityName
        val indexesDtoOrigin =
            entitiesUkMap[entityNameOrigin] ?: error("Почему то не найдена сущность ${entityNameOrigin.value}")
        val entityDataOrigin =
            entityDataMap[entityNameOrigin] ?: error("Почему то не найдена сущность ${entityNameOrigin.value}")
        val pkMetaOrigin = indexesDtoOrigin.pkEntityData as UKEntityData<T>

        val pkSerializerOrigin = indexesDtoOrigin.pkEntityData.serializer as KSerializer<Any>
        val serializerSynthetic = entityDataOrigin.serializerSynthetic as KSerializer<Any>
        checkFk(entityNameOrigin, aggregate.origin)


        val pkDto = pkMetaOrigin.extractContext(aggregate.origin)
        val pkJson = PKJsonVal(serializer.modelJsonSerializer.encodeToString(pkSerializerOrigin, pkDto))
        val entityJson = PayLoadJsonVal(serializer.modelJsonSerializer.encodeToString(serializerSynthetic, aggregate as Any))

        entityDao.saveFullAggregateNoParent(pkJson, entityNameOrigin, entityJson)


        indexesDtoOrigin.ukAndPkMap.values
            .forEach { ukMeta ->
                val ukMetaData = ukMeta as UKEntityData<T>
                val ukData = ukMetaData.extractContext(aggregate.origin)
                entityUkDao.saveEntityUkDto(entityNameOrigin, ukData, pkJson.value, ukMetaData)
            }
    }

    final fun <T : IEntityOrigin> saveAggregateByPart(aggregate: IEntitySynthetic<T>) {
        val designEntityName = aggregate.designEntityName
        val entityName = designEntityName
        val indexesDto = entitiesUkMap[entityName] ?: error("Почему то не найдена сущность ${entityName.value}")
        val pkSerializer = indexesDto.pkEntityData.serializer as KSerializer<Any>
        val entityData = entityDataMap[entityName] ?: error("Почему то не найдена сущность ${entityName.value}")
        val entitySerializer = entityData.serializer as KSerializer<Any>

        checkFk(entityName, aggregate.origin)


        val pkMeta = indexesDto.pkEntityData as UKEntityData<T>
        val pkDto: IContextOf<T> = pkMeta.extractContext(aggregate.origin)
        val pkJson = PKJsonVal(serializer.modelJsonSerializer.encodeToString(pkSerializer, pkDto))
        val entityJson = PayLoadJsonVal(serializer.modelJsonSerializer.encodeToString(entitySerializer, aggregate.origin))


        entityDao.saveFullAggregateNoParent(pkJson, entityName, entityJson)


        indexesDto.ukAndPkMap.values
            .forEach { ukMeta ->
                val ukMetaData = ukMeta as UKEntityData<T>
                val ukData = ukMetaData.extractContext(aggregate.origin)
                entityUkDao.saveEntityUkDto(entityName, ukData, pkJson.value, ukMetaData)
            }


        val childEntityNames = childEntity(designEntityName, aggregate)

        saveChildEntities(childEntityNames, pkDto as IContextOf<IEntityOrigin>)


        val entitiesSyntheticColumnsMap1 = entitiesSyntheticColumnsMap

//
        val size = entitiesSyntheticColumnsMap1.size
//        saveEntity(aggregate.origin)
    }

    private fun <T : IEntityOrigin> childEntity(
        designEntityName: EntityName,
        aggregate: IEntitySynthetic<T>
    ) = (DerivativeColumns.entitiesColumnsMap[designEntityName]
        ?.entries
        ?.filter { it.value.iColKind !is Simple }?.map { it.value.outEntity!! }
        ?.map { it to aggregate.syntheticField(it) }
        ?.filter { it.second.isNotEmpty() }
        ?.toMap()
        ?: mapOf())

    fun saveChildEntities(
        childEntityNames: Map<EntityName, Set<IEntitySynthetic<out IEntityOrigin>>>,
        pkDtoParent: IContextOf<IEntityOrigin>
    ) {
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
                val pkJson = serializer.modelJsonSerializer.encodeToString(pkSerializer, pkDto)

                val entitySerializer = entityData.serializer as KSerializer<Any>
                val entityJson = serializer.modelJsonSerializer.encodeToString(entitySerializer, synth.origin)
                val indexesDtoParent =
                    entitiesUkMap[pkDtoParent.designEntityName] ?: error("asdasdasdasdas 9280347jkhlkb ")
                val pkSerializerParent = indexesDtoParent.pkEntityData.serializer as KSerializer<Any>
                val pkJsonParent = serializer.modelJsonSerializer.encodeToString(pkSerializerParent, pkDtoParent)

                jdbcOperations.update(
                    """insert into entity_context(pk, entity_type, payload, parent_entity_type, parent_pk) VALUES (?, ?, ?, ?, ?) """,
                    pkJson, entityName.value, entityJson, pkDtoParent.designEntityName.value, pkJsonParent
                )

                indexesDto.ukAndPkMap.values
                    .forEach { ukMeta ->
                        val ukMetaData = ukMeta as UKEntityData<IEntityOrigin>
                        val ukData = ukMetaData.extractContext(origin)
                        entityUkDao.saveEntityUkDto(entityName, ukData, pkJson, ukMetaData)
                    }

                val childEntity = childEntity(entityName, synth)
                saveChildEntities(childEntity, pkDto)
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
        val pkJson = serializer.modelJsonSerializer.encodeToString(pkSerializer, pkDto)
        val entityJson = serializer.modelJsonSerializer.encodeToString(entitySerializer, entity)

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

    @Suppress("UNCHECKED_CAST")
    fun <T : IEntityOrigin> checkFk(entityName: EntityName, entity: T) {
        val fkEntityDataSet = foreignKeyMapFromEntity[entityName] ?: setOf()
        fkEntityDataSet
            .forEach { fkEntityData ->
                val extractContextByFKFunction = fkEntityData.extractJsonContext as (T) -> IContextOf<out IEntityOrigin>
                val parentContextValue = extractContextByFKFunction(entity)
                val ukEntityData =
                    entitiesUkMap[parentContextValue.designEntityName]!!.ukAndPkMap[parentContextValue.ukName]!!
                val ukSerializer = ukEntityData.serializer as KSerializer<Any>
                val encodeToString = UKJsonVal(serializer.modelJsonSerializer.encodeToString(ukSerializer, parentContextValue))
                entityUkDao.existUk(fkEntityData.uk, encodeToString.value)
            }
    }

    final fun <T : IEntityOrigin> findSyntheticEntityCollectPartByUk(uk: IContextOf<T>): IEntitySynthetic<out IEntityOrigin> {
        val originEntityName = uk.designEntityName
        val indexesDto =
            entitiesUkMap[originEntityName] ?: error("Почему то не найдена сущность ${originEntityName.value}")
        val ktSerializer = indexesDto.pkEntityData.serializer as KSerializer<IContextOf<T>>
        val ktEntitySerializer = uk.ktEntitySerializer as KSerializer<T>
        val ukJson = UKJsonVal(Json.encodeToString(ktSerializer, uk))
        val originJsonElement = entityDao.findEntityAsJsonElementByUk(ktEntitySerializer, uk.ukName, ukJson)

        val pkVal = entityDao.findPKJsonVal(uk, ukJson)


        val childEntityDtos = entityDao.findAllChildEntityDto(pkVal, indexesDto)

        val collectChildrenJsonElement = collectChildrenJsonElement(originEntityName, childEntityDtos)
        val jsonObject = collectSyntheticJsonObject(collectChildrenJsonElement, originEntityName, originJsonElement)
        val serializerSynthetic = entityDataMap[originEntityName]!!.serializerSynthetic


        val decodeFromJsonElement = serializer.modelJsonSerializer.decodeFromJsonElement(serializerSynthetic, jsonObject)



        return decodeFromJsonElement
    }

    private fun collectSyntheticJsonObject(
        collectChildrenJsonElement: Map<EntityName, JsonElement>,
        originEntityName: EntityName,
        originJsonElement: JsonElement
    ): JsonObject {

        val metaSyntheticColumn = entitiesSyntheticColumnsByEntityMap[originEntityName] ?: mapOf()

        val map1 = metaSyntheticColumn.entries
            .map { entry ->
                val jsonElement = collectChildrenJsonElement[entry.key] ?: JsonNull

                entry.value.simpleColumnName.value to jsonElement
            }
            .toMap()
            .plus("origin" to originJsonElement)


//        val map = collectChildrenJsonElement.entries.map { entry ->
//
//            val map = entitiesSyntheticColumnsByEntityMap[originEntityName]
//                ?: error("for ${originEntityName.value} not found ")
//            val columnEntityData = map[entry.key]
//                ?: error("for entity ${originEntityName.value} not found inner col non found col with type ${entry.key.value} ")
//            columnEntityData.simpleColumnName.value to entry.value
//        }
//            .toMap()
//            .plus("origin" to originJsonElement)

        return JsonObject(map1)
    }

    @OptIn(InternalSerializationApi::class)
    private fun collectChildrenJsonElement(
        entityName: EntityName,
        childEntityDtos: Map<EntityName, List<ChildEntityDto>>
    ): Map<EntityName, JsonElement> {
        val columnMap = entitiesSyntheticColumnsMap[entityName] ?: mapOf()
        val map = columnMap.values.map { columnEntityData ->
            val outEntity = columnEntityData.outEntity!!

//            val outEntitySyntheticColumns = entitiesSyntheticColumnsMap[outEntity]?: mapOf()

            val entityData = entityDataMap[outEntity] ?: error("mcvnbjkxchhgsdjkhgf")


            val childEntityDto1 = childEntityDtos[outEntity]
            val childEntityDto = if (columnEntityData.isOptional) {
                childEntityDto1 ?: listOf()
            } else {
                childEntityDto1 ?: error("Not found children entity for ${outEntity.value}")
            }

            val childrenJsonElementForOutEntity = collectChildrenJsonElement(outEntity, childEntityDtos)
            val childrenJsonForEntityName = childEntityDto.map { chDto ->
                val originJsonElement = serializer.modelJsonSerializer.decodeStringToJsonTree(entityData.serializer, chDto.payload.value)
                collectSyntheticJsonObject(childrenJsonElementForOutEntity, outEntity, originJsonElement)
            }

            val (_, _, _, isOptional, _, _, iColKind) = entitiesSyntheticColumnsByEntityMap[entityName]!![outEntity]!!

            val any = when (iColKind) {
                is SyntheticSet<*, *, *> -> JsonArray(childrenJsonForEntityName)
                is Synthetic<*, *, *> -> when (isOptional) {
                    true -> when (childrenJsonForEntityName.size) {
                        1 -> childrenJsonForEntityName[0]
                        0 -> JsonNull
                        else -> error("Asdadask9887345897")
                    }
                    false -> when (childrenJsonForEntityName.size) {
                        1 -> childrenJsonForEntityName[0]
                        else -> error("Asdadask9887345897304985734098573409857")
                    }
                }
                is Simple<*, *> -> error("poiutykfc,m.bncvm,")
            }


//            collectSyntheticEntity(outEntity, childrenJsonElement)


            outEntity to any

        }.toMap()

//        TODO()
        return map
    }

    @Suppress("UNCHECKED_CAST")
    final fun <T : IEntityOrigin> findSyntheticEntityOneRowByUk(uk: IContextOf<T>): IEntitySynthetic<out IEntityOrigin> {
        val entityName = uk.designEntityName
        val indexesDto = entitiesUkMap[entityName] ?: error("Почему то не найдена сущность ${entityName.value}")
        val ktSerializer = indexesDto.pkEntityData.serializer as KSerializer<IContextOf<T>>
        val ktEntitySerializer = uk.ktSyntheticEntitySerializer as KSerializer<IEntitySynthetic<T>>
        val ukJson = UKJsonVal(Json.encodeToString(ktSerializer, uk))
        val ukName = uk.ukName

        return entityDao.findEntityByUk(ktEntitySerializer, ukName, ukJson)
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
                serializer.modelJsonSerializer.decodeFromString(ktEntitySerializer, rs.getString(1))
            },
            uk.ukName.value, ukJson
        )

        if (query.size == 1)
            query[0]
        else error("Not found uk ${uk.ukName.value} with value ${ukJson}")

        return query[0]
    }


}

