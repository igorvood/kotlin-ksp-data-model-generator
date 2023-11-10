DO $$
begin

INSERT INTO DICT_KAFKA_PROP (TYPE_PROP, PROP_ID) VALUES ('cns', 'auto.offset.reset');
INSERT INTO DICT_KAFKA_PROP (TYPE_PROP, PROP_ID) VALUES ('cns', 'check.crcs');
INSERT INTO DICT_KAFKA_PROP (TYPE_PROP, PROP_ID) VALUES ('cns', 'connections.max.idle.ms');
INSERT INTO DICT_KAFKA_PROP (TYPE_PROP, PROP_ID) VALUES ('cns', 'enable.auto.commit');
INSERT INTO DICT_KAFKA_PROP (TYPE_PROP, PROP_ID) VALUES ('cns', 'exclude.internal.topics');
INSERT INTO DICT_KAFKA_PROP (TYPE_PROP, PROP_ID) VALUES ('cns', 'fetch.max.bytes');
INSERT INTO DICT_KAFKA_PROP (TYPE_PROP, PROP_ID) VALUES ('cns', 'fetch.max.wait.ms');
INSERT INTO DICT_KAFKA_PROP (TYPE_PROP, PROP_ID) VALUES ('cns', 'fetch.min.bytes');
INSERT INTO DICT_KAFKA_PROP (TYPE_PROP, PROP_ID) VALUES ('cns', 'group.id');
INSERT INTO DICT_KAFKA_PROP (TYPE_PROP, PROP_ID) VALUES ('cns', 'heartbeat.interval.ms');
INSERT INTO DICT_KAFKA_PROP (TYPE_PROP, PROP_ID) VALUES ('cns', 'isolation.level');
INSERT INTO DICT_KAFKA_PROP (TYPE_PROP, PROP_ID) VALUES ('cns', 'ssl.truststore.type');
INSERT INTO DICT_KAFKA_PROP (TYPE_PROP, PROP_ID) VALUES ('cns', 'ssl.keystore.type');
INSERT INTO DICT_KAFKA_PROP (TYPE_PROP, PROP_ID) VALUES ('cns', 'session.timeout.ms');

INSERT INTO DICT_KAFKA_PROP (TYPE_PROP, PROP_ID) VALUES ('prd', 'acks');
INSERT INTO DICT_KAFKA_PROP (TYPE_PROP, PROP_ID) VALUES ('prd', 'enable.idempotence');
INSERT INTO DICT_KAFKA_PROP (TYPE_PROP, PROP_ID) VALUES ('prd', 'max.block.ms');
INSERT INTO DICT_KAFKA_PROP (TYPE_PROP, PROP_ID) VALUES ('prd', 'retries');
INSERT INTO DICT_KAFKA_PROP (TYPE_PROP, PROP_ID) VALUES ('prd', 'transaction.timeout.ms');
INSERT INTO DICT_KAFKA_PROP (TYPE_PROP, PROP_ID) VALUES ('prd', 'transactional.id');
INSERT INTO DICT_KAFKA_PROP (TYPE_PROP, PROP_ID) VALUES ('prd', 'ssl.truststore.type');
INSERT INTO DICT_KAFKA_PROP (TYPE_PROP, PROP_ID) VALUES ('prd', 'ssl.keystore.type');






INSERT INTO DICT_KAFKA_PROP (TYPE_PROP, PROP_ID) VALUES ('cns', 'bootstrap.servers');
INSERT INTO DICT_KAFKA_PROP (TYPE_PROP, PROP_ID) VALUES ('cns', 'security.protocol');
INSERT INTO DICT_KAFKA_PROP (TYPE_PROP, PROP_ID) VALUES ('cns', 'ssl.key.password');
INSERT INTO DICT_KAFKA_PROP (TYPE_PROP, PROP_ID) VALUES ('cns', 'ssl.keystore.location');
INSERT INTO DICT_KAFKA_PROP (TYPE_PROP, PROP_ID) VALUES ('cns', 'ssl.keystore.password');
INSERT INTO DICT_KAFKA_PROP (TYPE_PROP, PROP_ID) VALUES ('cns', 'ssl.truststore.location');
INSERT INTO DICT_KAFKA_PROP (TYPE_PROP, PROP_ID) VALUES ('cns', 'ssl.truststore.password');










INSERT INTO DICT_KAFKA_PROP (TYPE_PROP, PROP_ID) VALUES ('prd', 'bootstrap.servers');
INSERT INTO DICT_KAFKA_PROP (TYPE_PROP, PROP_ID) VALUES ('prd', 'security.protocol');
INSERT INTO DICT_KAFKA_PROP (TYPE_PROP, PROP_ID) VALUES ('prd', 'ssl.key.password');
INSERT INTO DICT_KAFKA_PROP (TYPE_PROP, PROP_ID) VALUES ('prd', 'ssl.keystore.location');
INSERT INTO DICT_KAFKA_PROP (TYPE_PROP, PROP_ID) VALUES ('prd', 'ssl.keystore.password');
INSERT INTO DICT_KAFKA_PROP (TYPE_PROP, PROP_ID) VALUES ('prd', 'ssl.truststore.location');
INSERT INTO DICT_KAFKA_PROP (TYPE_PROP, PROP_ID) VALUES ('prd', 'ssl.truststore.password');

end;
$$;
/

commit
/