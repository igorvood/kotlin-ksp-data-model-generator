package ru.vood.dmgen.delete
                    
/**
*Это сущность Сделка
*/          
import ru.vood.dmgen.intf.IEntitySynthetic     
import ru.vood.dmgen.intf.EntityName
import javax.annotation.processing.Generated
import ru.vood.dmgen.datamodel.runtime.dataclassesOrigin.*
import ru.vood.dmgen.datamodel.runtime.dataclassesSynthetic.DealParamOneToOneOptionalSynthetic
import ru.vood.dmgen.datamodel.runtime.dataclassesSynthetic.DealParamOneToOneSynthetic
import ru.vood.dmgen.datamodel.runtime.dataclassesSynthetic.DealParamSetSynthetic

@Generated("ru.vood.processor.datamodel.gen.runtime.SyntheticFieldExtractorsGenerator", date = "2023-11-21T20:58:51.788685236")
@kotlinx.serialization.Serializable
data class DealSynthetic (
    override val origin: DealEntity,
    val dealParamOneToOne : DealParamOneToOneSynthetic,
    val dealParamOneToOneOptional : DealParamOneToOneOptionalSynthetic?,
    val dealParamSet : Set<DealParamSetSynthetic>

): IEntitySynthetic<DealEntity>         
{


    constructor(origin: DealEntity, ass: Map<EntityName, Any>) : this(origin,
        ass[EntityName("asd")]!! as DealParamOneToOneSynthetic,
        ass[EntityName("asd")] as DealParamOneToOneOptionalSynthetic,
        ass[EntityName("asd")]!! as Set<DealParamSetSynthetic>,

    )



    override fun ktSerializer() = serializer()
    
    override val designEntityName: EntityName
        get() = designEntityNameConst

    
    companion object{
        val designEntityNameConst = EntityName("Deal")
    
    }
}
                    