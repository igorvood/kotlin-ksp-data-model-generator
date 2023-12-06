package ru.vood.dmgen.delete
                    
/**
*Это сущность Сделка
*/          
import kotlinx.serialization.KSerializer
import ru.vood.dmgen.datamodel.Deal
import ru.vood.dmgen.datamodel.runtime.dataclassesOrigin.DealEntity
import ru.vood.dmgen.datamodel.runtime.dataclassesOrigin.DealParamOneToOneOptionalEntity
import ru.vood.dmgen.datamodel.valueClasses.DealId
import ru.vood.dmgen.intf.EntityName
import javax.annotation.processing.Generated
import ru.vood.dmgen.intf.IEntityOrigin
import ru.vood.dmgen.intf.IEntitySynthetic
import ru.vood.dmgen.intf.SerializableEntity
import ru.vood.dmgen.intf.newIntf.IConstructorSyntheticEntity


@Generated("ru.vood.processor.datamodel.gen.runtime.OriginEntityDataClassesGenerator", date = "2023-11-21T20:07:49.996870249")
@kotlinx.serialization.Serializable
open class DealEntity1 (
    /**
*Это ее идентификатор
*/     
override val id: DealId,
    override val s: kotlin.String,
    override val sn: kotlin.String?,
    override val b: kotlin.Boolean,
    override val bn: kotlin.Boolean?

): IEntityOrigin<DealEntity1>, Deal
{
    override fun ktSerializer() = serializer()
    
    override val designEntityName: EntityName
        get() = designEntityNameConst

    
    companion object{
        val designEntityNameConst = EntityName("Deal")
    
    }
}

@Generated("ru.vood.processor.datamodel.gen.runtime.EntityDataClassesGenerator", date = "2023-11-21T20:07:49.993777588")
@kotlinx.serialization.Serializable
//@optics([OpticsTarget.LENS])
data class DealEntitySyntetic (
    override val origin: DealEntity1,
//    val dealParamOneToOne : ru.vood.dmgen.datamodel.runtime.dataclasses.DealParamOneToOneEntity,
    val dealParamOneToOneOptional : DealParamOneToOneOptionalEntity?,
//    val dealParamSet : Set<ru.vood.dmgen.datamodel.runtime.dataclasses.DealParamSetEntity>

): IEntitySynthetic<DealEntity1>
{

    override fun syntheticField(entityName: EntityName): Set<IEntitySynthetic<out IEntityOrigin<*>>> {


        val sdf: IConstructorSyntheticEntity<DealEntity> =
        object: IConstructorSyntheticEntity<DealEntity>{
            override fun construct(origin: DealEntity, ass: Map<EntityName, Any>): IEntitySynthetic<DealEntity> {
                TODO("Not yet implemented")
            }
        }
        TODO("Not yet implemented")
    }

    override fun ktSerializer(): KSerializer<out SerializableEntity<out DealEntity1>> = DealEntitySyntetic.serializer()

    override val designEntityName: EntityName
        get() = TODO("Not yet implemented")
}
//    : ru.vood.dmgen.intf.IAggregate<DealEntity>, ru.vood.dmgen.datamodel.Deal
//{
//    override fun ktSerializer() = serializer()
//
//    override val designEntityName: EntityName
//        get() = designEntityNameConst
//
//
//    companion object{
//        val designEntityNameConst = EntityName("Deal")
//
//    }
//}
                    