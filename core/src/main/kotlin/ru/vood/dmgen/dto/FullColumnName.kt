package ru.vood.dmgen.dto

import ru.vood.dmgen.intf.SimpleColumnName


@JvmInline
value class FullColumnName(val value: String) {
    constructor(
        entityName: EntityName,
        simpleColumnName: SimpleColumnName
    ) : this("${entityName.value}_${simpleColumnName.value}")
}