drop type if exists topic cascade
/
create type topic as (
    direction varchar(3),
    topic_name varchar(256),
    prop_name varchar(256)
)
/


