package ru.vood.dmgen.datamodel.oneOf

import ru.vood.dmgen.annotation.*
import ru.vood.dmgen.datamodel.a.Deal
import ru.vood.dmgen.datamodel.valueClasses.DealId


@FlowEntity(FlowEntityType.AGGREGATE)
@ForeignKey(
//    value = Deal::class,
    kClass = "ru.vood.dmgen.datamodel.a.Deal",
    name ="OneOfDto_FK",
    cols = [ForeignKeyColumns("dealId", "id")],
    foreignKeyType = ForeignKeyType.OPTIONAL
)
interface OneOfDto {
    @Pk
    val dealId: DealId
    val paramDate: String
}

@FlowEntity(FlowEntityType.ONE_OF)
@ForeignKey(
//    value = OneOfDto::class,
    kClass = "ru.vood.dmgen.datamodel.oneOf.OneOfDto",
    name = "DealOneOfData_FK",
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
//    value = DealOneOfData::class,
    kClass = "ru.vood.dmgen.datamodel.oneOf.DealOneOfData",
    name = "DealOneData_FK",
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
//    value = DealOneOfData::class,
    kClass = "ru.vood.dmgen.datamodel.oneOf.DealOneOfData",
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

