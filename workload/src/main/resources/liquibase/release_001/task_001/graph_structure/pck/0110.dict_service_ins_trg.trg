create or replace function  dict_service_ins_trg(GRAPH_ID_PAR varchar,service_id_PAR varchar, profile_id_par varchar, MAIN_CLASS_par varchar )
returns  varchar
language plpgsql
    as
 $$
declare
    cnt numeric;
BEGIN

    begin
        select 1 into cnt from DICT_SERVICE d where d.id = service_id_PAR;
    exception when NO_DATA_FOUND then
        insert into DICT_SERVICE(ID, MAIN_CLASS) VALUES  (service_id_PAR, MAIN_CLASS_par);
    end;

    if(cnt is null ) then
        insert into DICT_SERVICE(ID, MAIN_CLASS) VALUES  (service_id_PAR, MAIN_CLASS_par);
    end if;

    insert into DICT_ABSTRACT_GRAPH_NODE(GRAPH_ID, NODE_TYPE, NODE_ID) values (GRAPH_ID_PAR, 'flink_srv', service_id_PAR||'~'||profile_id_par);

    insert into DICT_SERVICE_NODE(SERVICE_ID, PROFILE_ID) values (service_id_PAR, profile_id_par);
    RETURN '';
END;
$$
/
