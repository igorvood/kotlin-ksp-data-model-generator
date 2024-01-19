package ru.vood.dmgen.meta

import ru.vood.dmgen.annotation.FlowEntityType
import ru.vood.dmgen.datamodel.intf.FKMetaData
import ru.vood.dmgen.datamodel.metaEnum.EntityEnum
import ru.vood.dmgen.datamodel.metaEnum.FkNameEnum
import ru.vood.dmgen.datamodel.metaEnum.FkNameEnum.Companion.foreignKeyMap
import java.util.*


object DerivativeDependencyMap {

    private val entityDataMap = EnumMap(EntityEnum.values().associateWith { it.entityData() })
    val entityDependencyParentMap =
        collectDependencyNew(foreignKeyMap)

    val aggregateParentDependencyMap = EnumMap(entityDependencyParentMap
        .filter { qw -> entityDataMap[qw.key]!!.entityType == FlowEntityType.AGGREGATE }
        .map {
            it.key to it.value.filter { q -> entityDataMap[q.toEntity]!!.entityType == FlowEntityType.AGGREGATE }
                .toSet()
        }
        .toMap())


    val entityDependencyChildMap = EnumMap(entityDependencyParentMap.keys
        .associateWith { parentEnt ->
            val filter = entityDependencyParentMap.entries
                .filter { ch ->
                    ch.value.map { it.toEntity }.contains(parentEnt)
                }
                .distinctBy { it.key }
                .map { MetaDependencyNew(it.key, entityDataMap[it.key]!!) }
                .toSet()
            filter
        })

    val aggregateChildDependencyMap = EnumMap(entityDependencyChildMap
        .filter { qw -> entityDataMap[qw.key]!!.entityType == FlowEntityType.AGGREGATE }
        .map {
            it.key to it.value.filter { q -> entityDataMap[q.toEntity]!!.entityType == FlowEntityType.AGGREGATE }
                .toSet()
        }
        .toMap())

    private fun collectDependencyNew(
        foreignKey: Map<FkNameEnum, FKMetaData<*>>
    ): EnumMap<EntityEnum, Set<MetaDependencyNew>> {
        tailrec fun recursiveCollectDependency(
            listFk: List<FKMetaData<*>>,
            collector: Map<EntityEnum, Set<MetaDependencyNew>>
        ): Map<EntityEnum, Set<MetaDependencyNew>> {
            return when (listFk.isEmpty()) {
                true -> collector
                false -> {
                    val dataDictionaryForeignKeyEnum = listFk[0]
                    val entityData = entityDataMap[dataDictionaryForeignKeyEnum.toEntity]!!
                    val metaDependencies = collector[dataDictionaryForeignKeyEnum.fromEntity]
                    val let = metaDependencies?.plus(
                        MetaDependencyNew(dataDictionaryForeignKeyEnum.toEntity, entityData)
                    )
                        ?: setOf(MetaDependencyNew(dataDictionaryForeignKeyEnum.toEntity, entityData))

                    val plus = collector.plus(dataDictionaryForeignKeyEnum.fromEntity to let)

                    val values1 = listFk.drop(1)
                    recursiveCollectDependency(values1, plus)
                }
            }
        }

        val toMap = entityDataMap.values.map {
            it.entityName to setOf<MetaDependencyNew>()
        }.toMap()
        return EnumMap(recursiveCollectDependency(foreignKey.values.toList(), toMap))

    }


}


