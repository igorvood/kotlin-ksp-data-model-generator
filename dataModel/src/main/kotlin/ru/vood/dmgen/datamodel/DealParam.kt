package ru.vood.dmgen.datamodel

import ru.vood.dmgen.annotation.*
import ru.vood.dmgen.datamodel.a.Deal
import ru.vood.dmgen.datamodel.valueClasses.DealId

@FlowEntity(FlowEntityType.INNER)
@ForeignKey(
//    value = Deal::class,
    kClass = "ru.vood.dmgen.datamodel.a.Deal",
    name = "DealParamOneToOne_Deal_FK",
    cols = [ForeignKeyColumns("dealId", "id")],
    foreignKeyType = ForeignKeyType.MANDATORY
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

@FlowEntity(FlowEntityType.INNER)
@ForeignKey(
//    value = DealParamOneToOne::class,
    kClass = "ru.vood.dmgen.datamodel.DealParamOneToOne",
    name = "InnerToDealParamOneToOne_DealParamOneToOne_FK",
    cols = [ForeignKeyColumns("dealId", "dealId")],
    foreignKeyType = ForeignKeyType.MANDATORY
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
//    value = Deal::class,
    kClass = "ru.vood.dmgen.datamodel.a.Deal",
    name = "DealParamOneToOneOptional_Deal_FK",
    cols = [ForeignKeyColumns("dealId", "id")],
    foreignKeyType = ForeignKeyType.OPTIONAL
)
interface DealParamOneToOneOptional {
    @Pk
    val dealId: DealId
    val paramDate: String
}

@FlowEntity//(FlowEntityType.INNER_MANDATORY)
@ForeignKey(
//    value = Deal::class,
    kClass = "ru.vood.dmgen.datamodel.a.Deal",
    name = "DealParamSet_Deal_FK",
    cols = [ForeignKeyColumns("dealId", "id")],
    foreignKeyType = ForeignKeyType.MANDATORY
)
interface DealParamSet {
    @Pk
    val dealId: DealId

    @Pk
    val id: Int

    val paramDate: String
}
