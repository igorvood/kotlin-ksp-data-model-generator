package ru.vood.calculator.configuration

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "grpc.server")
data class GrpcServerProp(
    val port: Int,
)