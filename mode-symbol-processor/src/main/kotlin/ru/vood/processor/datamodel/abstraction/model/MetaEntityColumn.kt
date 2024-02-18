package ru.vood.processor.datamodel.abstraction.model

import com.squareup.kotlinpoet.TypeName
import ru.vood.dmgen.dto.SimpleColumnName

data class MetaEntityColumn(
    val name: SimpleColumnName,
    val inPk: Boolean,
    val isNullable: Boolean,
    val type: String,
    val typePoetClassName: TypeName,
    val position: Int,
    val comment: String,

    ) {
    @Deprecated("не нужен")
    val question = if (isNullable) {
        "?"
    } else {
        ""
    }
}