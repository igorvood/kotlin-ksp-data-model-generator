package ru.vood.dmgen.datamodel.oneOf

import ru.vood.dmgen.annotation.*
import ru.vood.dmgen.datamodel.valueClasses.DealId


@FlowEntity(FlowEntityType.AGGREGATE)
@ForeignKey(
//    kClass = Deal::class.java.canonicalName,

    kClass = "ru.vood.dmgen.datamodel.a.Deal",
    "OneOfDto_FK",
    cols = [ForeignKeyColumns("dealId", "id")],
    foreignKeyType = ForeignKeyType.OPTIONAL
)
interface OneOfDto {
    @Pk
    val dealId: DealId
    val paramDate: String
}

@FlowEntity(FlowEntityType.INNER)
@ForeignKey(
    kClass = "ru.vood.dmgen.datamodel.oneOf.OneOfDto",
    "DealOneOfData_FK",
    cols = [ForeignKeyColumns("dealId", "dealId")],
    foreignKeyType = ForeignKeyType.MANDATORY
)
@kotlinx.serialization.Serializable
sealed interface DealOneOfData {
    @Pk
    @Comment("Это ее идентификатор")
    val dealId: DealId
}


@FlowEntity(FlowEntityType.INNER)
@ForeignKey(
    kClass = "ru.vood.dmgen.datamodel.oneOf.DealOneOfData",
    "DealOneData_FK",
    cols = [ForeignKeyColumns("dealId", "dealId")],
    foreignKeyType = ForeignKeyType.MANDATORY
)
interface DealOneData {
    @Pk
    @Comment("Это ее идентификатор")
    val dealId: DealId

    val one: String?
}


@FlowEntity(FlowEntityType.INNER)
@ForeignKey(
    kClass = "ru.vood.dmgen.datamodel.oneOf.DealOneOfData",
    "DealTwoData_FK",
    cols = [ForeignKeyColumns("dealId", "dealId")],
    foreignKeyType = ForeignKeyType.MANDATORY
)
interface DealTwoData {
    @Pk
    @Comment("Это ее идентификатор")
    val dealId: DealId

    val two: String?
}

