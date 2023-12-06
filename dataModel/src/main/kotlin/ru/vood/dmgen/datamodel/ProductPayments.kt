package ru.vood.dmgen.datamodel

import ru.vood.dmgen.annotation.FlowEntity
import ru.vood.dmgen.annotation.FlowEntityType
import ru.vood.dmgen.annotation.ForeignKey
import ru.vood.dmgen.annotation.Pk
import ru.vood.dmgen.datamodel.noRelation.NoRelationData
import ru.vood.dmgen.datamodel.valueClasses.DealId

@FlowEntity(FlowEntityType.AGGREGATE)
@ForeignKey(
//    kClass = Deal::class,
    kClass = "ru.vood.dmgen.datamodel.Deal",
    "ProductPayments_FK_1",
    cols = [ru.vood.dmgen.annotation.ForeignKeyColumns("dealId", "id")]
)
@ForeignKey(
//    Product::class,
    kClass = "ru.vood.dmgen.datamodel.Product",
    "ProductPayments_FK_2",
    cols = [ru.vood.dmgen.annotation.ForeignKeyColumns("dealId", "dealId"),
        ru.vood.dmgen.annotation.ForeignKeyColumns("productId", "id")
    ]
)
//@Uk("Product_UK_3",["summa"])
interface ProductPayments {
    @Pk
    val productId: String

    @Pk
    val dealId: DealId

    @Pk
    val id: String

    val summa: Long

    val noRelationData: NoRelationData

}