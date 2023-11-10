create table dict_arrow
(
  graph_id varchar(256) not null,
  beg_node_type varchar(32)  not null,
  beg_node_id varchar(512) not null,
  end_node_type varchar(32)  not null,
  end_node_id varchar(512) not null,
  constraint dict_arrow_pk primary key (graph_id, beg_node_type, beg_node_id, end_node_type, end_node_id),
  constraint dict_arrow_not_equal_ck check (
    beg_node_type != end_node_type or beg_node_id != end_node_id
  ),
  constraint dict_arrow_beg_fk foreign key (graph_id, beg_node_type, beg_node_id) references dict_abstract_graph_node(graph_id, node_type, node_id) on delete cascade,
  constraint dict_arrow_end_fk foreign key (graph_id, end_node_type, end_node_id) references dict_abstract_graph_node(graph_id, node_type, node_id) on delete cascade,
  property_key varchar(256) not null,
  flink_srv varchar(256) generated always as  (
      case when beg_node_type = 'flink_srv'
      then beg_node_id
      else end_node_id end
      ) stored not null,
  constraint dict_arrow_prop_key_uk unique (flink_srv, property_key),
  common_name varchar(256) not null default 'Не задан',
  kafka_direction varchar(256) generated always as  (
      case when beg_node_type = 'flink_srv'
        then 'prd'
        else 'cns' end
      ) stored not null,
  kafka_grp_prop varchar(256) not null,
  constraint dict_arrow_prop_grp_fk foreign key (kafka_grp_prop, kafka_direction) references dict_kafka_property_grp(id, type_read)
)
/
comment on table dict_arrow is 'Справочник связей сервисов и топиков.'
/
comment on column dict_arrow.beg_node_type is 'Тип ноды начала стрелки .'
/
comment on column dict_arrow.beg_node_id is 'Идентификатор ноды начала стрелки.'
/
comment on column dict_arrow.end_node_type is 'Тип ноды окончания стрелки .'
/
comment on column dict_arrow.end_node_id is 'Идентификатор ноды окончания стрелки.'
/
comment on column dict_arrow.graph_id is 'Идентификатор графа.'
/
comment on column dict_arrow.property_key is 'Ключ для свойства для указания имени топика в настройках.'
/
comment on column dict_arrow.flink_srv is 'Имя сервиса.'
/
comment on column dict_arrow.common_name is 'Имя сертификата.'

