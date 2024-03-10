create table meta_property_function
(
    id varchar(256) not null,
    description varchar(512) not null,
    constraint meta_property_function_pk primary key (id)
)
/
comment on table meta_property_function is 'Справочник ф-ций для вычисления значений свойств.'
/
comment on column meta_property_function.id is 'Идентификатор ф-ции'
/
comment on column meta_property_function.description is 'Описание.'
/
