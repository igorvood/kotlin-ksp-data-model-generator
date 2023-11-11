package ru.vood.processor.datamodel.abstraction.model.dto

import ru.vood.dmgen.annotation.RelationType
import ru.vood.processor.datamodel.abstraction.model.MetaEntity

data class SyntheticFieldInfo(
    val metaEntity: MetaEntity,
    val isOptional: Boolean,
    val relationType: RelationType
)