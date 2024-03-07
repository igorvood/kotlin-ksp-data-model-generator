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
    val ukFrom: UkDto?,
    val foreignKeyType: ForeignKeyType,
)

@Serializable
data class MetaForeignKey(
    val name: ForeignKeyName,
    val fromEntity: MetaEntity,
    val toEntity: MetaEntity,
    val fkCols: Set<FkCol>,
    val uk: UkDto,
    val ukFrom: UkDto?,
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
        metaForeignKeyTemporary.ukFrom,
        relationType
    )

    init {
        when (relationType) {
            RelationType.MANY_TO_ONE -> {}
            RelationType.ONE_TO_ONE_MANDATORY, RelationType.ONE_TO_ONE_OPTIONAL -> require(ukFrom != null) { "for Foreign Key ${name.value} with relationType ->$relationType field ukFrom must be not null " }
        }
    }
}

@JvmInline
@Serializable
value class ForeignKeyName(val value: String)
