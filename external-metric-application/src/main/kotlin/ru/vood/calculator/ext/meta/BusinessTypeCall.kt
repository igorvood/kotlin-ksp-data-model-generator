package ru.vood.calculator.ext.meta

import ru.vood.dmgen.datamodel.metaEnum.EntityEnum
import ru.vood.grpc.server.dto.PayloadClass
import java.util.*

enum class BusinessTypeCall(
    val direction: Direction,
    val integrationType: IntegrationTypeEnum,
    val entityEnum: EntityEnum,

    ) {

    START_CALCULATION_DEAL(
        Direction.IN, IntegrationTypeEnum.SYNC, EntityEnum.Deal
    ),
//    DEAL_PRODUCTS(
//        Direction.OUT, IntegrationTypeEnum.ASYNC_MANY, EntityEnum.Deal
//    )
    ;


    companion object {
        val businessTypeCallByEntityEnum = EnumMap(BusinessTypeCall.values().map {
            it.entityEnum to it
        }.toMap())

        fun asd(payloadClass: PayloadClass): BusinessTypeCall = businessTypeCallByEntityEnum[
                EntityEnum.entityMetaByStr(
                    payloadClass.value
                )
        ]!!
    }
}



