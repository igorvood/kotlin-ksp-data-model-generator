package ru.vood.processor.datamodel.abstraction.model.serializer

@kotlinx.serialization.Serializable
data class ClassNameSerial(
    val packageName: String,
    val simpleName: String,
)


