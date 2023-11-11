package ru.vood.dmgen.intf.newIntf

import ru.vood.dmgen.annotation.RelationType
import ru.vood.dmgen.intf.*

interface IMetaFkEntityNew<T : IEntity<T>> {
    val fromEntity: IMetaUkEntityNew<T>
    val toEntity: IMetaUkEntityNew<T>
    val uk: IMetaUkEntityNew<T>
    val relationType: RelationType
    val fkCols: Set<FkPair>
//    val contextOfClass: KClass<IContextOf<T>>
}

data class FKEntityData<T : IEntity<T>>(
    override val fromEntity: IMetaUkEntityNew<T>,
    override val toEntity: IMetaUkEntityNew<T>,
    override val uk: IMetaUkEntityNew<T>,
    override val relationType: RelationType,
    override val fkCols: Set<FkPair>
//    override val contextOfClass: KClass<IContextOf<T>>
) : IMetaFkEntityNew<T> {
}
