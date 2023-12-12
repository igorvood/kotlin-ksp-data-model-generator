package ru.vood.dmgen.meta

import ru.vood.dmgen.intf.IEntityOrigin
import ru.vood.dmgen.intf.newIntf.UKEntityData

data class IndexesMetaDto(
    val pkEntityData: UKEntityData<out IEntityOrigin>,
    val ukOnlySet: Set<UKEntityData<out IEntityOrigin>>
){
    val ukAndPkMap = ukOnlySet.plus(pkEntityData).associateBy { it.ukName }

}
