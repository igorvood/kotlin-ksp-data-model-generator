create or replace function enable_constraints(p_table_list varchar[])returns void as
$$
declare
    r record;
begin
    for r in (select unnest as table_name
              from unnest(p_table_list))
        loop
            delete from tst_disabled_constraints_table_cache where table_name = r.table_name;
            perform modify_constraints(array [r.table_name], 'enable');
        end loop;

    return ;
end;
$$ language plpgsql
/