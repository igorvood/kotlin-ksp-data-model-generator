package ru.vood.calculator.ext

import ru.vood.grpc.server.dto.Payload
import ru.vood.grpc.server.dto.PayloadClass

data class ResponseData(
    val payloadClass: PayloadClass,
    val payload: Payload
)
