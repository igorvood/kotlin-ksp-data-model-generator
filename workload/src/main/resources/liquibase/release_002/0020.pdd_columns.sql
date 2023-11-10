drop view pdd_columns cascade
/
create or replace view pdd_columns as
SELECT
    table_schema,
    table_name,
    column_name,
    d.description as comment,
    ordinal_position,
    data_type,
    udt_name,
    is_nullable,
    column_default,
    character_maximum_length,
    numeric_precision,
    numeric_precision_radix,
    datetime_precision,
    interval_precision,
    interval_type,
    is_generated,
    generation_expression,
    is_updatable
FROM information_schema.columns c
    join pg_class t on t.relname = c.table_name
    left join pg_catalog.pg_description d on d.objsubid = c.ordinal_position and d.objoid = t.oid
/