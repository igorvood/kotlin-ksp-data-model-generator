package ru.vood.processor.datamodel.abstraction.model.dto

import ru.vood.dmgen.dto.UkName
import ru.vood.dmgen.dto.SimpleColumnName
import ru.vood.dmgen.annotation.TypeUk


data class UkDto(
    val name: UkName,
    val cols: Set<SimpleColumnName>,
    val typeUk: TypeUk
)

//@JvmInline
//value class UkName(val value: String)