package ru.vood.dmgen.datamodel.sealedData.oneOf

import ru.vood.dmgen.annotation.*
import ru.vood.dmgen.datamodel.valueClasses.DealId


@FlowEntity(FlowEntityType.INNER_MANDATORY)
@ForeignKey(
//    kClass = Deal::class.java.canonicalName,

    kClass = "ru.vood.dmgen.datamodel.sealedData.Deal",
    name = "OneOfDto_FK",
    cols = [ForeignKeyColumns("dealId", "id")]
)
sealed interface OneOfDto {
    @Pk
    val dealId: DealId
}

@FlowEntity(FlowEntityType.INNER_MANDATORY)
@ForeignKey(
    kClass = "ru.vood.dmgen.datamodel.sealedData.oneOf.OneOfDto",
    "DealOneData_FK",
    cols = [ForeignKeyColumns("dealId", "dealId")]
)
interface DealOneData {
    @Pk
    @Comment("Это ее идентификатор")
    val dealId: DealId
    val one:String
}


@FlowEntity(FlowEntityType.INNER_MANDATORY)
@ForeignKey(
    kClass = "ru.vood.dmgen.datamodel.sealedData.oneOf.OneOfDto",
    "DealTwoData_FK",
    cols = [ForeignKeyColumns("dealId", "dealId")]
)
interface DealTwoData {
    @Pk
    @Comment("Это ее идентификатор")
    val dealId: DealId

    val two: String?
}

