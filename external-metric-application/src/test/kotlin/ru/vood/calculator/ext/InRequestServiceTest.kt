package ru.vood.calculator.ext

import com.ninjasquad.springmockk.MockkBean
import kotlinx.serialization.KSerializer
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.springframework.beans.factory.annotation.Autowired
import ru.vood.calculator.configuration.JsonConfiguration
import ru.vood.calculator.ext.abstraction.AbstractDatasourceTests
import ru.vood.calculator.ext.abstraction.AbstractTests
import ru.vood.calculator.ext.data.businessTypeCallWithData
import ru.vood.calculator.ext.meta.BusinessTypeCall
import ru.vood.grpc.server.dto.Payload
import ru.vood.grpc.server.dto.PayloadClass

internal class InRequestServiceTest : AbstractDatasourceTests() {

    @Autowired
    private lateinit var inRequestService: InRequestService
    @Autowired
    private lateinit var jsonConfiguration: JsonConfiguration



    @ParameterizedTest
    @MethodSource("ru.vood.calculator.ext.InRequestServiceTest#testCaseData")
    fun processIntegration(tc: BusinessTypeCall) {
        val data = businessTypeCallWithData[tc]!!
        val serializer = data.designEntityName.entityData().serializerSynthetic as KSerializer<Any>
        val encodeToString = jsonConfiguration.asd.encodeToString(serializer, data as Any)

        val processIntegration = inRequestService.processIntegration(
            RequestData(
                PayloadClass(tc.entityEnum.entityData().designClass.simpleName!!),
                Payload(encodeToString)
            )
        )

        Assertions.assertEquals(Payload(value="""{"origin":{"dealId":1}}"""), processIntegration.payload)

    }


    companion object {
        private val testData = BusinessTypeCall.values()
//            .map { TestCase(PayloadClass(it.entityEnum.entityData().designClass.simpleName!!)) }
            .map { it }


        @JvmStatic
        private fun testCaseData() = testData.map { Arguments.of(it) }

    }


    internal data class TestCase(val payloadClass: PayloadClass)
}