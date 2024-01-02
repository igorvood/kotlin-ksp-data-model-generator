package ru.vood.dmgen.datamodel.sealedData.oneOf

import ru.vood.dmgen.annotation.*
import ru.vood.dmgen.datamodel.valueClasses.DealId


@FlowEntity(FlowEntityType.AGGREGATE)
@ForeignKey(
    kClass = "ru.vood.dmgen.datamodel.sealedData.Deal",
    name = "OneOfDto_FK",
    cols = [ForeignKeyColumns("dealId", "id")],
    foreignKeyType = ForeignKeyType.MANDATORY
)
sealed interface OneOfDto {
    @Pk
    val dealId: DealId
}

@FlowEntity(FlowEntityType.INNER)
@ForeignKey(
    kClass = "ru.vood.dmgen.datamodel.sealedData.oneOf.OneOfDto",
    name = "DealOneData_FK",
    cols = [ForeignKeyColumns("dealId", "dealId")],
    foreignKeyType = ForeignKeyType.MANDATORY
)
interface DealOneData {
    @Pk
    @Comment("Это ее идентификатор")
    val dealId: DealId
    val one: String
}


@FlowEntity(FlowEntityType.INNER)
@ForeignKey(
    kClass = "ru.vood.dmgen.datamodel.sealedData.oneOf.OneOfDto",
    name = "DealTwoData_FK",
    cols = [ForeignKeyColumns("dealId", "dealId")],
    foreignKeyType = ForeignKeyType.MANDATORY
)
interface DealTwoData {
    @Pk
    @Comment("Это ее идентификатор")
    val dealId: DealId

    val two: String?
}

