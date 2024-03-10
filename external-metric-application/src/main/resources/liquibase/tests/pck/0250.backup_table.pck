create or replace function backup_table(p_table_list varchar[]) returns void as
$$
declare
    l_new_name varchar(60);
    l_cmd_create varchar(1000);
    rt record;
begin
  for rt in (
    with p as (select unnest as obj from unnest(p_table_list))
      select t.name object_name, t.type object_type
        from pdd_tables t
                     join p on p.obj = t.name
            where t.type = 'table'
  )
  loop
    l_new_name := substr(rt.object_name, 1, 25) || '_BKP$';
    l_cmd_create := 'create table ' || l_new_name || ' as select * from ' || rt.object_name;
    perform exec_immediate(l_cmd_create);

    insert into tst_backedup_table_cache(ORIGINAL_NAME, BACKUP_NAME)
        select rt.object_name, l_new_name
        from DUAL;
  end loop;
end;
$$ language plpgsql
/
