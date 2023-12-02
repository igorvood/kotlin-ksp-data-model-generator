package ru.vood.dmgen.intf.newIntf

import ru.vood.dmgen.annotation.RelationType
import ru.vood.dmgen.annotation.UkName
import ru.vood.dmgen.intf.*

interface IMetaFkEntityNew<T : IEntityOrigin<T>> {
    val fromEntity: EntityName
    val toEntity: EntityName
    val uk: UkName
    val relationType: RelationType
    val fkCols: Set<FkPairNew>
    val extractJsonContext: (T) -> IContextOf<out IEntityOrigin<*>>
//    val contextOfClass: KClass<IContextOf<T>>
}

data class FKEntityData<T : IEntityOrigin<T>>(
    override val fromEntity: EntityName,
    override val toEntity: EntityName,
    override val uk: UkName,
    override val relationType: RelationType,
    override val fkCols: Set<FkPairNew>,
    override val extractJsonContext: (T) -> IContextOf<out IEntityOrigin<*>>
//    override val contextOfClass: KClass<IContextOf<T>>
) : IMetaFkEntityNew<T> {
}


data class FkPairNew(
    val from: FullColumnName,
    val to: FullColumnName
)
