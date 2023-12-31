package ru.vood.processor.datamodel.abstraction.model

import ru.vood.processor.datamodel.abstraction.model.dto.ModelClassName


data class MetaInformation(
    val metaForeignKeys: Set<MetaForeignKey>,
    val entities: Map<ModelClassName, MetaEntity>
) {
    val allEntityPackagesImport =
        entities.values.distinctBy { it.designClassPackageName }.map { "import ${it.designClassPackageName}.*" }
            .joinToString("\n")

    fun aggregateInnerDep(): Dependency {

        val filter =
            entities.filter { metaForeignKeys.filter { fk -> fk.fromEntity == it.value }.isEmpty() }
        if (filter.size != 1) {
            error("not found root entity, without ForeignKey on it")
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
    val parent: MetaEntity?
)


