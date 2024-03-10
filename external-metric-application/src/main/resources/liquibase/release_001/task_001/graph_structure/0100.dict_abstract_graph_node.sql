create table dict_abstract_graph_node
(
  graph_id varchar(256) not null,
  node_type varchar(32)  not null,
  constraint dict_abstract_graph_node_node_type_ck check ( node_type in ('topic', 'flink_srv') ),
  node_id varchar(512) not null,
  constraint dict_abstract_graph_node_pk primary key (graph_id, node_type, node_id)  ,
  constraint dict_abstract_graph_node_uk unique (node_type, node_id)
)
/
comment on table dict_abstract_graph_node is 'Справочник нод графов.'
/
comment on column dict_abstract_graph_node.graph_id is 'Идентификатор графа.'
/
comment on column dict_abstract_graph_node.node_type is 'Тип ноды.'
/
comment on column dict_abstract_graph_node.node_id is 'Идентификатор ноды.'
/
