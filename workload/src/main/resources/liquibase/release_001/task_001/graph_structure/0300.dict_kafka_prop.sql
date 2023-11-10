create table dict_kafka_prop
(
    type_prop varchar(256) not null,
    constraint dict_kafka_prop_type_prop_ck check ( type_prop in ('prd', 'cns') ),
    prop_id varchar(256) not null,
    constraint dict_kafka_prop_pk primary key (type_prop, prop_id)
)
/
comment on table dict_kafka_prop is 'Справочник групп настроек для консьюмера топиков.'
/
comment on column dict_kafka_prop.type_prop is 'Тип группы свойств prd - продьюссер, cns-консьюмер.'
/
comment on column dict_kafka_prop.prop_id is 'Идентификатор свойства.'
/
