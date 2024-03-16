package ru.vood.calculator.ext.meta

import ru.vood.dmgen.datamodel.metaEnum.EntityEnum
import java.util.EnumMap

enum class BusinessTypeCall(
    val direction: Direction,
    val sync: IntegrationType,
    val entityEnum: EntityEnum,

    ) {

    START_CALCULATION(
        Direction.IN, IntegrationType.SYNC, EntityEnum.Deal
    );


    companion object{
        val businessTypeCallByEntityEnum = EnumMap(BusinessTypeCall.values().map {
            it.entityEnum to it
        }.toMap())
    }



}