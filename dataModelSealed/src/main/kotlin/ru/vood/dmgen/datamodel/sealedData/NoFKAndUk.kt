package ru.vood.dmgen.datamodel.sealedData

import ru.vood.dmgen.annotation.*
import ru.vood.dmgen.datamodel.valueClasses.DealId

@FlowEntity(FlowEntityType.INNER)
@ForeignKey(
    kClass = "ru.vood.dmgen.datamodel.sealedData.Deal",
    name = "NoFKAndUk_FK",
    cols = [ForeignKeyColumns("dealId", "id")],
    foreignKeyType = ForeignKeyType.MANDATORY
)
sealed interface NoFKAndUk {
    val dealId: DealId
}