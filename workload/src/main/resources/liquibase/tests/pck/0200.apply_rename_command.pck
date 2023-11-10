create or replace function apply_rename_command(in_object_type varchar, in_current_name varchar, in_new_name varchar) returns void as
$$
declare
    l_cmd varchar(1000);
begin
    if (upper(in_object_type) not in ('VIEW', 'TABLE')) then
        raise 'Unsupported object type %' , in_object_type;
    end if;

    l_cmd :=
            case upper(in_object_type)
                when 'VIEW' then 'alter view ' || in_current_name || ' rename to ' || in_new_name
                when 'TABLE' then 'alter table ' || in_current_name || ' rename to ' || in_new_name
                end;
    perform exec_immediate(l_cmd);
    return ;
end;
$$ language plpgsql
/