package ru.vood.calculator.ext.meta

enum class BusinessTypeCall(
    val direction: Direction,
    val sync: IntegrationType) {

    START_CALCULATION(
        Direction.IN, IntegrationType.SYNC
    )

}