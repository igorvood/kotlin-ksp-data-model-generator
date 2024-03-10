create or replace function get_clob_hash(
    p_table_name in varchar,
    p_clob_name in varchar,
    p_unique_key in varchar,
    p_key_values in varchar) returns varchar as
$$
declare
    C_DELIM constant varchar(1) := ',';
    l_result varchar(128);
    l_sql_text text;
    l_key varchar(128);
    l_val varchar(128);
    l_unique_key varchar(32767) := p_unique_key || C_DELIM;
    l_key_values varchar(32767) := p_key_values || C_DELIM;
    l_sql_where text := '';
    l_key_pos integer := 1;
    l_val_pos integer := 1;
begin
    -- Парсим уникальный ключ, формируем условие для селекта
    l_key_pos := strpos(l_unique_key, C_DELIM);
    if l_key_pos > 0 then
        l_val_pos := strpos(l_key_values, C_DELIM);
        while (l_key_pos > 0 and l_val_pos > 0)
            loop
                l_key := trim(substr(l_unique_key, 1, l_key_pos - 1));
                l_val := trim(substr(l_key_values, 1, l_val_pos - 1));
                if length(l_key) > 0 and length(l_val) > 0 then
                    if length(l_sql_where) > 0 then
                        l_sql_where := l_sql_where || ' and ';
                    end if;
                    l_sql_where := l_sql_where || l_key || ' = ' || '''' || l_val || '''';
                end if;
                l_unique_key := trim(substr(l_unique_key, l_key_pos + 1));
                l_key_pos := strpos(l_unique_key, C_DELIM);
                l_key_values := trim(substr(l_key_values, l_val_pos + 1));
                l_val_pos := strpos(l_key_values, C_DELIM);
            end loop;
    else
        l_sql_where := p_unique_key || ' = ' || '''' || p_key_values || '''';
    end if;
    -- Расчет хэша
    l_sql_text := 'select hashtext('||  p_clob_name ||') from ' || p_table_name || ' where ' ||
                  l_sql_where;
    --dbms_output.put_line(l_sql_text);
    execute immediate l_sql_text into l_result;
    return l_result;
end;
$$ language plpgsql
/