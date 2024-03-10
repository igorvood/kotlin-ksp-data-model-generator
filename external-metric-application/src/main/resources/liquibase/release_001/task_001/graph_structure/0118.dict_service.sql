create table dict_service
(
  id varchar(255) not null,
  main_class varchar(255) not null,
  constraint dict_service_pk primary key (id)
)
/
comment on table dict_service is 'Справочник групп настроек для консьюмера топиков.'
/
comment on column dict_service.id is 'Идентификатор сервиса.'
/
comment on column dict_service.main_class is 'Класс запуска.'
/
