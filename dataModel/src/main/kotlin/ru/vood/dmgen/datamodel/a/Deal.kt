package ru.vood.dmgen.datamodel.a

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
interface Deal {
    @Pk
    @Comment("Это ее идентификатор")
    val id: DealId

    @Comment("Параметр сделки, отношение к сделке один к одному")
    val s: String
    @Comment("Параметр сделки, отношение к сделке один к одному")
    val sn: String?

    @Comment("Параметр сделки, отношение к сделке один к одному")
    val b: Boolean
    @Comment("Параметр сделки, отношение к сделке один к одному")
    val bn: Boolean?

    fun virtual() = s + sn

//    val paramsSet: DealParam,
//    val paramsList: List<DealParam>


}
