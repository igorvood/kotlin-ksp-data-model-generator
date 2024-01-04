package ru.vood.processor.datamodel.gen

import com.google.devtools.ksp.processing.KSPLogger
import ru.vood.dmgen.annotation.FlowEntityType
import ru.vood.processor.datamodel.abstraction.model.MetaEntity
import ru.vood.processor.datamodel.abstraction.model.MetaForeignKey
import ru.vood.processor.datamodel.abstraction.model.dto.ISyntheticFieldInfo
import ru.vood.processor.datamodel.abstraction.model.dto.SyntheticFieldInfo
import java.util.*


fun syntheticFieldInfos(
    childrenEntities: List<MetaEntity>,
    metaForeignKeys: Set<MetaForeignKey>,
    metaEntity: MetaEntity,
    logger: KSPLogger
): List<ISyntheticFieldInfo> {
    val joinToString = childrenEntities.map { it.entityFieldName }.joinToString(",")
    logger.info("fun syntheticFieldInfos  ${metaEntity.entityFieldName} childrens $joinToString")

    return when (metaEntity.flowEntityType) {
        FlowEntityType.AGGREGATE, FlowEntityType.INNER -> childrenEntities
            .map { childrenMetaEntity ->
                when (val fet = childrenMetaEntity.flowEntityType) {
                    FlowEntityType.AGGREGATE -> Optional.empty<SyntheticFieldInfo>()
                    FlowEntityType.INNER
                    -> {
                        val metaForeignKey =
                            getMetaForeignKey(metaForeignKeys, metaEntity, childrenMetaEntity)
                        Optional.of(SyntheticFieldInfo(childrenMetaEntity, metaForeignKey.relationType, false))
                    }
                    FlowEntityType.ONE_OF -> {
                        val metaForeignKey =
                            getMetaForeignKey(metaForeignKeys, metaEntity, childrenMetaEntity)
                        Optional.of(SyntheticFieldInfo(childrenMetaEntity, metaForeignKey.relationType, true))
                    }
                }
            }
            .filter { !it.isEmpty }
            .map { it.get() }

        FlowEntityType.ONE_OF -> listOf()
    }


}

private fun getMetaForeignKey(
    metaForeignKeys: Set<MetaForeignKey>,
    metaEntity: MetaEntity,
    childredMetaEntity: MetaEntity
): MetaForeignKey {
    val currentFks =
        metaForeignKeys.filter { fk -> fk.toEntity == metaEntity && fk.fromEntity == childredMetaEntity }
    val metaForeignKey =
        if (currentFks.size == 1) currentFks[0] else error("Found several fk from entity ${childredMetaEntity.designClassFullClassName.value} to ${metaEntity.designClassFullClassName.value}  ")
    return metaForeignKey
}