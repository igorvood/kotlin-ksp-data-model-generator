package ru.vood.calculator.firstRq

import org.springframework.stereotype.Service
import ru.vood.calculator.ext.RequestData
import ru.vood.calculator.ext.ResponseData
import ru.vood.calculator.ext.meta.BusinessTypeCall
import ru.vood.dmgen.datamodel.deal.DealDetail

@Service
class DealProcessor(

) : RequestProcessor<DealDetail> {

    override fun process(requestData: RequestData): ResponseData {
        TODO("Not yet implemented")
    }

    override val businessTypeCall: BusinessTypeCall
        get() = BusinessTypeCall.START_CALCULATION
}