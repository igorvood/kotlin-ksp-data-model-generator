create or replace view kafka_topic_by_service
as
with srv as (
  select DAGN.GRAPH_ID, sn.SERVICE_ID, sn.PROFILE_ID, sn.NODE_TYPE, DAGN.NODE_ID
  from DICT_SERVICE_NODE sn
    join DICT_ABSTRACT_GRAPH_NODE DAGN on DAGN.NODE_TYPE = sn.NODE_TYPE and DAGN.NODE_ID = sn.ID
),
from_srv as (
  select DAGN.SERVICE_ID, DAGN.PROFILE_ID, DA.END_NODE_ID topic, 'prd' derrection, da.PROPERTY_KEY, DA.kafka_direction, da.kafka_grp_prop
  from srv DAGN
    join DICT_ARROW DA on DAGN.GRAPH_ID = DA.GRAPH_ID and DAGN.NODE_TYPE = DA.BEG_NODE_TYPE and DAGN.NODE_ID = DA.BEG_NODE_ID
),
to_srv as (
  select DAGN.SERVICE_ID, DAGN.PROFILE_ID, DA.BEG_NODE_ID topic, 'cns' derrection,  da.PROPERTY_KEY, DA.kafka_direction, da.kafka_grp_prop
  from srv DAGN
    join DICT_ARROW DA on DAGN.GRAPH_ID = DA.GRAPH_ID and DAGN.NODE_TYPE = DA.end_NODE_TYPE and DAGN.NODE_ID = DA.end_NODE_ID
     ),
all_topic as (
  select SERVICE_ID, PROFILE_ID, topic, derrection, PROPERTY_KEY, kafka_direction, kafka_grp_prop
  from from_srv
  union all
  select SERVICE_ID, PROFILE_ID, topic, derrection, PROPERTY_KEY, kafka_direction, kafka_grp_prop
  from to_srv
)
select
    al.SERVICE_ID,
    al.PROFILE_ID,
    al.topic topic_id,
    tns.STAND,
    al.derrection,
    tns.TOPIC_NAME,
    kafka_grp_prop grp_prop,
    PROPERTY_KEY
from all_topic al
  join rep_TOPIC_NAME_BY_STAND tns on tns.TOPIC_ID=al.topic
--   left join DICT_TOPIC_NODE tn on (tn.ID, tn.PRD_TYPE) = ((al.topic, al.derrection))
--   left join DICT_TOPIC_NODE tn1 on (tn1.ID, tn1.CNS_TYPE) = ((al.topic, al.derrection))
-- where SERVICE_ID = 'mdm-enrichment' and PROFILE_ID = 'way4'
-- and STAND='IFT'
-- order by 3,4
/
comment on view kafka_topic_by_service is 'Топики для сервиса.'
/
comment on column kafka_topic_by_service.SERVICE_ID is 'Идентификатор сервиса.'
/
comment on column kafka_topic_by_service.PROFILE_ID is 'Идентификатор профиля.'
/
comment on column kafka_topic_by_service.topic_id is 'Идентификатор топика.'
/
comment on column kafka_topic_by_service.STAND is 'Идентификатор стенда.'
/
comment on column kafka_topic_by_service.derrection is 'Как используются топик, cns - для чтения, prd - для записи.'
/
comment on column kafka_topic_by_service.TOPIC_NAME is 'Имя топика.'
/
comment on column kafka_topic_by_service.PROPERTY_KEY is 'Часть ключа для настройки.'
/
comment on column kafka_topic_by_service.grp_prop is 'Группа свойств кафки.'
/

