package ru.vood.dmgen.meta

import ru.vood.dmgen.intf.IEntityOrigin
import ru.vood.dmgen.intf.newIntf.UKEntityData

/**Мета информаци по уникальным индексам и первичным ключам*/
data class IndexesMetaDto(
    /**Мета по первичному ключу*/
    val pkEntityData: UKEntityData<out IEntityOrigin>,
    /**мета по уникальным индексам, исключая первичный ключ*/
    val ukOnlySet: Set<UKEntityData<out IEntityOrigin>>
){
    /**мета по уникальным индексам включая первичный ключ*/
    val ukAndPkMap = ukOnlySet.plus(pkEntityData).associateBy { it.ukName }

}
