create or replace view service_topic_name_by_stand
as
select
    da.GRAPH_ID,
    coalesce(serv_beg.SERVICE_ID, serv_end.SERVICE_ID) service_id,
    coalesce(serv_beg.PROFILE_ID, serv_end.PROFILE_ID) profile_id,
    TNBS.STAND stand,
    da.PROPERTY_KEY prop_id,
    TNBS.TOPIC_NAME prop_value
from DICT_ARROW da
    join DICT_ABSTRACT_GRAPH_NODE DAGN_beg on DAGN_beg.GRAPH_ID = da.GRAPH_ID and DAGN_beg.NODE_TYPE = da.BEG_NODE_TYPE and DAGN_beg.NODE_ID = da.BEG_NODE_ID
    join DICT_ABSTRACT_GRAPH_NODE DAGN_end on DAGN_end.GRAPH_ID = da.GRAPH_ID and DAGN_end.NODE_TYPE = da.END_NODE_TYPE and DAGN_end.NODE_ID = da.END_NODE_ID
    left join DICT_SERVICE_NODE serv_beg on DAGN_beg.NODE_TYPE = serv_beg.NODE_TYPE and DAGN_beg.NODE_ID = serv_beg.ID
    left join DICT_SERVICE_NODE serv_end on DAGN_end.NODE_TYPE = serv_end.NODE_TYPE and DAGN_end.NODE_ID = serv_end.ID
    left join DICT_TOPIC_NODE DTN_beg on DAGN_beg.NODE_TYPE = DTN_beg.NODE_TYPE and DAGN_beg.NODE_ID = DTN_beg.ID
    left join DICT_TOPIC_NODE DTN_end on DAGN_end.NODE_TYPE = DTN_end.NODE_TYPE and DAGN_end.NODE_ID = DTN_end.ID
    join rep_TOPIC_NAME_BY_STAND TNBS on TNBS.TOPIC_ID = coalesce(DTN_beg.ID, DTN_end.ID)
/
comment on view service_topic_name_by_stand is 'Имена топиков в разрезе стендов и сервисов.'
/
comment on column service_topic_name_by_stand.service_id is 'Идентификатор сервиса.'
/
comment on column service_topic_name_by_stand.GRAPH_ID is 'Идентификатор графа.'
/
comment on column service_topic_name_by_stand.profile_id is 'Идентификатор профиля.'
/
comment on column service_topic_name_by_stand.stand is 'Идентификатор стенда.'
/
comment on column service_topic_name_by_stand.prop_id is 'Идентификатор имени свойства.'
/
comment on column service_topic_name_by_stand.prop_value is 'Значение свойства.'
/
