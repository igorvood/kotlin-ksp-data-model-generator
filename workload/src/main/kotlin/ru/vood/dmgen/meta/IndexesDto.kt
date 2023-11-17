package ru.vood.dmgen.meta

import ru.vood.dmgen.intf.IEntity
import ru.vood.dmgen.intf.newIntf.UKEntityData

data class IndexesDto(
    val pkEntityData: UKEntityData<out IEntity<*>>,
    val ukSet: Set<UKEntityData<out IEntity<*>>>
)
