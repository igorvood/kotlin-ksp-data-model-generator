package ru.vood.processor.datamodel.abstraction.model

import ru.vood.processor.datamodel.gen.syntheticFieldInfos

data class Dependency(
    val metaEntity: MetaEntity,
    val children: Set<Dependency>,
    val parent: MetaEntity?,
    val metaForeignKeys: Set<MetaForeignKey>,
) {

    val syntheticFieldsInfo by lazy { syntheticFieldInfos(children.map { it.metaEntity }, metaForeignKeys, metaEntity) }

}