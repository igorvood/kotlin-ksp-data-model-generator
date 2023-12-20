package ru.vood.dmgen.datamodel

import ru.vood.dmgen.annotation.*
import ru.vood.dmgen.datamodel.valueClasses.DealId

//@FlowEntity(FlowEntityType.INNER_MANDATORY)
@ForeignKey(
    kClass = "ru.vood.dmgen.datamodel.a.Deal",
    "DealOneOfData_FK",
    cols = [ForeignKeyColumns("dealId", "id")]
)
@kotlinx.serialization.Serializable
sealed interface DealOneOfData {
    @Pk
    @Comment("Это ее идентификатор")
    val dealId: DealId
}


//@FlowEntity(FlowEntityType.INNER_MANDATORY)
@ForeignKey(
    kClass = "ru.vood.dmgen.datamodel.DealOneOfData",
    "DealOneData_FK",
    cols = [ForeignKeyColumns("dealId", "dealId")]
)
interface DealOneData {
    @Pk
    @Comment("Это ее идентификатор")
    val dealId: DealId

    val one: String?
}


//@FlowEntity(FlowEntityType.INNER_MANDATORY)
@ForeignKey(
    kClass = "ru.vood.dmgen.datamodel.DealOneOfData",
    "DealTwoData_FK",
    cols = [ForeignKeyColumns("dealId", "dealId")]
)
interface DealTwoData {
    @Pk
    @Comment("Это ее идентификатор")
    val dealId: DealId

    val two: String?
}

