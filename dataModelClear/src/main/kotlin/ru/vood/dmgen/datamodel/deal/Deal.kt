package ru.vood.dmgen.datamodel.deal

import ru.vood.dmgen.annotation.*

@Comment("Это сущность Сделка")
@FlowEntity(FlowEntityType.AGGREGATE)
interface Deal {
    @Pk
    @Comment("Это ее идентификатор")
    val id: Int

    @Comment("Это какой-то строковый параметр")
    val s: String

    @Comment("Это какой-то числовой параметр")
    val i: Int

    @Comment("Это какой-то числовой параметр")
    val d: Double

    @Comment("Это какой-то числовой параметр")
    val f: Float

    @Comment("Это какой-то логический параметр")
    val b: Boolean

}
