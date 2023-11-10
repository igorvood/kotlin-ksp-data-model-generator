insert into dict_group(id, description)
with g as (
    select distinct graph_id from dict_abstract_graph_node
)
select g.graph_id, g.graph_id from g
/
insert into dict_group(id, description)
select service_id||'_'||dict_service_node.profile_id, service_id||'_'||dict_service_node.profile_id
from dict_service_node
/
