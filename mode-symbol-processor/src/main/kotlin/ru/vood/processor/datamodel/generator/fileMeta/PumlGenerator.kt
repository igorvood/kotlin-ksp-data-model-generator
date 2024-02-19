package ru.vood.processor.datamodel.generator.fileMeta

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.Dependencies
import com.squareup.kotlinpoet.FileSpec
import ru.vood.dmgen.annotation.FlowEntityType
import ru.vood.dmgen.dto.RelationType
import ru.vood.processor.datamodel.abstraction.model.MetaInformation
import ru.vood.processor.datamodel.gen.appendText
import ru.vood.processor.datamodel.generator.abstraction.AbstractGenerator

class PumlGenerator(
    val codeGenerator: CodeGenerator,
    val metaInformation: MetaInformation,
) : AbstractGenerator() {


    override fun files(): List<FileSpec> {
        val entities = metaInformation.entities
            .values
            .map { en ->
                val colourName = when (val entityData = en.flowEntityType) {
                    FlowEntityType.ONE_OF -> "Yellow"
                    FlowEntityType.INNER -> "Green"
                    FlowEntityType.AGGREGATE -> "Red"
                }
                val culumns = en.fields
                    .map { col ->
                        val typeCol = col.name.value
                        "${col.name.value}: $typeCol${col.question}"
                    }.joinToString("\\n")

                """${en.designPoetClassName.simpleName} [label="{<f0> ${en.designPoetClassName.simpleName}|<f1> $culumns }" shape=Mrecord color=$colourName];"""

            }
            .joinToString("\n")


        val arrows = metaInformation.metaForeignKeys
            .map { e ->
                val entityName = e.fromEntity.designPoetClassName.simpleName
                val toEntity = e.toEntity.designPoetClassName.simpleName

                val arrowColor = when (e.relationType) {
                    RelationType.MANY_TO_ONE -> "color=Indigo"//"color=Yellow"
                    RelationType.ONE_TO_ONE_OPTIONAL -> "color=Green"
                    RelationType.ONE_TO_ONE_MANDATORY -> "color=Red"
                }
                """${entityName} -> ${toEntity}[ $arrowColor];"""
            }
            .joinToString("\n")


        kotlin.runCatching {
            val file = codeGenerator.createNewFile(
                Dependencies.ALL_FILES,
                "scheme",
                "Scheme", "puml"
            )

            file.appendText(head)
            file.appendText(entities)
            file.appendText("")
            file.appendText(arrows)
            file.appendText(tail)
            file.close()
        }
        return listOf()

    }

    companion object {
        val head = """@startuml
digraph dfd{
	node[shape=record]"""

        val tail = """
}
@enduml"""

    }


}