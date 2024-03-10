create table dict_place_holder
(
    id varchar(255) not null,
    constraint dict_place_holder_pk primary key (id),
    description varchar(255) not null,
    default_value varchar(256) not null
)
/
comment on table dict_place_holder is 'Справочник плейсхолдеров.'
/
comment on column dict_place_holder.id is 'Идетификатор.'
/
comment on column dict_place_holder.description is 'Описание.'
/
comment on column dict_place_holder.default_value is 'Значение по умолчанию.'
/