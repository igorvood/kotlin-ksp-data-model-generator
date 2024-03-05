package ru.vood.mock.external.config.grpc.client

import io.grpc.ManagedChannel
import io.grpc.ManagedChannelBuilder
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import ru.vood.grpc.example.v1.GrpcServiceGrpcKt
import ru.vood.mock.external.config.grpc.GrpcClientProp

@Configuration
@EnableConfigurationProperties(GrpcClientProp::class)
class GrpcClientConfig(
    private val grpcClientProp: GrpcClientProp
) {

    @Bean
    fun grpcManagedChannel(): ManagedChannel {
        return ManagedChannelBuilder
            .forAddress(grpcClientProp.host, grpcClientProp.port)
            .usePlaintext()
            .build()
    }

    @Bean
    fun someServiceCoroutineStub(
        managedChannel: ManagedChannel
    ): GrpcServiceGrpcKt.GrpcServiceCoroutineStub {
        return GrpcServiceGrpcKt.GrpcServiceCoroutineStub(managedChannel)
    }
}