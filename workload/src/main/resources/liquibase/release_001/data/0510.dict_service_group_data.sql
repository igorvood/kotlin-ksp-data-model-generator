insert into dict_service_group(group_id, service_id, profile_id)
with g as (
    select graph_id grp_id, dsn.service_id, dsn.profile_id
    from dict_abstract_graph_node gn
    join dict_service_node dsn on gn.node_type = dsn.node_type and gn.node_id = dsn.id
)
select grp_id, service_id, profile_id from g
/
insert into dict_service_group(group_id, service_id, profile_id)
select service_id||'_'||dict_service_node.profile_id, service_id, profile_id
from dict_service_node
/