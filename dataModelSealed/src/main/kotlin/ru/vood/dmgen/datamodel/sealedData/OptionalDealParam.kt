package ru.vood.dmgen.datamodel.sealedData

import ru.vood.dmgen.annotation.*
import ru.vood.dmgen.datamodel.valueClasses.DealId

@FlowEntity(FlowEntityType.INNER)
@ForeignKey(
//    value = Deal::class,
    kClass = "ru.vood.dmgen.datamodel.sealedData.Deal",
    name = "OptionalDealParam_FK",
    cols = [ForeignKeyColumns("dealId", "id")],
    foreignKeyType = ForeignKeyType.OPTIONAL
)
@Uk(
    "OptionalDealParam_UK",
    ["paramId"]
)
@Comment("Параметр сделки, отношение к сделке один к одному, опциональный")
interface OptionalDealParam {
    @Comment("Идентификатор сделки")
    @Pk
    val dealId: DealId

    @Comment("Идентификатор параметра")
    val paramId: Int
}