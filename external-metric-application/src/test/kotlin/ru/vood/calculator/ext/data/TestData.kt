package ru.vood.calculator.ext.data

import ru.vood.calculator.ext.meta.BusinessTypeCall
import ru.vood.dmgen.datamodel.*
import ru.vood.dmgen.datamodel.deal.DealDetail
import ru.vood.dmgen.datamodel.deal.DealEntity
import ru.vood.dmgen.datamodel.intf.IEntityDetail
import ru.vood.dmgen.datamodel.intf.IEntityOrigin

val dealId = 1
val dealDetail = DealDetail(
    origin = DealEntity(id = dealId, s = "s", i = 2, d = 3.0, f = 4.0f, b = false),
    dealParamOneToOne = DealParamOneToOneDetail(
        origin = DealParamOneToOneEntity(
            dealId = dealId,
            paramDate = "paramDate"
        )
    ),
    dealParamOneToOneOptional = DealParamOneToOneOptionalDetail(
        origin = DealParamOneToOneOptionalEntity(
            dealId = dealId,
            paramDate = "paramDate"
        )
    ),
    dealParamSet = setOf(DealParamSetDetail(DealParamSetEntity(dealId = dealId, id = 5, paramDate = "paramDate")))

)

val businessTypeCallWithData: Map<BusinessTypeCall, IEntityDetail<out IEntityOrigin>> = BusinessTypeCall.values().associateWith {
    when (it) {
        BusinessTypeCall.START_CALCULATION_DEAL -> dealDetail
    }
}