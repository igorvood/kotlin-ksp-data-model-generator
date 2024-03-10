create or replace view pdd_constrant
    as
SELECT nsp.nspname, rel.relname, con.*
FROM pg_catalog.pg_constraint con
  JOIN pg_catalog.pg_class rel ON rel.oid = con.conrelid
  JOIN pg_catalog.pg_namespace nsp ON nsp.oid = connamespace
/
