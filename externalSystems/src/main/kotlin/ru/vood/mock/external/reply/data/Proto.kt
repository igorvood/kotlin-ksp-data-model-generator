package ru.vood.mock.external.reply.data

sealed interface IProtoRequest {
    val payloadClass: String
    val uk: Map<String, String>
    val payload: String
}

data class Request(
    override val payloadClass: String,
    override val uk: Map<String, String>,
    override val payload: String,
) : IProtoRequest

data class AsyncRequest(
    val rqId: String,
    override val payloadClass: String,
    override val uk: Map<String, String>,
    override val payload: String,
) : IProtoRequest


sealed interface IData

data class DataOk(val payload: String) : IData
data class DataError(val payload: String) : IData


sealed interface IProtoResponse {
}

object EmptyResponse : IProtoResponse

data class Response(
    val payloadClass: String,
    val payload: IData,
) : IProtoResponse

data class AsyncResponse(
    val rqId: String,
    val payloadClass: String,
    val payload: IData,
) : IProtoResponse

data class AsyncResponsePartial(
    val rqId: String,
    val cnt: Int,
    val num: Int,
    val payloadClass: String,
    val payload: IData,
) : IProtoResponse
