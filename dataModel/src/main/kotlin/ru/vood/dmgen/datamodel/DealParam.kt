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
@Comment("Параметр сделки, отношение к сделке один к одному")
interface DealParamOneToOne {
    @Pk
    @Comment("Параметр сделки, отношение к сделке один к одному")
    val dealId: DealId
    @Comment("Параметр сделки, отношение к сделке один к одному")
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
@Comment("Параметр сделки, отношение к сделке один к одному")
interface InnerToDealParamOneToOne {
    @Pk
    @Comment("Параметр сделки, отношение к сделке один к одному")
    val dealId: DealId
    @Comment("Параметр сделки, отношение к сделке один к одному")
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
@Comment("Параметр сделки, отношение к сделке один к одному")
interface DealParamOneToOneOptional {
    @Pk
    @Comment("Параметр сделки, отношение к сделке один к одному")
    val dealId: DealId
    @Comment("Параметр сделки, отношение к сделке один к одному")
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
@Comment("Параметр сделки, отношение к сделке один к одному")
interface DealParamSet {
    @Pk
    @Comment("Параметр сделки, отношение к сделке один к одному")
    val dealId: DealId

    @Pk
    @Comment("Параметр сделки, отношение к сделке один к одному")
    val id: Int

    @Comment("Параметр сделки, отношение к сделке один к одному")
    val paramDate: String
}
