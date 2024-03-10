create table dict_kafka_prop_value_by_stand
(
    grp_id varchar(256) not null,
    type_prop varchar(256) not null,
    constraint dict_kafka_prop_value_by_stand_type_prop_ck check ( type_prop in ('prd', 'cns') ),
    prop_id varchar(256) not null,
    constraint dict_kafka_prop_value_by_stand_pv_fk foreign key (type_prop, grp_id, prop_id)  references dict_kafka_prop_value(type_prop, grp_id, prop_id),
    stand_id varchar(256) not null,
    constraint dict_kafka_prop_value_by_stand_stand_id_fk foreign key (stand_id) references META_STAND(id),
    constraint dict_kafka_prop_value_by_stand_pk primary key (type_prop, stand_id, grp_id, prop_id),
    prop_value varchar(256) not null
)
/
comment on table dict_kafka_prop_value_by_stand is 'Справочник групп настроек для топиков.'
/
comment on column dict_kafka_prop_value_by_stand.grp_id is 'Идентификатор группы свойств'
/
comment on column dict_kafka_prop_value_by_stand.type_prop is 'Тип группы свойств prd - продьюссер, cns-консьюмер.'
/
comment on column dict_kafka_prop_value_by_stand.prop_id is 'Идентификатор свойства.'
/
comment on column dict_kafka_prop_value_by_stand.prop_value is 'Значение свойства.'
/
comment on column dict_kafka_prop_value_by_stand.stand_id is 'Идентификатор стенда.'
/