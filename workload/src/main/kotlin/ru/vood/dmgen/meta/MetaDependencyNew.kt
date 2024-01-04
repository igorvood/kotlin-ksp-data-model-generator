package ru.vood.dmgen.meta

import ru.vood.dmgen.datamodel.intf.IEntityData
import ru.vood.dmgen.datamodel.intf.IEntityOrigin
import ru.vood.dmgen.dto.EntityName

data class MetaDependencyNew<T : IEntityOrigin>(
    val toEntity: EntityName,
    val entityData: IEntityData<out T>
)