package ru.vood.dmgen.meta

import ru.vood.dmgen.datamodel.metaEnum.columnEntityDataMap

object DerivativeColumns {

    val entitiesColumnsMap = columnEntityDataMap.values
        .map { column ->
            column.entity to column
        }
        .groupBy { it.first }
        .map { it.key to it.value.map { ass -> ass.second}.map { asdsa ->asdsa.columnName to asdsa }.toMap() }
        .toMap()
}