create table calc_integration_base
(
    id varchar(256) not null DEFAULT nextval('calc_integration_base_sequence'),
    business_type_call varchar(256) not null,

    constraint entity_context_pk primary key (id),
--     node_type varchar(256) generated always as ('topic') stored,
    request_id varchar(256) generated always as (id) stored,
    constraint calc_integration_base_request_id unique (business_type_call, request_id),
    response_id varchar(256),
    constraint calc_integration_base_response_id unique (business_type_call, response_id),
    is_finished bool generated always as (response_id!=null) stored
)
/
comment on table calc_integration_base is 'базовая таблица регистрации интеграций.'
/
comment on column calc_integration_base.id is 'Идентификатор интеграционного взаимодействия.'
/
comment on column calc_integration_base.business_type_call is 'Бизнесс тип интеграционного взаимодействия.'
/
comment on column calc_integration_base.request_id is 'Идентификатор запроса .'
/
comment on column calc_integration_base.response_id is 'Идентификатор ответа.'
/
comment on column calc_integration_base.is_finished is 'Признак завершенности.'
/

