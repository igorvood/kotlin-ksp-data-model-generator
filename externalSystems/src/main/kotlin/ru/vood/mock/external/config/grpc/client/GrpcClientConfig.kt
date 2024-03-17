package ru.vood.mock.external.config.grpc.client

import io.grpc.ManagedChannel
import io.grpc.ManagedChannelBuilder
import org.slf4j.LoggerFactory
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import ru.vood.grpc.example.v1.GrpcServiceGrpcKt
import ru.vood.mock.external.config.grpc.GrpcClientProp

@Configuration
@EnableConfigurationProperties(GrpcClientProp::class)
class GrpcClientConfig(
    private val grpcClientProp: GrpcClientProp,
) {
    private val logger = LoggerFactory.getLogger(this.javaClass)
    @Bean
    fun grpcManagedChannel(): ManagedChannel {
        logger.info("config grpc client for host ${grpcClientProp.host}, port ${grpcClientProp.port}")
        return ManagedChannelBuilder
            .forAddress(grpcClientProp.host, grpcClientProp.port)
            .usePlaintext()
            .build()
    }

    @Bean
    fun someServiceCoroutineStub(
        managedChannel: ManagedChannel,
    ): GrpcServiceGrpcKt.GrpcServiceCoroutineStub {
        return GrpcServiceGrpcKt.GrpcServiceCoroutineStub(managedChannel)
    }
}