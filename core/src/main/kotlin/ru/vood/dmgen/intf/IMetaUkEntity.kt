package ru.vood.dmgen.intf

import ru.vood.dmgen.intf.newIntf.TypeUk
import kotlin.reflect.KClass

interface IMetaUkEntity {
    val columns: Set<IMetaColumnEntity>
    val entity: IMetaEntity
    val contextOfClass: KClass<*>
    val typeUk: TypeUk
}
