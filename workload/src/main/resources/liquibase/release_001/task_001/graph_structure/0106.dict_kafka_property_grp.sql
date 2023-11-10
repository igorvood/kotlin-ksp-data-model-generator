create table dict_kafka_property_grp
(
  id varchar(256) not null,
  type_read varchar(256) not null,
  constraint dict_kafka_property_grp_type_prop_ck check ( type_read in ('prd', 'cns') ),
  constraint dict_kafka_property_grp_pk primary key (type_read, id),
  description varchar(512)
)
/
comment on table dict_kafka_property_grp is 'Справочник групп настроек для кафки.'
/
comment on column dict_kafka_property_grp.description is 'Описание.'
/
comment on column dict_kafka_property_grp.id is 'Идентификатор группы настроек.'
/
comment on column dict_kafka_property_grp.type_read is 'Тип обращения prd - продьюссер, cns - консьюмер.'
/
