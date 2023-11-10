DO $$
begin
    -- update dict_topic_node tn set consumer_prop_grp='latest'
-- where tn.id in (
--     '',
--     '',
--     '',
--     '',
--     '',
--     '',
--     '',
--     'dev_ivr__uasp_realtime__input_converter__way4_issuing_operation__uaspdto',
--     'dev_ivr__uasp_realtime__case_48_concatenate__uaspdto'

INSERT INTO DICT_ARROW (GRAPH_ID, BEG_NODE_TYPE, BEG_NODE_ID, END_NODE_TYPE, END_NODE_ID, PROPERTY_KEY, kafka_grp_prop)
-- select 'graph_1', 'flink_srv', 'Additional_enrich~case_65', 'topic', 'mutator_consumer_2', 'some_key1' from DUAL union
-- select 'graph_1', 'flink_srv', 'Filter~case_65', 'topic', 'Filter_producer_1', 'some_key2' from DUAL union
-- select 'graph_1', 'flink_srv', 'Filter~case_65', 'topic', 'Filter_producer_2', 'some_key3' from DUAL union
-- select 'graph_1', 'flink_srv', 'Mutator~case_65', 'topic', 'dev_ivr__uasp_realtime__business_rules__uaspdto', 'some_key4' from DUAL union
-- select 'graph_1', 'flink_srv', 'Mutator~case_65', 'topic', 'ivr__uasp_realtime__bussiness_rules__uaspdto__dlq', 'some_key5' from DUAL union
-- select 'graph_1', 'topic', 'dev_ivr__uasp_realtime__business_rules__uaspdto', 'flink_srv', 'Filter~case_65', 'some_key6' from DUAL union
-- select 'graph_1', 'topic', 'ivr__uasp_realtime__bussiness_rules__uaspdto__dlq', 'flink_srv', 'Additional_enrich~case_65', 'some_key7' from DUAL union
-- select 'graph_1', 'topic', 'mutator_consumer_2', 'flink_srv', 'Mutator~case_65', 'some_key8' from DUAL union
-- select 'graph_1', 'topic', 'uasp_mutator_filter_input', 'flink_srv', 'Mutator~case_65', 'some_key9' from DUAL union
-- select 'graph_1', 'topic', 'uasp_mutator_filter_input_2', 'flink_srv', 'Mutator~case_65', 'some_key30' from DUAL union

select 'rto_graph', 'topic', 'dev_bevents_68_after_rate_enrich', 'flink_srv', 'uasp-kriaa-bevents-case-2~main', 'enrichOne.MainEnrichProperty$.fromTopic', 'earliest' from DUAL union
select 'rto_graph', 'topic', 'dev_bevents_68_after_rate_enrich', 'flink_srv', 'uasp-kriaa-bevents-case-40~main', 'enrichOne.MainEnrichProperty$.fromTopic', 'earliest' from DUAL union
select 'rto_graph', 'topic', 'dev_multibonus_partners_program', 'flink_srv', 'uasp-kriaa-bevents-case-40~main', 'multiBonus.MultiBonusEnrichProperty$.fromTopic', 'earliest' from DUAL union
select 'rto_graph', 'topic', 'dev_bevents_68_after_rate_enrich', 'flink_srv', 'uasp-kriaa-bevents-case-68~main', 'enrichOne.MainEnrichProperty$.fromTopic', 'earliest' from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-kriaa-bevents-case-40~main', 'topic', 'dev__rto_uasp__case_40__dlq', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.toTopic', 'producer_default' from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-kriaa-bevents-case-40~main', 'topic', 'dev__rto_uasp__case_40', 'enrichOne.MainEnrichProperty$.out.FlinkSinkProperties$.toTopic', 'producer_default' from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-kriaa-bevents-case-68~main', 'topic', 'dev__rto_uasp__pks', 'enrichOne.MainEnrichProperty$.out.FlinkSinkProperties$.toTopic', 'producer_default' from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-kriaa-bevents-case-68~main', 'topic', 'dev_bevents_udds_mdm_rate_case68_uaspdto_dlq', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.toTopic', 'producer_default' from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-kriaa-bevents-case-2~main', 'topic', 'dev__rto_uasp__case_2', 'enrichOne.MainEnrichProperty$.out.FlinkSinkProperties$.toTopic', 'producer_default' from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-kriaa-bevents-case-2~main', 'topic', 'dev__rto_uasp__case_2_dlq', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.toTopic', 'producer_default' from DUAL union


select 'rto_graph', 'flink_srv', 'bevents-streaming-aggregate-first-salary~aggregate-bevents', 'topic', 'dev__bevents__realtime__aggregate_first_salary__dlq', 'dlq.topic.name', 'producer_default' from DUAL union
select 'rto_graph', 'flink_srv', 'bevents-streaming-aggregate-first-salary~aggregate-bevents', 'topic', 'dev_bevents__realtime__aggregate_first_salary__uaspdto', 'output.topic.name', 'producer_default' from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-streaming-input-convertor~input-convertor-ca-cardfl', 'topic', 'dev__dko_uasp__card_agreement_dlq', 'ca-cardfl.dlq.topic.name', 'producer_default' from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-streaming-input-convertor~input-convertor-ca-depositfl', 'topic', 'dev_rto_batch_ca_deposit_account_case_71_dlq', 'ca-depositfl.dlq.topic.name', 'producer_default' from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-streaming-input-convertor~input-convertor-ca-depositfl', 'topic', 'dev_rto_batch_ca_deposit_account_case_71_json_converted', 'ca-depositfl.output.topic.name', 'producer_default' from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-streaming-input-convertor~input-convertor-ca-first-salary', 'topic', 'dev_bevents__batch__ca_first_salary_transactions_dlq', 'ca-cft-transactions.dlq.topic.name', 'producer_default' from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-streaming-input-convertor~input-convertor-ca-first-salary', 'topic', 'dev_bevents__batch__ca_first_salary_transactions__json_converted', 'ca-cft-transactions.output.topic.name', 'producer_default' from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-streaming-input-convertor~input-convertor-cardfl', 'topic', 'dev_input_converter_cardfl_refill_uasp', 'cardfl.output.topic.name', 'producer_default' from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-streaming-input-convertor~input-convertor-cardfl', 'topic', 'dev_input_converter_cardfl_refill_uasp_dlq', 'cardfl.dlq.topic.name', 'producer_default' from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-streaming-input-convertor~input-convertor-cft', 'topic', 'dev_bevents__realtime__enrichment__prof__transactions_first__uaspdto', 'cft-transactions.output.topic.name', 'producer_default' from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-streaming-input-convertor~input-convertor-cft', 'topic', 'dev_bevents__realtime__input_converter__cft__transactions__dlq', 'cft-transactions.dlq.topic.name', 'producer_default' from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-streaming-input-convertor~input-convertor-mdm', 'topic', 'dev_ivr__uasp_realtime__input_converter__mdm_cross_link__dlq', 'mdm.dlq.topic.name', 'producer_default' from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-streaming-input-convertor~input-convertor-mdm', 'topic', 'dev_ivr__uasp_realtime__input_converter__mdm_cross_link__uaspdto', 'mdm.output.topic.name', 'producer_default' from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-streaming-input-convertor~input-convertor-prof-auth', 'topic', 'dev_bevents_streaming_input_convertor_profile_auth_dlq', 'profile.dlq.topic.name', 'producer_default' from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-streaming-input-convertor~input-convertor-prof-auth', 'topic', 'dev_bevents_streaming_input_convertor_profile_auth_uaspdto', 'profile.output.topic.name', 'producer_default' from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-streaming-input-convertor~input-convertor-withdraw', 'topic', 'dev_bevents__realtime__enrichment__prof__transactions_first__uaspdto', 'withdraw-transactions.output.topic.name', 'producer_default' from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-streaming-input-convertor~input-convertor-withdraw', 'topic', 'dev_input_withdraw_tx_dlq', 'withdraw-transactions.dlq.topic.name', 'producer_default' from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-streaming-model-vector~model-vector-bevents', 'topic', 'dev_bevents__realtime__modelvector_first_salary__dlq', 'producer.dlq.topic.name', 'producer_default' from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-streaming-model-vector~model-vector-bevents', 'topic', 'dev_bevents__realtime__modelvector_first_salary__qa', 'producer.qa.topic.name', 'producer_default' from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-streaming-model-vector~model-vector-bevents', 'topic', 'dev_ivr__uasp_realtime__model_vector__json', 'producer.topic.name', 'producer_default' from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-streaming-model-vector~model-vector-bevents', 'topic', 'dev_ivr__uasp_realtime__operations__json', 'producer.short.topic.name', 'producer_default' from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-streaming-model-vector~model-vector-bevents', 'topic', 'dev__rto_uasp__pdscp', 'producer.case29.topic.name', 'producer_default' from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-streaming-model-vector~model-vector-bevents', 'topic', 'dev__rto_uasp__ppnsx', 'producer.ns.topic.name', 'producer_default' from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-streaming-model-vector~model-vector-bevents', 'topic', 'dev__rto_uasp__zp', 'producer.pens.topic.name', 'producer_default' from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-streaming-model-vector~model-vector-bevents', 'topic', 'dev__rto_uasp__zzp', 'producer.fs.topic.name', 'producer_default' from DUAL union

select 'rto_graph', 'topic', 'CFT2RS_CD_OUT', 'flink_srv', 'uasp-streaming-input-convertor~input-convertor-cft', 'cft-transactions.input.topic.name', 'latest' from DUAL union
select 'rto_graph', 'topic', 'dev_bevents__batch__ca_first_salary_transactions__json', 'flink_srv', 'uasp-streaming-input-convertor~input-convertor-ca-first-salary', 'ca-cft-transactions.input.topic.name', 'latest' from DUAL union
select 'rto_graph', 'topic', 'dev_bevents__realtime__enrichment_first_salary_transactions__uaspdto', 'flink_srv', 'bevents-streaming-aggregate-first-salary~aggregate-bevents', 'ha.topic.name', 'latest' from DUAL union
select 'rto_graph', 'topic', 'dev_bevents__realtime__filter_first_salary__uaspdto', 'flink_srv', 'uasp-streaming-model-vector~model-vector-bevents', 'consumer.topic.name', 'latest' from DUAL union
select 'rto_graph', 'topic', 'dev_bevents_streaming_input_convertor_profile_auth_json', 'flink_srv', 'uasp-streaming-input-convertor~input-convertor-prof-auth', 'profile.input.topic.name', 'latest' from DUAL union
select 'rto_graph', 'topic', 'dev__dko_uasp__card_agreement', 'flink_srv', 'uasp-streaming-input-convertor~input-convertor-ca-cardfl', 'ca-cardfl.input.topic.name', 'latest' from DUAL union
select 'rto_graph', 'topic', 'dev_ivr__uasp_realtime__input_converter__mdm_cross_link__json', 'flink_srv', 'uasp-streaming-input-convertor~input-convertor-mdm', 'mdm.input.topic.name', 'latest' from DUAL union
select 'rto_graph', 'topic', 'dev_rto_batch_ca_deposit_account_case_71_json', 'flink_srv', 'uasp-streaming-input-convertor~input-convertor-ca-depositfl', 'ca-depositfl.input.topic.name', 'latest' from DUAL union
select 'rto_graph', 'topic', 'dev__uasp_aprf__pks', 'flink_srv', 'uasp-streaming-input-convertor~input-convertor-cardfl', 'cardfl.input.topic.name', 'latest' from DUAL union
select 'rto_graph', 'topic', 'profile_tx_out', 'flink_srv', 'uasp-streaming-input-convertor~input-convertor-profile', 'profile-transactions.input.topic.name', 'latest' from DUAL union
select 'rto_graph', 'topic', 'withdraw_tx_out', 'flink_srv', 'uasp-streaming-input-convertor~input-convertor-withdraw', 'withdraw-transactions.input.topic.name', 'latest' from DUAL union

select 'rto_graph', 'topic', 'dev_bevents__realtime__aggregate_first_salary__uaspdto', 'flink_srv', 'uasp-streaming-filter~bevents-filter', 'kafka.consumer.fromTopic', 'latest' from DUAL union
select 'rto_graph', 'topic', 'dev_ivr__uasp_realtime__business_rules__uaspdto', 'flink_srv', 'uasp-streaming-filter~main-input-filter', 'app.kafka.consumer.topicName', 'latest' from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-streaming-filter~bevents-filter', 'topic', 'dev_bevents__realtime__filter_first_salary__filter', 'kafka.producer.filterTag-error.FlinkSinkProperties$.toTopic', 'producer_default' from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-streaming-filter~bevents-filter', 'topic', 'dev_bevents__realtime__filter_first_salary__uaspdto', 'kafka.producer.filterTag-success.toTopic', 'producer_default' from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-streaming-filter~main-input-filter', 'topic', 'dev_ivr__uasp_realtime__filter__uaspdto__filter', 'app.kafka.producers.filterTag-error.topicName', 'producer_default' from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-streaming-filter~main-input-filter', 'topic', 'dev_ivr__uasp_realtime__mdm_enrichment__uaspdto', 'app.kafka.producers.filterTag-success.topicName', 'producer_default' from DUAL union

select 'rto_graph', 'flink_srv', 'uasp-streaming-mdm-enrichment~way4', 'topic', 'dev_ivr__uasp_realtime__input_converter__mortgage__dlq', 'enrichOne.CommonEnrichProperty$.dlq.FlinkSinkProperties$.toTopic', 'producer_default' from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-streaming-mdm-enrichment~way4', 'topic', 'dev_ivr__uasp_realtime__mdm_enrichment__mdm_cross_link__status__dlq', 'enrichOne.GlobalIdEnrichProperty$.dlq.FlinkSinkProperties$.toTopic', 'producer_default' from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-streaming-mdm-enrichment~way4', 'topic', 'dev_ivr__uasp_realtime__mdm_enrichment__for_additional_enrichment__uaspdto', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.toTopic', 'producer_default' from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-streaming-mdm-enrichment~way4', 'topic', 'dev_ivr__uasp_realtime_way4_mdm_enrichment__uaspdto', 'enrichOne.MainEnrichProperty$.out.FlinkSinkProperties$.toTopic', 'producer_default' from DUAL union

select 'rto_graph', 'flink_srv', 'uasp-streaming-mdm-enrichment~way4-card-agreement', 'topic', 'dev_rto_batch_ca_customer_card_uaspdto__dlq', 'enrichOne.CommonEnrichProperty$.dlq.FlinkSinkProperties$.toTopic', 'producer_default' from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-streaming-mdm-enrichment~way4-card-agreement', 'topic', 'dev_bevents_card_agreement_enrich_way4_dlq', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.toTopic', 'producer_default' from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-streaming-mdm-enrichment~way4-card-agreement', 'topic', 'dev_bevents_card_agreement_enrich_out_uaspdto', 'enrichOne.MainEnrichProperty$.out.FlinkSinkProperties$.toTopic', 'producer_default' from DUAL union

select 'rto_graph', 'topic', 'dev_ivr__uasp_realtime__input_converter__mortgage__uaspdto', 'flink_srv', 'uasp-streaming-mdm-enrichment~way4', 'enrichOne.CommonEnrichProperty$.fromTopic', 'earliest' from DUAL union
select 'rto_graph', 'topic', 'dev_ivr__uasp_realtime__input_converter__mdm_cross_link__uaspdto', 'flink_srv', 'uasp-streaming-mdm-enrichment~way4', 'enrichOne.GlobalIdEnrichProperty$.fromTopic', 'earliest' from DUAL union
select 'rto_graph', 'topic', 'dev_ivr__uasp_realtime__input_converter__way4_issuing_operation__uaspdto', 'flink_srv', 'uasp-streaming-mdm-enrichment~way4', 'enrichOne.MainEnrichProperty$.fromTopic', 'latest' from DUAL union

select 'rto_graph', 'topic', 'dev__dko_uasp__card_agreement_converted', 'flink_srv', 'uasp-streaming-mdm-enrichment~way4-card-agreement', 'enrichOne.CommonEnrichProperty$.fromTopic', 'earliest' from DUAL union
select 'rto_graph', 'topic', 'dev_ivr__uasp_realtime__case_48_concatenate__uaspdto', 'flink_srv', 'uasp-streaming-mdm-enrichment~way4-card-agreement', 'enrichOne.MainEnrichProperty$.fromTopic', 'latest' from DUAL union


select 'rto_graph', 'topic', 'dev_bevents_cft_way4_profile_udds_before_mdm_rate_case68_uaspdto', 'flink_srv', 'uasp-streaming-mdm-enrichment~case-68', 'enrichOne.MainEnrichProperty$.fromTopic', 'latest' from DUAL union
select 'rto_graph', 'topic', 'dev_input_converter_cardfl_refill_uasp', 'flink_srv', 'uasp-streaming-mdm-enrichment~case-68', 'enrichOne.CommonEnrichProperty$.fromTopic', 'earliest' from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-streaming-mdm-enrichment~case-68', 'topic', 'dev_bevents_cft_way4_profile_udds_before_case68_uaspdto', 'enrichOne.MainEnrichProperty$.out.FlinkSinkProperties$.toTopic', 'producer_default' from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-streaming-mdm-enrichment~case-68', 'topic', 'dev_bevents_udds_mdm_rate_case68_uaspdto_dlq', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.toTopic', 'producer_default' from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-streaming-mdm-enrichment~case-68', 'topic', 'dev_input_converter_cardfl_refill_uasp_dlq', 'enrichOne.CommonEnrichProperty$.dlq.FlinkSinkProperties$.toTopic', 'producer_default' from DUAL union

select 'rto_graph', 'topic', 'dev_bevents_cft_way4_profile_udds_before_case68_uaspdto', 'flink_srv', 'uasp-streaming-mdm-enrichment~case-68_agrement', 'enrichOne.MainEnrichProperty$.fromTopic', 'latest' from DUAL union
select 'rto_graph', 'topic', 'dev__dko_uasp__card_agreement_converted', 'flink_srv', 'uasp-streaming-mdm-enrichment~case-68_agrement', 'enrichOne.CommonEnrichProperty$.fromTopic', 'earliest' from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-streaming-mdm-enrichment~case-68_agrement', 'topic', 'dev_bevents_cft_way4_profile_udds_before_case68_uaspdto_dlq', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.toTopic', 'producer_default' from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-streaming-mdm-enrichment~case-68_agrement', 'topic', 'dev_bevents_udds_mdm_rate_case68_uaspdto', 'enrichOne.MainEnrichProperty$.out.FlinkSinkProperties$.toTopic', 'producer_default' from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-streaming-mdm-enrichment~case-68_agrement', 'topic', 'dev_rto_batch_ca_customer_card68_uaspdto_dlq', 'enrichOne.CommonEnrichProperty$.dlq.FlinkSinkProperties$.toTopic', 'producer_default' from DUAL union

select 'rto_graph', 'topic', 'dev_bevents_streaming_input_convertor_profile_auth_uaspdto', 'flink_srv', 'uasp-streaming-mdm-enrichment~prof-auth', 'enrichOne.MainEnrichProperty$.fromTopic', 'latest' from DUAL union
select 'rto_graph', 'topic', 'dev__dko_uasp__card_agreement_converted', 'flink_srv', 'uasp-streaming-mdm-enrichment~prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fromTopic', 'earliest' from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-streaming-mdm-enrichment~prof-auth', 'topic', 'dev_bevents_card_agreement_enrich_dlq', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.toTopic', 'producer_default' from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-streaming-mdm-enrichment~prof-auth', 'topic', 'dev_bevents_card_agreement_enrich_out_uaspdto', 'enrichOne.MainEnrichProperty$.out.FlinkSinkProperties$.toTopic', 'producer_default' from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-streaming-mdm-enrichment~prof-auth', 'topic', 'dev_rto_batch_ca_customer_card_uaspdto__dlq', 'enrichOne.GlobalIdEnrichProperty$.dlq.FlinkSinkProperties$.toTopic', 'producer_default' from DUAL union

select 'rto_graph', 'topic', 'dev_ivr__uasp_realtime__ca_ha_aggregate__ca__uaspdto', 'flink_srv', 'uasp-streaming-aggregate~aggregate-dko', 'consumer.ca.topic.name', 'earliest'  from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-streaming-aggregate~aggregate-dko', 'topic', 'dev_ivr__uasp_realtime__aggregate__uaspdto', 'producer.ha.topic.name', 'producer_default'  from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-streaming-input-convertor~input-convertor-w4-operation', 'topic', 'dev_ivr__uasp_realtime__input_converter__way4_issuing_operation__uaspdto', 'way4.output.topic.name', 'producer_default'  from DUAL union
select 'rto_graph', 'topic', 'dev_ivr__uasp_realtime__mdm_enrichment__uaspdto', 'flink_srv', 'uasp-streaming-aggregate~aggregate-dko', 'consumer.ha.topic.name', 'earliest'  from DUAL union
select 'rto_graph', 'topic', 'dev_ivr__uasp_realtime__input_converter__way4_issuing_operation__json', 'flink_srv', 'uasp-streaming-input-convertor~input-convertor-w4-operation', 'way4.input.topic.name', 'earliest'  from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-streaming-aggregate~aggregate-dko', 'topic', 'dev_ivr__uasp_realtime__aggregate__filter', 'producer.ha.filter.status.topic.name', 'producer_default'  from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-streaming-input-convertor~input-convertor-w4-operation', 'topic', 'dev_ivr__uasp_realtime__input_converter__way4_issuing_operation__dlq', 'way4.dlq.topic.name', 'producer_default'  from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-streaming-aggregate~aggregate-dko', 'topic', 'dev_ivr__uasp_realtime__aggregate__dlq', 'producer.ha.dlq.topic.name', 'producer_default'  from DUAL union



select 'rto_graph', 'topic', 'dev_bevents_card_agreement_enrich_out_uaspdto', 'flink_srv', 'uasp-streaming-mdm-enrichment~prof-auth-packNM', 'enrichOne.MainEnrichProperty$.fromTopic', 'latest' from DUAL union
select 'rto_graph', 'topic', 'dev__dko_uasp__pension_converted', 'flink_srv', 'uasp-streaming-mdm-enrichment~prof-auth-packNM', 'enrichOne.CommonEnrichProperty$.fromTopic', 'earliest' from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-streaming-mdm-enrichment~prof-auth-packNM', 'topic', 'dev_bevents_package_nm_enrich_dlq', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.toTopic', 'producer_default' from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-streaming-mdm-enrichment~prof-auth-packNM', 'topic', 'dev_bevents__realtime__enrichment__prof__transactions_first__uaspdto', 'enrichOne.MainEnrichProperty$.out.FlinkSinkProperties$.toTopic', 'producer_default' from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-streaming-mdm-enrichment~prof-auth-packNM', 'topic', 'dev_rto_batch_ca_customer_package_dlq', 'enrichOne.CommonEnrichProperty$.dlq.FlinkSinkProperties$.toTopic', 'producer_default' from DUAL union

select 'rto_graph', 'topic', 'dev_bevents__realtime__input_converter__prof__transactions__uaspdto', 'flink_srv', 'uasp-streaming-mdm-enrichment~prof-tx-case-71', 'enrichOne.MainEnrichProperty$.fromTopic', 'latest' from DUAL union
select 'rto_graph', 'topic', 'dev_rto_batch_ca_deposit_account_case_71_json_converted', 'flink_srv', 'uasp-streaming-mdm-enrichment~prof-tx-case-71', 'enrichOne.CommonEnrichProperty$.fromTopic', 'earliest' from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-streaming-mdm-enrichment~prof-tx-case-71', 'topic', 'dev_bevents__realtime__case_71__uaspdto', 'enrichOne.MainEnrichProperty$.out.FlinkSinkProperties$.toTopic', 'producer_default' from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-streaming-mdm-enrichment~prof-tx-case-71', 'topic', 'dev_bevents__realtime__case_71__uaspdto_dlq', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.toTopic', 'producer_default' from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-streaming-mdm-enrichment~prof-tx-case-71', 'topic', 'dev_rto_batch_ca_deposit_account_case_71_uaspdto__dlq', 'enrichOne.CommonEnrichProperty$.dlq.FlinkSinkProperties$.toTopic', 'producer_default' from DUAL union

select 'rto_graph', 'topic', 'dev_bevents__batch__ca_regulatory_client_id_of_profile__json_converted', 'flink_srv', 'uasp-streaming-mdm-enrichment~profile-tx-step1', 'enrichOne.GlobalIdEnrichProperty$.fromTopic', 'earliest' from DUAL union
select 'rto_graph', 'topic', 'dev_bevents__realtime__case_71__uaspdto', 'flink_srv', 'uasp-streaming-mdm-enrichment~profile-tx-step1', 'enrichOne.MainEnrichProperty$.fromTopic', 'latest' from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-streaming-mdm-enrichment~profile-tx-step1', 'topic', 'dev_bevents__realtime__enrichment__prof__contract_num__uaspdto', 'enrichOne.MainEnrichProperty$.out.FlinkSinkProperties$.toTopic', 'producer_default' from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-streaming-mdm-enrichment~profile-tx-step1', 'topic', 'dev_bevents__realtime__enrichment__prof__transactions_with_clientid__dlq', 'enrichOne.GlobalIdEnrichProperty$.dlq.FlinkSinkProperties$.toTopic', 'producer_default' from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-streaming-mdm-enrichment~profile-tx-step1', 'topic', 'dev_bevents__realtime__enrichment__prof__transactions_with_contract_num__dlq', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.toTopic', 'producer_default' from DUAL union

select 'rto_graph', 'topic', 'dev_bevents__batch__ca_regulatory_contract_num_of_mdm_id_profile__uaspdto', 'flink_srv', 'uasp-streaming-mdm-enrichment~profile-tx-step2', 'enrichOne.GlobalIdEnrichProperty$.fromTopic', 'earliest' from DUAL union
select 'rto_graph', 'topic', 'dev_bevents__realtime__enrichment__prof__contract_num__uaspdto', 'flink_srv', 'uasp-streaming-mdm-enrichment~profile-tx-step2', 'enrichOne.MainEnrichProperty$.fromTopic', 'latest' from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-streaming-mdm-enrichment~profile-tx-step2', 'topic', 'dev_bevents__realtime__enrichment__prof__transactions_first__uaspdto', 'enrichOne.MainEnrichProperty$.out.FlinkSinkProperties$.toTopic', 'producer_default' from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-streaming-mdm-enrichment~profile-tx-step2', 'topic', 'dev_bevents__realtime__enrichment__prof__transactions_with_mdm_id__dlq', 'enrichOne.GlobalIdEnrichProperty$.dlq.FlinkSinkProperties$.toTopic', 'producer_default' from DUAL union
select 'rto_graph', 'flink_srv', 'uasp-streaming-mdm-enrichment~profile-tx-step2', 'topic', 'dev_bevents__realtime__enrichment__prof__transactions_with_partyUId__dlq', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.toTopic', 'producer_default' from DUAL;










end;
$$;
/
commit;
/
rollback