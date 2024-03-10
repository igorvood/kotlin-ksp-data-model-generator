create or replace view KAFKA_PROP_VALUE_by_STAND
as
with t as (
select KPV.GRP_ID, KPV.TYPE_PROP, KPV.PROP_ID, KPVBS.STAND_ID stand, coalesce(KPVBS.PROP_VALUE, KPV.PROP_VALUE) property_val
FROM DICT_KAFKA_PROP_VALUE KPV
  left join DICT_KAFKA_PROP_VALUE_BY_STAND KPVBS on KPV.TYPE_PROP = KPVBS.TYPE_PROP and KPV.GRP_ID = KPVBS.GRP_ID and KPV.PROP_ID = KPVBS.PROP_ID
)
select t.GRP_ID, t.TYPE_PROP, t.PROP_ID, t.stand, t.property_val  from t
/
comment on view KAFKA_PROP_VALUE_by_STAND is 'Значения свойств топиков в разрезе стендов.'
/
comment on column KAFKA_PROP_VALUE_by_STAND.GRP_ID is 'Группа топика.'
/
comment on column KAFKA_PROP_VALUE_by_STAND.TYPE_PROP is 'Тип свойства, для прольюсера или консьюмера.'
/
comment on column KAFKA_PROP_VALUE_by_STAND.PROP_ID is 'идентификатор свойства.'
/
comment on column KAFKA_PROP_VALUE_by_STAND.stand is 'идентификатор стенда.'
/
comment on column KAFKA_PROP_VALUE_by_STAND.property_val is 'Значение свойства.'
/
