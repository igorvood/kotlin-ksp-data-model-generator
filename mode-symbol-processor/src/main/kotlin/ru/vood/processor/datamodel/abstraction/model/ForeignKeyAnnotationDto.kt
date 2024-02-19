package ru.vood.processor.datamodel.abstraction.model

import com.squareup.kotlinpoet.ClassName
import kotlinx.serialization.Serializable
import ru.vood.dmgen.annotation.ForeignKeyType
import ru.vood.processor.datamodel.abstraction.model.serializer.ClassNameSerializer

@Serializable
data class ForeignKeyAnnotationDto(
    @Serializable(ClassNameSerializer::class)
    val kClass: ClassName,
    val name: String,
    val cols: List<ForeignKeyColumnsDto>,
    val foreignKeyType: ForeignKeyType,
)

@Serializable
data class ForeignKeyColumnsDto(
    val currentColName: String,
    val outColName: String,
)