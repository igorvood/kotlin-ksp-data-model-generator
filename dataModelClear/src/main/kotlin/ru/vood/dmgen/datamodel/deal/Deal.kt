package ru.vood.dmgen.datamodel.deal

import ru.vood.dmgen.annotation.*
import ru.vood.dmgen.datamodel.valueClasses.DealId

@Comment("Это сущность Сделка")
@FlowEntity(FlowEntityType.AGGREGATE)
interface Deal {
    @Pk
    @Comment("Это ее идентификатор")
    val id: DealId

    @Comment("Параметр сделки строка")
    val s: String
    @Comment("Параметр сделки опциональная строка")
    val sn: String?

    @Comment("Параметр сделки логика")
    val b: Boolean
    @Comment("Параметр сделки опциональная логика")
    val bn: Boolean?

    @Comment("Параметр сделки число")
    val n: Int
    @Comment("Параметр сделки опциональное число")
    val nn: Int?
}
