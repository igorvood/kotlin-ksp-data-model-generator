package ru.vood.mock.external.reply

import ru.vood.mock.external.config.IIntegrationType
import ru.vood.mock.external.reply.data.IProtoRequest
import ru.vood.mock.external.reply.data.IProtoResponse

interface IReplyRunner {
    fun generateReply(sync: IIntegrationType, request: IProtoRequest): IProtoResponse

}
