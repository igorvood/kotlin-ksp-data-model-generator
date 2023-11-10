alter table dict_service_group drop constraint dict_service_group_service_fk
/
alter table dict_service_group drop constraint dict_service_group_group_id_fk
/
alter table dict_service_group add constraint dict_service_group_group_id_fk foreign key (group_id) references dict_group(id) on DELETE cascade deferrable
/
alter table dict_service_group add constraint dict_service_group_service_fk foreign key (service_id, profile_id) references dict_service_node(service_id, profile_id) on DELETE cascade
/