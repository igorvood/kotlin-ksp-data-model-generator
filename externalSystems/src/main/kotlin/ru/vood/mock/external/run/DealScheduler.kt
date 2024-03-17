package ru.vood.mock.external.run

import kotlinx.coroutines.runBlocking
import org.slf4j.LoggerFactory
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import ru.vood.dmgen.datamodel.deal.Deal
import ru.vood.dmgen.datamodel.deal.DealDetail
import ru.vood.dmgen.datamodel.deal.Deal_PKContext
import ru.vood.dmgen.datamodel.metaEnum.UniqueKeyEnum
import ru.vood.grpc.example.v1.GrpcServiceGrpcKt
import ru.vood.grpc.example.v1.ProtoRequest
import ru.vood.mock.external.reply.IReplyGenerator
import ru.vood.mock.external.reply.data.DataOk
import java.util.UUID

@Service
class DealScheduler(
    private val grpcClient: GrpcServiceGrpcKt.GrpcServiceCoroutineStub,
    private val generator: IReplyGenerator
) {
    private val logger = LoggerFactory.getLogger(this.javaClass)
    @Scheduled(fixedRate = 500000)
    fun asdasd(){


        val parentPayloadClass = Deal::class.java.simpleName
        val generateAggregate = generator.generateAggregate(
            1,
            UniqueKeyEnum.Deal_PK.name,
            mapOf("id" to UUID.randomUUID().hashCode().toString())
        )[0]

        val dataOk = generateAggregate.payload as DataOk
        val build = ProtoRequest.newBuilder()
            .setPayload(dataOk.payload)
            .setPayloadClass(parentPayloadClass)
            .build()
        val runBlocking = runBlocking { grpcClient.executeOneRqOneRs(build) }
        logger.info(runBlocking.payload)

    }
}