package ru.vood.dmgen.intf.newIntf

import ru.vood.dmgen.intf.EntityName
import ru.vood.dmgen.intf.IContextOf
import ru.vood.dmgen.intf.IEntityOrigin
import ru.vood.dmgen.intf.SimpleColumnName



data class UKEntityData<T : IEntityOrigin<T>>(
     val columns: List<SimpleColumnName>,
     val entity: EntityName,
     val extractContext: (T) -> IContextOf<T>,
     val typeUk: TypeUk
//    override val contextOfClass: KClass<IContextOf<T>>
)

enum class TypeUk {
    PK, UK
}