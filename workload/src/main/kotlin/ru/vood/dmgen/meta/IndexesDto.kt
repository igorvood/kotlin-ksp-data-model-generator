package ru.vood.dmgen.meta

import ru.vood.dmgen.intf.IEntity
import ru.vood.dmgen.intf.IEntityOrigin
import ru.vood.dmgen.intf.newIntf.UKEntityData

data class IndexesDto(
    val pkEntityData: UKEntityData<out IEntityOrigin<*>>,
    val ukSet: Set<UKEntityData<out IEntityOrigin<*>>>
)
