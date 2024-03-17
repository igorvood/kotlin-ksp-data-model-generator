package ru.vood.calculator.firstRq

import kotlinx.serialization.KSerializer
import org.springframework.beans.factory.annotation.Autowired
import ru.vood.calculator.configuration.JsonConfiguration
import ru.vood.calculator.ext.RequestData
import ru.vood.calculator.ext.ResponseData
import ru.vood.calculator.ext.meta.BusinessTypeCall
import ru.vood.dmgen.datamodel.intf.IEntityDetail
import ru.vood.dmgen.datamodel.intf.IEntityOrigin
import ru.vood.grpc.server.dto.Payload
import ru.vood.grpc.server.dto.PayloadClass

abstract class AbstractRequestCommand<IN : IEntityDetail<out IEntityOrigin>, OUT : IEntityDetail<out IEntityOrigin>>(
    val businessTypeCall: BusinessTypeCall,
) {

    @Autowired
    lateinit var jsonConfiguration: JsonConfiguration

    fun process(requestData: RequestData): ResponseData {
        val entityData = businessTypeCall.entityEnum.entityData()
        require(requestData.payloadClass.value == entityData.runtimeSyntheticClass.simpleName) {
            "Class for ${businessTypeCall.name} not equals ${requestData.payloadClass.value}"
        }
        val decodeFromString =
            jsonConfiguration.asd.decodeFromString(entityData.serializerSynthetic, requestData.payloadClass.value) as IN

        val customProcess = runCommand(decodeFromString)

        val entityData1 = customProcess.designEntityName.entityData()
        val serializer = entityData1.serializerSynthetic as KSerializer<OUT>
        val encodeToString = jsonConfiguration.asd.encodeToString(serializer, customProcess)

        return ResponseData(PayloadClass(entityData1.runtimeSyntheticClass.simpleName!!), Payload(encodeToString))
    }

    abstract fun runCommand(requestData: IN): OUT

//    val businessTypeCall: BusinessTypeCall
}
