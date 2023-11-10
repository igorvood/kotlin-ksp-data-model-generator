create or replace view pdd_back_up as
with l as(
    select max(lvl) as lvl, name table_name  from pdd_tables_dependency
    group by name
),
constrain as (
    select table_schema, table_name, column_name
    from pdd_constrant_column
    where constraint_type = 'p'
),
tc as (
 select td.lvl, pt.relkind_full, pt.relname as table_name, pt.comment as table_comment, pc.column_name, pc.comment as column_comment,
        case when cons.column_name is null
            then 0
            else 1
        end is_in_pk,
        case when pc.is_generated ='NEVER'
            then 0
            else 1
        end is_generated
 from pdd_all_tables pt
    join pdd_columns pc on pt.relname = pc.table_name and pc.is_generated != 'ALWAYS'
    left join constrain cons on (cons.table_name, cons.column_name) = ((pt.relname, pc.column_name))
    join l td on td.table_name = pt.relname
)
select * from tc
where table_name not in ('databasechangeloglock', 'databasechangelog')
  and relkind_full = 'table'
order by lvl, table_name, column_name
/

