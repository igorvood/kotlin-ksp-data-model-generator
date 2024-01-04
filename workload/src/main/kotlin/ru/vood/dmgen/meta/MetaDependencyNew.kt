package ru.vood.dmgen.meta

import ru.vood.dmgen.datamodel.intf.IEntityData
import ru.vood.dmgen.datamodel.intf.IEntityOrigin
import ru.vood.dmgen.intf.EntityName

data class MetaDependencyNew<T : IEntityOrigin>(
    val toEntity: EntityName,
    val entityData: IEntityData<out T>
)