package ru.vood.calculator.ext

import org.junit.jupiter.api.Test

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.jdbc.core.JdbcOperations
import org.springframework.test.context.ContextConfiguration
import ru.vood.calculator.ext.abstraction.AbstractDatasourceTests
import ru.vood.calculator.ext.meta.BusinessTypeCall


//@ContextConfiguration(classes = [AbstractIntegrationRegistrarTestConfiguration::class])
internal class IntegrationRegistrarTest : AbstractDatasourceTests() {

    @Autowired
    lateinit var testIntegrationRegistrar: IntegrationRegistrar


    @Test
    fun register() {
        val register = testIntegrationRegistrar.registerIn(BusinessTypeCall.START_CALCULATION, "{}")
        val registerOut = testIntegrationRegistrar.registerOut(BusinessTypeCall.START_CALCULATION, 1, register, "{}")
        println(register)
        println(registerOut)

    }
}



