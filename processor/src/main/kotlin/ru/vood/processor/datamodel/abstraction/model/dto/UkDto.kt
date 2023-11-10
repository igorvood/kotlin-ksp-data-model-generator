package ru.vood.processor.datamodel.abstraction.model.dto

import ru.vood.dmgen.annotation.UkName
import ru.vood.dmgen.intf.ColumnName
import ru.vood.dmgen.intf.newIntf.TypeUk

data class UkDto(
    val name: UkName,
    val cols: Set<ColumnName>,
    val typeUk: TypeUk
)

//@JvmInline
//value class UkName(val value: String)