create table entity_context
(
  entity_type varchar(256) not null,
  pk varchar(512) not null,
  payload text not null,
  constraint entity_context_pk primary key (entity_type, pk)
)
/
comment on table entity_context is 'Справочник владельв топиков.'
/
comment on column entity_context.entity_type is 'Идентификатор владельца.'
/
