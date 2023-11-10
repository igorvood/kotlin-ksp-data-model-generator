create or replace view all_placeholder as
with ph as (
    select SERVICE_ID, PROFILE_ID, STAND, PROP_ID, PROP_VALUE, strpos(PROP_VALUE, '${') begin_index, strpos(PROP_VALUE, '}') end_index
    from FULL_FLINK_SERVICE_PROPERTY_STAND
)
select distinct SERVICE_ID, PROFILE_ID, STAND, PROP_VALUE from ph
where ph.begin_index>0 and ph.end_index>0 and ph.begin_index<ph.end_index
/
comment on view all_placeholder is 'Все значения свойств с плейсхолдерами.'
/
comment on column all_placeholder.PROP_VALUE is 'Значение свойства.'
/
comment on column all_placeholder.PROFILE_ID is 'Профиль.'
/
comment on column all_placeholder.SERVICE_ID is 'Сервис.'
/
comment on column all_placeholder.STAND is 'Стенд.'
/

