create or replace view flink_property_by_stand as
select s.ID SERVICE_ID, DSN.PROFILE_ID, st.ID STAND, DFPV.PROP_ID, DFPV.PROP_VALUE from DICT_SERVICE s
    join DICT_SERVICE_NODE DSN on s.ID = DSN.SERVICE_ID
    join DICT_FLINK_PROP_VALUE DFPV on DSN.SERVICE_ID = DFPV.SERVICE_ID and DSN.PROFILE_ID = DFPV.PROFILE_ID
    cross join META_STAND st
/
comment on view flink_property_by_stand is 'вьюха для update нод графов.'
/
comment on column flink_property_by_stand.SERVICE_ID is 'Идентификатор графа.'
/
comment on column flink_property_by_stand.PROFILE_ID is 'Идентификатор сервиса.'
/
comment on column flink_property_by_stand.STAND is 'Идентификатор профиля.'
/
comment on column flink_property_by_stand.PROP_ID is 'идентификатор свойства.'
/
comment on column flink_property_by_stand.PROP_VALUE is 'идентификатор свойства.'
/
