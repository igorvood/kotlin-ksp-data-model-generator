create or replace view parent_nodes AS
with pch as (
    select beg_node_id as node from dict_arrow
    union
    select end_node_id from dict_arrow
),
     p as (select da.beg_node_id as paretn_id, pch.node from pch
                                                                 left join dict_arrow da on da.end_node_id = pch.node
     )
select * from p
;

select *
from parent_nodes
where paretn_id = 'APRF_STATIC_PUB'
;

WITH RECURSIVE temp1 ( node ,paretn_id, PATH, LEVEL ) AS (
    SELECT T1.node,T1.paretn_id, CAST (T1.node AS VARCHAR (32000)) as PATH, 1
    FROM parent_nodes T1 WHERE T1.paretn_id IS NULL
    union
    select T2."node", T2."paretn_id", CAST ( temp1.PATH ||'->'|| T2."node" AS VARCHAR(32000)) ,LEVEL + 1
    FROM parent_nodes T2 INNER JOIN temp1 ON( temp1.node= T2."paretn_id")      )
select * from temp1 ORDER BY PATH LIMIT 10000
