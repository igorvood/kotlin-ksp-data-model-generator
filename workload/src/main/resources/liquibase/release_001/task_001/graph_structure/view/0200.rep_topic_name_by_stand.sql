create or replace view rep_topic_name_by_stand
as
with t as (
select tn.id topic_id,
       coalesce(DTPBS.STAND_ID, st.ID) as STAND,
       coalesce(DTPBS.TOPIC_NAME, replace(tn.id, 'dev_', st.REPLACMENT_FOR_TOPIC_NAME))  topic_name,
       tn.retention,
       tn.cleanup_policy,
       coalesce(DTPBS.cnt_partition, st.cnt_partition) as cnt_partition,
       tow.id as topic_owner_id,
       tow.description_for_report as topic_owner_for_report,
       case when coalesce(DA_e.GRAPH_ID, DA_b.GRAPH_ID) is not null
                then 1
            else 0
        end is_used
FROM DICT_TOPIC_NODE tn
   cross join META_STAND st
   join dict_topic_owner tow on tn.topic_owner_id = tow.id
   left join DICT_TOPIC_PARAMS_BY_STAND DTPBS on tn.ID = DTPBS.NODE_ID and st.ID = DTPBS.STAND_ID
   left join DICT_ABSTRACT_GRAPH_NODE DAGN on DAGN.NODE_TYPE = tn.NODE_TYPE and DAGN.NODE_ID = tn.ID
   left join DICT_ARROW DA_b on DAGN.GRAPH_ID = DA_b.GRAPH_ID and DAGN.NODE_TYPE = DA_b.BEG_NODE_TYPE and DAGN.NODE_ID = DA_b.BEG_NODE_ID
   left join DICT_ARROW DA_e on DAGN.GRAPH_ID = DA_e.GRAPH_ID and DAGN.NODE_TYPE = DA_e.END_NODE_TYPE and DAGN.NODE_ID = DA_e.END_NODE_ID
)
select t.topic_id, t.topic_name, t.stand, t.is_used, t.retention, t.cleanup_policy, t.cnt_partition, t.topic_owner_id, t.topic_owner_for_report
from t
/
comment on view rep_topic_name_by_stand is 'Имена топиков в разрезе стендов.'
/
comment on column rep_topic_name_by_stand.topic_id is 'Идентификатор графа.'
/
comment on column rep_topic_name_by_stand.stand is 'Тип стенда.'
/
comment on column rep_topic_name_by_stand.topic_name is 'Имя топика.'
/
comment on column rep_topic_name_by_stand.retention is 'retention.'
/
comment on column rep_topic_name_by_stand.cleanup_policy is 'политика очистки.'
/
comment on column rep_topic_name_by_stand.cnt_partition is 'кол-во партиций.'
/
comment on column rep_topic_name_by_stand.is_used is 'Признак того что топик используется.'
/
comment on column rep_topic_name_by_stand.topic_owner_id is 'Идентификатор владельца топика.'
/
comment on column rep_topic_name_by_stand.topic_owner_for_report is 'Описание владельца, для вывода в отчеты.'
/
