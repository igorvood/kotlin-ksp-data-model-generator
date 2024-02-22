package ru.vood.dmgen.datamodel.sealedData

import ru.vood.dmgen.annotation.*
import ru.vood.dmgen.datamodel.valueClasses.DealId

@FlowEntity(FlowEntityType.AGGREGATE)
@ForeignKey(
//    value = Deal::class,
    kClass = "ru.vood.dmgen.datamodel.sealedData.Deal",
    name = "DealParamaggregate_FK",
    cols = [ForeignKeyColumns("dealId", "id")],
    foreignKeyType = ForeignKeyType.OPTIONAL
)
@Comment("Параметр сделки, Агрегат")
interface DealParamaggregate {
    @Comment("Идентификатор сделки")
    @Pk
    val dealId: DealId

}