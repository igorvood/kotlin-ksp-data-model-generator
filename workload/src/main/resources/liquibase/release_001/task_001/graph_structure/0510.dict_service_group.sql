create table dict_service_group
(
    group_id varchar(255) not null,
    service_id varchar(255) not null,
    profile_id varchar(255) not null,
    constraint dict_service_group_pk primary key (group_id, service_id, profile_id),
    constraint dict_service_group_group_id_fk foreign key (group_id) references dict_group(id),
    constraint dict_service_group_service_fk foreign key (service_id, profile_id) references dict_service_node(service_id, profile_id)
)
/
comment on table dict_service_group is 'Справочник связей групп и сервисов.'
/
comment on column dict_service_group.group_id is 'Идетификатор группы.'
/
comment on column dict_service_group.service_id is 'Идетификатор сервиса.'
/
comment on column dict_service_group.profile_id is 'Идетификатор профиля.'
/
