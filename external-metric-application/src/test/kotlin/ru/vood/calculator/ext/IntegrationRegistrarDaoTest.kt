package ru.vood.calculator.ext

import org.junit.jupiter.api.Test

import org.springframework.beans.factory.annotation.Autowired
import ru.vood.calculator.ext.abstraction.AbstractDatasourceTests
import ru.vood.calculator.ext.meta.BusinessTypeCall


//@ContextConfiguration(classes = [AbstractIntegrationRegistrarTestConfiguration::class])
internal class IntegrationRegistrarDaoTest : AbstractDatasourceTests() {

    @Autowired
    lateinit var testIntegrationRegistrarDao: IntegrationRegistrarDao


    @Test
    fun register() {
        val register = testIntegrationRegistrarDao.registerIn(BusinessTypeCall.START_CALCULATION_DEAL, "{}")
        val registerOut = testIntegrationRegistrarDao.registerOut(BusinessTypeCall.START_CALCULATION_DEAL, 1, register, "{}")
        println(register)
        println(registerOut)

    }
}



