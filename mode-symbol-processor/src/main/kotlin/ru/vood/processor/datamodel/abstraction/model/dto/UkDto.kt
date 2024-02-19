package ru.vood.processor.datamodel.abstraction.model.dto

import kotlinx.serialization.Serializable
import ru.vood.dmgen.dto.SimpleColumnName
import ru.vood.dmgen.dto.TypeUk
import ru.vood.dmgen.dto.UkName


@Serializable
data class UkDto(
    val name: UkName,
    val cols: List<SimpleColumnName>,
    val typeUk: TypeUk,
)

//@JvmInline
//value class UkName(val value: String)