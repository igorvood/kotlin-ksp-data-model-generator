package ru.vood.processor.datamodel.gen.runtime.intf

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.KSPLogger
import ru.vood.dmgen.dto.FkPair
import ru.vood.dmgen.annotation.FlowEntityType
import ru.vood.dmgen.dto.RelationType
import ru.vood.dmgen.dto.*
import ru.vood.processor.datamodel.abstraction.model.MetaInformation
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
import ${FkPair::class.java.canonicalName}
import ${TypeUk::class.java.canonicalName}



@Generated("${this.javaClass.canonicalName}", date = "${LocalDateTime.now()}")
interface ${GeneratedClasses.SerializableEntity} {
    val designEntityName: EntityName
}

@Generated("${this.javaClass.canonicalName}", date = "${LocalDateTime.now()}")
interface ${GeneratedClasses.IEntityOrigin} : ${GeneratedClasses.SerializableEntity}

@Generated("${this.javaClass.canonicalName}", date = "${LocalDateTime.now()}")
interface ${GeneratedClasses.IEntityDetail}<T : ${GeneratedClasses.IEntityOrigin}> : ${GeneratedClasses.IEntityOrigin} {

    val origin: T
    fun syntheticField(entityName: ${EntityName::class.java.simpleName}): Set<${GeneratedClasses.IEntityDetail}<out ${GeneratedClasses.IEntityOrigin}>>

}

@Generated("${this.javaClass.canonicalName}", date = "${LocalDateTime.now()}")
interface ${GeneratedClasses.IContextOf}<T : ${GeneratedClasses.IEntityOrigin}> : ${GeneratedClasses.SerializableEntity} {

    val ukName: ${UkName::class.java.simpleName}

    val ktEntitySerializer: KSerializer<T>

    val ktSyntheticEntitySerializer: KSerializer<out ${GeneratedClasses.IEntityDetail}<out T>>

}

@Generated("${this.javaClass.canonicalName}", date = "${LocalDateTime.now()}")
/**Мета данные по реквизиту сущности*/
sealed interface ${GeneratedClasses.ColumnEntityData}<T> {
    /**имя сущности*/
    val entity: ${EntityName::class.java.simpleName}

    /**имя колонки*/
    val simpleColumnName: ${SimpleColumnName::class.java.simpleName}

    /**признак опциональности колонки*/
    val isOptional: Boolean

    /**коментарий колонки*/
    val comment: ${String::class.java.simpleName}
    /**ф-ция экстрактор значения колонки*/
}

@Generated("${this.javaClass.canonicalName}", date = "${LocalDateTime.now()}")
data class ${GeneratedClasses.SimpleColumnEntityData}<T : ${GeneratedClasses.IEntityOrigin}>(
    override val entity: ${EntityName::class.java.simpleName},
    /**имя колонки*/
    override val simpleColumnName: ${SimpleColumnName::class.java.simpleName},
    /**признак опциональности колонки*/
    override val isOptional: Boolean,
    /**коментарий колонки*/
    override val comment: String,
    /**ф-ция экстрактор значения колонки*/
    val iColExtractFunction: ${GeneratedClasses.SimpleColExtractFunction}<T, *>,
    val simpleColumnType: ${SimpleColumnType::class.java.simpleName}
) : ${GeneratedClasses.ColumnEntityData}<T>


@Generated("${this.javaClass.canonicalName}", date = "${LocalDateTime.now()}")
data class ${GeneratedClasses.SyntheticColumnEntityData}<T>(
    override val entity: ${EntityName::class.java.simpleName},
    /**имя колонки*/
    override val simpleColumnName: ${SimpleColumnName::class.java.simpleName},
    /**признак опциональности колонки*/
    override val isOptional: Boolean,
    /**коментарий колонки*/
    override val comment: String,
    /**ф-ция экстрактор значения колонки*/
    val iColExtractFunction: ${GeneratedClasses.ISyntheticColExtractFunction}<T, *>,
    val outEntity: ${EntityName::class.java.simpleName}
) : ${GeneratedClasses.ColumnEntityData}<T>

@Generated("${this.javaClass.canonicalName}", date = "${LocalDateTime.now()}")
data class ${GeneratedClasses.SealedSyntheticColumnEntityData}<T>(
    override val entity: ${EntityName::class.java.simpleName},
    /**имя колонки*/
    override val simpleColumnName: ${SimpleColumnName::class.java.simpleName},
    /**признак опциональности колонки*/
    override val isOptional: Boolean,
    /**коментарий колонки*/
    override val comment: String,
    /**ф-ция экстрактор значения колонки*/
//    override val iColExtractFunction: ${GeneratedClasses.ISyntheticColExtractFunction}<T, *>,
    val outEntities: Set<${EntityName::class.java.simpleName}>
) : ${GeneratedClasses.ColumnEntityData}<T>

@Generated("${this.javaClass.canonicalName}", date = "${LocalDateTime.now()}")
sealed interface ${GeneratedClasses.IColExtractFunction}<in T, out OUT> {
    val extractFieldValue: (entity: T) -> OUT
}

@Generated("${this.javaClass.canonicalName}", date = "${LocalDateTime.now()}")
sealed interface ${GeneratedClasses.ISyntheticColExtractFunction}<in T, out OUT> : ${GeneratedClasses.IColExtractFunction}<T, OUT>

@JvmInline
@Generated("${this.javaClass.canonicalName}", date = "${LocalDateTime.now()}")
value class ${GeneratedClasses.SimpleColExtractFunction}<T : IEntityOrigin, OUT>(
    override val extractFieldValue: (entity: T) -> OUT
) : ${GeneratedClasses.IColExtractFunction}<T, OUT>

