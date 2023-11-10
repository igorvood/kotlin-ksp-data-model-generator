insert into dict_kafka_property_grp(ID, TYPE_READ, DESCRIPTION)
SELECT 'earliest', 'cns', 'Загрузка всех сообщений топика с самого начала' from DUAL union
SELECT 'latest', 'cns', 'загрузка сообщений начиная с офсета, который запомнила кафка' from DUAL union
SELECT 'producer_default', 'prd', 'Самый простой и минималистичный продюсер' from DUAL
/