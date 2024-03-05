package ru.vood.dmgen.datamodel

import ru.vood.dmgen.annotation.*
import ru.vood.dmgen.datamodel.a.Deal
import ru.vood.dmgen.datamodel.c.Product
import ru.vood.dmgen.datamodel.noRelation.NoRelationData
import ru.vood.dmgen.datamodel.valueClasses.DealId

@FlowEntity(FlowEntityType.AGGREGATE)
@ForeignKey(
//    value = Deal::class,
    kClass = "ru.vood.dmgen.datamodel.a.Deal",
    name = "ProductPayments_FK_1",
    cols = [ru.vood.dmgen.annotation.ForeignKeyColumns("dealId", "id")],
    foreignKeyType = ForeignKeyType.OPTIONAL
)
@ForeignKey(
//    value = Product::class,
    kClass = "ru.vood.dmgen.datamodel.c.Product",
    name = "ProductPayments_FK_2",
    cols = [ru.vood.dmgen.annotation.ForeignKeyColumns("dealId", "dealId"),
        ru.vood.dmgen.annotation.ForeignKeyColumns("productId", "id")
    ],
    foreignKeyType = ForeignKeyType.OPTIONAL
)
//@Uk("Product_UK_3",["summa"])
@Comment("Параметр сделки, отношение к сделке один к одному")
interface ProductPayments {
    @Pk
    @Comment("Параметр сделки, отношение к сделке один к одному")
    val productId: String

    @Pk
    @Comment("Параметр сделки, отношение к сделке один к одному")
    val dealId: DealId

    //    @Pk
    @Comment("Параметр сделки, отношение к сделке один к одному")
    val id: String

    @Comment("Параметр сделки, отношение к сделке один к одному")
    val summa: Long

    @Comment("Параметр сделки, отношение к сделке один к одному")
    val noRelationData: NoRelationData

}