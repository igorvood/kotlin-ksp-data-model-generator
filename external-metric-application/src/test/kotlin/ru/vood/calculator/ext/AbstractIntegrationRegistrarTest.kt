package ru.vood.calculator.ext

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.jdbc.core.JdbcOperations
import org.springframework.test.context.ContextConfiguration
import ru.vood.calculator.ext.abstraction.AbstractDatasourceTests
import ru.vood.calculator.ext.meta.BusinessTypeCall


@ContextConfiguration(classes = [AbstractIntegrationRegistrarTestConfiguration::class])
internal class AbstractIntegrationRegistrarTest: AbstractDatasourceTests() {

@Autowired
    lateinit var testIntegrationRegistrar: AbstractIntegrationRegistrar



    @Test
    fun register() {
        val register = testIntegrationRegistrar.register("{}")
        println(register)
    }
}

open class TestIntegrationRegistrar(jdbcOperations: JdbcOperations): AbstractIntegrationRegistrar(jdbcOperations){
    override val businessTypeCall: BusinessTypeCall
        get() = BusinessTypeCall.START_CALCULATION
}
@TestConfiguration
open internal class AbstractIntegrationRegistrarTestConfiguration{

    @Bean
    open fun testIntegrationRegistrar(jdbcOperations: JdbcOperations) = TestIntegrationRegistrar(jdbcOperations)
}