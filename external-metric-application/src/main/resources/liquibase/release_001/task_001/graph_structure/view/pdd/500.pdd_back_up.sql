create or replace view pdd_back_up as
with l as(
    select max(lvl) lvl, name table_name  from pdd_tables_dependency
    group by name
),
tc as (
    select td.lvl, pt.relkind_full, pt.relname as table_name, pc.column_name
    from pdd_all_tables pt
        join pdd_columns pc on pt.relname = pc.table_name and pc.is_generated != 'ALWAYS'
        join l td on td.table_name = pt.relname
)
select * from tc
where table_name not in ('databasechangeloglock', 'databasechangelog')
  and relkind_full = 'table'
order by lvl, table_name, column_name
/

