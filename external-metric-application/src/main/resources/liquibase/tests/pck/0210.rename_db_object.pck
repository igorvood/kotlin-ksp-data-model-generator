create or replace function rename_db_object(p_object_list varchar[]) returns void as
$$
declare
    l_view_code varchar(30000);
    l_new_name varchar(30);
    l_cmd_create varchar(1000);
    rt record;
begin
    for rt in (
        with p as (select unnest as obj from unnest(p_object_list))
        select name ::varchar as object_name, type ::varchar as object_type
        from pdd_tables t
            join p on t.name=p.obj
    )
        loop
            if (upper(rt.object_type)='VIEW') then
                select view_definition into l_view_code from information_schema.views where table_name = rt.object_name;
            else
                l_view_code := null;
            end if;
            l_new_name := substr(rt.object_name, 1, 25) || '_RMN';
            perform apply_rename_command(rt.object_type, rt.object_name, l_new_name);
            l_cmd_create := 'create table ' || rt.object_name || ' as select * from ' || l_new_name;
--
            perform exec_immediate(l_cmd_create);
            insert into tst_renamed_db_obj_cache(owner, original_name, new_name, type_obj, view_code)
            VALUES ('owner', rt.object_name, l_new_name, rt.object_type, l_view_code);
        end loop;
    return ;
end;
$$ language plpgsql
/



