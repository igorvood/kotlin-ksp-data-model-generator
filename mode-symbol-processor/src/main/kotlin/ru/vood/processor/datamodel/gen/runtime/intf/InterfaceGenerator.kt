package ru.vood.processor.datamodel.gen.runtime.intf

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.KSPLogger
import ru.vood.dmgen.annotation.FlowEntityType
import ru.vood.dmgen.dto.RelationType
import ru.vood.dmgen.dto.SimpleColumnName
import ru.vood.dmgen.dto.SimpleColumnType
import ru.vood.dmgen.dto.TypeUk
import ru.vood.model.generator.ksp.common.CommonClassNames.subPackageAbstractDataDictionaryGenerator
import ru.vood.model.generator.ksp.common.dto.PackageName
import ru.vood.processor.datamodel.abstraction.model.MetaInformation
import ru.vood.processor.datamodel.gen.*

import ru.vood.processor.datamodel.gen.meta.ColumnEntityMapGenerator.Companion.fullColumnEnumName
import java.time.LocalDateTime
import java.util.*
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
import ${GeneratedClasses.UniqueKeyEnum.getPac(rootPackage)}
import ${SimpleColumnName::class.java.canonicalName}
import ${SimpleColumnType::class.java.canonicalName}
import ${EnumMap::class.java.canonicalName}
import ${FlowEntityType::class.java.canonicalName}
import ${RelationType::class.java.canonicalName}.*
import kotlin.reflect.KClass
import ${RelationType::class.java.canonicalName}
import ${TypeUk::class.java.canonicalName}
import ${GeneratedClasses.EntityEnum.getPac(rootPackage)}
import ${GeneratedClasses.FkNameEnum.getPac(rootPackage)}
import ${GeneratedClasses.FullColumnNameEnum.getPac(rootPackage)}



@${Generated::class.java.simpleName}("${this.javaClass.canonicalName}", date = "${LocalDateTime.now()}")
/**Сериализуемая сущность*/
interface ${GeneratedClasses.SerializableEntity} {
    /**Мета информаци по сущности*/
    val designEntityName: ${GeneratedClasses.EntityEnum}
}

@${Generated::class.java.simpleName}("${this.javaClass.canonicalName}", date = "${LocalDateTime.now()}")
/**Оригинал сущности, только поля принадлежащие ей*/
interface ${GeneratedClasses.IEntityOrigin} : ${GeneratedClasses.SerializableEntity}

@${Generated::class.java.simpleName}("${this.javaClass.canonicalName}", date = "${LocalDateTime.now()}")
interface ${GeneratedClasses.IEntityDetail}<T : ${GeneratedClasses.IEntityOrigin}> : ${GeneratedClasses.IEntityOrigin} {

    /**Оригинал сущности, только поля принадлежащие ей*/
    val origin: T
    
    fun syntheticField(entityName: ${GeneratedClasses.EntityEnum}): Set<${GeneratedClasses.IEntityDetail}<out ${GeneratedClasses.IEntityOrigin}>> {
       return when(FkNameEnum.getFk(entityName, origin.designEntityName).relationType){
            RelationType.MANY_TO_ONE -> syntheticFieldSet(entityName)
            RelationType.ONE_TO_ONE_MANDATORY -> setOf( syntheticFieldMandatory(entityName))
            RelationType.ONE_TO_ONE_OPTIONAL -> syntheticFieldOptional(entityName)?.let { setOf(it) }?: setOf()
        }
    }
    
