package ru.vood.dmgen.meta

import ru.vood.dmgen.datamodel.metaEnum.FkNameEnum.Companion.foreignKeyMap
import java.util.*


object DerivativeFKs {

    val foreignKeyMapFromEntity = EnumMap(foreignKeyMap.values
        .map {
            it.fromEntity to it
        }
        .groupBy { it.first }
        .map { it.key to it.value.map { q -> q.second }.toSet() }
        .toMap()
    )
}