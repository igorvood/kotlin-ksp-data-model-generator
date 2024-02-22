package ru.vood.processor.datamodel.abstraction.model.dto

import ru.vood.dmgen.dto.RelationType
import ru.vood.processor.datamodel.abstraction.model.MetaEntity


/**свойства синтетического поля*/
sealed interface ISyntheticFieldInfo {
    /**тип связи*/
    val relationType: RelationType
    /**признак опциональности*/
    val isOneOf: Boolean
}

data class SyntheticFieldInfo(
    /**сущность из которой идет ссылка*/
    val metaEntity: MetaEntity,
    /**тип связи*/
    override val relationType: RelationType,
    /**признак опциональности*/
    override val isOneOf: Boolean,
) : ISyntheticFieldInfo

data class SealedSyntheticFieldInfo(
    val metaEntities: Set<MetaEntity>,
    /**тип связи*/
    override val relationType: RelationType,
    /**признак опциональности*/
    override val isOneOf: Boolean,
) : ISyntheticFieldInfo{

    init {
        require(metaEntities.size>1){"Synthetic sealed entity must have more than one FK on it"}
    }
}


//val partOfMetaEntity: MetaEntity?
