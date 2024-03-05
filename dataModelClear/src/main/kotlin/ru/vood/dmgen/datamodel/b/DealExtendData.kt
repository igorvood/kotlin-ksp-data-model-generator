package ru.vood.dmgen.datamodel.b

import ru.vood.dmgen.annotation.*
import ru.vood.dmgen.datamodel.deal.Deal
import ru.vood.dmgen.datamodel.valueClasses.DealId

@FlowEntity(FlowEntityType.AGGREGATE)
@ForeignKey(
//    value = Deal::class,
    kClass = "ru.vood.dmgen.datamodel.deal.Deal",
    name = "DealExtendData_FK",
    cols = [ForeignKeyColumns("dealId", "id")],
    foreignKeyType = ForeignKeyType.MANDATORY
)
@Comment("Параметр сделки, отношение к сделке один к одному")
interface DealExtendData {
    @Pk
    @Comment("Это ее идентификатор")
    val dealId: DealId

    @Comment("Параметр сделки, отношение к сделке один к одному")
    val extendData: String

}