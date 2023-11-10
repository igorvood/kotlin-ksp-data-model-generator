create table tst_renamed_db_obj_cache
(
    owner         varchar(63),
    ---
    original_name varchar(63),
    --
    new_name      varchar(63),
    --
    type_obj      varchar(30),
    constraint tst_renamed_db_obj_cache_t_ck check (upper(type_obj) in ('TABLE', 'VIEW') ),
    --
    constraint tst_renamed_db_obj_cache_pk primary key (owner, type_obj, original_name),
    view_code text,
    constraint tst_renamed_db_obj_cache_view_code_ck check ( (upper(type_obj) = 'VIEW' and view_code is not null) or upper(type_obj) = 'TABLE')
)
/
comment on table tst_renamed_db_obj_cache is 'Таблица переименованных объектов, для тестов'
/
comment on column tst_renamed_db_obj_cache.owner is 'Владелец объекта'
/
comment on column tst_renamed_db_obj_cache.original_name is 'Первоначальное имя объекта'
/
comment on column tst_renamed_db_obj_cache.new_name is 'Новое имя объекта'
/
comment on column tst_renamed_db_obj_cache.type_obj is 'Тип объекта'
/