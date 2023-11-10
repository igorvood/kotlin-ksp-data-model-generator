create or replace view dict_service_profile
as
select ds.ID, ds.MAIN_CLASS, dsn.PROFILE_ID
from DICT_SERVICE ds
  join DICT_SERVICE_NODE DSN on ds.ID = DSN.SERVICE_ID

/
comment on view dict_service_profile is 'вьюха Сервисов с профилями.'
/
comment on column dict_service_profile.ID is 'Идентификатор сервиса.'
/
comment on column dict_service_profile.PROFILE_ID is 'Идентификатор профиля.'
/
comment on column dict_service_profile.MAIN_CLASS is 'Класс.'
/