package ru.vood.dmgen.delete

import ru.vood.dmgen.datamodel.runtime.dataclassesOrigin.DealEntity
import ru.vood.dmgen.datamodel.runtime.dataclassesOrigin.DealParamOneToOneEntity
import ru.vood.dmgen.datamodel.runtime.dataclassesSynthetic.DealParamOneToOneSynthetic
import ru.vood.dmgen.datamodel.runtime.dataclassesSynthetic.DealSynthetic
import ru.vood.dmgen.datamodel.valueClasses.DealId
import ru.vood.dmgen.intf.*
import ru.vood.dmgen.intf.newIntf.ColumnKind


data class ColumnEntityData<T >(
    val entity: EntityName,
//    override val kProperty1: KProperty1<out T, *>,
    val simpleColumnName: SimpleColumnName,
    val isOptional: Boolean,
    val comment: String,
    @Deprecated("use iColKind")
    val columnKind: ColumnKind,
    val iColKind: IColKind<T, *>

)

sealed interface IColKind<in T , out OUT> {
    val extractFieldValue: (entity: T) -> OUT
}

@JvmInline
value class Simple<T : IEntityOrigin<out T>, OUT>(
    override val extractFieldValue: (entity: T) -> OUT
) : IColKind<T, OUT>

@JvmInline
value class Synthetic<
        ORIG_IN :  IEntityOrigin<out ORIG_IN>,
        SINTH_IN: IEntitySynthetic<out ORIG_IN>,
        OUT : IEntityOrigin<OUT>>(
    override val extractFieldValue: (entity: SINTH_IN) -> Set<IEntitySynthetic<OUT>>
) : IColKind<SINTH_IN, Set<IEntitySynthetic<OUT>>>

@JvmInline
value class SyntheticSet<T : IEntityOrigin<out T>, OUT : IEntityOrigin<OUT>>(
    override val extractFieldValue: (entity: T) -> Set<OUT>
) : IColKind<T, Set<OUT>>


fun asdsad() {
    val dealId = DealId("12")
    val paramDate = "asd"
    val dealParamOneToOneEntity = DealParamOneToOneSynthetic(DealParamOneToOneEntity(dealId, paramDate))

    val dealSynthetic: DealSynthetic =
        DealSynthetic(DealEntity(dealId, "asd", null, true, null), dealParamOneToOneEntity, null, setOf())

    val iEntitySynthetic: IEntitySynthetic<DealEntity> = dealSynthetic
    val iEntityOrigin: IEntityOrigin<DealEntity> = dealSynthetic
    val serializer: Serializer<DealEntity> = dealSynthetic


    val IEntitySynthetic: IEntitySynthetic<DealParamOneToOneEntity> = dealParamOneToOneEntity
    val IEntityOrigin: IEntityOrigin<DealParamOneToOneEntity> = dealParamOneToOneEntity
    val Serializer: Serializer<DealParamOneToOneEntity> = dealParamOneToOneEntity

    Synthetic<DealEntity, DealSynthetic , DealParamOneToOneEntity> { setOf( it.dealParamOneToOne)}

//    Synthetic<IEntityOrigin<DealEntity>, IEntitySynthetic<DealParamOneToOneEntity>> {TODO()}

}

val columnEntityDataMap = mapOf(

    FullColumnName("DealParamOneToOne_dealParamOneToOne") to ColumnEntityData(
        EntityName("Deal"),
//DealSynthetic::dealParamOneToOne,
        SimpleColumnName("dealParamOneToOne"),
        false,
        "null",
        ColumnKind.SYNTHETIC,
        Synthetic<DealEntity, DealSynthetic, DealParamOneToOneEntity> { setOf(it.dealParamOneToOne) }
    ),


//    FullColumnName("DealParamOneToOneOptional_dealParamOneToOneOptional") to ru.vood.dmgen.intf.newIntf.ColumnEntityData(
//        EntityName("Deal"),
////DealSynthetic::dealParamOneToOneOptional,
//        SimpleColumnName("dealParamOneToOneOptional"),
//        true,
//        "null",
//        ColumnKind.SYNTHETIC,
//        Synthetic<DealSynthetic, DealParamOneToOneOptionalSynthetic> {
//            it.dealParamOneToOneOptional?.let { q ->
//                setOf(
//                    q
//                )
//            } ?: setOf()
//        }
//    ),
//    FullColumnName("DealParamSet_dealParamSet") to ru.vood.dmgen.intf.newIntf.ColumnEntityData(
//        EntityName("Deal"),
////DealSynthetic::dealParamSet,
//        SimpleColumnName("dealParamSet"),
//        false,
//        "null",
//        ColumnKind.SYNTHETIC_SET,
//        SyntheticSet<DealSynthetic, DealParamSetEntity> { it.dealParamSet }
//    ),

    FullColumnName("Deal_id") to ColumnEntityData(
        EntityName("Deal"),
//DealEntity::id,
        SimpleColumnName("id"),
        false,
        "Это ее идентификатор",
        ColumnKind.SIMPLE,
        Simple<DealEntity, DealId> { it.id }
    ),
    FullColumnName("Deal_s") to ColumnEntityData(
        EntityName("Deal"),
//DealEntity::s,
        SimpleColumnName("s"),
        false,
        "null",
        ColumnKind.SIMPLE,
        Simple<DealEntity, String> { it.s }
    ),
    FullColumnName("Deal_sn") to ColumnEntityData(
        EntityName("Deal"),
//DealEntity::sn,
        SimpleColumnName("sn"),
        true,
        "null",
        ColumnKind.SIMPLE,
        Simple<DealEntity, String?> { it.sn }
    ),
    FullColumnName("Deal_b") to ColumnEntityData(
        EntityName("Deal"),
//DealEntity::b,
        SimpleColumnName("b"),
        false,
        "null",
        ColumnKind.SIMPLE,
        Simple<DealEntity, Boolean> { it.b }
    ),
    FullColumnName("Deal_bn") to ColumnEntityData(
        EntityName("Deal"),
//DealEntity::bn,
        SimpleColumnName("bn"),
        true,
        "null",
        ColumnKind.SIMPLE,
        Simple<DealEntity, Boolean?> { it.bn }
    ),

    )