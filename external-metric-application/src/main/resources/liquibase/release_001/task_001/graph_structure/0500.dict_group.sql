create table dict_group
(
    id varchar(255) not null,
    constraint dict_group_pk primary key (id),
    description varchar(512) not null
)
/
comment on table dict_group is 'Справочник групп.'
/
comment on column dict_group.id is 'Идетификатор группы.'
/
comment on column dict_group.description is 'Описание группы.'
/
