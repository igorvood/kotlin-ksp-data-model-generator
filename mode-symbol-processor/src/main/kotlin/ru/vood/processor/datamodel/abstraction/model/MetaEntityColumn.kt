package ru.vood.processor.datamodel.abstraction.model

import com.squareup.kotlinpoet.TypeName
import kotlinx.serialization.Serializable
import ru.vood.dmgen.dto.SimpleColumnName
import ru.vood.processor.datamodel.abstraction.model.serializer.ClassNameSerializer

@Serializable
data class MetaEntityColumn(
    val name: SimpleColumnName,
    val inPk: Boolean,
    val isNullable: Boolean,
    val type: String,
    @Serializable(ClassNameSerializer::class)
    val typePoetClassName: TypeName,
    val position: Int,
    val comment: String,

    ) {
    @kotlinx.serialization.Transient
    @Deprecated("не нужен")
    val question = if (isNullable) {
        "?"
    } else {
        ""
    }
}