create or replace function    create_srv(
        p_graph_id in varchar,
        p_SERVICE_ID in varchar,
        P_PROFILE_ID in varchar,
        P_MAIN_CLASS in varchar,
        p_topics in topic[],
        p_propepies_flink in PROPERTy[]
    ) returns  varchar
    language plpgsql
as
$$
declare
    cnt numeric;
BEGIN

        insert into DICT_SERVICE_INS(GRAPH_ID, SERVICE_ID, PROFILE_ID, MAIN_CLASS)
        values (p_graph_id, p_SERVICE_ID, P_PROFILE_ID, P_MAIN_CLASS);

        insert into dict_topic_ins(GRAPH_ID, NODE_ID)
        select p_graph_id, topic_name from  p_topics;


        insert into DICT_ARROW(GRAPH_ID, BEG_NODE_TYPE, BEG_NODE_ID, END_NODE_TYPE, END_NODE_ID, PROPERTY_KEY)
        select p_graph_id GRAPH_ID,
               case dirrection
                   when 'in' then 'topic'
                   when 'out' then 'flink_srv'
                   end BEG_NODE_TYPE,
               case dirrection
                   when 'in' then topic_name
                   when 'out' then p_SERVICE_ID||'~'||P_PROFILE_ID
                   end BEG_NODE_ID,
               case dirrection
                   when 'out' then 'topic'
                   when 'in' then 'flink_srv'
                   end END_NODE_TYPE,
               case dirrection
                   when 'out' then topic_name
                   when 'in' then p_SERVICE_ID||'~'||P_PROFILE_ID
                   end END_NODE_ID,
               prop_name PROPERTY_KEY
        from  p_topics;
        
        insert into DICT_FLINK_PROP_VALUE(SERVICE_ID, PROFILE_ID, PROP_ID, PROP_VALUE, IS_FUNCTION)
        select p_SERVICE_ID, P_PROFILE_ID, prop_id, prop_value, is_function
        from p_propepies_flink;


        commit;
    end;
$$

