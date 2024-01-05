package ru.vood.dmgen.meta

import ru.vood.dmgen.datamodel.intf.IEntityData
import ru.vood.dmgen.datamodel.intf.IEntityOrigin
import ru.vood.dmgen.datamodel.metaEnum.EntityEnum

data class MetaDependencyNew(
    val toEntity: EntityEnum,
    val entityData: IEntityData
)