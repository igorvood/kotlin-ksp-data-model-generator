package ru.vood.grpc.server.dto

data class RuntimeRequest(
    val payloadClass: PayloadClass,
    val payload: Payload
)

//message ProtoRequest {
//    string payloadClass = 1;
//    map<string, string> uk = 2;
//    string payload = 3;
//}
