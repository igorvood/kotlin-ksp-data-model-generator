package ru.vood.dmgen.dto


@JvmInline
@Deprecated("в будующем будет enum")
value class FullColumnName(val value: String) {
    constructor(
        entityName: EntityName1,
        simpleColumnName: SimpleColumnName
    ) : this("${entityName.value}_${simpleColumnName.value}")
}