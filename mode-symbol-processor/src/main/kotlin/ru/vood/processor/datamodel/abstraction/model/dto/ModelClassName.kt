package ru.vood.processor.datamodel.abstraction.model.dto

import kotlinx.serialization.Serializable

@JvmInline
@Serializable
value class ModelClassName(
    val value: String,
)