    /**Для опциональных сущностей. По имени сущности имеющей fk на текущую возвращает ее экземляр.*/
    fun syntheticFieldOptional(entityName:  ${GeneratedClasses.EntityEnum}): ${GeneratedClasses.IEntityDetail}<out ${GeneratedClasses.IEntityOrigin}>?
    /**Для обязательных сущностей. По имени сущности имеющей fk на текущую возвращает ее экземляр.*/
    fun syntheticFieldMandatory(entityName:  ${GeneratedClasses.EntityEnum}): ${GeneratedClasses.IEntityDetail}<out ${GeneratedClasses.IEntityOrigin}>
    /**Для сущностей имеющих связь, много к одному к текущей. По имени сущности имеющей fk на текущую возвращает ее экземляр.*/
    fun syntheticFieldSet(entityName: ${GeneratedClasses.EntityEnum}): Set<${GeneratedClasses.IEntityDetail}<out ${GeneratedClasses.IEntityOrigin}>>


}

@${Generated::class.java.simpleName}("${this.javaClass.canonicalName}", date = "${LocalDateTime.now()}")
interface ${GeneratedClasses.IContextOf}<T : ${GeneratedClasses.IEntityOrigin}> : ${GeneratedClasses.SerializableEntity} {

    /**Мета информация по уникальному ключу*/
    val ukName: ${GeneratedClasses.UniqueKeyEnum}

    /**Сериализатор оригинальной сущности*/
    val ktEntitySerializer: KSerializer<T>

    /**Сериализатор детальной(аггрегированной) сущности*/
    val ktSyntheticEntitySerializer: KSerializer<out ${GeneratedClasses.IEntityDetail}<out T>>

}

@${Generated::class.java.simpleName}("${this.javaClass.canonicalName}", date = "${LocalDateTime.now()}")
/**Мета данные по реквизиту сущности*/
sealed interface ${GeneratedClasses.ColumnEntityData}<T> {
    /**имя сущности*/
    val entity:  ${GeneratedClasses.EntityEnum}

    /**имя колонки*/
    val simpleColumnName: ${SimpleColumnName::class.java.simpleName}

    /**признак опциональности колонки*/
    val isOptional: Boolean

    /**коментарий колонки*/
    val comment: ${String::class.java.simpleName}
    /**ф-ция экстрактор значения колонки*/
}

