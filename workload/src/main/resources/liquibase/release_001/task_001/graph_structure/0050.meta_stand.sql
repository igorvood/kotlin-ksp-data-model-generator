create table meta_stand
(
    id varchar(256) not null,
    description varchar(512) not null,
    is_local numeric(1) not null,
    is_prod numeric(1) not null,
    constraint meta_stand_is_local_ck check ( is_local in (0, 1) ),
    constraint meta_stand_pk primary key (id),
    replacment_for_topic_name varchar(16) not null,
    CNT_PARTITION numeric(2) not null,
    constraint meta_stand_ck check ( CNT_PARTITION > 0 and CNT_PARTITION < 64)
)
/
comment on table meta_stand is 'Справочник Стендов.'
/
comment on column meta_stand.id is 'Идентификатор стенда'
/
comment on column meta_stand.description is 'Описание стенда.'
/
comment on column meta_stand.is_local is 'признак локального стенда.'
/
comment on column meta_stand.is_prod is 'признак прода.'
/
comment on column meta_stand.replacment_for_topic_name is 'Префикс для имени топика.'
/
comment on column meta_stand.CNT_PARTITION is 'кол-во партиций для топика по умолчанию.'
/

