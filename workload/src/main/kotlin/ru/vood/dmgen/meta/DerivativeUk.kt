package ru.vood.dmgen.meta

import ru.vood.dmgen.datamodel.intf.IEntityOrigin
import ru.vood.dmgen.datamodel.intf.IndexesMetaDto
import ru.vood.dmgen.datamodel.intf.UKEntityData
import ru.vood.dmgen.datamodel.metaEnum.EntityEnum
import ru.vood.dmgen.datamodel.metaEnum.UniqueKeyEnum.Companion.uniqueKeyMap
import ru.vood.dmgen.dto.TypeUk
import java.util.*


object DerivativeUk {

    val entitiesUkMap = EnumMap(uniqueKeyMap.values
        .map { uk ->
            uk.entity to uk
        }
        .groupBy(Pair<EntityEnum, UKEntityData<out IEntityOrigin>>::first)
        .map { entWithUks ->
            val pkAndUk = entWithUks.value.map { it.second }
            val pkOnly = pkAndUk.filter { it.typeUk == TypeUk.PK }
            val pkEntityData = if (pkOnly.size == 1) {
                pkOnly[0]
            } else error("for ${entWithUks.key} must be one PK")

            val ukSet = pkAndUk.filter { it.typeUk == TypeUk.UK }.toSet()
            entWithUks.key to IndexesMetaDto(pkEntityData, ukSet)
        }
        .toMap()
    )

}