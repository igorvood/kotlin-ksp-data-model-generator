create table dict_topic_owner
(
  id varchar(256) not null,
  constraint dict_topic_owner_pk primary key (id),
  is_our numeric(1) default 1 not null,
  constraint dict_topic_owner_is_our_ck check ( is_our in (0, 1) ),
  description_for_report varchar(512)
)
/
comment on table dict_topic_owner is 'Справочник владельв топиков.'
/
comment on column dict_topic_owner.id is 'Идентификатор владельца.'
/
comment on column dict_topic_owner.is_our is 'Признак топика принадлежащего комманде.'
/
comment on column dict_topic_owner.description_for_report is 'Описание для отчетов.'
/