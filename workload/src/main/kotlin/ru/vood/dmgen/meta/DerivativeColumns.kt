package ru.vood.dmgen.meta

import ru.vood.dmgen.datamodel.metaEnum.columnEntityDataMap
import ru.vood.dmgen.intf.EntityType
import ru.vood.dmgen.intf.IEntityOrigin
import ru.vood.dmgen.intf.newIntf.IColExtractFunction
import ru.vood.dmgen.intf.newIntf.SyntheticColumnEntityData

object DerivativeColumns {

    val entitiesColumnsMap = columnEntityDataMap.values
        .map { column ->
            column.entity to column
        }
        .groupBy { it.first }
        .map {
            it.key to it.value.map { ass -> ass.second }
                .map { asdsa -> asdsa.simpleColumnName to asdsa }.toMap()
        }
        .toMap()

    val entitiesSyntheticColumnsMap = entitiesColumnsMap
        .entries
        .map { asd ->
            asd.key to asd.value
                .filter { c -> c.value is SyntheticColumnEntityData }
                .map { c ->
                    c.value as SyntheticColumnEntityData
                }
        }
        .filter { asd -> asd.second.isNotEmpty() }
        .toMap()


    val entitiesSyntheticColumnsByEntityMap2 = entitiesSyntheticColumnsMap
        .entries
        .map { asd ->
            asd.key to asd.value
                .map { qwe -> qwe.outEntity to qwe }
                .toMap()
        }
        .toMap()


}