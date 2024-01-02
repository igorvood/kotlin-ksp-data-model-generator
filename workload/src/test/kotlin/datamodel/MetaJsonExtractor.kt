package datamodel

import com.charleskorn.kaml.Yaml
import kotlinx.serialization.Serializable
import kotlinx.serialization.hocon.Hocon
import org.junit.jupiter.api.Test
import ru.vood.dmgen.annotation.FlowEntityType
import ru.vood.dmgen.datamodel.metaEnum.entityDataMap
import ru.vood.dmgen.intf.EntityName
import ru.vood.dmgen.intf.IEntityOrigin
import ru.vood.dmgen.intf.newIntf.EntityData
import ru.vood.dmgen.serial.ModelJsonSerializer
import java.io.File

class MetaJsonExtractor {

    @Test
    fun entityDataMap() {


//        val toMap = entityDataMap.entries.map { it -> it.key to EntityDataJson.of(it.value) }.toMap()
//
//        val ent = Ent(toMap)
//
//        val encodeToString = ModelJsonSerializer.modelJsonSerializer.encodeToString(Ent.serializer(), ent)
//
//        File("entityDataMap.json").printWriter().use { out ->
//            out.println(encodeToString)
//        }
//
//        val hocon = Hocon { }
//        File("entityDataMap.hocon").printWriter().use { out ->
//            out.println(hocon.encodeToConfig(Ent.serializer(), ent).toString())
//        }
//
//
//        val yml = Yaml
//        val default = yml.default
//        File("entityDataMap.yml").printWriter().use { out ->
//            out.println(default.encodeToString(Ent.serializer(), ent))
//        }

    }

    @Serializable
    data class Ent(
        /*override */val entMap: Map<EntityName, EntityDataJson>
    )//: IMetaEntityData

    @Serializable
    data class EntityDataJson(
        /**интрефейс описывающий структуру сущности */
        val designClass: String,
        /**класс описывающий сущность*/
        val runtimeClass: String,
        /**синтетический класс описывающий сущность, включает в себя все сущности, которорые имею форен на текущую*/
        val runtimeSyntheticClass: String,
        /**сериализатор оригинальной сущности*/
        val serializer: String,
        /**сериализатор синтетической сущности*/
        val serializerSynthetic: String,
        /**Имя сущности*/
        val entityName: EntityName,
        /**коментарий сущности*/
        val comment: String,
        /**тип сущности*/
        val entityType: FlowEntityType
    )//: IEntityData<T>
    {
        companion object {
            fun of(d: EntityData<IEntityOrigin>): EntityDataJson {
                return EntityDataJson(
                    d.designClass.qualifiedName!!,
                    d.runtimeClass.qualifiedName!!,
                    d.runtimeSyntheticClass.qualifiedName!!,
                    d.serializer.descriptor.serialName,
                    d.serializerSynthetic.descriptor.serialName,
                    d.entityName,
                    d.comment,
                    d.entityType,
                )
            }
        }
    }


}