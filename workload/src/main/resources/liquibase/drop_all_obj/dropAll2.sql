-- drop schema if exists db_configuration_manager CASCADE
-- /
DO $$
declare
    r record;

begin
  for r in
    with list as
      ((select 100 as prior, 'table' as tp, tablename as name,
        'drop table ' ||  tablename ||' CASCADE' cmd
        from pg_catalog.pg_tables where
        schemaname = 'db_configuration_manager' and
        tablename not in ('databasechangelog', 'databasechangeloglock')
        )
          union
        (select 10 as prior, 'view' as tp,  viewname as name,
         'drop view '  || viewname cmd
        from pg_catalog.pg_views where schemaname = 'db_configuration_manager')
          union
       (select 5, 'routine', routine_name,
               'drop '||routine_type||' '||routine_name  from information_schema.routines
        where specific_schema = 'db_configuration_manager'
       )
       union
       (
        select 110, 'type', n.nspname,
                'drop type '||t.typname||' cascade;' from pg_type t
          LEFT JOIN pg_catalog.pg_namespace n ON n.oid = t.typnamespace
        where  n.nspname = 'db_configuration_manager' and substr(t.typname,1,1)!='_'
            and t.typname not in ('databasechangelog', 'databasechangeloglock' )
        order by t.typname
       )
      )

      select tp.cmd  cmd from list tp
      order by prior

  loop
    execute r.cmd;
  end loop;
end;
$$;
/
CREATE SCHEMA IF NOT EXISTS db_configuration_manager
/
alter schema db_configuration_manager owner to db_configuration_manager_admin;
/
alter role db_configuration_manager_admin set search_path to db_configuration_manager
/

SET search_path TO db_configuration_manager
/