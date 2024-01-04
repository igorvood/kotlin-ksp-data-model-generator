package ru.vood.processor.datamodel.gen.runtime.intf

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.KSPLogger
import ru.vood.dmgen.annotation.FkPairNew
import ru.vood.dmgen.annotation.FlowEntityType
import ru.vood.dmgen.annotation.RelationType
import ru.vood.dmgen.dto.UkName
import ru.vood.dmgen.dto.EntityName
import ru.vood.dmgen.dto.SimpleColumnName
import ru.vood.dmgen.dto.SimpleColumnType
import ru.vood.processor.datamodel.abstraction.model.MetaInformation
import ru.vood.dmgen.dto.TypeUk
import ru.vood.processor.datamodel.gen.*
import java.time.LocalDateTime
import javax.annotation.processing.Generated

class InterfaceGenerator(
    codeGenerator: CodeGenerator,
    rootPackage: PackageName,
    logger: KSPLogger

) : AbstractGenerator<MetaInformation>(codeGenerator, rootPackage, logger) {

    override fun textGenerator(metaInfo: MetaInformation): Set<GeneratedFile> {
        val trimIndent = """
package ${packageName.value}


import kotlinx.serialization.KSerializer
import ${Generated::class.java.canonicalName}
import ${UkName::class.java.canonicalName}
import ${EntityName::class.java.canonicalName}
import ${SimpleColumnName::class.java.canonicalName}
import ${SimpleColumnType::class.java.canonicalName}
import ${FlowEntityType::class.java.canonicalName}
import kotlin.reflect.KClass
import ${RelationType::class.java.canonicalName}
import ${FkPairNew::class.java.canonicalName}
import ${TypeUk::class.java.canonicalName}



@Generated("${this.javaClass.canonicalName}", date = "${LocalDateTime.now()}")
interface ${GeneratedClasses.SerializableEntity} {
    val designEntityName: EntityName
}

@Generated("${this.javaClass.canonicalName}", date = "${LocalDateTime.now()}")
interface ${GeneratedClasses.IEntityOrigin} : SerializableEntity

@Generated("${this.javaClass.canonicalName}", date = "${LocalDateTime.now()}")
interface ${GeneratedClasses.IEntityDetail}<T : IEntityOrigin> : IEntityOrigin {

    val origin: T
    fun syntheticField(entityName: EntityName): Set<IEntityDetail<out IEntityOrigin>>

}

@Generated("${this.javaClass.canonicalName}", date = "${LocalDateTime.now()}")
interface ${GeneratedClasses.IContextOf}<T : IEntityOrigin> : SerializableEntity {

    val ukName: UkName

    val ktEntitySerializer: KSerializer<T>

    val ktSyntheticEntitySerializer: KSerializer<out IEntityDetail<out T>>

}

/**Мета данные по реквизиту сущности*/
sealed interface ${GeneratedClasses.ColumnEntityData}<T> {
    /**имя сущности*/
    val entity: EntityName

    /**имя колонки*/
    val simpleColumnName: SimpleColumnName

    /**признак опциональности колонки*/
    val isOptional: Boolean

    /**коментарий колонки*/
    val comment: String
    /**ф-ция экстрактор значения колонки*/
}

data class ${GeneratedClasses.SimpleColumnEntityData}<T : IEntityOrigin>(
    override val entity: EntityName,
    /**имя колонки*/
    override val simpleColumnName: SimpleColumnName,
    /**признак опциональности колонки*/
    override val isOptional: Boolean,
    /**коментарий колонки*/
    override val comment: String,
    /**ф-ция экстрактор значения колонки*/
    val iColExtractFunction: SimpleColExtractFunction<T, *>,
    val simpleColumnType: SimpleColumnType
) : ${GeneratedClasses.ColumnEntityData}<T>


data class ${GeneratedClasses.SyntheticColumnEntityData}<T>(
    override val entity: EntityName,
    /**имя колонки*/
    override val simpleColumnName: SimpleColumnName,
    /**признак опциональности колонки*/
    override val isOptional: Boolean,
    /**коментарий колонки*/
    override val comment: String,
    /**ф-ция экстрактор значения колонки*/
    val iColExtractFunction: ISyntheticColExtractFunction<T, *>,
    val outEntity: EntityName
) : ${GeneratedClasses.ColumnEntityData}<T>

data class ${GeneratedClasses.SealedSyntheticColumnEntityData}<T>(
    override val entity: EntityName,
    /**имя колонки*/
    override val simpleColumnName: SimpleColumnName,
    /**признак опциональности колонки*/
    override val isOptional: Boolean,
    /**коментарий колонки*/
    override val comment: String,
    /**ф-ция экстрактор значения колонки*/
//    override val iColExtractFunction: ISyntheticColExtractFunction<T, *>,
    val outEntities: Set<EntityName>
) : ${GeneratedClasses.ColumnEntityData}<T>

sealed interface ${GeneratedClasses.IColExtractFunction}<in T, out OUT> {
    val extractFieldValue: (entity: T) -> OUT
}

sealed interface ${GeneratedClasses.ISyntheticColExtractFunction}<in T, out OUT> : ${GeneratedClasses.IColExtractFunction}<T, OUT>

@JvmInline
value class ${GeneratedClasses.SimpleColExtractFunction}<T : IEntityOrigin, OUT>(
    override val extractFieldValue: (entity: T) -> OUT
) : ${GeneratedClasses.IColExtractFunction}<T, OUT>

@JvmInline
value class ${GeneratedClasses.Synthetic}<
        ORIG_IN : IEntityOrigin,
        SINTH_IN : IEntityDetail<out ORIG_IN>,
        OUT : IEntityOrigin>(
    override val extractFieldValue: (entity: SINTH_IN) -> Set<IEntityDetail<OUT>>
) : ${GeneratedClasses.ISyntheticColExtractFunction}<SINTH_IN, Set<IEntityDetail<OUT>>>

@JvmInline
value class ${GeneratedClasses.SyntheticSet}<
        ORIG_IN : IEntityOrigin,
        SINTH_IN : IEntityDetail<out ORIG_IN>,
        OUT : IEntityOrigin>(
    override val extractFieldValue: (entity: SINTH_IN) -> Set<IEntityDetail<OUT>>
) : ${GeneratedClasses.ISyntheticColExtractFunction}<SINTH_IN, Set<IEntityDetail<OUT>>>


/**Мета данные по сущности*/
sealed interface ${GeneratedClasses.IEntityData}<T : IEntityOrigin> {
    /**интрефейс описывающий структуру сущности */
    val designClass: KClass<out Any>

    /**класс описывающий сущность*/
    val runtimeClass: KClass<out T>

    /**синтетический класс описывающий сущность, включает в себя все сущности, которорые имею форен на текущую*/
    val runtimeSyntheticClass: KClass<out T>

    /**сериализатор оригинальной сущности*/
    val serializer: KSerializer<out IEntityOrigin>

    /**сериализатор синтетической сущности*/
    val serializerSynthetic: KSerializer<out IEntityDetail<out T>>

    /**Имя сущности*/
    val entityName: EntityName

    /**коментарий сущности*/
    val comment: String

    /**тип сущности*/
    val entityType: FlowEntityType
}

/**Мета данные по сущности*/
data class ${GeneratedClasses.EntityData}<T : IEntityOrigin>(
    /**интрефейс описывающий структуру сущности */
    override val designClass: KClass<out Any>,
    /**класс описывающий сущность*/
    override val runtimeClass: KClass<out T>,
    /**синтетический класс описывающий сущность, включает в себя все сущности, которорые имею форен на текущую*/
    override val runtimeSyntheticClass: KClass<out T>,
    /**сериализатор оригинальной сущности*/
    override val serializer: KSerializer<out IEntityOrigin>,
    /**сериализатор синтетической сущности*/
    override val serializerSynthetic: KSerializer<out IEntityDetail<out T>>,
    /**Имя сущности*/
    override val entityName: EntityName,
    /**коментарий сущности*/
    override val comment: String,
    /**тип сущности*/
    override val entityType: FlowEntityType
) : ${GeneratedClasses.IEntityData}<T>

data class ${GeneratedClasses.SealedEntityData}<T : IEntityOrigin>(
    /**интрефейс описывающий структуру сущности */
    override val designClass: KClass<out Any>,
    /**класс описывающий сущность*/
    override val runtimeClass: KClass<out T>,
    /**синтетический класс описывающий сущность, включает в себя все сущности, которорые имею форен на текущую*/
    override val runtimeSyntheticClass: KClass<out T>,
    /**сериализатор оригинальной сущности*/
    override val serializer: KSerializer<out IEntityOrigin>,
    /**сериализатор синтетической сущности*/
    override val serializerSynthetic: KSerializer<out IEntityDetail<out T>>,
    /**Имя сущности*/
    override val entityName: EntityName,
    /**коментарий сущности*/
    override val comment: String,
    /**тип сущности*/
    override val entityType: FlowEntityType,
    /**перечень наследников*/
    val children: Set<EntityName>
) : ${GeneratedClasses.IEntityData}<T>

/**Мета данные по внегнему ключу*/
data class ${GeneratedClasses.FKMetaData}<T : IEntityOrigin>(
    /**Сущность из которой идет внешний ключ*/
    val fromEntity: EntityName,
    /**Сущность к которой идет внешний ключ*/
    val toEntity: EntityName,
    /**Имя уикалоного индекса из toEntity на которой нацелен внешний ключ*/
    val uk: UkName,
    /**Тип связи
     * TODO по идеи величина вычисляемая, сейчас задается разработчиком*/
    val relationType: RelationType,
    /**Коллекция колонок входящих во внешний ключ */
    val fkCols: Set<FkPairNew>,
    /**Ф-ция вытаскивающая из fromEntity, экземпляр уникального ключа toEntity -> uk.
     * хорошо подходит для поиска  */
    val сontextExtractor: (T) -> IContextOf<out IEntityOrigin>
)


/**Мета данные по уникальному ключу*/
data class ${GeneratedClasses.UKEntityData}<T : IEntityOrigin>(
    /**Имя уникального ключа*/
    val ukName: UkName,
    /**Колонки входящие в ключ*/
    val columns: List<SimpleColumnName>,
    /**Сериализатор уникального ключа*/
    val serializer: KSerializer<out IContextOf<out T>>,
    /**Класс уникального ключа*/
    val ukClass: KClass<out IContextOf<out T>>,
    /**Имя сушности, к которой относится уникальный ключ*/
    val entity: EntityName,
    /**Экстрактор уникального ключа из ДТО*/
    val extractContext: (T) -> IContextOf<T>,
    /**Тип уникального ключа PK, UK*/
    val typeUk: TypeUk
//    override val contextOfClass: KClass<IContextOf<T>>
)


""".trimIndent()
        val generatedFile = GeneratedFile(
            FileName("DataInterfaces"),
            GeneratedCode(trimIndent),
            packageName
        )

        return setOf(generatedFile)
    }

    override val subPackage: PackageName
        get() = interfaceGeneratorPackageName

    companion object {
        val interfaceGeneratorPackageName = PackageName("intf")
    }

    enum class GeneratedClasses{
        SerializableEntity,
        IEntityOrigin,
        IEntityDetail,
        IContextOf,
        ColumnEntityData,
        SimpleColumnEntityData,
        SyntheticColumnEntityData,
        SealedSyntheticColumnEntityData,
        IColExtractFunction,
        ISyntheticColExtractFunction,
        SimpleColExtractFunction,
        Synthetic,
        SyntheticSet,
        IEntityData,
        EntityData,
        FKMetaData,
        SealedEntityData,
        UKEntityData;

        fun getPac(root: PackageName) = root.value+"."+interfaceGeneratorPackageName.value+"."+this
    }
}