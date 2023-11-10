DO $$

begin
INSERT INTO META_PROPERTY_FUNCTION (ID, DESCRIPTION)
select 'SERVICE_NAME', 'SERVICE_NAME' from dual;
end;
$$;
/
commit;
/