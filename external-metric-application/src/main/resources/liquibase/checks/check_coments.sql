DO $$
declare
    r record;
begin
  for r in (
    with
        table_adn_view as(
            SELECT pc.oid, nsp.nspname, pc.relname
            FROM pg_class pc
                     JOIN pg_catalog.pg_namespace nsp ON nsp.oid = relnamespace
            WHERE relkind in ('r', 'v')
              and nsp.nspname='db_configuration_manager'
              and pc.relname not in ('databasechangeloglock', 'databasechangelog', 'dual')
              and pc.relname not like 'pdd%'
        ),
        cc as
            (SELECT
                 v.nspname, v.relname, cols.column_name, (
                    SELECT  pg_catalog.col_description(c.oid, cols.ordinal_position::int)
                      FROM pg_catalog.pg_class c
                    WHERE c.relname = cols.table_name
                ) AS column_comment
             FROM
                 information_schema.columns cols
                     right join table_adn_view v on (v.nspname, v.relname) = ((cols.table_schema, cols.table_name))
            ),
        d as (
      (
          SELECT 'table '||pc.nspname||'.'||pc.relname||' has no coments' nm
          FROM table_adn_view pc
          WHERE obj_description(pc.oid) is null
      )
      UNION ALL
      (
          select 'column '||nspname||'.'||relname||'.'||column_name||' has no coments'
          from cc
          where cc.column_comment is null)
      )
    select STRING_AGG (d.nm, chr(10)) ::varchar lst
      from d
    limit  50
    )
  loop
    if(r.lst is not null ) then
    raise 'NO COMENTS: %' , r.lst;
    end if;
  end loop;
end;
$$;
/
SELECT * FROM information_schema.columns pc where table_name = 'all_placeholder'
;

SELECT obj_description(pc.oid), relkind, *
FROM pg_class pc
where relname = 'all_placeholder';


with
    table_adn_view as(
        SELECT pc.oid, nsp.nspname, pc.relname
        FROM pg_class pc
                 JOIN pg_catalog.pg_namespace nsp ON nsp.oid = relnamespace
        WHERE relkind in ('r', 'v')
          and nsp.nspname='db_configuration_manager'
          and (pc.relname not in ('databasechangeloglock', 'databasechangelog', 'dual')
--                 and pc.relname not like 'pdd%'
              )
    ),
cc as
(SELECT
    v.nspname, v.relname, cols.column_name, (
    SELECT
        pg_catalog.col_description(c.oid, cols.ordinal_position::int)
    FROM
        pg_catalog.pg_class c
    WHERE
--             c.oid = (SELECT ('"' || cols.table_name || '"')::regclass::oid)
       c.relname = cols.table_name
) AS column_comment
FROM
    information_schema.columns cols
right join table_adn_view v on (v.nspname, v.relname) = ((cols.table_schema, cols.table_name))
)
select 'column '||nspname||'.'||relname||'.'||column_name||' has no coments'
from cc
where cc.column_comment is null
;
;
--         cols.table_catalog    = 'your_database'
--   AND cols.table_name   = 'all_placeholder'
--   AND cols.table_schema = 'your_schema';