package ru.vood.grpc.server

import com.google.protobuf.Empty
import kotlinx.coroutines.flow.Flow
import ru.vood.grpc.example.v1.*

class GrpcServerImpl(

): GrpcServiceGrpcKt.GrpcServiceCoroutineImplBase() {


    override suspend fun executeOneRqOneRs(request: ProtoRequest): ProtoResponse {
        return super.executeOneRqOneRs(request)
    }

    override fun executeOneRqManyRs(request: ProtoRequest): Flow<ProtoResponse> {
        return super.executeOneRqManyRs(request)
    }

    override suspend fun asyncRequest(request: AsyncProtoRequest): Empty {
        return super.asyncRequest(request)
    }

    override suspend fun asyncResponse(request: AsyncProtoResponse): Empty {
        return super.asyncResponse(request)
    }
}