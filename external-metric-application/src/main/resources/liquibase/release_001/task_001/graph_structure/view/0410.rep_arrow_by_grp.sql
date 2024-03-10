create or replace view rep_arrow_by_grp as
with grp_srv as (
    select group_id, sn.id srv_id, sg.service_id, sg.profile_id
    from dict_service_group sg
      join dict_service_node sn on sn.service_id = sg.service_id and sn.profile_id = sg.profile_id
),
from_arrows_grp as (
    select group_id, BEG_NODE_TYPE, BEG_NODE_ID, END_NODE_TYPE, END_NODE_ID, kafka_grp_prop
    from DICT_ARROW arr
      join grp_srv dagn on arr.beg_node_id = dagn.srv_id
),
to_arrows_grp as (
    select group_id, BEG_NODE_TYPE, BEG_NODE_ID, END_NODE_TYPE, END_NODE_ID, kafka_grp_prop
    from DICT_ARROW arr
      join grp_srv dagn on arr.end_node_id = dagn.srv_id
),
arrows_grp as (
    select group_id, BEG_NODE_TYPE, BEG_NODE_ID, END_NODE_TYPE, END_NODE_ID, kafka_grp_prop
    from from_arrows_grp
    union
    select group_id, BEG_NODE_TYPE, BEG_NODE_ID, END_NODE_TYPE, END_NODE_ID, kafka_grp_prop
    from to_arrows_grp
)
select group_id, BEG_NODE_TYPE, BEG_NODE_ID, END_NODE_TYPE, END_NODE_ID, kafka_grp_prop
from arrows_grp
/