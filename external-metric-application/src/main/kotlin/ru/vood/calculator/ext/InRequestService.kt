package ru.vood.calculator.ext

import org.springframework.stereotype.Service
import ru.vood.calculator.ext.meta.BusinessTypeCall
import ru.vood.calculator.ext.meta.BusinessTypeCall.Companion.asd
import ru.vood.calculator.firstRq.RequestProcessor
import ru.vood.dmgen.datamodel.intf.IEntityDetail
import ru.vood.dmgen.datamodel.intf.IEntityOrigin
import java.util.EnumMap


@Service
class InRequestService(
    private val integrationInRegistrar: IntegrationRegistrarDao,
    requestProcessors: List<RequestProcessor<IEntityDetail<out IEntityOrigin>>>,
) {

    private val requestProcessorsMap: EnumMap<BusinessTypeCall, RequestProcessor<IEntityDetail<out IEntityOrigin>>> = EnumMap(requestProcessors
        .associateBy { rp -> rp.businessTypeCall })
    fun processIntegration(requestData: RequestData): ResponseData {
        val businessTypeCall = asd(requestData.payloadClass)
        val registerIn = integrationInRegistrar.registerIn(businessTypeCall, requestData.payload.value)
        val processIntegration: ResponseData = requestProcessorsMap[businessTypeCall]!!.process(requestData)
        integrationInRegistrar.registerOut(businessTypeCall, 1, registerIn, processIntegration.payload.value)
        return processIntegration

    }


}