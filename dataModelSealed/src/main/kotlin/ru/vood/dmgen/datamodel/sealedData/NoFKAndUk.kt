package ru.vood.dmgen.datamodel.sealedData

import ru.vood.dmgen.annotation.*
import ru.vood.dmgen.datamodel.valueClasses.DealId

@FlowEntity(FlowEntityType.INNER)
@ForeignKey(
//    value = Deal::class,
    kClass = "ru.vood.dmgen.datamodel.sealedData.Deal",
    name = "NoFKAndUk_FK",
    cols = [ForeignKeyColumns("dealId", "id")],
    foreignKeyType = ForeignKeyType.MANDATORY
)
@Comment("Параметр сделки, отношение к сделке один к одному")
sealed interface NoFKAndUk {
    @Comment("Параметр сделки, отношение к сделке один к одному")
    val dealId: DealId
}