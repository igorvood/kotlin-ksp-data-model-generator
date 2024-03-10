create or replace function exec_immediate(in_sql in text) returns void as
$$

begin
    --         EXEC SQL EXECUTE IMMEDIATE :in_sql;
    execute in_sql;
    return ;
    --     exception
--         when Others then
--             RAISE 'sqlCode=% , sqlErrM=%', sqlCode , sqlErrM || ', stmt=' || subStr(in_sql, 1, 3900);
end;
$$ language plpgsql
/
