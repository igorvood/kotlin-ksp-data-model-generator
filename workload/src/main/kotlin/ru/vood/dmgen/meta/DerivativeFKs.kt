package ru.vood.dmgen.meta

import ru.vood.dmgen.datamodel.metaEnum.foreignKeyMap

object DerivativeFKs {

    val foreignKeyMapFromEntity = foreignKeyMap.values
        .map {
            it.fromEntity to it
        }
        .groupBy { it.first }
        .map { it.key to it.value.map { q -> q.second }.toSet() }
        .toMap()
}