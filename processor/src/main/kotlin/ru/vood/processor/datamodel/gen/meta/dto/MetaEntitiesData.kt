package ru.vood.processor.datamodel.gen.meta.dto

import ru.vood.dmgen.intf.EntityName
import ru.vood.dmgen.intf.IEntityOrigin
import ru.vood.dmgen.intf.newIntf.EntityData
import ru.vood.dmgen.intf.newIntf.IMetaEntityData

data class MetaEntitiesData(
    override val entMap: Map<EntityName, EntityData<IEntityOrigin>>
) : IMetaEntityData
