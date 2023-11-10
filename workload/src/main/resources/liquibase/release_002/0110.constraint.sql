delete from dict_arrow
where flink_srv in  (
'uasp_dko_83088_way4_mdm_enrich_2150~way4_old_stream',
'uasp_dko_83088_way4_mdm_enrich~83088_way4_mdm_enrich_old',
'uasp_dko_83088_way4_mdm_enrich~83088_way4_new',
'uasp_dko_83088_way4_mdm_enrich~83088_way4_old',
'uasp_dko_83088_way4_mdm_enrich~way4_old',
'uasp-streaming-unp-convertor~w4_issuing_card'
)
/
alter table dict_arrow drop constraint dict_arrow_end_fk
/
alter table dict_arrow add constraint    dict_arrow_end_fk
    foreign key (graph_id, end_node_type, end_node_id) references dict_abstract_graph_node(graph_id, node_type, node_id)
        on delete cascade        deferrable initially deferred
/