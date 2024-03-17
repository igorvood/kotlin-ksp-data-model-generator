package ru.vood.calculator.ext.meta

import ru.vood.dmgen.datamodel.metaEnum.EntityEnum
import ru.vood.grpc.server.dto.PayloadClass
import java.util.*

enum class BusinessTypeCall(
    val direction: Direction,
    val sync: IntegrationType,
    val entityEnum: EntityEnum,

    ) {

    START_CALCULATION_DEAL(
        Direction.IN, IntegrationType.SYNC, EntityEnum.Deal
    );


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



