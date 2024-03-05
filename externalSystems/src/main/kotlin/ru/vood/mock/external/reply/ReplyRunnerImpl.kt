package ru.vood.mock.external.reply

import org.springframework.stereotype.Service
import ru.vood.mock.external.config.IIntegrationType
import ru.vood.mock.external.reply.data.IProtoRequest
import ru.vood.mock.external.reply.data.IProtoResponse
import ru.vood.mock.external.reply.data.Response

@Service
class ReplyRunnerImpl(
    private val replyGenerator: IReplyGenerator
) : IReplyRunner {
    override fun generateReply(sync: IIntegrationType, request: IProtoRequest): IProtoResponse {

        val asdfds =  replyGenerator.generate(request.payloadClass, request.uk)

        return when(sync){
            IIntegrationType.SYNC -> asdfds[0]
            IIntegrationType.ASYNC_ONE -> TODO()
            IIntegrationType.ASYNC_PARTITION -> TODO()
        }
    }
}