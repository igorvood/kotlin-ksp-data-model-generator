package ru.vood.mock.external.config.grpc.server

import io.grpc.Server
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import ru.vood.grpc.example.v1.GrpcServiceGrpcKt
import ru.vood.mock.external.config.grpc.GrpcServerProp

@Configuration
@EnableConfigurationProperties(GrpcServerProp::class)
class GrpcServerConfig(
    private val grpcServerProp: GrpcServerProp,
) {

    @Bean
    fun grpcServer(someServiceCoroutineImplBase: GrpcServiceGrpcKt.GrpcServiceCoroutineImplBase): Server {

        return io.grpc.ServerBuilder
            .forPort(grpcServerProp.port)
            .maxInboundMetadataSize(1000000)
            .addService(someServiceCoroutineImplBase)
            .build()
            .start()

    }
}