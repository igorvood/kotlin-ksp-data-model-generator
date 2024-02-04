package ru.vood.dmgen.meta

import ru.vood.dmgen.datamodel.intf.SyntheticColumnEntityData
import ru.vood.dmgen.datamodel.metaEnum.FullColumnNameEnum
import java.util.*


object DerivativeColumns {


    private val columnEntityDataMap = EnumMap(FullColumnNameEnum.values().associateWith { it.columnData() })

    val entitiesColumnsMap = EnumMap(columnEntityDataMap.values
        .map { column ->
            column.entity to column
        }
        .groupBy { it.first }
        .map {
            it.key to it.value.map { entWithColEntData -> entWithColEntData.second }
                .associateBy { colEntData -> colEntData.simpleColumnName }
        }
        .toMap()
    )

    val entitiesSyntheticColumnsMap = EnumMap(entitiesColumnsMap
        .entries
        .map { asd ->
            asd.key to asd.value
                .filter { c -> c.value is SyntheticColumnEntityData<*> }
                .map { c ->
                    c.value as SyntheticColumnEntityData<*>
                }
                .toSet()
        }
        .filter { asd -> asd.second.isNotEmpty() }
        .toMap()
    )

    val entitiesSyntheticColumnsByEntityMap2 = EnumMap(entitiesSyntheticColumnsMap
        .entries
        .map { asd ->
            asd.key to EnumMap(asd.value
                .map { qwe -> qwe.outEntity to qwe }
                .toMap())
        }
        .toMap()
    )

}