package ru.vood.processor.datamodel.abstraction.model

import com.google.devtools.ksp.processing.KSPLogger
import ru.vood.model.generator.ksp.common.CommonClassNames.setRootPackage
import ru.vood.model.generator.ksp.common.dto.PackageName
import ru.vood.processor.datamodel.NewDataModelConfigProcessor.Companion.commonPackage
import ru.vood.processor.datamodel.abstraction.model.dto.ModelClassName
import ru.vood.processor.datamodel.gen.syntheticFieldInfos


data class MetaInformation(
    val metaForeignKeys: Set<MetaForeignKey>,
    val entities: Map<ModelClassName, MetaEntity>,
    val nullableProbSetDefaultNull: Boolean,
    val logger: KSPLogger,
) {
    val rootPackage by lazy {  PackageName(commonPackage( entities.values.toSet()))}
    init {
        setRootPackage(rootPackage)
    }

    val allEntityPackagesImport =
        entities.values.distinctBy { it.designClassPackageName }.map { "import ${it.designClassPackageName}.*" }
            .joinToString("\n")

    val aggregateInnerDep by lazy { aggregateInnerDepFun() }


    private fun aggregateInnerDepFun(): Dependency {

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
            collectInnerDependency(root, root, metaForeignKeys),
            parent = null,
            metaForeignKeys
        )
    }

    private fun collectInnerDependency(
        parentModelClassName: MetaEntity,
        root: MetaEntity,
        metaForeignKeys: Set<MetaForeignKey>,
    ): Set<Dependency> {
        return this.metaForeignKeys
            .filter { it.toEntity.designClassFullClassName == parentModelClassName.designClassFullClassName }
            .map {
                val collectInnerDependency = collectInnerDependency(it.fromEntity, root, this.metaForeignKeys)
                Dependency(
                    metaEntity = it.fromEntity,
                    children = collectInnerDependency,
                    parent = parentModelClassName,
                    metaForeignKeys
                )
            }
            .toSet()
    }


}

data class Dependency(
    val metaEntity: MetaEntity,
    val children: Set<Dependency>,
    val parent: MetaEntity?,
    val metaForeignKeys: Set<MetaForeignKey>,
) {

    val syntheticFieldsInfo by lazy { syntheticFieldInfos(children.map { it.metaEntity }, metaForeignKeys, metaEntity) }

}


