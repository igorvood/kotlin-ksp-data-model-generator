package ru.vood.dmgen.dao

import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.internal.decodeStringToJsonTree
import org.springframework.jdbc.core.JdbcOperations
import org.springframework.stereotype.Repository
import ru.vood.dmgen.dto.UkName
import ru.vood.dmgen.dao.dto.ChildEntityDto
import ru.vood.dmgen.dao.dto.PKJsonVal
import ru.vood.dmgen.dao.dto.PayLoadJsonVal
import ru.vood.dmgen.dao.dto.UKJsonVal
import ru.vood.dmgen.datamodel.intf.IContextOf
import ru.vood.dmgen.datamodel.intf.IEntityOrigin
import ru.vood.dmgen.dto.EntityName
import ru.vood.dmgen.meta.IndexesMetaDto
import ru.vood.dmgen.serial.ModelJsonSerializer

@Repository
class EntityDao(
    private val jdbcOperations: JdbcOperations,
    val serializer: ModelJsonSerializer,
) {

    fun saveFullAggregateNoParent(
        pkJson: PKJsonVal,
        entityName: EntityName,
        entityJson: PayLoadJsonVal
    ) {
        jdbcOperations.update(
            """insert into entity_context(pk, entity_type, payload) VALUES (?, ?, ?) """,
            pkJson.value, entityName.value, entityJson.value
        )
    }

    fun <TT> findEntityByUk(
        ktEntitySerializer: KSerializer<TT>,
        ukName: UkName,
        ukJson: UKJsonVal
    ): TT {
        val query = jdbcOperations.query(
            """
                        select e.payload
                            from entity_uk_context uc
                        join entity_context e on (uc.entity_type, uc.pk) = ((e.entity_type, e.pk))
                        where uc.entity_type_uk = ? and uc.uk = ?
                        """,
            { rs, _ ->
                serializer.modelJsonSerializer.decodeFromString(ktEntitySerializer, rs.getString(1))
            },
            ukName.value, ukJson.value
        )
        return if (query.size == 1)
            query[0]
        else error("Not found uk ${ukName.value} with value ${ukJson.value}")
    }

    @OptIn(InternalSerializationApi::class)
    fun <TT> findEntityAsJsonElementByUk(
        ktEntitySerializer: KSerializer<TT>,
        ukName: UkName,
        ukJson: UKJsonVal
    ): JsonElement {
        val query = jdbcOperations.query(
            """
                        select e.payload
                            from entity_uk_context uc
                        join entity_context e on (uc.entity_type, uc.pk) = ((e.entity_type, e.pk))
                        where uc.entity_type_uk = ? and uc.uk = ?
                        """,
            { rs, _ ->
                serializer.modelJsonSerializer.decodeStringToJsonTree(ktEntitySerializer, rs.getString(1))
            },
            ukName.value, ukJson.value
        )
        return if (query.size == 1)
            query[0]
        else error("Not found uk ${ukName.value} with value ${ukJson.value}")
    }

    fun <T : IEntityOrigin> findPKJsonVal(
        uk: IContextOf<T>,
        ukJson: UKJsonVal
    ): PKJsonVal {
        val queryJsons = jdbcOperations.query(
            """
                    select e.pk
                        from entity_uk_context uc
                    join entity_context e on (uc.entity_type, uc.pk) = ((e.entity_type, e.pk))
                    where uc.entity_type_uk = ? and uc.uk = ?
                    """,
            { rs, _ ->
                PKJsonVal(rs.getString(1))
            },
            uk.ukName.value, ukJson.value
        )

        return queryJsons[0]
    }

    fun findAllChildEntityDto(
        pkVal: PKJsonVal,
        indexesMetaDto: IndexesMetaDto
    ) = jdbcOperations.query(
        """with recursive temp1(entity_type, pk, parent_entity_type, parent_pk, payload, levell)
                       as (select T1.entity_type,
                                  T1.pk,
                                  T1.parent_entity_type,
                                  T1.parent_pk,
                                  T1.payload,
                                  1
                           from entity_context T1
                           where
                               T1.parent_pk = ?
                             and T1.parent_entity_type = ?
                           union all
                           select t2.entity_type,
                                  t2.pk,
                                  t2.parent_entity_type,
                                  t2.parent_pk,
                                  t2.payload,
                                  levell + 1
                           from entity_context t2
                                    inner join temp1
                                               on t2.parent_entity_type = temp1.entity_type and t2.parent_pk = temp1.pk)
    select entity_type, pk, parent_entity_type, parent_pk, payload, levell
    from temp1
    order by levell
                                        """,
        { rs, _ ->
            ChildEntityDto(entityType = EntityName(rs.getString(1)), payload = PayLoadJsonVal(rs.getString(5)))
        },
        pkVal.value, indexesMetaDto.pkEntityData.entity.value
    ).groupBy { it.entityType }


    fun saveChldrenEntity(
        pkChildrenJson: PKJsonVal,
        childrenEntityName: EntityName,
        childrenEntityJson: PayLoadJsonVal,
        pkDtoParentEntityName: EntityName,
        pkJsonParent: PKJsonVal
    ) {
        jdbcOperations.update(
            """insert into entity_context(pk, entity_type, payload, parent_entity_type, parent_pk) VALUES (?, ?, ?, ?, ?) """,
            pkChildrenJson.value,
            childrenEntityName.value,
            childrenEntityJson.value,
            pkDtoParentEntityName.value,
            pkJsonParent.value
        )
    }

}