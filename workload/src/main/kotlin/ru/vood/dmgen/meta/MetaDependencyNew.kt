package ru.vood.dmgen.meta

import ru.vood.dmgen.intf.EntityName
import ru.vood.dmgen.intf.IEntityOrigin
import ru.vood.dmgen.intf.newIntf.EntityData
import ru.vood.dmgen.intf.newIntf.IEntityData

data class MetaDependencyNew<T : IEntityOrigin>(
    val toEntity: EntityName,
    val entityData: IEntityData<out T>
)