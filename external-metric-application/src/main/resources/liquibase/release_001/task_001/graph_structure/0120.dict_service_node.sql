create table dict_service_node
(
  service_id varchar(255) not null,
  constraint dict_service_node_service_id_fk foreign key(service_id) references dict_service(id),
  profile_id varchar(255) not null,
  constraint dict_service_node_pk primary key (service_id, profile_id),
  node_type varchar(256) generated always as ('flink_srv') stored,
  id varchar(256) generated always as (service_id||'~'||profile_id) stored,
  constraint dict_service_node_node_type_fk foreign key (node_type, id) references dict_abstract_graph_node(node_type, NODE_ID) on delete cascade,
  report_description text default 'Описание не заполнено.' not null
)
/
comment on table dict_service_node is 'Справочник групп настроек для консьюмера топиков.'
/
comment on column dict_service_node.node_type is 'Тип ноды.'
/
comment on column dict_service_node.id is 'Идентификатор ноды.'
/
comment on column dict_service_node.service_id is 'Идентификатор сервиса.'
/
comment on column dict_service_node.profile_id is 'Идентификатор профиля запуска.'
/
comment on column dict_service_node.report_description is 'Описание для отчетов.'
/