package ru.vood.dmgen.intf.newIntf

import ru.vood.dmgen.intf.EntityName
import ru.vood.dmgen.intf.IContextOf
import ru.vood.dmgen.intf.IEntityOrigin
import ru.vood.dmgen.intf.SimpleColumnName

interface IMetaUkEntityNew<T : IEntityOrigin<T>> {
    val columns: List<SimpleColumnName>
    val entity: EntityName
    val extractContext: (T) -> IContextOf<T>
    val typeUk: TypeUk
//    val contextOfClass: KClass<IContextOf<T>>
}

data class UKEntityData<T : IEntityOrigin<T>>(
    override val columns: List<SimpleColumnName>,
    override val entity: EntityName,
    override val extractContext: (T) -> IContextOf<T>,
    override val typeUk: TypeUk
//    override val contextOfClass: KClass<IContextOf<T>>
) : IMetaUkEntityNew<T> {
}

enum class TypeUk {
    PK, UK
}