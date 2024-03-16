package ru.vood.calculator.ext

import ru.vood.calculator.ext.meta.BusinessTypeCall

interface RequestService {

    val integrationInRegistrar: IntegrationRegistrar

    val businessTypeCall: BusinessTypeCall
    fun processIntegration(requestData: RequestData): ResponseData

    fun processInData(requestData: RequestData): ResponseData {
        val registerIn = integrationInRegistrar.registerIn(businessTypeCall, requestData.payload.value)
        val processIntegration = processIntegration(requestData)
        integrationInRegistrar.registerOut(businessTypeCall, 1, registerIn, processIntegration.payload.value)
        return processIntegration
    }


}