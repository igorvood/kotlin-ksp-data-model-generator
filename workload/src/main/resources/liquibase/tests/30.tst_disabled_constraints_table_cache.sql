create table tst_disabled_constraints_table_cache
(
    table_name varchar(63) not null,
    constraint tst_disabled_constraints_table_cache_pk primary key (table_name)
)
/
comment on table tst_disabled_constraints_table_cache is 'таблицы с отключкенными форенами'
/
comment on column tst_disabled_constraints_table_cache.table_name is 'Первоначальное имя объекта'
/
