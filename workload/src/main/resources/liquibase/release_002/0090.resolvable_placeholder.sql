drop view resolvable_placeholder
/
create or replace view resolvable_placeholder as
with a as (
select srv.SERVICE_ID, srv.PROFILE_ID, st.ID stand, ph.ID placeholder_id, ph.DEFAULT_VALUE
from DICT_PLACE_HOLDER ph
    cross join DICT_SERVICE_NODE srv
    cross join META_STAND st
)
select a.SERVICE_ID, a.PROFILE_ID, a.stand, a.placeholder_id, coalesce(ph_srv.VALUE, a.DEFAULT_VALUE) placeholder_value
from a
         left join DICT_PLACE_HOLDER_BY_SERVICE ph_srv on (ph_srv.SERVICE_ID, ph_srv.PROFILE_ID, ph_srv.STAND_ID, ph_srv.place_holder_id) = ((a.SERVICE_ID, a.PROFILE_ID , a.stand, a.placeholder_id))
/
comment on view resolvable_placeholder is 'Значения пленйсхолдеров в разрезе стендов.'
/
comment on column resolvable_placeholder.placeholder_value is 'Значение плейсхолдера.'
/
comment on column resolvable_placeholder.PROFILE_ID is 'Профиль.'
/
comment on column resolvable_placeholder.SERVICE_ID is 'Сервис.'
/
comment on column resolvable_placeholder.STAND is 'Стенд.'
/
comment on column resolvable_placeholder.placeholder_id is 'Идентификатор плейсхолдера.'
/


