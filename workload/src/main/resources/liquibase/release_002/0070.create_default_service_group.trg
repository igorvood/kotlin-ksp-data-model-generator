create or replace function  create_default_service_group()
    returns  varchar
    language plpgsql
as $$
BEGIN
    insert into dict_group(id, description)
    with all_srv as (
        select service_id||'_'||dict_service_node.profile_id group_id
        from dict_service_node
    )
    select a.group_id, a.group_id
    from all_srv a
             left join dict_group dsg on (a.group_id) = ((dsg.id))
    where dsg.id is null;

    insert into dict_service_group(group_id, service_id, profile_id)
    with all_srv as (
        select service_id||'_'||dict_service_node.profile_id group_id, service_id, profile_id
        from dict_service_node
    )
    select a.group_id, a.service_id, a.profile_id
    from all_srv a
        left join dict_service_group dsg on (a.group_id, a.service_id, a.profile_id) = ((dsg.group_id, dsg.service_id, dsg.profile_id))
    where dsg.group_id is null;

  RETURN '';
END;  $$
/
