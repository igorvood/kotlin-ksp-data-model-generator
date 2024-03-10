create or replace function disable_constraints(p_table_list varchar[]) returns void as
$$
declare
    r record;
begin
    for r in (select unnest as table_name
              from unnest(p_table_list))
    loop
        insert into tst_disabled_constraints_table_cache(table_name) values (r.table_name);
        perform modify_constraints(array [r.table_name], 'disable');
    end loop;

  return ;
end;
$$ language plpgsql
/
