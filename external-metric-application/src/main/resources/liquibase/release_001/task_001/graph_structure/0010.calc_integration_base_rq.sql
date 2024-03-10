create table calc_integration_base_rq
(
  id varchar(256),
  business_type_call varchar(256) not null,
  constraint calc_integration_base_rq_pk primary key (id),
  constraint calc_integration_base_rq_fk foreign key (business_type_call, id)
      references calc_integration_base(business_type_call, request_id) ON DELETE cascade deferrable INITIALLY DEFERRED,
  create_time timestamp default now()

)
/
comment on table calc_integration_base_rq is 'Справочник владельв топиков.'
/
comment on column calc_integration_base_rq.id is 'Идентификатор запроса.'
/
comment on column calc_integration_base_rq.business_type_call is 'Идентификатор запроса.'
/
comment on column calc_integration_base_rq.create_time is 'Идентификатор запроса.'
/
