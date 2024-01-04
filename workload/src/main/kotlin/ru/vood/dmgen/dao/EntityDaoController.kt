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
import ru.vood.dmgen.datamodel.intf.*
import ru.vood.dmgen.datamodel.metaEnum.entityDataMap
import ru.vood.dmgen.intf.*

import ru.vood.dmgen.meta.DerivativeColumns.entitiesSyntheticColumnsByEntityMap2
import ru.vood.dmgen.meta.DerivativeColumns.entitiesSyntheticColumnsMap
import ru.vood.dmgen.meta.DerivativeFKs.foreignKeyMapFromEntity
import ru.vood.dmgen.meta.DerivativeUk.entitiesUkMap
import ru.vood.dmgen.serial.ModelJsonSerializer

/** TODO сохранения происходят не в тразакциях, для MVP этого достаточно, но для прода надо продумать
 * */
@Repository
class EntityDaoController(
    val jdbcOperations: JdbcOperations,
    val entityDao: EntityDao,
    val entityUkDao: EntityUkDaoController,
    val serializer: ModelJsonSerializer,
) {

    /**Сохранение агрегата полностью, в одной строке, при это сохраняется только первичный и уникальные ключи,
     * оригинальной ДТО, связанной с аггрегатом
     *
     * */
    @Suppress("UNCHECKED_CAST")
    final fun <T : IEntityOrigin> saveAggregate(aggregate: IEntityDetail<T>) {
//        Вытаскиваю мету
        val entityNameOrigin = aggregate.designEntityName
        val indexesDtoOrigin =
            entitiesUkMap[entityNameOrigin] ?: error("Почему то не найдена сущность ${entityNameOrigin.value}")
        val entityDataOrigin =
            entityDataMap[entityNameOrigin] ?: error("Почему то не найдена сущность ${entityNameOrigin.value}")
        val pkMetaOrigin = indexesDtoOrigin.pkEntityData as UKEntityData<T>

        // сериалайзеры
        val pkSerializerOrigin = indexesDtoOrigin.pkEntityData.serializer as KSerializer<Any>
        val serializerSynthetic = entityDataOrigin.serializerSynthetic as KSerializer<Any>

        // проверяю сущностей на которые ссылаются форены
        checkFk(entityNameOrigin, aggregate.origin)

        //Вытаскиваю нужные json-ы для сохранения
        val pkDto = pkMetaOrigin.extractContext(aggregate.origin)
        val pkJson = PKJsonVal(serializer.modelJsonSerializer.encodeToString(pkSerializerOrigin, pkDto))
        val entityJson =
            PayLoadJsonVal(serializer.modelJsonSerializer.encodeToString(serializerSynthetic, aggregate as Any))

        // сохранение сущности
        entityDao.saveFullAggregateNoParent(pkJson, entityNameOrigin, entityJson)


        // Сохранение всех уникальных ключей
        indexesDtoOrigin.ukAndPkMap.values
            .forEach { ukMeta ->
                val ukMetaData = ukMeta as UKEntityData<T>
                val ukData = ukMetaData.extractContext(aggregate.origin)
                entityUkDao.saveEntityUkDto(entityNameOrigin, ukData, pkJson.value, ukMetaData)
            }
    }

    /**Сохранение агрегата по частям, каждая саб сущность помещается в отдельную строчку таблицы,
     * с сохранением всех ее уникальных ключей*/
    @Suppress("UNCHECKED_CAST")
    final fun <T : IEntityOrigin> saveAggregateByPart(aggregate: IEntityDetail<T>) {
        // Вытаскиваю мету
        val entityNameOrigin = aggregate.designEntityName
        val indexesDto =
            entitiesUkMap[entityNameOrigin] ?: error("Почему то не найдена сущность ${entityNameOrigin.value}")
        val entityData =
            entityDataMap[entityNameOrigin] ?: error("Почему то не найдена сущность ${entityNameOrigin.value}")
        val pkMeta = indexesDto.pkEntityData as UKEntityData<T>


        // сериалайзеры
        val pkSerializer = indexesDto.pkEntityData.serializer as KSerializer<Any>
        val entitySerializer = entityData.serializer as KSerializer<Any>

        // проверяю сущностей на которые ссылаются форены
        checkFk(entityNameOrigin, aggregate.origin)


        //Вытаскиваю нужные json-ы для сохранения
        val pkDto = pkMeta.extractContext(aggregate.origin)
        val pkJson = PKJsonVal(serializer.modelJsonSerializer.encodeToString(pkSerializer, pkDto))
        val entityJson =
            PayLoadJsonVal(serializer.modelJsonSerializer.encodeToString(entitySerializer, aggregate.origin))

        // сохранение основной сущности
        entityDao.saveFullAggregateNoParent(pkJson, entityNameOrigin, entityJson)

        // Сохранение всех уникальных ключей основной сущности
        //TODO надобы сохранение батчем сделать
        indexesDto.ukAndPkMap.values
            .forEach { ukMeta ->
                val ukMetaData = ukMeta as UKEntityData<T>
                val ukData = ukMetaData.extractContext(aggregate.origin)
                entityUkDao.saveEntityUkDto(entityNameOrigin, ukData, pkJson.value, ukMetaData)
            }

//        вытаскиваю все дочерние сущности из текущей
//        TODO тут бы вытаскивание по легковеснее сделать, Думаю надо мету в ином разрезе собрать и это поможет
        val childEntityNames = childEntity(entityNameOrigin, aggregate)

//        сохраняю все дочерние сущности
        saveChildEntities(childEntityNames, pkDto as IContextOf<IEntityOrigin>)

    }

    /**вытаскиваю все дочерние сущности из текущей
     * */
    private fun <T : IEntityOrigin> childEntity(
        designEntityName: EntityName,
        aggregate: IEntityDetail<T>
    ): Map<EntityName, Set<IEntityDetail<out IEntityOrigin>>> {

        val entitiesSyntheticColumnsMap1 = entitiesSyntheticColumnsMap[designEntityName] ?: listOf()

        return entitiesSyntheticColumnsMap1
            .map { it.outEntity }
            .map { it to aggregate.syntheticField(it) }
            .filter { it.second.isNotEmpty() }
            .toMap()
    }

    /**сохраняю все дочерние сущности */
    @Suppress("UNCHECKED_CAST")
    private fun saveChildEntities(
        /**Дочерние сущности */
        childEntityNames: Map<EntityName, Set<IEntityDetail<out IEntityOrigin>>>,
        /**первичный ключ основной сущности*/
        pkDtoParent: IContextOf<IEntityOrigin>
    ) {
        val pkDtoParentEntityName = pkDtoParent.designEntityName
//        Бегаю по всем дочерним
        childEntityNames.map { entry ->
            val childrenEntityName = entry.key
            // тут коллекция дочерних, потому как может быть от 0 до n сущностей.
            // например для опциональной тут может быть 0 или 1
            // Обязательной строго 1
            // для коллекции от 0 до n
            val childrenSynthetics = entry.value

//            вытаскиваю мету по дочерней сущности
            val childrenEntityData =
                entityDataMap[childrenEntityName] ?: error("Почему то не найдена сущность ${childrenEntityName.value}")
            val indexesDto =
                entitiesUkMap[childrenEntityName] ?: error("Почему то не найдена сущность ${childrenEntityName.value}")
            val pkMeta: UKEntityData<IEntityOrigin> = indexesDto.pkEntityData as UKEntityData<IEntityOrigin>
            val indexesDtoParent =
                entitiesUkMap[pkDtoParent.designEntityName] ?: error("asdasdasdasdas 9280347jkhlkb ")

//            сериализаторы
            val pkChildrenSerializer = pkMeta.serializer as KSerializer<Any>
            val childrenEntitySerializer = childrenEntityData.serializer as KSerializer<Any>
            val pkSerializerParent = indexesDtoParent.pkEntityData.serializer as KSerializer<Any>

            val pkJsonParent = PKJsonVal(serializer.modelJsonSerializer.encodeToString(pkSerializerParent, pkDtoParent))

//            багаю по каждой конкретной дочерней сущности из коллекции и пыжусь сохранить
            childrenSynthetics.forEach { synth: IEntityDetail<out IEntityOrigin> ->
//                Вытаскиваю нужные ДТО
                val childrenOrigin = synth.origin
                val pkChildrenDto = pkMeta.extractContext(childrenOrigin)

//                Генеррю json-ы
                val pkChildrenJson =
                    PKJsonVal(serializer.modelJsonSerializer.encodeToString(pkChildrenSerializer, pkChildrenDto))
                val childrenEntityJson =
                    PayLoadJsonVal(
                        serializer.modelJsonSerializer.encodeToString(
                            childrenEntitySerializer,
                            synth.origin
                        )
                    )

//                сохраняю сущность
                entityDao.saveChldrenEntity(
                    pkChildrenJson = pkChildrenJson,
                    childrenEntityName = childrenEntityName,
                    childrenEntityJson = childrenEntityJson,
                    pkDtoParentEntityName = pkDtoParentEntityName,
                    pkJsonParent = pkJsonParent
                )

//                Сохраняю уникальные ключи
                indexesDto.ukAndPkMap.values
                    .forEach { ukMeta ->
                        val ukMetaData = ukMeta as UKEntityData<IEntityOrigin>
                        val ukData = ukMetaData.extractContext(childrenOrigin)
                        entityUkDao.saveEntityUkDto(childrenEntityName, ukData, pkChildrenJson.value, ukMetaData)
                    }
//              у текущей дочерней могут быть свои дочериние. посему надо вызвать рекурсивно, для их сохранения
//TODO если заметить, то тут рекрсивно вызывается очень много раз. Думаю есть большой потенциал для опртимизации, просто подумать надо сильнее.
// TODO для оптимизации надо рекурсивный вызов вынести за пределы итераторов, если такое возможно
                val childEntity = childEntity(childrenEntityName, synth)
                saveChildEntities(childEntity, pkChildrenDto)
            }
        }
    }


    /**сохранение обычной сущности, не синтетической, принцип как у синтетики, только дочерние не сохраняются*/
    @Suppress("UNCHECKED_CAST")
    final inline fun <reified T : IEntityOrigin> saveEntity(entity: T) {
        val entityName = entity.designEntityName
        val indexesDto = entitiesUkMap[entityName] ?: error("Почему то не найдена сущность ${entityName.value}")
        val pkSerializer = indexesDto.pkEntityData.serializer as KSerializer<Any>
        val entityData = entityDataMap[entityName] ?: error("Почему то не найдена сущность ${entityName.value}")
        val entitySerializer = entityData.serializer as KSerializer<Any>

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
                val extractContextByFKFunction = fkEntityData.сontextExtractor as (T) -> IContextOf<out IEntityOrigin>
                val parentContextValue = extractContextByFKFunction(entity)
                val ukEntityData =
                    entitiesUkMap[parentContextValue.designEntityName]!!.ukAndPkMap[parentContextValue.ukName]!!
                val ukSerializer = ukEntityData.serializer as KSerializer<Any>
                val encodeToString =
                    UKJsonVal(serializer.modelJsonSerializer.encodeToString(ukSerializer, parentContextValue))
                entityUkDao.existUk(fkEntityData.uk, encodeToString.value)
            }
    }

    @Suppress("UNCHECKED_CAST")
    final fun <
            Origin : IEntityOrigin,
            T : IEntityDetail<out Origin>
            > findSyntheticEntityCollectPartByUk(
        uk: IContextOf<Origin>
    ): T {
        val originEntityName = uk.designEntityName
        val indexesDto =
            entitiesUkMap[originEntityName] ?: error("Почему то не найдена сущность ${originEntityName.value}")
        val ktSerializer = indexesDto.pkEntityData.serializer as KSerializer<IContextOf<Origin>>
        val ktEntitySerializer = uk.ktEntitySerializer
        val ukJson = UKJsonVal(Json.encodeToString(ktSerializer, uk))
        val originJsonElement = entityDao.findEntityAsJsonElementByUk(ktEntitySerializer, uk.ukName, ukJson)

        val pkVal = entityDao.findPKJsonVal(uk, ukJson)


        val childEntityDtos = entityDao.findAllChildEntityDto(pkVal, indexesDto)

        val collectChildrenJsonElement = collectChildrenJsonElement(originEntityName, childEntityDtos)
        val jsonObject = collectSyntheticJsonObject(collectChildrenJsonElement, originEntityName, originJsonElement)
        val serializerSynthetic = entityDataMap[originEntityName]!!.serializerSynthetic

        return serializer.modelJsonSerializer.decodeFromJsonElement(serializerSynthetic, jsonObject) as T
    }

    final fun collectSyntheticJsonObject(
        collectChildrenJsonElement: Map<EntityName, JsonElement>,
        originEntityName: EntityName,
        originJsonElement: JsonElement
    ): JsonObject {

        val metaSyntheticColumn = entitiesSyntheticColumnsByEntityMap2[originEntityName] ?: mapOf()

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
    final fun collectChildrenJsonElement(
        entityName: EntityName,
        childEntityDtos: Map<EntityName, List<ChildEntityDto>>
    ): Map<EntityName, JsonElement> {
        val syntheticColumnEntityData = entitiesSyntheticColumnsMap[entityName]
        val columnMap = syntheticColumnEntityData ?: listOf()
        val map = columnMap.map { columnEntityData ->


            val outEntity = columnEntityData.outEntity


            val entityData = entityDataMap[outEntity] ?: error("mcvnbjkxchhgsdjkhgf")


            val childEntityDto1 = childEntityDtos[outEntity]
            val childEntityDto = if (columnEntityData.isOptional) {
                childEntityDto1 ?: listOf()
            } else {
                childEntityDto1 ?: error("Not found children entity for ${outEntity.value}")
            }

            val childrenJsonElementForOutEntity = collectChildrenJsonElement(outEntity, childEntityDtos)
            val childrenJsonForEntityName = childEntityDto.map { chDto ->
                val originJsonElement =
                    serializer.modelJsonSerializer.decodeStringToJsonTree(entityData.serializer, chDto.payload.value)
                collectSyntheticJsonObject(childrenJsonElementForOutEntity, outEntity, originJsonElement)
            }

            val columnEntityData1 =
                entitiesSyntheticColumnsByEntityMap2[entityName]!![outEntity]!!
            val isOptional = columnEntityData1.isOptional
            val iColKind = columnEntityData1.iColExtractFunction


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
                is SimpleColExtractFunction<*, *> -> error("poiutykfc,m.bncvm,")
            }


//            collectSyntheticEntity(outEntity, childrenJsonElement)


            outEntity to any

        }.toMap()

//        TODO()
        return map
    }

    @Suppress("UNCHECKED_CAST")
    final fun <T : IEntityOrigin> findSyntheticEntityOneRowByUk(uk: IContextOf<T>): IEntityDetail<out IEntityOrigin> {
        val entityName = uk.designEntityName
        val indexesDto = entitiesUkMap[entityName] ?: error("Почему то не найдена сущность ${entityName.value}")
        val ktSerializer = indexesDto.pkEntityData.serializer as KSerializer<IContextOf<T>>
        val ktEntitySerializer = uk.ktSyntheticEntitySerializer as KSerializer<IEntityDetail<T>>
        val ukJson = UKJsonVal(Json.encodeToString(ktSerializer, uk))
        val ukName = uk.ukName

        return entityDao.findEntityByUk(ktEntitySerializer, ukName, ukJson)
    }

    @Suppress("UNCHECKED_CAST")
    final inline fun <reified T : IEntityOrigin> findEntityByUk(uk: IContextOf<T>): IEntityOrigin {
        val entityName = uk.designEntityName
        val indexesDto = entitiesUkMap[entityName] ?: error("Почему то не найдена сущность ${entityName.value}")

        val ktSerializer = indexesDto.pkEntityData.serializer as KSerializer<IContextOf<T>>
        val ktEntitySerializer = uk.ktEntitySerializer
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

