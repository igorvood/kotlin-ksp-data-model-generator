package ru.vood.dmgen.meta

import ru.vood.dmgen.datamodel.metaEnum.columnEntityDataMap
import ru.vood.dmgen.intf.newIntf.Simple

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
        .map { asd -> asd.key to asd.value.filter { c -> c.value.iColKind !is Simple } }
        .filter { asd -> asd.second.isNotEmpty() }
        .toMap()

}