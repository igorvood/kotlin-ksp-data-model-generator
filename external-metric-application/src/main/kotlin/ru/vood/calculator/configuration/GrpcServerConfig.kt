package ru.vood.calculator.configuration

import io.grpc.Server
import org.slf4j.LoggerFactory
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import ru.vood.grpc.example.v1.GrpcServiceGrpcKt

@Configuration
@EnableConfigurationProperties(GrpcServerProp::class)
open class GrpcServerConfig(
    private val grpcServerProp: GrpcServerProp,
) {
    private val logger = LoggerFactory.getLogger(this.javaClass)
    @Bean
    open fun grpcServer(someServiceCoroutineImplBase: GrpcServiceGrpcKt.GrpcServiceCoroutineImplBase): Server {
        logger.info("run grpc server on port ${grpcServerProp.port}")
        return io.grpc.ServerBuilder
            .forPort(grpcServerProp.port)
            .maxInboundMetadataSize(1000000)
            .addService(someServiceCoroutineImplBase)
            .build()
            .start()

    }
}