create table calc_integration_base_rs
(
    id varchar(256),
    business_type_call varchar(256) not null,
    constraint calc_integration_base_rs_pk primary key (id),
    constraint calc_integration_base_rs_fk foreign key (business_type_call, id)
        references calc_integration_base(business_type_call, request_id) ON DELETE cascade deferrable INITIALLY DEFERRED,
    create_time timestamp default now(),
    num int not null,
    request_id varchar(256) not null,
    constraint calc_integration_base_rs_request_id unique (business_type_call, request_id),
    constraint calc_integration_base_rs_rq_fk foreign key (request_id) references calc_integration_base_rq(id),
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


