package ru.vood.dmgen.meta

import ru.vood.dmgen.datamodel.metaEnum.uniqueKeyMap
import ru.vood.dmgen.intf.EntityName
import ru.vood.dmgen.intf.IEntityOrigin
import ru.vood.dmgen.intf.newIntf.TypeUk
import ru.vood.dmgen.intf.newIntf.UKEntityData

object DerivativeUk {

    val entitiesUkMap = uniqueKeyMap.values.map { uk ->
        uk.entity to uk
    }
        .groupBy(Pair<EntityName, UKEntityData<out IEntityOrigin>>::first)
        .map { d ->
            val map = d.value.map { it.second }
            val filter = map.filter { it.typeUk == TypeUk.PK }
            val pkEntityData = if (filter.size == 1) {
                filter[0]
            } else error("for ${d.key.value} must be one PK")

            val ukSet = map.filter { it.typeUk == TypeUk.UK }.toSet()
            d.key to IndexesMetaDto(pkEntityData, ukSet)
        }
        .toMap()

}