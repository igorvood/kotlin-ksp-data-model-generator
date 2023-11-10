
    procedure restore_table
    is
    begin
        execute immediate 'alter session set ddl_lock_timeout = 30';
        for rt in (
            select t.object_name                                                            object_name
                 , listAgg(tc.column_name, ', ') within group (order by tc.table_name desc) list_columns
                 , back.object_name                                                         backup_name
            from all_objects t
                     join tst_backedup_table_cache c on c.original_name = t.object_name
                     left join all_objects back on back.object_name = c.backup_name
                     join all_tab_cols tc
                          on tc.owner = t.owner and tc.table_name = t.object_name and tc.virtual_column = 'NO'
            where t.owner = 'OKR'
            group by t.object_name, back.object_name
            )
            loop
                dbms_output.put_line('restore_table ->' || rt.object_name);
                if rt.backup_name is not null then
                    disable_constraints(get_constraints(rt.object_name));
                    execute immediate 'delete JP.' || rt.object_name;
                    execute immediate 'insert into jp.' || rt.object_name || '(' || rt.list_columns || ')
                             select ' || rt.list_columns || ' from jp.' || rt.backup_name;
                    execute immediate 'drop table jp.' || rt.backup_name || ' purge';
                end if;
                delete tst_backedup_table_cache c where c.original_name = rt.object_name;
            end loop;
        enable_constraints();
        commit;
    end;


/


    function get_constraints(in_table_name varchar) return cmn_str_tab
    is
        l_ret_c cmn_str_tab;
    begin
    with c as (select level lev, all_c.constraint_name
               from all_constraints all_c
               where all_c.constraint_type = 'R'
                 and all_c.owner = 'JP'
                   START WITH all_c.table_name = upper(in_table_name)
               CONNECT BY PRIOR all_c.constraint_name = all_c.r_constraint_name)
    select c.constraint_name bulk collect into l_ret_c
    from c
    where c.lev > 1;
    return l_ret_c;
    end;