package ru.vood.processor.datamodel.abstraction.model.dto

import ru.vood.dmgen.dto.SimpleColumnName
import ru.vood.dmgen.dto.TypeUk
import ru.vood.dmgen.dto.UkName1


data class UkDto(
    val name: UkName1,
    val cols: Set<SimpleColumnName>,
    val typeUk: TypeUk
)

//@JvmInline
//value class UkName(val value: String)