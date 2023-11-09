package ru.vood.processor.datamodel.abstraction.model.dto

import ru.vood.dmgen.intf.ColumnName

data class UkDto(
    val name: UkName,
    val cols: Set<ColumnName>
)

@JvmInline
value class UkName(val value: String)