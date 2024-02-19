package ru.vood.processor.datamodel.abstraction.model

@kotlinx.serialization.Serializable
data class FkCol(
    val from: MetaEntityColumn,
    val to: MetaEntityColumn,
) {

}
