package ru.vood.calculator.ext

import org.springframework.jdbc.core.JdbcOperations
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import ru.vood.calculator.ext.dto.RequestId
import ru.vood.calculator.ext.meta.BusinessTypeCall


@Service
open class IntegrationRegistrar(
    val jdbcOperations: JdbcOperations,
) {



    @Transactional(propagation = Propagation.REQUIRES_NEW)
    internal open fun registerIn(businessTypeCall: BusinessTypeCall, data: String): RequestId {
        val requestId =
            jdbcOperations.queryForObject(
                """ insert into calc_integration_base(business_type_call) VALUES (?) returning id""",
                String::class.java,
                businessTypeCall.name
            )!!.let { RequestId(it) }
        jdbcOperations.update(
            """insert into calc_integration_base_rq(id, business_type_call, data) VALUES (?, ?, ?)""",
            requestId.value,
            businessTypeCall.name,
            data
        )
        return requestId
    }


}