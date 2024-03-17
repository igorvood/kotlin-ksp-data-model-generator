package ru.vood.calculator.ext

import org.springframework.stereotype.Service
import ru.vood.calculator.ext.meta.BusinessTypeCall.Companion.asd
import ru.vood.calculator.firstRq.AbstractRequestCommand
import java.util.*


@Service
class InRequestService(
    private val integrationInRegistrar: IntegrationRegistrarDao,
    val abstractRequestProcessors: List<AbstractRequestCommand<*, *>>,
) {

    private val abstractRequestProcessorsMap = EnumMap(
        abstractRequestProcessors
            .associateBy { rp -> rp.businessTypeCall }
    )

    fun processIntegration(requestData: RequestData): ResponseData {
        val businessTypeCall = asd(requestData.payloadClass)
        val registerIn = integrationInRegistrar.registerIn(businessTypeCall, requestData.payload.value)
        val processIntegration: ResponseData = abstractRequestProcessorsMap[businessTypeCall]!!.process(requestData)
        integrationInRegistrar.registerOut(businessTypeCall, 1, registerIn, processIntegration.payload.value)
        return processIntegration
    }


}