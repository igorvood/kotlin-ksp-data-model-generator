package ru.vood.dmgen.datamodel.c

import ru.vood.dmgen.annotation.*
import ru.vood.dmgen.datamodel.a.Deal
import ru.vood.dmgen.datamodel.oneOf.DealOneOfData
import ru.vood.dmgen.datamodel.valueClasses.DealId

@FlowEntity(FlowEntityType.AGGREGATE)
@ForeignKey(

//    value = Deal::class,
    kClass = "ru.vood.dmgen.datamodel.a.Deal",
    name = "Product_FK_1",
    cols = [ForeignKeyColumns("dealId", "id")],
    foreignKeyType = ForeignKeyType.OPTIONAL
)
@Uk(
    "Product_UK_1",
    ["otherSystemProductId", "dealId"]
)
//@Uk("Product_UK_2",["dealId", "id"])
//@Uk("Product_UK_3",["l", "d", "f", "bd", "b", "t"])
interface Product {
    @Pk
    val id: String

    @Pk
    val dealId: DealId

    val otherSystemProductId: String

    val productName: String

    val inn: Int?


    val ln: Long?
    val dn: Double?
    val fn: Float?

    //        val bd: BigDecimal
    val bn: Boolean?
    val isdsdd: String?
//    val t: Instant,


    val l: Long
    val d: Double
    val f: Float

    //    val bd: BigDecimal,
    val b: Boolean
//    val t: Instant,
}
