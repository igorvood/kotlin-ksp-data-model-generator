package ru.vood.processor.datamodel.abstraction.model

import com.squareup.kotlinpoet.ClassName
import ru.vood.dmgen.annotation.ForeignKeyType

data class ForeignKeyAnnotationDto(
    val kClass: ClassName,
    val name: String,
    val cols: List<ForeignKeyColumnsDto>,
    val foreignKeyType: ForeignKeyType
)

data class ForeignKeyColumnsDto(
    val currentColName: String,
    val outColName: String,
)