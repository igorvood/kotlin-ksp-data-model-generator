create or replace function tested_view(p_view_name varchar, p_object_source_list varchar[]) returns void as
$$
declare
    rt record;
    l_view_code_create varchar(1000);
begin
    select view_definition into l_view_code_create from information_schema.views where table_name = p_view_name;
--     execute immediate 'alter session set ddl_lock_timeout = 30';
    for rt in (
        select unnest as obj from unnest(p_object_source_list)
    )
    loop
      perform rename_db_object(array [rt.obj]);
    end loop;
    perform apply_rename_command('view', p_view_name, p_view_name||'_tested');
    insert into tst_renamed_db_obj_cache(owner, original_name, new_name, type_obj, view_code)
    VALUES ('owner', p_view_name, p_view_name||'_tested', 'view', l_view_code_create);

    perform exec_immediate('create or replace view '||p_view_name||' as '||l_view_code_create);

end;
$$ language plpgsql
/