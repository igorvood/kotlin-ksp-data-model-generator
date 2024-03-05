package ru.vood.dmgen.datamodel.c

import ru.vood.dmgen.annotation.*

@FlowEntity(FlowEntityType.AGGREGATE)
@ForeignKey(

//    value = Deal::class,
    kClass = "ru.vood.dmgen.datamodel.deal.Deal",
    name = "Product_FK_1",
    cols = [ForeignKeyColumns("dealId", "id")],
    foreignKeyType = ForeignKeyType.OPTIONAL
)
@Comment("Параметр сделки, отношение к сделке один к одному")
interface Product {
    @Pk
    @Comment("Параметр сделки, отношение к сделке один к одному")
    val id: String

    @Pk
    @Comment("Параметр сделки, отношение к сделке один к одному")
    val dealId: Int

    @Comment("Параметр сделки, отношение к сделке один к одному")
    val productName: String

    @Comment("Параметр сделки, отношение к сделке один к одному")
    val inn: Int?


    @Comment("Параметр сделки, отношение к сделке один к одному")
    val ln: Long?

    @Comment("Параметр сделки, отношение к сделке один к одному")
    val dn: Double?

    @Comment("Параметр сделки, отношение к сделке один к одному")
    val fn: Float?

    //        val bd: BigDecimal
    @Comment("Параметр сделки, отношение к сделке один к одному")
    val bn: Boolean?

    @Comment("Параметр сделки, отношение к сделке один к одному")
    val isdsdd: String?
//    val t: Instant,


    @Comment("Параметр сделки, отношение к сделке один к одному")
    val l: Long

    @Comment("Параметр сделки, отношение к сделке один к одному")
    val d: Double

    @Comment("Параметр сделки, отношение к сделке один к одному")
    val f: Float

    //    val bd: BigDecimal,
    @Comment("Параметр сделки, отношение к сделке один к одному")
    val b: Boolean
//    val t: Instant,
}
