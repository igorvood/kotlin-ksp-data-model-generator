create or replace view pdd_tables_dependency as
with recursive temp1(schema, name, parent_id, PATH, lvl) as(
    select i1.schema, i1.name, i1.parent_id, i1.name  as PATH, 1 lvl
    from pdd_ierarhy_table i1
    where i1.parent_id is null
    union
    select t2.schema, t2.name, t2.parent_id, temp1.path||'->'|| T2.name  as PATH, lvl + 1 lvl
    from pdd_ierarhy_table t2
             INNER JOIN temp1 ON( temp1.name= T2.parent_id)
)
select * from temp1

/