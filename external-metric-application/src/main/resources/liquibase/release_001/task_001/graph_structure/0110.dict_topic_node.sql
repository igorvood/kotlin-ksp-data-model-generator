create table dict_topic_node
(
  id varchar(512) not null,
  constraint dict_topic_node_pk primary key (id),
  node_type varchar(256) generated always as ('topic') stored,
  constraint dict_topic_node_node_type_fk foreign key (node_type, id) references dict_abstract_graph_node(node_type, NODE_ID) on delete cascade,
  topic_owner_id varchar(256) not null,
  constraint dict_topic_node_topic_owner_id_fk foreign key (topic_owner_id) references dict_topic_owner(id),
  cleanup_policy varchar(16) not null default 'delete',
  constraint dict_topic_node_cleanup_policy_ck check ( cleanup_policy in ('compact', 'delete') ),
  retention numeric default 14400000,
  constraint dict_topic_node_retention_ck check (
      (cleanup_policy = 'compact' and retention is null)
      or (cleanup_policy = 'delete' and retention>0 )
  )
)
/
comment on table dict_topic_node is 'Справочник групп настроек для консьюмера топиков.'
/
comment on column dict_topic_node.node_type is 'Тип ноды.'
/
comment on column dict_topic_node.id is 'Идентификатор топика.'
/

