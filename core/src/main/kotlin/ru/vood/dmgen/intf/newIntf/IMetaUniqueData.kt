package ru.vood.dmgen.intf.newIntf

import ru.vood.dmgen.annotation.UkName
import ru.vood.dmgen.intf.IEntityOrigin

interface IMetaUniqueData {
    val ukMap: Map<UkName, UKEntityData<out IEntityOrigin>>
}