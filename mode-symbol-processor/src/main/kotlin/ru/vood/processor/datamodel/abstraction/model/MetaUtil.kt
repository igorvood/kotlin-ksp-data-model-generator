package ru.vood.processor.datamodel.abstraction.model

import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.symbol.KSAnnotated
import com.google.devtools.ksp.symbol.KSClassDeclaration
import ru.vood.dmgen.annotation.ForeignKeyType
import ru.vood.dmgen.dto.RelationType
import ru.vood.processor.datamodel.abstraction.model.dto.ModelClassName
import ru.vood.processor.datamodel.abstraction.model.dto.UkDto

/**Собирает мету по колонкам */
fun metaEntityColumns(
    /**полный список сущностей*/
    entities: Map<ModelClassName, MetaEntity>,
    /**Сущность из которой вытаскивается мета по колонкам*/
    entity: ModelClassName,
    /**список колонок по которым надо вытащить мету*/
    cols: Array<String>,
    /**имя */
    currentClass: ModelClassName,
    foreignKey: ForeignKeyAnnotationDto,
    logger: KSPLogger,
): List<MetaEntityColumn> {
    val fromMetaEntity =
        entities[entity]
            ?: logger.kspError(
                "Для внешнего ключа ${foreignKey.name} сущности ${currentClass.value} не найдена сущность ${entity.value} указанная в ссылке",
                entities[currentClass]?.ksAnnotated
            )
    val fromCols = cols.map { fkField ->
        fromMetaEntity.fields.filter { field -> field.name.value == fkField }.firstOrNull()
            ?: logger.kspError(
                "Для внешнего ключа ${foreignKey.name} сущности ${currentClass.value} не найдено поле ${fkField}  у сущности  ${entity.value}",
                entities[currentClass]?.ksAnnotated
            )

    }
    return fromCols
}

tailrec fun collectMetaForeignKey(
    /**Список внешних ключей, рекурсивно по одному буду обрабатывать*/
    elementsAnnotatedWith: List<Pair<ForeignKeyAnnotationDto, ModelClassName>>,
    /**Все сущности */
    entities: Map<ModelClassName, MetaEntity>,
    /**Коллектор, сюда складывается разобранная информация о внешних ключах*/
    collector: Set<MetaForeignKeyTemporary> = setOf(),
    logger: KSPLogger,
): Set<MetaForeignKeyTemporary> {
    // есть еще что обрабатывать?
    return when (elementsAnnotatedWith.isEmpty()) {
        //нет, возвращаю то что обработал, выход из рекурсии
        true -> collector
        // еще есть что обрабатывать
        false -> {
            // вытаскиваю информацию о первом форене
            val head = elementsAnnotatedWith.first()
            val foreignKey = head.first
            val fromMetaEntityClassName = head.second
            val toMetaEntityClassName = ModelClassName(foreignKey.kClass.canonicalName)


            //вы таскиваю мету по колонкам сущности из которой форен идет
            val colsFromAnnotation = foreignKey.cols
                .map { a -> a.currentColName }.toTypedArray()

            val fromCols = metaEntityColumns(
                entities = entities,
                entity = fromMetaEntityClassName,
                cols = colsFromAnnotation,
                currentClass = fromMetaEntityClassName,
                foreignKey = foreignKey,
                logger = logger
            )
            //вы таскиваю мету по колонкам сущности в которою форен идет
            val toCols = metaEntityColumns(
                entities = entities,
                entity = toMetaEntityClassName,
                cols = foreignKey.cols.map { q -> q.outColName }.toTypedArray(),
                currentClass = fromMetaEntityClassName,
                foreignKey = foreignKey,
                logger = logger
            )

            fkAssert(fromCols, toCols, foreignKey)

            // поиск уникального ключа по которому указывает форен
            val toForeignMetaEntity = entities[toMetaEntityClassName]!!
            val uks = toForeignMetaEntity.uniqueKeysFields
                .filter { uksEntry ->

                    val ukCols = uksEntry.value.map { it.name }
                    val fkCols = toCols.map { it.name }
                    val b = ukCols.minus(fkCols).isEmpty() && fkCols.minus(ukCols).isEmpty()
                    b
                }
            val fromMetaEntity = entities[fromMetaEntityClassName]!!
            val ukDto = if (uks.size != 1) {
                logger.kspError(
                    """У сущности ${fromMetaEntityClassName.value} 
                    для внешнего ключа $foreignKey 
                    во внешней таблице должен быть строго один уникальный ключ
                    список подходящих ключей-> ${uks.map { it.key.name.value }}""",
                    fromMetaEntity.ksAnnotated
                )
            } else {

                val fromUksOneToOne = fromMetaEntity.uniqueKeysFields
                    .filter { entry ->
                        val ukCols = entry.value.map { mc -> mc.name.value }.sorted()
                        val fkCols = foreignKey.cols.map { acol -> acol.currentColName }.sorted()

                        ukCols.minus(fkCols).isEmpty() && fkCols.minus(ukCols).isEmpty()
                    }

                val fromUksManyToOne = fromMetaEntity.uniqueKeysFields
                    .filter { entry ->
                        val ukCols = entry.value.map { mc -> mc.name.value }.sorted()
                        val fkCols = foreignKey.cols.map { acol -> acol.currentColName }.sorted()

                        ukCols.minus(fkCols).isNotEmpty() && fkCols.minus(ukCols).isEmpty()
                    }

                val toUk = uks.entries.first().key



                UkToFrom(toUk, onlyOneOrNull(fromUksOneToOne) ?: onlyOneOrNull(fromUksManyToOne))
            }

            val fkCols = fromCols.withIndex()
                .map { from -> FkCol(from.value, toCols[from.index]) }
                .toSet()


            val element =
                MetaForeignKeyTemporary(
                    name = ForeignKeyName(value = foreignKey.name),
                    fromEntity = fromMetaEntity,
                    toEntity = toForeignMetaEntity,
                    fkCols = fkCols,
                    uk = ukDto.to,
                    ukFrom = ukDto.from,
                    foreignKeyType = foreignKey.foreignKeyType
                )

            val filter = collector.filter { it.name == element.name }
            val plus = if (filter.isNotEmpty()) {
                val dublicateFKNAmeInEntities =
                    filter.map { it.fromEntity.designClassShortName }.plus(element.fromEntity.designClassShortName)
                        .joinToString(",")
                logger.kspError(
                    "Найден дубль имени внешнего ключа ${foreignKey.name}, повторяется у сущностей ${dublicateFKNAmeInEntities}",
                    entities[fromMetaEntityClassName]?.ksAnnotated
                )

            } else {
                val element1 = element
                collector.plus(element1)
            }

            val elementsAnnotatedWith1 = elementsAnnotatedWith.drop(1)
            collectMetaForeignKey(elementsAnnotatedWith1, entities, plus, logger)
        }
    }
}

