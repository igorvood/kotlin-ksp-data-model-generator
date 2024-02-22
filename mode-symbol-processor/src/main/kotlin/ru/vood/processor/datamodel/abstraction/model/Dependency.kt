package ru.vood.processor.datamodel.abstraction.model

import ru.vood.dmgen.annotation.FlowEntityType
import ru.vood.dmgen.dto.RelationType
import ru.vood.processor.datamodel.abstraction.model.dto.ISyntheticFieldInfo
import ru.vood.processor.datamodel.abstraction.model.dto.SealedSyntheticFieldInfo
import ru.vood.processor.datamodel.abstraction.model.dto.SyntheticFieldInfo
import java.util.*

@kotlinx.serialization.Serializable
data class Dependency(
    val metaEntity: MetaEntity,
    val children: Set<Dependency>,
    val parent: MetaEntity?,
    val metaForeignKeys: Set<MetaForeignKey>,
) {

    val childrenSyntheticFieldsInfo by lazy {
        syntheticFieldInfos(
            children.map { it.metaEntity },
            metaForeignKeys,
            metaEntity
        )
    }

    companion object {
        internal fun syntheticFieldInfos(
            childrenEntities: List<MetaEntity>,
            metaForeignKeys: Set<MetaForeignKey>,
            metaEntity: MetaEntity,
        ): List<ISyntheticFieldInfo> {
            return when (metaEntity.flowEntityType) {
                FlowEntityType.AGGREGATE, FlowEntityType.INNER -> childrenEntities
                    .map { childrenMetaEntity ->
                        when (val fet = childrenMetaEntity.flowEntityType) {
                            FlowEntityType.AGGREGATE, FlowEntityType.INNER,
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

                FlowEntityType.ONE_OF -> {
                    //TODO тут надо проверить а действительно ли RelationType.ONE_TO_ONE_OPTIONAL если не так то бросать исключение
                    listOf(SealedSyntheticFieldInfo(childrenEntities.toSet(), RelationType.ONE_TO_ONE_OPTIONAL, false))
                }
            }


        }

        private fun getMetaForeignKey(
            metaForeignKeys: Set<MetaForeignKey>,
            metaEntity: MetaEntity,
            childredMetaEntity: MetaEntity,
        ): MetaForeignKey {
            val currentFks =
                metaForeignKeys.filter { fk -> fk.toEntity == metaEntity && fk.fromEntity == childredMetaEntity }
            val metaForeignKey =
                if (currentFks.size == 1) currentFks[0] else error("Found several fk from entity ${childredMetaEntity.designClassFullClassName.value} to ${metaEntity.designClassFullClassName.value}  ")
            return metaForeignKey
        }
    }


}