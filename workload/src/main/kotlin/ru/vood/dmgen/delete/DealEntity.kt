package ru.vood.dmgen.delete

/**
 *Это сущность Сделка
 */

import kotlinx.serialization.json.Json
import ru.vood.dmgen.datamodel.valueClasses.DealId

@kotlinx.serialization.Serializable
sealed interface Deal {
    val id: DealId


}

@kotlinx.serialization.Serializable
data class DealImpl(override val id: DealId) : Deal


@kotlinx.serialization.Serializable
//@optics([OpticsTarget.LENS])
data class DealEntity(

    val d: Deal,
    /**
     *Это ее идентификатор
     */
//override val id: ru.vood.dmgen.datamodel.valueClasses.DealId,
//    override val s: kotlin.String,
//    override val sn: kotlin.String?,
//    override val b: kotlin.Boolean,
//    override val bn: kotlin.Boolean?,
//    val dealParamOneToOne : ru.vood.dmgen.datamodel.runtime.dataclasses.DealParamOneToOneEntity,
//    val dealParamOneToOneOptional : ru.vood.dmgen.datamodel.runtime.dataclasses.DealParamOneToOneOptionalEntity?,
//    val dealParamSet : Set<ru.vood.dmgen.datamodel.runtime.dataclasses.DealParamSetEntity>

) : Deal by d {

    val asdasd by lazy { "asdas" }
}

fun main1() {
    val id = DealId("asdas")
    val dealEntity = DealEntity(d = DealImpl(id))

    val encodeToString = Json.encodeToString(DealEntity.serializer(), dealEntity)
    println(encodeToString)
    val decodeFromString = Json.decodeFromString(DealEntity.serializer(), encodeToString)
    println(decodeFromString)

}