package ru.vood.mock.external.reply

import kotlinx.coroutines.flow.Flow
import ru.vood.mock.external.config.IIntegrationType

interface IReply<RQ, RS> {

    val integrationType: IIntegrationType

    fun reply(rq: RQ): Flow<RS>
}



