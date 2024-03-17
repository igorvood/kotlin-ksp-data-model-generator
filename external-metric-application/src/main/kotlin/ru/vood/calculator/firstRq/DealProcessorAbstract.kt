package ru.vood.calculator.firstRq

import org.springframework.stereotype.Service
import ru.vood.calculator.ext.ResponseData
import ru.vood.calculator.ext.meta.BusinessTypeCall
import ru.vood.dmgen.datamodel.deal.DealDetail
import ru.vood.dmgen.datamodel.deal.DealRsp
import ru.vood.dmgen.datamodel.deal.DealRspDetail
import ru.vood.dmgen.datamodel.deal.DealRspEntity

@Service
class DealProcessorAbstract(

) : AbstractRequestCommand<DealDetail, DealRspDetail>( BusinessTypeCall.START_CALCULATION) {
    override fun runCommand(requestData: DealDetail): DealRspDetail {
        return DealRspDetail(DealRspEntity(requestData.origin.id))
    }

}