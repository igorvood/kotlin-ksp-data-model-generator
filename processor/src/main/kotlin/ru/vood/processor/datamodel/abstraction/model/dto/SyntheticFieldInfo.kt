package ru.vood.processor.datamodel.abstraction.model.dto

import ru.vood.dmgen.annotation.RelationType
import ru.vood.processor.datamodel.abstraction.model.MetaEntity


sealed interface ISyntheticFieldInfo {
    val relationType: RelationType
    val isOneOf: Boolean
}

data class SyntheticFieldInfo(
    val metaEntity: MetaEntity,
    override val relationType: RelationType,
    override val isOneOf: Boolean,
) : ISyntheticFieldInfo

data class SealedSyntheticFieldInfo(
    val metaEntities: Set<MetaEntity>,
    override val relationType: RelationType,
    override val isOneOf: Boolean,
) : ISyntheticFieldInfo


//val partOfMetaEntity: MetaEntity?
