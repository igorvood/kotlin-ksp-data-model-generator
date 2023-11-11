package ru.vood.dmgen.annotation

import ru.vood.dmgen.intf.SimpleColumnName
import ru.vood.dmgen.intf.newIntf.TypeUk

data class UkDto(
    val name: UkName,
    val cols: Set<SimpleColumnName>,
    val typeUk: TypeUk
)

@JvmInline
value class UkName(val value: String)

@JvmInline
value class FkName(val value: String)