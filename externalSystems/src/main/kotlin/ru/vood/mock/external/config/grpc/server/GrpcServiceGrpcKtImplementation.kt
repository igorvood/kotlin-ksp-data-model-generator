package ru.vood.mock.external.config.grpc.server

import com.google.protobuf.Empty
import org.springframework.stereotype.Service
import ru.vood.grpc.example.v1.*
import ru.vood.mock.external.config.IIntegrationType
import ru.vood.mock.external.reply.IReplyRunner
import ru.vood.mock.external.reply.data.*

@Service
class GrpcServiceGrpcKtImplementation(
    private val replyRunner: IReplyRunner,
) : GrpcServiceGrpcKt.GrpcServiceCoroutineImplBase() {

    override suspend fun executeOneRqOneRs(request: ProtoRequest): ProtoResponse {
        val protoRequest: IProtoRequest = Request(request.payloadClass, request.ukMap, request.payload)
        val protoResponse: IProtoResponse = replyRunner.generateReply(IIntegrationType.SYNC, protoRequest)

        val apply = ProtoResponse.newBuilder().apply {
            when (protoResponse) {
                is Response -> {
                    payloadClass = protoResponse.payloadClass
                    payload = when (val res = protoResponse.payload) {
                        is DataOk -> res.payload
                        is DataError -> res.payload
                    }
                }
                is EmptyResponse -> error("")
                is AsyncResponse -> error("")
                is AsyncResponsePartial -> error("")
            }
        }.build()
        return apply
    }

    override fun executeOneRqManyRs(request: ProtoRequest): kotlinx.coroutines.flow.Flow<ProtoResponse> {
        return super.executeOneRqManyRs(request)
    }

    override suspend fun asyncRequest(request: AsyncProtoRequest): Empty {
        val protoRequest: IProtoRequest =
            AsyncRequest(request.rqId, request.payloadClass, request.ukMap, request.payload)
        replyRunner.generateReply(IIntegrationType.SYNC, protoRequest)
        return Empty.getDefaultInstance()
    }

    override suspend fun asyncResponse(request: AsyncProtoResponse): Empty {
        return super.asyncResponse(request)
    }
}