package ru.vood.calculator.firstRq

import ru.vood.calculator.ext.RequestData
import ru.vood.calculator.ext.ResponseData
import ru.vood.calculator.ext.meta.BusinessTypeCall
import ru.vood.dmgen.datamodel.intf.IEntityDetail
import ru.vood.dmgen.datamodel.intf.IEntityOrigin

interface RequestProcessor<out T : IEntityDetail<out IEntityOrigin>> {
    fun process(requestData: RequestData): ResponseData


    val businessTypeCall: BusinessTypeCall
}