private fun onlyOneOrNull(fromUksOneToOne: Map<UkDto, List<MetaEntityColumn>>): UkDto? {
    val fromUkOneToOne = if (fromUksOneToOne.values.size == 1) {
        fromUksOneToOne.keys.first()
    } else null
    return fromUkOneToOne
}

data class UkToFrom(val to: UkDto, val from: UkDto?)

private fun fkAssert(
    fromCols: List<MetaEntityColumn>,
    toCols: List<MetaEntityColumn>,
    foreignKey: ForeignKeyAnnotationDto,
) {
    if (fromCols.size != toCols.size) {
        error("Не совпадают по кол-ву списки колонок currentTypeCols и outTypeCols во внешнем ключе $foreignKey")
    }

    fromCols.indices
        .forEach { idx ->
            val fromMetaEntityColumn = fromCols[idx]
            val toMetaEntityColumn = toCols[idx]
            if (fromMetaEntityColumn.type != toMetaEntityColumn.type) {
                error("Для внешнего ключа $foreignKey не совпадают типы колонок  в текущей(${fromMetaEntityColumn.name}, ${fromMetaEntityColumn.type}) и внешней(${toMetaEntityColumn.name}, ${toMetaEntityColumn.type}) таблице")
            }
        }
}

fun metaInformation(
    annotatedDataClasses: List<KSAnnotated>,
    logger: KSPLogger,
    nullableProbSetDefaultNull: Boolean,
): MetaInformation {
    //Вытаскиваю все классы аннотированые
    val elementsAnnotatedWithFlowEntity = annotatedDataClasses
        .filterIsInstance<KSClassDeclaration>()
        .map { MetaEntityCollector(it, logger).metaEntity }
//    Собираю сущности
    val entities = elementsAnnotatedWithFlowEntity.map { it.designClassFullClassName to it }.toMap()

    checkDublicateUk(entities, logger)
    checkDuplicateClassName(entities)

//    Собираю все внешние ключи
    val fks = entities.map { it.value }
        .flatMap { me ->
            me.foreignKeysAnnotations.map { fk -> fk to me.designClassFullClassName }
        }

    val collectMetaForeignKey = collectMetaForeignKey(elementsAnnotatedWith = fks, entities = entities, logger = logger)

    checkDublicateFKName(collectMetaForeignKey)

    val fieldsFk = fieldsFk(collectMetaForeignKey, logger)
    return MetaInformation(fieldsFk, entities, nullableProbSetDefaultNull, logger)
}

