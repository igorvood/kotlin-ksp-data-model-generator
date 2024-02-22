package ru.vood.processor.datamodel.abstraction.model

import com.google.devtools.ksp.processing.KSPLogger
import com.squareup.kotlinpoet.ClassName
import kotlinx.serialization.Serializable
import ru.vood.model.generator.ksp.common.CommonClassNames.setRootPackage
import ru.vood.model.generator.ksp.common.dto.PackageName
import ru.vood.processor.datamodel.abstraction.model.dto.ModelClassName


@Serializable
data class MetaInformation(
    val metaForeignKeys: Set<MetaForeignKey>,
    val entities: Map<ModelClassName, MetaEntity>,
    val nullableProbSetDefaultNull: Boolean,
    @kotlinx.serialization.Transient
    val logger: KSPLogger? = null,
) {
    val rootPackage by lazy { PackageName(commonPackage(entities.values.toSet())) }

    init {
        setRootPackage(rootPackage)
    }

    val aggregateInnerDep by lazy { aggregateInnerDepFun() }

    val entityDependency by lazy { entityDependencyFun() }

    private fun entityDependencyFun(): Map<ClassName, Dependency> {

        fun collect(dependency: Dependency): Map<ClassName, Dependency> {
            val pair = dependency.metaEntity.designPoetClassName to dependency

            val map1 = dependency.children
                .map { it -> collect(it) }
                .fold(mapOf<ClassName, Dependency>()) { acc, cur -> acc.plus(cur) }
            return map1.plus(pair)
        }

        return collect(aggregateInnerDep)
    }

    private fun aggregateInnerDepFun(): Dependency {

        val filter =
            entities.filter { metaForeignKeys.filter { fk -> fk.fromEntity == it.value }.isEmpty() }
        when {
            filter.isEmpty() -> logger?.kspError("Not found root entity, without ForeignKey from it")
            filter.size > 1 -> logger?.kspError(
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
            .filter { it.toEntity == parentModelClassName }
            .map {
                val collectInnerDependency = collectInnerDependency(it.fromEntity, root, metaForeignKeys)
                Dependency(
                    metaEntity = it.fromEntity,
                    children = collectInnerDependency,
                    parent = parentModelClassName,
                    metaForeignKeys
                )
            }
            .toSet()
    }

    companion object {
        private fun commonPackage(setMetaEnt: Set<MetaEntity>): String {
            tailrec fun commonPackageRecursive(currentPackage: String, packacges: List<String>): String {
                return when (packacges.isEmpty()) {
                    true -> currentPackage
                    false -> {
                        val nextPack = packacges[0]

                        var collector = ""

                        for (q in nextPack.withIndex()) {
                            if (currentPackage.getOrElse(q.index) { '~' } == q.value) {
                                collector = collector.plus(q.value)
                            } else {
                                break
                            }
                        }

                        commonPackageRecursive(collector, packacges.drop(1))
                    }
                }

            }

            val toList = setMetaEnt.toList().map { it.designPoetClassName.packageName }
            val value = toList[0]
            return commonPackageRecursive(value, toList.drop(1))
        }
    }

}




