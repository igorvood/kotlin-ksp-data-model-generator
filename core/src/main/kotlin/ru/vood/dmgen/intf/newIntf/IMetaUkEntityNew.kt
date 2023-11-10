package ru.vood.dmgen.intf.newIntf

import ru.vood.dmgen.intf.ColumnName
import ru.vood.dmgen.intf.EntityName
import ru.vood.dmgen.intf.IContextOf
import ru.vood.dmgen.intf.IEntity

interface IMetaUkEntityNew<T : IEntity<T>> {
    val columns: Set<ColumnName>
    val entity: EntityName
    val extractContext: (T) -> IContextOf<T>
    val typeUk: TypeUk
//    val contextOfClass: KClass<IContextOf<T>>
}

data class UKEntityData<T : IEntity<T>>(
    override val columns: Set<ColumnName>,
    override val entity: EntityName,
    override val extractContext: (T) -> IContextOf<T>,
    override val typeUk: TypeUk
//    override val contextOfClass: KClass<IContextOf<T>>
) : IMetaUkEntityNew<T> {
}

enum class TypeUk {
    PK, UK
}