package ru.vood.processor.datamodel.gen.meta.dto

import ru.vood.dmgen.annotation.UkName
import ru.vood.dmgen.intf.IEntityOrigin
import ru.vood.dmgen.intf.newIntf.IMetaUniqueData
import ru.vood.dmgen.intf.newIntf.UKEntityData

data class MetaUniqueKeysData(
    override val ukMap: Map<UkName, UKEntityData<out IEntityOrigin>>
) : IMetaUniqueData