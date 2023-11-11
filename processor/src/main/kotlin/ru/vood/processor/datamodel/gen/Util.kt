package ru.vood.processor.datamodel.gen

import ru.vood.dmgen.annotation.FlowEntityType
import ru.vood.processor.datamodel.abstraction.model.MetaEntity
import ru.vood.processor.datamodel.abstraction.model.MetaForeignKey
import ru.vood.processor.datamodel.abstraction.model.dto.SyntheticFieldInfo
import java.util.*


fun syntheticFieldInfos(
    childrenEntities: List<MetaEntity>,
    metaForeignKeys: Set<MetaForeignKey>,
    metaEntity: MetaEntity
): List<SyntheticFieldInfo> = childrenEntities
    .map { childredMetaEntity ->
        when (val fet = childredMetaEntity.flowEntityType) {
            FlowEntityType.AGGREGATE -> Optional.empty<SyntheticFieldInfo>()
            FlowEntityType.INNER_MANDATORY, FlowEntityType.INNER_OPTIONAL -> {
                val currentFks =
                    metaForeignKeys.filter { fk -> fk.toEntity == metaEntity && fk.fromEntity == childredMetaEntity }
                val metaForeignKey =
                    if (currentFks.size == 1) currentFks[0] else error("Found several fk from entity ${childredMetaEntity.designClassFullClassName.value} to ${metaEntity.designClassFullClassName.value}  ")
                Optional.of(SyntheticFieldInfo(childredMetaEntity, fet.isOptional, metaForeignKey.relationType))
            }

        }
    }
    .filter { !it.isEmpty }
    .map { it.get() }