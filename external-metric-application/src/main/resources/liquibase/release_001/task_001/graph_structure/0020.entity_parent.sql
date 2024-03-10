create view entity_parent as
            with recursive temp1(entity_type, pk, parent_entity_type, parent_pk, payload, levell/*, path*/)
as (select T1.entity_type,
    T1.pk,
    T1.parent_entity_type,
    T1.parent_pk,
    T1.payload,
    1
--                               cAST(T1.pk AS VARCHAR(500)) as PATH
    from entity_context T1
    where T1.parent_pk is null
    and T1.parent_entity_type is null
    union all
    select t2.entity_type,
    t2.pk,
    t2.parent_entity_type,
    t2.parent_pk,
    t2.payload,
    levell + 1
--                               (temp1.PATH || '->' || (t2.pk AS VARCHAR(500)))
    from entity_context t2
    inner join temp1
    on t2.parent_entity_type = temp1.entity_type and t2.parent_pk = temp1.pk
--                         where ec.entity_type ='Deal' and ec. pk='{"id":"12"}'
)
select * from temp1
