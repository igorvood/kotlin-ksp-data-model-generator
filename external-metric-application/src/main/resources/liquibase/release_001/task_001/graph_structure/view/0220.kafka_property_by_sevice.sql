create or replace view kafka_property_by_sevice
as
with srv as (
  select TOPIC_ID, DKPV.PROP_ID, DKPV.PROP_VALUE, sn.SERVICE_ID, PROFILE_ID,  STAND, sn.DERRECTION TYPE_PROP,  TOPIC_NAME, GRP_PROP, sn.PROPERTY_KEY
  from kafka_topic_by_service sn
    join DICT_KAFKA_PROPERTY_GRP kpg on (kpg.TYPE_READ, kpg.ID) = ((sn.DERRECTION, sn.GRP_PROP))
    join DICT_KAFKA_PROP_VALUE DKPV on kpg.TYPE_READ = DKPV.TYPE_PROP and kpg.ID = DKPV.GRP_ID
)
select
    srv.SERVICE_ID, srv.PROFILE_ID,  srv.STAND, srv.PROP_ID, srv.TYPE_PROP,
    srv.PROPERTY_KEY||'.'||srv.TYPE_PROP||'.'||srv.PROP_ID env_prop_name, coalesce(prp.PROPERTY_VAL, srv.PROP_VALUE) PROPERTY_VAL
from srv
  left join KAFKA_PROP_VALUE_by_STAND prp on (prp.GRP_ID, prp.TYPE_PROP, prp.PROP_ID, prp.STAND) = ((srv.GRP_PROP,srv.TYPE_PROP, srv.PROP_ID,  srv.STAND ))
order by SERVICE_ID, PROFILE_ID, STAND, env_prop_name
/
comment on view kafka_property_by_sevice is 'вьюха для update нод графов.'
/
comment on column kafka_property_by_sevice.SERVICE_ID is 'Идентификатор графа.'
/
comment on column kafka_property_by_sevice.PROFILE_ID is 'Идентификатор сервиса.'
/
comment on column kafka_property_by_sevice.STAND is 'Идентификатор профиля.'
/
comment on column kafka_property_by_sevice.ENV_PROP_NAME is 'кей для формирования env файла.'
/
comment on column kafka_property_by_sevice.PROP_ID is 'идентификатор свойства.'
/
comment on column kafka_property_by_sevice.PROPERTY_VAL is 'идентификатор свойства.'
/
comment on column kafka_property_by_sevice.TYPE_PROP is 'идентификатор свойства.'
/
