package ru.vood.dmgen.intf.newIntf

import ru.vood.dmgen.annotation.RelationType
import ru.vood.dmgen.annotation.UkName
import ru.vood.dmgen.intf.EntityName
import ru.vood.dmgen.intf.FullColumnName
import ru.vood.dmgen.intf.IContextOf
import ru.vood.dmgen.intf.IEntityOrigin


data class FKEntityData<T : IEntityOrigin>(
    val fromEntity: EntityName,
    val toEntity: EntityName,
    val uk: UkName,
    val relationType: RelationType,
    val fkCols: Set<FkPairNew>,
    val extractJsonContext: (T) -> IContextOf<out IEntityOrigin>
//    override val contextOfClass: KClass<IContextOf<T>>
)


data class FkPairNew(
    val from: FullColumnName,
    val to: FullColumnName
)
