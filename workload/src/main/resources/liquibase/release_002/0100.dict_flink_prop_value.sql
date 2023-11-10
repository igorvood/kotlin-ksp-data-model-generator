alter table dict_flink_prop_value drop constraint dict_flink_prop_value_is_function_ck
/
alter table dict_flink_prop_value drop constraint dict_flink_prop_value_function_id_fk
/
alter table dict_flink_prop_value drop column function_id
/
alter table dict_flink_prop_value drop column is_function
/

