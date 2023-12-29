package ru.vood.dmgen.datamodel

import ru.vood.dmgen.annotation.*
import ru.vood.dmgen.datamodel.valueClasses.DealId

@FlowEntity(FlowEntityType.INNER_MANDATORY)
@ForeignKey(
    kClass = "ru.vood.dmgen.datamodel.a.Deal",
    "DealParamOneToOne_Deal_FK",
    cols = [ForeignKeyColumns("dealId", "id")]
)
@Uk(
    "DealParamOneToOne_UK",
    ["dealId", "paramDate"]
)
interface DealParamOneToOne {
    @Pk
    val dealId: DealId
    val paramDate: String
}

@FlowEntity(FlowEntityType.INNER_MANDATORY)
@ForeignKey(
    kClass = "ru.vood.dmgen.datamodel.DealParamOneToOne",
    "InnerToDealParamOneToOne_DealParamOneToOne_FK",
    cols = [ForeignKeyColumns("dealId", "dealId")]
)
@Uk(
    "DealParamOneToOne_UK2",
    ["dealId", "paramDate"]
)
interface InnerToDealParamOneToOne {
    @Pk
    val dealId: DealId
    val paramDate: String
}


@FlowEntity
@ForeignKey(
    kClass = "ru.vood.dmgen.datamodel.a.Deal",
    "DealParamOneToOneOptional_Deal_FK",
    cols = [ForeignKeyColumns("dealId", "id")]
)
interface DealParamOneToOneOptional {
    @Pk
    val dealId: DealId
    val paramDate: String
}

@FlowEntity//(FlowEntityType.INNER_MANDATORY)
@ForeignKey(
    kClass = "ru.vood.dmgen.datamodel.a.Deal",
    "DealParamSet_Deal_FK",
    cols = [ForeignKeyColumns("dealId", "id")]
)
interface DealParamSet {
    @Pk
    val dealId: DealId

    @Pk
    val id: Int

    val paramDate: String
}
