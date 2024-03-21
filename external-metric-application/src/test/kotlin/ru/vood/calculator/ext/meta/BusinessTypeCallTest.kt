package ru.vood.calculator.ext.meta

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class BusinessTypeCallTest {

    @Test
    fun getDirection() {

        val groupBy = BusinessTypeCall.values().map { it.entityEnum }.groupBy { it }
            .filter { it.value.size>1 }
            .map { it.key }
        Assertions.assertEquals(0, groupBy.size){"Dublicate entities $groupBy in ${BusinessTypeCall::class.java}"}


    }
}