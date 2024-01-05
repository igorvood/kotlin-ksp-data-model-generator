package ru.vood.dmgen.dto


@JvmInline
@Deprecated("в будующем будет enum")
value class FullColumnName1(val value: String) {
    constructor(
        entityName: EntityName,
        simpleColumnName: SimpleColumnName
    ) : this("${entityName.value}_${simpleColumnName.value}")
}