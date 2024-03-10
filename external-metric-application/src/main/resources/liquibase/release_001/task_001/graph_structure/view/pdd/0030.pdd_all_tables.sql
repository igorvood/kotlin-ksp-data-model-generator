create or replace view pdd_all_tables as
select nsp.nspname,
       case pc.relkind
           when 'r' then 'table'
           when 'v' then 'view'
           else 'unsupported'
           end as relkind_full,
       pc.*
from pg_catalog.pg_class pc
         JOIN pg_catalog.pg_namespace nsp ON nsp.oid = pc.relnamespace
where nspname='db_configuration_manager' and pc.relkind in ('r', 'v')
/