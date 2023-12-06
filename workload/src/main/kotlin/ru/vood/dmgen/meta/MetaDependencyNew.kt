package ru.vood.dmgen.meta

import ru.vood.dmgen.intf.EntityName
import ru.vood.dmgen.intf.IEntityOrigin
import ru.vood.dmgen.intf.newIntf.EntityData

data class MetaDependencyNew<T : IEntityOrigin>(
    val toEntity: EntityName,
    val entityData: EntityData<out T>
)