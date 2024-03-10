create table calc_integration_base
(
  id varchar(256) GENERATED ,
  entity_type varchar(256) not null,
  pk varchar(512) not null,

  parent_entity_type varchar(256),
  parent_pk varchar(512),

  payload text not null,
  constraint entity_context_pk primary key (entity_type, pk),
  constraint entity_context_parent_fk foreign key (parent_entity_type, parent_pk) references entity_context(entity_type, pk) on delete cascade

)
/
comment on table entity_context is 'Справочник владельв топиков.'
/
comment on column entity_context.entity_type is 'Идентификатор владельца.'
/
