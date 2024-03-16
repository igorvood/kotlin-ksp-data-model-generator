package ru.vood.calculator.firstRq

import org.springframework.stereotype.Service
import ru.vood.calculator.ext.IntegrationRegistrar
import ru.vood.calculator.ext.RequestData
import ru.vood.calculator.ext.RequestService
import ru.vood.calculator.ext.ResponseData
import ru.vood.calculator.ext.meta.BusinessTypeCall

@Service
class DealRegister(
    override val integrationInRegistrar: IntegrationRegistrar
    ): RequestService {
    override val businessTypeCall: BusinessTypeCall
        get() = BusinessTypeCall.START_CALCULATION

    override fun processIntegration(requestData: RequestData): ResponseData {
        TODO("Not yet implemented")
    }


}