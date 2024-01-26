package ru.vood.dmgen.metaJson

import kotlinx.serialization.Serializable
import ru.vood.dmgen.dto.EntityName
import ru.vood.dmgen.dto.SimpleColumnName
import ru.vood.dmgen.dto.TypeUk
import ru.vood.dmgen.dto.UkName
import ru.vood.dmgen.metaJson.value.UKRuntimeEntityClassName

/**Мета данные по уникальному ключу*/
@Serializable
data class UKEntityDataJson(
    /**Имя уникального ключа*/
    val ukName: UkName,
    /**Колонки входящие в ключ*/
    val columns: List<SimpleColumnName>,
    /**Класс уникального ключа*/
    val ukClass: UKRuntimeEntityClassName,
    /**Имя сушности, к которой относится уникальный ключ*/
    val entity: EntityName,
    /**Тип уникального ключа PK, UK*/
    val typeUk: TypeUk
)