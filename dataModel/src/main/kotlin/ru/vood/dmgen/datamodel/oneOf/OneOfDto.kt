package ru.vood.dmgen.datamodel.oneOf

import ru.vood.dmgen.annotation.*
import ru.vood.dmgen.datamodel.valueClasses.DealId


@FlowEntity(FlowEntityType.AGGREGATE)
@ForeignKey(
//    kClass = Deal::class.java.canonicalName,

    kClass = "ru.vood.dmgen.datamodel.a.Deal",
    "OneOfDto_FK",
    cols = [ForeignKeyColumns("dealId", "id")]
)
interface OneOfDto {
    @Pk
    val dealId: DealId
    val paramDate: String
}

@FlowEntity(FlowEntityType.INNER_MANDATORY)
@ForeignKey(
    kClass = "ru.vood.dmgen.datamodel.oneOf.OneOfDto",
    "DealOneOfData_FK",
    cols = [ForeignKeyColumns("dealId", "dealId")]
)
@kotlinx.serialization.Serializable
sealed interface DealOneOfData {
    @Pk
    @Comment("Это ее идентификатор")
    val dealId: DealId
}


@FlowEntity(FlowEntityType.INNER_MANDATORY)
@ForeignKey(
    kClass = "ru.vood.dmgen.datamodel.oneOf.DealOneOfData",
    "DealOneData_FK",
    cols = [ForeignKeyColumns("dealId", "dealId")]
)
interface DealOneData {
    @Pk
    @Comment("Это ее идентификатор")
    val dealId: DealId

    val one: String?
}


@FlowEntity(FlowEntityType.INNER_MANDATORY)
@ForeignKey(
    kClass = "ru.vood.dmgen.datamodel.oneOf.DealOneOfData",
    "DealTwoData_FK",
    cols = [ForeignKeyColumns("dealId", "dealId")]
)
interface DealTwoData {
    @Pk
    @Comment("Это ее идентификатор")
    val dealId: DealId

    val two: String?
}

