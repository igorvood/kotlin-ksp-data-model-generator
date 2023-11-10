package ru.vood.dmgen.dao

import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository
import ru.vood.dmgen.datamodel.metaEnum.entityDataMap
import ru.vood.dmgen.intf.EntityName
import ru.vood.dmgen.intf.IEntity
import ru.vood.dmgen.intf.newIntf.EntityData

@Repository
class EntityDao(
    private val jdbcTemplate: JdbcTemplate
) {

    final inline fun <reified T : IEntity<T>> saveEntity(entity: T) {
        val entityData = entityDataMap[EntityName(entity.javaClass.simpleName)]!! as EntityData<out IEntity<T>>




        TODO()

    }

}