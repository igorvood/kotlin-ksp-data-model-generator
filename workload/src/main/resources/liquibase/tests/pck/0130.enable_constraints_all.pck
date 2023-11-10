create or replace function enable_constraints_all() returns void as
$$
declare
    r record;
begin
    --         execute immediate 'alter session set ddl_lock_timeout = 30';
    for r in (
        select table_name
        from tst_disabled_constraints_table_cache c
    )
        loop
            perform enable_constraints(array [r.table_name]);
        end loop;
    return ;
end;
$$ language plpgsql