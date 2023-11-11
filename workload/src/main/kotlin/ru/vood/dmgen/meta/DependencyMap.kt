package ru.vood.dmgen.meta

import ru.vood.dmgen.annotation.FkName
import ru.vood.dmgen.annotation.FlowEntityType
import ru.vood.dmgen.datamodel.metaEnum.Dependency
import ru.vood.dmgen.datamodel.metaEnum.entityDataMap
import ru.vood.dmgen.datamodel.metaEnum.foreignKeyMap
import ru.vood.dmgen.intf.EntityName
import ru.vood.dmgen.intf.IEntity
import ru.vood.dmgen.intf.newIntf.EntityData
import ru.vood.dmgen.intf.newIntf.FKEntityData


object DependencyMap {

    val entityDependencyMap: Map<EntityName, Set<MetaDependencyNew<*>>> =
        collectDependencyNew(entityDataMap, foreignKeyMap)

    val aggregateDependencyMap = entityDependencyMap
        .filter { qw -> entityDataMap[qw.key]!!.entityType == FlowEntityType.AGGREGATE }
        .map { it.key to it.value.filter { q -> entityDataMap[q.toEntity]!!.entityType == FlowEntityType.AGGREGATE }.toSet() }
        .toMap()

    private fun collectDependencyNew(
        entities: Map<EntityName, EntityData<out IEntity<*>>>,
        foreignKey: Map<FkName, FKEntityData>
    ): Map<EntityName, Set<MetaDependencyNew<*>>> {
        tailrec fun recursiveCollectDependency(
            listFk: List<FKEntityData>,
            collector: Map<EntityName, Set<MetaDependencyNew<*>>>
        ): Map<EntityName, Set<MetaDependencyNew<*>>> {
            return when (listFk.isEmpty()) {
                true -> collector
                false -> {
                    val dataDictionaryForeignKeyEnum = listFk[0]
                    val entityData = entities[dataDictionaryForeignKeyEnum.toEntity]!!
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

        val toMap = entities.values.map {
            it.entityName to setOf<MetaDependencyNew<*>>()
        }.toMap()
        return recursiveCollectDependency(foreignKey.values.toList(), toMap)

    }


}


