alter table dict_kafka_prop_value drop constraint dict_kafka_prop_value_prop_value_ref_fk
/
alter table dict_kafka_prop_value add constraint dict_kafka_prop_value_prop_value_ref_fk
    foreign key (type_prop, grp_id) references dict_kafka_property_grp on delete cascade deferrable INITIALLY deferred
/
alter table dict_kafka_prop_value drop constraint dict_kafka_prop_value_prp_fk
/
alter table dict_kafka_prop_value add constraint dict_kafka_prop_value_prp_fk
    foreign key (type_prop, prop_id) references dict_kafka_prop on delete cascade  deferrable INITIALLY deferred
/
alter table dict_kafka_prop_value_by_stand drop constraint dict_kafka_prop_value_by_stand_pv_fk
/
alter table dict_kafka_prop_value_by_stand add constraint dict_kafka_prop_value_by_stand_pv_fk
    foreign key (type_prop, grp_id, prop_id) references dict_kafka_prop_value on delete cascade  deferrable INITIALLY deferred
/
alter table dict_service_group drop constraint dict_service_group_service_fk
/
alter table dict_service_group add constraint dict_service_group_service_fk
    foreign key (service_id, profile_id) references dict_service_node on delete cascade  deferrable INITIALLY deferred
/
alter table dict_service_node drop constraint dict_service_node_node_type_fk
/
alter table dict_service_node add constraint dict_service_node_node_type_fk
    foreign key (node_type, id) references dict_abstract_graph_node (node_type, node_id) on delete cascade  deferrable INITIALLY deferred
/
alter table dict_service_node drop constraint dict_service_node_service_id_fk
/
alter table dict_service_node add constraint dict_service_node_service_id_fk
    foreign key (service_id) references dict_service(id) on delete cascade  deferrable INITIALLY deferred
/
alter table dict_topic_node drop constraint dict_topic_node_topic_owner_id_fk
/
alter table dict_topic_node add constraint dict_topic_node_topic_owner_id_fk
    foreign key (topic_owner_id) references dict_topic_owner(id) on delete cascade  deferrable INITIALLY deferred
/
alter table dict_topic_node drop constraint dict_topic_node_node_type_fk
/
alter table dict_topic_node add constraint dict_topic_node_node_type_fk
    foreign key (node_type, id) references dict_abstract_graph_node (node_type, node_id) on delete cascade  deferrable INITIALLY deferred
/
alter table dict_arrow drop constraint dict_arrow_beg_fk
/
alter table dict_arrow add constraint dict_arrow_beg_fk
    foreign key (graph_id, beg_node_type, beg_node_id) references dict_abstract_graph_node on delete cascade  deferrable INITIALLY deferred
/
alter table dict_arrow drop constraint dict_arrow_end_fk
/
alter table dict_arrow add constraint dict_arrow_end_fk
    foreign key (graph_id, beg_node_type, beg_node_id) references dict_abstract_graph_node on delete cascade  deferrable INITIALLY deferred
/
alter table dict_arrow drop constraint dict_arrow_prop_grp_fk
/
alter table dict_arrow add constraint dict_arrow_prop_grp_fk
    foreign key (kafka_grp_prop, kafka_direction) references dict_kafka_property_grp (id, type_read) on delete cascade  deferrable INITIALLY deferred
/
alter table dict_flink_prop_value drop constraint dict_flink_prop_value_srv_node_fk
/
alter table dict_flink_prop_value add constraint dict_flink_prop_value_srv_node_fk
    foreign key (service_id, profile_id) references dict_service_node on delete cascade  deferrable INITIALLY deferred
/
alter table dict_place_holder_by_service drop constraint dict_place_holder_by_service_ph_fk
/
alter table dict_place_holder_by_service add constraint dict_place_holder_by_service_ph_fk
    foreign key (place_holder_id) references dict_place_holder(ID) on delete cascade  deferrable INITIALLY deferred
/
alter table dict_place_holder_by_service drop constraint dict_place_holder_by_service_srv_fk
/
alter table dict_place_holder_by_service add constraint dict_place_holder_by_service_srv_fk
    foreign key (service_id, profile_id) references DICT_SERVICE_NODE(SERVICE_ID, PROFILE_ID) on delete cascade  deferrable INITIALLY deferred
/
alter table dict_topic_params_by_stand drop constraint dict_topic_params_by_stand_node_fk
/
alter table dict_topic_params_by_stand add constraint dict_topic_params_by_stand_node_fk
    foreign key (node_id) references DICT_TOPIC_NODE(id) on delete cascade  deferrable INITIALLY deferred
/
