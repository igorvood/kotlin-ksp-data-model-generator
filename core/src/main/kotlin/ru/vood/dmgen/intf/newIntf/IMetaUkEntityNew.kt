package ru.vood.dmgen.intf.newIntf

import kotlinx.serialization.KSerializer
import ru.vood.dmgen.annotation.UkName
import ru.vood.dmgen.intf.EntityName
import ru.vood.dmgen.intf.IContextOf
import ru.vood.dmgen.intf.IEntityOrigin
import ru.vood.dmgen.intf.SimpleColumnName
import kotlin.reflect.KClass


/**Мета данные по уникальному ключу*/
data class UKEntityData<T : IEntityOrigin>(
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

enum class TypeUk {
    PK, UK
}