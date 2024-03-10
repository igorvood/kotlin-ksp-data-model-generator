insert into META_STAND(ID, DESCRIPTION, IS_LOCAL, REPLACMENT_FOR_TOPIC_NAME, CNT_PARTITION, is_prod)
SELECT 'NOTEBOOK', 'NOTEBOOK', 1, 'dev_', 8,0 from dual union
SELECT 'NOTEBOOK_DSO', 'NOTEBOOK_DSO', 1, 'dev_', 8,0 from dual union
SELECT 'DSO', 'DSO', 0, 'dev_', 8,0 from dual union
SELECT 'IFT', 'IFT', 0, 'ift_', 8,0 from dual union
SELECT 'NT', 'NT', 0, 'nt_', 8,0 from dual union
SELECT 'REAL', 'REAL', 0, 'rr_', 8,0 from dual union
SELECT 'P0', 'P0', 0, 'p0_', 8,1 from dual
/