@${Generated::class.java.simpleName}("${this.javaClass.canonicalName}", date = "${LocalDateTime.now()}")
data class ${GeneratedClasses.SimpleColumnEntityData}<T : ${GeneratedClasses.IEntityOrigin}>(
    override val entity:  ${GeneratedClasses.EntityEnum},
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


@${Generated::class.java.simpleName}("${this.javaClass.canonicalName}", date = "${LocalDateTime.now()}")
data class ${GeneratedClasses.SyntheticColumnEntityData}<T>(
    override val entity:  ${GeneratedClasses.EntityEnum},
    /**имя колонки*/
    override val simpleColumnName: ${SimpleColumnName::class.java.simpleName},
    /**признак опциональности колонки*/
    override val isOptional: Boolean,
    /**коментарий колонки*/
    override val comment: String,
    /**ф-ция экстрактор значения колонки*/
    val iColExtractFunction: ${GeneratedClasses.ISyntheticColExtractFunction}<T, *>,
    val outEntity:  ${GeneratedClasses.EntityEnum}
) : ${GeneratedClasses.ColumnEntityData}<T>

@${Generated::class.java.simpleName}("${this.javaClass.canonicalName}", date = "${LocalDateTime.now()}")
data class ${GeneratedClasses.SealedSyntheticColumnEntityData}<T>(
    override val entity:  ${GeneratedClasses.EntityEnum},
    /**имя колонки*/
    override val simpleColumnName: ${SimpleColumnName::class.java.simpleName},
    /**признак опциональности колонки*/
    override val isOptional: Boolean,
    /**коментарий колонки*/
    override val comment: String,
    /**ф-ция экстрактор значения колонки*/
//    override val iColExtractFunction: ${GeneratedClasses.ISyntheticColExtractFunction}<T, *>,
    val outEntities: Set< ${GeneratedClasses.EntityEnum}>
) : ${GeneratedClasses.ColumnEntityData}<T>

@${Generated::class.java.simpleName}("${this.javaClass.canonicalName}", date = "${LocalDateTime.now()}")
sealed interface ${GeneratedClasses.IColExtractFunction}<in T, out OUT> {
    val extractFieldValue: (entity: T) -> OUT
}

@${Generated::class.java.simpleName}("${this.javaClass.canonicalName}", date = "${LocalDateTime.now()}")
sealed interface ${GeneratedClasses.ISyntheticColExtractFunction}<in T, out OUT> : ${GeneratedClasses.IColExtractFunction}<T, OUT>

@JvmInline
@${Generated::class.java.simpleName}("${this.javaClass.canonicalName}", date = "${LocalDateTime.now()}")
value class ${GeneratedClasses.SimpleColExtractFunction}<T : IEntityOrigin, OUT>(
    override val extractFieldValue: (entity: T) -> OUT
) : ${GeneratedClasses.IColExtractFunction}<T, OUT>

@JvmInline
@${Generated::class.java.simpleName}("${this.javaClass.canonicalName}", date = "${LocalDateTime.now()}")
value class ${GeneratedClasses.Synthetic}<
        ORIG_IN : ${GeneratedClasses.IEntityOrigin},
        SINTH_IN : ${GeneratedClasses.IEntityDetail}<out ORIG_IN>,
        OUT : ${GeneratedClasses.IEntityOrigin}>(
    override val extractFieldValue: (entity: SINTH_IN) -> Set<${GeneratedClasses.IEntityDetail}<OUT>>
) : ${GeneratedClasses.ISyntheticColExtractFunction}<SINTH_IN, Set<${GeneratedClasses.IEntityDetail}<OUT>>>

@JvmInline
@${Generated::class.java.simpleName}("${this.javaClass.canonicalName}", date = "${LocalDateTime.now()}")
value class ${GeneratedClasses.SyntheticSet}<
        ORIG_IN : ${GeneratedClasses.IEntityOrigin},
        SINTH_IN : ${GeneratedClasses.IEntityDetail}<out ORIG_IN>,
        OUT : ${GeneratedClasses.IEntityOrigin}>(
    override val extractFieldValue: (entity: SINTH_IN) -> Set<${GeneratedClasses.IEntityDetail}<OUT>>
) : ${GeneratedClasses.ISyntheticColExtractFunction}<SINTH_IN, Set<${GeneratedClasses.IEntityDetail}<OUT>>>


@${Generated::class.java.simpleName}("${this.javaClass.canonicalName}", date = "${LocalDateTime.now()}")
/**Мета данные по сущности*/
sealed interface ${GeneratedClasses.IEntityData} {
    /**интрефейс описывающий структуру сущности */
    val designClass: KClass<out Any>

    /**класс описывающий сущность*/
    val runtimeClass: KClass<out ${GeneratedClasses.IEntityOrigin}>

    /**синтетический класс описывающий сущность, включает в себя все сущности, которорые имею форен на текущую*/
    val runtimeSyntheticClass: KClass<out ${GeneratedClasses.IEntityOrigin}>

    /**сериализатор оригинальной сущности*/
    val serializer: KSerializer<out ${GeneratedClasses.IEntityOrigin}>

    /**сериализатор синтетической сущности*/
    val serializerSynthetic: KSerializer<out ${GeneratedClasses.IEntityDetail}<out ${GeneratedClasses.IEntityOrigin}>>

    /**Имя сущности*/
    val entityName:  ${GeneratedClasses.EntityEnum}

    /**коментарий сущности*/
    val comment: String

    /**тип сущности*/
    val entityType: ${FlowEntityType::class.java.simpleName}
}

@${Generated::class.java.simpleName}("${this.javaClass.canonicalName}", date = "${LocalDateTime.now()}")
/**Мета данные по сущности*/
data class ${GeneratedClasses.EntityData}(
    /**интрефейс описывающий структуру сущности */
    override val designClass: KClass<out Any>,
    /**класс описывающий сущность*/
    override val runtimeClass: KClass<out ${GeneratedClasses.IEntityOrigin}>,
    /**синтетический класс описывающий сущность, включает в себя все сущности, которорые имею форен на текущую*/
    override val runtimeSyntheticClass: KClass<out ${GeneratedClasses.IEntityOrigin}>,
    /**сериализатор оригинальной сущности*/
    override val serializer: KSerializer<out ${GeneratedClasses.IEntityOrigin}>,
    /**сериализатор синтетической сущности*/
    override val serializerSynthetic: KSerializer<out ${GeneratedClasses.IEntityDetail}<out ${GeneratedClasses.IEntityOrigin}>>,
    /**Имя сущности*/
    override val entityName:  ${GeneratedClasses.EntityEnum},
    /**коментарий сущности*/
    override val comment: String,
    /**тип сущности*/
    override val entityType: ${FlowEntityType::class.java.simpleName} 
) : ${GeneratedClasses.IEntityData}

@${Generated::class.java.simpleName}("${this.javaClass.canonicalName}", date = "${LocalDateTime.now()}")
data class ${GeneratedClasses.SealedEntityData}(
    /**интрефейс описывающий структуру сущности */
    override val designClass: KClass<out Any>,
    /**класс описывающий сущность*/
    override val runtimeClass: KClass<out ${GeneratedClasses.IEntityOrigin}>,
    /**синтетический класс описывающий сущность, включает в себя все сущности, которорые имею форен на текущую*/
    override val runtimeSyntheticClass: KClass<out ${GeneratedClasses.IEntityOrigin}>,
    /**сериализатор оригинальной сущности*/
    override val serializer: KSerializer<out ${GeneratedClasses.IEntityOrigin}>,
    /**сериализатор синтетической сущности*/
    override val serializerSynthetic: KSerializer<out ${GeneratedClasses.IEntityDetail}<out ${GeneratedClasses.IEntityOrigin}>>,
    /**Имя сущности*/
    override val entityName:  ${GeneratedClasses.EntityEnum},
    /**коментарий сущности*/
    override val comment: String,
    /**тип сущности*/
    override val entityType: ${FlowEntityType::class.java.simpleName},
    /**перечень наследников*/
    val children: Set< ${GeneratedClasses.EntityEnum}>
) : ${GeneratedClasses.IEntityData}

@${Generated::class.java.simpleName}("${this.javaClass.canonicalName}", date = "${LocalDateTime.now()}")
/**Мета данные по внегнему ключу*/
data class ${GeneratedClasses.FKMetaData}<T : ${GeneratedClasses.IEntityOrigin}>(
    /**Сущность из которой идет внешний ключ*/
    val fromEntity:  ${GeneratedClasses.EntityEnum},
    /**Сущность к которой идет внешний ключ*/
    val toEntity:  ${GeneratedClasses.EntityEnum},
    /**Имя уикалоного индекса из toEntity на которой нацелен внешний ключ*/
    val uk: ${GeneratedClasses.UniqueKeyEnum},
    /**Тип связи
     * TODO по идеи величина вычисляемая, сейчас задается разработчиком*/
    val relationType: ${RelationType::class.java.simpleName},
    /**Коллекция колонок входящих во внешний ключ */
    val fkCols: Set<${GeneratedClasses.FkPair}>,
    /**Ф-ция вытаскивающая из fromEntity, экземпляр уникального ключа toEntity -> uk.
     * хорошо подходит для поиска  */
    val сontextExtractor: (T) -> ${GeneratedClasses.IContextOf}<out ${GeneratedClasses.IEntityOrigin}>
)

@${Generated::class.java.simpleName}("${this.javaClass.canonicalName}", date = "${LocalDateTime.now()}")
/**Мета данные по уникальному ключу*/
data class ${GeneratedClasses.UKEntityData}<T : IEntityOrigin>(
    /**Имя уникального ключа*/
    val ukName: ${GeneratedClasses.UniqueKeyEnum},
    /**Колонки входящие в ключ*/
    val columns: List<${SimpleColumnName::class.java.simpleName}>,
    /**Сериализатор уникального ключа*/
    val serializer: KSerializer<out ${GeneratedClasses.IContextOf}<out T>>,
    /**Класс уникального ключа*/
    val ukClass: KClass<out ${GeneratedClasses.IContextOf}<out T>>,
    /**Имя сушности, к которой относится уникальный ключ*/
    val entity:  ${GeneratedClasses.EntityEnum},
    /**Экстрактор уникального ключа из ДТО*/
    val extractContext: (T) -> ${GeneratedClasses.IContextOf}<T>,
    /**Тип уникального ключа PK, UK*/
    val typeUk: ${TypeUk::class.java.simpleName}
//    override val contextOfClass: KClass<${GeneratedClasses.IContextOf}<T>>
)

@${Generated::class.java.simpleName}("${this.javaClass.canonicalName}", date = "${LocalDateTime.now()}")
data class ${GeneratedClasses.FkPair}(
    val from: $fullColumnEnumName,
    val to: $fullColumnEnumName
)

@${Generated::class.java.simpleName}("${this.javaClass.canonicalName}", date = "${LocalDateTime.now()}")
data class ${GeneratedClasses.IndexesMetaDto}(
    /**Мета по первичному ключу*/
    val pkEntityData: ${GeneratedClasses.UKEntityData}<out ${GeneratedClasses.IEntityOrigin}>,
    /**мета по уникальным индексам, исключая первичный ключ*/
    val ukOnlySet: Set<${GeneratedClasses.UKEntityData}<out ${GeneratedClasses.IEntityOrigin}>>
) {
    /**мета по уникальным индексам включая первичный ключ*/
    val ukAndPkMap = ${EnumMap::class.java.simpleName}(ukOnlySet.plus(pkEntityData).associateBy { it.ukName })

}



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

    enum class GeneratedClasses(val subPackageName: PackageName) {
        @Deprecated("")
        SerializableEntity(interfaceGeneratorPackageName),
        IndexesMetaDto(interfaceGeneratorPackageName),

        @Deprecated("")
        IEntityOrigin(interfaceGeneratorPackageName),
        IEntityDetail(interfaceGeneratorPackageName),
        IContextOf(interfaceGeneratorPackageName),
        ColumnEntityData(interfaceGeneratorPackageName),
        SimpleColumnEntityData(interfaceGeneratorPackageName),
        SyntheticColumnEntityData(interfaceGeneratorPackageName),
        SealedSyntheticColumnEntityData(interfaceGeneratorPackageName),
        IColExtractFunction(interfaceGeneratorPackageName),
        ISyntheticColExtractFunction(interfaceGeneratorPackageName),
        SimpleColExtractFunction(interfaceGeneratorPackageName),
        Synthetic(interfaceGeneratorPackageName),
        SyntheticSet(interfaceGeneratorPackageName),
        IEntityData(interfaceGeneratorPackageName),
        EntityData(interfaceGeneratorPackageName),
        FKMetaData(interfaceGeneratorPackageName),
        SealedEntityData(interfaceGeneratorPackageName),
        UKEntityData(interfaceGeneratorPackageName),
        FkPair(interfaceGeneratorPackageName),
        EntityEnum(subPackageAbstractDataDictionaryGenerator),
        FkNameEnum(subPackageAbstractDataDictionaryGenerator),
        FullColumnNameEnum(subPackageAbstractDataDictionaryGenerator),
        UniqueKeyEnum(subPackageAbstractDataDictionaryGenerator)
        ;

        fun getPac(root: PackageName) = root.value + "." + subPackageName.value + "." + this
    }
}