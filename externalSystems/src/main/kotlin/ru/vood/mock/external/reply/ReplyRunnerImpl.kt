package ru.vood.mock.external.reply

import org.springframework.stereotype.Service
import ru.vood.mock.external.config.IIntegrationType
import ru.vood.mock.external.reply.data.IProtoRequest
import ru.vood.mock.external.reply.data.IProtoResponse

@Service
class ReplyRunnerImpl : IReplyRunner {
    override fun generateReply(sync: IIntegrationType, request: IProtoRequest): IProtoResponse {
        TODO("Not yet implemented")
    }
}