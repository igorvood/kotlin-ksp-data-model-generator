create or replace view pdd_ierarhy_table as
with cc as (
    select distinct constraint_name, table_schema, table_name, reference_table from pdd_constrant_column

    where  constraint_type='f'

),
     ier as
         (select t.schema, t.name, cc.reference_table parent_id,cc.constraint_name from pdd_tables t
                                                                                            left join cc on (t.schema, t.name) = ((cc.table_schema, cc.table_name))
          where t.name not like 'tst_%' and t.name not like 'dual' and t.name not in ('databasechangelog', 'databasechangeloglock'))
select * from ier
/