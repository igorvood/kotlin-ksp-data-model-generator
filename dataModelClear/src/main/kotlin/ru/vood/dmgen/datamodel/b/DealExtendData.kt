package ru.vood.dmgen.datamodel.b

import ru.vood.dmgen.annotation.*

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
    val dealId: Int

    @Comment("Параметр сделки, отношение к сделке один к одному")
    val extendData: String

}