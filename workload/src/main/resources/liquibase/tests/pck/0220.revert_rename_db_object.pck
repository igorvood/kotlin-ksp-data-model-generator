create or replace function revert_rename_db_object() returns void as
$$
declare
    rt record;
begin
    for rt in (
        select original_name, new_name, type_obj
        from tst_renamed_db_obj_cache
    )
    loop
      BEGIN
        perform exec_immediate('drop '||rt.type_obj||' if exists '||rt.original_name||' cascade');
      EXCEPTION WHEN OTHERS -- аналог catch
        THEN
          perform exec_immediate('drop table if exists '||rt.original_name||' cascade');
      END;

      perform apply_rename_command(rt.type_obj, rt.new_name, rt.original_name);
    end loop;
    delete from tst_renamed_db_obj_cache;
    return ;
end;
$$ language plpgsql
/