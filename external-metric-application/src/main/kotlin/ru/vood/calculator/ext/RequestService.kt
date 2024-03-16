package ru.vood.calculator.ext

import ru.vood.calculator.ext.meta.BusinessTypeCall

interface RequestService {

    val integrationInRegistrar: IntegrationRegistrar

    val businessTypeCall: BusinessTypeCall


    fun processIntegration(requestData: RequestData): ResponseData

    fun processInData(requestData: RequestData): ResponseData {
        integrationInRegistrar.registerIn(businessTypeCall, requestData.payload.value)
        return processIntegration(requestData)
    }


}