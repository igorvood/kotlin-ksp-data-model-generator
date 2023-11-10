create table entity_uk_context
(
  entity_type varchar(256) not null,
  entity_type_uk varchar(256) not null,
  pk varchar(512) not null,
  uk varchar(512) not null,
  constraint entity_uk_context_pk primary key (entity_type, uk),
  constraint entity_uk_context_fk foreign key (entity_type, pk) references entity_context(entity_type, pk)
)
/
comment on table entity_uk_context is 'Справочник владельв топиков.'
/
comment on column entity_uk_context.entity_type is 'Идентификатор владельца.'
/
