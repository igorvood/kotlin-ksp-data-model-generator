package ru.vood.processor.datamodel.abstraction.model

import com.google.devtools.ksp.processing.KSPLogger
import ru.vood.processor.datamodel.abstraction.model.dto.ModelClassName


data class MetaInformation(
    val metaForeignKeys: Set<MetaForeignKey>,
    val entities: Map<ModelClassName, MetaEntity>,
    val nullableProbSetDefaultNull: Boolean,
) {
    val allEntityPackagesImport =
        entities.values.distinctBy { it.designClassPackageName }.map { "import ${it.designClassPackageName}.*" }
            .joinToString("\n")

    fun aggregateInnerDep(logger: KSPLogger): Dependency {

        val filter =
            entities.filter { metaForeignKeys.filter { fk -> fk.fromEntity == it.value }.isEmpty() }
        when {
            filter.isEmpty() -> logger.kspError("Not found root entity, without ForeignKey from it")
            filter.size > 1 -> logger.kspError(
                "Found ${filter.size} root entity, must be only one, without ForeignKey from it: ${
                    filter.keys.joinToString(", ") { it.value }
                }"
            )
        }

        val root = filter.entries.toList()[0].value
        return Dependency(
            metaEntity = root,
            collectInnerDependency(root, root),
            parent = null
        )
    }

    private fun collectInnerDependency(parentModelClassName: MetaEntity, root: MetaEntity): Set<Dependency> {
        return metaForeignKeys
            .filter { it.toEntity.designClassFullClassName == parentModelClassName.designClassFullClassName }
            .map {
                val collectInnerDependency = collectInnerDependency(it.fromEntity, root)
                Dependency(
                    metaEntity = it.fromEntity,
                    children = collectInnerDependency,
                    parent = parentModelClassName
                )
            }
            .toSet()
    }


}

data class Dependency(
    val metaEntity: MetaEntity,
    val children: Set<Dependency>,
    val parent: MetaEntity?,
)


