package datamodel

import kotlinx.serialization.Serializable
import org.junit.jupiter.api.Test
import ru.vood.dmgen.annotation.FlowEntityType
import ru.vood.dmgen.datamodel.intf.EntityData
import ru.vood.dmgen.datamodel.metaEnum.EntityEnum

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
        /*override */
        val entMap: Map<EntityEnum, EntityDataJson>,
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
        val entityName: EntityEnum,
        /**коментарий сущности*/
        val comment: String,
        /**тип сущности*/
        val entityType: FlowEntityType,
    )//: IEntityData<T>
    {
        companion object {
            fun of(d: EntityData): EntityDataJson {
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