package ru.vood.calculator.configuration

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import ru.vood.calculator.ext.RequestData
import ru.vood.calculator.ext.InRequestService
import ru.vood.grpc.example.v1.GrpcServiceGrpcKt
import ru.vood.grpc.example.v1.ProtoRequest
import ru.vood.grpc.example.v1.ProtoResponse
import ru.vood.grpc.server.dto.Payload
import ru.vood.grpc.server.dto.PayloadClass

@Service
class GrpcKtServer(
    val inRequestService: InRequestService,
) :
    GrpcServiceGrpcKt.GrpcServiceCoroutineImplBase() {
    private val logger = LoggerFactory.getLogger(this.javaClass)

    override suspend fun executeOneRqOneRs(request: ProtoRequest): ProtoResponse {

        logger.info(request.payload)

        val registerIn =
            inRequestService.processIntegration(RequestData(PayloadClass(request.payloadClass), Payload(request.payload)))
        return ProtoResponse.newBuilder()
            .setPayload(registerIn.payload.value)
            .setPayloadClass(registerIn.payloadClass.value)
            .build()
    }
}