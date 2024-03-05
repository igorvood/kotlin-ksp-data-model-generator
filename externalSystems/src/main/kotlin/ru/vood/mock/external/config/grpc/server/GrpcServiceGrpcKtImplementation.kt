package ru.vood.mock.external.config.grpc.server

import com.google.protobuf.Empty
import org.springframework.stereotype.Service
import ru.vood.grpc.example.v1.*

@Service
class GrpcServiceGrpcKtImplementation : GrpcServiceGrpcKt.GrpcServiceCoroutineImplBase() {

    override suspend fun executeOneRqOneRs(request: ProtoRequest): ProtoResponse {
        return super.executeOneRqOneRs(request)
    }

    override fun executeOneRqManyRs(request: ProtoRequest): kotlinx.coroutines.flow.Flow<ProtoResponse> {
        return super.executeOneRqManyRs(request)
    }

    override suspend fun asyncRequest(request: AsyncProtoRequest): Empty {
        return super.asyncRequest(request)
    }

    override suspend fun asyncResponse(request: AsyncProtoResponse): Empty {
        return super.asyncResponse(request)
    }
}