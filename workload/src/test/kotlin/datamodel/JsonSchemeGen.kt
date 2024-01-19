package datamodel

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.jsonSchema.JsonSchemaGenerator
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import org.junit.jupiter.api.Test
import ru.vood.dmgen.datamodel.metaEnum.EntityEnum

class JsonSchemeGen {


    @Test
    fun asdad() {
        val mapper = ObjectMapper().registerKotlinModule()
        val jsonSchemaGenerator = JsonSchemaGenerator(mapper)

        EntityEnum.values()
            .forEach {
                val runtimeClass = it.entityData().runtimeClass
                val java = runtimeClass.java as Class<*>
                val generateSchema = jsonSchemaGenerator.generateSchema(java)
                val toString = generateSchema.toString()
//                println(generateSchema.)
            }


//        File("schemes/depTree.puml").printWriter().use { out ->
//
//            out.println(PumlGenerator.head)
//            out.println(entities)
//            out.println("")
//            out.println(arrows)
//            out.println(tail)
//
//        }
    }


}