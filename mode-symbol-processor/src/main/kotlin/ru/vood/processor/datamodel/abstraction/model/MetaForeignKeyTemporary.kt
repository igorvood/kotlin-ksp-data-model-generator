package ru.vood.processor.datamodel.abstraction.model

import kotlinx.serialization.Serializable
import ru.vood.dmgen.annotation.ForeignKeyType
import ru.vood.dmgen.dto.RelationType
import ru.vood.processor.datamodel.abstraction.model.dto.UkDto

data class MetaForeignKeyTemporary(
    val name: ForeignKeyName,
    val fromEntity: MetaEntity,
    val toEntity: MetaEntity,
    val fkCols: Set<FkCol>,
    val uk: UkDto,
    val foreignKeyType: ForeignKeyType,
)

@Serializable
data class MetaForeignKey(
    val name: ForeignKeyName,
    val fromEntity: MetaEntity,
    val toEntity: MetaEntity,
    val fkCols: Set<FkCol>,
    val uk: UkDto,
    val relationType: RelationType,
) {
    constructor(
        metaForeignKeyTemporary: MetaForeignKeyTemporary,
        relationType: RelationType,
    ) : this(
        metaForeignKeyTemporary.name,
        metaForeignKeyTemporary.fromEntity,
        metaForeignKeyTemporary.toEntity,
        metaForeignKeyTemporary.fkCols,
        metaForeignKeyTemporary.uk,
        relationType
    )

}

@JvmInline
@kotlinx.serialization.Serializable
value class ForeignKeyName(val value: String)
