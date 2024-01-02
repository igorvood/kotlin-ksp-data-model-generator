package datamodel

import org.junit.jupiter.api.Test
import ru.vood.dmgen.annotation.FlowEntityType
import ru.vood.dmgen.annotation.RelationType
import ru.vood.dmgen.datamodel.metaEnum.entityDataMap
import ru.vood.dmgen.intf.EntityName
import ru.vood.dmgen.intf.IEntityOrigin
import ru.vood.dmgen.intf.newIntf.EntityData
import ru.vood.dmgen.intf.newIntf.IMetaEntityData
import ru.vood.dmgen.intf.newIntf.SimpleColumnEntityData
import ru.vood.dmgen.intf.newIntf.SyntheticColumnEntityData
import ru.vood.dmgen.meta.DerivativeColumns.entitiesColumnsMap
import ru.vood.dmgen.meta.DerivativeDependencyMap.entityDependencyParentMap
import ru.vood.dmgen.meta.DerivativeFKs.foreignKeyMapFromEntity
import ru.vood.dmgen.serial.ModelJsonSerializer
import java.io.File

class MetaJsonExtractor {

    @Test
    fun entityDataMap() {


        val ent = Ent(entityDataMap.keys)

        val encodeToString = ModelJsonSerializer.modelJsonSerializer.encodeToString(Ent.serializer(), ent)

        File("entityDataMap.json").printWriter().use { out ->

            out.println(encodeToString)

        }

    }


    companion object {
        val head = """@startuml
digraph dfd{
	node[shape=record]"""
    }

    @kotlinx.serialization.Serializable
    data class Ent(
        /*override */val entMap: Set<EntityName>
    )//: IMetaEntityData

}