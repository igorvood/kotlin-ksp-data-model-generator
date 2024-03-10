drop type if exists property cascade
/
create type property as (
    prop_id varchar(256),
    prop_value varchar(256),
    is_function numeric(1)
)
/
