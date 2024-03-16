package ru.vood.calculator.firstRq

import ru.vood.calculator.ext.IntegrationRegistrar
import ru.vood.calculator.ext.RequestData
import ru.vood.calculator.ext.RequestService
import ru.vood.calculator.ext.ResponseData
import ru.vood.calculator.ext.meta.BusinessTypeCall

class DealRegister: RequestService {
    override val businessTypeCall: BusinessTypeCall
        get() = TODO("Not yet implemented")

    override fun processIntegration(requestData: RequestData): ResponseData {
        TODO("Not yet implemented")
    }

    override val integrationInRegistrar: IntegrationRegistrar
        get() = TODO("Not yet implemented")
}