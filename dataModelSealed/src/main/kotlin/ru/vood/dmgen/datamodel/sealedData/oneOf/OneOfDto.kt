package ru.vood.dmgen.datamodel.sealedData.oneOf

import ru.vood.dmgen.annotation.*
import ru.vood.dmgen.datamodel.sealedData.Deal
import ru.vood.dmgen.datamodel.valueClasses.DealId


@FlowEntity(FlowEntityType.ONE_OF)
@ForeignKey(
//    value = Deal::class,
    kClass = "ru.vood.dmgen.datamodel.sealedData.Deal",
    name = "OneOfDto_FK",
    cols = [ForeignKeyColumns("dealId", "id")],
    foreignKeyType = ForeignKeyType.MANDATORY
)
@Comment("Параметр сделки, отношение к сделке один к одному")
sealed interface OneOfDto {
    @Pk
    @Comment("Параметр сделки, отношение к сделке один к одному")
    val dealId: DealId
}

@FlowEntity(FlowEntityType.INNER)
@ForeignKey(
//    value = OneOfDto::class,
    kClass = "ru.vood.dmgen.datamodel.sealedData.oneOf.OneOfDto",
    name = "DealOneData_FK",
    cols = [ForeignKeyColumns("dealId", "dealId")],
    foreignKeyType = ForeignKeyType.MANDATORY
)
@Comment("Параметр сделки, отношение к сделке один к одному")
interface DealOneData {
    @Pk
    @Comment("Это ее идентификатор")
    val dealId: DealId
    @Comment("Параметр сделки, отношение к сделке один к одному")
    val one: String
}


@FlowEntity(FlowEntityType.INNER)
@ForeignKey(
//    value = OneOfDto::class,
    kClass = "ru.vood.dmgen.datamodel.sealedData.oneOf.OneOfDto",
    name = "DealTwoData_FK",
    cols = [ForeignKeyColumns("dealId", "dealId")],
    foreignKeyType = ForeignKeyType.MANDATORY
)
@Comment("Параметр сделки, отношение к сделке один к одному")
interface DealTwoData {
    @Pk
    @Comment("Это ее идентификатор")
    val dealId: DealId

    @Comment("Параметр сделки, отношение к сделке один к одному")
    val two: String?
}

