create table calc_integration_base_rs
(
    id varchar(256) not null DEFAULT nextval('calc_integration_base_sequence'),
    business_type_call varchar(256) not null,
    constraint calc_integration_base_rs_pk primary key (id),
    create_time timestamp default now(),
    request_id varchar(256) not null,
    constraint calc_integration_base_rs_request_id unique (business_type_call, request_id),
    constraint calc_integration_base_rs_rq_fk foreign key (request_id) references calc_integration_base_rq(id) ON DELETE cascade,
    data text not null
)
/
comment on table calc_integration_base_rs is 'Справочник владельв топиков.'
/
comment on column calc_integration_base_rs.id is 'Идентификатор запроса.'
/
comment on column calc_integration_base_rs.business_type_call is 'Идентификатор запроса.'
/
comment on column calc_integration_base_rs.create_time is 'Идентификатор запроса.'
/


