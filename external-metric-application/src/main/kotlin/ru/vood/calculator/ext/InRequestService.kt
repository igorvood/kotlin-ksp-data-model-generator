package ru.vood.calculator.ext

import org.springframework.stereotype.Service
import ru.vood.calculator.ext.meta.BusinessTypeCall
import ru.vood.calculator.ext.meta.BusinessTypeCall.Companion.asd
import ru.vood.calculator.firstRq.AbstractRequestCommand
import java.util.*


@Service
class InRequestService(
    private val integrationInRegistrar: IntegrationRegistrarDao,
    val abstractRequestProcessors: List<AbstractRequestCommand<*, *>>,
) {

    private val abstractRequestProcessorsMap by lazy {

        val minus = BusinessTypeCall.values().toSet().minus(abstractRequestProcessors.map { it.businessTypeCall })
        require(minus.isEmpty()){"Not found implementation ${AbstractRequestCommand::class.java.name} for BusinessTypeCalls $minus"}

        EnumMap(
            abstractRequestProcessors
                .associateBy { rp -> rp.businessTypeCall }
        )
    }

    fun processIntegration(requestData: RequestData): ResponseData {
        val businessTypeCall = asd(requestData.payloadClass)
        val registerIn = integrationInRegistrar.registerIn(businessTypeCall, requestData.payload.value)

        val runCatching = kotlin.runCatching {
            val abstractRequestCommand = abstractRequestProcessorsMap[businessTypeCall]?: error("Not found implementation ${AbstractRequestCommand::class.java.name} for ${businessTypeCall.name}")
            abstractRequestCommand.process(requestData) }
            .map { processIntegration -> integrationInRegistrar.registerOut(businessTypeCall, registerIn, processIntegration.payload.value)
                processIntegration}
            .getOrElse {
                integrationInRegistrar.registerError(registerIn, it)
                throw java.lang.IllegalStateException(it)
            }

        return runCatching
    }


}