private fun checkDublicateFKName(collectMetaForeignKey: Set<MetaForeignKeyTemporary>) {
    val dublicatetdFkName =
        collectMetaForeignKey.map { it.name to it.fromEntity.designClassShortName }
            .groupBy { it.first }
            .filter { it.value.size > 1 }
            .map { "dublicate FK name ${it.key.value} in enties: ${it.value.map { q -> q.second }}" }
            .joinToString("\n")

    if (dublicatetdFkName.isNotEmpty()) {
        error(dublicatetdFkName)
    }
}

private fun checkDuplicateClassName(entities: Map<ModelClassName, MetaEntity>) {
    val groupBy =
        entities.map { it.key to it.value.designClassShortName }
            .groupBy { it.second }
            .filter { it.value.size > 1 }
            .flatMap { it.value.map { e -> e.first } }
            .distinct()
            .joinToString(",\n")
    if (groupBy.isNotEmpty()) {
        error("Class name without package must be unique. Duplicate names entity for next classes: \n$groupBy")
    }
}

private fun checkDublicateUk(entities: Map<ModelClassName, MetaEntity>, logger: KSPLogger) {
    val dublicatesUk = entities
        .flatMap { ent ->
            ent.value.uniqueKeysFields.entries
                .map { w -> w.key.name to ent.key }
        }
        .groupBy { it.first.value }
        .filter { it.value.size > 1 }
        .map { it -> entities[it.value[0].second]!!.ksAnnotated to "dublicate uk name ${it.key} for entities ${it.value.map { w -> w.second.value }}" }


    if (dublicatesUk.isNotEmpty()) {
        logger.kspError(dublicatesUk.map { it.second }.joinToString(","), dublicatesUk[0].first)
//        error(dublicatesUk)
    }
}

/**Вычисляет тип реляционной связи */
private fun fieldsFk(
    collectMetaForeignKeyTemporary: Set<MetaForeignKeyTemporary>,
    logger: KSPLogger,
): Set<MetaForeignKey> {
    val map1 = collectMetaForeignKeyTemporary
        .map { fkTemp ->
            val fromMetaEntity = fkTemp.fromEntity

//            Вытаскиваю колонки из форена
            val fromEntityFkCols = fkTemp.fkCols.map { qq -> qq.from.name }.toSet()
//            Вытаскиваю колонки из всех уникальных ключей
            val fromEntityUKsCols = fromMetaEntity.uniqueKeysFields.keys.map { aas -> aas.cols }

            // Держите штаны, пыжусь определить тип связи между сущностями
//            надо найти uk полностью совпадающий по колоночному составу с fk
            val uksOneTOne = fromEntityUKsCols
                .filter { ukCols -> ukCols.equalsAnyOrder(fromEntityFkCols) }

            val relationType =
                // такой UK найден, значит тип связи один к одному
                if (uksOneTOne.size == 1) {

                    // определяю опциональность связи
                    when (fkTemp.foreignKeyType) {
                        ForeignKeyType.OPTIONAL -> RelationType.ONE_TO_ONE_OPTIONAL
                        ForeignKeyType.MANDATORY -> RelationType.ONE_TO_ONE_MANDATORY
                    }

                } else {
                    // такой UK найден,
                    val fkCols = fkTemp.fkCols.map { it.from.name }
                    val uksOneToMany = fromEntityUKsCols
                        .filter { ukCols ->
                            val minus = fkCols.minus(ukCols)
                            val minus1 = ukCols.minus(fkCols)
                            val notEmpty = minus.isEmpty()
                            val empty = minus1.isNotEmpty()
                            notEmpty && empty
                        }
                    when {
                        uksOneToMany.isNotEmpty() -> RelationType.MANY_TO_ONE
                        fromMetaEntity.uniqueKeysFields.isEmpty() -> RelationType.MANY_TO_ONE
                        else -> {
                            val message =
                                "can not calculate relation type for Foreign Key ${fkTemp.name.value} on entity ${fkTemp.fromEntity.designClassShortName} ${fromMetaEntity.uniqueKeysFields.keys}"
                            logger.kspError(
                                message,
                                fkTemp.fromEntity.ksAnnotated
                            )
                            error(message)
                        }
                    }

                }
            runCatching {
                MetaForeignKey(
                    fkTemp,
                    relationType
                )
            }.getOrElse { err -> logger.kspError(err.message.orEmpty(), fromMetaEntity.ksAnnotated) }
        }.toSet()
    val minus = collectMetaForeignKeyTemporary.map { it.name }.minus(map1.map { it.name }.toSet())
    assert(minus.isEmpty()) { " Почему то не все обработаны $minus" }

    return map1

}

private inline fun <reified E> Collection<E>.equalsAnyOrder(set: Set<E>): Boolean {
    return this.minus(set).isEmpty() && set.minus(this).isEmpty()
}