@JvmInline
@Generated("${this.javaClass.canonicalName}", date = "${LocalDateTime.now()}")
value class ${GeneratedClasses.Synthetic}<
        ORIG_IN : ${GeneratedClasses.IEntityOrigin},
        SINTH_IN : ${GeneratedClasses.IEntityDetail}<out ORIG_IN>,
        OUT : ${GeneratedClasses.IEntityOrigin}>(
    override val extractFieldValue: (entity: SINTH_IN) -> Set<${GeneratedClasses.IEntityDetail}<OUT>>
) : ${GeneratedClasses.ISyntheticColExtractFunction}<SINTH_IN, Set<${GeneratedClasses.IEntityDetail}<OUT>>>

@JvmInline
@Generated("${this.javaClass.canonicalName}", date = "${LocalDateTime.now()}")
value class ${GeneratedClasses.SyntheticSet}<
        ORIG_IN : ${GeneratedClasses.IEntityOrigin},
        SINTH_IN : ${GeneratedClasses.IEntityDetail}<out ORIG_IN>,
        OUT : ${GeneratedClasses.IEntityOrigin}>(
    override val extractFieldValue: (entity: SINTH_IN) -> Set<${GeneratedClasses.IEntityDetail}<OUT>>
) : ${GeneratedClasses.ISyntheticColExtractFunction}<SINTH_IN, Set<${GeneratedClasses.IEntityDetail}<OUT>>>


@Generated("${this.javaClass.canonicalName}", date = "${LocalDateTime.now()}")
/**Мета данные по сущности*/
sealed interface ${GeneratedClasses.IEntityData}<T : IEntityOrigin> {
    /**интрефейс описывающий структуру сущности */
    val designClass: KClass<out Any>

    /**класс описывающий сущность*/
    val runtimeClass: KClass<out T>

    /**синтетический класс описывающий сущность, включает в себя все сущности, которорые имею форен на текущую*/
    val runtimeSyntheticClass: KClass<out T>

    /**сериализатор оригинальной сущности*/
    val serializer: KSerializer<out ${GeneratedClasses.IEntityOrigin}>

    /**сериализатор синтетической сущности*/
    val serializerSynthetic: KSerializer<out ${GeneratedClasses.IEntityDetail}<out T>>

    /**Имя сущности*/
    val entityName: ${EntityName::class.java.simpleName}

    /**коментарий сущности*/
    val comment: String

    /**тип сущности*/
    val entityType: ${FlowEntityType::class.java.simpleName}
}

/**Мета данные по сущности*/
data class ${GeneratedClasses.EntityData}<T : ${GeneratedClasses.IEntityOrigin}>(
    /**интрефейс описывающий структуру сущности */
    override val designClass: KClass<out Any>,
    /**класс описывающий сущность*/
    override val runtimeClass: KClass<out T>,
    /**синтетический класс описывающий сущность, включает в себя все сущности, которорые имею форен на текущую*/
    override val runtimeSyntheticClass: KClass<out T>,
    /**сериализатор оригинальной сущности*/
    override val serializer: KSerializer<out ${GeneratedClasses.IEntityOrigin}>,
    /**сериализатор синтетической сущности*/
    override val serializerSynthetic: KSerializer<out ${GeneratedClasses.IEntityDetail}<out T>>,
    /**Имя сущности*/
    override val entityName: ${EntityName::class.java.simpleName},
    /**коментарий сущности*/
    override val comment: String,
    /**тип сущности*/
    override val entityType: ${FlowEntityType::class.java.simpleName} 
) : ${GeneratedClasses.IEntityData}<T>

data class ${GeneratedClasses.SealedEntityData}<T : ${GeneratedClasses.IEntityOrigin}>(
    /**интрефейс описывающий структуру сущности */
    override val designClass: KClass<out Any>,
    /**класс описывающий сущность*/
    override val runtimeClass: KClass<out T>,
    /**синтетический класс описывающий сущность, включает в себя все сущности, которорые имею форен на текущую*/
    override val runtimeSyntheticClass: KClass<out T>,
    /**сериализатор оригинальной сущности*/
    override val serializer: KSerializer<out ${GeneratedClasses.IEntityOrigin}>,
    /**сериализатор синтетической сущности*/
    override val serializerSynthetic: KSerializer<out ${GeneratedClasses.IEntityDetail}<out T>>,
    /**Имя сущности*/
    override val entityName: ${EntityName::class.java.simpleName},
    /**коментарий сущности*/
    override val comment: String,
    /**тип сущности*/
    override val entityType: ${FlowEntityType::class.java.simpleName},
    /**перечень наследников*/
    val children: Set<${EntityName::class.java.simpleName}>
) : ${GeneratedClasses.IEntityData}<T>

/**Мета данные по внегнему ключу*/
data class ${GeneratedClasses.FKMetaData}<T : ${GeneratedClasses.IEntityOrigin}>(
    /**Сущность из которой идет внешний ключ*/
    val fromEntity: ${EntityName::class.java.simpleName},
    /**Сущность к которой идет внешний ключ*/
    val toEntity: ${EntityName::class.java.simpleName},
    /**Имя уикалоного индекса из toEntity на которой нацелен внешний ключ*/
    val uk: ${UkName::class.java.simpleName},
    /**Тип связи
     * TODO по идеи величина вычисляемая, сейчас задается разработчиком*/
    val relationType: RelationType,
    /**Коллекция колонок входящих во внешний ключ */
    val fkCols: Set<${FkPair::class.java.simpleName}>,
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

    enum class GeneratedClasses {
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

        fun getPac(root: PackageName) = root.value + "." + interfaceGeneratorPackageName.value + "." + this
    }
}