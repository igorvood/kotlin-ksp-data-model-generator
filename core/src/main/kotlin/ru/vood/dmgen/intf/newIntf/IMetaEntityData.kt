package ru.vood.dmgen.intf.newIntf

import ru.vood.dmgen.intf.EntityName
import ru.vood.dmgen.intf.IEntityOrigin

interface IMetaEntityData {
    val entMap: Map<EntityName, EntityData<IEntityOrigin>>
}





