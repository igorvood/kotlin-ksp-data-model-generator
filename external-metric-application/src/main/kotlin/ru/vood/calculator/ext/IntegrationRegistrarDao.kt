package ru.vood.calculator.ext

import org.springframework.jdbc.core.JdbcOperations
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import ru.vood.calculator.ext.dto.RequestId
import ru.vood.calculator.ext.dto.ResponseId
import ru.vood.calculator.ext.meta.BusinessTypeCall


@Service
open class IntegrationRegistrarDao(
    val jdbcOperations: JdbcOperations,
) {

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    internal open fun registerIn(businessTypeCall: BusinessTypeCall, data: String): RequestId {
        val requestId =
            jdbcOperations.queryForObject(
                """ insert into calc_integration_base(business_type_call, direction, integration_type) VALUES (?, ?, ?) returning id""",
                String::class.java,
                businessTypeCall.name,
                businessTypeCall.direction.name,
                businessTypeCall.integrationType.name,
            )!!.let { RequestId(it) }
        jdbcOperations.update(
            """insert into calc_integration_base_rq(id, business_type_call, data) VALUES (?, ?, ?)""",
            requestId.value,
            businessTypeCall.name,
            data
        )
        return requestId
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    internal open fun registerOut(
        businessTypeCall: BusinessTypeCall,
        requestId: RequestId,
        data: String,
    ): ResponseId {
        val let = jdbcOperations.queryForObject(
            """insert into calc_integration_base_rs(business_type_call, request_id, data) VALUES ( ?, ?,? ) returning id""",
            String::class.java,
            businessTypeCall.name,
            requestId.value,
            data
        )!!.let { ResponseId(it) }

        jdbcOperations.update(
            """update calc_integration_base set last_response_id = ? where id = ?""",
            let.value,
            requestId.value,
        )
        return let
    }

    internal open fun registerError(
        requestId: RequestId,
        error: String,
    ) {
        jdbcOperations.update(
            """update calc_integration_base set process_error = ? where id = ?""",
            error,
            requestId.value,
        )

    }


}