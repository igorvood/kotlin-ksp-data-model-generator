create table dict_flink_prop_value
(
    service_id varchar(255) not null,
    profile_id varchar(255) not null,
    prop_id varchar(256) not null,
    constraint dict_flink_prop_value_pk primary key (service_id, profile_id, prop_id),
    prop_value varchar(256) not null,
    is_function numeric(1) not null,
    constraint dict_flink_prop_value_is_function_ck check ( is_function in (0, 1) ),
    function_id varchar(256) generated always as (case when is_function=1 then prop_value end) stored ,
    constraint dict_flink_prop_value_function_id_fk foreign key (function_id) references meta_property_function(id),
    constraint dict_flink_prop_value_srv_node_fk foreign key (service_id, profile_id) references DICT_SERVICE_NODE(SERVICE_ID, PROFILE_ID) on delete cascade
)
/
comment on table dict_flink_prop_value is 'Справочник групп настроек для консьюмера топиков.'
/
comment on column dict_flink_prop_value.service_id is 'Идентификатор сервиса'
/
comment on column dict_flink_prop_value.profile_id is 'Идентификатор профиля сервиса.'
/
comment on column dict_flink_prop_value.prop_id is 'Идентификатор свойства.'
/
comment on column dict_flink_prop_value.prop_value is 'Значение свойства.'
/
comment on column dict_flink_prop_value.is_function is 'Признак вычисляемого значения свойства.'
/
comment on column dict_flink_prop_value.function_id is 'Ф-ция вычисления св-ва.'
/
