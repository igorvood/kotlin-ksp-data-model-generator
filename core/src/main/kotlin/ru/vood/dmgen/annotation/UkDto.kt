package ru.vood.dmgen.annotation

import ru.vood.dmgen.intf.ColumnName
import ru.vood.dmgen.intf.newIntf.TypeUk

data class UkDto(
    val name: UkName,
    val cols: Set<ColumnName>,
    val typeUk: TypeUk
)

@JvmInline
value class UkName(val value: String)