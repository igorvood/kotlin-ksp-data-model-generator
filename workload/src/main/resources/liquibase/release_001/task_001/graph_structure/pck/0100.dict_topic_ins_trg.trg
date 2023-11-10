create or replace function  dict_topic_ins_trg(p_GRAPH_ID varchar, p_NODE_ID varchar, p_owner varchar)
    returns  varchar
    language plpgsql
as $$
BEGIN
  insert into DICT_ABSTRACT_GRAPH_NODE(GRAPH_ID, NODE_TYPE, NODE_ID) values (p_GRAPH_ID, 'topic', p_NODE_ID);

  insert into DICT_TOPIC_NODE(id, topic_owner_id) values (p_NODE_ID, p_owner);
  RETURN '';
END;  $$
/
