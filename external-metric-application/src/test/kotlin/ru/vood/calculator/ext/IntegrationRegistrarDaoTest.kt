package ru.vood.calculator.ext

import org.junit.jupiter.api.Assertions
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
        val registerOut = testIntegrationRegistrarDao.registerOut(
            BusinessTypeCall.START_CALCULATION_DEAL,
            register,
            "{}"
        )
        val queryForObject = jdbcTemplate.queryForObject(
            "select not_finished_id from calc_integration_base where id = ? ",
            String::class.java,
            register.value
        )

        Assertions.assertNull(queryForObject)

    }

    @Test
    fun registerError() {
        val register = testIntegrationRegistrarDao.registerIn(BusinessTypeCall.START_CALCULATION_DEAL, "{}")
        val registerOut = testIntegrationRegistrarDao.registerError(
            register,
            "{}"
        )
        val queryForObject = jdbcTemplate.queryForObject(
            "select not_finished_id from calc_integration_base where id = ? ",
            String::class.java,
            register.value
        )

        Assertions.assertNull(queryForObject)

    }
}



