package ru.vood.dmgen.intf

import ru.vood.dmgen.dto.EntityName


@JvmInline
value class FullColumnName(val value: String) {
    constructor(
        entityName: EntityName,
        simpleColumnName: SimpleColumnName
    ) : this("${entityName.value}_${simpleColumnName.value}")
}