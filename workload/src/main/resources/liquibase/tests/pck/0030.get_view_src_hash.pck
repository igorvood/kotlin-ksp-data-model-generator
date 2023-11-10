create or replace function get_view_src_hash(in_view_owner varchar, in_view_name varchar)  returns varchar as
$$
declare
    l_string varchar(32760);
begin
    select t.text into l_string from pg_views t where (t.viewowner, t.viewname) = ((in_view_owner, in_view_name));
    return hashtext(l_string);
end;
$$ language plpgsql
/