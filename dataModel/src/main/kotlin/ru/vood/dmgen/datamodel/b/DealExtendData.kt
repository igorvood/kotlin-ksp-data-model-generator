package ru.vood.dmgen.datamodel.b

import ru.vood.dmgen.annotation.*
import ru.vood.dmgen.datamodel.valueClasses.DealId

@FlowEntity(FlowEntityType.AGGREGATE)
@ForeignKey(
//    kClass = Deal::class.java.canonicalName,

    kClass = "ru.vood.dmgen.datamodel.a.Deal",
    "DealExtendData_FK",
    cols = [ForeignKeyColumns("dealId", "id")]
)

interface DealExtendData {
    @Pk
    @Comment("Это ее идентификатор")
    val dealId: DealId

    val extendData: String

}