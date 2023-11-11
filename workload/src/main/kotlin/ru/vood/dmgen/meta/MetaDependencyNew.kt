package ru.vood.dmgen.meta

import ru.vood.dmgen.intf.EntityName
import ru.vood.dmgen.intf.IEntity
import ru.vood.dmgen.intf.newIntf.EntityData

data class MetaDependencyNew<T : IEntity<out T>>(
    val toEntity: EntityName,
    val entityData: EntityData<out T>
    )