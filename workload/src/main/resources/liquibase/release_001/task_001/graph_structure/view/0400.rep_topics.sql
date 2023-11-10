create or replace view rep_topics as
with g as (
  select dagn.graph_id,  gg.group_id, dsn.id srv_id, dsn.service_id, dsn.profile_id, dagn.node_type, dsn.report_description srv_report_description
  from dict_service_group gg
    join dict_service_node dsn on dsn.service_id = gg.service_id and dsn.profile_id = gg.profile_id
    join dict_abstract_graph_node dagn on dagn.node_type = dsn.node_type and dagn.node_id = dsn.id
),
to_t as(
  select da_beg.end_node_id topic_id,
         g.graph_id,
         g.group_id,
         g.srv_id,
         g.service_id,
         g.profile_id,
         g.node_type,
         g.srv_report_description,
         'WRITE' as dirrection,
         da_beg.common_name as cn
  from g
    join dict_arrow da_beg on g.graph_id = da_beg.graph_id and g.node_type = da_beg.beg_node_type and g.srv_id = da_beg.beg_node_id
),
from_t as(
  select da_end.beg_node_id topic_name,
         g.graph_id,
         g.group_id,
         g.srv_id,
         g.service_id,
         g.profile_id,
         g.node_type,
         g.srv_report_description,
         'READ' as dirrection,
         da_end.common_name as cn
  from g
    join dict_arrow da_end on g.graph_id = da_end.graph_id and g.node_type = da_end.end_node_type and g.srv_id = da_end.end_node_id
),
with_all_topic as(
  select topic_id, graph_id,group_id,srv_id,service_id,profile_id,srv_report_description,dirrection,cn
    from to_t
  union
  select topic_name, graph_id, group_id, srv_id, service_id, profile_id, srv_report_description, dirrection, cn
    from from_t
),
with_all_topic_prop as(
  select r.stand,
         r.topic_name,
         t.graph_id,
         t.group_id,
         t.srv_id,
         t.service_id,
         t.profile_id,
         t.srv_report_description,
         t.dirrection,
         t.cn,
         r.cleanup_policy,
         r.retention,
         r.cnt_partition,
         r.topic_owner_for_report
  from with_all_topic t
    join rep_topic_name_by_stand r on t.topic_id = r.topic_id
)
select stand, topic_name, graph_id, group_id, srv_id, service_id, profile_id, srv_report_description, dirrection, cn, cleanup_policy, retention, cnt_partition, topic_owner_for_report
from with_all_topic_prop
/