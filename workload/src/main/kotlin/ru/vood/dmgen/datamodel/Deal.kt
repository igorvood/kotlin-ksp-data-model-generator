package ru.vood.dmgen.datamodel

import ru.vood.dmgen.annotation.*
import ru.vood.dmgen.datamodel.valueClasses.DealId

@Comment("Это сущность Сделка")
@FlowEntity(FlowEntityType.AGGREGATE)
//@ForeignKey(
//    kClass = "ru.vood.dmgen.datamodel.DealParamOneToOne",
//    "Deal_2_DealParamOneToOne_FK",
//    cols = [ForeignKeyColumns("id", "dealId")]
//)

//@Uk(["paramsList"])
interface Deal{
    @Pk
    @Comment("Это ее идентификатор")
    val id: DealId

    val s: String
    val sn: String?

    val b: Boolean
    val bn: Boolean?


//    val paramsSet: DealParam,
//    val paramsList: List<DealParam>



}
