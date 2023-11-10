insert into dict_abstract_graph_node(graph_id, node_id, node_type) 
select 'close_acc_graph', 'dev___account-provider__ acc__ close', 'topic' from dual  union 
select 'close_acc_graph', 'dev__account-provider__ acc__ close', 'topic' from dual  union 
select 'close_acc_graph', 'dev__account-provider__ acc__ close_unp', 'topic' from dual  union 
select 'close_acc_graph', 'dev__uasp_usst__account-provider__ acc__ close-topic-003', 'topic' from dual  union 
select 'close_acc_graph', 'dev__uasp_usst__account-provider__ acc__ close-topic-003_dlq', 'topic' from dual  union 
select 'close_acc_graph', 'uasp-streaming-input-convertor~close_account', 'flink_srv' from dual  union 
select 'close_acc_graph', 'uasp-streaming-unp-convertor~close_account', 'flink_srv' from dual  union 
select 'ofvs', 'dev__rto_uasp__ofvs', 'topic' from dual  union 
select 'ofvs', 'dev__rto_uasp__ofvs__dlq', 'topic' from dual  union 
select 'ofvs', 'dev__tbcr_uasp__ofvs', 'topic' from dual  union 
select 'ofvs', 'uasp-streaming-rto-ofvs~uasp-streaming-rto-ofvs', 'flink_srv' from dual  union 
select 'rto_graph', 'APRF_STATIC_PUB', 'topic' from dual  union 
select 'rto_graph', 'bevents-streaming-aggregate-first-salary~aggregate-bevents', 'flink_srv' from dual  union 
select 'rto_graph', 'bevents-streaming-aggregate-first-salary~aggregate-bevents-56-57', 'flink_srv' from dual  union 
select 'rto_graph', 'CFT2RS_CD_OUT', 'topic' from dual  union 
select 'rto_graph', 'dev_accr_uasp_acc_close', 'topic' from dual  union 
select 'rto_graph', 'dev_accr_uasp_acc_close_ack', 'topic' from dual  union 
select 'rto_graph', 'dev_accr_uasp_acc_close_valid', 'topic' from dual  union 
select 'rto_graph', 'dev_bevent__batch__ca_regulatory_client_id_of_profile__json_dlq', 'topic' from dual  union 
select 'rto_graph', 'dev_bevents_68_after_rate_enrich', 'topic' from dual  union 
select 'rto_graph', 'dev_bevents__batch__ca_first_salary_transactions_dlq', 'topic' from dual  union 
select 'rto_graph', 'dev_bevents__batch__ca_first_salary_transactions__json', 'topic' from dual  union 
select 'rto_graph', 'dev_bevents__batch__ca_first_salary_transactions__json_converted', 'topic' from dual  union 
select 'rto_graph', 'dev_bevents__batch__ca_regulatory_client_id_of_profile__json', 'topic' from dual  union 
select 'rto_graph', 'dev_bevents__batch__ca_regulatory_client_id_of_profile__json_converted', 'topic' from dual  union 
select 'rto_graph', 'dev_bevents__batch__ca_regulatory_contract_num_of_mdm_id_profile__uaspdto', 'topic' from dual  union 
select 'rto_graph', 'dev_bevents_card_agreement_enrich_dlq', 'topic' from dual  union 
select 'rto_graph', 'dev_bevents_card_agreement_enrich_out_uaspdto', 'topic' from dual  union 
select 'rto_graph', 'dev_bevents_card_agreement_enrich_way4_dlq', 'topic' from dual  union 
select 'rto_graph', 'dev_bevents_cft_way4_profile_udds_after_mutator_uaspdto', 'topic' from dual  union 
select 'rto_graph', 'dev_bevents_cft_way4_profile_udds_before_case68_uaspdto', 'topic' from dual  union 
select 'rto_graph', 'dev_bevents_cft_way4_profile_udds_before_case68_uaspdto_dlq', 'topic' from dual  union 
select 'rto_graph', 'dev_bevents_cft_way4_profile_udds_before_mdm_rate_case68_uaspdto', 'topic' from dual  union 
select 'rto_graph', 'dev_bevents_cft_way4_profile_udds_before_mdm_rate_case68_uaspdto_dlq', 'topic' from dual  union 
select 'rto_graph', 'dev_bevents_package_nm_enrich_dlq', 'topic' from dual  union 
select 'rto_graph', 'dev__bevents__realtime__aggregate_first_salary__dlq', 'topic' from dual  union 
select 'rto_graph', 'dev_bevents__realtime__aggregate_first_salary__uaspdto', 'topic' from dual  union 
select 'rto_graph', 'dev_bevents__realtime__case_71__uaspdto', 'topic' from dual  union 
select 'rto_graph', 'dev_bevents__realtime__case_71__uaspdto_dlq', 'topic' from dual  union 
select 'rto_graph', 'dev_bevents__realtime__enrichment_first_salary_transactions_dlq', 'topic' from dual  union 
select 'rto_graph', 'dev_bevents__realtime__enrichment_first_salary_transactions__uaspdto', 'topic' from dual  union 
select 'rto_graph', 'dev_bevents__realtime__enrichment_prepare_transactions__dlq', 'topic' from dual  union 
select 'rto_graph', 'dev_bevents__realtime__enrichment_prepare_transactions__uaspdto', 'topic' from dual  union 
select 'rto_graph', 'dev_bevents__realtime__enrichment__prof__contract_num__uaspdto', 'topic' from dual  union 
select 'rto_graph', 'dev_bevents__realtime__enrichment__prof__transactions_first__uaspdto', 'topic' from dual  union 
select 'rto_graph', 'dev_bevents__realtime__enrichment__prof__transactions_with_clientid__dlq', 'topic' from dual  union 
select 'rto_graph', 'dev_bevents__realtime__enrichment__prof__transactions_with_contract_num__dlq', 'topic' from dual  union 
select 'rto_graph', 'dev_bevents__realtime__enrichment__prof__transactions_with_mdm_id__dlq', 'topic' from dual  union 
select 'rto_graph', 'dev_bevents__realtime__enrichment__prof__transactions_with_partyUId__dlq', 'topic' from dual  union 
select 'rto_graph', 'dev_bevents__realtime__filter_first_salary__filter', 'topic' from dual  union 
select 'rto_graph', 'dev_bevents__realtime__filter_first_salary__uaspdto', 'topic' from dual  union 
select 'rto_graph', 'dev_bevents__realtime__input_converter__cft__transactions__dlq', 'topic' from dual  union 
select 'rto_graph', 'dev_bevents__realtime__input_converter__prof__transactions__dlq', 'topic' from dual  union 
select 'rto_graph', 'dev_bevents__realtime__input_converter__prof__transactions__uaspdto', 'topic' from dual  union 
select 'rto_graph', 'dev_bevents__realtime__modelvector_first_salary__dlq', 'topic' from dual  union 
select 'rto_graph', 'dev_bevents__realtime__modelvector_first_salary__qa', 'topic' from dual  union 
select 'rto_graph', 'dev_bevents__realtime__refunds-notifier__dlq', 'topic' from dual  union 
select 'rto_graph', 'dev_bevents_streaming_input_convertor_profile_auth_dlq', 'topic' from dual  union 
select 'rto_graph', 'dev_bevents_streaming_input_convertor_profile_auth_json', 'topic' from dual  union 
select 'rto_graph', 'dev_bevents_streaming_input_convertor_profile_auth_uaspdto', 'topic' from dual  union 
select 'rto_graph', 'dev_bevents__uasp_realtime__outer_cbr_rate__status', 'topic' from dual  union 
select 'rto_graph', 'dev_bevents_udds_mdm_rate_case68_uaspdto', 'topic' from dual  union 
select 'rto_graph', 'dev_bevents_udds_mdm_rate_case68_uaspdto_dlq', 'topic' from dual  union 
select 'rto_graph', 'dev__boop_uasp__uss__loyalty_profile_changes', 'topic' from dual  union 
select 'rto_graph', 'dev__boop_uasp__uss__loyalty_profile_changes_dlq', 'topic' from dual  union 
select 'rto_graph', 'dev_cft2rl_uasp_loan_details', 'topic' from dual  union 
select 'rto_graph', 'dev__cft2rs_uasp__chvsns', 'topic' from dual  union 
select 'rto_graph', 'dev__dko_uasp__card_agreement', 'topic' from dual  union 
select 'rto_graph', 'dev__dko_uasp__card_agreement_converted', 'topic' from dual  union 
select 'rto_graph', 'dev__dko_uasp__card_agreement_dlq', 'topic' from dual  union 
select 'rto_graph', 'dev__dko_uasp__pension', 'topic' from dual  union 
select 'rto_graph', 'dev_dko_uasp__pension', 'topic' from dual  union 
select 'rto_graph', 'dev__dko_uasp__pension_converted', 'topic' from dual  union 
select 'rto_graph', 'dev__dko_uasp__pension_dlq', 'topic' from dual  union 
select 'rto_graph', 'dev__dlq__ipo_uasp__od', 'topic' from dual  union 
select 'rto_graph', 'dev_feature_ivr__uasp_realtime__mdm_enrichment__uaspdto', 'topic' from dual  union 
select 'rto_graph', 'dev_input_converter_cardfl_refill_uasp', 'topic' from dual  union 
select 'rto_graph', 'dev_input_converter_cardfl_refill_uasp_dlq', 'topic' from dual  union 
select 'rto_graph', 'dev_input_withdraw_tx_dlq', 'topic' from dual  union 
select 'rto_graph', 'dev__ipo_uasp__od', 'topic' from dual  union 
select 'rto_graph', 'dev_ivr__uasp_realtime__aggregate__dlq', 'topic' from dual  union 
select 'rto_graph', 'dev_ivr__uasp_realtime__aggregate__filter', 'topic' from dual  union 
select 'rto_graph', 'dev_ivr__uasp_realtime__aggregate__uaspdto', 'topic' from dual  union 
select 'rto_graph', 'dev_ivr__uasp_realtime__business_rules__uaspdto', 'topic' from dual  union 
select 'rto_graph', 'dev_ivr__uasp_realtime__bussiness_rules__uaspdto__dlq', 'topic' from dual  union 
select 'rto_graph', 'dev_ivr__uasp_realtime__ca_ha_aggregate__ca__uaspdto', 'topic' from dual  union 
select 'rto_graph', 'dev_ivr__uasp_realtime__case_48_concatenate__uaspdto', 'topic' from dual  union 
select 'rto_graph', 'dev_ivr__uasp_realtime__filter__uaspdto__filter', 'topic' from dual  union 
select 'rto_graph', 'dev_ivr__uasp_realtime__input_converter__mdm_cross_link__dlq', 'topic' from dual  union 
select 'rto_graph', 'dev_ivr__uasp_realtime__input_converter__mdm_cross_link__json', 'topic' from dual  union 
select 'rto_graph', 'dev_ivr__uasp_realtime__input_converter__mdm_cross_link__uaspdto', 'topic' from dual  union 
select 'rto_graph', 'dev_ivr__uasp_realtime__input_converter__mortgage__dlq', 'topic' from dual  union 
select 'rto_graph', 'dev_ivr__uasp_realtime__input_converter__mortgage__uaspdto', 'topic' from dual  union 
select 'rto_graph', 'dev_ivr__uasp_realtime__input_converter__way4_issuing_account_balance__json', 'topic' from dual  union 
select 'rto_graph', 'dev_ivr__uasp_realtime__input_converter__way4_issuing_card__json', 'topic' from dual  union 
select 'rto_graph', 'dev_ivr__uasp_realtime__input_converter__way4_issuing_operation__dlq', 'topic' from dual  union 
select 'rto_graph', 'dev_ivr__uasp_realtime__input_converter__way4_issuing_operation__json', 'topic' from dual  union 
select 'rto_graph', 'dev_ivr__uasp_realtime__input_converter__way4_issuing_operation__uaspdto', 'topic' from dual  union 
select 'rto_graph', 'dev_ivr__uasp_realtime__mdm_enrichment__for_additional_enrichment__uaspdto', 'topic' from dual  union 
select 'rto_graph', 'dev_ivr__uasp_realtime__mdm_enrichment__mdm_cross_link__status__dlq', 'topic' from dual  union 
select 'rto_graph', 'dev_ivr__uasp_realtime__mdm_enrichment__uaspdto', 'topic' from dual  union 
select 'rto_graph', 'dev_ivr__uasp_realtime__mdm_enrichment__uaspdto__dlq', 'topic' from dual  union 
select 'rto_graph', 'dev_ivr__uasp_realtime__model_vector__json', 'topic' from dual  union 
select 'rto_graph', 'dev_ivr__uasp_realtime__operations__json', 'topic' from dual  union 
select 'rto_graph', 'dev_ivr__uasp_realtime__outer_cbr_rate__ask', 'topic' from dual  union 
select 'rto_graph', 'dev_ivr__uasp_realtime__outer_cbr_rates__json', 'topic' from dual  union 
select 'rto_graph', 'dev_ivr__uasp_realtime__schemas__json', 'topic' from dual  union 
select 'rto_graph', 'dev_ivr_uasp_realtime_way4_main_input_issuing_operation__json', 'topic' from dual  union 
select 'rto_graph', 'dev_ivr__uasp_realtime_way4_mdm_enrichment__uaspdto', 'topic' from dual  union 
select 'rto_graph', 'dev_mdm-usst-outpu', 'topic' from dual  union 
select 'rto_graph', 'dev_mdm-usst-output', 'topic' from dual  union 
select 'rto_graph', 'dev__model_orkestrator__uasp__zoc', 'topic' from dual  union 
select 'rto_graph', 'dev__mscl_uasp_applic', 'topic' from dual  union 
select 'rto_graph', 'dev__mscl_uasp_applic_valid', 'topic' from dual  union 
select 'rto_graph', 'dev__mscl_uasp_applic_valid_ack', 'topic' from dual  union 
select 'rto_graph', 'dev__mssa_uasp_applic', 'topic' from dual  union 
select 'rto_graph', 'dev__mssa_uasp_applic_valid', 'topic' from dual  union 
select 'rto_graph', 'dev__mssa_uasp_applic_valid_ack', 'topic' from dual  union 
select 'rto_graph', 'dev_multibonus_partners_program', 'topic' from dual  union 
select 'rto_graph', 'dev__pp_fl_uasp__opyp', 'topic' from dual  union 
select 'rto_graph', 'dev_rto_batch_ca_customer_card68_uaspdto_dlq', 'topic' from dual  union 
select 'rto_graph', 'dev_rto_batch_ca_customer_card_uaspdto__dlq', 'topic' from dual  union 
select 'rto_graph', 'dev_rto_batch_ca_customer_package_dlq', 'topic' from dual  union 
select 'rto_graph', 'dev_rto_batch_ca_deposit_account_case_71_dlq', 'topic' from dual  union 
select 'rto_graph', 'dev_rto_batch_ca_deposit_account_case_71_json', 'topic' from dual  union 
select 'rto_graph', 'dev_rto_batch_ca_deposit_account_case_71_json_converted', 'topic' from dual  union 
select 'rto_graph', 'dev_rto_batch_ca_deposit_account_case_71_uaspdto__dlq', 'topic' from dual  union 
select 'rto_graph', 'dev_rto_batch_ca_personal_manager_json', 'topic' from dual  union 
select 'rto_graph', 'dev_rto_batch_ca_personal_manager_json_converted', 'topic' from dual  union 
select 'rto_graph', 'dev_rto_batch_ca_personal_manager_json_dlq', 'topic' from dual  union 
select 'rto_graph', 'dev_rto_uasp_actc', 'topic' from dual  union 
select 'rto_graph', 'dev_rto_uasp_actc_way4_dlq', 'topic' from dual  union 
select 'rto_graph', 'dev__rto_uasp__blcard', 'topic' from dual  union 
select 'rto_graph', 'dev__rto_uasp__case_2', 'topic' from dual  union 
select 'rto_graph', 'dev__rto_uasp__case_2_dlq', 'topic' from dual  union 
select 'rto_graph', 'dev__rto_uasp__case_39_old', 'topic' from dual  union 
select 'rto_graph', 'dev__rto_uasp__case_39_vector', 'topic' from dual  union 
select 'rto_graph', 'dev__rto_uasp__case_40', 'topic' from dual  union 
select 'rto_graph', 'dev__rto_uasp__case_40__dlq', 'topic' from dual  union 
select 'rto_graph', 'dev__rto_uasp__case_44', 'topic' from dual  union 
select 'rto_graph', 'dev__rto_uasp__case_48', 'topic' from dual  union 
select 'rto_graph', 'dev__rto_uasp__case_51', 'topic' from dual  union 
select 'rto_graph', 'dev__rto_uasp__case_62', 'topic' from dual  union 
select 'rto_graph', 'dev__rto_uasp__case_62_prf_dlq', 'topic' from dual  union 
select 'rto_graph', 'dev__rto_uasp__case_62_way4_dlq', 'topic' from dual  union 
select 'rto_graph', 'dev__rto_uasp__case_70', 'topic' from dual  union 
select 'rto_graph', 'dev__rto_uasp__case_70_dlq', 'topic' from dual  union 
select 'rto_graph', 'dev__rto_uasp__case_71', 'topic' from dual  union 
select 'rto_graph', 'dev__rto_uasp__case_84', 'topic' from dual  union 
select 'rto_graph', 'dev__rto_uasp__case_84_dlq', 'topic' from dual  union 
select 'rto_graph', 'dev__rto_uasp_ipood', 'topic' from dual  union 
select 'rto_graph', 'dev__rto_uasp__izmpin', 'topic' from dual  union 
select 'rto_graph', 'dev__rto_uasp__izost', 'topic' from dual  union 
select 'rto_graph', 'dev__rto_uasp__izost_unp', 'topic' from dual  union 
select 'rto_graph', 'dev_rto_uasp_ons', 'topic' from dual  union 
select 'rto_graph', 'dev_rto_uasp_ons__dlq', 'topic' from dual  union 
select 'rto_graph', 'dev__rto_uasp__opyp', 'topic' from dual  union 
select 'rto_graph', 'dev__rto_uasp__opyp__dlq', 'topic' from dual  union 
select 'rto_graph', 'dev_rto_uasp_ov', 'topic' from dual  union 
select 'rto_graph', 'dev_rto_uasp_ov__dlq', 'topic' from dual  union 
select 'rto_graph', 'dev__rto_uasp__pdscp', 'topic' from dual  union 
select 'rto_graph', 'dev_rto_uasp_piods', 'topic' from dual  union 
select 'rto_graph', 'dev_rto_uasp_piods_dlq', 'topic' from dual  union 
select 'rto_graph', 'dev__rto_uasp__pks', 'topic' from dual  union 
select 'rto_graph', 'dev__rto_uasp__ppnsx', 'topic' from dual  union 
select 'rto_graph', 'dev_rto_uasp_pzns_dlq', 'topic' from dual  union 
select 'rto_graph', 'dev_rto_uasp_pzv', 'topic' from dual  union 
select 'rto_graph', 'dev_rto_uasp_pzv__dlq', 'topic' from dual  union 
select 'rto_graph', 'dev_rto_uasp_svc', 'topic' from dual  union 
select 'rto_graph', 'dev_rto_uasp_svc_dlq', 'topic' from dual  union 
select 'rto_graph', 'dev_rto_uasp_usapns', 'topic' from dual  union 
select 'rto_graph', 'dev_rto_uasp_usapns__dlq', 'topic' from dual  union 
select 'rto_graph', 'dev__rto_uasp__zp', 'topic' from dual  union 
select 'rto_graph', 'dev__rto_uasp__zp_dlq', 'topic' from dual  union 
select 'rto_graph', 'dev__rto_uasp__zzp', 'topic' from dual  union 
select 'rto_graph', 'dev__rto_uasp__zzp_dlq', 'topic' from dual  union 
select 'rto_graph', 'dev_sstr_uasp_pay_inf', 'topic' from dual  union 
select 'rto_graph', 'dev_sstr_uasp_pay_inf_ack', 'topic' from dual  union 
select 'rto_graph', 'dev_sstr_uasp_pay_inf_valid', 'topic' from dual  union 
select 'rto_graph', 'dev_sstr_uasp_piods', 'topic' from dual  union 
select 'rto_graph', 'dev_ss_uasp_ons', 'topic' from dual  union 
select 'rto_graph', 'dev_ss_uasp_ov', 'topic' from dual  union 
select 'rto_graph', 'dev_ss_uasp_pzns', 'topic' from dual  union 
select 'rto_graph', 'dev_ss_uasp_pzv', 'topic' from dual  union 
select 'rto_graph', 'dev_ss_uasp_svc', 'topic' from dual  union 
select 'rto_graph', 'dev_ss_uasp_usapns', 'topic' from dual  union 
select 'rto_graph', 'dev__trns_uasp__up', 'topic' from dual  union 
select 'rto_graph', 'dev__uasp_aprf__pks', 'topic' from dual  union 
select 'rto_graph', 'dev__uasp_aprf__pks_dlq', 'topic' from dual  union 
select 'rto_graph', 'dev_uasp_bcps_ced', 'topic' from dual  union 
select 'rto_graph', 'dev_uasp_bcps_ced_dlq', 'topic' from dual  union 
select 'rto_graph', 'dev_uasp_bcps_csc', 'topic' from dual  union 
select 'rto_graph', 'dev_uasp_bcps_csc_dlq', 'topic' from dual  union 
select 'rto_graph', 'dev_uasp_ccpp_card_activate', 'topic' from dual  union 
select 'rto_graph', 'dev_uasp_ccpp_card_activate_dlq', 'topic' from dual  union 
select 'rto_graph', 'dev_uasp_ccpp_card_block', 'topic' from dual  union 
select 'rto_graph', 'dev_uasp_ccpp_card_block_dlq', 'topic' from dual  union 
select 'rto_graph', 'dev_uasp_ccpp_card_pin_change', 'topic' from dual  union 
select 'rto_graph', 'dev_uasp_ccpp_card_pin_change_dlq', 'topic' from dual  union 
select 'rto_graph', 'dev__uasp__enrichment__zoc', 'topic' from dual  union 
select 'rto_graph', 'dev_uasp_ins_add_vns', 'topic' from dual  union 
select 'rto_graph', 'dev_uasp_ins_add_vns_dlq', 'topic' from dual  union 
select 'rto_graph', 'dev_uasp_ins_change_vns', 'topic' from dual  union 
select 'rto_graph', 'dev_uasp_ins_change_vns_dlq', 'topic' from dual  union 
select 'rto_graph', 'dev__uasp__rto__zoc', 'topic' from dual  union 
select 'rto_graph', 'dev__uasp__rto__zoc__dlq', 'topic' from dual  union 
select 'rto_graph', 'dev__uasp_usst__wayNew_account_trmon', 'topic' from dual  union 
select 'rto_graph', 'dev__uasp_usst__wayNew_account_uop', 'topic' from dual  union 
select 'rto_graph', 'dev__uasp_usst__wayNew_operation_trmon', 'topic' from dual  union 
select 'rto_graph', 'dev__uasp_usst__wayNew_operation_uop', 'topic' from dual  union 
select 'rto_graph', 'dev__uasp_usst__wayOld_account_trmon', 'topic' from dual  union 
select 'rto_graph', 'dev__uasp_usst__wayOld_operation_trmon', 'topic' from dual  union 
select 'rto_graph', 'dev__uasp_usst__wayOld_operation_uop', 'topic' from dual  union 
select 'rto_graph', 'dev__uasp_usst__way_trmon__dlq', 'topic' from dual  union 
select 'rto_graph', 'dev__uasp_usst__way_uop__dlq', 'topic' from dual  union 
select 'rto_graph', 'dev__udds_uasp__up', 'topic' from dual  union 
select 'rto_graph', 'dev__udds_uasp__up_dlq', 'topic' from dual  union 
select 'rto_graph', 'dev__udds_uasp__up_unp', 'topic' from dual  union 
select 'rto_graph', 'dev__wayn_wvtb__issuing_account', 'topic' from dual  union 
select 'rto_graph', 'dev__wayn_wvtb__issuing_operation', 'topic' from dual  union 
select 'rto_graph', 'dev__wpr_profile-uasp__auth', 'topic' from dual  union 
select 'rto_graph', 'dev__wpr_profile-uasp__tran', 'topic' from dual  union 
select 'rto_graph', 'ift__udds_uasp__up_dlq', 'topic' from dual  union 
select 'rto_graph', 'issuing-account', 'topic' from dual  union 
select 'rto_graph', 'issuing-account-balance', 'topic' from dual  union 
select 'rto_graph', 'issuing-card', 'topic' from dual  union 
select 'rto_graph', 'issuing-operation', 'topic' from dual  union 
select 'rto_graph', 'p0_bevents__realtime__enrichment__prof__transactions_first__uaspdto', 'topic' from dual  union 
select 'rto_graph', 'p0_ivr__uasp_realtime__input_converter__way4_issuing_operation__json', 'topic' from dual  union 
select 'rto_graph', 'p0_ivr_uasp_realtime_way4_main_input_issuing_operation__json', 'topic' from dual  union 
select 'rto_graph', 'p0_ivr__uasp_realtime_way4_mdm_enrichment__uaspdto', 'topic' from dual  union 
select 'rto_graph', 'p0__rto_uasp__case_70', 'topic' from dual  union 
select 'rto_graph', 'prod__dlq__ipo_uasp__od', 'topic' from dual  union 
select 'rto_graph', 'prod__ipo_uasp__od', 'topic' from dual  union 
select 'rto_graph', 'PROD.OUTER.CBR.RATES.ACK', 'topic' from dual  union 
select 'rto_graph', 'prod__rto_uasp_ipood', 'topic' from dual  union 
select 'rto_graph', 'prod_rto_uasp_ov', 'topic' from dual  union 
select 'rto_graph', 'prod_rto_uasp_ov__dlq', 'topic' from dual  union 
select 'rto_graph', 'prod_rto_uasp_pzv', 'topic' from dual  union 
select 'rto_graph', 'prod_rto_uasp_pzv__dlq', 'topic' from dual  union 
select 'rto_graph', 'prod_rto_uasp_usapns', 'topic' from dual  union 
select 'rto_graph', 'prod_rto_uasp_usapns__dlq', 'topic' from dual  union 
select 'rto_graph', 'prod_ss_uasp_ov', 'topic' from dual  union 
select 'rto_graph', 'prod_ss_uasp_pzv', 'topic' from dual  union 
select 'rto_graph', 'prod_ss_uasp_usapns', 'topic' from dual  union 
select 'rto_graph', 'profile_tx_out', 'topic' from dual  union 
select 'rto_graph', 'streaming.smart_replication_change_request_tbcvsofk_default', 'topic' from dual  union 
select 'rto_graph', 'uasp_dko_83088_way4_mdm_enrich_2150~way4_new_stream', 'flink_srv' from dual  union 
select 'rto_graph', 'uasp_dko_83088_way4_mdm_enrich_2150~way4_old_stream', 'flink_srv' from dual  union 
select 'rto_graph', 'uasp_dko_83088_way4_mdm_enrich~way4_new', 'flink_srv' from dual  union 
select 'rto_graph', 'uasp_dko_83088_way4_mdm_enrich~way4_old_stream', 'flink_srv' from dual  union 
select 'rto_graph', 'uasp-dko-rds-63902-accr-reciver~main', 'flink_srv' from dual  union 
select 'rto_graph', 'uasp-kriaa-bevents-case-2~main', 'flink_srv' from dual  union 
select 'rto_graph', 'uasp-kriaa-bevents-case-40~main', 'flink_srv' from dual  union 
select 'rto_graph', 'uasp-kriaa-bevents-case-55~main', 'flink_srv' from dual  union 
select 'rto_graph', 'uasp-kriaa-bevents-case-56~main', 'flink_srv' from dual  union 
select 'rto_graph', 'uasp-kriaa-bevents-case-57~main', 'flink_srv' from dual  union 
select 'rto_graph', 'uasp-kriaa-bevents-case-68~main', 'flink_srv' from dual  union 
select 'rto_graph', 'uasp-kriaa-bevents-case-70~main', 'flink_srv' from dual  union 
select 'rto_graph', 'uasp-kriaa-bevents-case-84~main', 'flink_srv' from dual  union 
select 'rto_graph', 'uasp-kriaa-bevents-case-86~main', 'flink_srv' from dual  union 
select 'rto_graph', 'uasp-kriaa-bevents-insurence-cft~main', 'flink_srv' from dual  union 
select 'rto_graph', 'uasp-kriaa-bevents-insurence-kn~main', 'flink_srv' from dual  union 
select 'rto_graph', 'uasp-kriaa-bevents-monitor~test', 'flink_srv' from dual  union 
select 'rto_graph', 'uasp-streaming-aggregate~aggregate-dko', 'flink_srv' from dual  union 
select 'rto_graph', 'uasp-streaming-beg-card-block~credit-card', 'flink_srv' from dual  union 
select 'rto_graph', 'uasp-streaming-beg-pincode-change~credit-card', 'flink_srv' from dual  union 
select 'rto_graph', 'uasp-streaming-cc-activation~credit-card', 'flink_srv' from dual  union 
select 'rto_graph', 'uasp-streaming-currency-enrichment~case68', 'flink_srv' from dual  union 
select 'rto_graph', 'uasp-streaming-currency-enrichment~first-salary', 'flink_srv' from dual  union 
select 'rto_graph', 'uasp-streaming-filter~bevents-filter', 'flink_srv' from dual  union 
select 'rto_graph', 'uasp-streaming-filter~main-input-filter', 'flink_srv' from dual  union 
select 'rto_graph', 'uasp-streaming-input-convertor~customer-package', 'flink_srv' from dual  union 
select 'rto_graph', 'uasp-streaming-input-convertor~customer-profile-full', 'flink_srv' from dual  union 
select 'rto_graph', 'uasp-streaming-input-convertor~input-convertor-ca-cardfl', 'flink_srv' from dual  union 
select 'rto_graph', 'uasp-streaming-input-convertor~input-convertor-ca-depositfl', 'flink_srv' from dual  union 
select 'rto_graph', 'uasp-streaming-input-convertor~input-convertor-ca-first-salary', 'flink_srv' from dual  union 
select 'rto_graph', 'uasp-streaming-input-convertor~input-convertor-cardfl', 'flink_srv' from dual  union 
select 'rto_graph', 'uasp-streaming-input-convertor~input-convertor-cft', 'flink_srv' from dual  union 
select 'rto_graph', 'uasp-streaming-input-convertor~input-convertor-mdm', 'flink_srv' from dual  union 
select 'rto_graph', 'uasp-streaming-input-convertor~input-convertor-prof-auth', 'flink_srv' from dual  union 
select 'rto_graph', 'uasp-streaming-input-convertor~input-convertor-profile', 'flink_srv' from dual  union 
select 'rto_graph', 'uasp-streaming-input-convertor~input-convertor-udds', 'flink_srv' from dual  union 
select 'rto_graph', 'uasp-streaming-input-convertor~input-convertor-w4-operation', 'flink_srv' from dual  union 
select 'rto_graph', 'uasp-streaming-input-convertor~input-convertor-withdraw', 'flink_srv' from dual  union 
select 'rto_graph', 'uasp-streaming-input-convertor~loyalty', 'flink_srv' from dual  union 
select 'rto_graph', 'uasp-streaming-input-convertor~mdm-profile', 'flink_srv' from dual  union 
select 'rto_graph', 'uasp-streaming-json-validator~insurance', 'flink_srv' from dual  union 
select 'rto_graph', 'uasp-streaming-json-validator~kn', 'flink_srv' from dual  union 
select 'rto_graph', 'uasp-streaming-json-validator~uz', 'flink_srv' from dual  union 
select 'rto_graph', 'uasp-streaming-mdm-enrichment~case-68', 'flink_srv' from dual  union 
select 'rto_graph', 'uasp-streaming-mdm-enrichment~case-68_agrement', 'flink_srv' from dual  union 
select 'rto_graph', 'uasp-streaming-mdm-enrichment~prof-auth', 'flink_srv' from dual  union 
select 'rto_graph', 'uasp-streaming-mdm-enrichment~prof-auth-packNM', 'flink_srv' from dual  union 
select 'rto_graph', 'uasp-streaming-mdm-enrichment~profile-tx-step1', 'flink_srv' from dual  union 
select 'rto_graph', 'uasp-streaming-mdm-enrichment~profile-tx-step2', 'flink_srv' from dual  union 
select 'rto_graph', 'uasp-streaming-mdm-enrichment~prof-tx-case-71', 'flink_srv' from dual  union 
select 'rto_graph', 'uasp-streaming-mdm-enrichment~way4', 'flink_srv' from dual  union 
select 'rto_graph', 'uasp-streaming-mdm-enrichment~way4-card-agreement', 'flink_srv' from dual  union 
select 'rto_graph', 'uasp-streaming-model-vector~model-vector-bevents', 'flink_srv' from dual  union 
select 'rto_graph', 'uasp-streaming-mutator~case-48-concatenate', 'flink_srv' from dual  union 
select 'rto_graph', 'uasp-streaming-mutator~mainInput', 'flink_srv' from dual  union 
select 'rto_graph', 'uasp-streaming-mutator~rateMutate', 'flink_srv' from dual  union 
select 'rto_graph', 'uasp-streaming-mutator~uddsRate', 'flink_srv' from dual  union 
select 'rto_graph', 'uasp-streaming-refunds-event-notifier~main', 'flink_srv' from dual  union 
select 'rto_graph', 'uasp-streaming-rto-15~uasp-streaming-rto-15', 'flink_srv' from dual  union 
select 'rto_graph', 'uasp-streaming-rto-37~uasp-streaming-rto-37', 'flink_srv' from dual  union 
select 'rto_graph', 'uasp-streaming-rto-attempt-close-part2~uasp-streaming-rto-attempt-close-part2', 'flink_srv' from dual  union 
select 'rto_graph', 'uasp-streaming-rto-bcps-card-emission-digital~uasp-streaming-rto-bcps-card-emission-digital', 'flink_srv' from dual  union 
select 'rto_graph', 'uasp-streaming-rto-bcps-card-emission-digital~uasp-streaming-rto-bcps-card-emission-digital-mock-test', 'flink_srv' from dual  union 
select 'rto_graph', 'uasp-streaming-rto-bcps-status-change~ uasp-streaming-rto-bcps-status-change', 'flink_srv' from dual  union 
select 'rto_graph', 'uasp-streaming-rto-bcps-status-change~uasp-streaming-rto-bcps-status-change', 'flink_srv' from dual  union 
select 'rto_graph', 'uasp-streaming-rto-bcps-status-change~uasp-streaming-rto-bcps-status-change-mock-test', 'flink_srv' from dual  union 
select 'rto_graph', 'uasp-streaming-rto-card-activation-way4~uasp-streaming-rto-card-activation-way4', 'flink_srv' from dual  union 
select 'rto_graph', 'uasp-streaming-rto-card-activation-way4~uasp-streaming-rto-card-activation-way4-mock-test', 'flink_srv' from dual  union 
select 'rto_graph', 'uasp-streaming-rto-closing-deposit~uasp-streaming-rto-closing-deposit', 'flink_srv' from dual  union 
select 'rto_graph', 'uasp-streaming-rto-dko-4_62~uasp-streaming-rto-dko-4_62', 'flink_srv' from dual  union 
select 'rto_graph', 'uasp-streaming-rto-mortgage-approval~uasp-streaming-rto-mortgage-approval-prod', 'flink_srv' from dual  union 
select 'rto_graph', 'uasp-streaming-rto-open-deposit~uasp-streaming-rto-open-deposit', 'flink_srv' from dual  union 
select 'rto_graph', 'uasp-streaming-rto-status-execution-goal~uasp-streaming-rto-status-execution-goal', 'flink_srv' from dual  union 
select 'rto_graph', 'uasp-streaming-rto-zoc~uasp-streaming-rto-zoc', 'flink_srv' from dual  union 
select 'rto_graph', 'uasp-streaming-unp-convertor~aggregate-ca', 'flink_srv' from dual  union 
select 'rto_graph', 'uasp-streaming-unp-convertor~cardfl', 'flink_srv' from dual  union 
select 'rto_graph', 'uasp-streaming-unp-convertor~case68', 'flink_srv' from dual  union 
select 'rto_graph', 'uasp-streaming-unp-convertor~cbr-rate', 'flink_srv' from dual  union 
select 'rto_graph', 'uasp-streaming-unp-convertor~cft-transactions', 'flink_srv' from dual  union 
select 'rto_graph', 'uasp-streaming-unp-convertor~outer-cbr-rate', 'flink_srv' from dual  union 
select 'rto_graph', 'uasp-streaming-unp-convertor~profile-auth', 'flink_srv' from dual  union 
select 'rto_graph', 'uasp-streaming-unp-convertor~profile-transactions', 'flink_srv' from dual  union 
select 'rto_graph', 'uasp-streaming-unp-convertor~udds-3to8', 'flink_srv' from dual  union 
select 'rto_graph', 'uasp-streaming-unp-convertor~unp_w4_issuing_card', 'flink_srv' from dual  union 
select 'rto_graph', 'uasp-streaming-unp-convertor~w4-account-balance', 'flink_srv' from dual  union 
select 'rto_graph', 'uasp-streaming-unp-convertor~way4-main', 'flink_srv' from dual  union 
select 'rto_graph', 'uasp-streaming-unp-convertor~way4-transactions', 'flink_srv' from dual  union 
select 'rto_graph', 'uasp-streaming-unp-convertor~withdraw-transactions', 'flink_srv' from dual  union 
select 'rto_graph', 'UNP_PROFILE_AUTH', 'topic' from dual  union 
select 'rto_graph', 'withdraw_tx_out', 'topic' from dual ;

insert into dict_group(description, id) 
select 'bevents-streaming-aggregate-first-salary_aggregate-bevents', 'bevents-streaming-aggregate-first-salary_aggregate-bevents' from dual  union 
select 'bevents-streaming-aggregate-first-salary_aggregate-bevents-56-57', 'bevents-streaming-aggregate-first-salary_aggregate-bevents-56-57' from dual  union 
select 'rto_graph', 'rto_graph' from dual  union 
select 'uasp_dko_83088_way4_mdm_enrich_2150_way4_new_stream', 'uasp_dko_83088_way4_mdm_enrich_2150_way4_new_stream' from dual  union 
select 'uasp_dko_83088_way4_mdm_enrich_2150_way4_old_stream', 'uasp_dko_83088_way4_mdm_enrich_2150_way4_old_stream' from dual  union 
select 'uasp_dko_83088_way4_mdm_enrich_83088_way4_mdm_enrich_new', 'uasp_dko_83088_way4_mdm_enrich_83088_way4_mdm_enrich_new' from dual  union 
select 'uasp_dko_83088_way4_mdm_enrich_83088_way4_mdm_enrich_old', 'uasp_dko_83088_way4_mdm_enrich_83088_way4_mdm_enrich_old' from dual  union 
select 'uasp_dko_83088_way4_mdm_enrich_83088_way4_new', 'uasp_dko_83088_way4_mdm_enrich_83088_way4_new' from dual  union 
select 'uasp_dko_83088_way4_mdm_enrich_83088_way4_old', 'uasp_dko_83088_way4_mdm_enrich_83088_way4_old' from dual  union 
select 'uasp_dko_83088_way4_mdm_enrich_way4_new', 'uasp_dko_83088_way4_mdm_enrich_way4_new' from dual  union 
select 'uasp_dko_83088_way4_mdm_enrich_way4_old', 'uasp_dko_83088_way4_mdm_enrich_way4_old' from dual  union 
select 'uasp_dko_83088_way4_mdm_enrich_way4_old_stream', 'uasp_dko_83088_way4_mdm_enrich_way4_old_stream' from dual  union 
select 'uasp-dko-rds-63902-accr-reciver_main', 'uasp-dko-rds-63902-accr-reciver_main' from dual  union 
select 'uasp-kriaa-bevents-case-2_main', 'uasp-kriaa-bevents-case-2_main' from dual  union 
select 'uasp-kriaa-bevents-case-40_main', 'uasp-kriaa-bevents-case-40_main' from dual  union 
select 'uasp-kriaa-bevents-case-55_main', 'uasp-kriaa-bevents-case-55_main' from dual  union 
select 'uasp-kriaa-bevents-case-56_main', 'uasp-kriaa-bevents-case-56_main' from dual  union 
select 'uasp-kriaa-bevents-case-57_main', 'uasp-kriaa-bevents-case-57_main' from dual  union 
select 'uasp-kriaa-bevents-case-68_main', 'uasp-kriaa-bevents-case-68_main' from dual  union 
select 'uasp-kriaa-bevents-case-70_main', 'uasp-kriaa-bevents-case-70_main' from dual  union 
select 'uasp-kriaa-bevents-case-84_main', 'uasp-kriaa-bevents-case-84_main' from dual  union 
select 'uasp-kriaa-bevents-case-86_main', 'uasp-kriaa-bevents-case-86_main' from dual  union 
select 'uasp-kriaa-bevents-insurence-cft_main', 'uasp-kriaa-bevents-insurence-cft_main' from dual  union 
select 'uasp-kriaa-bevents-insurence-kn_main', 'uasp-kriaa-bevents-insurence-kn_main' from dual  union 
select 'uasp-kriaa-bevents-monitor_test', 'uasp-kriaa-bevents-monitor_test' from dual  union 
select 'uasp-streaming-aggregate_aggregate-dko', 'uasp-streaming-aggregate_aggregate-dko' from dual  union 
select 'uasp-streaming-beg-card-block_credit-card', 'uasp-streaming-beg-card-block_credit-card' from dual  union 
select 'uasp-streaming-beg-pincode-change_credit-card', 'uasp-streaming-beg-pincode-change_credit-card' from dual  union 
select 'uasp-streaming-cc-activation_credit-card', 'uasp-streaming-cc-activation_credit-card' from dual  union 
select 'uasp-streaming-currency-enrichment_case68', 'uasp-streaming-currency-enrichment_case68' from dual  union 
select 'uasp-streaming-currency-enrichment_first-salary', 'uasp-streaming-currency-enrichment_first-salary' from dual  union 
select 'uasp-streaming-filter_bevents-filter', 'uasp-streaming-filter_bevents-filter' from dual  union 
select 'uasp-streaming-filter_main-input-filter', 'uasp-streaming-filter_main-input-filter' from dual  union 
select 'uasp-streaming-input-convertor_close_account', 'uasp-streaming-input-convertor_close_account' from dual  union 
select 'uasp-streaming-input-convertor_customer-package', 'uasp-streaming-input-convertor_customer-package' from dual  union 
select 'uasp-streaming-input-convertor_customer-profile-full', 'uasp-streaming-input-convertor_customer-profile-full' from dual  union 
select 'uasp-streaming-input-convertor_input-convertor-ca-cardfl', 'uasp-streaming-input-convertor_input-convertor-ca-cardfl' from dual  union 
select 'uasp-streaming-input-convertor_input-convertor-ca-depositfl', 'uasp-streaming-input-convertor_input-convertor-ca-depositfl' from dual  union 
select 'uasp-streaming-input-convertor_input-convertor-ca-first-salary', 'uasp-streaming-input-convertor_input-convertor-ca-first-salary' from dual  union 
select 'uasp-streaming-input-convertor_input-convertor-cardfl', 'uasp-streaming-input-convertor_input-convertor-cardfl' from dual  union 
select 'uasp-streaming-input-convertor_input-convertor-cft', 'uasp-streaming-input-convertor_input-convertor-cft' from dual  union 
select 'uasp-streaming-input-convertor_input-convertor-mdm', 'uasp-streaming-input-convertor_input-convertor-mdm' from dual  union 
select 'uasp-streaming-input-convertor_input-convertor-prof-auth', 'uasp-streaming-input-convertor_input-convertor-prof-auth' from dual  union 
select 'uasp-streaming-input-convertor_input-convertor-profile', 'uasp-streaming-input-convertor_input-convertor-profile' from dual  union 
select 'uasp-streaming-input-convertor_input-convertor-udds', 'uasp-streaming-input-convertor_input-convertor-udds' from dual  union 
select 'uasp-streaming-input-convertor_input-convertor-w4-operation', 'uasp-streaming-input-convertor_input-convertor-w4-operation' from dual  union 
select 'uasp-streaming-input-convertor_input-convertor-withdraw', 'uasp-streaming-input-convertor_input-convertor-withdraw' from dual  union 
select 'uasp-streaming-input-convertor_loyalty', 'uasp-streaming-input-convertor_loyalty' from dual  union 
select 'uasp-streaming-input-convertor_mdm-profile', 'uasp-streaming-input-convertor_mdm-profile' from dual  union 
select 'uasp-streaming-input-convertor_way4-convertor', 'uasp-streaming-input-convertor_way4-convertor' from dual  union 
select 'uasp-streaming-json-validator_insurance', 'uasp-streaming-json-validator_insurance' from dual  union 
select 'uasp-streaming-json-validator_kn', 'uasp-streaming-json-validator_kn' from dual  union 
select 'uasp-streaming-json-validator_uz', 'uasp-streaming-json-validator_uz' from dual  union 
select 'uasp-streaming-mdm-enrichment_case-68', 'uasp-streaming-mdm-enrichment_case-68' from dual  union 
select 'uasp-streaming-mdm-enrichment_case-68_agrement', 'uasp-streaming-mdm-enrichment_case-68_agrement' from dual  union 
select 'uasp-streaming-mdm-enrichment_prof-auth', 'uasp-streaming-mdm-enrichment_prof-auth' from dual  union 
select 'uasp-streaming-mdm-enrichment_prof-auth-packNM', 'uasp-streaming-mdm-enrichment_prof-auth-packNM' from dual  union 
select 'uasp-streaming-mdm-enrichment_profile-tx-step1', 'uasp-streaming-mdm-enrichment_profile-tx-step1' from dual  union 
select 'uasp-streaming-mdm-enrichment_profile-tx-step2', 'uasp-streaming-mdm-enrichment_profile-tx-step2' from dual  union 
select 'uasp-streaming-mdm-enrichment_prof-tx-case-71', 'uasp-streaming-mdm-enrichment_prof-tx-case-71' from dual  union 
select 'uasp-streaming-mdm-enrichment_way4', 'uasp-streaming-mdm-enrichment_way4' from dual  union 
select 'uasp-streaming-mdm-enrichment_way4-card-agreement', 'uasp-streaming-mdm-enrichment_way4-card-agreement' from dual  union 
select 'uasp-streaming-model-vector_model-vector-bevents', 'uasp-streaming-model-vector_model-vector-bevents' from dual  union 
select 'uasp-streaming-mutator_case-48-concatenate', 'uasp-streaming-mutator_case-48-concatenate' from dual  union 
select 'uasp-streaming-mutator_mainInput', 'uasp-streaming-mutator_mainInput' from dual  union 
select 'uasp-streaming-mutator_rateMutate', 'uasp-streaming-mutator_rateMutate' from dual  union 
select 'uasp-streaming-mutator_uddsRate', 'uasp-streaming-mutator_uddsRate' from dual  union 
select 'uasp-streaming-refunds-event-notifier_main', 'uasp-streaming-refunds-event-notifier_main' from dual  union 
select 'uasp-streaming-rto-15_uasp-streaming-rto-15', 'uasp-streaming-rto-15_uasp-streaming-rto-15' from dual  union 
select 'uasp-streaming-rto-37_uasp-streaming-rto-37', 'uasp-streaming-rto-37_uasp-streaming-rto-37' from dual  union 
select 'uasp-streaming-rto-attempt-close-part2_uasp-streaming-rto-attempt-close-part2', 'uasp-streaming-rto-attempt-close-part2_uasp-streaming-rto-attempt-close-part2' from dual  union 
select 'uasp-streaming-rto-bcps-card-emission-digital_uasp-streaming-rto-bcps-card-emission-digital', 'uasp-streaming-rto-bcps-card-emission-digital_uasp-streaming-rto-bcps-card-emission-digital' from dual  union 
select 'uasp-streaming-rto-bcps-card-emission-digital_uasp-streaming-rto-bcps-card-emission-digital-mock-test', 'uasp-streaming-rto-bcps-card-emission-digital_uasp-streaming-rto-bcps-card-emission-digital-mock-test' from dual  union 
select 'uasp-streaming-rto-bcps-status-change_uasp-streaming-rto-bcps-status-change', 'uasp-streaming-rto-bcps-status-change_uasp-streaming-rto-bcps-status-change' from dual  union 
select 'uasp-streaming-rto-bcps-status-change_uasp-streaming-rto-bcps-status-change-mock-test', 'uasp-streaming-rto-bcps-status-change_uasp-streaming-rto-bcps-status-change-mock-test' from dual  union 
select 'uasp-streaming-rto-card-activation-way4_uasp-streaming-rto-card-activation-way4', 'uasp-streaming-rto-card-activation-way4_uasp-streaming-rto-card-activation-way4' from dual  union 
select 'uasp-streaming-rto-card-activation-way4_uasp-streaming-rto-card-activation-way4-mock-test', 'uasp-streaming-rto-card-activation-way4_uasp-streaming-rto-card-activation-way4-mock-test' from dual  union 
select 'uasp-streaming-rto-closing-deposit_uasp-streaming-rto-closing-deposit', 'uasp-streaming-rto-closing-deposit_uasp-streaming-rto-closing-deposit' from dual  union 
select 'uasp-streaming-rto-dko-4_62_uasp-streaming-rto-dko-4_62', 'uasp-streaming-rto-dko-4_62_uasp-streaming-rto-dko-4_62' from dual  union 
select 'uasp-streaming-rto-mortgage-approval_uasp-streaming-rto-mortgage-approval', 'uasp-streaming-rto-mortgage-approval_uasp-streaming-rto-mortgage-approval' from dual  union 
select 'uasp-streaming-rto-mortgage-approval_uasp-streaming-rto-mortgage-approval-prod', 'uasp-streaming-rto-mortgage-approval_uasp-streaming-rto-mortgage-approval-prod' from dual  union 
select 'uasp-streaming-rto-ofvs_uasp-streaming-rto-ofvs', 'uasp-streaming-rto-ofvs_uasp-streaming-rto-ofvs' from dual  union 
select 'uasp-streaming-rto-open-deposit_uasp-streaming-rto-open-deposit', 'uasp-streaming-rto-open-deposit_uasp-streaming-rto-open-deposit' from dual  union 
select 'uasp-streaming-rto-status-execution-goal_uasp-streaming-rto-status-execution-goal', 'uasp-streaming-rto-status-execution-goal_uasp-streaming-rto-status-execution-goal' from dual  union 
select 'uasp-streaming-rto-zoc_uasp-streaming-rto-zoc', 'uasp-streaming-rto-zoc_uasp-streaming-rto-zoc' from dual  union 
select 'uasp-streaming-unp-convertor_aggregate-ca', 'uasp-streaming-unp-convertor_aggregate-ca' from dual  union 
select 'uasp-streaming-unp-convertor_cardfl', 'uasp-streaming-unp-convertor_cardfl' from dual  union 
select 'uasp-streaming-unp-convertor_case68', 'uasp-streaming-unp-convertor_case68' from dual  union 
select 'uasp-streaming-unp-convertor_cbr-rate', 'uasp-streaming-unp-convertor_cbr-rate' from dual  union 
select 'uasp-streaming-unp-convertor_cft-transactions', 'uasp-streaming-unp-convertor_cft-transactions' from dual  union 
select 'uasp-streaming-unp-convertor_close_account', 'uasp-streaming-unp-convertor_close_account' from dual  union 
select 'uasp-streaming-unp-convertor_outer-cbr-rate', 'uasp-streaming-unp-convertor_outer-cbr-rate' from dual  union 
select 'uasp-streaming-unp-convertor_profile-auth', 'uasp-streaming-unp-convertor_profile-auth' from dual  union 
select 'uasp-streaming-unp-convertor_profile-transactions', 'uasp-streaming-unp-convertor_profile-transactions' from dual  union 
select 'uasp-streaming-unp-convertor_udds-3to8', 'uasp-streaming-unp-convertor_udds-3to8' from dual  union 
select 'uasp-streaming-unp-convertor_unp_w4_issuing_card', 'uasp-streaming-unp-convertor_unp_w4_issuing_card' from dual  union 
select 'uasp-streaming-unp-convertor_w4-account-balance', 'uasp-streaming-unp-convertor_w4-account-balance' from dual  union 
select 'uasp-streaming-unp-convertor_way4-main', 'uasp-streaming-unp-convertor_way4-main' from dual  union 
select 'uasp-streaming-unp-convertor_way4-transactions', 'uasp-streaming-unp-convertor_way4-transactions' from dual  union 
select 'uasp-streaming-unp-convertor_withdraw-transactions', 'uasp-streaming-unp-convertor_withdraw-transactions' from dual ;

insert into dict_kafka_prop(prop_id, type_prop) 
select 'acks', 'prd' from dual  union 
select 'auto.offset.reset', 'cns' from dual  union 
select 'bootstrap.servers', 'cns' from dual  union 
select 'bootstrap.servers', 'prd' from dual  union 
select 'check.crcs', 'cns' from dual  union 
select 'connections.max.idle.ms', 'cns' from dual  union 
select 'enable.auto.commit', 'cns' from dual  union 
select 'enable.idempotence', 'prd' from dual  union 
select 'exclude.internal.topics', 'cns' from dual  union 
select 'fetch.max.bytes', 'cns' from dual  union 
select 'fetch.max.wait.ms', 'cns' from dual  union 
select 'fetch.min.bytes', 'cns' from dual  union 
select 'group.id', 'cns' from dual  union 
select 'heartbeat.interval.ms', 'cns' from dual  union 
select 'isolation.level', 'cns' from dual  union 
select 'key.serializer', 'prd' from dual  union 
select 'max.block.ms', 'prd' from dual  union 
select 'retries', 'prd' from dual  union 
select 'security.protocol', 'cns' from dual  union 
select 'security.protocol', 'prd' from dual  union 
select 'session.timeout.ms', 'cns' from dual  union 
select 'ssl.key.password', 'cns' from dual  union 
select 'ssl.key.password', 'prd' from dual  union 
select 'ssl.keystore.location', 'cns' from dual  union 
select 'ssl.keystore.location', 'prd' from dual  union 
select 'ssl.keystore.password', 'cns' from dual  union 
select 'ssl.keystore.password', 'prd' from dual  union 
select 'ssl.keystore.type', 'cns' from dual  union 
select 'ssl.keystore.type', 'prd' from dual  union 
select 'ssl.truststore.location', 'cns' from dual  union 
select 'ssl.truststore.location', 'prd' from dual  union 
select 'ssl.truststore.password', 'cns' from dual  union 
select 'ssl.truststore.password', 'prd' from dual  union 
select 'ssl.truststore.type', 'cns' from dual  union 
select 'ssl.truststore.type', 'prd' from dual  union 
select 'transactional.id', 'prd' from dual  union 
select 'transaction.timeout.ms', 'prd' from dual  union 
select 'value.serializer', 'prd' from dual ;

insert into dict_kafka_property_grp(description, id, type_read) 
select 'загрузка сообщений начиная с офсета, который запомнила кафка', 'latest', 'cns' from dual  union 
select 'Самый идемпотентный продюсер', 'producer_idempotence', 'prd' from dual  union 
select 'Producer to CbrRateKafka', 'producer_CBR_RATE', 'prd' from dual  union 
select 'Загрузка всех сообщений топика с самого начала', 'earliest_DATA_PLATFORM', 'cns' from dual  union 
select 'Загрузка всех сообщений топика с самого начала', 'earliest_CARDFL_BOOTSTRAP_SERVERS', 'cns' from dual  union 
select 'Внешняя кафка GF для UNP convertor, загрузка сообщений начиная с офсета, который запомнила кафка', 'gf_latest', 'cns' from dual  union 
select 'Самый простой и минималистичный продюсер', 'producer_default', 'prd' from dual  union 
select 'Загрузка всех сообщений топика с самого начала', 'earliest', 'cns' from dual  union 
select 'загрузка сообщений начиная с офсета, который запомнила кафка', 'latest_DATA_PLATFORM', 'cns' from dual ;

insert into dict_place_holder(default_value, description, id) 
select '${BOOTSTRAP_SERVERS}', 'BOOTSTRAP_SERVERS', 'BOOTSTRAP_SERVERS' from dual  union 
select '${CARD_NUMBER_SHA_256_SALT}', 'CARD_NUMBER_SHA_256_SALT', 'CARD_NUMBER_SHA_256_SALT' from dual  union 
select '${DSO_CARDFL_BOOTSTRAP_SERVERS}', 'DSO_CARDFL_BOOTSTRAP_SERVERS', 'DSO_CARDFL_BOOTSTRAP_SERVERS' from dual  union 
select '${DSO_GF_IFWAYN_BOOTSTRAP_SERVERS}', 'DSO_GF_IFWAYN_BOOTSTRAP_SERVERS', 'DSO_GF_IFWAYN_BOOTSTRAP_SERVERS' from dual  union 
select '${DSO_GF_IFWAYN_KEYSTORE_LOCATION}', 'DSO_GF_IFWAYN_KEYSTORE_LOCATION', 'DSO_GF_IFWAYN_KEYSTORE_LOCATION' from dual  union 
select '${DSO_GF_IFWAYN_SSL_KEY_PASSWORD}', 'DSO_GF_IFWAYN_SSL_KEY_PASSWORD', 'DSO_GF_IFWAYN_SSL_KEY_PASSWORD' from dual  union 
select '${DSO_GF_IFWAYN_SSL_KEYSTORE_PASSWORD}', 'DSO_GF_IFWAYN_SSL_KEYSTORE_PASSWORD', 'DSO_GF_IFWAYN_SSL_KEYSTORE_PASSWORD' from dual  union 
select '${DSO_GF_IFWAYN_SSL_TRUSTSTORE_PASSWORD}', 'DSO_GF_IFWAYN_SSL_TRUSTSTORE_PASSWORD', 'DSO_GF_IFWAYN_SSL_TRUSTSTORE_PASSWORD' from dual  union 
select '${DSO_GF_IFWAYN_TRUSTSTORE_LOCATION}', 'DSO_GF_IFWAYN_TRUSTSTORE_LOCATION', 'DSO_GF_IFWAYN_TRUSTSTORE_LOCATION' from dual  union 
select '${DSO_KAFKA_SSL_KEY_PASSWORD}', 'DSO_KAFKA_SSL_KEY_PASSWORD', 'DSO_KAFKA_SSL_KEY_PASSWORD' from dual  union 
select '${DSO_KAFKA_SSL_KEYSTORE_PASSWORD}', 'DSO_KAFKA_SSL_KEYSTORE_PASSWORD', 'DSO_KAFKA_SSL_KEYSTORE_PASSWORD' from dual  union 
select '${DSO_KAFKA_SSL_TRUSTSTORE_PASSWORD}', 'DSO_KAFKA_SSL_TRUSTSTORE_PASSWORD', 'DSO_KAFKA_SSL_TRUSTSTORE_PASSWORD' from dual  union 
select '${IFT_CARDFL_BOOTSTRAP_SERVERS}', 'IFT_CARDFL_BOOTSTRAP_SERVERS', 'IFT_CARDFL_BOOTSTRAP_SERVERS' from dual  union 
select '${IFT_CARD_NUMBER_SHA_256_SALT}', 'IFT_CARD_NUMBER_SHA_256_SALT', 'IFT_CARD_NUMBER_SHA_256_SALT' from dual  union 
select '${IFT_GF_IFWAYN_BOOTSTRAP_SERVERS}', 'IFT_GF_IFWAYN_BOOTSTRAP_SERVERS', 'IFT_GF_IFWAYN_BOOTSTRAP_SERVERS' from dual  union 
select '${IFT_GF_IFWAYN_KEYSTORE_LOCATION}', 'IFT_GF_IFWAYN_KEYSTORE_LOCATION', 'IFT_GF_IFWAYN_KEYSTORE_LOCATION' from dual  union 
select '${IFT_GF_IFWAYN_SSL_KEY_PASSWORD}', 'IFT_GF_IFWAYN_SSL_KEY_PASSWORD', 'IFT_GF_IFWAYN_SSL_KEY_PASSWORD' from dual  union 
select '${IFT_GF_IFWAYN_SSL_KEYSTORE_PASSWORD}', 'IFT_GF_IFWAYN_SSL_KEYSTORE_PASSWORD', 'IFT_GF_IFWAYN_SSL_KEYSTORE_PASSWORD' from dual  union 
select '${IFT_GF_IFWAYN_SSL_TRUSTSTORE_PASSWORD}', 'IFT_GF_IFWAYN_SSL_TRUSTSTORE_PASSWORD', 'IFT_GF_IFWAYN_SSL_TRUSTSTORE_PASSWORD' from dual  union 
select '${IFT_GF_IFWAYN_TRUSTSTORE_LOCATION}', 'IFT_GF_IFWAYN_TRUSTSTORE_LOCATION', 'IFT_GF_IFWAYN_TRUSTSTORE_LOCATION' from dual  union 
select '${IFT_KAFKA_SSL_KEY_PASSWORD}', 'IFT_KAFKA_SSL_KEY_PASSWORD', 'IFT_KAFKA_SSL_KEY_PASSWORD' from dual  union 
select '${IFT_KAFKA_SSL_KEYSTORE_PASSWORD}', 'IFT_KAFKA_SSL_KEYSTORE_PASSWORD', 'IFT_KAFKA_SSL_KEYSTORE_PASSWORD' from dual  union 
select '${IFT_KAFKA_SSL_TRUSTSTORE_PASSWORD}', 'IFT_KAFKA_SSL_TRUSTSTORE_PASSWORD', 'IFT_KAFKA_SSL_TRUSTSTORE_PASSWORD' from dual  union 
select '${KEYSTORE_LOCATION}', 'KEYSTORE_LOCATION', 'KEYSTORE_LOCATION' from dual  union 
select '${NT_CARD_NUMBER_SHA_256_SALT}', 'NT_CARD_NUMBER_SHA_256_SALT', 'NT_CARD_NUMBER_SHA_256_SALT' from dual  union 
select '${NT_GF_IFWAYN_BOOTSTRAP_SERVERS}', 'NT_GF_IFWAYN_BOOTSTRAP_SERVERS', 'NT_GF_IFWAYN_BOOTSTRAP_SERVERS' from dual  union 
select '${NT_GF_IFWAYN_KEYSTORE_LOCATION}', 'NT_GF_IFWAYN_KEYSTORE_LOCATION', 'NT_GF_IFWAYN_KEYSTORE_LOCATION' from dual  union 
select '${NT_GF_IFWAYN_SSL_KEY_PASSWORD}', 'NT_GF_IFWAYN_SSL_KEY_PASSWORD', 'NT_GF_IFWAYN_SSL_KEY_PASSWORD' from dual  union 
select '${NT_GF_IFWAYN_SSL_KEYSTORE_PASSWORD}', 'NT_GF_IFWAYN_SSL_KEYSTORE_PASSWORD', 'NT_GF_IFWAYN_SSL_KEYSTORE_PASSWORD' from dual  union 
select '${NT_GF_IFWAYN_SSL_TRUSTSTORE_PASSWORD}', 'NT_GF_IFWAYN_SSL_TRUSTSTORE_PASSWORD', 'NT_GF_IFWAYN_SSL_TRUSTSTORE_PASSWORD' from dual  union 
select '${NT_GF_IFWAYN_TRUSTSTORE_LOCATION}', 'NT_GF_IFWAYN_TRUSTSTORE_LOCATION', 'NT_GF_IFWAYN_TRUSTSTORE_LOCATION' from dual  union 
select '${NT_KAFKA_SSL_KEY_PASSWORD}', 'NT_KAFKA_SSL_KEY_PASSWORD', 'NT_KAFKA_SSL_KEY_PASSWORD' from dual  union 
select '${NT_KAFKA_SSL_KEYSTORE_PASSWORD}', 'NT_KAFKA_SSL_KEYSTORE_PASSWORD', 'NT_KAFKA_SSL_KEYSTORE_PASSWORD' from dual  union 
select '${NT_KAFKA_SSL_TRUSTSTORE_PASSWORD}', 'NT_KAFKA_SSL_TRUSTSTORE_PASSWORD', 'NT_KAFKA_SSL_TRUSTSTORE_PASSWORD' from dual  union 
select '${P0_CARDFL_BOOTSTRAP_SERVERS}', 'P0_CARDFL_BOOTSTRAP_SERVERS', 'P0_CARDFL_BOOTSTRAP_SERVERS' from dual  union 
select '${P0_CARD_NUMBER_SHA_256_SALT}', 'P0_CARD_NUMBER_SHA_256_SALT', 'P0_CARD_NUMBER_SHA_256_SALT' from dual  union 
select '${P0_DATA_PLATFORM_BOOTSTRAP_SERVERS}', 'P0_DATA_PLATFORM_BOOTSTRAP_SERVERS', 'P0_DATA_PLATFORM_BOOTSTRAP_SERVERS' from dual  union 
select '${P0_GF_IFWAYN_BOOTSTRAP_SERVERS}', 'P0_GF_IFWAYN_BOOTSTRAP_SERVERS', 'P0_GF_IFWAYN_BOOTSTRAP_SERVERS' from dual  union 
select '${P0_GF_IFWAYN_KEYSTORE_LOCATION}', 'P0_GF_IFWAYN_KEYSTORE_LOCATION', 'P0_GF_IFWAYN_KEYSTORE_LOCATION' from dual  union 
select '${P0_GF_IFWAYN_SSL_KEY_PASSWORD}', 'P0_GF_IFWAYN_SSL_KEY_PASSWORD', 'P0_GF_IFWAYN_SSL_KEY_PASSWORD' from dual  union 
select '${P0_GF_IFWAYN_SSL_KEYSTORE_PASSWORD}', 'P0_GF_IFWAYN_SSL_KEYSTORE_PASSWORD', 'P0_GF_IFWAYN_SSL_KEYSTORE_PASSWORD' from dual  union 
select '${P0_GF_IFWAYN_SSL_TRUSTSTORE_PASSWORD}', 'P0_GF_IFWAYN_SSL_TRUSTSTORE_PASSWORD', 'P0_GF_IFWAYN_SSL_TRUSTSTORE_PASSWORD' from dual  union 
select '${P0_GF_IFWAYN_TRUSTSTORE_LOCATION}', 'P0_GF_IFWAYN_TRUSTSTORE_LOCATION', 'P0_GF_IFWAYN_TRUSTSTORE_LOCATION' from dual  union 
select '${P0_KAFKA_SSL_KEY_PASSWORD}', 'P0_KAFKA_SSL_KEY_PASSWORD', 'P0_KAFKA_SSL_KEY_PASSWORD' from dual  union 
select '${P0_KAFKA_SSL_KEYSTORE_PASSWORD}', 'P0_KAFKA_SSL_KEYSTORE_PASSWORD', 'P0_KAFKA_SSL_KEYSTORE_PASSWORD' from dual  union 
select '${P0_KAFKA_SSL_TRUSTSTORE_PASSWORD}', 'P0_KAFKA_SSL_TRUSTSTORE_PASSWORD', 'P0_KAFKA_SSL_TRUSTSTORE_PASSWORD' from dual  union 
select '${PORTFOLIO_CLIENT_ID}', 'PORTFOLIO_CLIENT_ID', 'PORTFOLIO_CLIENT_ID' from dual  union 
select '${PORTFOLIO_CLIENT_SECRET}', 'PORTFOLIO_CLIENT_SECRET', 'PORTFOLIO_CLIENT_SECRET' from dual  union 
select '${PORTFOLIO_REQUEST_SERVICE_URL}', 'PORTFOLIO_REQUEST_SERVICE_URL', 'PORTFOLIO_REQUEST_SERVICE_URL' from dual  union 
select '${PORTFOLIO_SECURITY_SERVICE_URL}', 'PORTFOLIO_SECURITY_SERVICE_URL', 'PORTFOLIO_SECURITY_SERVICE_URL' from dual  union 
select '${PORTFOLIO_X_TYK_API_KEY}', 'PORTFOLIO_X_TYK_API_KEY', 'PORTFOLIO_X_TYK_API_KEY' from dual  union 
select '${REAL_KAFKA_SSL_KEY_PASSWORD}', 'REAL_KAFKA_SSL_KEY_PASSWORD', 'REAL_KAFKA_SSL_KEY_PASSWORD' from dual  union 
select '${REAL_KAFKA_SSL_KEYSTORE_PASSWORD}', 'REAL_KAFKA_SSL_KEYSTORE_PASSWORD', 'REAL_KAFKA_SSL_KEYSTORE_PASSWORD' from dual  union 
select '${REAL_KAFKA_SSL_TRUSTSTORE_PASSWORD}', 'REAL_KAFKA_SSL_TRUSTSTORE_PASSWORD', 'REAL_KAFKA_SSL_TRUSTSTORE_PASSWORD' from dual  union 
select '${RR_CARD_NUMBER_SHA_256_SALT}', 'RR_CARD_NUMBER_SHA_256_SALT', 'RR_CARD_NUMBER_SHA_256_SALT' from dual  union 
select '${RR_GF_IFWAYN_BOOTSTRAP_SERVERS}', 'REAL_GF_IFWAYN_BOOTSTRAP_SERVERS', 'RR_GF_IFWAYN_BOOTSTRAP_SERVERS' from dual  union 
select '${RR_GF_IFWAYN_KEYSTORE_LOCATION}', 'REAL_GF_IFWAYN_KEYSTORE_LOCATION', 'RR_GF_IFWAYN_KEYSTORE_LOCATION' from dual  union 
select '${RR_GF_IFWAYN_SSL_KEY_PASSWORD}', 'REAL_GF_IFWAYN_SSL_KEY_PASSWORD', 'RR_GF_IFWAYN_SSL_KEY_PASSWORD' from dual  union 
select '${RR_GF_IFWAYN_SSL_KEYSTORE_PASSWORD}', 'REAL_GF_IFWAYN_SSL_KEYSTORE_PASSWORD', 'RR_GF_IFWAYN_SSL_KEYSTORE_PASSWORD' from dual  union 
select '${RR_GF_IFWAYN_SSL_TRUSTSTORE_PASSWORD}', 'REAL_GF_IFWAYN_SSL_TRUSTSTORE_PASSWORD', 'RR_GF_IFWAYN_SSL_TRUSTSTORE_PASSWORD' from dual  union 
select '${RR_GF_IFWAYN_TRUSTSTORE_LOCATION}', 'REAL_GF_IFWAYN_TRUSTSTORE_LOCATION', 'RR_GF_IFWAYN_TRUSTSTORE_LOCATION' from dual  union 
select '${SERVICE_VERSION}', 'SERVICE_VERSION', 'SERVICE_VERSION' from dual  union 
select '${TRUSTSTORE_LOCATION}', 'TRUSTSTORE_LOCATION', 'TRUSTSTORE_LOCATION' from dual  union 
select '2', 'PARALLELISM', 'PARALLELISM' from dual ;

insert into dict_service(id, main_class) 
select 'bevents-streaming-aggregate-first-salary', 'ru.vtb.bevent.first.salary.aggregate.UaspStreamingAggregateFirstSalary' from dual  union 
select 'uasp_dko_83088_way4_mdm_enrich', 'ru.vtb.uasp.way4mdmenrich.Way4MdmEnrichJob' from dual  union 
select 'uasp_dko_83088_way4_mdm_enrich_2150', 'ru.vtb.uasp.way4mdmenrich2150.Way4MdmEnrichJob' from dual  union 
select 'uasp-dko-rds-63902-accr-reciver', 'ru.vtb.uasp.closingaccount.ClosingAccountJob' from dual  union 
select 'uasp-kriaa-bevents-case-2', 'ru.vtb.uasp.packacge.PackageServiceJob' from dual  union 
select 'uasp-kriaa-bevents-case-40', 'ru.vtb.uasp.packacge.PackageServiceJob' from dual  union 
select 'uasp-kriaa-bevents-case-55', 'ru.vtb.uasp.packacge.PackageServiceJob' from dual  union 
select 'uasp-kriaa-bevents-case-56', 'ru.vtb.uasp.packacge.PackageServiceJob' from dual  union 
select 'uasp-kriaa-bevents-case-57', 'ru.vtb.uasp.packacge.PackageServiceJob' from dual  union 
select 'uasp-kriaa-bevents-case-68', 'ru.vtb.bevent.UaspStreamingCase68' from dual  union 
select 'uasp-kriaa-bevents-case-70', 'ru.vtb.uasp.packacge.PackageServiceJob' from dual  union 
select 'uasp-kriaa-bevents-case-84', 'ru.vtb.uasp.packacge.PackageServiceJob' from dual  union 
select 'uasp-kriaa-bevents-case-86', 'ru.vtb.uasp.packacge.PackageServiceJob' from dual  union 
select 'uasp-kriaa-bevents-insurence-cft', 'ru.vtb.uasp.packacge.PackageServiceJob' from dual  union 
select 'uasp-kriaa-bevents-insurence-kn', 'ru.vtb.uasp.packacge.PackageServiceJob' from dual  union 
select 'uasp-kriaa-bevents-monitor', 'ru.vtb.uasp.packacge.PackageServiceJob' from dual  union 
select 'uasp-streaming-aggregate', 'ru.vtb.uasp.aggregate.UaspStreamingAggregate' from dual  union 
select 'uasp-streaming-beg-card-block', 'ru.vtb.uasp.beg.card.block.App' from dual  union 
select 'uasp-streaming-beg-pincode-change', 'ru.vtb.uasp.beg.pincode.change.App' from dual  union 
select 'uasp-streaming-cc-activation', 'ru.vtb.uasp.App' from dual  union 
select 'uasp-streaming-currency-enrichment', 'ru.vtb.uasp.streaming.currency.CurrencyEnrichmentApp' from dual  union 
select 'uasp-streaming-filter', 'ru.vtb.uasp.filter.FilterJob' from dual  union 
select 'uasp-streaming-input-convertor', 'ru.vtb.uasp.inputconvertor.Convertor' from dual  union 
select 'uasp-streaming-json-validator', 'ru.vtb.uasp.streaming.json.validator.App' from dual  union 
select 'uasp-streaming-mdm-enrichment', 'ru.vtb.uasp.mdm.enrichment.EnrichmentJob' from dual  union 
select 'uasp-streaming-model-vector', 'ru.vtb.uasp.vector.UaspStreamingModelVector' from dual  union 
select 'uasp-streaming-mutator', 'ru.vtb.uasp.mutator.DroolsBusinessRullesJob' from dual  union 
select 'uasp-streaming-refunds-event-notifier', 'ru.vtb.uasp.refunds.RefundsNotifierApp' from dual  union 
select 'uasp-streaming-rto-15', 'ru.vtb.uasp.App' from dual  union 
select 'uasp-streaming-rto-37', 'ru.vtb.uasp.App' from dual  union 
select 'uasp-streaming-rto-attempt-close-part2', 'ru.vtb.uasp.App' from dual  union 
select 'uasp-streaming-rto-bcps-card-emission-digital', 'ru.vtb.uasp.App' from dual  union 
select 'uasp-streaming-rto-bcps-status-change', 'ru.vtb.uasp.App' from dual  union 
select 'uasp-streaming-rto-card-activation-way4', 'ru.vtb.uasp.App' from dual  union 
select 'uasp-streaming-rto-closing-deposit', 'ru.vtb.uasp.App' from dual  union 
select 'uasp-streaming-rto-dko-4_62', 'ru.vtb.uasp.App' from dual  union 
select 'uasp-streaming-rto-mortgage-approval', 'ru.vtb.uasp.rto.mortgage.approval.App' from dual  union 
select 'uasp-streaming-rto-ofvs', 'ru.vtb.uasp.App' from dual  union 
select 'uasp-streaming-rto-open-deposit', 'ru.vtb.uasp.App' from dual  union 
select 'uasp-streaming-rto-status-execution-goal', 'ru.vtb.uasp.App' from dual  union 
select 'uasp-streaming-rto-zoc', 'ru.vtb.uasp.App' from dual  union 
select 'uasp-streaming-unp-convertor', 'ru.vtb.uasp.unp.convertor.UnpConvertor' from dual ;

insert into dict_topic_owner(description_for_report, id, is_our) 
select 'Интеграция: ссылка на ПМИ', 'DKO_COMMAND', 1 from dual ;

insert into meta_property_function(description, id) 
select 'SERVICE_NAME', 'SERVICE_NAME' from dual ;

insert into meta_stand(cnt_partition, description, id, is_local, is_prod, replacment_for_topic_name) 
select 8, 'P0', 'P0', 0, 1, 'p0_' from dual  union 
select 8, 'IFT', 'IFT', 0, 0, 'ift_' from dual  union 
select 8, 'DSO', 'DSO', 0, 0, 'dev_' from dual  union 
select 8, 'REAL', 'REAL', 0, 0, 'rr_' from dual  union 
select 8, 'NOTEBOOK', 'NOTEBOOK', 1, 0, 'dev_' from dual  union 
select 8, 'NT', 'NT', 0, 0, 'nt_' from dual  union 
select 8, 'NOTEBOOK_DSO', 'NOTEBOOK_DSO', 1, 0, 'dev_' from dual ;

insert into dict_arrow(beg_node_id, beg_node_type, common_name, end_node_id, end_node_type, graph_id, kafka_grp_prop, property_key) 
select 'APRF_STATIC_PUB', 'topic', 'Не задан', 'uasp-kriaa-bevents-case-55~main', 'flink_srv', 'rto_graph', 'earliest_CARDFL_BOOTSTRAP_SERVERS', 'enrichOne.PackageFlEnrichProperty$.fromTopic' from dual  union 
select 'APRF_STATIC_PUB', 'topic', 'Не задан', 'uasp-streaming-unp-convertor~cardfl', 'flink_srv', 'rto_graph', 'latest', 'consumer.fromTopic' from dual  union 
select 'bevents-streaming-aggregate-first-salary~aggregate-bevents', 'flink_srv', 'Не задан', 'dev__bevents__realtime__aggregate_first_salary__dlq', 'topic', 'rto_graph', 'producer_default', 'dlq.toTopic' from dual  union 
select 'bevents-streaming-aggregate-first-salary~aggregate-bevents', 'flink_srv', 'Не задан', 'dev_bevents__realtime__aggregate_first_salary__uaspdto', 'topic', 'rto_graph', 'producer_default', 'output.toTopic' from dual  union 
select 'bevents-streaming-aggregate-first-salary~aggregate-bevents-56-57', 'flink_srv', 'Не задан', 'dev__bevents__realtime__aggregate_first_salary__dlq', 'topic', 'rto_graph', 'producer_default', 'dlq.toTopic' from dual  union 
select 'bevents-streaming-aggregate-first-salary~aggregate-bevents-56-57', 'flink_srv', 'Не задан', 'dev_bevents__realtime__aggregate_first_salary__uaspdto', 'topic', 'rto_graph', 'producer_default', 'output.toTopic' from dual  union 
select 'CFT2RS_CD_OUT', 'topic', 'Не задан', 'uasp-streaming-input-convertor~input-convertor-cft', 'flink_srv', 'rto_graph', 'latest', 'input.fromTopic' from dual  union 
select 'dev__account-provider__ acc__ close', 'topic', 'Не задан', 'uasp-streaming-unp-convertor~close_account', 'flink_srv', 'close_acc_graph', 'latest', 'consumer.fromTopic' from dual  union 
select 'dev__account-provider__ acc__ close_unp', 'topic', 'Не задан', 'uasp-streaming-input-convertor~close_account', 'flink_srv', 'close_acc_graph', 'latest', 'input.fromTopic' from dual  union 
select 'dev_accr_uasp_acc_close', 'topic', 'Не задан', 'uasp-dko-rds-63902-accr-reciver~main', 'flink_srv', 'rto_graph', 'latest', 'enrichOne.MainProperty$.fromTopic' from dual  union 
select 'dev_bevents_68_after_rate_enrich', 'topic', 'Не задан', 'uasp-kriaa-bevents-case-40~main', 'flink_srv', 'rto_graph', 'latest', 'enrichOne.MainEnrichProperty$.fromTopic' from dual  union 
select 'dev_bevents_68_after_rate_enrich', 'topic', 'Не задан', 'uasp-kriaa-bevents-case-68~main', 'flink_srv', 'rto_graph', 'latest', 'enrichOne.MainEnrichProperty$.fromTopic' from dual  union 
select 'dev_bevents__batch__ca_first_salary_transactions__json', 'topic', 'Не задан', 'uasp-kriaa-bevents-case-56~main', 'flink_srv', 'rto_graph', 'latest', 'enrichOne.PackageFlEnrichProperty$.fromTopic' from dual  union 
select 'dev_bevents__batch__ca_first_salary_transactions__json', 'topic', 'Не задан', 'uasp-kriaa-bevents-case-57~main', 'flink_srv', 'rto_graph', 'latest', 'enrichOne.PackageFlEnrichProperty$.fromTopic' from dual  union 
select 'dev_bevents__batch__ca_first_salary_transactions__json', 'topic', 'Не задан', 'uasp-streaming-input-convertor~input-convertor-ca-first-salary', 'flink_srv', 'rto_graph', 'latest', 'input.fromTopic' from dual  union 
select 'dev_bevents__batch__ca_first_salary_transactions__json_converted', 'topic', 'Не задан', 'uasp-streaming-unp-convertor~aggregate-ca', 'flink_srv', 'rto_graph', 'latest', 'consumer.fromTopic' from dual  union 
select 'dev_bevents__batch__ca_regulatory_client_id_of_profile__json', 'topic', 'Не задан', 'uasp-streaming-input-convertor~customer-profile-full', 'flink_srv', 'rto_graph', 'latest', 'input.fromTopic' from dual  union 
select 'dev_bevents__batch__ca_regulatory_client_id_of_profile__json_converted', 'topic', 'Не задан', 'uasp-streaming-mdm-enrichment~profile-tx-step1', 'flink_srv', 'rto_graph', 'earliest', 'enrichOne.GlobalIdEnrichProperty$.fromTopic' from dual  union 
select 'dev_bevents__batch__ca_regulatory_contract_num_of_mdm_id_profile__uaspdto', 'topic', 'Не задан', 'uasp-streaming-mdm-enrichment~profile-tx-step2', 'flink_srv', 'rto_graph', 'earliest', 'enrichOne.GlobalIdEnrichProperty$.fromTopic' from dual  union 
select 'dev_bevents_card_agreement_enrich_out_uaspdto', 'topic', 'Не задан', 'uasp-streaming-mdm-enrichment~prof-auth-packNM', 'flink_srv', 'rto_graph', 'latest', 'enrichOne.MainEnrichProperty$.fromTopic' from dual  union 
select 'dev_bevents_cft_way4_profile_udds_after_mutator_uaspdto', 'topic', 'Не задан', 'uasp-streaming-mutator~uddsRate', 'flink_srv', 'rto_graph', 'latest', 'kafka.consumer.fromTopic' from dual  union 
select 'dev_bevents_cft_way4_profile_udds_before_case68_uaspdto', 'topic', 'Не задан', 'uasp-kriaa-bevents-case-2~main', 'flink_srv', 'rto_graph', 'earliest', 'enrichOne.MainEnrichProperty$.fromTopic' from dual  union 
select 'dev_bevents_cft_way4_profile_udds_before_case68_uaspdto', 'topic', 'Не задан', 'uasp-streaming-mdm-enrichment~case-68_agrement', 'flink_srv', 'rto_graph', 'latest', 'enrichOne.MainEnrichProperty$.fromTopic' from dual  union 
select 'dev_bevents_cft_way4_profile_udds_before_mdm_rate_case68_uaspdto', 'topic', 'Не задан', 'uasp-streaming-mdm-enrichment~case-68', 'flink_srv', 'rto_graph', 'latest', 'enrichOne.MainEnrichProperty$.fromTopic' from dual  union 
select 'dev_bevents__realtime__aggregate_first_salary__uaspdto', 'topic', 'Не задан', 'uasp-streaming-filter~bevents-filter', 'flink_srv', 'rto_graph', 'latest', 'kafka.consumer.fromTopic' from dual  union 
select 'dev_bevents__realtime__case_71__uaspdto', 'topic', 'Не задан', 'uasp-streaming-mdm-enrichment~profile-tx-step1', 'flink_srv', 'rto_graph', 'latest', 'enrichOne.MainEnrichProperty$.fromTopic' from dual  union 
select 'dev_bevents__realtime__enrichment_first_salary_transactions__uaspdto', 'topic', 'Не задан', 'bevents-streaming-aggregate-first-salary~aggregate-bevents', 'flink_srv', 'rto_graph', 'latest', 'ha.fromTopic' from dual  union 
select 'dev_bevents__realtime__enrichment_first_salary_transactions__uaspdto', 'topic', 'Не задан', 'bevents-streaming-aggregate-first-salary~aggregate-bevents-56-57', 'flink_srv', 'rto_graph', 'latest', 'ha.fromTopic' from dual  union 
select 'dev_bevents__realtime__enrichment_first_salary_transactions__uaspdto', 'topic', 'Не задан', 'uasp-kriaa-bevents-case-56~main', 'flink_srv', 'rto_graph', 'latest', 'enrichOne.MainEnrichProperty$.fromTopic' from dual  union 
select 'dev_bevents__realtime__enrichment_first_salary_transactions__uaspdto', 'topic', 'Не задан', 'uasp-kriaa-bevents-case-57~main', 'flink_srv', 'rto_graph', 'latest', 'enrichOne.MainEnrichProperty$.fromTopic' from dual  union 
select 'dev_bevents__realtime__enrichment_first_salary_transactions__uaspdto', 'topic', 'Не задан', 'uasp-kriaa-bevents-monitor~test', 'flink_srv', 'rto_graph', 'earliest', 'enrichOne.fromTopic' from dual  union 
select 'dev_bevents__realtime__enrichment_first_salary_transactions__uaspdto', 'topic', 'Не задан', 'uasp-streaming-refunds-event-notifier~main', 'flink_srv', 'rto_graph', 'latest', 'fromTopic' from dual  union 
select 'dev_bevents__realtime__enrichment_prepare_transactions__uaspdto', 'topic', 'Не задан', 'uasp-streaming-currency-enrichment~first-salary', 'flink_srv', 'rto_graph', 'latest', 'uasp.fromTopic' from dual  union 
select 'dev_bevents__realtime__enrichment_prepare_transactions__uaspdto', 'topic', 'Не задан', 'uasp-streaming-unp-convertor~case68', 'flink_srv', 'rto_graph', 'latest', 'consumer.fromTopic' from dual  union 
select 'dev_bevents__realtime__enrichment__prof__contract_num__uaspdto', 'topic', 'Не задан', 'uasp-streaming-mdm-enrichment~profile-tx-step2', 'flink_srv', 'rto_graph', 'latest', 'enrichOne.MainEnrichProperty$.fromTopic' from dual  union 
select 'dev_bevents__realtime__enrichment__prof__transactions_first__uaspdto', 'topic', 'Не задан', 'uasp-kriaa-bevents-case-70~main', 'flink_srv', 'rto_graph', 'latest', 'fromTopic' from dual  union 
select 'dev_bevents__realtime__enrichment__prof__transactions_first__uaspdto', 'topic', 'Не задан', 'uasp-streaming-mutator~rateMutate', 'flink_srv', 'rto_graph', 'latest', 'kafka.consumer.fromTopic' from dual  union 
select 'dev_bevents__realtime__filter_first_salary__uaspdto', 'topic', 'Не задан', 'uasp-streaming-model-vector~model-vector-bevents', 'flink_srv', 'rto_graph', 'latest', 'consumer.fromTopic' from dual  union 
select 'dev_bevents__realtime__input_converter__prof__transactions__uaspdto', 'topic', 'Не задан', 'uasp-streaming-mdm-enrichment~prof-tx-case-71', 'flink_srv', 'rto_graph', 'latest', 'enrichOne.MainEnrichProperty$.fromTopic' from dual  union 
select 'dev_bevents_streaming_input_convertor_profile_auth_uaspdto', 'topic', 'Не задан', 'uasp-streaming-mdm-enrichment~prof-auth', 'flink_srv', 'rto_graph', 'latest', 'enrichOne.MainEnrichProperty$.fromTopic' from dual  union 
select 'dev_bevents_udds_mdm_rate_case68_uaspdto', 'topic', 'Не задан', 'uasp-streaming-currency-enrichment~case68', 'flink_srv', 'rto_graph', 'latest', 'uasp.fromTopic' from dual  union 
select 'dev__boop_uasp__uss__loyalty_profile_changes', 'topic', 'Не задан', 'uasp-streaming-input-convertor~loyalty', 'flink_srv', 'rto_graph', 'latest', 'input.fromTopic' from dual  union 
select 'dev_cft2rl_uasp_loan_details', 'topic', 'Не задан', 'uasp-kriaa-bevents-case-84~main', 'flink_srv', 'rto_graph', 'latest', 'enrichOne.MainEnrichProperty$.fromTopic' from dual  union 
select 'dev_cft2rl_uasp_loan_details', 'topic', 'Не задан', 'uasp-kriaa-bevents-insurence-cft~main', 'flink_srv', 'rto_graph', 'latest', 'fromTopic' from dual  union 
select 'dev__cft2rs_uasp__chvsns', 'topic', 'Не задан', 'uasp-streaming-unp-convertor~cft-transactions', 'flink_srv', 'rto_graph', 'latest', 'consumer.fromTopic' from dual  union 
select 'dev__dko_uasp__card_agreement', 'topic', 'Не задан', 'uasp-streaming-input-convertor~input-convertor-ca-cardfl', 'flink_srv', 'rto_graph', 'latest', 'input.fromTopic' from dual  union 
select 'dev__dko_uasp__card_agreement', 'topic', 'Не задан', 'uasp-streaming-rto-dko-4_62~uasp-streaming-rto-dko-4_62', 'flink_srv', 'rto_graph', 'latest', 'card-agreement.fromTopic' from dual  union 
select 'dev__dko_uasp__card_agreement_converted', 'topic', 'Не задан', 'uasp-streaming-mdm-enrichment~case-68_agrement', 'flink_srv', 'rto_graph', 'earliest', 'enrichOne.CommonEnrichProperty$.fromTopic' from dual  union 
select 'dev__dko_uasp__card_agreement_converted', 'topic', 'Не задан', 'uasp-streaming-mdm-enrichment~prof-auth', 'flink_srv', 'rto_graph', 'earliest', 'enrichOne.GlobalIdEnrichProperty$.fromTopic' from dual  union 
select 'dev__dko_uasp__card_agreement_converted', 'topic', 'Не задан', 'uasp-streaming-mdm-enrichment~way4-card-agreement', 'flink_srv', 'rto_graph', 'earliest', 'enrichOne.CommonEnrichProperty$.fromTopic' from dual  union 
select 'dev__dko_uasp__pension', 'topic', 'Не задан', 'uasp-kriaa-bevents-case-84~main', 'flink_srv', 'rto_graph', 'earliest', 'packageNm.PackageNmEnrichProperty$.fromTopic' from dual  union 
select 'dev__dko_uasp__pension', 'topic', 'Не задан', 'uasp-streaming-beg-card-block~credit-card', 'flink_srv', 'rto_graph', 'latest', 'pension.fromTopic' from dual  union 
select 'dev__dko_uasp__pension', 'topic', 'Не задан', 'uasp-streaming-beg-pincode-change~credit-card', 'flink_srv', 'rto_graph', 'latest', 'pension.fromTopic' from dual  union 
select 'dev__dko_uasp__pension', 'topic', 'Не задан', 'uasp-streaming-input-convertor~customer-package', 'flink_srv', 'rto_graph', 'latest', 'input.fromTopic' from dual  union 
select 'dev__dko_uasp__pension', 'topic', 'Не задан', 'uasp-streaming-rto-dko-4_62~uasp-streaming-rto-dko-4_62', 'flink_srv', 'rto_graph', 'latest', 'pension.fromTopic' from dual  union 
select 'dev__dko_uasp__pension_converted', 'topic', 'Не задан', 'uasp-streaming-mdm-enrichment~prof-auth-packNM', 'flink_srv', 'rto_graph', 'earliest', 'enrichOne.CommonEnrichProperty$.fromTopic' from dual  union 
select 'dev_feature_ivr__uasp_realtime__mdm_enrichment__uaspdto', 'topic', 'Не задан', 'uasp-streaming-unp-convertor~way4-transactions', 'flink_srv', 'rto_graph', 'latest', 'consumer.fromTopic' from dual  union 
select 'dev_input_converter_cardfl_refill_uasp', 'topic', 'Не задан', 'uasp-streaming-mdm-enrichment~case-68', 'flink_srv', 'rto_graph', 'earliest', 'enrichOne.CommonEnrichProperty$.fromTopic' from dual  union 
select 'dev_ivr__uasp_realtime__business_rules__uaspdto', 'topic', 'Не задан', 'uasp-streaming-filter~main-input-filter', 'flink_srv', 'rto_graph', 'latest', 'kafka.consumer.fromTopic' from dual  union 
select 'dev_ivr__uasp_realtime__ca_ha_aggregate__ca__uaspdto', 'topic', 'Не задан', 'uasp-streaming-aggregate~aggregate-dko', 'flink_srv', 'rto_graph', 'earliest', 'consumer.ca.topic.name' from dual  union 
select 'dev_ivr__uasp_realtime__case_48_concatenate__uaspdto', 'topic', 'Не задан', 'uasp-streaming-mdm-enrichment~way4-card-agreement', 'flink_srv', 'rto_graph', 'latest', 'enrichOne.MainEnrichProperty$.fromTopic' from dual  union 
select 'dev_ivr__uasp_realtime__input_converter__mdm_cross_link__json', 'topic', 'Не задан', 'uasp_dko_83088_way4_mdm_enrich_2150~way4_new_stream', 'flink_srv', 'rto_graph', 'earliest', 'enrichMdm.MdmEnrichProperty$.fromTopic' from dual  union 
select 'dev_ivr__uasp_realtime__input_converter__mdm_cross_link__json', 'topic', 'Не задан', 'uasp_dko_83088_way4_mdm_enrich~way4_new', 'flink_srv', 'rto_graph', 'earliest', 'enrichMdm.MdmEnrichProperty$.fromTopic' from dual  union 
select 'dev_ivr__uasp_realtime__input_converter__mdm_cross_link__json', 'topic', 'Не задан', 'uasp_dko_83088_way4_mdm_enrich~way4_old_stream', 'flink_srv', 'rto_graph', 'earliest', 'enrichMdm.MdmEnrichProperty$.fromTopic' from dual  union 
select 'dev_ivr__uasp_realtime__input_converter__mdm_cross_link__json', 'topic', 'Не задан', 'uasp-streaming-input-convertor~input-convertor-mdm', 'flink_srv', 'rto_graph', 'latest', 'input.fromTopic' from dual  union 
select 'dev_ivr__uasp_realtime__input_converter__mdm_cross_link__json', 'topic', 'Не задан', 'uasp-streaming-input-convertor~mdm-profile', 'flink_srv', 'rto_graph', 'latest', 'input.fromTopic' from dual  union 
select 'dev_ivr__uasp_realtime__input_converter__mdm_cross_link__json', 'topic', 'Не задан', 'uasp-streaming-rto-card-activation-way4~uasp-streaming-rto-card-activation-way4', 'flink_srv', 'rto_graph', 'latest', 'mdm.fromTopic' from dual  union 
select 'dev_ivr__uasp_realtime__input_converter__mdm_cross_link__json', 'topic', 'Не задан', 'uasp-streaming-rto-card-activation-way4~uasp-streaming-rto-card-activation-way4-mock-test', 'flink_srv', 'rto_graph', 'latest', 'mdm.fromTopic' from dual  union 
select 'dev_ivr__uasp_realtime__input_converter__mdm_cross_link__json', 'topic', 'Не задан', 'uasp-streaming-rto-dko-4_62~uasp-streaming-rto-dko-4_62', 'flink_srv', 'rto_graph', 'latest', 'way4.balance.fromTopic' from dual  union 
select 'dev_ivr__uasp_realtime__input_converter__mdm_cross_link__uaspdto', 'topic', 'Не задан', 'uasp-streaming-mdm-enrichment~way4', 'flink_srv', 'rto_graph', 'earliest', 'enrichOne.GlobalIdEnrichProperty$.fromTopic' from dual  union 
select 'dev_ivr__uasp_realtime__input_converter__mortgage__uaspdto', 'topic', 'Не задан', 'uasp-streaming-mdm-enrichment~way4', 'flink_srv', 'rto_graph', 'earliest', 'enrichOne.CommonEnrichProperty$.fromTopic' from dual  union 
select 'dev_ivr__uasp_realtime__input_converter__way4_issuing_card__json', 'topic', 'Не задан', 'uasp-streaming-rto-card-activation-way4~uasp-streaming-rto-card-activation-way4', 'flink_srv', 'rto_graph', 'latest', 'fromTopic' from dual  union 
select 'dev_ivr__uasp_realtime__input_converter__way4_issuing_card__json', 'topic', 'Не задан', 'uasp-streaming-rto-card-activation-way4~uasp-streaming-rto-card-activation-way4-mock-test', 'flink_srv', 'rto_graph', 'latest', 'fromTopic' from dual  union 
select 'dev_ivr__uasp_realtime__input_converter__way4_issuing_operation__json', 'topic', 'Не задан', 'uasp-streaming-rto-dko-4_62~uasp-streaming-rto-dko-4_62', 'flink_srv', 'rto_graph', 'latest', 'way4.operation.fromTopic' from dual  union 
select 'dev_ivr__uasp_realtime__input_converter__way4_issuing_operation__json', 'topic', 'Не задан', 'uasp-streaming-unp-convertor~way4-main', 'flink_srv', 'rto_graph', 'latest', 'consumer.fromTopic' from dual  union 
select 'dev_ivr__uasp_realtime__input_converter__way4_issuing_operation__uaspdto', 'topic', 'Не задан', 'uasp-streaming-mdm-enrichment~way4', 'flink_srv', 'rto_graph', 'latest', 'enrichOne.MainEnrichProperty$.fromTopic' from dual  union 
select 'dev_ivr__uasp_realtime__mdm_enrichment__uaspdto', 'topic', 'Не задан', 'uasp-streaming-aggregate~aggregate-dko', 'flink_srv', 'rto_graph', 'earliest', 'consumer.ha.topic.name' from dual  union 
select 'dev_ivr__uasp_realtime__outer_cbr_rate__ask', 'topic', 'Не задан', 'uasp-streaming-unp-convertor~cbr-rate', 'flink_srv', 'rto_graph', 'latest', 'consumer.fromTopic' from dual  union 
select 'dev_ivr__uasp_realtime__outer_cbr_rate__ask', 'topic', 'Не задан', 'uasp-streaming-unp-convertor~outer-cbr-rate', 'flink_srv', 'rto_graph', 'latest', 'consumer.fromTopic' from dual  union 
select 'dev_ivr__uasp_realtime__outer_cbr_rates__json', 'topic', 'Не задан', 'uasp-streaming-currency-enrichment~case68', 'flink_srv', 'rto_graph', 'latest', 'currency.fromTopic' from dual  union 
select 'dev_ivr__uasp_realtime__outer_cbr_rates__json', 'topic', 'Не задан', 'uasp-streaming-currency-enrichment~first-salary', 'flink_srv', 'rto_graph', 'latest', 'currency.fromTopic' from dual  union 
select 'dev_ivr_uasp_realtime_way4_main_input_issuing_operation__json', 'topic', 'Не задан', 'uasp-streaming-input-convertor~input-convertor-w4-operation', 'flink_srv', 'rto_graph', 'earliest', 'input.fromTopic' from dual  union 
select 'dev_ivr__uasp_realtime_way4_mdm_enrichment__uaspdto', 'topic', 'Не задан', 'uasp-streaming-mutator~case-48-concatenate', 'flink_srv', 'rto_graph', 'latest', 'kafka.consumer.fromTopic' from dual  union 
select 'dev_ivr__uasp_realtime_way4_mdm_enrichment__uaspdto', 'topic', 'Не задан', 'uasp-streaming-mutator~mainInput', 'flink_srv', 'rto_graph', 'latest', 'kafka.consumer.fromTopic' from dual  union 
select 'dev__model_orkestrator__uasp__zoc', 'topic', 'Не задан', 'uasp-streaming-rto-zoc~uasp-streaming-rto-zoc', 'flink_srv', 'rto_graph', 'latest', 'fromTopic' from dual  union 
select 'dev__mscl_uasp_applic', 'topic', 'Не задан', 'uasp-streaming-json-validator~kn', 'flink_srv', 'rto_graph', 'latest', 'fromTopic' from dual  union 
select 'dev__mscl_uasp_applic_valid', 'topic', 'Не задан', 'uasp-kriaa-bevents-insurence-kn~main', 'flink_srv', 'rto_graph', 'latest', 'fromTopic' from dual  union 
select 'dev__mssa_uasp_applic', 'topic', 'Не задан', 'uasp-streaming-json-validator~uz', 'flink_srv', 'rto_graph', 'latest', 'fromTopic' from dual  union 
select 'dev_multibonus_partners_program', 'topic', 'Не задан', 'uasp-kriaa-bevents-case-40~main', 'flink_srv', 'rto_graph', 'earliest', 'multiBonus.fromTopic' from dual  union 
select 'dev__pp_fl_uasp__opyp', 'topic', 'Не задан', 'uasp-kriaa-bevents-case-55~main', 'flink_srv', 'rto_graph', 'latest', 'enrichOne.MainEnrichProperty$.fromTopic' from dual  union 
select 'dev_rto_batch_ca_deposit_account_case_71_json', 'topic', 'Не задан', 'uasp-streaming-input-convertor~input-convertor-ca-depositfl', 'flink_srv', 'rto_graph', 'latest', 'input.fromTopic' from dual  union 
select 'dev_rto_batch_ca_deposit_account_case_71_json_converted', 'topic', 'Не задан', 'uasp-streaming-mdm-enrichment~prof-tx-case-71', 'flink_srv', 'rto_graph', 'earliest', 'enrichOne.CommonEnrichProperty$.fromTopic' from dual  union 
select 'dev_rto_batch_ca_personal_manager_json', 'topic', 'Не задан', 'uasp-kriaa-bevents-case-55~main', 'flink_srv', 'rto_graph', 'earliest', 'enrichOne.PersonalManagerEnrichProperty$.fromTopic' from dual  union 
select 'dev_sstr_uasp_pay_inf', 'topic', 'Не задан', 'uasp-streaming-json-validator~insurance', 'flink_srv', 'rto_graph', 'latest', 'fromTopic' from dual  union 
select 'dev_sstr_uasp_piods', 'topic', 'Не задан', 'uasp-kriaa-bevents-case-86~main', 'flink_srv', 'rto_graph', 'latest', 'enrichOne.MainEnrichProperty$.fromTopic' from dual  union 
select 'dev_ss_uasp_ons', 'topic', 'Не задан', 'uasp-streaming-rto-37~uasp-streaming-rto-37', 'flink_srv', 'rto_graph', 'latest', 'fromTopic' from dual  union 
select 'dev_ss_uasp_pzns', 'topic', 'Не задан', 'uasp-streaming-rto-attempt-close-part2~uasp-streaming-rto-attempt-close-part2', 'flink_srv', 'rto_graph', 'latest', 'fromTopic' from dual  union 
select 'dev_ss_uasp_svc', 'topic', 'Не задан', 'uasp-streaming-rto-status-execution-goal~uasp-streaming-rto-status-execution-goal', 'flink_srv', 'rto_graph', 'latest', 'fromTopic' from dual  union 
select 'dev__tbcr_uasp__ofvs', 'topic', 'Не задан', 'uasp-streaming-rto-ofvs~uasp-streaming-rto-ofvs', 'flink_srv', 'ofvs', 'latest', 'fromTopic' from dual  union 
select 'dev__trns_uasp__up', 'topic', 'Не задан', 'uasp-streaming-unp-convertor~withdraw-transactions', 'flink_srv', 'rto_graph', 'latest', 'consumer.fromTopic' from dual  union 
select 'dev__uasp_aprf__pks', 'topic', 'Не задан', 'uasp-streaming-input-convertor~input-convertor-cardfl', 'flink_srv', 'rto_graph', 'latest', 'input.fromTopic' from dual  union 
select 'dev_uasp_bcps_ced', 'topic', 'Не задан', 'uasp-streaming-rto-bcps-card-emission-digital~uasp-streaming-rto-bcps-card-emission-digital', 'flink_srv', 'rto_graph', 'latest', 'fromTopic' from dual  union 
select 'dev_uasp_bcps_ced', 'topic', 'Не задан', 'uasp-streaming-rto-bcps-card-emission-digital~uasp-streaming-rto-bcps-card-emission-digital-mock-test', 'flink_srv', 'rto_graph', 'latest', 'fromTopic' from dual  union 
select 'dev_uasp_bcps_csc', 'topic', 'Не задан', 'uasp-streaming-rto-bcps-status-change~uasp-streaming-rto-bcps-status-change', 'flink_srv', 'rto_graph', 'latest', 'fromTopic' from dual  union 
select 'dev_uasp_bcps_csc', 'topic', 'Не задан', 'uasp-streaming-rto-bcps-status-change~uasp-streaming-rto-bcps-status-change-mock-test', 'flink_srv', 'rto_graph', 'latest', 'fromTopic' from dual  union 
select 'dev_uasp_ccpp_card_activate', 'topic', 'Не задан', 'uasp-streaming-cc-activation~credit-card', 'flink_srv', 'rto_graph', 'latest', 'fromTopic' from dual  union 
select 'dev_uasp_ccpp_card_block', 'topic', 'Не задан', 'uasp-streaming-beg-card-block~credit-card', 'flink_srv', 'rto_graph', 'latest', 'fromTopic' from dual  union 
select 'dev_uasp_ccpp_card_pin_change', 'topic', 'Не задан', 'uasp-streaming-beg-pincode-change~credit-card', 'flink_srv', 'rto_graph', 'latest', 'fromTopic' from dual  union 
select 'dev__udds_uasp__up', 'topic', 'Не задан', 'uasp-streaming-unp-convertor~udds-3to8', 'flink_srv', 'rto_graph', 'latest', 'consumer.fromTopic' from dual  union 
select 'dev__udds_uasp__up_unp', 'topic', 'Не задан', 'uasp-streaming-input-convertor~input-convertor-udds', 'flink_srv', 'rto_graph', 'earliest', 'input.fromTopic' from dual  union 
select 'dev__wayn_wvtb__issuing_account', 'topic', 'Не задан', 'uasp_dko_83088_way4_mdm_enrich_2150~way4_new_stream', 'flink_srv', 'rto_graph', 'latest', 'enrichMdm.MainAccountProperty$.fromTopic' from dual  union 
select 'dev__wayn_wvtb__issuing_account', 'topic', 'Не задан', 'uasp_dko_83088_way4_mdm_enrich~way4_new', 'flink_srv', 'rto_graph', 'latest', 'enrichMdm.MainAccountProperty$.fromTopic' from dual  union 
select 'dev__wayn_wvtb__issuing_operation', 'topic', 'Не задан', 'uasp_dko_83088_way4_mdm_enrich_2150~way4_new_stream', 'flink_srv', 'rto_graph', 'latest', 'enrichMdm.MainOperationProperty$.fromTopic' from dual  union 
select 'dev__wayn_wvtb__issuing_operation', 'topic', 'Не задан', 'uasp_dko_83088_way4_mdm_enrich~way4_new', 'flink_srv', 'rto_graph', 'latest', 'enrichMdm.MainOperationProperty$.fromTopic' from dual  union 
select 'dev__wpr_profile-uasp__auth', 'topic', 'Не задан', 'uasp-streaming-input-convertor~input-convertor-prof-auth', 'flink_srv', 'rto_graph', 'latest', 'input.fromTopic' from dual  union 
select 'dev__wpr_profile-uasp__auth', 'topic', 'Не задан', 'uasp-streaming-unp-convertor~profile-auth', 'flink_srv', 'rto_graph', 'latest', 'consumer.fromTopic' from dual  union 
select 'dev__wpr_profile-uasp__tran', 'topic', 'Не задан', 'uasp-streaming-input-convertor~input-convertor-profile', 'flink_srv', 'rto_graph', 'latest', 'input.fromTopic' from dual  union 
select 'dev__wpr_profile-uasp__tran', 'topic', 'Не задан', 'uasp-streaming-rto-dko-4_62~uasp-streaming-rto-dko-4_62', 'flink_srv', 'rto_graph', 'latest', 'profile.fromTopic' from dual  union 
select 'dev__wpr_profile-uasp__tran', 'topic', 'Не задан', 'uasp-streaming-unp-convertor~profile-transactions', 'flink_srv', 'rto_graph', 'latest', 'consumer.fromTopic' from dual  union 
select 'issuing-account', 'topic', 'Не задан', 'uasp_dko_83088_way4_mdm_enrich~way4_old_stream', 'flink_srv', 'rto_graph', 'latest', 'enrichMdm.MainAccountProperty$.fromTopic' from dual  union 
select 'issuing-account-balance', 'topic', 'Не задан', 'uasp-streaming-unp-convertor~w4-account-balance', 'flink_srv', 'rto_graph', 'latest', 'consumer.fromTopic' from dual  union 
select 'issuing-card', 'topic', 'Не задан', 'uasp-streaming-unp-convertor~unp_w4_issuing_card', 'flink_srv', 'rto_graph', 'gf_latest', 'consumer.fromTopic' from dual  union 
select 'issuing-operation', 'topic', 'Не задан', 'uasp_dko_83088_way4_mdm_enrich~way4_old_stream', 'flink_srv', 'rto_graph', 'latest', 'enrichMdm.MainOperationProperty$.fromTopic' from dual  union 
select 'prod__ipo_uasp__od', 'topic', 'Не задан', 'uasp-streaming-rto-mortgage-approval~uasp-streaming-rto-mortgage-approval-prod', 'flink_srv', 'rto_graph', 'latest', 'fromTopic' from dual  union 
select 'prod_ss_uasp_ov', 'topic', 'Не задан', 'uasp-streaming-rto-open-deposit~uasp-streaming-rto-open-deposit', 'flink_srv', 'rto_graph', 'latest', 'fromTopic' from dual  union 
select 'prod_ss_uasp_pzv', 'topic', 'Не задан', 'uasp-streaming-rto-closing-deposit~uasp-streaming-rto-closing-deposit', 'flink_srv', 'rto_graph', 'latest', 'fromTopic' from dual  union 
select 'prod_ss_uasp_usapns', 'topic', 'Не задан', 'uasp-streaming-rto-15~uasp-streaming-rto-15', 'flink_srv', 'rto_graph', 'latest', 'fromTopic' from dual  union 
select 'streaming.smart_replication_change_request_tbcvsofk_default', 'topic', 'Не задан', 'uasp-kriaa-bevents-case-55~main', 'flink_srv', 'rto_graph', 'earliest_DATA_PLATFORM', 'enrichOne.ChangeRecordEnrichProperty$.fromTopic' from dual  union 
select 'uasp_dko_83088_way4_mdm_enrich_2150~way4_new_stream', 'flink_srv', 'Не задан', 'dev__uasp_usst__wayNew_account_uop', 'topic', 'rto_graph', 'producer_default', 'enrichMdm.MainAccountProperty$.out.FlinkSinkProperties$.toTopic' from dual  union 
select 'uasp_dko_83088_way4_mdm_enrich_2150~way4_new_stream', 'flink_srv', 'Не задан', 'dev__uasp_usst__wayNew_operation_uop', 'topic', 'rto_graph', 'producer_default', 'enrichMdm.MainOperationProperty$.out.FlinkSinkProperties$.toTopic' from dual  union 
select 'uasp_dko_83088_way4_mdm_enrich_2150~way4_new_stream', 'flink_srv', 'Не задан', 'dev__uasp_usst__way_uop__dlq', 'topic', 'rto_graph', 'producer_default', 'enrichMdm.MainOperationProperty$.dlq.FlinkSinkProperties$.toTopic' from dual  union 
select 'uasp_dko_83088_way4_mdm_enrich~way4_new', 'flink_srv', 'Не задан', 'dev__uasp_usst__wayNew_account_trmon', 'topic', 'rto_graph', 'producer_default', 'enrichMdm.MainAccountProperty$.out.FlinkSinkProperties$.toTopic' from dual  union 
select 'uasp_dko_83088_way4_mdm_enrich~way4_new', 'flink_srv', 'Не задан', 'dev__uasp_usst__wayNew_operation_trmon', 'topic', 'rto_graph', 'producer_default', 'enrichMdm.MainOperationProperty$.out.FlinkSinkProperties$.toTopic' from dual  union 
select 'uasp_dko_83088_way4_mdm_enrich~way4_new', 'flink_srv', 'Не задан', 'dev__uasp_usst__way_trmon__dlq', 'topic', 'rto_graph', 'producer_default', 'enrichMdm.MainOperationProperty$.dlq.FlinkSinkProperties$.toTopic' from dual  union 
select 'uasp_dko_83088_way4_mdm_enrich~way4_old_stream', 'flink_srv', 'Не задан', 'dev__uasp_usst__wayOld_account_trmon', 'topic', 'rto_graph', 'producer_default', 'enrichMdm.MainAccountProperty$.out.FlinkSinkProperties$.toTopic' from dual  union 
select 'uasp_dko_83088_way4_mdm_enrich~way4_old_stream', 'flink_srv', 'Не задан', 'dev__uasp_usst__wayOld_operation_trmon', 'topic', 'rto_graph', 'producer_default', 'enrichMdm.MainOperationProperty$.out.FlinkSinkProperties$.toTopic' from dual  union 
select 'uasp_dko_83088_way4_mdm_enrich~way4_old_stream', 'flink_srv', 'Не задан', 'dev__uasp_usst__way_trmon__dlq', 'topic', 'rto_graph', 'producer_default', 'enrichMdm.MainOperationProperty$.dlq.FlinkSinkProperties$.toTopic' from dual  union 
select 'uasp-dko-rds-63902-accr-reciver~main', 'flink_srv', 'Не задан', 'dev_accr_uasp_acc_close_ack', 'topic', 'rto_graph', 'producer_default', 'enrichOne.AskProperty$.out.FlinkSinkProperties$.toTopic' from dual  union 
select 'uasp-dko-rds-63902-accr-reciver~main', 'flink_srv', 'Не задан', 'dev_accr_uasp_acc_close_valid', 'topic', 'rto_graph', 'producer_default', 'enrichOne.MainProperty$.out.FlinkSinkProperties$.toTopic' from dual  union 
select 'uasp-kriaa-bevents-case-2~main', 'flink_srv', 'Не задан', 'dev__rto_uasp__case_2', 'topic', 'rto_graph', 'producer_default', 'enrichOne.MainEnrichProperty$.out.FlinkSinkProperties$.toTopic' from dual  union 
select 'uasp-kriaa-bevents-case-2~main', 'flink_srv', 'Не задан', 'dev__rto_uasp__case_2_dlq', 'topic', 'rto_graph', 'producer_default', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.toTopic' from dual  union 
select 'uasp-kriaa-bevents-case-40~main', 'flink_srv', 'Не задан', 'dev__rto_uasp__case_40', 'topic', 'rto_graph', 'producer_default', 'enrichOne.MainEnrichProperty$.out.FlinkSinkProperties$.toTopic' from dual  union 
select 'uasp-kriaa-bevents-case-40~main', 'flink_srv', 'Не задан', 'dev__rto_uasp__case_40__dlq', 'topic', 'rto_graph', 'producer_default', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.toTopic' from dual  union 
select 'uasp-kriaa-bevents-case-55~main', 'flink_srv', 'Не задан', 'dev__rto_uasp__opyp', 'topic', 'rto_graph', 'producer_default', 'enrichOne.MainEnrichProperty$.out.FlinkSinkProperties$.toTopic' from dual  union 
select 'uasp-kriaa-bevents-case-55~main', 'flink_srv', 'Не задан', 'dev__rto_uasp__opyp__dlq', 'topic', 'rto_graph', 'producer_default', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.toTopic' from dual  union 
select 'uasp-kriaa-bevents-case-56~main', 'flink_srv', 'Не задан', 'dev__rto_uasp__zzp', 'topic', 'rto_graph', 'producer_default', 'enrichOne.MainEnrichProperty$.out.FlinkSinkProperties$.toTopic' from dual  union 
select 'uasp-kriaa-bevents-case-56~main', 'flink_srv', 'Не задан', 'dev__rto_uasp__zzp_dlq', 'topic', 'rto_graph', 'producer_default', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.toTopic' from dual  union 
select 'uasp-kriaa-bevents-case-57~main', 'flink_srv', 'Не задан', 'dev__rto_uasp__izost_unp', 'topic', 'rto_graph', 'producer_default', 'enrichOne.MainEnrichProperty$.out.FlinkSinkProperties$.toTopic' from dual  union 
select 'uasp-kriaa-bevents-case-57~main', 'flink_srv', 'Не задан', 'dev__rto_uasp__zp_dlq', 'topic', 'rto_graph', 'producer_default', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.toTopic' from dual  union 
select 'uasp-kriaa-bevents-case-68~main', 'flink_srv', 'Не задан', 'dev_bevents_udds_mdm_rate_case68_uaspdto_dlq', 'topic', 'rto_graph', 'producer_default', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.toTopic' from dual  union 
select 'uasp-kriaa-bevents-case-68~main', 'flink_srv', 'Не задан', 'dev__rto_uasp__pks', 'topic', 'rto_graph', 'producer_default', 'enrichOne.MainEnrichProperty$.out.FlinkSinkProperties$.toTopic' from dual  union 
select 'uasp-kriaa-bevents-case-70~main', 'flink_srv', 'Не задан', 'dev__rto_uasp__case_70', 'topic', 'rto_graph', 'producer_default', 'producer.FlinkSinkProperties$.toTopic' from dual  union 
select 'uasp-kriaa-bevents-case-70~main', 'flink_srv', 'Не задан', 'dev__rto_uasp__case_70_dlq', 'topic', 'rto_graph', 'producer_default', 'dlq.FlinkSinkProperties$.toTopic' from dual  union 
select 'uasp-kriaa-bevents-case-84~main', 'flink_srv', 'Не задан', 'dev__rto_uasp__case_84', 'topic', 'rto_graph', 'producer_default', 'enrichOne.MainEnrichProperty$.out.FlinkSinkProperties$.toTopic' from dual  union 
select 'uasp-kriaa-bevents-case-84~main', 'flink_srv', 'Не задан', 'dev__rto_uasp__case_84_dlq', 'topic', 'rto_graph', 'producer_default', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.toTopic' from dual  union 
select 'uasp-kriaa-bevents-case-86~main', 'flink_srv', 'Не задан', 'dev_rto_uasp_piods', 'topic', 'rto_graph', 'producer_default', 'enrichOne.MainEnrichProperty$.out.FlinkSinkProperties$.toTopic' from dual  union 
select 'uasp-kriaa-bevents-case-86~main', 'flink_srv', 'Не задан', 'dev_rto_uasp_piods_dlq', 'topic', 'rto_graph', 'producer_default', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.toTopic' from dual  union 
select 'uasp-kriaa-bevents-insurence-cft~main', 'flink_srv', 'Не задан', 'dev_uasp_ins_change_vns', 'topic', 'rto_graph', 'producer_default', 'out.toTopic' from dual  union 
select 'uasp-kriaa-bevents-insurence-cft~main', 'flink_srv', 'Не задан', 'dev_uasp_ins_change_vns_dlq', 'topic', 'rto_graph', 'producer_default', 'dlq.toTopic' from dual  union 
select 'uasp-kriaa-bevents-insurence-kn~main', 'flink_srv', 'Не задан', 'dev_uasp_ins_add_vns', 'topic', 'rto_graph', 'producer_default', 'out.toTopic' from dual  union 
select 'uasp-kriaa-bevents-insurence-kn~main', 'flink_srv', 'Не задан', 'dev_uasp_ins_add_vns_dlq', 'topic', 'rto_graph', 'producer_default', 'dlq.toTopic' from dual  union 
select 'uasp-streaming-aggregate~aggregate-dko', 'flink_srv', 'Не задан', 'dev_ivr__uasp_realtime__aggregate__dlq', 'topic', 'rto_graph', 'producer_default', 'producer.ha.dlq.topic.name' from dual  union 
select 'uasp-streaming-aggregate~aggregate-dko', 'flink_srv', 'Не задан', 'dev_ivr__uasp_realtime__aggregate__filter', 'topic', 'rto_graph', 'producer_default', 'producer.ha.filter.status.topic.name' from dual  union 
select 'uasp-streaming-aggregate~aggregate-dko', 'flink_srv', 'Не задан', 'dev_ivr__uasp_realtime__aggregate__uaspdto', 'topic', 'rto_graph', 'producer_default', 'producer.ha.topic.name' from dual  union 
select 'uasp-streaming-beg-card-block~credit-card', 'flink_srv', 'Не задан', 'dev__rto_uasp__blcard', 'topic', 'rto_graph', 'producer_default', 'toTopic' from dual  union 
select 'uasp-streaming-beg-card-block~credit-card', 'flink_srv', 'Не задан', 'dev_uasp_ccpp_card_block_dlq', 'topic', 'rto_graph', 'producer_default', 'dlq.toTopic' from dual  union 
select 'uasp-streaming-beg-pincode-change~credit-card', 'flink_srv', 'Не задан', 'dev__rto_uasp__izmpin', 'topic', 'rto_graph', 'producer_default', 'toTopic' from dual  union 
select 'uasp-streaming-beg-pincode-change~credit-card', 'flink_srv', 'Не задан', 'dev_uasp_ccpp_card_pin_change_dlq', 'topic', 'rto_graph', 'producer_default', 'dlq.toTopic' from dual  union 
select 'uasp-streaming-cc-activation~credit-card', 'flink_srv', 'Не задан', 'dev_rto_uasp_actc', 'topic', 'rto_graph', 'producer_default', 'toTopic' from dual  union 
select 'uasp-streaming-cc-activation~credit-card', 'flink_srv', 'Не задан', 'dev_uasp_ccpp_card_activate_dlq', 'topic', 'rto_graph', 'producer_default', 'dlq.toTopic' from dual  union 
select 'uasp-streaming-currency-enrichment~case68', 'flink_srv', 'Не задан', 'dev_bevents_68_after_rate_enrich', 'topic', 'rto_graph', 'producer_default', 'out.toTopic' from dual  union 
select 'uasp-streaming-currency-enrichment~case68', 'flink_srv', 'Не задан', 'dev_bevents__realtime__enrichment_first_salary_transactions_dlq', 'topic', 'rto_graph', 'producer_default', 'dlq.toTopic' from dual  union 
select 'uasp-streaming-currency-enrichment~case68', 'flink_srv', 'Не задан', 'dev_bevents__uasp_realtime__outer_cbr_rate__status', 'topic', 'rto_graph', 'producer_default', 'rate.toTopic' from dual  union 
select 'uasp-streaming-currency-enrichment~first-salary', 'flink_srv', 'Не задан', 'dev_bevents__realtime__enrichment_first_salary_transactions_dlq', 'topic', 'rto_graph', 'producer_default', 'dlq.toTopic' from dual  union 
select 'uasp-streaming-currency-enrichment~first-salary', 'flink_srv', 'Не задан', 'dev_bevents__realtime__enrichment_first_salary_transactions__uaspdto', 'topic', 'rto_graph', 'producer_default', 'out.toTopic' from dual  union 
select 'uasp-streaming-currency-enrichment~first-salary', 'flink_srv', 'Не задан', 'dev_ivr__uasp_realtime__outer_cbr_rate__ask', 'topic', 'rto_graph', 'producer_default', 'rate.toTopic' from dual  union 
select 'uasp-streaming-filter~bevents-filter', 'flink_srv', 'Не задан', 'dev_bevents__realtime__filter_first_salary__filter', 'topic', 'rto_graph', 'producer_default', 'kafka.producer.filterTag-error.FlinkSinkProperties$.toTopic' from dual  union 
select 'uasp-streaming-filter~bevents-filter', 'flink_srv', 'Не задан', 'dev_bevents__realtime__filter_first_salary__uaspdto', 'topic', 'rto_graph', 'producer_default', 'kafka.producer.filterTag-success.toTopic' from dual  union 
select 'uasp-streaming-filter~main-input-filter', 'flink_srv', 'Не задан', 'dev_ivr__uasp_realtime__filter__uaspdto__filter', 'topic', 'rto_graph', 'producer_default', 'kafka.producer.filterTag-error.FlinkSinkProperties$.toTopic' from dual  union 
select 'uasp-streaming-filter~main-input-filter', 'flink_srv', 'Не задан', 'dev_ivr__uasp_realtime__mdm_enrichment__uaspdto', 'topic', 'rto_graph', 'producer_default', 'kafka.producer.filterTag-success.toTopic' from dual  union 
select 'uasp-streaming-input-convertor~close_account', 'flink_srv', 'Не задан', 'dev__uasp_usst__account-provider__ acc__ close-topic-003', 'topic', 'close_acc_graph', 'producer_default', 'output.toTopic' from dual  union 
select 'uasp-streaming-input-convertor~close_account', 'flink_srv', 'Не задан', 'dev__uasp_usst__account-provider__ acc__ close-topic-003_dlq', 'topic', 'close_acc_graph', 'producer_default', 'dlq.toTopic' from dual  union 
select 'uasp-streaming-input-convertor~customer-package', 'flink_srv', 'Не задан', 'dev__dko_uasp__pension_converted', 'topic', 'rto_graph', 'producer_default', 'output.toTopic' from dual  union 
select 'uasp-streaming-input-convertor~customer-package', 'flink_srv', 'Не задан', 'dev__dko_uasp__pension_dlq', 'topic', 'rto_graph', 'producer_default', 'dlq.toTopic' from dual  union 
select 'uasp-streaming-input-convertor~customer-profile-full', 'flink_srv', 'Не задан', 'dev_bevent__batch__ca_regulatory_client_id_of_profile__json_dlq', 'topic', 'rto_graph', 'producer_default', 'dlq.toTopic' from dual  union 
select 'uasp-streaming-input-convertor~customer-profile-full', 'flink_srv', 'Не задан', 'dev_bevents__batch__ca_regulatory_client_id_of_profile__json_converted', 'topic', 'rto_graph', 'producer_default', 'output.toTopic' from dual  union 
select 'uasp-streaming-input-convertor~input-convertor-ca-cardfl', 'flink_srv', 'Не задан', 'dev__dko_uasp__card_agreement_converted', 'topic', 'rto_graph', 'producer_default', 'output.toTopic' from dual  union 
select 'uasp-streaming-input-convertor~input-convertor-ca-cardfl', 'flink_srv', 'Не задан', 'dev__dko_uasp__card_agreement_dlq', 'topic', 'rto_graph', 'producer_default', 'dlq.toTopic' from dual  union 
select 'uasp-streaming-input-convertor~input-convertor-ca-depositfl', 'flink_srv', 'Не задан', 'dev_rto_batch_ca_deposit_account_case_71_dlq', 'topic', 'rto_graph', 'producer_default', 'dlq.toTopic' from dual  union 
select 'uasp-streaming-input-convertor~input-convertor-ca-depositfl', 'flink_srv', 'Не задан', 'dev_rto_batch_ca_deposit_account_case_71_json_converted', 'topic', 'rto_graph', 'producer_default', 'output.toTopic' from dual  union 
select 'uasp-streaming-input-convertor~input-convertor-ca-first-salary', 'flink_srv', 'Не задан', 'dev_bevents__batch__ca_first_salary_transactions_dlq', 'topic', 'rto_graph', 'producer_default', 'dlq.toTopic' from dual  union 
select 'uasp-streaming-input-convertor~input-convertor-ca-first-salary', 'flink_srv', 'Не задан', 'dev_bevents__batch__ca_first_salary_transactions__json_converted', 'topic', 'rto_graph', 'producer_default', 'output.toTopic' from dual  union 
select 'uasp-streaming-input-convertor~input-convertor-cardfl', 'flink_srv', 'Не задан', 'dev_input_converter_cardfl_refill_uasp', 'topic', 'rto_graph', 'producer_default', 'output.toTopic' from dual  union 
select 'uasp-streaming-input-convertor~input-convertor-cardfl', 'flink_srv', 'Не задан', 'dev_input_converter_cardfl_refill_uasp_dlq', 'topic', 'rto_graph', 'producer_default', 'dlq.toTopic' from dual  union 
select 'uasp-streaming-input-convertor~input-convertor-cft', 'flink_srv', 'Не задан', 'dev_bevents_card_agreement_enrich_out_uaspdto', 'topic', 'rto_graph', 'producer_default', 'output.toTopic' from dual  union 
select 'uasp-streaming-input-convertor~input-convertor-cft', 'flink_srv', 'Не задан', 'dev_bevents__realtime__input_converter__cft__transactions__dlq', 'topic', 'rto_graph', 'producer_default', 'dlq.toTopic' from dual  union 
select 'uasp-streaming-input-convertor~input-convertor-mdm', 'flink_srv', 'Не задан', 'dev_ivr__uasp_realtime__input_converter__mdm_cross_link__dlq', 'topic', 'rto_graph', 'producer_default', 'dlq.toTopic' from dual  union 
select 'uasp-streaming-input-convertor~input-convertor-mdm', 'flink_srv', 'Не задан', 'dev_ivr__uasp_realtime__input_converter__mdm_cross_link__uaspdto', 'topic', 'rto_graph', 'producer_default', 'output.toTopic' from dual  union 
select 'uasp-streaming-input-convertor~input-convertor-prof-auth', 'flink_srv', 'Не задан', 'dev_bevents_streaming_input_convertor_profile_auth_dlq', 'topic', 'rto_graph', 'producer_default', 'dlq.toTopic' from dual  union 
select 'uasp-streaming-input-convertor~input-convertor-prof-auth', 'flink_srv', 'Не задан', 'dev_bevents_streaming_input_convertor_profile_auth_uaspdto', 'topic', 'rto_graph', 'producer_default', 'output.toTopic' from dual  union 
select 'uasp-streaming-input-convertor~input-convertor-profile', 'flink_srv', 'Не задан', 'dev_bevents__realtime__input_converter__prof__transactions__dlq', 'topic', 'rto_graph', 'producer_default', 'dlq.toTopic' from dual  union 
select 'uasp-streaming-input-convertor~input-convertor-profile', 'flink_srv', 'Не задан', 'dev_bevents__realtime__input_converter__prof__transactions__uaspdto', 'topic', 'rto_graph', 'producer_default', 'output.toTopic' from dual  union 
select 'uasp-streaming-input-convertor~input-convertor-udds', 'flink_srv', 'Не задан', 'dev_bevents_cft_way4_profile_udds_after_mutator_uaspdto', 'topic', 'rto_graph', 'producer_default', 'output.toTopic' from dual  union 
select 'uasp-streaming-input-convertor~input-convertor-udds', 'flink_srv', 'Не задан', 'dev__udds_uasp__up_dlq', 'topic', 'rto_graph', 'producer_default', 'dlq.toTopic' from dual  union 
select 'uasp-streaming-input-convertor~input-convertor-w4-operation', 'flink_srv', 'Не задан', 'dev_ivr__uasp_realtime__input_converter__way4_issuing_operation__dlq', 'topic', 'rto_graph', 'producer_default', 'dlq.toTopic' from dual  union 
select 'uasp-streaming-input-convertor~input-convertor-w4-operation', 'flink_srv', 'Не задан', 'dev_ivr__uasp_realtime__input_converter__way4_issuing_operation__uaspdto', 'topic', 'rto_graph', 'producer_default', 'output.toTopic' from dual  union 
select 'uasp-streaming-input-convertor~input-convertor-withdraw', 'flink_srv', 'Не задан', 'dev_bevents__realtime__enrichment__prof__transactions_first__uaspdto', 'topic', 'rto_graph', 'producer_default', 'output.toTopic' from dual  union 
select 'uasp-streaming-input-convertor~input-convertor-withdraw', 'flink_srv', 'Не задан', 'dev_input_withdraw_tx_dlq', 'topic', 'rto_graph', 'producer_default', 'dlq.toTopic' from dual  union 
select 'uasp-streaming-input-convertor~loyalty', 'flink_srv', 'Не задан', 'dev_bevents_card_agreement_enrich_out_uaspdto', 'topic', 'rto_graph', 'producer_default', 'output.toTopic' from dual  union 
select 'uasp-streaming-input-convertor~loyalty', 'flink_srv', 'Не задан', 'dev__boop_uasp__uss__loyalty_profile_changes_dlq', 'topic', 'rto_graph', 'producer_default', 'dlq.toTopic' from dual  union 
select 'uasp-streaming-input-convertor~mdm-profile', 'flink_srv', 'Не задан', 'dev_bevents__batch__ca_regulatory_contract_num_of_mdm_id_profile__uaspdto', 'topic', 'rto_graph', 'producer_default', 'output.toTopic' from dual  union 
select 'uasp-streaming-input-convertor~mdm-profile', 'flink_srv', 'Не задан', 'dev_ivr__uasp_realtime__input_converter__mdm_cross_link__dlq', 'topic', 'rto_graph', 'producer_default', 'dlq.toTopic' from dual  union 
select 'uasp-streaming-json-validator~insurance', 'flink_srv', 'Не задан', 'dev_sstr_uasp_pay_inf_ack', 'topic', 'rto_graph', 'producer_default', 'ack.toTopic' from dual  union 
select 'uasp-streaming-json-validator~insurance', 'flink_srv', 'Не задан', 'dev_sstr_uasp_pay_inf_valid', 'topic', 'rto_graph', 'producer_default', 'toTopic' from dual  union 
select 'uasp-streaming-json-validator~kn', 'flink_srv', 'Не задан', 'dev__mscl_uasp_applic_valid', 'topic', 'rto_graph', 'producer_default', 'toTopic' from dual  union 
select 'uasp-streaming-json-validator~kn', 'flink_srv', 'Не задан', 'dev__mscl_uasp_applic_valid_ack', 'topic', 'rto_graph', 'producer_default', 'ack.toTopic' from dual  union 
select 'uasp-streaming-json-validator~uz', 'flink_srv', 'Не задан', 'dev__mssa_uasp_applic_valid', 'topic', 'rto_graph', 'producer_default', 'toTopic' from dual  union 
select 'uasp-streaming-json-validator~uz', 'flink_srv', 'Не задан', 'dev__mssa_uasp_applic_valid_ack', 'topic', 'rto_graph', 'producer_default', 'ack.toTopic' from dual  union 
select 'uasp-streaming-mdm-enrichment~case-68', 'flink_srv', 'Не задан', 'dev_bevents_cft_way4_profile_udds_before_case68_uaspdto', 'topic', 'rto_graph', 'producer_default', 'enrichOne.MainEnrichProperty$.out.FlinkSinkProperties$.toTopic' from dual  union 
select 'uasp-streaming-mdm-enrichment~case-68', 'flink_srv', 'Не задан', 'dev_bevents_udds_mdm_rate_case68_uaspdto_dlq', 'topic', 'rto_graph', 'producer_default', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.toTopic' from dual  union 
select 'uasp-streaming-mdm-enrichment~case-68', 'flink_srv', 'Не задан', 'dev_input_converter_cardfl_refill_uasp_dlq', 'topic', 'rto_graph', 'producer_default', 'enrichOne.CommonEnrichProperty$.dlq.FlinkSinkProperties$.toTopic' from dual  union 
select 'uasp-streaming-mdm-enrichment~case-68_agrement', 'flink_srv', 'Не задан', 'dev_bevents_cft_way4_profile_udds_before_case68_uaspdto_dlq', 'topic', 'rto_graph', 'producer_default', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.toTopic' from dual  union 
select 'uasp-streaming-mdm-enrichment~case-68_agrement', 'flink_srv', 'Не задан', 'dev_bevents_udds_mdm_rate_case68_uaspdto', 'topic', 'rto_graph', 'producer_default', 'enrichOne.MainEnrichProperty$.out.FlinkSinkProperties$.toTopic' from dual  union 
select 'uasp-streaming-mdm-enrichment~case-68_agrement', 'flink_srv', 'Не задан', 'dev_rto_batch_ca_customer_card68_uaspdto_dlq', 'topic', 'rto_graph', 'producer_default', 'enrichOne.CommonEnrichProperty$.dlq.FlinkSinkProperties$.toTopic' from dual  union 
select 'uasp-streaming-mdm-enrichment~prof-auth', 'flink_srv', 'Не задан', 'dev_bevents_card_agreement_enrich_dlq', 'topic', 'rto_graph', 'producer_default', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.toTopic' from dual  union 
select 'uasp-streaming-mdm-enrichment~prof-auth', 'flink_srv', 'Не задан', 'dev_bevents_card_agreement_enrich_out_uaspdto', 'topic', 'rto_graph', 'producer_default', 'enrichOne.MainEnrichProperty$.out.FlinkSinkProperties$.toTopic' from dual  union 
select 'uasp-streaming-mdm-enrichment~prof-auth', 'flink_srv', 'Не задан', 'dev_rto_batch_ca_customer_card_uaspdto__dlq', 'topic', 'rto_graph', 'producer_default', 'enrichOne.GlobalIdEnrichProperty$.dlq.FlinkSinkProperties$.toTopic' from dual  union 
select 'uasp-streaming-mdm-enrichment~prof-auth-packNM', 'flink_srv', 'Не задан', 'dev_bevents_package_nm_enrich_dlq', 'topic', 'rto_graph', 'producer_default', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.toTopic' from dual  union 
select 'uasp-streaming-mdm-enrichment~prof-auth-packNM', 'flink_srv', 'Не задан', 'dev_bevents__realtime__enrichment__prof__transactions_first__uaspdto', 'topic', 'rto_graph', 'producer_default', 'enrichOne.MainEnrichProperty$.out.FlinkSinkProperties$.toTopic' from dual  union 
select 'uasp-streaming-mdm-enrichment~prof-auth-packNM', 'flink_srv', 'Не задан', 'dev_rto_batch_ca_customer_package_dlq', 'topic', 'rto_graph', 'producer_default', 'enrichOne.CommonEnrichProperty$.dlq.FlinkSinkProperties$.toTopic' from dual  union 
select 'uasp-streaming-mdm-enrichment~profile-tx-step1', 'flink_srv', 'Не задан', 'dev_bevents__realtime__enrichment__prof__contract_num__uaspdto', 'topic', 'rto_graph', 'producer_default', 'enrichOne.MainEnrichProperty$.out.FlinkSinkProperties$.toTopic' from dual  union 
select 'uasp-streaming-mdm-enrichment~profile-tx-step1', 'flink_srv', 'Не задан', 'dev_bevents__realtime__enrichment__prof__transactions_with_clientid__dlq', 'topic', 'rto_graph', 'producer_default', 'enrichOne.GlobalIdEnrichProperty$.dlq.FlinkSinkProperties$.toTopic' from dual  union 
select 'uasp-streaming-mdm-enrichment~profile-tx-step1', 'flink_srv', 'Не задан', 'dev_bevents__realtime__enrichment__prof__transactions_with_contract_num__dlq', 'topic', 'rto_graph', 'producer_default', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.toTopic' from dual  union 
select 'uasp-streaming-mdm-enrichment~profile-tx-step2', 'flink_srv', 'Не задан', 'dev_bevents_card_agreement_enrich_out_uaspdto', 'topic', 'rto_graph', 'producer_default', 'enrichOne.MainEnrichProperty$.out.FlinkSinkProperties$.toTopic' from dual  union 
select 'uasp-streaming-mdm-enrichment~profile-tx-step2', 'flink_srv', 'Не задан', 'dev_bevents__realtime__enrichment__prof__transactions_with_mdm_id__dlq', 'topic', 'rto_graph', 'producer_default', 'enrichOne.GlobalIdEnrichProperty$.dlq.FlinkSinkProperties$.toTopic' from dual  union 
select 'uasp-streaming-mdm-enrichment~profile-tx-step2', 'flink_srv', 'Не задан', 'dev_bevents__realtime__enrichment__prof__transactions_with_partyUId__dlq', 'topic', 'rto_graph', 'producer_default', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.toTopic' from dual  union 
select 'uasp-streaming-mdm-enrichment~prof-tx-case-71', 'flink_srv', 'Не задан', 'dev_bevents__realtime__case_71__uaspdto', 'topic', 'rto_graph', 'producer_default', 'enrichOne.MainEnrichProperty$.out.FlinkSinkProperties$.toTopic' from dual  union 
select 'uasp-streaming-mdm-enrichment~prof-tx-case-71', 'flink_srv', 'Не задан', 'dev_bevents__realtime__case_71__uaspdto_dlq', 'topic', 'rto_graph', 'producer_default', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.toTopic' from dual  union 
select 'uasp-streaming-mdm-enrichment~prof-tx-case-71', 'flink_srv', 'Не задан', 'dev_rto_batch_ca_deposit_account_case_71_uaspdto__dlq', 'topic', 'rto_graph', 'producer_default', 'enrichOne.CommonEnrichProperty$.dlq.FlinkSinkProperties$.toTopic' from dual  union 
select 'uasp-streaming-mdm-enrichment~way4', 'flink_srv', 'Не задан', 'dev_ivr__uasp_realtime__input_converter__mortgage__dlq', 'topic', 'rto_graph', 'producer_default', 'enrichOne.CommonEnrichProperty$.dlq.FlinkSinkProperties$.toTopic' from dual  union 
select 'uasp-streaming-mdm-enrichment~way4', 'flink_srv', 'Не задан', 'dev_ivr__uasp_realtime__mdm_enrichment__for_additional_enrichment__uaspdto', 'topic', 'rto_graph', 'producer_default', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.toTopic' from dual  union 
select 'uasp-streaming-mdm-enrichment~way4', 'flink_srv', 'Не задан', 'dev_ivr__uasp_realtime__mdm_enrichment__mdm_cross_link__status__dlq', 'topic', 'rto_graph', 'producer_default', 'enrichOne.GlobalIdEnrichProperty$.dlq.FlinkSinkProperties$.toTopic' from dual  union 
select 'uasp-streaming-mdm-enrichment~way4', 'flink_srv', 'Не задан', 'dev_ivr__uasp_realtime_way4_mdm_enrichment__uaspdto', 'topic', 'rto_graph', 'producer_default', 'enrichOne.MainEnrichProperty$.out.FlinkSinkProperties$.toTopic' from dual  union 
select 'uasp-streaming-mdm-enrichment~way4-card-agreement', 'flink_srv', 'Не задан', 'dev_bevents_card_agreement_enrich_out_uaspdto', 'topic', 'rto_graph', 'producer_default', 'enrichOne.MainEnrichProperty$.out.FlinkSinkProperties$.toTopic' from dual  union 
select 'uasp-streaming-mdm-enrichment~way4-card-agreement', 'flink_srv', 'Не задан', 'dev_bevents_card_agreement_enrich_way4_dlq', 'topic', 'rto_graph', 'producer_default', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.toTopic' from dual  union 
select 'uasp-streaming-mdm-enrichment~way4-card-agreement', 'flink_srv', 'Не задан', 'dev_rto_batch_ca_customer_card_uaspdto__dlq', 'topic', 'rto_graph', 'producer_default', 'enrichOne.CommonEnrichProperty$.dlq.FlinkSinkProperties$.toTopic' from dual  union 
select 'uasp-streaming-model-vector~model-vector-bevents', 'flink_srv', 'Не задан', 'dev_bevents__realtime__modelvector_first_salary__dlq', 'topic', 'rto_graph', 'producer_default', 'producer.dlq.FlinkSinkProperties$.toTopic' from dual  union 
select 'uasp-streaming-model-vector~model-vector-bevents', 'flink_srv', 'Не задан', 'dev_bevents__realtime__modelvector_first_salary__qa', 'topic', 'rto_graph', 'producer_default', 'producer.qa.FlinkSinkProperties$.toTopic' from dual  union 
select 'uasp-streaming-model-vector~model-vector-bevents', 'flink_srv', 'Не задан', 'dev__rto_uasp__case_39_old', 'topic', 'rto_graph', 'producer_default', 'producer.pos.FlinkSinkProperties$.toTopic' from dual  union 
select 'uasp-streaming-model-vector~model-vector-bevents', 'flink_srv', 'Не задан', 'dev__rto_uasp__case_39_vector', 'topic', 'rto_graph', 'producer_default', 'producer.posNew.FlinkSinkProperties$.toTopic' from dual  union 
select 'uasp-streaming-model-vector~model-vector-bevents', 'flink_srv', 'Не задан', 'dev__rto_uasp__case_44', 'topic', 'rto_graph', 'producer_default', 'producer.case44.FlinkSinkProperties$.toTopic' from dual  union 
select 'uasp-streaming-model-vector~model-vector-bevents', 'flink_srv', 'Не задан', 'dev__rto_uasp__case_48', 'topic', 'rto_graph', 'producer_default', 'producer.case48.FlinkSinkProperties$.toTopic' from dual  union 
select 'uasp-streaming-model-vector~model-vector-bevents', 'flink_srv', 'Не задан', 'dev__rto_uasp__case_51', 'topic', 'rto_graph', 'producer_default', 'producer.case51.FlinkSinkProperties$.toTopic' from dual  union 
select 'uasp-streaming-model-vector~model-vector-bevents', 'flink_srv', 'Не задан', 'dev__rto_uasp__case_71', 'topic', 'rto_graph', 'producer_default', 'producer.case71.FlinkSinkProperties$.toTopic' from dual  union 
select 'uasp-streaming-model-vector~model-vector-bevents', 'flink_srv', 'Не задан', 'dev__rto_uasp__izost', 'topic', 'rto_graph', 'producer_default', 'producer.case8.FlinkSinkProperties$.toTopic' from dual  union 
select 'uasp-streaming-model-vector~model-vector-bevents', 'flink_srv', 'Не задан', 'dev__rto_uasp__pdscp', 'topic', 'rto_graph', 'producer_default', 'producer.case29.FlinkSinkProperties$.toTopic' from dual  union 
select 'uasp-streaming-model-vector~model-vector-bevents', 'flink_srv', 'Не задан', 'dev__rto_uasp__pks', 'topic', 'rto_graph', 'producer_default', 'producer.case69.FlinkSinkProperties$.toTopic' from dual  union 
select 'uasp-streaming-model-vector~model-vector-bevents', 'flink_srv', 'Не задан', 'dev__rto_uasp__ppnsx', 'topic', 'rto_graph', 'producer_default', 'producer.ns.FlinkSinkProperties$.toTopic' from dual  union 
select 'uasp-streaming-model-vector~model-vector-bevents', 'flink_srv', 'Не задан', 'dev__rto_uasp__zp', 'topic', 'rto_graph', 'producer_default', 'producer.pens.FlinkSinkProperties$.toTopic' from dual  union 
select 'uasp-streaming-model-vector~model-vector-bevents', 'flink_srv', 'Не задан', 'dev__rto_uasp__zzp', 'topic', 'rto_graph', 'producer_default', 'producer.fs.FlinkSinkProperties$.toTopic' from dual  union 
select 'uasp-streaming-mutator~case-48-concatenate', 'flink_srv', 'Не задан', 'dev_ivr__uasp_realtime__case_48_concatenate__uaspdto', 'topic', 'rto_graph', 'producer_default', 'kafka.producers.filterErrorTag-success.toTopic' from dual  union 
select 'uasp-streaming-mutator~case-48-concatenate', 'flink_srv', 'Не задан', 'dev_ivr__uasp_realtime__mdm_enrichment__uaspdto__dlq', 'topic', 'rto_graph', 'producer_default', 'kafka.producers.filterErrorTag-error.FlinkSinkProperties$.toTopic' from dual  union 
select 'uasp-streaming-mutator~mainInput', 'flink_srv', 'Не задан', 'dev_ivr__uasp_realtime__business_rules__uaspdto', 'topic', 'rto_graph', 'producer_default', 'kafka.producers.filterErrorTag-success.toTopic' from dual  union 
select 'uasp-streaming-mutator~mainInput', 'flink_srv', 'Не задан', 'dev_ivr__uasp_realtime__bussiness_rules__uaspdto__dlq', 'topic', 'rto_graph', 'producer_default', 'kafka.producers.filterErrorTag-error.FlinkSinkProperties$.toTopic' from dual  union 
select 'uasp-streaming-mutator~rateMutate', 'flink_srv', 'Не задан', 'dev_bevents__realtime__enrichment_prepare_transactions__dlq', 'topic', 'rto_graph', 'producer_default', 'kafka.producers.filterErrorTag-error.FlinkSinkProperties$.toTopic' from dual  union 
select 'uasp-streaming-mutator~rateMutate', 'flink_srv', 'Не задан', 'dev_bevents__realtime__enrichment_prepare_transactions__uaspdto', 'topic', 'rto_graph', 'producer_default', 'kafka.producers.filterErrorTag-success.toTopic' from dual  union 
select 'uasp-streaming-mutator~uddsRate', 'flink_srv', 'Не задан', 'dev_bevents_cft_way4_profile_udds_before_mdm_rate_case68_uaspdto', 'topic', 'rto_graph', 'producer_default', 'kafka.producers.filterErrorTag-success.toTopic' from dual  union 
select 'uasp-streaming-mutator~uddsRate', 'flink_srv', 'Не задан', 'dev_bevents_cft_way4_profile_udds_before_mdm_rate_case68_uaspdto_dlq', 'topic', 'rto_graph', 'producer_default', 'kafka.producers.filterErrorTag-error.FlinkSinkProperties$.toTopic' from dual  union 
select 'uasp-streaming-refunds-event-notifier~main', 'flink_srv', 'Не задан', 'dev_bevents__realtime__filter_first_salary__uaspdto', 'topic', 'rto_graph', 'producer_default', 'out.toTopic' from dual  union 
select 'uasp-streaming-refunds-event-notifier~main', 'flink_srv', 'Не задан', 'dev_bevents__realtime__refunds-notifier__dlq', 'topic', 'rto_graph', 'producer_default', 'dlq.toTopic' from dual  union 
select 'uasp-streaming-rto-15~uasp-streaming-rto-15', 'flink_srv', 'Не задан', 'prod_rto_uasp_usapns', 'topic', 'rto_graph', 'producer_default', 'toTopic' from dual  union 
select 'uasp-streaming-rto-15~uasp-streaming-rto-15', 'flink_srv', 'Не задан', 'prod_rto_uasp_usapns__dlq', 'topic', 'rto_graph', 'producer_default', 'dlq.toTopic' from dual  union 
select 'uasp-streaming-rto-37~uasp-streaming-rto-37', 'flink_srv', 'Не задан', 'dev_rto_uasp_ons', 'topic', 'rto_graph', 'producer_default', 'toTopic' from dual  union 
select 'uasp-streaming-rto-37~uasp-streaming-rto-37', 'flink_srv', 'Не задан', 'dev_rto_uasp_ons__dlq', 'topic', 'rto_graph', 'producer_default', 'dlq.toTopic' from dual  union 
select 'uasp-streaming-rto-attempt-close-part2~uasp-streaming-rto-attempt-close-part2', 'flink_srv', 'Не задан', 'dev_rto_uasp_pzns_dlq', 'topic', 'rto_graph', 'producer_default', 'dlq.toTopic' from dual  union 
select 'uasp-streaming-rto-attempt-close-part2~uasp-streaming-rto-attempt-close-part2', 'flink_srv', 'Не задан', 'prod_rto_uasp_pzv', 'topic', 'rto_graph', 'producer_default', 'toTopic' from dual  union 
select 'uasp-streaming-rto-bcps-card-emission-digital~uasp-streaming-rto-bcps-card-emission-digital', 'flink_srv', 'Не задан', 'dev_rto_uasp_actc', 'topic', 'rto_graph', 'producer_default', 'toTopic' from dual  union 
select 'uasp-streaming-rto-bcps-card-emission-digital~uasp-streaming-rto-bcps-card-emission-digital', 'flink_srv', 'Не задан', 'dev_uasp_bcps_ced_dlq', 'topic', 'rto_graph', 'producer_default', 'dlq.toTopic' from dual  union 
select 'uasp-streaming-rto-bcps-card-emission-digital~uasp-streaming-rto-bcps-card-emission-digital-mock-test', 'flink_srv', 'Не задан', 'dev_rto_uasp_actc', 'topic', 'rto_graph', 'producer_default', 'toTopic' from dual  union 
select 'uasp-streaming-rto-bcps-card-emission-digital~uasp-streaming-rto-bcps-card-emission-digital-mock-test', 'flink_srv', 'Не задан', 'dev_uasp_bcps_ced_dlq', 'topic', 'rto_graph', 'producer_default', 'dlq.toTopic' from dual  union 
select 'uasp-streaming-rto-bcps-status-change~uasp-streaming-rto-bcps-status-change', 'flink_srv', 'Не задан', 'dev_rto_uasp_actc', 'topic', 'rto_graph', 'producer_default', 'toTopic' from dual  union 
select 'uasp-streaming-rto-bcps-status-change~uasp-streaming-rto-bcps-status-change', 'flink_srv', 'Не задан', 'dev_uasp_bcps_csc_dlq', 'topic', 'rto_graph', 'producer_default', 'dlq.toTopic' from dual  union 
select 'uasp-streaming-rto-bcps-status-change~uasp-streaming-rto-bcps-status-change-mock-test', 'flink_srv', 'Не задан', 'dev_rto_uasp_actc', 'topic', 'rto_graph', 'producer_default', 'toTopic' from dual  union 
select 'uasp-streaming-rto-bcps-status-change~uasp-streaming-rto-bcps-status-change-mock-test', 'flink_srv', 'Не задан', 'dev_uasp_bcps_csc_dlq', 'topic', 'rto_graph', 'producer_default', 'dlq.toTopic' from dual  union 
select 'uasp-streaming-rto-card-activation-way4~uasp-streaming-rto-card-activation-way4', 'flink_srv', 'Не задан', 'dev_mdm-usst-output', 'topic', 'rto_graph', 'producer_default', 'mdm.toTopic' from dual  union 
select 'uasp-streaming-rto-card-activation-way4~uasp-streaming-rto-card-activation-way4', 'flink_srv', 'Не задан', 'dev_rto_uasp_actc', 'topic', 'rto_graph', 'producer_default', 'toTopic' from dual  union 
select 'uasp-streaming-rto-card-activation-way4~uasp-streaming-rto-card-activation-way4', 'flink_srv', 'Не задан', 'dev_rto_uasp_actc_way4_dlq', 'topic', 'rto_graph', 'producer_default', 'dlq.toTopic' from dual  union 
select 'uasp-streaming-rto-card-activation-way4~uasp-streaming-rto-card-activation-way4-mock-test', 'flink_srv', 'Не задан', 'dev_mdm-usst-output', 'topic', 'rto_graph', 'producer_default', 'mdm.toTopic' from dual  union 
select 'uasp-streaming-rto-card-activation-way4~uasp-streaming-rto-card-activation-way4-mock-test', 'flink_srv', 'Не задан', 'dev_rto_uasp_actc', 'topic', 'rto_graph', 'producer_default', 'toTopic' from dual  union 
select 'uasp-streaming-rto-card-activation-way4~uasp-streaming-rto-card-activation-way4-mock-test', 'flink_srv', 'Не задан', 'dev_rto_uasp_actc_way4_dlq', 'topic', 'rto_graph', 'producer_default', 'dlq.toTopic' from dual  union 
select 'uasp-streaming-rto-closing-deposit~uasp-streaming-rto-closing-deposit', 'flink_srv', 'Не задан', 'prod_rto_uasp_pzv', 'topic', 'rto_graph', 'producer_default', 'toTopic' from dual  union 
select 'uasp-streaming-rto-closing-deposit~uasp-streaming-rto-closing-deposit', 'flink_srv', 'Не задан', 'prod_rto_uasp_pzv__dlq', 'topic', 'rto_graph', 'producer_default', 'dlq.toTopic' from dual  union 
select 'uasp-streaming-rto-dko-4_62~uasp-streaming-rto-dko-4_62', 'flink_srv', 'Не задан', 'dev__rto_uasp__case_62', 'topic', 'rto_graph', 'producer_default', 'toTopic' from dual  union 
select 'uasp-streaming-rto-dko-4_62~uasp-streaming-rto-dko-4_62', 'flink_srv', 'Не задан', 'dev__rto_uasp__case_62_prf_dlq', 'topic', 'rto_graph', 'producer_default', 'profile.dlq.toTopic' from dual  union 
select 'uasp-streaming-rto-dko-4_62~uasp-streaming-rto-dko-4_62', 'flink_srv', 'Не задан', 'dev__rto_uasp__case_62_way4_dlq', 'topic', 'rto_graph', 'producer_default', 'way4.dlq.toTopic' from dual  union 
select 'uasp-streaming-rto-mortgage-approval~uasp-streaming-rto-mortgage-approval-prod', 'flink_srv', 'Не задан', 'prod__dlq__ipo_uasp__od', 'topic', 'rto_graph', 'producer_default', 'dlq.toTopic' from dual  union 
select 'uasp-streaming-rto-mortgage-approval~uasp-streaming-rto-mortgage-approval-prod', 'flink_srv', 'Не задан', 'prod__rto_uasp_ipood', 'topic', 'rto_graph', 'producer_default', 'toTopic' from dual  union 
select 'uasp-streaming-rto-ofvs~uasp-streaming-rto-ofvs', 'flink_srv', 'Не задан', 'dev__rto_uasp__ofvs', 'topic', 'ofvs', 'producer_default', 'toTopic' from dual  union 
select 'uasp-streaming-rto-ofvs~uasp-streaming-rto-ofvs', 'flink_srv', 'Не задан', 'dev__rto_uasp__ofvs__dlq', 'topic', 'ofvs', 'producer_default', 'dlq.toTopic' from dual  union 
select 'uasp-streaming-rto-open-deposit~uasp-streaming-rto-open-deposit', 'flink_srv', 'Не задан', 'prod_rto_uasp_ov', 'topic', 'rto_graph', 'producer_default', 'toTopic' from dual  union 
select 'uasp-streaming-rto-open-deposit~uasp-streaming-rto-open-deposit', 'flink_srv', 'Не задан', 'prod_rto_uasp_ov__dlq', 'topic', 'rto_graph', 'producer_default', 'dlq.toTopic' from dual  union 
select 'uasp-streaming-rto-status-execution-goal~uasp-streaming-rto-status-execution-goal', 'flink_srv', 'Не задан', 'dev_rto_uasp_svc', 'topic', 'rto_graph', 'producer_default', 'toTopic' from dual  union 
select 'uasp-streaming-rto-status-execution-goal~uasp-streaming-rto-status-execution-goal', 'flink_srv', 'Не задан', 'dev_rto_uasp_svc_dlq', 'topic', 'rto_graph', 'producer_default', 'dlq.toTopic' from dual  union 
select 'uasp-streaming-rto-zoc~uasp-streaming-rto-zoc', 'flink_srv', 'Не задан', 'dev__uasp__rto__zoc', 'topic', 'rto_graph', 'producer_default', 'toTopic' from dual  union 
select 'uasp-streaming-rto-zoc~uasp-streaming-rto-zoc', 'flink_srv', 'Не задан', 'dev__uasp__rto__zoc__dlq', 'topic', 'rto_graph', 'producer_default', 'dlq.toTopic' from dual  union 
select 'uasp-streaming-unp-convertor~aggregate-ca', 'flink_srv', 'Не задан', 'dev_bevents__realtime__enrichment_first_salary_transactions__uaspdto', 'topic', 'rto_graph', 'producer_default', 'producer.toTopic' from dual  union 
select 'uasp-streaming-unp-convertor~cardfl', 'flink_srv', 'Не задан', 'dev__uasp_aprf__pks', 'topic', 'rto_graph', 'producer_default', 'producer.toTopic' from dual  union 
select 'uasp-streaming-unp-convertor~case68', 'flink_srv', 'Не задан', 'dev_bevents_cft_way4_profile_udds_before_mdm_rate_case68_uaspdto', 'topic', 'rto_graph', 'producer_default', 'producer.toTopic' from dual  union 
select 'uasp-streaming-unp-convertor~cbr-rate', 'flink_srv', 'Не задан', 'dev_ivr__uasp_realtime__outer_cbr_rate__ask', 'topic', 'rto_graph', 'producer_default', 'producer.toTopic' from dual  union 
select 'uasp-streaming-unp-convertor~cft-transactions', 'flink_srv', 'Не задан', 'CFT2RS_CD_OUT', 'topic', 'rto_graph', 'producer_default', 'producer.toTopic' from dual  union 
select 'uasp-streaming-unp-convertor~close_account', 'flink_srv', 'Не задан', 'dev__account-provider__ acc__ close_unp', 'topic', 'close_acc_graph', 'producer_default', 'producer.toTopic' from dual  union 
select 'uasp-streaming-unp-convertor~outer-cbr-rate', 'flink_srv', 'Не задан', 'PROD.OUTER.CBR.RATES.ACK', 'topic', 'rto_graph', 'producer_CBR_RATE', 'producer.toTopic' from dual  union 
select 'uasp-streaming-unp-convertor~profile-auth', 'flink_srv', 'Не задан', 'dev_bevents_streaming_input_convertor_profile_auth_json', 'topic', 'rto_graph', 'producer_default', 'producer.toTopic' from dual  union 
select 'uasp-streaming-unp-convertor~udds-3to8', 'flink_srv', 'Не задан', 'dev__udds_uasp__up_unp', 'topic', 'rto_graph', 'producer_default', 'producer.toTopic' from dual  union 
select 'uasp-streaming-unp-convertor~unp_w4_issuing_card', 'flink_srv', 'Не задан', 'dev_ivr__uasp_realtime__input_converter__way4_issuing_card__json', 'topic', 'rto_graph', 'producer_default', 'producer.toTopic' from dual  union 
select 'uasp-streaming-unp-convertor~w4-account-balance', 'flink_srv', 'Не задан', 'dev_ivr__uasp_realtime__input_converter__way4_issuing_account_balance__json', 'topic', 'rto_graph', 'producer_default', 'producer.toTopic' from dual  union 
select 'uasp-streaming-unp-convertor~way4-main', 'flink_srv', 'Не задан', 'dev_ivr_uasp_realtime_way4_main_input_issuing_operation__json', 'topic', 'rto_graph', 'producer_default', 'producer.toTopic' from dual  union 
select 'uasp-streaming-unp-convertor~way4-transactions', 'flink_srv', 'Не задан', 'dev_bevents__realtime__enrichment__prof__transactions_first__uaspdto', 'topic', 'rto_graph', 'producer_default', 'producer.toTopic' from dual  union 
select 'uasp-streaming-unp-convertor~withdraw-transactions', 'flink_srv', 'Не задан', 'withdraw_tx_out', 'topic', 'rto_graph', 'producer_default', 'producer.toTopic' from dual  union 
select 'withdraw_tx_out', 'topic', 'Не задан', 'uasp-streaming-input-convertor~input-convertor-withdraw', 'flink_srv', 'rto_graph', 'latest', 'input.fromTopic' from dual ;

insert into dict_kafka_prop_value(grp_id, prop_id, prop_value, type_prop) 
select 'earliest', 'auto.offset.reset', 'earliest', 'cns' from dual  union 
select 'earliest', 'bootstrap.servers', '${BOOTSTRAP_SERVERS}', 'cns' from dual  union 
select 'earliest', 'fetch.min.bytes', '50', 'cns' from dual  union 
select 'earliest', 'isolation.level', 'read_uncommitted', 'cns' from dual  union 
select 'earliest', 'security.protocol', 'SSL', 'cns' from dual  union 
select 'earliest', 'session.timeout.ms', '72000000', 'cns' from dual  union 
select 'earliest', 'ssl.key.password', '${DSO_KAFKA_SSL_KEY_PASSWORD}', 'cns' from dual  union 
select 'earliest', 'ssl.keystore.location', '${KEYSTORE_LOCATION} ', 'cns' from dual  union 
select 'earliest', 'ssl.keystore.password', '${DSO_KAFKA_SSL_KEYSTORE_PASSWORD}', 'cns' from dual  union 
select 'earliest', 'ssl.keystore.type', 'PKCS12', 'cns' from dual  union 
select 'earliest', 'ssl.truststore.location', '${TRUSTSTORE_LOCATION}', 'cns' from dual  union 
select 'earliest', 'ssl.truststore.password', '${DSO_KAFKA_SSL_TRUSTSTORE_PASSWORD}', 'cns' from dual  union 
select 'earliest', 'ssl.truststore.type', 'PKCS12', 'cns' from dual  union 
select 'earliest_CARDFL_BOOTSTRAP_SERVERS', 'auto.offset.reset', 'earliest', 'cns' from dual  union 
select 'earliest_CARDFL_BOOTSTRAP_SERVERS', 'bootstrap.servers', '${CARDFL_BOOTSTRAP_SERVERS}', 'cns' from dual  union 
select 'earliest_CARDFL_BOOTSTRAP_SERVERS', 'fetch.min.bytes', '50', 'cns' from dual  union 
select 'earliest_CARDFL_BOOTSTRAP_SERVERS', 'isolation.level', 'read_uncommitted', 'cns' from dual  union 
select 'earliest_CARDFL_BOOTSTRAP_SERVERS', 'security.protocol', 'SSL', 'cns' from dual  union 
select 'earliest_CARDFL_BOOTSTRAP_SERVERS', 'session.timeout.ms', '72000000', 'cns' from dual  union 
select 'earliest_CARDFL_BOOTSTRAP_SERVERS', 'ssl.key.password', '${DSO_KAFKA_SSL_KEY_PASSWORD}', 'cns' from dual  union 
select 'earliest_CARDFL_BOOTSTRAP_SERVERS', 'ssl.keystore.location', '${KEYSTORE_LOCATION} ', 'cns' from dual  union 
select 'earliest_CARDFL_BOOTSTRAP_SERVERS', 'ssl.keystore.password', '${DSO_KAFKA_SSL_KEYSTORE_PASSWORD}', 'cns' from dual  union 
select 'earliest_CARDFL_BOOTSTRAP_SERVERS', 'ssl.keystore.type', 'PKCS12', 'cns' from dual  union 
select 'earliest_CARDFL_BOOTSTRAP_SERVERS', 'ssl.truststore.location', '${TRUSTSTORE_LOCATION}', 'cns' from dual  union 
select 'earliest_CARDFL_BOOTSTRAP_SERVERS', 'ssl.truststore.password', '${DSO_KAFKA_SSL_TRUSTSTORE_PASSWORD}', 'cns' from dual  union 
select 'earliest_CARDFL_BOOTSTRAP_SERVERS', 'ssl.truststore.type', 'PKCS12', 'cns' from dual  union 
select 'earliest_DATA_PLATFORM', 'auto.offset.reset', 'earliest', 'cns' from dual  union 
select 'earliest_DATA_PLATFORM', 'bootstrap.servers', '${DATA_PLATFORM_BOOTSTRAP_SERVERS}', 'cns' from dual  union 
select 'earliest_DATA_PLATFORM', 'fetch.min.bytes', '50', 'cns' from dual  union 
select 'earliest_DATA_PLATFORM', 'isolation.level', 'read_uncommitted', 'cns' from dual  union 
select 'earliest_DATA_PLATFORM', 'security.protocol', 'SSL', 'cns' from dual  union 
select 'earliest_DATA_PLATFORM', 'session.timeout.ms', '72000000', 'cns' from dual  union 
select 'earliest_DATA_PLATFORM', 'ssl.key.password', '${DSO_KAFKA_SSL_KEY_PASSWORD}', 'cns' from dual  union 
select 'earliest_DATA_PLATFORM', 'ssl.keystore.location', '${KEYSTORE_LOCATION} ', 'cns' from dual  union 
select 'earliest_DATA_PLATFORM', 'ssl.keystore.password', '${DSO_KAFKA_SSL_KEYSTORE_PASSWORD}', 'cns' from dual  union 
select 'earliest_DATA_PLATFORM', 'ssl.keystore.type', 'PKCS12', 'cns' from dual  union 
select 'earliest_DATA_PLATFORM', 'ssl.truststore.location', '${TRUSTSTORE_LOCATION}', 'cns' from dual  union 
select 'earliest_DATA_PLATFORM', 'ssl.truststore.password', '${DSO_KAFKA_SSL_TRUSTSTORE_PASSWORD}', 'cns' from dual  union 
select 'earliest_DATA_PLATFORM', 'ssl.truststore.type', 'PKCS12', 'cns' from dual  union 
select 'gf_latest', 'auto.offset.reset', 'latest', 'cns' from dual  union 
select 'gf_latest', 'bootstrap.servers', '${DSO_GF_IFWAYN_BOOTSTRAP_SERVERS}', 'cns' from dual  union 
select 'gf_latest', 'fetch.min.bytes', '50', 'cns' from dual  union 
select 'gf_latest', 'isolation.level', 'read_uncommitted', 'cns' from dual  union 
select 'gf_latest', 'security.protocol', 'SSL', 'cns' from dual  union 
select 'gf_latest', 'session.timeout.ms', '72000000', 'cns' from dual  union 
select 'gf_latest', 'ssl.key.password', '${DSO_GF_IFWAYN_SSL_KEY_PASSWORD}', 'cns' from dual  union 
select 'gf_latest', 'ssl.keystore.location', '${DSO_GF_IFWAYN_KEYSTORE_LOCATION}', 'cns' from dual  union 
select 'gf_latest', 'ssl.keystore.password', '${DSO_GF_IFWAYN_SSL_KEYSTORE_PASSWORD}', 'cns' from dual  union 
select 'gf_latest', 'ssl.keystore.type', 'PKCS12', 'cns' from dual  union 
select 'gf_latest', 'ssl.truststore.location', '${DSO_GF_IFWAYN_TRUSTSTORE_LOCATION}', 'cns' from dual  union 
select 'gf_latest', 'ssl.truststore.password', '${DSO_GF_IFWAYN_SSL_TRUSTSTORE_PASSWORD}', 'cns' from dual  union 
select 'gf_latest', 'ssl.truststore.type', 'PKCS12', 'cns' from dual  union 
select 'latest', 'auto.offset.reset', 'latest', 'cns' from dual  union 
select 'latest', 'bootstrap.servers', '${BOOTSTRAP_SERVERS}', 'cns' from dual  union 
select 'latest', 'fetch.min.bytes', '50', 'cns' from dual  union 
select 'latest', 'group.id', '${SERVICE_NAME}_${PROFILE_NAME}', 'cns' from dual  union 
select 'latest', 'isolation.level', 'read_uncommitted', 'cns' from dual  union 
select 'latest', 'security.protocol', 'SSL', 'cns' from dual  union 
select 'latest', 'session.timeout.ms', '72000000', 'cns' from dual  union 
select 'latest', 'ssl.key.password', '${DSO_KAFKA_SSL_KEY_PASSWORD}', 'cns' from dual  union 
select 'latest', 'ssl.keystore.location', '${KEYSTORE_LOCATION} ', 'cns' from dual  union 
select 'latest', 'ssl.keystore.password', '${DSO_KAFKA_SSL_KEYSTORE_PASSWORD}', 'cns' from dual  union 
select 'latest', 'ssl.keystore.type', 'PKCS12', 'cns' from dual  union 
select 'latest', 'ssl.truststore.location', '${TRUSTSTORE_LOCATION}', 'cns' from dual  union 
select 'latest', 'ssl.truststore.password', '${DSO_KAFKA_SSL_TRUSTSTORE_PASSWORD}', 'cns' from dual  union 
select 'latest', 'ssl.truststore.type', 'PKCS12', 'cns' from dual  union 
select 'latest_DATA_PLATFORM', 'auto.offset.reset', 'latest', 'cns' from dual  union 
select 'latest_DATA_PLATFORM', 'bootstrap.servers', '${BOOTSTRAP_SERVERS}', 'cns' from dual  union 
select 'latest_DATA_PLATFORM', 'fetch.min.bytes', '50', 'cns' from dual  union 
select 'latest_DATA_PLATFORM', 'group.id', '${SERVICE_NAME}_${PROFILE_NAME}', 'cns' from dual  union 
select 'latest_DATA_PLATFORM', 'isolation.level', 'read_uncommitted', 'cns' from dual  union 
select 'latest_DATA_PLATFORM', 'security.protocol', 'SSL', 'cns' from dual  union 
select 'latest_DATA_PLATFORM', 'session.timeout.ms', '72000000', 'cns' from dual  union 
select 'latest_DATA_PLATFORM', 'ssl.key.password', '${DSO_KAFKA_SSL_KEY_PASSWORD}', 'cns' from dual  union 
select 'latest_DATA_PLATFORM', 'ssl.keystore.location', '${KEYSTORE_LOCATION} ', 'cns' from dual  union 
select 'latest_DATA_PLATFORM', 'ssl.keystore.password', '${DSO_KAFKA_SSL_KEYSTORE_PASSWORD}', 'cns' from dual  union 
select 'latest_DATA_PLATFORM', 'ssl.keystore.type', 'PKCS12', 'cns' from dual  union 
select 'latest_DATA_PLATFORM', 'ssl.truststore.location', '${TRUSTSTORE_LOCATION}', 'cns' from dual  union 
select 'latest_DATA_PLATFORM', 'ssl.truststore.password', '${DSO_KAFKA_SSL_TRUSTSTORE_PASSWORD}', 'cns' from dual  union 
select 'latest_DATA_PLATFORM', 'ssl.truststore.type', 'PKCS12', 'cns' from dual  union 
select 'producer_CBR_RATE', 'bootstrap.servers', '${P0_CBR_RATES_IFFXRT_BOOTSTRAP_SERVERS}', 'prd' from dual  union 
select 'producer_CBR_RATE', 'security.protocol', 'SSL', 'prd' from dual  union 
select 'producer_CBR_RATE', 'ssl.key.password', '${P0_CBR_RATES_IFFXRT_SSL_KEY_PASSWORD}', 'prd' from dual  union 
select 'producer_CBR_RATE', 'ssl.keystore.location', '${P0_CBR_RATES_IFFXRT_KEYSTORE_LOCATION}', 'prd' from dual  union 
select 'producer_CBR_RATE', 'ssl.keystore.password', '${P0_CBR_RATES_IFFXRT_SSL_KEYSTORE_PASSWORD}', 'prd' from dual  union 
select 'producer_CBR_RATE', 'ssl.keystore.type', 'PKCS12', 'prd' from dual  union 
select 'producer_CBR_RATE', 'ssl.truststore.location', '${P0_CBR_RATES_IFFXRT_TRUSTSTORE_LOCATION}', 'prd' from dual  union 
select 'producer_CBR_RATE', 'ssl.truststore.password', '${P0_CBR_RATES_IFFXRT_SSL_TRUSTSTORE_PASSWORD}', 'prd' from dual  union 
select 'producer_CBR_RATE', 'ssl.truststore.type', 'PKCS12', 'prd' from dual  union 
select 'producer_CBR_RATE', 'transactional.id', '${PROFILE}', 'prd' from dual  union 
select 'producer_CBR_RATE', 'transaction.timeout.ms', '30000', 'prd' from dual  union 
select 'producer_default', 'bootstrap.servers', '${BOOTSTRAP_SERVERS}', 'prd' from dual  union 
select 'producer_default', 'security.protocol', 'SSL', 'prd' from dual  union 
select 'producer_default', 'ssl.key.password', '${DSO_KAFKA_SSL_KEY_PASSWORD}', 'prd' from dual  union 
select 'producer_default', 'ssl.keystore.location', '${KEYSTORE_LOCATION} ', 'prd' from dual  union 
select 'producer_default', 'ssl.keystore.password', '${DSO_KAFKA_SSL_KEYSTORE_PASSWORD}', 'prd' from dual  union 
select 'producer_default', 'ssl.keystore.type', 'PKCS12', 'prd' from dual  union 
select 'producer_default', 'ssl.truststore.location', '${TRUSTSTORE_LOCATION}', 'prd' from dual  union 
select 'producer_default', 'ssl.truststore.password', '${DSO_KAFKA_SSL_TRUSTSTORE_PASSWORD}', 'prd' from dual  union 
select 'producer_default', 'ssl.truststore.type', 'PKCS12', 'prd' from dual  union 
select 'producer_default', 'transactional.id', '${PROFILE_NAME}', 'prd' from dual  union 
select 'producer_default', 'transaction.timeout.ms', '30000', 'prd' from dual  union 
select 'producer_idempotence', 'acks', 'all', 'prd' from dual  union 
select 'producer_idempotence', 'bootstrap.servers', '${BOOTSTRAP_SERVERS}', 'prd' from dual  union 
select 'producer_idempotence', 'enable.idempotence', 'true', 'prd' from dual  union 
select 'producer_idempotence', 'key.serializer', 'org.apache.kafka.common.serialization.ByteArraySerializer', 'prd' from dual  union 
select 'producer_idempotence', 'max.block.ms', '90000', 'prd' from dual  union 
select 'producer_idempotence', 'retries', '1', 'prd' from dual  union 
select 'producer_idempotence', 'security.protocol', 'SSL', 'prd' from dual  union 
select 'producer_idempotence', 'ssl.key.password', '${DSO_KAFKA_SSL_KEY_PASSWORD}', 'prd' from dual  union 
select 'producer_idempotence', 'ssl.keystore.location', '${KEYSTORE_LOCATION} ', 'prd' from dual  union 
select 'producer_idempotence', 'ssl.keystore.password', '${DSO_KAFKA_SSL_KEYSTORE_PASSWORD}', 'prd' from dual  union 
select 'producer_idempotence', 'ssl.keystore.type', 'PKCS12', 'prd' from dual  union 
select 'producer_idempotence', 'ssl.truststore.location', '${TRUSTSTORE_LOCATION}', 'prd' from dual  union 
select 'producer_idempotence', 'ssl.truststore.password', '${DSO_KAFKA_SSL_TRUSTSTORE_PASSWORD}', 'prd' from dual  union 
select 'producer_idempotence', 'ssl.truststore.type', 'PKCS12', 'prd' from dual  union 
select 'producer_idempotence', 'transactional.id', '${PROFILE_NAME}', 'prd' from dual  union 
select 'producer_idempotence', 'transaction.timeout.ms', '1800000', 'prd' from dual  union 
select 'producer_idempotence', 'value.serializer', 'org.apache.kafka.common.serialization.ByteArraySerializer', 'prd' from dual ;

insert into dict_service_node(profile_id, report_description, service_id) 
select 'aggregate-bevents', 'Описание не заполнено.', 'bevents-streaming-aggregate-first-salary' from dual  union 
select 'aggregate-bevents-56-57', 'Описание не заполнено.', 'bevents-streaming-aggregate-first-salary' from dual  union 
select 'aggregate-ca', 'Описание не заполнено.', 'uasp-streaming-unp-convertor' from dual  union 
select 'aggregate-dko', 'Описание не заполнено.', 'uasp-streaming-aggregate' from dual  union 
select 'bevents-filter', 'Описание не заполнено.', 'uasp-streaming-filter' from dual  union 
select 'cardfl', 'Описание не заполнено.', 'uasp-streaming-unp-convertor' from dual  union 
select 'case-48-concatenate', 'Описание не заполнено.', 'uasp-streaming-mutator' from dual  union 
select 'case-68', 'Описание не заполнено.', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'case68', 'Описание не заполнено.', 'uasp-streaming-currency-enrichment' from dual  union 
select 'case68', 'Описание не заполнено.', 'uasp-streaming-unp-convertor' from dual  union 
select 'case-68_agrement', 'Описание не заполнено.', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'cbr-rate', 'Описание не заполнено.', 'uasp-streaming-unp-convertor' from dual  union 
select 'cft-transactions', 'Описание не заполнено.', 'uasp-streaming-unp-convertor' from dual  union 
select 'close_account', 'Описание не заполнено.', 'uasp-streaming-input-convertor' from dual  union 
select 'close_account', 'Описание не заполнено.', 'uasp-streaming-unp-convertor' from dual  union 
select 'credit-card', 'Описание не заполнено.', 'uasp-streaming-beg-card-block' from dual  union 
select 'credit-card', 'Описание не заполнено.', 'uasp-streaming-beg-pincode-change' from dual  union 
select 'credit-card', 'Описание не заполнено.', 'uasp-streaming-cc-activation' from dual  union 
select 'customer-package', 'Описание не заполнено.', 'uasp-streaming-input-convertor' from dual  union 
select 'customer-profile-full', 'Описание не заполнено.', 'uasp-streaming-input-convertor' from dual  union 
select 'first-salary', 'Описание не заполнено.', 'uasp-streaming-currency-enrichment' from dual  union 
select 'input-convertor-ca-cardfl', 'Описание не заполнено.', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-ca-depositfl', 'Описание не заполнено.', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-ca-first-salary', 'Описание не заполнено.', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-cardfl', 'Описание не заполнено.', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-cft', 'Описание не заполнено.', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-mdm', 'Описание не заполнено.', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-prof-auth', 'Описание не заполнено.', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-profile', 'Описание не заполнено.', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-udds', 'Описание не заполнено.', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-w4-operation', 'Описание не заполнено.', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-withdraw', 'Описание не заполнено.', 'uasp-streaming-input-convertor' from dual  union 
select 'insurance', 'Описание не заполнено.', 'uasp-streaming-json-validator' from dual  union 
select 'kn', 'Описание не заполнено.', 'uasp-streaming-json-validator' from dual  union 
select 'loyalty', 'Описание не заполнено.', 'uasp-streaming-input-convertor' from dual  union 
select 'main', 'Описание не заполнено.', 'uasp-dko-rds-63902-accr-reciver' from dual  union 
select 'main', 'Описание не заполнено.', 'uasp-kriaa-bevents-case-2' from dual  union 
select 'main', 'Описание не заполнено.', 'uasp-kriaa-bevents-case-40' from dual  union 
select 'main', 'Описание не заполнено.', 'uasp-kriaa-bevents-case-55' from dual  union 
select 'main', 'Описание не заполнено.', 'uasp-kriaa-bevents-case-56' from dual  union 
select 'main', 'Описание не заполнено.', 'uasp-kriaa-bevents-case-57' from dual  union 
select 'main', 'Описание не заполнено.', 'uasp-kriaa-bevents-case-68' from dual  union 
select 'main', 'Описание не заполнено.', 'uasp-kriaa-bevents-case-70' from dual  union 
select 'main', 'Описание не заполнено.', 'uasp-kriaa-bevents-case-84' from dual  union 
select 'main', 'Описание не заполнено.', 'uasp-kriaa-bevents-case-86' from dual  union 
select 'main', 'Описание не заполнено.', 'uasp-kriaa-bevents-insurence-cft' from dual  union 
select 'main', 'Описание не заполнено.', 'uasp-kriaa-bevents-insurence-kn' from dual  union 
select 'main', 'Описание не заполнено.', 'uasp-streaming-refunds-event-notifier' from dual  union 
select 'mainInput', 'Описание не заполнено.', 'uasp-streaming-mutator' from dual  union 
select 'main-input-filter', 'Описание не заполнено.', 'uasp-streaming-filter' from dual  union 
select 'mdm-profile', 'Описание не заполнено.', 'uasp-streaming-input-convertor' from dual  union 
select 'model-vector-bevents', 'Описание не заполнено.', 'uasp-streaming-model-vector' from dual  union 
select 'outer-cbr-rate', 'Описание не заполнено.', 'uasp-streaming-unp-convertor' from dual  union 
select 'prof-auth', 'Описание не заполнено.', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth-packNM', 'Описание не заполнено.', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'profile-auth', 'Описание не заполнено.', 'uasp-streaming-unp-convertor' from dual  union 
select 'profile-transactions', 'Описание не заполнено.', 'uasp-streaming-unp-convertor' from dual  union 
select 'profile-tx-step1', 'Описание не заполнено.', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'profile-tx-step2', 'Описание не заполнено.', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-tx-case-71', 'Описание не заполнено.', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'rateMutate', 'Описание не заполнено.', 'uasp-streaming-mutator' from dual  union 
select 'test', 'Описание не заполнено.', 'uasp-kriaa-bevents-monitor' from dual  union 
select 'uasp-streaming-rto-15', 'Описание не заполнено.', 'uasp-streaming-rto-15' from dual  union 
select 'uasp-streaming-rto-37', 'Описание не заполнено.', 'uasp-streaming-rto-37' from dual  union 
select 'uasp-streaming-rto-attempt-close-part2', 'Описание не заполнено.', 'uasp-streaming-rto-attempt-close-part2' from dual  union 
select 'uasp-streaming-rto-bcps-card-emission-digital', 'Описание не заполнено.', 'uasp-streaming-rto-bcps-card-emission-digital' from dual  union 
select 'uasp-streaming-rto-bcps-card-emission-digital-mock-test', 'Описание не заполнено.', 'uasp-streaming-rto-bcps-card-emission-digital' from dual  union 
select 'uasp-streaming-rto-bcps-status-change', 'Описание не заполнено.', 'uasp-streaming-rto-bcps-status-change' from dual  union 
select 'uasp-streaming-rto-bcps-status-change-mock-test', 'Описание не заполнено.', 'uasp-streaming-rto-bcps-status-change' from dual  union 
select 'uasp-streaming-rto-card-activation-way4', 'Описание не заполнено.', 'uasp-streaming-rto-card-activation-way4' from dual  union 
select 'uasp-streaming-rto-card-activation-way4-mock-test', 'Описание не заполнено.', 'uasp-streaming-rto-card-activation-way4' from dual  union 
select 'uasp-streaming-rto-closing-deposit', 'Описание не заполнено.', 'uasp-streaming-rto-closing-deposit' from dual  union 
select 'uasp-streaming-rto-dko-4_62', 'Описание не заполнено.', 'uasp-streaming-rto-dko-4_62' from dual  union 
select 'uasp-streaming-rto-mortgage-approval-prod', 'Описание не заполнено.', 'uasp-streaming-rto-mortgage-approval' from dual  union 
select 'uasp-streaming-rto-ofvs', 'Описание не заполнено.', 'uasp-streaming-rto-ofvs' from dual  union 
select 'uasp-streaming-rto-open-deposit', 'Описание не заполнено.', 'uasp-streaming-rto-open-deposit' from dual  union 
select 'uasp-streaming-rto-status-execution-goal', 'Описание не заполнено.', 'uasp-streaming-rto-status-execution-goal' from dual  union 
select 'uasp-streaming-rto-zoc', 'Описание не заполнено.', 'uasp-streaming-rto-zoc' from dual  union 
select 'udds-3to8', 'Описание не заполнено.', 'uasp-streaming-unp-convertor' from dual  union 
select 'uddsRate', 'Описание не заполнено.', 'uasp-streaming-mutator' from dual  union 
select 'unp_w4_issuing_card', 'Описание не заполнено.', 'uasp-streaming-unp-convertor' from dual  union 
select 'uz', 'Описание не заполнено.', 'uasp-streaming-json-validator' from dual  union 
select 'w4-account-balance', 'Описание не заполнено.', 'uasp-streaming-unp-convertor' from dual  union 
select 'way4', 'Описание не заполнено.', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4-card-agreement', 'Описание не заполнено.', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4-main', 'Описание не заполнено.', 'uasp-streaming-unp-convertor' from dual  union 
select 'way4_new', 'Описание не заполнено.', 'uasp_dko_83088_way4_mdm_enrich' from dual  union 
select 'way4_new_stream', 'Описание не заполнено.', 'uasp_dko_83088_way4_mdm_enrich_2150' from dual  union 
select 'way4_old_stream', 'Описание не заполнено.', 'uasp_dko_83088_way4_mdm_enrich' from dual  union 
select 'way4_old_stream', 'Описание не заполнено.', 'uasp_dko_83088_way4_mdm_enrich_2150' from dual  union 
select 'way4-transactions', 'Описание не заполнено.', 'uasp-streaming-unp-convertor' from dual  union 
select 'withdraw-transactions', 'Описание не заполнено.', 'uasp-streaming-unp-convertor' from dual ;

insert into dict_topic_node(cleanup_policy, id, retention, topic_owner_id) 
select 'delete', 'APRF_STATIC_PUB', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'CFT2RS_CD_OUT', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev___account-provider__ acc__ close', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev__account-provider__ acc__ close', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev__account-provider__ acc__ close_unp', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_accr_uasp_acc_close', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_accr_uasp_acc_close_ack', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_accr_uasp_acc_close_valid', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_bevent__batch__ca_regulatory_client_id_of_profile__json_dlq', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_bevents_68_after_rate_enrich', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_bevents__batch__ca_first_salary_transactions_dlq', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_bevents__batch__ca_first_salary_transactions__json', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_bevents__batch__ca_first_salary_transactions__json_converted', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_bevents__batch__ca_regulatory_client_id_of_profile__json', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_bevents__batch__ca_regulatory_client_id_of_profile__json_converted', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_bevents__batch__ca_regulatory_contract_num_of_mdm_id_profile__uaspdto', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_bevents_card_agreement_enrich_dlq', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_bevents_card_agreement_enrich_out_uaspdto', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_bevents_card_agreement_enrich_way4_dlq', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_bevents_cft_way4_profile_udds_after_mutator_uaspdto', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_bevents_cft_way4_profile_udds_before_case68_uaspdto', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_bevents_cft_way4_profile_udds_before_case68_uaspdto_dlq', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_bevents_cft_way4_profile_udds_before_mdm_rate_case68_uaspdto', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_bevents_cft_way4_profile_udds_before_mdm_rate_case68_uaspdto_dlq', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_bevents_package_nm_enrich_dlq', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev__bevents__realtime__aggregate_first_salary__dlq', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_bevents__realtime__aggregate_first_salary__uaspdto', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_bevents__realtime__case_71__uaspdto', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_bevents__realtime__case_71__uaspdto_dlq', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_bevents__realtime__enrichment_first_salary_transactions_dlq', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_bevents__realtime__enrichment_first_salary_transactions__uaspdto', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_bevents__realtime__enrichment_prepare_transactions__dlq', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_bevents__realtime__enrichment_prepare_transactions__uaspdto', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_bevents__realtime__enrichment__prof__contract_num__uaspdto', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_bevents__realtime__enrichment__prof__transactions_first__uaspdto', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_bevents__realtime__enrichment__prof__transactions_with_clientid__dlq', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_bevents__realtime__enrichment__prof__transactions_with_contract_num__dlq', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_bevents__realtime__enrichment__prof__transactions_with_mdm_id__dlq', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_bevents__realtime__enrichment__prof__transactions_with_partyUId__dlq', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_bevents__realtime__filter_first_salary__filter', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_bevents__realtime__filter_first_salary__uaspdto', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_bevents__realtime__input_converter__cft__transactions__dlq', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_bevents__realtime__input_converter__prof__transactions__dlq', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_bevents__realtime__input_converter__prof__transactions__uaspdto', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_bevents__realtime__modelvector_first_salary__dlq', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_bevents__realtime__modelvector_first_salary__qa', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_bevents__realtime__refunds-notifier__dlq', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_bevents_streaming_input_convertor_profile_auth_dlq', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_bevents_streaming_input_convertor_profile_auth_json', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_bevents_streaming_input_convertor_profile_auth_uaspdto', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_bevents__uasp_realtime__outer_cbr_rate__status', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_bevents_udds_mdm_rate_case68_uaspdto', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_bevents_udds_mdm_rate_case68_uaspdto_dlq', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev__boop_uasp__uss__loyalty_profile_changes', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev__boop_uasp__uss__loyalty_profile_changes_dlq', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_cft2rl_uasp_loan_details', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev__cft2rs_uasp__chvsns', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev__dko_uasp__card_agreement', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev__dko_uasp__card_agreement_converted', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev__dko_uasp__card_agreement_dlq', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev__dko_uasp__pension', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_dko_uasp__pension', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev__dko_uasp__pension_converted', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev__dko_uasp__pension_dlq', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev__dlq__ipo_uasp__od', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_feature_ivr__uasp_realtime__mdm_enrichment__uaspdto', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_input_converter_cardfl_refill_uasp', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_input_converter_cardfl_refill_uasp_dlq', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_input_withdraw_tx_dlq', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev__ipo_uasp__od', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_ivr__uasp_realtime__aggregate__dlq', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_ivr__uasp_realtime__aggregate__filter', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_ivr__uasp_realtime__aggregate__uaspdto', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_ivr__uasp_realtime__business_rules__uaspdto', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_ivr__uasp_realtime__bussiness_rules__uaspdto__dlq', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_ivr__uasp_realtime__ca_ha_aggregate__ca__uaspdto', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_ivr__uasp_realtime__case_48_concatenate__uaspdto', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_ivr__uasp_realtime__filter__uaspdto__filter', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_ivr__uasp_realtime__input_converter__mdm_cross_link__dlq', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_ivr__uasp_realtime__input_converter__mdm_cross_link__json', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_ivr__uasp_realtime__input_converter__mdm_cross_link__uaspdto', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_ivr__uasp_realtime__input_converter__mortgage__dlq', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_ivr__uasp_realtime__input_converter__mortgage__uaspdto', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_ivr__uasp_realtime__input_converter__way4_issuing_account_balance__json', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_ivr__uasp_realtime__input_converter__way4_issuing_card__json', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_ivr__uasp_realtime__input_converter__way4_issuing_operation__dlq', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_ivr__uasp_realtime__input_converter__way4_issuing_operation__json', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_ivr__uasp_realtime__input_converter__way4_issuing_operation__uaspdto', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_ivr__uasp_realtime__mdm_enrichment__for_additional_enrichment__uaspdto', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_ivr__uasp_realtime__mdm_enrichment__mdm_cross_link__status__dlq', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_ivr__uasp_realtime__mdm_enrichment__uaspdto', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_ivr__uasp_realtime__mdm_enrichment__uaspdto__dlq', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_ivr__uasp_realtime__model_vector__json', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_ivr__uasp_realtime__operations__json', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_ivr__uasp_realtime__outer_cbr_rate__ask', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_ivr__uasp_realtime__outer_cbr_rates__json', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_ivr__uasp_realtime__schemas__json', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_ivr_uasp_realtime_way4_main_input_issuing_operation__json', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_ivr__uasp_realtime_way4_mdm_enrichment__uaspdto', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_mdm-usst-outpu', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_mdm-usst-output', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev__model_orkestrator__uasp__zoc', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev__mscl_uasp_applic', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev__mscl_uasp_applic_valid', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev__mscl_uasp_applic_valid_ack', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev__mssa_uasp_applic', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev__mssa_uasp_applic_valid', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev__mssa_uasp_applic_valid_ack', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_multibonus_partners_program', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev__pp_fl_uasp__opyp', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_rto_batch_ca_customer_card68_uaspdto_dlq', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_rto_batch_ca_customer_card_uaspdto__dlq', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_rto_batch_ca_customer_package_dlq', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_rto_batch_ca_deposit_account_case_71_dlq', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_rto_batch_ca_deposit_account_case_71_json', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_rto_batch_ca_deposit_account_case_71_json_converted', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_rto_batch_ca_deposit_account_case_71_uaspdto__dlq', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_rto_batch_ca_personal_manager_json', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_rto_batch_ca_personal_manager_json_converted', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_rto_batch_ca_personal_manager_json_dlq', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_rto_uasp_actc', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_rto_uasp_actc_way4_dlq', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev__rto_uasp__blcard', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev__rto_uasp__case_2', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev__rto_uasp__case_2_dlq', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev__rto_uasp__case_39_old', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev__rto_uasp__case_39_vector', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev__rto_uasp__case_40', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev__rto_uasp__case_40__dlq', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev__rto_uasp__case_44', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev__rto_uasp__case_48', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev__rto_uasp__case_51', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev__rto_uasp__case_62', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev__rto_uasp__case_62_prf_dlq', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev__rto_uasp__case_62_way4_dlq', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev__rto_uasp__case_70', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev__rto_uasp__case_70_dlq', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev__rto_uasp__case_71', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev__rto_uasp__case_84', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev__rto_uasp__case_84_dlq', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev__rto_uasp_ipood', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev__rto_uasp__izmpin', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev__rto_uasp__izost', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev__rto_uasp__izost_unp', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev__rto_uasp__ofvs', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev__rto_uasp__ofvs__dlq', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_rto_uasp_ons', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_rto_uasp_ons__dlq', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev__rto_uasp__opyp', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev__rto_uasp__opyp__dlq', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_rto_uasp_ov', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_rto_uasp_ov__dlq', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev__rto_uasp__pdscp', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_rto_uasp_piods', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_rto_uasp_piods_dlq', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev__rto_uasp__pks', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev__rto_uasp__ppnsx', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_rto_uasp_pzns_dlq', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_rto_uasp_pzv', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_rto_uasp_pzv__dlq', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_rto_uasp_svc', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_rto_uasp_svc_dlq', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_rto_uasp_usapns', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_rto_uasp_usapns__dlq', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev__rto_uasp__zp', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev__rto_uasp__zp_dlq', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev__rto_uasp__zzp', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev__rto_uasp__zzp_dlq', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_sstr_uasp_pay_inf', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_sstr_uasp_pay_inf_ack', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_sstr_uasp_pay_inf_valid', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_sstr_uasp_piods', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_ss_uasp_ons', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_ss_uasp_ov', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_ss_uasp_pzns', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_ss_uasp_pzv', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_ss_uasp_svc', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_ss_uasp_usapns', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev__tbcr_uasp__ofvs', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev__trns_uasp__up', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev__uasp_aprf__pks', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev__uasp_aprf__pks_dlq', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_uasp_bcps_ced', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_uasp_bcps_ced_dlq', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_uasp_bcps_csc', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_uasp_bcps_csc_dlq', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_uasp_ccpp_card_activate', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_uasp_ccpp_card_activate_dlq', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_uasp_ccpp_card_block', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_uasp_ccpp_card_block_dlq', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_uasp_ccpp_card_pin_change', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_uasp_ccpp_card_pin_change_dlq', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev__uasp__enrichment__zoc', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_uasp_ins_add_vns', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_uasp_ins_add_vns_dlq', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_uasp_ins_change_vns', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev_uasp_ins_change_vns_dlq', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev__uasp__rto__zoc', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev__uasp__rto__zoc__dlq', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev__uasp_usst__account-provider__ acc__ close-topic-003', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev__uasp_usst__account-provider__ acc__ close-topic-003_dlq', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev__uasp_usst__wayNew_account_trmon', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev__uasp_usst__wayNew_account_uop', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev__uasp_usst__wayNew_operation_trmon', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev__uasp_usst__wayNew_operation_uop', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev__uasp_usst__wayOld_account_trmon', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev__uasp_usst__wayOld_operation_trmon', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev__uasp_usst__wayOld_operation_uop', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev__uasp_usst__way_trmon__dlq', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev__uasp_usst__way_uop__dlq', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev__udds_uasp__up', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev__udds_uasp__up_dlq', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev__udds_uasp__up_unp', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev__wayn_wvtb__issuing_account', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev__wayn_wvtb__issuing_operation', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev__wpr_profile-uasp__auth', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'dev__wpr_profile-uasp__tran', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'ift__udds_uasp__up_dlq', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'issuing-account', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'issuing-account-balance', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'issuing-card', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'issuing-operation', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'p0_bevents__realtime__enrichment__prof__transactions_first__uaspdto', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'p0_ivr__uasp_realtime__input_converter__way4_issuing_operation__json', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'p0_ivr_uasp_realtime_way4_main_input_issuing_operation__json', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'p0_ivr__uasp_realtime_way4_mdm_enrichment__uaspdto', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'p0__rto_uasp__case_70', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'prod__dlq__ipo_uasp__od', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'prod__ipo_uasp__od', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'PROD.OUTER.CBR.RATES.ACK', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'prod__rto_uasp_ipood', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'prod_rto_uasp_ov', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'prod_rto_uasp_ov__dlq', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'prod_rto_uasp_pzv', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'prod_rto_uasp_pzv__dlq', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'prod_rto_uasp_usapns', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'prod_rto_uasp_usapns__dlq', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'prod_ss_uasp_ov', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'prod_ss_uasp_pzv', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'prod_ss_uasp_usapns', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'profile_tx_out', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'streaming.smart_replication_change_request_tbcvsofk_default', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'UNP_PROFILE_AUTH', 14400000, 'DKO_COMMAND' from dual  union 
select 'delete', 'withdraw_tx_out', 14400000, 'DKO_COMMAND' from dual ;

insert into dict_flink_prop_value(profile_id, prop_id, prop_value, service_id) 
select 'aggregate-bevents', 'dlq.JsMaskedPath$.data.dataDecimal.card_expiration_dt', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'bevents-streaming-aggregate-first-salary' from dual  union 
select 'aggregate-bevents', 'dlq.JsMaskedPath$.data.dataDecimal.endbal_prf', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'bevents-streaming-aggregate-first-salary' from dual  union 
select 'aggregate-bevents', 'dlq.JsMaskedPath$.data.dataString.account_num', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'bevents-streaming-aggregate-first-salary' from dual  union 
select 'aggregate-bevents', 'dlq.JsMaskedPath$.data.dataString.card_expire_w4', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'bevents-streaming-aggregate-first-salary' from dual  union 
select 'aggregate-bevents', 'dlq.JsMaskedPath$.data.dataString.contract_num', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'bevents-streaming-aggregate-first-salary' from dual  union 
select 'aggregate-bevents', 'dlq.JsMaskedPath$.data.dataString.data_operationName', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'bevents-streaming-aggregate-first-salary' from dual  union 
select 'aggregate-bevents', 'dlq.JsMaskedPath$.data.dataString.replacement_amt', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'bevents-streaming-aggregate-first-salary' from dual  union 
select 'aggregate-bevents', 'dlq.JsMaskedPath$.data.dataString.source_account_w4', 'ru.vtb.uasp.common.mask.fun.AccountMask', 'bevents-streaming-aggregate-first-salary' from dual  union 
select 'aggregate-bevents', 'dlq.JsMaskedPath$.data.dataString.tcmt', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'bevents-streaming-aggregate-first-salary' from dual  union 
select 'aggregate-bevents', 'dlq.JsMaskedPath$.data.dataString.tcmt_account_num', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'bevents-streaming-aggregate-first-salary' from dual  union 
select 'aggregate-bevents', 'dlq.JsMaskedPath$.data.dataString.tso', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'bevents-streaming-aggregate-first-salary' from dual  union 
select 'aggregate-bevents', 'list.of.business.rule', 'case_48.drl,case_71.drl,case_8.drl,case_29.drl,case_38.drl,case_39.drl', 'bevents-streaming-aggregate-first-salary' from dual  union 
select 'aggregate-bevents', 'list.of.business.rule.level0', 'source_account.drl', 'bevents-streaming-aggregate-first-salary' from dual  union 
select 'aggregate-bevents', 'list.of.business.rule.level1', 'level1.drl', 'bevents-streaming-aggregate-first-salary' from dual  union 
select 'aggregate-bevents', 'list.of.business.rule.level2', 'level2.drl', 'bevents-streaming-aggregate-first-salary' from dual  union 
select 'aggregate-bevents', 'max.parallelism', '${PARALLELISM}', 'bevents-streaming-aggregate-first-salary' from dual  union 
select 'aggregate-bevents', 'name.state.first.salary.aggregates', '${SERVICE_NAME}', 'bevents-streaming-aggregate-first-salary' from dual  union 
select 'aggregate-bevents', 'service.serviceName', '${SERVICE_NAME}', 'bevents-streaming-aggregate-first-salary' from dual  union 
select 'aggregate-bevents', 'service.serviceProfile', '${PROFILE_NAME}', 'bevents-streaming-aggregate-first-salary' from dual  union 
select 'aggregate-bevents', 'service.serviceVersion', '${SERVICE_VERSION}', 'bevents-streaming-aggregate-first-salary' from dual  union 
select 'aggregate-bevents', 'state.checkpoints.num-retained', '1', 'bevents-streaming-aggregate-first-salary' from dual  union 
select 'aggregate-bevents', 'stream.checkpoint.time.milliseconds', '600000', 'bevents-streaming-aggregate-first-salary' from dual  union 
select 'aggregate-bevents', 'stream.checkpoint.timeout.milliseconds', '600000', 'bevents-streaming-aggregate-first-salary' from dual  union 
select 'aggregate-bevents-56-57', 'dlq.JsMaskedPath$.data.dataDecimal.card_expiration_dt', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'bevents-streaming-aggregate-first-salary' from dual  union 
select 'aggregate-bevents-56-57', 'dlq.JsMaskedPath$.data.dataDecimal.endbal_prf', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'bevents-streaming-aggregate-first-salary' from dual  union 
select 'aggregate-bevents-56-57', 'dlq.JsMaskedPath$.data.dataString.account_num', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'bevents-streaming-aggregate-first-salary' from dual  union 
select 'aggregate-bevents-56-57', 'dlq.JsMaskedPath$.data.dataString.card_expire_w4', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'bevents-streaming-aggregate-first-salary' from dual  union 
select 'aggregate-bevents-56-57', 'dlq.JsMaskedPath$.data.dataString.contract_num', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'bevents-streaming-aggregate-first-salary' from dual  union 
select 'aggregate-bevents-56-57', 'dlq.JsMaskedPath$.data.dataString.data_operationName', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'bevents-streaming-aggregate-first-salary' from dual  union 
select 'aggregate-bevents-56-57', 'dlq.JsMaskedPath$.data.dataString.replacement_amt', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'bevents-streaming-aggregate-first-salary' from dual  union 
select 'aggregate-bevents-56-57', 'dlq.JsMaskedPath$.data.dataString.source_account_w4', 'ru.vtb.uasp.common.mask.fun.AccountMask', 'bevents-streaming-aggregate-first-salary' from dual  union 
select 'aggregate-bevents-56-57', 'dlq.JsMaskedPath$.data.dataString.tcmt', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'bevents-streaming-aggregate-first-salary' from dual  union 
select 'aggregate-bevents-56-57', 'dlq.JsMaskedPath$.data.dataString.tcmt_account_num', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'bevents-streaming-aggregate-first-salary' from dual  union 
select 'aggregate-bevents-56-57', 'dlq.JsMaskedPath$.data.dataString.tso', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'bevents-streaming-aggregate-first-salary' from dual  union 
select 'aggregate-bevents-56-57', 'list.of.business.rule', 'case_44.drl,case_56.drl,case_57.drl', 'bevents-streaming-aggregate-first-salary' from dual  union 
select 'aggregate-bevents-56-57', 'list.of.business.rule.level0', 'source_account.drl', 'bevents-streaming-aggregate-first-salary' from dual  union 
select 'aggregate-bevents-56-57', 'list.of.business.rule.level1', 'level1.drl', 'bevents-streaming-aggregate-first-salary' from dual  union 
select 'aggregate-bevents-56-57', 'list.of.business.rule.level2', 'level2.drl', 'bevents-streaming-aggregate-first-salary' from dual  union 
select 'aggregate-bevents-56-57', 'max.parallelism', '${PARALLELISM}', 'bevents-streaming-aggregate-first-salary' from dual  union 
select 'aggregate-bevents-56-57', 'name.state.first.salary.aggregates', '${SERVICE_NAME}', 'bevents-streaming-aggregate-first-salary' from dual  union 
select 'aggregate-bevents-56-57', 'service.serviceName', '${SERVICE_NAME}', 'bevents-streaming-aggregate-first-salary' from dual  union 
select 'aggregate-bevents-56-57', 'service.serviceProfile', '${PROFILE_NAME}', 'bevents-streaming-aggregate-first-salary' from dual  union 
select 'aggregate-bevents-56-57', 'service.serviceVersion', '${SERVICE_VERSION}', 'bevents-streaming-aggregate-first-salary' from dual  union 
select 'aggregate-bevents-56-57', 'state.checkpoints.num-retained', '1', 'bevents-streaming-aggregate-first-salary' from dual  union 
select 'aggregate-bevents-56-57', 'stream.checkpoint.time.milliseconds', '600000', 'bevents-streaming-aggregate-first-salary' from dual  union 
select 'aggregate-bevents-56-57', 'stream.checkpoint.timeout.milliseconds', '600000', 'bevents-streaming-aggregate-first-salary' from dual  union 
select 'aggregate-ca', 'max.parallelism', '8', 'uasp-streaming-unp-convertor' from dual  union 
select 'aggregate-ca', 'service.serviceName', '${SERVICE_NAME}', 'uasp-streaming-unp-convertor' from dual  union 
select 'aggregate-ca', 'service.serviceProfile', '${PROFILE_NAME}', 'uasp-streaming-unp-convertor' from dual  union 
select 'aggregate-ca', 'service.serviceVersion', '${SERVICE_VERSION}', 'uasp-streaming-unp-convertor' from dual  union 
select 'aggregate-ca', 'sink.parallelism', '8', 'uasp-streaming-unp-convertor' from dual  union 
select 'aggregate-ca', 'source.parallelism', '8', 'uasp-streaming-unp-convertor' from dual  union 
select 'bevents-filter', 'filter.fieldName', 'system-classification', 'uasp-streaming-filter' from dual  union 
select 'bevents-filter', 'filter.operandClass', 'String', 'uasp-streaming-filter' from dual  union 
select 'bevents-filter', 'filter.operator', 'notNull', 'uasp-streaming-filter' from dual  union 
select 'bevents-filter', 'flink.job.service.serviceName', '${SERVICE_NAME}', 'uasp-streaming-filter' from dual  union 
select 'bevents-filter', 'flink.job.service.serviceProfile', '${PROFILE_NAME}', 'uasp-streaming-filter' from dual  union 
select 'bevents-filter', 'flink.job.service.serviceVersion', '${SERVICE_VERSION}', 'uasp-streaming-filter' from dual  union 
select 'bevents-filter', 'flink.job.sync.parallelism', '${PARALLELISM}', 'uasp-streaming-filter' from dual  union 
select 'bevents-filter', 'kafka.producer.filterTag-error.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.amount_sum_cft', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-filter' from dual  union 
select 'bevents-filter', 'kafka.producer.filterTag-error.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.base_amount_w4', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-filter' from dual  union 
select 'bevents-filter', 'kafka.producer.filterTag-error.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.bseamt', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-filter' from dual  union 
select 'bevents-filter', 'kafka.producer.filterTag-error.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.endbal_prf', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-filter' from dual  union 
select 'bevents-filter', 'kafka.producer.filterTag-error.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.transaction_amount', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-filter' from dual  union 
select 'bevents-filter', 'kafka.producer.filterTag-error.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.transaction_amount_prf', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-filter' from dual  union 
select 'bevents-filter', 'kafka.producer.filterTag-error.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.transaction_amount_sum', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-filter' from dual  union 
select 'bevents-filter', 'kafka.producer.filterTag-error.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.transaction_amt', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-filter' from dual  union 
select 'bevents-filter', 'kafka.producer.filterTag-error.FlinkSinkProperties$.JsMaskedPath$.data.dataString.account_num', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-filter' from dual  union 
select 'bevents-filter', 'kafka.producer.filterTag-error.FlinkSinkProperties$.JsMaskedPath$.data.dataString.card_expiration_dt', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-filter' from dual  union 
select 'bevents-filter', 'kafka.producer.filterTag-error.FlinkSinkProperties$.JsMaskedPath$.data.dataString.card_expire_w4', 'ru.vtb.uasp.common.mask.fun.CenterMaskService(1,0)', 'uasp-streaming-filter' from dual  union 
select 'bevents-filter', 'kafka.producer.filterTag-error.FlinkSinkProperties$.JsMaskedPath$.data.dataString.contract_num', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-filter' from dual  union 
select 'bevents-filter', 'kafka.producer.filterTag-error.FlinkSinkProperties$.JsMaskedPath$.data.dataString.data_operationName', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-filter' from dual  union 
select 'bevents-filter', 'kafka.producer.filterTag-error.FlinkSinkProperties$.JsMaskedPath$.data.dataString.replacement_amt', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-filter' from dual  union 
select 'bevents-filter', 'kafka.producer.filterTag-error.FlinkSinkProperties$.JsMaskedPath$.data.dataString.source_account_w4', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-filter' from dual  union 
select 'bevents-filter', 'kafka.producer.filterTag-error.FlinkSinkProperties$.JsMaskedPath$.data.dataString.tcmt', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-filter' from dual  union 
select 'bevents-filter', 'kafka.producer.filterTag-error.FlinkSinkProperties$.JsMaskedPath$.data.dataString.tcmt_account_num', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-filter' from dual  union 
select 'bevents-filter', 'kafka.producer.filterTag-error.FlinkSinkProperties$.JsMaskedPath$.data.dataString.tso', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-filter' from dual  union 
select 'cardfl', 'max.parallelism', '8', 'uasp-streaming-unp-convertor' from dual  union 
select 'cardfl', 'service.serviceName', '${SERVICE_NAME}', 'uasp-streaming-unp-convertor' from dual  union 
select 'cardfl', 'service.serviceProfile', '${PROFILE_NAME}', 'uasp-streaming-unp-convertor' from dual  union 
select 'cardfl', 'service.serviceVersion', '${SERVICE_VERSION}', 'uasp-streaming-unp-convertor' from dual  union 
select 'cardfl', 'sink.parallelism', '8', 'uasp-streaming-unp-convertor' from dual  union 
select 'cardfl', 'source.parallelism', '8', 'uasp-streaming-unp-convertor' from dual  union 
select 'case-48-concatenate', 'kafka.producers.filterErrorTag-error.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.base_amount_w4', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mutator' from dual  union 
select 'case-48-concatenate', 'kafka.producers.filterErrorTag-error.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.fee_amount_w4', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mutator' from dual  union 
select 'case-48-concatenate', 'kafka.producers.filterErrorTag-error.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.transaction_amount', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mutator' from dual  union 
select 'case-48-concatenate', 'kafka.producers.filterErrorTag-error.FlinkSinkProperties$.JsMaskedPath$.data.dataString.card_expire_w4', 'ru.vtb.uasp.common.mask.fun.CenterMaskService(1,0)', 'uasp-streaming-mutator' from dual  union 
select 'case-48-concatenate', 'kafka.producers.filterErrorTag-error.FlinkSinkProperties$.JsMaskedPath$.data.dataString.comment', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mutator' from dual  union 
select 'case-48-concatenate', 'kafka.producers.filterErrorTag-error.FlinkSinkProperties$.JsMaskedPath$.data.dataString.source_account_w4', 'ru.vtb.uasp.common.mask.fun.AccountMask', 'uasp-streaming-mutator' from dual  union 
select 'case-48-concatenate', 'rulles.drools.list', 'way4-case-48-concatenate.drl', 'uasp-streaming-mutator' from dual  union 
select 'case-48-concatenate', 'rulles.filter.fieldName', 'customer_id_and_masked_card_number', 'uasp-streaming-mutator' from dual  union 
select 'case-48-concatenate', 'rulles.filter.operandClass', 'String', 'uasp-streaming-mutator' from dual  union 
select 'case-48-concatenate', 'rulles.filter.operator', 'notNull', 'uasp-streaming-mutator' from dual  union 
select 'case-48-concatenate', 'rulles.flink.job.checkpoint.service.serviceName', '${SERVICE_NAME}', 'uasp-streaming-mutator' from dual  union 
select 'case-48-concatenate', 'rulles.flink.job.checkpoint.service.serviceProfile', '${PROFILE_NAME}', 'uasp-streaming-mutator' from dual  union 
select 'case-48-concatenate', 'rulles.flink.job.checkpoint.service.serviceVersion', '${SERVICE_VERSION}', 'uasp-streaming-mutator' from dual  union 
select 'case-48-concatenate', 'rulles.flink.job.checkpoint.sync.parallelism', '${PARALLELISM}', 'uasp-streaming-mutator' from dual  union 
select 'case-68', 'enrichOne.CommonEnrichProperty$.fieldsList.a1.fromFieldName', 'CrtXzFdTpCd', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'case-68', 'enrichOne.CommonEnrichProperty$.fieldsList.a1.fromFieldType', 'String', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'case-68', 'enrichOne.CommonEnrichProperty$.fieldsList.a1.isOptionalEnrichValue', 'true', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'case-68', 'enrichOne.CommonEnrichProperty$.fieldsList.a1.toFieldName', 'CrtXzFdTpCd', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'case-68', 'enrichOne.CommonEnrichProperty$.fieldsList.a2.fromFieldName', 'CrtXzKkTpCd', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'case-68', 'enrichOne.CommonEnrichProperty$.fieldsList.a2.fromFieldType', 'Int', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'case-68', 'enrichOne.CommonEnrichProperty$.fieldsList.a2.isOptionalEnrichValue', 'true', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'case-68', 'enrichOne.CommonEnrichProperty$.fieldsList.a2.toFieldName', 'CrtXzKkTpCd', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'case-68', 'enrichOne.CommonEnrichProperty$.fieldsList.a3.fromFieldName', 'ZpBs144Flg', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'case-68', 'enrichOne.CommonEnrichProperty$.fieldsList.a3.fromFieldType', 'Boolean', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'case-68', 'enrichOne.CommonEnrichProperty$.fieldsList.a3.isOptionalEnrichValue', 'true', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'case-68', 'enrichOne.CommonEnrichProperty$.fieldsList.a3.toFieldName', 'ZpBs144Flg', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'case-68', 'enrichOne.CommonEnrichProperty$.fieldsList.a4.fromFieldName', 'mdmid', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'case-68', 'enrichOne.CommonEnrichProperty$.fieldsList.a4.fromFieldType', 'String', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'case-68', 'enrichOne.CommonEnrichProperty$.fieldsList.a4.isOptionalEnrichValue', 'true', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'case-68', 'enrichOne.CommonEnrichProperty$.fieldsList.a4.toFieldName', 'mdmid_cardfl', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'case-68', 'enrichOne.CommonEnrichProperty$.inputDataFormat', 'UaspDtoFormat', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'case-68', 'enrichOne.CommonEnrichProperty$.keySelectorEnrich.isId', 'true', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'case-68', 'enrichOne.CommonEnrichProperty$.keySelectorMain.isId', 'true', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'case-68', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.amount_sum_cft', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'case-68', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.base_amount_w4', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'case-68', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.bseamt', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'case-68', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.endbal_prf', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'case-68', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.fee_amount_w4', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'case-68', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.operationAmount', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'case-68', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.transaction_amount', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'case-68', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.transaction_amount_prf', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'case-68', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.transaction_amount_sum', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'case-68', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.transaction_amt', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'case-68', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.account_num', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'case-68', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.balanceBeforeOperation', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'case-68', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.card_expiration_dt', 'ru.vtb.uasp.common.mask.fun.CenterMaskService(1,0)', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'case-68', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.card_expire_w4', 'ru.vtb.uasp.common.mask.fun.CenterMaskService(1,0)', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'case-68', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.comment', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'case-68', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.contract_num', 'ru.vtb.uasp.common.mask.fun.AccountMask', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'case-68', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.data_operationName', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'case-68', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.fee_amount_sum', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'case-68', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.replacement_amt', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'case-68', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.source_account_w4', 'ru.vtb.uasp.common.mask.fun.AccountMask', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'case-68', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.tcmt', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'case-68', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.tcmt_account_num', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'case-68', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.tso', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'case-68', 'savepoint.pref', 'mdm_enrichment', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'case-68', 'service.serviceName', '${SERVICE_NAME}', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'case-68', 'service.serviceProfile', '${PROFILE_NAME}', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'case-68', 'service.serviceVersion', '${SERVICE_VERSION}', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'case-68', 'sync.parallelism', '${PARALLELISM}', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'case68', 'currency.alphaCode.fieldName', 'exchange_currency', 'uasp-streaming-currency-enrichment' from dual  union 
select 'case68', 'currency.date.fieldName', 'exchange_dttm', 'uasp-streaming-currency-enrichment' from dual  union 
select 'case68', 'depth.count', '14', 'uasp-streaming-currency-enrichment' from dual  union 
select 'case68', 'depth.ofDay', '14', 'uasp-streaming-currency-enrichment' from dual  union 
select 'case68', 'dlq.JsMaskedPath$.data.dataDecimal.card_expiration_dt', 'ru.vtb.uasp.common.mask.fun.StringMaskAll', 'uasp-streaming-currency-enrichment' from dual  union 
select 'case68', 'dlq.JsMaskedPath$.data.dataDecimal.endbal_prf', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-currency-enrichment' from dual  union 
select 'case68', 'dlq.JsMaskedPath$.data.dataString.account_num', 'ru.vtb.uasp.common.mask.fun.AccountMask', 'uasp-streaming-currency-enrichment' from dual  union 
select 'case68', 'dlq.JsMaskedPath$.data.dataString.card_expire_w4', 'ru.vtb.uasp.common.mask.fun.StringMaskAll', 'uasp-streaming-currency-enrichment' from dual  union 
select 'case68', 'dlq.JsMaskedPath$.data.dataString.contract_num', 'ru.vtb.uasp.common.mask.fun.StringMaskAll', 'uasp-streaming-currency-enrichment' from dual  union 
select 'case68', 'dlq.JsMaskedPath$.data.dataString.data_operationName', 'ru.vtb.uasp.common.mask.fun.StringMaskAll', 'uasp-streaming-currency-enrichment' from dual  union 
select 'case68', 'dlq.JsMaskedPath$.data.dataString.replacement_amt', 'ru.vtb.uasp.common.mask.fun.StringMaskAll', 'uasp-streaming-currency-enrichment' from dual  union 
select 'case68', 'dlq.JsMaskedPath$.data.dataString.source_account_w4', 'ru.vtb.uasp.common.mask.fun.AccountMask', 'uasp-streaming-currency-enrichment' from dual  union 
select 'case68', 'dlq.JsMaskedPath$.data.dataString.tcmt', 'ru.vtb.uasp.common.mask.fun.StringMaskAll', 'uasp-streaming-currency-enrichment' from dual  union 
select 'case68', 'dlq.JsMaskedPath$.data.dataString.tcmt_account_num', 'ru.vtb.uasp.common.mask.fun.StringMaskAll', 'uasp-streaming-currency-enrichment' from dual  union 
select 'case68', 'dlq.JsMaskedPath$.data.dataString.tso', 'ru.vtb.uasp.common.mask.fun.StringMaskAll', 'uasp-streaming-currency-enrichment' from dual  union 
select 'case68', 'max.parallelism', '8', 'uasp-streaming-unp-convertor' from dual  union 
select 'case68', 'national.currency', 'RUR', 'uasp-streaming-currency-enrichment' from dual  union 
select 'case68', 'national.rate', '1', 'uasp-streaming-currency-enrichment' from dual  union 
select 'case68', 'national.scale', '1', 'uasp-streaming-currency-enrichment' from dual  union 
select 'case68', 'recipt.currency.price.fieldName', 'currency_price', 'uasp-streaming-currency-enrichment' from dual  union 
select 'case68', 'recipt.currency.scale.fieldName', 'currency_scale', 'uasp-streaming-currency-enrichment' from dual  union 
select 'case68', 'savepoint.pref', 'uasp-streaming-currency-enrichment', 'uasp-streaming-currency-enrichment' from dual  union 
select 'case68', 'service.serviceName', '${SERVICE_NAME}', 'uasp-streaming-currency-enrichment' from dual  union 
select 'case68', 'service.serviceName', '${SERVICE_NAME}', 'uasp-streaming-unp-convertor' from dual  union 
select 'case68', 'service.serviceProfile', '${PROFILE_NAME}', 'uasp-streaming-currency-enrichment' from dual  union 
select 'case68', 'service.serviceProfile', '${PROFILE_NAME}', 'uasp-streaming-unp-convertor' from dual  union 
select 'case68', 'service.serviceVersion', '${SERVICE_VERSION}', 'uasp-streaming-currency-enrichment' from dual  union 
select 'case68', 'service.serviceVersion', '${SERVICE_VERSION}', 'uasp-streaming-unp-convertor' from dual  union 
select 'case68', 'sink.parallelism', '8', 'uasp-streaming-unp-convertor' from dual  union 
select 'case68', 'source.parallelism', '8', 'uasp-streaming-unp-convertor' from dual  union 
select 'case68', 'sync.parallelism', '8', 'uasp-streaming-currency-enrichment' from dual  union 
select 'case68', 'system.code', '1557_UASP', 'uasp-streaming-currency-enrichment' from dual  union 
select 'case-68_agrement', 'enrichOne.CommonEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.account_num', 'ru.vtb.uasp.common.mask.fun.AccountMask', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'case-68_agrement', 'enrichOne.CommonEnrichProperty$.fieldsList.a1.fromFieldName', 'card_type_cd', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'case-68_agrement', 'enrichOne.CommonEnrichProperty$.fieldsList.a1.fromFieldType', 'String', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'case-68_agrement', 'enrichOne.CommonEnrichProperty$.fieldsList.a1.isOptionalEnrichValue', 'true', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'case-68_agrement', 'enrichOne.CommonEnrichProperty$.fieldsList.a1.toFieldName', 'card_type_cd', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'case-68_agrement', 'enrichOne.CommonEnrichProperty$.inputDataFormat', 'UaspDtoFormat', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'case-68_agrement', 'enrichOne.CommonEnrichProperty$.keySelectorEnrich.isId', 'true', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'case-68_agrement', 'enrichOne.CommonEnrichProperty$.keySelectorMain.isId', 'false', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'case-68_agrement', 'enrichOne.CommonEnrichProperty$.keySelectorMain.mapKey', 'hash_card_number', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'case-68_agrement', 'enrichOne.CommonEnrichProperty$.keySelectorMain.mapType', 'String', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'case-68_agrement', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.amount_sum_cft', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'case-68_agrement', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.base_amount_w4', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'case-68_agrement', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.bseamt', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'case-68_agrement', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.endbal_prf', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'case-68_agrement', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.fee_amount_sum', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'case-68_agrement', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.fee_amount_w4', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'case-68_agrement', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.operationAmount', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'case-68_agrement', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.transaction_amount', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'case-68_agrement', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.transaction_amount_prf', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'case-68_agrement', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.transaction_amount_sum', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'case-68_agrement', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.transaction_amt', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'customer-package', 'service.serviceVersion', '${SERVICE_VERSION}', 'uasp-streaming-input-convertor' from dual  union 
select 'case-68_agrement', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.balanceBeforeOperation', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'case-68_agrement', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.card_expiration_dt', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'case-68_agrement', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.card_expire_w4', 'ru.vtb.uasp.common.mask.fun.CenterMaskService(1,0)', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'case-68_agrement', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.comment', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'case-68_agrement', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.contract_num', 'ru.vtb.uasp.common.mask.fun.AccountMask', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'case-68_agrement', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.data_operationName', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'case-68_agrement', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.replacement_amt', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'case-68_agrement', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.source_account_w4', 'ru.vtb.uasp.common.mask.fun.AccountMask', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'case-68_agrement', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.tcmt', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'case-68_agrement', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.tcmt_account_num', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'case-68_agrement', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.tso', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'case-68_agrement', 'savepoint.pref', 'mdm_enrichment', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'case-68_agrement', 'service.serviceName', '${SERVICE_NAME}', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'case-68_agrement', 'service.serviceProfile', '${PROFILE_NAME}', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'case-68_agrement', 'service.serviceVersion', '${SERVICE_VERSION}', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'case-68_agrement', 'sync.parallelism', '${PARALLELISM}', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'cbr-rate', 'max.parallelism', '8', 'uasp-streaming-unp-convertor' from dual  union 
select 'cbr-rate', 'service.serviceName', '${SERVICE_NAME}', 'uasp-streaming-unp-convertor' from dual  union 
select 'cbr-rate', 'service.serviceProfile', '${PROFILE_NAME}', 'uasp-streaming-unp-convertor' from dual  union 
select 'cbr-rate', 'service.serviceVersion', '${SERVICE_VERSION}', 'uasp-streaming-unp-convertor' from dual  union 
select 'cbr-rate', 'sink.parallelism', '8', 'uasp-streaming-unp-convertor' from dual  union 
select 'cbr-rate', 'source.parallelism', '8', 'uasp-streaming-unp-convertor' from dual  union 
select 'cft-transactions', 'max.parallelism', '8', 'uasp-streaming-unp-convertor' from dual  union 
select 'cft-transactions', 'service.serviceName', '${SERVICE_NAME}', 'uasp-streaming-unp-convertor' from dual  union 
select 'cft-transactions', 'service.serviceProfile', '${PROFILE_NAME}', 'uasp-streaming-unp-convertor' from dual  union 
select 'cft-transactions', 'service.serviceVersion', '${SERVICE_VERSION}', 'uasp-streaming-unp-convertor' from dual  union 
select 'cft-transactions', 'sink.parallelism', '8', 'uasp-streaming-unp-convertor' from dual  union 
select 'cft-transactions', 'source.parallelism', '8', 'uasp-streaming-unp-convertor' from dual  union 
select 'close_account', 'card.number.sha256.salt', '${CARD_NUMBER_SHA_256_SALT}', 'uasp-streaming-input-convertor' from dual  union 
select 'close_account', 'max.parallelism', '${PARALLELISM}', 'uasp-streaming-unp-convertor' from dual  union 
select 'close_account', 'read.source.topic.frombeginning', 'false', 'uasp-streaming-input-convertor' from dual  union 
select 'close_account', 'service.serviceName', '${SERVICE_NAME}', 'uasp-streaming-input-convertor' from dual  union 
select 'close_account', 'service.serviceName', '${SERVICE_NAME}', 'uasp-streaming-unp-convertor' from dual  union 
select 'close_account', 'service.serviceProfile', '${PROFILE_NAME}', 'uasp-streaming-input-convertor' from dual  union 
select 'close_account', 'service.serviceProfile', '${PROFILE_NAME}', 'uasp-streaming-unp-convertor' from dual  union 
select 'close_account', 'service.serviceVersion', '${SERVICE_VERSION}', 'uasp-streaming-input-convertor' from dual  union 
select 'close_account', 'service.serviceVersion', '${SERVICE_VERSION}', 'uasp-streaming-unp-convertor' from dual  union 
select 'close_account', 'sink.parallelism', '${PARALLELISM}', 'uasp-streaming-unp-convertor' from dual  union 
select 'close_account', 'source.parallelism', '${PARALLELISM}', 'uasp-streaming-unp-convertor' from dual  union 
select 'close_account', 'sync.parallelism', '${PARALLELISM}', 'uasp-streaming-input-convertor' from dual  union 
select 'close_account', 'uaspdto.type', 'close_account', 'uasp-streaming-input-convertor' from dual  union 
select 'credit-card', 'flink.job.service.serviceName', '${SERVICE_NAME}', 'uasp-streaming-beg-card-block' from dual  union 
select 'credit-card', 'flink.job.service.serviceName', '${SERVICE_NAME}', 'uasp-streaming-beg-pincode-change' from dual  union 
select 'credit-card', 'flink.job.service.serviceName', '${SERVICE_NAME}', 'uasp-streaming-cc-activation' from dual  union 
select 'credit-card', 'flink.job.service.serviceProfile', '${PROFILE_NAME}', 'uasp-streaming-beg-card-block' from dual  union 
select 'credit-card', 'flink.job.service.serviceProfile', '${PROFILE_NAME}', 'uasp-streaming-beg-pincode-change' from dual  union 
select 'credit-card', 'flink.job.service.serviceProfile', '${PROFILE_NAME}', 'uasp-streaming-cc-activation' from dual  union 
select 'credit-card', 'flink.job.service.serviceVersion', '${SERVICE_VERSION}', 'uasp-streaming-beg-card-block' from dual  union 
select 'credit-card', 'flink.job.service.serviceVersion', '${SERVICE_VERSION}', 'uasp-streaming-beg-pincode-change' from dual  union 
select 'credit-card', 'flink.job.service.serviceVersion', '${SERVICE_VERSION}', 'uasp-streaming-cc-activation' from dual  union 
select 'credit-card', 'portfolio.endpoint', 'https://epa-ig-if-lb.test.vtb.ru/api/rb/prp/aggregator/v1/portfolio/active', 'uasp-streaming-cc-activation' from dual  union 
select 'credit-card', 'portfolio.token.client', '***', 'uasp-streaming-cc-activation' from dual  union 
select 'credit-card', 'portfolio.token.endpoint', 'https://epa-am-if-lb.test.vtb.ru/passport/oauth2/token', 'uasp-streaming-cc-activation' from dual  union 
select 'credit-card', 'portfolio.token.secret', '***', 'uasp-streaming-cc-activation' from dual  union 
select 'credit-card', 'portfolio.tyk.key', '***', 'uasp-streaming-cc-activation' from dual  union 
select 'credit-card', 'test.run', 'true', 'uasp-streaming-cc-activation' from dual  union 
select 'customer-package', 'card.number.sha256.salt', '${CARD_NUMBER_SHA_256_SALT}', 'uasp-streaming-input-convertor' from dual  union 
select 'customer-package', 'read.source.topic.frombeginning', 'false', 'uasp-streaming-input-convertor' from dual  union 
select 'customer-package', 'service.serviceName', '${SERVICE_NAME}', 'uasp-streaming-input-convertor' from dual  union 
select 'customer-package', 'service.serviceProfile', '${PROFILE_NAME}', 'uasp-streaming-input-convertor' from dual  union 
select 'customer-package', 'sync.parallelism', '${PARALLELISM}', 'uasp-streaming-input-convertor' from dual  union 
select 'customer-package', 'uaspdto.type', 'customer-package', 'uasp-streaming-input-convertor' from dual  union 
select 'customer-profile-full', 'card.number.sha256.salt', '${CARD_NUMBER_SHA_256_SALT}', 'uasp-streaming-input-convertor' from dual  union 
select 'customer-profile-full', 'dlq.JsMaskedPath$.data.contract_num', 'ru.vtb.uasp.common.mask.fun.AccountMask', 'uasp-streaming-input-convertor' from dual  union 
select 'customer-profile-full', 'read.source.topic.frombeginning', 'false', 'uasp-streaming-input-convertor' from dual  union 
select 'customer-profile-full', 'service.serviceName', '${SERVICE_NAME}', 'uasp-streaming-input-convertor' from dual  union 
select 'customer-profile-full', 'service.serviceProfile', '${PROFILE_NAME}', 'uasp-streaming-input-convertor' from dual  union 
select 'customer-profile-full', 'service.serviceVersion', '${SERVICE_VERSION}', 'uasp-streaming-input-convertor' from dual  union 
select 'customer-profile-full', 'sync.parallelism', '${PARALLELISM}', 'uasp-streaming-input-convertor' from dual  union 
select 'customer-profile-full', 'uaspdto.type', 'customer-profile-full', 'uasp-streaming-input-convertor' from dual  union 
select 'first-salary', 'currency.alphaCode.fieldName', 'exchange_currency', 'uasp-streaming-currency-enrichment' from dual  union 
select 'first-salary', 'currency.date.fieldName', 'exchange_dttm', 'uasp-streaming-currency-enrichment' from dual  union 
select 'first-salary', 'depth.count', '14', 'uasp-streaming-currency-enrichment' from dual  union 
select 'first-salary', 'depth.ofDay', '14', 'uasp-streaming-currency-enrichment' from dual  union 
select 'first-salary', 'dlq.JsMaskedPath$.data.dataDecimal.card_expiration_dt', 'ru.vtb.uasp.common.mask.fun.StringMaskAll', 'uasp-streaming-currency-enrichment' from dual  union 
select 'first-salary', 'dlq.JsMaskedPath$.data.dataDecimal.endbal_prf', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-currency-enrichment' from dual  union 
select 'first-salary', 'dlq.JsMaskedPath$.data.dataString.account_num', 'ru.vtb.uasp.common.mask.fun.AccountMask', 'uasp-streaming-currency-enrichment' from dual  union 
select 'first-salary', 'dlq.JsMaskedPath$.data.dataString.card_expire_w4', 'ru.vtb.uasp.common.mask.fun.StringMaskAll', 'uasp-streaming-currency-enrichment' from dual  union 
select 'first-salary', 'dlq.JsMaskedPath$.data.dataString.contract_num', 'ru.vtb.uasp.common.mask.fun.StringMaskAll', 'uasp-streaming-currency-enrichment' from dual  union 
select 'first-salary', 'dlq.JsMaskedPath$.data.dataString.data_operationName', 'ru.vtb.uasp.common.mask.fun.StringMaskAll', 'uasp-streaming-currency-enrichment' from dual  union 
select 'first-salary', 'dlq.JsMaskedPath$.data.dataString.replacement_amt', 'ru.vtb.uasp.common.mask.fun.StringMaskAll', 'uasp-streaming-currency-enrichment' from dual  union 
select 'first-salary', 'dlq.JsMaskedPath$.data.dataString.source_account_w4', 'ru.vtb.uasp.common.mask.fun.AccountMask', 'uasp-streaming-currency-enrichment' from dual  union 
select 'first-salary', 'dlq.JsMaskedPath$.data.dataString.tcmt', 'ru.vtb.uasp.common.mask.fun.StringMaskAll', 'uasp-streaming-currency-enrichment' from dual  union 
select 'first-salary', 'dlq.JsMaskedPath$.data.dataString.tcmt_account_num', 'ru.vtb.uasp.common.mask.fun.StringMaskAll', 'uasp-streaming-currency-enrichment' from dual  union 
select 'first-salary', 'dlq.JsMaskedPath$.data.dataString.tso', 'ru.vtb.uasp.common.mask.fun.StringMaskAll', 'uasp-streaming-currency-enrichment' from dual  union 
select 'first-salary', 'national.currency', 'RUR', 'uasp-streaming-currency-enrichment' from dual  union 
select 'first-salary', 'national.rate', '1', 'uasp-streaming-currency-enrichment' from dual  union 
select 'first-salary', 'national.scale', '1', 'uasp-streaming-currency-enrichment' from dual  union 
select 'first-salary', 'recipt.currency.price.fieldName', 'currency_price', 'uasp-streaming-currency-enrichment' from dual  union 
select 'first-salary', 'recipt.currency.scale.fieldName', 'currency_scale', 'uasp-streaming-currency-enrichment' from dual  union 
select 'first-salary', 'savepoint.pref', 'uasp-streaming-currency-enrichment', 'uasp-streaming-currency-enrichment' from dual  union 
select 'first-salary', 'service.serviceName', '${SERVICE_NAME}', 'uasp-streaming-currency-enrichment' from dual  union 
select 'first-salary', 'service.serviceProfile', '${PROFILE_NAME}', 'uasp-streaming-currency-enrichment' from dual  union 
select 'first-salary', 'service.serviceVersion', '${SERVICE_VERSION}', 'uasp-streaming-currency-enrichment' from dual  union 
select 'first-salary', 'sync.parallelism', '8', 'uasp-streaming-currency-enrichment' from dual  union 
select 'first-salary', 'system.code', '1557_UASP', 'uasp-streaming-currency-enrichment' from dual  union 
select 'input-convertor-ca-cardfl', 'card.number.sha256.salt', '${CARD_NUMBER_SHA_256_SALT}', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-ca-cardfl', 'dlq.JsMaskedPath$.data.account_num', 'ru.vtb.uasp.common.mask.fun.AccountMask', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-ca-cardfl', 'dlq.JsMaskedPath$.data.card_expiration_dt', 'ru.vtb.uasp.common.mask.fun.CenterMaskService(2,2)', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-ca-cardfl', 'dlq.JsMaskedPath$.data.credit_limit_amt', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-ca-cardfl', 'read.source.topic.frombeginning', 'false', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-ca-cardfl', 'service.serviceName', '${SERVICE_NAME}', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-ca-cardfl', 'service.serviceProfile', '${PROFILE_NAME}', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-ca-cardfl', 'service.serviceVersion', '${SERVICE_VERSION}', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-ca-cardfl', 'sync.parallelism', '${PARALLELISM}', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-ca-cardfl', 'uaspdto.type', 'ca-cardfl', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-ca-depositfl', 'card.number.sha256.salt', '${CARD_NUMBER_SHA_256_SALT}', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-ca-depositfl', 'dlq.JsMaskedPath$.data.account_num', 'ru.vtb.uasp.common.mask.fun.AccountMask', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-ca-depositfl', 'read.source.topic.frombeginning', 'false', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-ca-depositfl', 'service.serviceName', '${SERVICE_NAME}', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-ca-depositfl', 'service.serviceProfile', '${PROFILE_NAME}', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-ca-depositfl', 'service.serviceVersion', '${SERVICE_VERSION}', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-ca-depositfl', 'sync.parallelism', '${PARALLELISM}', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-ca-depositfl', 'uaspdto.type', 'ca-depositfl', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-ca-first-salary', 'card.number.sha256.salt', '${CARD_NUMBER_SHA_256_SALT}', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-ca-first-salary', 'dlq.JsMaskedPath$.data.trans_amount_ca', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-ca-first-salary', 'read.source.topic.frombeginning', 'false', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-ca-first-salary', 'service.serviceName', '${SERVICE_NAME}', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-ca-first-salary', 'service.serviceProfile', '${PROFILE_NAME}', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-ca-first-salary', 'service.serviceVersion', '${SERVICE_VERSION}', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-ca-first-salary', 'sync.parallelism', '${PARALLELISM}', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-ca-first-salary', 'uaspdto.type', 'ca-first-salary', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-cardfl', 'card.number.sha256.salt', '${CARD_NUMBER_SHA_256_SALT}', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-cardfl', 'dlq.JsMaskedPath$.data.CntrCd', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-cardfl', 'dlq.JsMaskedPath$.data.InvstPrtfAmtNc', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-cardfl', 'dlq.JsMaskedPath$.data.PfmManSapId', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-cardfl', 'dlq.JsMaskedPath$.data.TtBlncAmt', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-cardfl', 'read.source.topic.frombeginning', 'true', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-cardfl', 'service.serviceName', '${SERVICE_NAME}', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-cardfl', 'service.serviceProfile', '${PROFILE_NAME}', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-cardfl', 'service.serviceVersion', '${SERVICE_VERSION}', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-cardfl', 'sync.parallelism', '${PARALLELISM}', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-cardfl', 'uaspdto.type', 'cardfl', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-cft', 'card.number.sha256.salt', '${CARD_NUMBER_SHA_256_SALT}', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-cft', 'dlq.JsMaskedPath$.data.data.feeAmount.sum', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-cft', 'dlq.JsMaskedPath$.data.data.operationAmount.sum', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-cft', 'dlq.JsMaskedPath$.data.data.operationName', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-cft', 'dlq.JsMaskedPath$.data.data.transactionAmount.sum', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-cft', 'read.source.topic.frombeginning', 'false', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-cft', 'service.serviceName', '${SERVICE_NAME}', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-cft', 'service.serviceProfile', '${PROFILE_NAME}', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-cft', 'service.serviceVersion', '${SERVICE_VERSION}', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-cft', 'sync.parallelism', '${PARALLELISM}', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-cft', 'uaspdto.type', 'first-salary', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-mdm', 'card.number.sha256.salt', '${CARD_NUMBER_SHA_256_SALT}', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-mdm', 'read.source.topic.frombeginning', 'true', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-mdm', 'service.serviceName', '${SERVICE_NAME}', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-mdm', 'service.serviceProfile', '${PROFILE_NAME}', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-mdm', 'service.serviceVersion', '${SERVICE_VERSION}', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-mdm', 'sync.parallelism', '${PARALLELISM}', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-mdm', 'uaspdto.type', 'mdm', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-prof-auth', 'card.number.sha256.salt', '${CARD_NUMBER_SHA_256_SALT}', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-prof-auth', 'dlq.JsMaskedPath$.data.acquirer_fee_amt', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-prof-auth', 'dlq.JsMaskedPath$.data.adjustment_amt', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-prof-auth', 'dlq.JsMaskedPath$.data.cardholder_billing_amt', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-prof-auth', 'dlq.JsMaskedPath$.data.replacement_amt', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-prof-auth', 'dlq.JsMaskedPath$.data.replacement_original_amt', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-prof-auth', 'dlq.JsMaskedPath$.data.transaction_amt', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-prof-auth', 'read.source.topic.frombeginning', 'false', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-prof-auth', 'service.serviceName', '${SERVICE_NAME}', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-prof-auth', 'service.serviceProfile', '${PROFILE_NAME}', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-prof-auth', 'service.serviceVersion', '${SERVICE_VERSION}', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-prof-auth', 'sync.parallelism', '${PARALLELISM}', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-prof-auth', 'uaspdto.type', 'profile-auth', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-profile', 'card.number.sha256.salt', '${CARD_NUMBER_SHA_256_SALT}', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-profile', 'dlq.JsMaskedPath$.data.endbal', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-profile', 'dlq.JsMaskedPath$.data.prin', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-profile', 'dlq.JsMaskedPath$.data.sysbase', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-profile', 'dlq.JsMaskedPath$.data.tamt', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-profile', 'dlq.JsMaskedPath$.data.tcmt', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-profile', 'dlq.JsMaskedPath$.data.tot', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-profile', 'read.source.topic.frombeginning', 'false', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-profile', 'service.serviceName', '${SERVICE_NAME}', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-profile', 'service.serviceProfile', '${PROFILE_NAME}', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-profile', 'service.serviceVersion', '${SERVICE_VERSION}', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-profile', 'sync.parallelism', '${PARALLELISM}', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-profile', 'uaspdto.type', 'profile', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-udds', 'card.number.sha256.salt', '${CARD_NUMBER_SHA_256_SALT}', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-udds', 'dlq.JsMaskedPath$.data.BALANCE_BEFORE_OPERATION', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-udds', 'dlq.JsMaskedPath$.data.OPERATION_AMOUNT', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-udds', 'read.source.topic.frombeginning', 'false', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-udds', 'service.serviceName', '${SERVICE_NAME}', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-udds', 'service.serviceProfile', '${PROFILE_NAME}', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-udds', 'service.serviceVersion', '${SERVICE_VERSION}', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-udds', 'sync.parallelism', '${PARALLELISM}', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-udds', 'uaspdto.type', 'udds', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-w4-operation', 'card.number.sha256.salt', '${CARD_NUMBER_SHA_256_SALT}', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-w4-operation', 'dlq.JsMaskedPath$.data.account.client.externalId', 'ru.vtb.uasp.common.mask.fun.CenterMaskService(3,4)', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-w4-operation', 'dlq.JsMaskedPath$.data.account.iban', 'ru.vtb.uasp.common.mask.fun.CenterMaskService(3,4)', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-w4-operation', 'dlq.JsMaskedPath$.data.card.client.externalId', 'ru.vtb.uasp.common.mask.fun.CenterMaskService(3,4)', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-w4-operation', 'dlq.JsMaskedPath$.data.card.externalId', 'ru.vtb.uasp.common.mask.fun.CenterMaskService(3,4)', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-w4-operation', 'dlq.JsMaskedPath$.data.card.plastic.expire', 'ru.vtb.uasp.common.mask.fun.CenterMaskService(1,0)', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-w4-operation', 'dlq.JsMaskedPath$.data.comment', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-w4-operation', 'dlq.JsMaskedPath$.data.counterpartyPaymentDetails.party.accountInfo.accountNumber', 'ru.vtb.uasp.common.mask.fun.AccountMask', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-w4-operation', 'dlq.JsMaskedPath$.data.PaymentDetails.corrBank.accountNumber', 'ru.vtb.uasp.common.mask.fun.CenterMaskService(3,4)', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-w4-operation', 'dlq.JsMaskedPath$.data.processing.availableAmount.amount', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-w4-operation', 'dlq.JsMaskedPath$.data.processing.baseAmount.amount', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-w4-operation', 'dlq.JsMaskedPath$.data.processing.feeAmount.amount', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-w4-operation', 'dlq.JsMaskedPath$.data.requestedAmount.billing.amount', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-w4-operation', 'dlq.JsMaskedPath$.data.requestedAmount.cashback.amount', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-w4-operation', 'dlq.JsMaskedPath$.data.requestedAmount.transaction.amount', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-w4-operation', 'dlq.JsMaskedPath$.data.аccount.client.externalId', 'ru.vtb.uasp.common.mask.fun.CenterMaskService(3,4)', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-w4-operation', 'read.source.topic.frombeginning', 'false', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-w4-operation', 'service.serviceName', '${SERVICE_NAME}', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-w4-operation', 'service.serviceProfile', '${PROFILE_NAME}', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-w4-operation', 'service.serviceVersion', '${SERVICE_VERSION}', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-w4-operation', 'sync.parallelism', '${PARALLELISM}', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-w4-operation', 'uaspdto.type', 'way4', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-withdraw', 'card.number.sha256.salt', '${CARD_NUMBER_SHA_256_SALT}', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-withdraw', 'dlq.JsMaskedPath$.data.fields.receiverName', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-withdraw', 'dlq.JsMaskedPath$.data.fields.senderName', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-withdraw', 'dlq.JsMaskedPath$.data.fields.sourceAccount', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-withdraw', 'dlq.JsMaskedPath$.data.fields.sourceSumRub', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-withdraw', 'dlq.JsMaskedPath$.data.fields.targetAccount', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-withdraw', 'read.source.topic.frombeginning', 'false', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-withdraw', 'service.serviceName', '${SERVICE_NAME}', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-withdraw', 'service.serviceProfile', '${PROFILE_NAME}', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-withdraw', 'service.serviceVersion', '${SERVICE_VERSION}', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-withdraw', 'sync.parallelism', '${PARALLELISM}', 'uasp-streaming-input-convertor' from dual  union 
select 'input-convertor-withdraw', 'uaspdto.type', 'withdraw', 'uasp-streaming-input-convertor' from dual  union 
select 'insurance', 'flink.job.service.serviceName', '${SERVICE_NAME}', 'uasp-streaming-json-validator' from dual  union 
select 'insurance', 'flink.job.service.serviceProfile', '${PROFILE_NAME}', 'uasp-streaming-json-validator' from dual  union 
select 'insurance', 'flink.job.service.serviceVersion', '${SERVICE_VERSION}', 'uasp-streaming-json-validator' from dual  union 
select 'insurance', 'validation.schema.name', 'insurance-schema.json', 'uasp-streaming-json-validator' from dual  union 
select 'kn', 'flink.job.service.serviceName', '${SERVICE_NAME}', 'uasp-streaming-json-validator' from dual  union 
select 'kn', 'flink.job.service.serviceProfile', '${PROFILE_NAME}', 'uasp-streaming-json-validator' from dual  union 
select 'kn', 'flink.job.service.serviceVersion', '${SERVICE_VERSION}', 'uasp-streaming-json-validator' from dual  union 
select 'kn', 'validation.schema.name', 'kn-schema.json', 'uasp-streaming-json-validator' from dual  union 
select 'loyalty', 'card.number.sha256.salt', '${CARD_NUMBER_SHA_256_SALT}', 'uasp-streaming-input-convertor' from dual  union 
select 'loyalty', 'read.source.topic.frombeginning', 'false', 'uasp-streaming-input-convertor' from dual  union 
select 'loyalty', 'service.serviceName', '${SERVICE_NAME}', 'uasp-streaming-input-convertor' from dual  union 
select 'loyalty', 'service.serviceProfile', '${PROFILE_NAME}', 'uasp-streaming-input-convertor' from dual  union 
select 'loyalty', 'service.serviceVersion', '${SERVICE_VERSION}', 'uasp-streaming-input-convertor' from dual  union 
select 'loyalty', 'sync.parallelism', '${PARALLELISM}', 'uasp-streaming-input-convertor' from dual  union 
select 'loyalty', 'uaspdto.type', 'loyalty', 'uasp-streaming-input-convertor' from dual  union 
select 'main', 'appOperationTTlMilliseconds', '7200000', 'uasp-streaming-refunds-event-notifier' from dual  union 
select 'main', 'appStreamCheckpointTimeMilliseconds', '10000', 'uasp-kriaa-bevents-case-2' from dual  union 
select 'main', 'appStreamCheckpointTimeMilliseconds', '10000', 'uasp-kriaa-bevents-case-40' from dual  union 
select 'main', 'appStreamCheckpointTimeMilliseconds', '10000', 'uasp-kriaa-bevents-case-56' from dual  union 
select 'main', 'appStreamCheckpointTimeMilliseconds', '10000', 'uasp-kriaa-bevents-case-57' from dual  union 
select 'main', 'appStreamCheckpointTimeMilliseconds', '10000', 'uasp-kriaa-bevents-case-68' from dual  union 
select 'main', 'appStreamCheckpointTimeMilliseconds', '10000', 'uasp-kriaa-bevents-case-70' from dual  union 
select 'main', 'appStreamCheckpointTimeMilliseconds', '10000', 'uasp-kriaa-bevents-case-84' from dual  union 
select 'main', 'appSyncParallelism', '${PARALLELISM}', 'uasp-kriaa-bevents-case-55' from dual  union 
select 'main', 'appSyncParallelism', '1', 'uasp-dko-rds-63902-accr-reciver' from dual  union 
select 'main', 'dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.endbal_prf', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-kriaa-bevents-case-70' from dual  union 
select 'main', 'dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.account_num', 'ru.vtb.uasp.common.mask.fun.AccountMask', 'uasp-kriaa-bevents-case-70' from dual  union 
select 'main', 'dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.card_expiration_dt', 'ru.vtb.uasp.common.mask.fun.StringMaskAll', 'uasp-kriaa-bevents-case-70' from dual  union 
select 'main', 'dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.card_expire_w4', 'ru.vtb.uasp.common.mask.fun.StringMaskAll', 'uasp-kriaa-bevents-case-70' from dual  union 
select 'main', 'dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.contract_num', 'ru.vtb.uasp.common.mask.fun.StringMaskAll', 'uasp-kriaa-bevents-case-70' from dual  union 
select 'main', 'dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.data_operationName', 'ru.vtb.uasp.common.mask.fun.StringMaskAll', 'uasp-kriaa-bevents-case-70' from dual  union 
select 'main', 'dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.replacement_amt', 'ru.vtb.uasp.common.mask.fun.StringMaskAll', 'uasp-kriaa-bevents-case-70' from dual  union 
select 'main', 'dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.source_account_w4', 'ru.vtb.uasp.common.mask.fun.AccountMask', 'uasp-kriaa-bevents-case-70' from dual  union 
select 'main', 'dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.tcmt', 'ru.vtb.uasp.common.mask.fun.StringMaskAll', 'uasp-kriaa-bevents-case-70' from dual  union 
select 'main', 'dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.tcmt_account_num', 'ru.vtb.uasp.common.mask.fun.StringMaskAll', 'uasp-kriaa-bevents-case-70' from dual  union 
select 'main', 'dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.tso', 'ru.vtb.uasp.common.mask.fun.StringMaskAll', 'uasp-kriaa-bevents-case-70' from dual  union 
select 'main', 'dlq.JsMaskedPath$.data.dataDecimal.card_expiration_dt', 'ru.vtb.uasp.common.mask.fun.StringMaskAll', 'uasp-streaming-refunds-event-notifier' from dual  union 
select 'main', 'dlq.JsMaskedPath$.data.dataDecimal.endbal_prf', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-refunds-event-notifier' from dual  union 
select 'main', 'dlq.JsMaskedPath$.data.dataString.account_num', 'ru.vtb.uasp.common.mask.fun.AccountMask', 'uasp-streaming-refunds-event-notifier' from dual  union 
select 'main', 'dlq.JsMaskedPath$.data.dataString.card_expire_w4', 'ru.vtb.uasp.common.mask.fun.StringMaskAll', 'uasp-streaming-refunds-event-notifier' from dual  union 
select 'main', 'dlq.JsMaskedPath$.data.dataString.contract_num', 'ru.vtb.uasp.common.mask.fun.StringMaskAll', 'uasp-streaming-refunds-event-notifier' from dual  union 
select 'main', 'dlq.JsMaskedPath$.data.dataString.data_operationName', 'ru.vtb.uasp.common.mask.fun.StringMaskAll', 'uasp-streaming-refunds-event-notifier' from dual  union 
select 'main', 'dlq.JsMaskedPath$.data.dataString.replacement_amt', 'ru.vtb.uasp.common.mask.fun.StringMaskAll', 'uasp-streaming-refunds-event-notifier' from dual  union 
select 'main', 'dlq.JsMaskedPath$.data.dataString.source_account_w4', 'ru.vtb.uasp.common.mask.fun.AccountMask', 'uasp-streaming-refunds-event-notifier' from dual  union 
select 'main', 'dlq.JsMaskedPath$.data.dataString.tcmt', 'ru.vtb.uasp.common.mask.fun.StringMaskAll', 'uasp-streaming-refunds-event-notifier' from dual  union 
select 'main', 'dlq.JsMaskedPath$.data.dataString.tcmt_account_num', 'ru.vtb.uasp.common.mask.fun.StringMaskAll', 'uasp-streaming-refunds-event-notifier' from dual  union 
select 'main', 'dlq.JsMaskedPath$.data.dataString.tso', 'ru.vtb.uasp.common.mask.fun.StringMaskAll', 'uasp-streaming-refunds-event-notifier' from dual  union 
select 'main', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.contrSum', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-kriaa-bevents-case-84' from dual  union 
select 'main', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.amount_sum_cft', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-kriaa-bevents-case-55' from dual  union 
select 'main', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.amount_sum_cft', 'ru.vtb.uasp.common.mask.fun.StringMaskAll', 'uasp-kriaa-bevents-case-56' from dual  union 
select 'main', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.amount_sum_cft', 'ru.vtb.uasp.common.mask.fun.StringMaskAll', 'uasp-kriaa-bevents-case-57' from dual  union 
select 'main', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.card_expiration_dt', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-kriaa-bevents-case-55' from dual  union 
select 'main', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.card_expiration_dt', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-kriaa-bevents-case-68' from dual  union 
select 'main', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.card_expiration_dt', 'ru.vtb.uasp.common.mask.fun.StringMaskAll', 'uasp-kriaa-bevents-case-40' from dual  union 
select 'main', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.card_expiration_dt', 'ru.vtb.uasp.common.mask.fun.StringMaskAll', 'uasp-kriaa-bevents-case-56' from dual  union 
select 'main', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.card_expiration_dt', 'ru.vtb.uasp.common.mask.fun.StringMaskAll', 'uasp-kriaa-bevents-case-57' from dual  union 
select 'main', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.employee_email', 'ru.vtb.uasp.common.mask.fun.EMailMask', 'uasp-kriaa-bevents-case-55' from dual  union 
select 'main', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.employee_full_nm', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-kriaa-bevents-case-55' from dual  union 
select 'main', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.endbal_prf', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-kriaa-bevents-case-40' from dual  union 
select 'main', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.endbal_prf', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-kriaa-bevents-case-55' from dual  union 
select 'main', 'streamCheckpointTimeoutMilliseconds', '600000', 'uasp-kriaa-bevents-case-56' from dual  union 
select 'main', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.endbal_prf', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-kriaa-bevents-case-56' from dual  union 
select 'main', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.endbal_prf', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-kriaa-bevents-case-57' from dual  union 
select 'main', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.endbal_prf', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-kriaa-bevents-case-68' from dual  union 
select 'main', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.login_id', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-kriaa-bevents-case-55' from dual  union 
select 'main', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.account_num', 'ru.vtb.uasp.common.mask.fun.AccountMask', 'uasp-kriaa-bevents-case-40' from dual  union 
select 'main', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.account_num', 'ru.vtb.uasp.common.mask.fun.AccountMask', 'uasp-kriaa-bevents-case-68' from dual  union 
select 'main', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.account_num', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-kriaa-bevents-case-55' from dual  union 
select 'main', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.account_num', 'ru.vtb.uasp.common.mask.fun.StringMaskAll', 'uasp-kriaa-bevents-case-56' from dual  union 
select 'main', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.account_num', 'ru.vtb.uasp.common.mask.fun.StringMaskAll', 'uasp-kriaa-bevents-case-57' from dual  union 
select 'main', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.card_expire_w4', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-kriaa-bevents-case-55' from dual  union 
select 'main', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.card_expire_w4', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-kriaa-bevents-case-68' from dual  union 
select 'main', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.card_expire_w4', 'ru.vtb.uasp.common.mask.fun.StringMaskAll', 'uasp-kriaa-bevents-case-40' from dual  union 
select 'main', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.card_expire_w4', 'ru.vtb.uasp.common.mask.fun.StringMaskAll', 'uasp-kriaa-bevents-case-56' from dual  union 
select 'main', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.card_expire_w4', 'ru.vtb.uasp.common.mask.fun.StringMaskAll', 'uasp-kriaa-bevents-case-57' from dual  union 
select 'main', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.contract_num', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-kriaa-bevents-case-55' from dual  union 
select 'main', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.contract_num', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-kriaa-bevents-case-68' from dual  union 
select 'main', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.contract_num', 'ru.vtb.uasp.common.mask.fun.StringMaskAll', 'uasp-kriaa-bevents-case-40' from dual  union 
select 'main', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.contract_num', 'ru.vtb.uasp.common.mask.fun.StringMaskAll', 'uasp-kriaa-bevents-case-56' from dual  union 
select 'main', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.contract_num', 'ru.vtb.uasp.common.mask.fun.StringMaskAll', 'uasp-kriaa-bevents-case-57' from dual  union 
select 'main', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.data_operationName', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-kriaa-bevents-case-55' from dual  union 
select 'main', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.data_operationName', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-kriaa-bevents-case-68' from dual  union 
select 'main', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.data_operationName', 'ru.vtb.uasp.common.mask.fun.StringMaskAll', 'uasp-kriaa-bevents-case-40' from dual  union 
select 'main', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.data_operationName', 'ru.vtb.uasp.common.mask.fun.StringMaskAll', 'uasp-kriaa-bevents-case-56' from dual  union 
select 'main', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.data_operationName', 'ru.vtb.uasp.common.mask.fun.StringMaskAll', 'uasp-kriaa-bevents-case-57' from dual  union 
select 'main', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.replacement_amt', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-kriaa-bevents-case-55' from dual  union 
select 'main', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.replacement_amt', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-kriaa-bevents-case-68' from dual  union 
select 'main', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.replacement_amt', 'ru.vtb.uasp.common.mask.fun.StringMaskAll', 'uasp-kriaa-bevents-case-40' from dual  union 
select 'main', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.replacement_amt', 'ru.vtb.uasp.common.mask.fun.StringMaskAll', 'uasp-kriaa-bevents-case-56' from dual  union 
select 'main', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.replacement_amt', 'ru.vtb.uasp.common.mask.fun.StringMaskAll', 'uasp-kriaa-bevents-case-57' from dual  union 
select 'main', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.source_account_w4', 'ru.vtb.uasp.common.mask.fun.AccountMask', 'uasp-kriaa-bevents-case-40' from dual  union 
select 'main', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.source_account_w4', 'ru.vtb.uasp.common.mask.fun.AccountMask', 'uasp-kriaa-bevents-case-55' from dual  union 
select 'main', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.source_account_w4', 'ru.vtb.uasp.common.mask.fun.AccountMask', 'uasp-kriaa-bevents-case-56' from dual  union 
select 'main', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.source_account_w4', 'ru.vtb.uasp.common.mask.fun.AccountMask', 'uasp-kriaa-bevents-case-57' from dual  union 
select 'main', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.source_account_w4', 'ru.vtb.uasp.common.mask.fun.AccountMask', 'uasp-kriaa-bevents-case-68' from dual  union 
select 'main', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.tcmt', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-kriaa-bevents-case-55' from dual  union 
select 'main', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.tcmt', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-kriaa-bevents-case-68' from dual  union 
select 'main', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.tcmt', 'ru.vtb.uasp.common.mask.fun.StringMaskAll', 'uasp-kriaa-bevents-case-40' from dual  union 
select 'main', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.tcmt', 'ru.vtb.uasp.common.mask.fun.StringMaskAll', 'uasp-kriaa-bevents-case-56' from dual  union 
select 'main', 'streamCheckpointTimeoutMilliseconds', '600000', 'uasp-kriaa-bevents-case-57' from dual  union 
select 'main', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.tcmt', 'ru.vtb.uasp.common.mask.fun.StringMaskAll', 'uasp-kriaa-bevents-case-57' from dual  union 
select 'main', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.tcmt_account_num', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-kriaa-bevents-case-55' from dual  union 
select 'main', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.tcmt_account_num', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-kriaa-bevents-case-68' from dual  union 
select 'main', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.tcmt_account_num', 'ru.vtb.uasp.common.mask.fun.StringMaskAll', 'uasp-kriaa-bevents-case-40' from dual  union 
select 'main', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.tcmt_account_num', 'ru.vtb.uasp.common.mask.fun.StringMaskAll', 'uasp-kriaa-bevents-case-56' from dual  union 
select 'main', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.tcmt_account_num', 'ru.vtb.uasp.common.mask.fun.StringMaskAll', 'uasp-kriaa-bevents-case-57' from dual  union 
select 'main', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.tso', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-kriaa-bevents-case-55' from dual  union 
select 'main', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.tso', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-kriaa-bevents-case-68' from dual  union 
select 'main', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.tso', 'ru.vtb.uasp.common.mask.fun.StringMaskAll', 'uasp-kriaa-bevents-case-40' from dual  union 
select 'main', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.tso', 'ru.vtb.uasp.common.mask.fun.StringMaskAll', 'uasp-kriaa-bevents-case-56' from dual  union 
select 'main', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.tso', 'ru.vtb.uasp.common.mask.fun.StringMaskAll', 'uasp-kriaa-bevents-case-57' from dual  union 
select 'main', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.employee_email', 'ru.vtb.uasp.common.mask.fun.EMailMask', 'uasp-kriaa-bevents-case-55' from dual  union 
select 'main', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.employee_full_nm', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-kriaa-bevents-case-55' from dual  union 
select 'main', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.login_id', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-kriaa-bevents-case-55' from dual  union 
select 'main', 'max.parallelism', '8', 'uasp-kriaa-bevents-case-70' from dual  union 
select 'main', 'savepoint.pref', 'case-2', 'uasp-kriaa-bevents-case-2' from dual  union 
select 'main', 'savepoint.pref', 'case-40', 'uasp-kriaa-bevents-case-40' from dual  union 
select 'main', 'savepoint.pref', 'case-56', 'uasp-kriaa-bevents-case-56' from dual  union 
select 'main', 'savepoint.pref', 'case-57', 'uasp-kriaa-bevents-case-57' from dual  union 
select 'main', 'savepoint.pref', 'case-68', 'uasp-kriaa-bevents-case-68' from dual  union 
select 'main', 'savepoint.pref', 'uasp-streaming-refunds-event-notifier', 'uasp-streaming-refunds-event-notifier' from dual  union 
select 'main', 'service.serviceName', '${SERVICE_NAME}', 'uasp-dko-rds-63902-accr-reciver' from dual  union 
select 'main', 'service.serviceName', '${SERVICE_NAME}', 'uasp-kriaa-bevents-case-2' from dual  union 
select 'main', 'service.serviceName', '${SERVICE_NAME}', 'uasp-kriaa-bevents-case-40' from dual  union 
select 'main', 'service.serviceName', '${SERVICE_NAME}', 'uasp-kriaa-bevents-case-56' from dual  union 
select 'main', 'service.serviceName', '${SERVICE_NAME}', 'uasp-kriaa-bevents-case-57' from dual  union 
select 'main', 'service.serviceName', '${SERVICE_NAME}', 'uasp-kriaa-bevents-case-68' from dual  union 
select 'main', 'service.serviceName', '${SERVICE_NAME}', 'uasp-kriaa-bevents-case-70' from dual  union 
select 'main', 'service.serviceName', '${SERVICE_NAME}', 'uasp-kriaa-bevents-case-84' from dual  union 
select 'main', 'service.serviceName', '${SERVICE_NAME}', 'uasp-kriaa-bevents-insurence-cft' from dual  union 
select 'main', 'service.serviceName', '${SERVICE_NAME}', 'uasp-kriaa-bevents-insurence-kn' from dual  union 
select 'main', 'service.serviceName', '${SERVICE_NAME}', 'uasp-streaming-refunds-event-notifier' from dual  union 
select 'main', 'service.serviceName', 'uasp-kriaa-bevents-case-55', 'uasp-kriaa-bevents-case-55' from dual  union 
select 'main', 'service.serviceProfile', '${PROFILE_NAME}', 'uasp-dko-rds-63902-accr-reciver' from dual  union 
select 'main', 'service.serviceProfile', '${PROFILE_NAME}', 'uasp-kriaa-bevents-case-2' from dual  union 
select 'main', 'service.serviceProfile', '${PROFILE_NAME}', 'uasp-kriaa-bevents-case-40' from dual  union 
select 'main', 'service.serviceProfile', '${PROFILE_NAME}', 'uasp-kriaa-bevents-case-56' from dual  union 
select 'main', 'service.serviceProfile', '${PROFILE_NAME}', 'uasp-kriaa-bevents-case-57' from dual  union 
select 'main', 'service.serviceProfile', '${PROFILE_NAME}', 'uasp-kriaa-bevents-case-68' from dual  union 
select 'main', 'service.serviceProfile', '${PROFILE_NAME}', 'uasp-kriaa-bevents-case-70' from dual  union 
select 'main', 'service.serviceProfile', '${PROFILE_NAME}', 'uasp-kriaa-bevents-case-84' from dual  union 
select 'main', 'service.serviceProfile', '${PROFILE_NAME}', 'uasp-kriaa-bevents-insurence-cft' from dual  union 
select 'main', 'service.serviceProfile', '${PROFILE_NAME}', 'uasp-kriaa-bevents-insurence-kn' from dual  union 
select 'main', 'service.serviceProfile', '${PROFILE_NAME}', 'uasp-streaming-refunds-event-notifier' from dual  union 
select 'main', 'service.serviceProfile', 'main', 'uasp-kriaa-bevents-case-55' from dual  union 
select 'main', 'service.serviceVersion', '${SERVICE_VERSION}', 'uasp-dko-rds-63902-accr-reciver' from dual  union 
select 'main', 'service.serviceVersion', '${SERVICE_VERSION}', 'uasp-kriaa-bevents-case-2' from dual  union 
select 'main', 'service.serviceVersion', '${SERVICE_VERSION}', 'uasp-kriaa-bevents-case-40' from dual  union 
select 'main', 'service.serviceVersion', '${SERVICE_VERSION}', 'uasp-kriaa-bevents-case-55' from dual  union 
select 'main', 'service.serviceVersion', '${SERVICE_VERSION}', 'uasp-kriaa-bevents-case-56' from dual  union 
select 'main', 'service.serviceVersion', '${SERVICE_VERSION}', 'uasp-kriaa-bevents-case-57' from dual  union 
select 'main', 'service.serviceVersion', '${SERVICE_VERSION}', 'uasp-kriaa-bevents-case-68' from dual  union 
select 'main', 'service.serviceVersion', '${SERVICE_VERSION}', 'uasp-kriaa-bevents-case-70' from dual  union 
select 'main', 'service.serviceVersion', '${SERVICE_VERSION}', 'uasp-kriaa-bevents-case-84' from dual  union 
select 'main', 'service.serviceVersion', '${SERVICE_VERSION}', 'uasp-kriaa-bevents-insurence-cft' from dual  union 
select 'main', 'service.serviceVersion', '${SERVICE_VERSION}', 'uasp-kriaa-bevents-insurence-kn' from dual  union 
select 'main', 'service.serviceVersion', '${SERVICE_VERSION}', 'uasp-streaming-refunds-event-notifier' from dual  union 
select 'main', 'stateCheckpointsNumRetained', '8', 'uasp-kriaa-bevents-case-2' from dual  union 
select 'main', 'stateCheckpointsNumRetained', '8', 'uasp-kriaa-bevents-case-40' from dual  union 
select 'main', 'stateCheckpointsNumRetained', '8', 'uasp-kriaa-bevents-case-56' from dual  union 
select 'main', 'stateCheckpointsNumRetained', '8', 'uasp-kriaa-bevents-case-57' from dual  union 
select 'main', 'stateCheckpointsNumRetained', '8', 'uasp-kriaa-bevents-case-68' from dual  union 
select 'main', 'stateCheckpointsNumRetained', '8', 'uasp-kriaa-bevents-case-70' from dual  union 
select 'main', 'stateCheckpointsNumRetained', '8', 'uasp-kriaa-bevents-case-84' from dual  union 
select 'main', 'streamCheckpointTimeoutMilliseconds', '600000', 'uasp-kriaa-bevents-case-2' from dual  union 
select 'main', 'streamCheckpointTimeoutMilliseconds', '600000', 'uasp-kriaa-bevents-case-40' from dual  union 
select 'main', 'streamCheckpointTimeoutMilliseconds', '600000', 'uasp-kriaa-bevents-case-68' from dual  union 
select 'main', 'streamCheckpointTimeoutMilliseconds', '600000', 'uasp-kriaa-bevents-case-70' from dual  union 
select 'main', 'streamCheckpointTimeoutMilliseconds', '600000', 'uasp-kriaa-bevents-case-84' from dual  union 
select 'main', 'sync.parallelism', '${PARALLELISM}', 'uasp-kriaa-bevents-case-2' from dual  union 
select 'main', 'sync.parallelism', '${PARALLELISM}', 'uasp-kriaa-bevents-case-40' from dual  union 
select 'main', 'sync.parallelism', '${PARALLELISM}', 'uasp-kriaa-bevents-case-55' from dual  union 
select 'main', 'sync.parallelism', '${PARALLELISM}', 'uasp-kriaa-bevents-case-56' from dual  union 
select 'main', 'sync.parallelism', '${PARALLELISM}', 'uasp-kriaa-bevents-case-68' from dual  union 
select 'main', 'sync.parallelism', '${PARALLELISM}', 'uasp-kriaa-bevents-case-84' from dual  union 
select 'main', 'sync.parallelism', '${PARALLELISM}', 'uasp-kriaa-bevents-case-86' from dual  union 
select 'main', 'sync.parallelism', '8', 'uasp-kriaa-bevents-case-57' from dual  union 
select 'main', 'sync.parallelism', '8', 'uasp-kriaa-bevents-insurence-cft' from dual  union 
select 'main', 'sync.parallelism', '8', 'uasp-kriaa-bevents-insurence-kn' from dual  union 
select 'main', 'sync.parallelism', '8', 'uasp-streaming-refunds-event-notifier' from dual  union 
select 'main', 'timeZoneOffset', '3', 'uasp-kriaa-bevents-case-55' from dual  union 
select 'main', 'windows.size.time.minutes', '2', 'uasp-kriaa-bevents-case-70' from dual  union 
select 'main', 'windowsSizeTimeMinutes', '${WINDOWS_SIZE_TIME_MINUTES}', 'uasp-kriaa-bevents-case-55' from dual  union 
select 'mainInput', 'kafka.producers.filterErrorTag-error.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.base_amount_w4', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mutator' from dual  union 
select 'mainInput', 'kafka.producers.filterErrorTag-error.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.fee_amount_w4', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mutator' from dual  union 
select 'mainInput', 'kafka.producers.filterErrorTag-error.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.transaction_amount', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mutator' from dual  union 
select 'mainInput', 'kafka.producers.filterErrorTag-error.FlinkSinkProperties$.JsMaskedPath$.data.dataString.card_expire_w4', 'ru.vtb.uasp.common.mask.fun.CenterMaskService(1,0)', 'uasp-streaming-mutator' from dual  union 
select 'mainInput', 'kafka.producers.filterErrorTag-error.FlinkSinkProperties$.JsMaskedPath$.data.dataString.comment', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mutator' from dual  union 
select 'mainInput', 'kafka.producers.filterErrorTag-error.FlinkSinkProperties$.JsMaskedPath$.data.dataString.source_account_w4', 'ru.vtb.uasp.common.mask.fun.AccountMask', 'uasp-streaming-mutator' from dual  union 
select 'mainInput', 'rulles.drools.list', 'way4-case-2_2.drl,way4-case-2_3.drl,way4-case-2_4.drl,way4-case-2_10.drl,way4-case-5_2.drl,way4-case-5_3.drl,way4-case-11_2.drl', 'uasp-streaming-mutator' from dual  union 
select 'mainInput', 'rulles.filter.fieldName', 'sys-BussinesRulles-error', 'uasp-streaming-mutator' from dual  union 
select 'mainInput', 'rulles.filter.operandClass', 'String', 'uasp-streaming-mutator' from dual  union 
select 'mainInput', 'rulles.filter.operator', 'null', 'uasp-streaming-mutator' from dual  union 
select 'mainInput', 'rulles.flink.job.checkpoint.service.serviceName', '${SERVICE_NAME}', 'uasp-streaming-mutator' from dual  union 
select 'mainInput', 'rulles.flink.job.checkpoint.service.serviceProfile', '${PROFILE_NAME}', 'uasp-streaming-mutator' from dual  union 
select 'mainInput', 'rulles.flink.job.checkpoint.service.serviceVersion', '${SERVICE_VERSION}', 'uasp-streaming-mutator' from dual  union 
select 'mainInput', 'rulles.flink.job.checkpoint.sync.parallelism', '${PARALLELISM}', 'uasp-streaming-mutator' from dual  union 
select 'main-input-filter', 'filter.fieldName', 'system-uasp-way-classification', 'uasp-streaming-filter' from dual  union 
select 'main-input-filter', 'filter.operandClass', 'String', 'uasp-streaming-filter' from dual  union 
select 'main-input-filter', 'filter.operator', 'notNull', 'uasp-streaming-filter' from dual  union 
select 'main-input-filter', 'flink.job.service.serviceName', '${SERVICE_NAME}', 'uasp-streaming-filter' from dual  union 
select 'main-input-filter', 'flink.job.service.serviceProfile', '${PROFILE_NAME}', 'uasp-streaming-filter' from dual  union 
select 'main-input-filter', 'flink.job.service.serviceVersion', '${SERVICE_VERSION}', 'uasp-streaming-filter' from dual  union 
select 'main-input-filter', 'flink.job.sync.parallelism', '${PARALLELISM}', 'uasp-streaming-filter' from dual  union 
select 'main-input-filter', 'kafka.producer.filterTag-error.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.base_amount_w4', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-filter' from dual  union 
select 'main-input-filter', 'kafka.producer.filterTag-error.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.fee_amount_w4', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-filter' from dual  union 
select 'main-input-filter', 'kafka.producer.filterTag-error.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.transaction_amount', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-filter' from dual  union 
select 'main-input-filter', 'kafka.producer.filterTag-error.FlinkSinkProperties$.JsMaskedPath$.data.dataString.card_expire_w4', 'ru.vtb.uasp.common.mask.fun.CenterMaskService(1,0)', 'uasp-streaming-filter' from dual  union 
select 'main-input-filter', 'kafka.producer.filterTag-error.FlinkSinkProperties$.JsMaskedPath$.data.dataString.comment', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-filter' from dual  union 
select 'main-input-filter', 'kafka.producer.filterTag-error.FlinkSinkProperties$.JsMaskedPath$.data.dataString.source_account_w4', 'ru.vtb.uasp.common.mask.fun.AccountMask', 'uasp-streaming-filter' from dual  union 
select 'mdm-profile', 'card.number.sha256.salt', '${CARD_NUMBER_SHA_256_SALT}', 'uasp-streaming-input-convertor' from dual  union 
select 'mdm-profile', 'read.source.topic.frombeginning', 'false', 'uasp-streaming-input-convertor' from dual  union 
select 'mdm-profile', 'service.serviceName', '${SERVICE_NAME}', 'uasp-streaming-input-convertor' from dual  union 
select 'mdm-profile', 'service.serviceProfile', '${PROFILE_NAME}', 'uasp-streaming-input-convertor' from dual  union 
select 'mdm-profile', 'service.serviceVersion', '${SERVICE_VERSION}', 'uasp-streaming-input-convertor' from dual  union 
select 'mdm-profile', 'sync.parallelism', '${PARALLELISM}', 'uasp-streaming-input-convertor' from dual  union 
select 'mdm-profile', 'uaspdto.type', 'mdm-profile', 'uasp-streaming-input-convertor' from dual  union 
select 'model-vector-bevents', 'mv.max.parallelism', '${PARALLELISM}', 'uasp-streaming-model-vector' from dual  union 
select 'model-vector-bevents', 'mv.state.checkpoints.num-retained', '4', 'uasp-streaming-model-vector' from dual  union 
select 'model-vector-bevents', 'mv.stream.checkpoint.time.seconds', '120000', 'uasp-streaming-model-vector' from dual  union 
select 'model-vector-bevents', 'producer.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.card_expiration_dt', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-model-vector' from dual  union 
select 'model-vector-bevents', 'producer.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.endbal_prf', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-model-vector' from dual  union 
select 'model-vector-bevents', 'producer.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.account_num', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-model-vector' from dual  union 
select 'model-vector-bevents', 'producer.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.card_expire_w4', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-model-vector' from dual  union 
select 'model-vector-bevents', 'producer.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.contract_num', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-model-vector' from dual  union 
select 'model-vector-bevents', 'producer.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.data_operationName', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-model-vector' from dual  union 
select 'model-vector-bevents', 'producer.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.replacement_amt', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-model-vector' from dual  union 
select 'model-vector-bevents', 'producer.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.source_account_w4', 'ru.vtb.uasp.common.mask.fun.AccountMask', 'uasp-streaming-model-vector' from dual  union 
select 'model-vector-bevents', 'producer.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.tcmt', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-model-vector' from dual  union 
select 'model-vector-bevents', 'producer.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.tcmt_account_num', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-model-vector' from dual  union 
select 'model-vector-bevents', 'producer.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.tso', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-model-vector' from dual  union 
select 'model-vector-bevents', 'service.serviceName', '${SERVICE_NAME}', 'uasp-streaming-model-vector' from dual  union 
select 'model-vector-bevents', 'service.serviceProfile', '${PROFILE_NAME}', 'uasp-streaming-model-vector' from dual  union 
select 'model-vector-bevents', 'service.serviceVersion', '${SERVICE_VERSION}', 'uasp-streaming-model-vector' from dual  union 
select 'outer-cbr-rate', 'max.parallelism', '4', 'uasp-streaming-unp-convertor' from dual  union 
select 'outer-cbr-rate', 'service.serviceName', '${SERVICE_NAME}', 'uasp-streaming-unp-convertor' from dual  union 
select 'outer-cbr-rate', 'service.serviceProfile', '${PROFILE_NAME}', 'uasp-streaming-unp-convertor' from dual  union 
select 'outer-cbr-rate', 'service.serviceVersion', '${SERVICE_VERSION}', 'uasp-streaming-unp-convertor' from dual  union 
select 'outer-cbr-rate', 'sink.parallelism', '1', 'uasp-streaming-unp-convertor' from dual  union 
select 'outer-cbr-rate', 'source.parallelism', '3', 'uasp-streaming-unp-convertor' from dual  union 
select 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a01.fromFieldName', 'mask_card_number', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a01.fromFieldType', 'String', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a01.isOptionalEnrichValue', 'true', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a01.toFieldName', 'MASK_CARD_NUMBER', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a02.fromFieldName', 'customer_id', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a02.fromFieldType', 'String', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a02.isOptionalEnrichValue', 'true', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a02.toFieldName', 'customer_id', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a03.fromFieldName', 'source_system_cd', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a03.fromFieldType', 'String', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a03.isOptionalEnrichValue', 'true', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a03.toFieldName', 'source_system_cd', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a04.fromFieldName', 'pos_flg', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a04.fromFieldType', 'String', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a04.isOptionalEnrichValue', 'true', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a04.toFieldName', 'pos_flg', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a05.fromFieldName', 'account_num', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a05.fromFieldType', 'String', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a05.isOptionalEnrichValue', 'true', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a05.toFieldName', 'account_num', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a06.fromFieldName', 'is_virtual_card_flg', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a06.fromFieldType', 'String', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a06.isOptionalEnrichValue', 'true', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a06.toFieldName', 'is_virtual_card_flg', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a07.fromFieldName', 'card_expiration_dt', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a07.fromFieldType', 'String', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a07.isOptionalEnrichValue', 'true', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a07.toFieldName', 'card_expiration_dt', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a08.fromFieldName', 'payment_system_desc', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a08.fromFieldType', 'String', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a08.isOptionalEnrichValue', 'true', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a08.toFieldName', 'payment_system_desc', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a09.fromFieldName', 'card_type_cd', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a09.fromFieldType', 'String', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a09.isOptionalEnrichValue', 'true', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a09.toFieldName', 'card_type_cd', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a10.fromFieldName', 'salary_serv_pack_flg', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a10.fromFieldType', 'String', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'unp_w4_issuing_card', 'sink.parallelism', '8', 'uasp-streaming-unp-convertor' from dual  union 
select 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a10.isOptionalEnrichValue', 'true', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a10.toFieldName', 'salary_serv_pack_flg', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a11.fromFieldName', 'salary_project_flg', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a11.fromFieldType', 'String', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a11.isOptionalEnrichValue', 'true', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a11.toFieldName', 'salary_project_flg', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a12.fromFieldName', 'salary_account_scheme_flg', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a12.fromFieldType', 'String', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a12.isOptionalEnrichValue', 'true', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a12.toFieldName', 'salary_account_scheme_flg', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a13.fromFieldName', 'salary_card_type_flg', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a13.fromFieldType', 'String', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a13.isOptionalEnrichValue', 'true', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a13.toFieldName', 'salary_card_type_flg', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a14.fromFieldName', 'contract_card_type_cd', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a14.fromFieldType', 'String', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a14.isOptionalEnrichValue', 'true', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a14.toFieldName', 'contract_card_type_cd', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a15.fromFieldName', 'hash_card_number', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a15.fromFieldType', 'String', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a15.isOptionalEnrichValue', 'true', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a15.toFieldName', 'hash_card_number', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.globalEnrichFields.fromFieldName', 'mdm_id', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.globalEnrichFields.fromFieldType', 'String', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.globalEnrichFields.isOptionalEnrichValue', 'false', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.globalEnrichFields.toFieldName', 'calculate-mdm_id', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.inputDataFormat', 'UaspDtoFormat', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.keySelectorEnrich.isId', 'true', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.keySelectorMain.isId', 'false', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.keySelectorMain.mapKey', 'card_number_sha_256', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth', 'enrichOne.GlobalIdEnrichProperty$.keySelectorMain.mapType', 'String', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.transaction_amt', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.replacement_amt', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth', 'savepoint.pref', 'mdm_enrichment', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth', 'service.serviceName', '${SERVICE_NAME}', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth', 'service.serviceProfile', '${PROFILE_NAME}', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth', 'service.serviceVersion', '${SERVICE_VERSION}', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth', 'sync.parallelism', '${PARALLELISM}', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth-packNM', 'enrichOne.CommonEnrichProperty$.fieldsList.a01.fromFieldName', 'package_nm', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth-packNM', 'enrichOne.CommonEnrichProperty$.fieldsList.a01.fromFieldType', 'String', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth-packNM', 'enrichOne.CommonEnrichProperty$.fieldsList.a01.isOptionalEnrichValue', 'true', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth-packNM', 'enrichOne.CommonEnrichProperty$.fieldsList.a01.toFieldName', 'package_nm', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth-packNM', 'enrichOne.CommonEnrichProperty$.fieldsList.a02.fromFieldName', 'multibonus_flg', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth-packNM', 'enrichOne.CommonEnrichProperty$.fieldsList.a02.fromFieldType', 'String', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth-packNM', 'enrichOne.CommonEnrichProperty$.fieldsList.a02.isOptionalEnrichValue', 'true', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth-packNM', 'enrichOne.CommonEnrichProperty$.fieldsList.a02.toFieldName', 'multibonus_flg', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth-packNM', 'enrichOne.CommonEnrichProperty$.fieldsList.a03.fromFieldName', 'pension_flg', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth-packNM', 'enrichOne.CommonEnrichProperty$.fieldsList.a03.fromFieldType', 'String', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth-packNM', 'enrichOne.CommonEnrichProperty$.fieldsList.a03.isOptionalEnrichValue', 'true', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth-packNM', 'enrichOne.CommonEnrichProperty$.fieldsList.a03.toFieldName', 'pension_flg', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth-packNM', 'enrichOne.CommonEnrichProperty$.inputDataFormat', 'UaspDtoFormat', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth-packNM', 'enrichOne.CommonEnrichProperty$.keySelectorEnrich.isId', 'true', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth-packNM', 'enrichOne.CommonEnrichProperty$.keySelectorMain.isId', 'true', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth-packNM', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.amount_sum_cft', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'unp_w4_issuing_card', 'source.parallelism', '8', 'uasp-streaming-unp-convertor' from dual  union 
select 'prof-auth-packNM', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.base_amount_w4', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth-packNM', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.bseamt', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth-packNM', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.endbal_prf', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth-packNM', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.fee_amount_sum', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth-packNM', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.fee_amount_w4', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth-packNM', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.operationAmount', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth-packNM', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.transaction_amount', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth-packNM', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.transaction_amount_prf', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth-packNM', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.transaction_amount_sum', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth-packNM', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.transaction_amt', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth-packNM', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.account_num', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth-packNM', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.card_expiration_dt', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth-packNM', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.card_expire_w4', 'ru.vtb.uasp.common.mask.fun.CenterMaskService(1,0)', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth-packNM', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.comment', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth-packNM', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.contract_num', 'ru.vtb.uasp.common.mask.fun.AccountMask', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth-packNM', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.data_operationName', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth-packNM', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.replacement_amt', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth-packNM', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.source_account_w4', 'ru.vtb.uasp.common.mask.fun.AccountMask', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth-packNM', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.tcmt', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth-packNM', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.tcmt_account_num', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth-packNM', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.tso', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth-packNM', 'savepoint.pref', 'mdm_enrichment', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth-packNM', 'service.serviceName', '${SERVICE_NAME}', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth-packNM', 'service.serviceProfile', '${PROFILE_NAME}', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth-packNM', 'service.serviceVersion', '${SERVICE_VERSION}', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-auth-packNM', 'sync.parallelism', '${PARALLELISM}', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'profile-auth', 'max.parallelism', '8', 'uasp-streaming-unp-convertor' from dual  union 
select 'profile-auth', 'service.serviceName', '${SERVICE_NAME}', 'uasp-streaming-unp-convertor' from dual  union 
select 'profile-auth', 'service.serviceProfile', '${PROFILE_NAME}', 'uasp-streaming-unp-convertor' from dual  union 
select 'profile-auth', 'service.serviceVersion', '${SERVICE_VERSION}', 'uasp-streaming-unp-convertor' from dual  union 
select 'profile-auth', 'sink.parallelism', '8', 'uasp-streaming-unp-convertor' from dual  union 
select 'profile-auth', 'source.parallelism', '8', 'uasp-streaming-unp-convertor' from dual  union 
select 'profile-transactions', 'max.parallelism', '8', 'uasp-streaming-unp-convertor' from dual  union 
select 'profile-transactions', 'service.serviceName', '${SERVICE_NAME}', 'uasp-streaming-unp-convertor' from dual  union 
select 'profile-transactions', 'service.serviceProfile', '${PROFILE_NAME}', 'uasp-streaming-unp-convertor' from dual  union 
select 'profile-transactions', 'service.serviceVersion', '${SERVICE_VERSION}', 'uasp-streaming-unp-convertor' from dual  union 
select 'profile-transactions', 'sink.parallelism', '8', 'uasp-streaming-unp-convertor' from dual  union 
select 'profile-transactions', 'source.parallelism', '8', 'uasp-streaming-unp-convertor' from dual  union 
select 'profile-tx-step1', 'enrichOne.GlobalIdEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.bseamt', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'profile-tx-step1', 'enrichOne.GlobalIdEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.transaction_amount_prf', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'profile-tx-step1', 'enrichOne.GlobalIdEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.contract_num', 'ru.vtb.uasp.common.mask.fun.AccountMask', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'profile-tx-step1', 'enrichOne.GlobalIdEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.tcmt', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'profile-tx-step1', 'enrichOne.GlobalIdEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.tcmt_account_num', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'profile-tx-step1', 'enrichOne.GlobalIdEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.tso', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'profile-tx-step1', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a1.fromFieldName', 'contract_num', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'profile-tx-step1', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a1.fromFieldType', 'String', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'profile-tx-step1', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a1.isOptionalEnrichValue', 'false', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'profile-tx-step1', 'enrichOne.GlobalIdEnrichProperty$.fieldsList.a1.toFieldName', 'contract_num', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'profile-tx-step1', 'enrichOne.GlobalIdEnrichProperty$.globalEnrichFields.fromFieldName', 'customer_id', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'profile-tx-step1', 'enrichOne.GlobalIdEnrichProperty$.globalEnrichFields.fromFieldType', 'String', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'profile-tx-step1', 'enrichOne.GlobalIdEnrichProperty$.globalEnrichFields.isOptionalEnrichValue', 'false', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'profile-tx-step1', 'enrichOne.GlobalIdEnrichProperty$.globalEnrichFields.toFieldName', 'calculate-customer_id', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'profile-tx-step1', 'enrichOne.GlobalIdEnrichProperty$.inputDataFormat', 'UaspDtoFormat', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'profile-tx-step1', 'enrichOne.GlobalIdEnrichProperty$.keySelectorEnrich.isId', 'true', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'profile-tx-step1', 'enrichOne.GlobalIdEnrichProperty$.keySelectorMain.isId', 'true', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'profile-tx-step1', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.bseamt', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'profile-tx-step1', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.endbal_prf', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'profile-tx-step1', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.transaction_amount_prf', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'profile-tx-step1', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.contract_num', 'ru.vtb.uasp.common.mask.fun.AccountMask', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'profile-tx-step1', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.tcmt', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'profile-tx-step1', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.tcmt_account_num', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'profile-tx-step1', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.tso', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'profile-tx-step1', 'savepoint.pref', 'mdm_enrichment', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'profile-tx-step1', 'service.serviceName', '${SERVICE_NAME}', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'profile-tx-step1', 'service.serviceProfile', '${PROFILE_NAME}', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'profile-tx-step1', 'service.serviceVersion', '${SERVICE_VERSION}', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'profile-tx-step1', 'sync.parallelism', '${PARALLELISM}', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'profile-tx-step2', 'enrichOne.GlobalIdEnrichProperty$.globalEnrichFields.fromFieldName', 'global_id', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'profile-tx-step2', 'enrichOne.GlobalIdEnrichProperty$.globalEnrichFields.fromFieldType', 'String', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'profile-tx-step2', 'enrichOne.GlobalIdEnrichProperty$.globalEnrichFields.isOptionalEnrichValue', 'false', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'profile-tx-step2', 'enrichOne.GlobalIdEnrichProperty$.globalEnrichFields.toFieldName', 'calculate-mdm_id', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'profile-tx-step2', 'enrichOne.GlobalIdEnrichProperty$.inputDataFormat', 'UaspDtoFormat', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'profile-tx-step2', 'enrichOne.GlobalIdEnrichProperty$.keySelectorEnrich.isId', 'true', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'profile-tx-step2', 'enrichOne.GlobalIdEnrichProperty$.keySelectorMain.isId', 'true', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'profile-tx-step2', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.bseamt', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'profile-tx-step2', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.endbal_prf', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'profile-tx-step2', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.transaction_amount_prf', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'profile-tx-step2', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.contract_num', 'ru.vtb.uasp.common.mask.fun.AccountMask', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'profile-tx-step2', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.tcmt', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'profile-tx-step2', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.tcmt_account_num', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'profile-tx-step2', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.tso', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'profile-tx-step2', 'savepoint.pref', 'mdm_enrichment', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'profile-tx-step2', 'service.serviceName', '${SERVICE_NAME}', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'profile-tx-step2', 'service.serviceProfile', '${PROFILE_NAME}', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'profile-tx-step2', 'service.serviceVersion', '${SERVICE_VERSION}', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'profile-tx-step2', 'sync.parallelism', '${PARALLELISM}', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-tx-case-71', 'enrichOne.CommonEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.bseamt', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-tx-case-71', 'enrichOne.CommonEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.transaction_amount_prf', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-tx-case-71', 'enrichOne.CommonEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.account_num', 'ru.vtb.uasp.common.mask.fun.AccountMask', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-tx-case-71', 'enrichOne.CommonEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.tcmt', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'uz', 'flink.job.service.serviceName', '${SERVICE_NAME}', 'uasp-streaming-json-validator' from dual  union 
select 'prof-tx-case-71', 'enrichOne.CommonEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.tcmt_account_num', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-tx-case-71', 'enrichOne.CommonEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.tso', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-tx-case-71', 'enrichOne.CommonEnrichProperty$.fieldsList.a1.fromFieldName', 'product_nm', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-tx-case-71', 'enrichOne.CommonEnrichProperty$.fieldsList.a1.fromFieldType', 'String', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-tx-case-71', 'enrichOne.CommonEnrichProperty$.fieldsList.a1.isOptionalEnrichValue', 'true', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-tx-case-71', 'enrichOne.CommonEnrichProperty$.fieldsList.a1.toFieldName', 'product_nm', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-tx-case-71', 'enrichOne.CommonEnrichProperty$.fieldsList.a2.fromFieldName', 'product_rate', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-tx-case-71', 'enrichOne.CommonEnrichProperty$.fieldsList.a2.fromFieldType', 'BigDecimal', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-tx-case-71', 'enrichOne.CommonEnrichProperty$.fieldsList.a2.isOptionalEnrichValue', 'true', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-tx-case-71', 'enrichOne.CommonEnrichProperty$.fieldsList.a2.toFieldName', 'product_rate', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-tx-case-71', 'enrichOne.CommonEnrichProperty$.fieldsList.a3.fromFieldName', 'period', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-tx-case-71', 'enrichOne.CommonEnrichProperty$.fieldsList.a3.fromFieldType', 'Int', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-tx-case-71', 'enrichOne.CommonEnrichProperty$.fieldsList.a3.isOptionalEnrichValue', 'true', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-tx-case-71', 'enrichOne.CommonEnrichProperty$.fieldsList.a3.toFieldName', 'period', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-tx-case-71', 'enrichOne.CommonEnrichProperty$.inputDataFormat', 'UaspDtoFormat', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-tx-case-71', 'enrichOne.CommonEnrichProperty$.keySelectorEnrich.isId', 'true', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-tx-case-71', 'enrichOne.CommonEnrichProperty$.keySelectorMain.isId', 'false', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-tx-case-71', 'enrichOne.CommonEnrichProperty$.keySelectorMain.mapKey', 'tcmt_account_num', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-tx-case-71', 'enrichOne.CommonEnrichProperty$.keySelectorMain.mapType', 'String', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-tx-case-71', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.bseamt', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-tx-case-71', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.endbal_prf', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-tx-case-71', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.transaction_amount_prf', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-tx-case-71', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.account_num', 'ru.vtb.uasp.common.mask.fun.AccountMask', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-tx-case-71', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.tcmt', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-tx-case-71', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.tcmt_account_num', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-tx-case-71', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.tso', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-tx-case-71', 'savepoint.pref', 'mdm_enrichment', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-tx-case-71', 'service.serviceName', '${SERVICE_NAME}', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-tx-case-71', 'service.serviceProfile', '${PROFILE_NAME}', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-tx-case-71', 'service.serviceVersion', '${SERVICE_VERSION}', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'prof-tx-case-71', 'sync.parallelism', '${PARALLELISM}', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'rateMutate', 'kafka.producers.filterErrorTag-error.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.amount_sum_cft', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mutator' from dual  union 
select 'rateMutate', 'kafka.producers.filterErrorTag-error.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.base_amount_w4', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mutator' from dual  union 
select 'rateMutate', 'kafka.producers.filterErrorTag-error.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.bseamt', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mutator' from dual  union 
select 'rateMutate', 'kafka.producers.filterErrorTag-error.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.endbal_prf', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mutator' from dual  union 
select 'rateMutate', 'kafka.producers.filterErrorTag-error.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.fee_amount_sum', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mutator' from dual  union 
select 'rateMutate', 'kafka.producers.filterErrorTag-error.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.fee_amount_w4', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mutator' from dual  union 
select 'rateMutate', 'kafka.producers.filterErrorTag-error.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.transaction_amount', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mutator' from dual  union 
select 'rateMutate', 'kafka.producers.filterErrorTag-error.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.transaction_amount_prf', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mutator' from dual  union 
select 'rateMutate', 'kafka.producers.filterErrorTag-error.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.transaction_amount_sum', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mutator' from dual  union 
select 'rateMutate', 'kafka.producers.filterErrorTag-error.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.transaction_amt', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mutator' from dual  union 
select 'rateMutate', 'kafka.producers.filterErrorTag-error.FlinkSinkProperties$.JsMaskedPath$.data.dataString.card_expire_w4', 'ru.vtb.uasp.common.mask.fun.CenterMaskService(1,0)', 'uasp-streaming-mutator' from dual  union 
select 'rateMutate', 'kafka.producers.filterErrorTag-error.FlinkSinkProperties$.JsMaskedPath$.data.dataString.comment', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mutator' from dual  union 
select 'rateMutate', 'kafka.producers.filterErrorTag-error.FlinkSinkProperties$.JsMaskedPath$.data.dataString.contract_num', 'ru.vtb.uasp.common.mask.fun.AccountMask', 'uasp-streaming-mutator' from dual  union 
select 'uz', 'flink.job.service.serviceProfile', '${PROFILE_NAME}', 'uasp-streaming-json-validator' from dual  union 
select 'rateMutate', 'kafka.producers.filterErrorTag-error.FlinkSinkProperties$.JsMaskedPath$.data.dataString.data_operationName', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mutator' from dual  union 
select 'rateMutate', 'kafka.producers.filterErrorTag-error.FlinkSinkProperties$.JsMaskedPath$.data.dataString.replacement_amt', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mutator' from dual  union 
select 'rateMutate', 'kafka.producers.filterErrorTag-error.FlinkSinkProperties$.JsMaskedPath$.data.dataString.source_account_w4', 'ru.vtb.uasp.common.mask.fun.AccountMask', 'uasp-streaming-mutator' from dual  union 
select 'rateMutate', 'kafka.producers.filterErrorTag-error.FlinkSinkProperties$.JsMaskedPath$.data.dataString.tcmt', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mutator' from dual  union 
select 'rateMutate', 'kafka.producers.filterErrorTag-error.FlinkSinkProperties$.JsMaskedPath$.data.dataString.tcmt_account_num', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mutator' from dual  union 
select 'rateMutate', 'kafka.producers.filterErrorTag-error.FlinkSinkProperties$.JsMaskedPath$.data.dataString.tso', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mutator' from dual  union 
select 'rateMutate', 'rulles.drools.list', 'exchange_currency_fields.drl', 'uasp-streaming-mutator' from dual  union 
select 'rateMutate', 'rulles.filter.fieldName', 'sys-BussinesRulles-error', 'uasp-streaming-mutator' from dual  union 
select 'rateMutate', 'rulles.filter.operandClass', 'String', 'uasp-streaming-mutator' from dual  union 
select 'rateMutate', 'rulles.filter.operator', 'null', 'uasp-streaming-mutator' from dual  union 
select 'rateMutate', 'rulles.flink.job.checkpoint.service.serviceName', '${SERVICE_NAME}', 'uasp-streaming-mutator' from dual  union 
select 'rateMutate', 'rulles.flink.job.checkpoint.service.serviceProfile', '${PROFILE_NAME}', 'uasp-streaming-mutator' from dual  union 
select 'rateMutate', 'rulles.flink.job.checkpoint.service.serviceVersion', '${SERVICE_VERSION}', 'uasp-streaming-mutator' from dual  union 
select 'rateMutate', 'rulles.flink.job.checkpoint.sync.parallelism', '${PARALLELISM}', 'uasp-streaming-mutator' from dual  union 
select 'test', 'service.serviceName', '${SERVICE_NAME}', 'uasp-kriaa-bevents-monitor' from dual  union 
select 'test', 'service.serviceProfile', '${PROFILE_NAME}', 'uasp-kriaa-bevents-monitor' from dual  union 
select 'test', 'service.serviceVersion', '${SERVICE_VERSION}', 'uasp-kriaa-bevents-monitor' from dual  union 
select 'test', 'sync.parallelism', '${PARALLELISM}', 'uasp-kriaa-bevents-monitor' from dual  union 
select 'uasp-streaming-rto-15', 'disable.validation', 'false', 'uasp-streaming-rto-15' from dual  union 
select 'uasp-streaming-rto-15', 'flink.job.service.serviceName', '${SERVICE_NAME}', 'uasp-streaming-rto-15' from dual  union 
select 'uasp-streaming-rto-15', 'flink.job.service.serviceProfile', '${PROFILE_NAME}', 'uasp-streaming-rto-15' from dual  union 
select 'uasp-streaming-rto-15', 'flink.job.service.serviceVersion', '${SERVICE_VERSION}', 'uasp-streaming-rto-15' from dual  union 
select 'uasp-streaming-rto-15', 'mask.DESTINATION_ACCOUNT_NUMBER', 'ru.vtb.uasp.common.java.mask.service.fun.AccountMask', 'uasp-streaming-rto-15' from dual  union 
select 'uasp-streaming-rto-15', 'mask.SOURCE_ACCOUNT_NUMBER', 'ru.vtb.uasp.common.java.mask.service.fun.AccountMask', 'uasp-streaming-rto-15' from dual  union 
select 'uasp-streaming-rto-15', 'restart.attempts', '50', 'uasp-streaming-rto-15' from dual  union 
select 'uasp-streaming-rto-15', 'restart.delay', '5000', 'uasp-streaming-rto-15' from dual  union 
select 'uasp-streaming-rto-37', 'flink.job.service.serviceName', '${SERVICE_NAME}', 'uasp-streaming-rto-37' from dual  union 
select 'uasp-streaming-rto-37', 'flink.job.service.serviceProfile', '${PROFILE_NAME}', 'uasp-streaming-rto-37' from dual  union 
select 'uasp-streaming-rto-37', 'flink.job.service.serviceVersion', '${SERVICE_VERSION}', 'uasp-streaming-rto-37' from dual  union 
select 'uasp-streaming-rto-37', 'mask.ACCOUNT_AMOUNT', 'ru.vtb.uasp.common.java.mask.service.fun.AmountMaskingMethod', 'uasp-streaming-rto-37' from dual  union 
select 'uasp-streaming-rto-37', 'mask.ACCOUNT_NUMBER', 'ru.vtb.uasp.common.java.mask.service.fun.FloatLengthCommonMaskService', 'uasp-streaming-rto-37' from dual  union 
select 'uasp-streaming-rto-37', 'restart.attempts', '50', 'uasp-streaming-rto-37' from dual  union 
select 'uasp-streaming-rto-37', 'restart.delay', '5000', 'uasp-streaming-rto-37' from dual  union 
select 'uasp-streaming-rto-attempt-close-part2', 'flink.job.service.serviceName', '${SERVICE_NAME}', 'uasp-streaming-rto-attempt-close-part2' from dual  union 
select 'uasp-streaming-rto-attempt-close-part2', 'flink.job.service.serviceProfile', '${PROFILE_NAME}', 'uasp-streaming-rto-attempt-close-part2' from dual  union 
select 'uasp-streaming-rto-attempt-close-part2', 'flink.job.service.serviceVersion', '${SERVICE_VERSION}', 'uasp-streaming-rto-attempt-close-part2' from dual  union 
select 'uasp-streaming-rto-attempt-close-part2', 'mask.ACCOUNT_AMOUNT', 'ru.vtb.uasp.common.java.mask.service.fun.AmountMaskingMethod', 'uasp-streaming-rto-attempt-close-part2' from dual  union 
select 'uasp-streaming-rto-bcps-card-emission-digital', 'flink.job.service.serviceName', '${SERVICE_NAME}', 'uasp-streaming-rto-bcps-card-emission-digital' from dual  union 
select 'uasp-streaming-rto-bcps-card-emission-digital', 'flink.job.service.serviceProfile', '${PROFILE_NAME}', 'uasp-streaming-rto-bcps-card-emission-digital' from dual  union 
select 'uasp-streaming-rto-bcps-card-emission-digital', 'flink.job.service.serviceVersion', '${SERVICE_VERSION}', 'uasp-streaming-rto-bcps-card-emission-digital' from dual  union 
select 'uasp-streaming-rto-bcps-card-emission-digital', 'portfolio.endpoint', '${PORTFOLIO_REQUEST_SERVICE_URL}', 'uasp-streaming-rto-bcps-card-emission-digital' from dual  union 
select 'uasp-streaming-rto-bcps-card-emission-digital', 'portfolio.ssl.enabled', 'false', 'uasp-streaming-rto-bcps-card-emission-digital' from dual  union 
select 'uasp-streaming-rto-bcps-card-emission-digital', 'portfolio.token.client', '${PORTFOLIO_CLIENT_ID}', 'uasp-streaming-rto-bcps-card-emission-digital' from dual  union 
select 'uasp-streaming-rto-bcps-card-emission-digital', 'portfolio.token.endpoint', '${PORTFOLIO_SECURITY_SERVICE_URL}', 'uasp-streaming-rto-bcps-card-emission-digital' from dual  union 
select 'uasp-streaming-rto-bcps-card-emission-digital', 'portfolio.token.secret', '${PORTFOLIO_CLIENT_SECRET}', 'uasp-streaming-rto-bcps-card-emission-digital' from dual  union 
select 'uasp-streaming-rto-bcps-card-emission-digital', 'portfolio.tyk.key', '${PORTFOLIO_X_TYK_API_KEY}', 'uasp-streaming-rto-bcps-card-emission-digital' from dual  union 
select 'uasp-streaming-rto-bcps-card-emission-digital', 'restart.attempts', '50', 'uasp-streaming-rto-bcps-card-emission-digital' from dual  union 
select 'uasp-streaming-rto-bcps-card-emission-digital', 'restart.delay', '5000', 'uasp-streaming-rto-bcps-card-emission-digital' from dual  union 
select 'uasp-streaming-rto-bcps-card-emission-digital-mock-test', 'flink.job.service.serviceName', '${SERVICE_NAME}', 'uasp-streaming-rto-bcps-card-emission-digital' from dual  union 
select 'uasp-streaming-rto-bcps-card-emission-digital-mock-test', 'flink.job.service.serviceProfile', '${PROFILE_NAME}', 'uasp-streaming-rto-bcps-card-emission-digital' from dual  union 
select 'uasp-streaming-rto-bcps-card-emission-digital-mock-test', 'flink.job.service.serviceVersion', '${SERVICE_VERSION}', 'uasp-streaming-rto-bcps-card-emission-digital' from dual  union 
select 'uasp-streaming-rto-bcps-card-emission-digital-mock-test', 'portfolio.endpoint', 'https://epa-ig-if-lb.test.vtb.ru/api/rb/prp/aggregator/v1/portfolio/active', 'uasp-streaming-rto-bcps-card-emission-digital' from dual  union 
select 'uasp-streaming-rto-bcps-card-emission-digital-mock-test', 'portfolio.ssl.enabled', 'false', 'uasp-streaming-rto-bcps-card-emission-digital' from dual  union 
select 'uasp-streaming-rto-bcps-card-emission-digital-mock-test', 'portfolio.token.client', '***', 'uasp-streaming-rto-bcps-card-emission-digital' from dual  union 
select 'uasp-streaming-rto-bcps-card-emission-digital-mock-test', 'portfolio.token.endpoint', 'https://epa-am-if-lb.test.vtb.ru/passport/oauth2/token', 'uasp-streaming-rto-bcps-card-emission-digital' from dual  union 
select 'uasp-streaming-rto-bcps-card-emission-digital-mock-test', 'portfolio.token.secret', '***', 'uasp-streaming-rto-bcps-card-emission-digital' from dual  union 
select 'uasp-streaming-rto-bcps-card-emission-digital-mock-test', 'portfolio.tyk.key', '***', 'uasp-streaming-rto-bcps-card-emission-digital' from dual  union 
select 'uasp-streaming-rto-bcps-card-emission-digital-mock-test', 'restart.attempts', '50', 'uasp-streaming-rto-bcps-card-emission-digital' from dual  union 
select 'uasp-streaming-rto-bcps-card-emission-digital-mock-test', 'restart.delay', '5000', 'uasp-streaming-rto-bcps-card-emission-digital' from dual  union 
select 'uasp-streaming-rto-bcps-card-emission-digital-mock-test', 'test.run', 'true', 'uasp-streaming-rto-bcps-card-emission-digital' from dual  union 
select 'uasp-streaming-rto-bcps-status-change', 'flink.job.service.serviceName', '${SERVICE_NAME}', 'uasp-streaming-rto-bcps-status-change' from dual  union 
select 'uasp-streaming-rto-bcps-status-change', 'flink.job.service.serviceProfile', '${PROFILE_NAME}', 'uasp-streaming-rto-bcps-status-change' from dual  union 
select 'uasp-streaming-rto-bcps-status-change', 'flink.job.service.serviceVersion', '${SERVICE_VERSION}', 'uasp-streaming-rto-bcps-status-change' from dual  union 
select 'uasp-streaming-rto-bcps-status-change', 'portfolio.endpoint', '${PORTFOLIO_REQUEST_SERVICE_URL}', 'uasp-streaming-rto-bcps-status-change' from dual  union 
select 'uasp-streaming-rto-bcps-status-change', 'portfolio.ssl.enabled', 'false', 'uasp-streaming-rto-bcps-status-change' from dual  union 
select 'uasp-streaming-rto-bcps-status-change', 'portfolio.token.client', '${PORTFOLIO_CLIENT_ID}', 'uasp-streaming-rto-bcps-status-change' from dual  union 
select 'uasp-streaming-rto-bcps-status-change', 'portfolio.token.endpoint', '${PORTFOLIO_SECURITY_SERVICE_URL}', 'uasp-streaming-rto-bcps-status-change' from dual  union 
select 'uasp-streaming-rto-bcps-status-change', 'portfolio.token.secret', '${PORTFOLIO_CLIENT_SECRET}', 'uasp-streaming-rto-bcps-status-change' from dual  union 
select 'uasp-streaming-rto-bcps-status-change', 'portfolio.tyk.key', '${PORTFOLIO_X_TYK_API_KEY}', 'uasp-streaming-rto-bcps-status-change' from dual  union 
select 'uasp-streaming-rto-bcps-status-change', 'restart.attempts', '50', 'uasp-streaming-rto-bcps-status-change' from dual  union 
select 'uasp-streaming-rto-bcps-status-change', 'restart.delay', '5000', 'uasp-streaming-rto-bcps-status-change' from dual  union 
select 'uasp-streaming-rto-bcps-status-change', 'test.run', 'false', 'uasp-streaming-rto-bcps-status-change' from dual  union 
select 'uasp-streaming-rto-bcps-status-change-mock-test', 'flink.job.service.serviceName', '${SERVICE_NAME}', 'uasp-streaming-rto-bcps-status-change' from dual  union 
select 'uasp-streaming-rto-bcps-status-change-mock-test', 'flink.job.service.serviceProfile', '${PROFILE_NAME}', 'uasp-streaming-rto-bcps-status-change' from dual  union 
select 'uasp-streaming-rto-bcps-status-change-mock-test', 'flink.job.service.serviceVersion', '${SERVICE_VERSION}', 'uasp-streaming-rto-bcps-status-change' from dual  union 
select 'uasp-streaming-rto-bcps-status-change-mock-test', 'portfolio.endpoint', 'https://epa-ig-if-lb.test.vtb.ru/api/rb/prp/aggregator/v1/portfolio/active', 'uasp-streaming-rto-bcps-status-change' from dual  union 
select 'uasp-streaming-rto-bcps-status-change-mock-test', 'portfolio.ssl.enabled', 'false', 'uasp-streaming-rto-bcps-status-change' from dual  union 
select 'uasp-streaming-rto-bcps-status-change-mock-test', 'portfolio.token.client', '***', 'uasp-streaming-rto-bcps-status-change' from dual  union 
select 'uasp-streaming-rto-bcps-status-change-mock-test', 'portfolio.token.endpoint', 'https://epa-am-if-lb.test.vtb.ru/passport/oauth2/token', 'uasp-streaming-rto-bcps-status-change' from dual  union 
select 'uasp-streaming-rto-bcps-status-change-mock-test', 'portfolio.token.secret', '***', 'uasp-streaming-rto-bcps-status-change' from dual  union 
select 'uasp-streaming-rto-bcps-status-change-mock-test', 'portfolio.tyk.key', '***', 'uasp-streaming-rto-bcps-status-change' from dual  union 
select 'uasp-streaming-rto-bcps-status-change-mock-test', 'restart.attempts', '50', 'uasp-streaming-rto-bcps-status-change' from dual  union 
select 'uasp-streaming-rto-bcps-status-change-mock-test', 'restart.delay', '5000', 'uasp-streaming-rto-bcps-status-change' from dual  union 
select 'uasp-streaming-rto-bcps-status-change-mock-test', 'test.run', 'true', 'uasp-streaming-rto-bcps-status-change' from dual  union 
select 'uasp-streaming-rto-card-activation-way4', 'flink.job.service.serviceName', '${SERVICE_NAME}', 'uasp-streaming-rto-card-activation-way4' from dual  union 
select 'uasp-streaming-rto-card-activation-way4', 'flink.job.service.serviceProfile', '${PROFILE_NAME}', 'uasp-streaming-rto-card-activation-way4' from dual  union 
select 'uasp-streaming-rto-card-activation-way4', 'flink.job.service.serviceVersion', '${SERVICE_VERSION}', 'uasp-streaming-rto-card-activation-way4' from dual  union 
select 'uasp-streaming-rto-card-activation-way4', 'mask.account.accountNumber', 'ru.vtb.uasp.common.java.mask.service.fun.FloatLengthCommonMaskService', 'uasp-streaming-rto-card-activation-way4' from dual  union 
select 'uasp-streaming-rto-card-activation-way4', 'mask.account.iban', 'ru.vtb.uasp.common.java.mask.service.fun.FloatLengthCommonMaskService', 'uasp-streaming-rto-card-activation-way4' from dual  union 
select 'uasp-streaming-rto-card-activation-way4', 'mask.plastic.expirationDate', 'ru.vtb.uasp.common.java.mask.service.fun.FloatLengthCommonMaskService', 'uasp-streaming-rto-card-activation-way4' from dual  union 
select 'uasp-streaming-rto-card-activation-way4', 'portfolio.endpoint', '${PORTFOLIO_REQUEST_SERVICE_URL}', 'uasp-streaming-rto-card-activation-way4' from dual  union 
select 'uasp-streaming-rto-card-activation-way4', 'portfolio.ssl.enabled', 'false', 'uasp-streaming-rto-card-activation-way4' from dual  union 
select 'uasp-streaming-rto-card-activation-way4', 'portfolio.token.client', '${PORTFOLIO_CLIENT_ID}', 'uasp-streaming-rto-card-activation-way4' from dual  union 
select 'uasp-streaming-rto-card-activation-way4', 'portfolio.token.endpoint', '${PORTFOLIO_SECURITY_SERVICE_URL}', 'uasp-streaming-rto-card-activation-way4' from dual  union 
select 'uasp-streaming-rto-card-activation-way4', 'portfolio.token.secret', '${PORTFOLIO_CLIENT_SECRET}', 'uasp-streaming-rto-card-activation-way4' from dual  union 
select 'uasp-streaming-rto-card-activation-way4', 'portfolio.tyk.key', '${PORTFOLIO_X_TYK_API_KEY}', 'uasp-streaming-rto-card-activation-way4' from dual  union 
select 'uasp-streaming-rto-card-activation-way4', 'restart.attempts', '50', 'uasp-streaming-rto-card-activation-way4' from dual  union 
select 'uasp-streaming-rto-card-activation-way4', 'restart.delay', '5000', 'uasp-streaming-rto-card-activation-way4' from dual  union 
select 'uasp-streaming-rto-card-activation-way4', 'test.run', 'false', 'uasp-streaming-rto-card-activation-way4' from dual  union 
select 'uasp-streaming-rto-card-activation-way4-mock-test', 'flink.job.service.serviceName', '${SERVICE_NAME}', 'uasp-streaming-rto-card-activation-way4' from dual  union 
select 'uasp-streaming-rto-card-activation-way4-mock-test', 'flink.job.service.serviceProfile', '${PROFILE_NAME}', 'uasp-streaming-rto-card-activation-way4' from dual  union 
select 'uasp-streaming-rto-card-activation-way4-mock-test', 'flink.job.service.serviceVersion', '${SERVICE_VERSION}', 'uasp-streaming-rto-card-activation-way4' from dual  union 
select 'uasp-streaming-rto-card-activation-way4-mock-test', 'portfolio.endpoint', 'https://epa-ig-if-lb.test.vtb.ru/api/rb/prp/aggregator/v1/portfolio/active', 'uasp-streaming-rto-card-activation-way4' from dual  union 
select 'uasp-streaming-rto-card-activation-way4-mock-test', 'portfolio.ssl.enabled', 'false', 'uasp-streaming-rto-card-activation-way4' from dual  union 
select 'uasp-streaming-rto-card-activation-way4-mock-test', 'portfolio.token.client', '***', 'uasp-streaming-rto-card-activation-way4' from dual  union 
select 'uasp-streaming-rto-card-activation-way4-mock-test', 'portfolio.token.endpoint', 'https://epa-am-if-lb.test.vtb.ru/passport/oauth2/token', 'uasp-streaming-rto-card-activation-way4' from dual  union 
select 'uasp-streaming-rto-card-activation-way4-mock-test', 'portfolio.token.secret', '***', 'uasp-streaming-rto-card-activation-way4' from dual  union 
select 'uasp-streaming-rto-card-activation-way4-mock-test', 'portfolio.tyk.key', '***', 'uasp-streaming-rto-card-activation-way4' from dual  union 
select 'uasp-streaming-rto-card-activation-way4-mock-test', 'restart.attempts', '50', 'uasp-streaming-rto-card-activation-way4' from dual  union 
select 'uasp-streaming-rto-card-activation-way4-mock-test', 'restart.delay', '5000', 'uasp-streaming-rto-card-activation-way4' from dual  union 
select 'uasp-streaming-rto-card-activation-way4-mock-test', 'test.run', 'true', 'uasp-streaming-rto-card-activation-way4' from dual  union 
select 'uasp-streaming-rto-closing-deposit', 'flink.job.service.serviceName', '${SERVICE_NAME}', 'uasp-streaming-rto-closing-deposit' from dual  union 
select 'uasp-streaming-rto-closing-deposit', 'flink.job.service.serviceProfile', '${PROFILE_NAME}', 'uasp-streaming-rto-closing-deposit' from dual  union 
select 'uasp-streaming-rto-closing-deposit', 'flink.job.service.serviceVersion', '${SERVICE_VERSION}', 'uasp-streaming-rto-closing-deposit' from dual  union 
select 'uasp-streaming-rto-closing-deposit', 'mask.balance.amount', 'ru.vtb.uasp.common.java.mask.service.fun.AmountMaskingMethod', 'uasp-streaming-rto-closing-deposit' from dual  union 
select 'uasp-streaming-rto-dko-4_62', 'flink.job.service.serviceName', '${SERVICE_NAME}', 'uasp-streaming-rto-dko-4_62' from dual  union 
select 'uasp-streaming-rto-dko-4_62', 'flink.job.service.serviceProfile', '${PROFILE_NAME}', 'uasp-streaming-rto-dko-4_62' from dual  union 
select 'uasp-streaming-rto-dko-4_62', 'flink.job.service.serviceVersion', '${SERVICE_VERSION}', 'uasp-streaming-rto-dko-4_62' from dual  union 
select 'uasp-streaming-rto-mortgage-approval-prod', 'flink.job.service.serviceName', '${SERVICE_NAME}', 'uasp-streaming-rto-mortgage-approval' from dual  union 
select 'uasp-streaming-rto-mortgage-approval-prod', 'flink.job.service.serviceProfile', '${PROFILE_NAME}', 'uasp-streaming-rto-mortgage-approval' from dual  union 
select 'uasp-streaming-rto-mortgage-approval-prod', 'flink.job.service.serviceVersion', '${SERVICE_VERSION}', 'uasp-streaming-rto-mortgage-approval' from dual  union 
select 'uasp-streaming-rto-mortgage-approval-prod', 'mask.initialPaymentAmount', 'ru.vtb.uasp.common.java.mask.service.fun.AmountMaskingMethod', 'uasp-streaming-rto-mortgage-approval' from dual  union 
select 'uasp-streaming-rto-mortgage-approval-prod', 'mask.mortgageAmount', 'ru.vtb.uasp.common.java.mask.service.fun.AmountMaskingMethod', 'uasp-streaming-rto-mortgage-approval' from dual  union 
select 'uasp-streaming-rto-ofvs', 'flink.job.service.serviceName', '${SERVICE_NAME}', 'uasp-streaming-rto-ofvs' from dual  union 
select 'uasp-streaming-rto-ofvs', 'flink.job.service.serviceProfile', '${PROFILE_NAME}', 'uasp-streaming-rto-ofvs' from dual  union 
select 'uasp-streaming-rto-ofvs', 'flink.job.service.serviceVersion', '${SERVICE_VERSION}', 'uasp-streaming-rto-ofvs' from dual  union 
select 'uasp-streaming-rto-open-deposit', 'flink.job.service.serviceName', '${SERVICE_NAME}', 'uasp-streaming-rto-open-deposit' from dual  union 
select 'uasp-streaming-rto-open-deposit', 'flink.job.service.serviceProfile', '${PROFILE_NAME}', 'uasp-streaming-rto-open-deposit' from dual  union 
select 'uasp-streaming-rto-open-deposit', 'flink.job.service.serviceVersion', '${SERVICE_VERSION}', 'uasp-streaming-rto-open-deposit' from dual  union 
select 'uasp-streaming-rto-open-deposit', 'mask.balance', 'ru.vtb.uasp.common.java.mask.service.fun.AmountMaskingMethod', 'uasp-streaming-rto-open-deposit' from dual  union 
select 'uasp-streaming-rto-status-execution-goal', 'flink.job.service.serviceName', '${SERVICE_NAME}', 'uasp-streaming-rto-status-execution-goal' from dual  union 
select 'uasp-streaming-rto-status-execution-goal', 'flink.job.service.serviceProfile', '${PROFILE_NAME}', 'uasp-streaming-rto-status-execution-goal' from dual  union 
select 'uasp-streaming-rto-status-execution-goal', 'flink.job.service.serviceVersion', '${SERVICE_VERSION}', 'uasp-streaming-rto-status-execution-goal' from dual  union 
select 'uasp-streaming-rto-status-execution-goal', 'mask.GOAL_ACCOUNT_AMOUNT', 'ru.vtb.uasp.common.java.mask.service.fun.AmountMaskingMethod', 'uasp-streaming-rto-status-execution-goal' from dual  union 
select 'uasp-streaming-rto-status-execution-goal', 'mask.GOAL_ACCOUNT_NUMBER', 'ru.vtb.uasp.common.java.mask.service.fun.FloatLengthCommonMaskService', 'uasp-streaming-rto-status-execution-goal' from dual  union 
select 'uasp-streaming-rto-status-execution-goal', 'mask.GOAL_AMOUNT', 'ru.vtb.uasp.common.java.mask.service.fun.AmountMaskingMethod', 'uasp-streaming-rto-status-execution-goal' from dual  union 
select 'uasp-streaming-rto-status-execution-goal', 'restart.attempts', '50', 'uasp-streaming-rto-status-execution-goal' from dual  union 
select 'uasp-streaming-rto-status-execution-goal', 'restart.delay', '5000', 'uasp-streaming-rto-status-execution-goal' from dual  union 
select 'uasp-streaming-rto-zoc', 'flink.job.service.serviceName', '${SERVICE_NAME}', 'uasp-streaming-rto-zoc' from dual  union 
select 'uasp-streaming-rto-zoc', 'flink.job.service.serviceProfile', '${PROFILE_NAME}', 'uasp-streaming-rto-zoc' from dual  union 
select 'uasp-streaming-rto-zoc', 'flink.job.service.serviceVersion', '${SERVICE_VERSION}', 'uasp-streaming-rto-zoc' from dual  union 
select 'uasp-streaming-rto-zoc', 'mask.sub', 'ru.vtb.uasp.common.java.mask.service.fun.EmployeeLoginService', 'uasp-streaming-rto-zoc' from dual  union 
select 'udds-3to8', 'max.parallelism', '4', 'uasp-streaming-unp-convertor' from dual  union 
select 'udds-3to8', 'service.serviceName', '${SERVICE_NAME}', 'uasp-streaming-unp-convertor' from dual  union 
select 'udds-3to8', 'service.serviceProfile', '${PROFILE_NAME}', 'uasp-streaming-unp-convertor' from dual  union 
select 'udds-3to8', 'service.serviceVersion', '${SERVICE_VERSION}', 'uasp-streaming-unp-convertor' from dual  union 
select 'udds-3to8', 'sink.parallelism', '1', 'uasp-streaming-unp-convertor' from dual  union 
select 'udds-3to8', 'source.parallelism', '3', 'uasp-streaming-unp-convertor' from dual  union 
select 'uddsRate', 'kafka.producers.filterErrorTag-error.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.endbal_prf', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mutator' from dual  union 
select 'uddsRate', 'kafka.producers.filterErrorTag-error.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.operationAmount', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mutator' from dual  union 
select 'uddsRate', 'rulles.drools.list', 'currency-rate-for-uddt.drl', 'uasp-streaming-mutator' from dual  union 
select 'uddsRate', 'rulles.filter.fieldName', 'sys-BussinesRulles-error', 'uasp-streaming-mutator' from dual  union 
select 'uddsRate', 'rulles.filter.operandClass', 'String', 'uasp-streaming-mutator' from dual  union 
select 'uddsRate', 'rulles.filter.operator', 'null', 'uasp-streaming-mutator' from dual  union 
select 'uddsRate', 'rulles.flink.job.checkpoint.service.serviceName', '${SERVICE_NAME}', 'uasp-streaming-mutator' from dual  union 
select 'uddsRate', 'rulles.flink.job.checkpoint.service.serviceProfile', '${PROFILE_NAME}', 'uasp-streaming-mutator' from dual  union 
select 'uddsRate', 'rulles.flink.job.checkpoint.service.serviceVersion', '${SERVICE_VERSION}', 'uasp-streaming-mutator' from dual  union 
select 'uddsRate', 'rulles.flink.job.checkpoint.sync.parallelism', '${PARALLELISM}', 'uasp-streaming-mutator' from dual  union 
select 'unp_w4_issuing_card', 'max.parallelism', '8', 'uasp-streaming-unp-convertor' from dual  union 
select 'unp_w4_issuing_card', 'service.serviceName', '${SERVICE_NAME}', 'uasp-streaming-unp-convertor' from dual  union 
select 'unp_w4_issuing_card', 'service.serviceProfile', '${PROFILE_NAME}', 'uasp-streaming-unp-convertor' from dual  union 
select 'unp_w4_issuing_card', 'service.serviceVersion', '${SERVICE_VERSION}', 'uasp-streaming-unp-convertor' from dual  union 
select 'uz', 'flink.job.service.serviceVersion', '${SERVICE_VERSION}', 'uasp-streaming-json-validator' from dual  union 
select 'uz', 'validation.schema.name', 'uz-schema.json', 'uasp-streaming-json-validator' from dual  union 
select 'w4-account-balance', 'max.parallelism', '8', 'uasp-streaming-unp-convertor' from dual  union 
select 'w4-account-balance', 'service.serviceName', '${SERVICE_NAME}', 'uasp-streaming-unp-convertor' from dual  union 
select 'w4-account-balance', 'service.serviceProfile', '${PROFILE_NAME}', 'uasp-streaming-unp-convertor' from dual  union 
select 'w4-account-balance', 'service.serviceVersion', '${SERVICE_VERSION}', 'uasp-streaming-unp-convertor' from dual  union 
select 'w4-account-balance', 'sink.parallelism', '8', 'uasp-streaming-unp-convertor' from dual  union 
select 'w4-account-balance', 'source.parallelism', '8', 'uasp-streaming-unp-convertor' from dual  union 
select 'way4', 'enrichOne.CommonEnrichProperty$.fieldsList.a1.fromFieldName', 'is_mortgage', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4', 'enrichOne.CommonEnrichProperty$.fieldsList.a1.fromFieldType', 'Boolean', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4', 'enrichOne.CommonEnrichProperty$.fieldsList.a1.isOptionalEnrichValue', 'true', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4', 'enrichOne.CommonEnrichProperty$.fieldsList.a1.toFieldName', 'is_mortgage', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4', 'enrichOne.CommonEnrichProperty$.inputDataFormat', 'UaspDtoFormat', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4', 'enrichOne.CommonEnrichProperty$.keySelectorEnrich.isId', 'true', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4', 'enrichOne.CommonEnrichProperty$.keySelectorMain.isId', 'true', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4', 'enrichOne.GlobalIdEnrichProperty$.globalEnrichFields.fromFieldName', 'global_id', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4', 'enrichOne.GlobalIdEnrichProperty$.globalEnrichFields.fromFieldType', 'String', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4', 'enrichOne.GlobalIdEnrichProperty$.globalEnrichFields.isOptionalEnrichValue', 'false', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4', 'enrichOne.GlobalIdEnrichProperty$.globalEnrichFields.toFieldName', 'calculate-mdm_id', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4', 'enrichOne.GlobalIdEnrichProperty$.inputDataFormat', 'UaspDtoFormat', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4', 'enrichOne.GlobalIdEnrichProperty$.isDeletedFieldPath', 'is_deleted', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4', 'enrichOne.GlobalIdEnrichProperty$.keySelectorEnrich.isId', 'true', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4', 'enrichOne.GlobalIdEnrichProperty$.keySelectorMain.isId', 'true', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.base_amount_w4', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.fee_amount_w4', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.transaction_amount', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.card_expire_w4', 'ru.vtb.uasp.common.mask.fun.CenterMaskService(1,0)', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.comment', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.source_account_w4', 'ru.vtb.uasp.common.mask.fun.AccountMask', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4', 'savepoint.pref', 'mdm_enrichment', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4', 'service.serviceName', '${SERVICE_NAME}', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4', 'service.serviceProfile', '${PROFILE_NAME}', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4', 'service.serviceVersion', '${SERVICE_VERSION}', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4', 'sync.parallelism', '${PARALLELISM}', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4-card-agreement', 'enrichOne.CommonEnrichProperty$.fieldsList.a01.fromFieldName', 'mask_card_number', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4-card-agreement', 'enrichOne.CommonEnrichProperty$.fieldsList.a01.fromFieldType', 'String', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4-card-agreement', 'enrichOne.CommonEnrichProperty$.fieldsList.a01.isOptionalEnrichValue', 'true', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4-card-agreement', 'enrichOne.CommonEnrichProperty$.fieldsList.a01.toFieldName', 'MASK_CARD_NUMBER', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4-card-agreement', 'enrichOne.CommonEnrichProperty$.fieldsList.a02.fromFieldName', 'customer_id', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4-card-agreement', 'enrichOne.CommonEnrichProperty$.fieldsList.a02.fromFieldType', 'String', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4-card-agreement', 'enrichOne.CommonEnrichProperty$.fieldsList.a02.isOptionalEnrichValue', 'true', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4-card-agreement', 'enrichOne.CommonEnrichProperty$.fieldsList.a02.toFieldName', 'customer_id', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4-card-agreement', 'enrichOne.CommonEnrichProperty$.fieldsList.a03.fromFieldName', 'source_system_cd', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4-card-agreement', 'enrichOne.CommonEnrichProperty$.fieldsList.a03.fromFieldType', 'String', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4-card-agreement', 'enrichOne.CommonEnrichProperty$.fieldsList.a03.isOptionalEnrichValue', 'true', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4-card-agreement', 'enrichOne.CommonEnrichProperty$.fieldsList.a03.toFieldName', 'source_system_cd', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4-card-agreement', 'enrichOne.CommonEnrichProperty$.fieldsList.a04.fromFieldName', 'pos_flg', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4-card-agreement', 'enrichOne.CommonEnrichProperty$.fieldsList.a04.fromFieldType', 'String', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4-card-agreement', 'enrichOne.CommonEnrichProperty$.fieldsList.a04.isOptionalEnrichValue', 'true', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4-card-agreement', 'enrichOne.CommonEnrichProperty$.fieldsList.a04.toFieldName', 'pos_flg', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4-card-agreement', 'enrichOne.CommonEnrichProperty$.fieldsList.a05.fromFieldName', 'account_num', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4-card-agreement', 'enrichOne.CommonEnrichProperty$.fieldsList.a05.fromFieldType', 'String', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4-card-agreement', 'enrichOne.CommonEnrichProperty$.fieldsList.a05.isOptionalEnrichValue', 'true', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4-card-agreement', 'enrichOne.CommonEnrichProperty$.fieldsList.a05.toFieldName', 'account_num', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4-card-agreement', 'enrichOne.CommonEnrichProperty$.fieldsList.a06.fromFieldName', 'is_virtual_card_flg', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4-card-agreement', 'enrichOne.CommonEnrichProperty$.fieldsList.a06.fromFieldType', 'String', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4-card-agreement', 'enrichOne.CommonEnrichProperty$.fieldsList.a06.isOptionalEnrichValue', 'true', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4-card-agreement', 'enrichOne.CommonEnrichProperty$.fieldsList.a06.toFieldName', 'is_virtual_card_flg', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4-card-agreement', 'enrichOne.CommonEnrichProperty$.fieldsList.a07.fromFieldName', 'card_expiration_dt', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4-card-agreement', 'enrichOne.CommonEnrichProperty$.fieldsList.a07.fromFieldType', 'String', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4-card-agreement', 'enrichOne.CommonEnrichProperty$.fieldsList.a07.isOptionalEnrichValue', 'true', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4-card-agreement', 'enrichOne.CommonEnrichProperty$.fieldsList.a07.toFieldName', 'card_expiration_dt', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4-card-agreement', 'enrichOne.CommonEnrichProperty$.fieldsList.a08.fromFieldName', 'payment_system_desc', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4-card-agreement', 'enrichOne.CommonEnrichProperty$.fieldsList.a08.fromFieldType', 'String', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4-card-agreement', 'enrichOne.CommonEnrichProperty$.fieldsList.a08.isOptionalEnrichValue', 'true', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4-card-agreement', 'enrichOne.CommonEnrichProperty$.fieldsList.a08.toFieldName', 'payment_system_desc', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4-card-agreement', 'enrichOne.CommonEnrichProperty$.fieldsList.a09.fromFieldName', 'card_type_cd', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4-card-agreement', 'enrichOne.CommonEnrichProperty$.fieldsList.a09.fromFieldType', 'String', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4-card-agreement', 'enrichOne.CommonEnrichProperty$.fieldsList.a09.isOptionalEnrichValue', 'true', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4-card-agreement', 'enrichOne.CommonEnrichProperty$.fieldsList.a09.toFieldName', 'card_type_cd', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4-card-agreement', 'enrichOne.CommonEnrichProperty$.fieldsList.a10.fromFieldName', 'salary_serv_pack_flg', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4-card-agreement', 'enrichOne.CommonEnrichProperty$.fieldsList.a10.fromFieldType', 'String', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4-card-agreement', 'enrichOne.CommonEnrichProperty$.fieldsList.a10.isOptionalEnrichValue', 'true', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4-card-agreement', 'enrichOne.CommonEnrichProperty$.fieldsList.a10.toFieldName', 'salary_serv_pack_flg', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4-card-agreement', 'enrichOne.CommonEnrichProperty$.fieldsList.a11.fromFieldName', 'salary_project_flg', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4-card-agreement', 'enrichOne.CommonEnrichProperty$.fieldsList.a11.fromFieldType', 'String', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4-card-agreement', 'enrichOne.CommonEnrichProperty$.fieldsList.a11.isOptionalEnrichValue', 'true', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4-card-agreement', 'enrichOne.CommonEnrichProperty$.fieldsList.a11.toFieldName', 'salary_project_flg', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4-card-agreement', 'enrichOne.CommonEnrichProperty$.fieldsList.a12.fromFieldName', 'salary_account_scheme_flg', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4-card-agreement', 'enrichOne.CommonEnrichProperty$.fieldsList.a12.fromFieldType', 'String', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4-card-agreement', 'enrichOne.CommonEnrichProperty$.fieldsList.a12.isOptionalEnrichValue', 'true', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4-card-agreement', 'enrichOne.CommonEnrichProperty$.fieldsList.a12.toFieldName', 'salary_account_scheme_flg', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4-card-agreement', 'enrichOne.CommonEnrichProperty$.fieldsList.a13.fromFieldName', 'salary_card_type_flg', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4-card-agreement', 'enrichOne.CommonEnrichProperty$.fieldsList.a13.fromFieldType', 'String', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4-card-agreement', 'enrichOne.CommonEnrichProperty$.fieldsList.a13.isOptionalEnrichValue', 'true', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4-card-agreement', 'enrichOne.CommonEnrichProperty$.fieldsList.a13.toFieldName', 'salary_card_type_flg', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4-card-agreement', 'enrichOne.CommonEnrichProperty$.fieldsList.a14.fromFieldName', 'contract_card_type_cd', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4-card-agreement', 'enrichOne.CommonEnrichProperty$.fieldsList.a14.fromFieldType', 'String', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4-card-agreement', 'enrichOne.CommonEnrichProperty$.fieldsList.a14.isOptionalEnrichValue', 'true', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4-card-agreement', 'enrichOne.CommonEnrichProperty$.fieldsList.a14.toFieldName', 'contract_card_type_cd', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4-card-agreement', 'enrichOne.CommonEnrichProperty$.fieldsList.a15.fromFieldName', 'hash_card_number', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4-card-agreement', 'enrichOne.CommonEnrichProperty$.fieldsList.a15.fromFieldType', 'String', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4-card-agreement', 'enrichOne.CommonEnrichProperty$.fieldsList.a15.isOptionalEnrichValue', 'true', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4-card-agreement', 'enrichOne.CommonEnrichProperty$.fieldsList.a15.toFieldName', 'hash_card_number', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4-card-agreement', 'enrichOne.CommonEnrichProperty$.inputDataFormat', 'UaspDtoFormat', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4-card-agreement', 'enrichOne.CommonEnrichProperty$.isDeletedFieldPath', 'is_deleted', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4-card-agreement', 'enrichOne.CommonEnrichProperty$.keySelectorEnrich.isId', 'false', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4-card-agreement', 'enrichOne.CommonEnrichProperty$.keySelectorEnrich.mapKey', 'customer_id_and_masked_card_number', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4-card-agreement', 'enrichOne.CommonEnrichProperty$.keySelectorEnrich.mapType', 'String', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4-card-agreement', 'enrichOne.CommonEnrichProperty$.keySelectorMain.isId', 'false', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4-card-agreement', 'enrichOne.CommonEnrichProperty$.keySelectorMain.mapKey', 'customer_id_and_masked_card_number', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4-card-agreement', 'enrichOne.CommonEnrichProperty$.keySelectorMain.mapType', 'String', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4-card-agreement', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.base_amount_w4', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4-card-agreement', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.fee_amount_w4', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4-card-agreement', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataDecimal.transaction_amount', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4-card-agreement', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.card_expire_w4', 'ru.vtb.uasp.common.mask.fun.CenterMaskService(1,0)', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4-card-agreement', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.comment', 'ru.vtb.uasp.common.mask.fun.FloatLengthCommonMaskService', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4-card-agreement', 'enrichOne.MainEnrichProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.source_account_w4', 'ru.vtb.uasp.common.mask.fun.AccountMask', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4-card-agreement', 'savepoint.pref', 'mdm_enrichment', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4-card-agreement', 'service.serviceName', '${SERVICE_NAME}', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4-card-agreement', 'service.serviceProfile', '${PROFILE_NAME}', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4-card-agreement', 'service.serviceVersion', '${SERVICE_VERSION}', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4-card-agreement', 'sync.parallelism', '${PARALLELISM}', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'way4-main', 'max.parallelism', '8', 'uasp-streaming-unp-convertor' from dual  union 
select 'way4-main', 'service.serviceName', '${SERVICE_NAME}', 'uasp-streaming-unp-convertor' from dual  union 
select 'way4-main', 'service.serviceProfile', '${PROFILE_NAME}', 'uasp-streaming-unp-convertor' from dual  union 
select 'way4-main', 'service.serviceVersion', '${SERVICE_VERSION}', 'uasp-streaming-unp-convertor' from dual  union 
select 'way4-main', 'sink.parallelism', '8', 'uasp-streaming-unp-convertor' from dual  union 
select 'way4-main', 'source.parallelism', '8', 'uasp-streaming-unp-convertor' from dual  union 
select 'way4_new', 'appSyncParallelism', '1', 'uasp_dko_83088_way4_mdm_enrich' from dual  union 
select 'way4_new', 'enrichMdm.MainOperationProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.account.accountNumber', 'ru.vtb.uasp.common.mask.fun.AccountMask', 'uasp_dko_83088_way4_mdm_enrich' from dual  union 
select 'way4_new', 'enrichMdm.MainOperationProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.accountNumber', 'ru.vtb.uasp.common.mask.fun.AccountMask', 'uasp_dko_83088_way4_mdm_enrich' from dual  union 
select 'way4_new', 'enrichMdm.MainOperationProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.card.externalId', 'ru.vtb.uasp.common.mask.fun.AccountMask', 'uasp_dko_83088_way4_mdm_enrich' from dual  union 
select 'way4_new', 'enrichMdm.MainOperationProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.comment', 'ru.vtb.uasp.common.mask.fun.StringMaskAll', 'uasp_dko_83088_way4_mdm_enrich' from dual  union 
select 'way4_new', 'service.serviceName', '${SERVICE_NAME}', 'uasp_dko_83088_way4_mdm_enrich' from dual  union 
select 'way4_new', 'service.serviceProfile', '${PROFILE_NAME}', 'uasp_dko_83088_way4_mdm_enrich' from dual  union 
select 'way4_new', 'service.serviceVersion', '${SERVICE_VERSION}', 'uasp_dko_83088_way4_mdm_enrich' from dual  union 
select 'way4_new_stream', 'appSyncParallelism', '1', 'uasp_dko_83088_way4_mdm_enrich_2150' from dual  union 
select 'way4_new_stream', 'enrichMdm.MainOperationProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.account.accountNumber', 'ru.vtb.uasp.common.mask.fun.AccountMask', 'uasp_dko_83088_way4_mdm_enrich_2150' from dual  union 
select 'way4_new_stream', 'enrichMdm.MainOperationProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.accountNumber', 'ru.vtb.uasp.common.mask.fun.AccountMask', 'uasp_dko_83088_way4_mdm_enrich_2150' from dual  union 
select 'way4_new_stream', 'enrichMdm.MainOperationProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.card.externalId', 'ru.vtb.uasp.common.mask.fun.AccountMask', 'uasp_dko_83088_way4_mdm_enrich_2150' from dual  union 
select 'way4_new_stream', 'enrichMdm.MainOperationProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.comment', 'ru.vtb.uasp.common.mask.fun.StringMaskAll', 'uasp_dko_83088_way4_mdm_enrich_2150' from dual  union 
select 'way4_new_stream', 'service.serviceName', '${SERVICE_NAME}', 'uasp_dko_83088_way4_mdm_enrich_2150' from dual  union 
select 'way4_new_stream', 'service.serviceProfile', '${PROFILE_NAME}', 'uasp_dko_83088_way4_mdm_enrich_2150' from dual  union 
select 'way4_new_stream', 'service.serviceVersion', '${SERVICE_VERSION}', 'uasp_dko_83088_way4_mdm_enrich_2150' from dual  union 
select 'way4_old_stream', 'appSyncParallelism', '1', 'uasp_dko_83088_way4_mdm_enrich' from dual  union 
select 'way4_old_stream', 'appSyncParallelism', '1', 'uasp_dko_83088_way4_mdm_enrich_2150' from dual  union 
select 'way4_old_stream', 'enrichMdm.MainOperationProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.account.accountNumber', 'ru.vtb.uasp.common.mask.fun.AccountMask', 'uasp_dko_83088_way4_mdm_enrich' from dual  union 
select 'way4_old_stream', 'enrichMdm.MainOperationProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.account.accountNumber', 'ru.vtb.uasp.common.mask.fun.AccountMask', 'uasp_dko_83088_way4_mdm_enrich_2150' from dual  union 
select 'way4_old_stream', 'enrichMdm.MainOperationProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.accountNumber', 'ru.vtb.uasp.common.mask.fun.AccountMask', 'uasp_dko_83088_way4_mdm_enrich' from dual  union 
select 'way4_old_stream', 'enrichMdm.MainOperationProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.accountNumber', 'ru.vtb.uasp.common.mask.fun.AccountMask', 'uasp_dko_83088_way4_mdm_enrich_2150' from dual  union 
select 'way4_old_stream', 'enrichMdm.MainOperationProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.card.externalId', 'ru.vtb.uasp.common.mask.fun.AccountMask', 'uasp_dko_83088_way4_mdm_enrich' from dual  union 
select 'way4_old_stream', 'enrichMdm.MainOperationProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.card.externalId', 'ru.vtb.uasp.common.mask.fun.AccountMask', 'uasp_dko_83088_way4_mdm_enrich_2150' from dual  union 
select 'way4_old_stream', 'enrichMdm.MainOperationProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.comment', 'ru.vtb.uasp.common.mask.fun.StringMaskAll', 'uasp_dko_83088_way4_mdm_enrich' from dual  union 
select 'way4_old_stream', 'enrichMdm.MainOperationProperty$.dlq.FlinkSinkProperties$.JsMaskedPath$.data.dataString.comment', 'ru.vtb.uasp.common.mask.fun.StringMaskAll', 'uasp_dko_83088_way4_mdm_enrich_2150' from dual  union 
select 'way4_old_stream', 'service.serviceName', '${SERVICE_NAME}', 'uasp_dko_83088_way4_mdm_enrich' from dual  union 
select 'way4_old_stream', 'service.serviceName', '${SERVICE_NAME}', 'uasp_dko_83088_way4_mdm_enrich_2150' from dual  union 
select 'way4_old_stream', 'service.serviceProfile', '${PROFILE_NAME}', 'uasp_dko_83088_way4_mdm_enrich' from dual  union 
select 'way4_old_stream', 'service.serviceProfile', '${PROFILE_NAME}', 'uasp_dko_83088_way4_mdm_enrich_2150' from dual  union 
select 'way4_old_stream', 'service.serviceVersion', '${SERVICE_VERSION}', 'uasp_dko_83088_way4_mdm_enrich' from dual  union 
select 'way4_old_stream', 'service.serviceVersion', '${SERVICE_VERSION}', 'uasp_dko_83088_way4_mdm_enrich_2150' from dual  union 
select 'way4-transactions', 'max.parallelism', '8', 'uasp-streaming-unp-convertor' from dual  union 
select 'way4-transactions', 'service.serviceName', '${SERVICE_NAME}', 'uasp-streaming-unp-convertor' from dual  union 
select 'way4-transactions', 'service.serviceProfile', '${PROFILE_NAME}', 'uasp-streaming-unp-convertor' from dual  union 
select 'way4-transactions', 'service.serviceVersion', '${SERVICE_VERSION}', 'uasp-streaming-unp-convertor' from dual  union 
select 'way4-transactions', 'sink.parallelism', '8', 'uasp-streaming-unp-convertor' from dual  union 
select 'way4-transactions', 'source.parallelism', '8', 'uasp-streaming-unp-convertor' from dual  union 
select 'withdraw-transactions', 'max.parallelism', '8', 'uasp-streaming-unp-convertor' from dual  union 
select 'withdraw-transactions', 'service.serviceName', '${SERVICE_NAME}', 'uasp-streaming-unp-convertor' from dual  union 
select 'withdraw-transactions', 'service.serviceProfile', '${PROFILE_NAME}', 'uasp-streaming-unp-convertor' from dual  union 
select 'withdraw-transactions', 'service.serviceVersion', '${SERVICE_VERSION}', 'uasp-streaming-unp-convertor' from dual  union 
select 'withdraw-transactions', 'sink.parallelism', '8', 'uasp-streaming-unp-convertor' from dual  union 
select 'withdraw-transactions', 'source.parallelism', '8', 'uasp-streaming-unp-convertor' from dual ;

insert into dict_kafka_prop_value_by_stand(grp_id, prop_id, prop_value, stand_id, type_prop) 
select 'earliest', 'bootstrap.servers', 'kafka-1:29092,kafka-2:39092,kafka-3:49092', 'NOTEBOOK', 'cns' from dual  union 
select 'earliest', 'security.protocol', 'PLAINTEXT', 'NOTEBOOK', 'cns' from dual  union 
select 'earliest', 'ssl.key.password', '${DSO_KAFKA_SSL_KEY_PASSWORD}', 'DSO', 'cns' from dual  union 
select 'earliest', 'ssl.key.password', '${IFT_KAFKA_SSL_KEY_PASSWORD}', 'IFT', 'cns' from dual  union 
select 'earliest', 'ssl.key.password', '${NT_KAFKA_SSL_KEY_PASSWORD}', 'NT', 'cns' from dual  union 
select 'earliest', 'ssl.key.password', '${P0_KAFKA_SSL_KEY_PASSWORD}', 'P0', 'cns' from dual  union 
select 'earliest', 'ssl.key.password', '${REAL_KAFKA_SSL_KEY_PASSWORD}', 'REAL', 'cns' from dual  union 
select 'earliest', 'ssl.key.password', 'kafkauasppassword', 'NOTEBOOK', 'cns' from dual  union 
select 'earliest', 'ssl.keystore.location', 'C:\\Work\\secret\\kafka-trust.pfx', 'NOTEBOOK', 'cns' from dual  union 
select 'earliest', 'ssl.keystore.password', '${DSO_KAFKA_SSL_KEYSTORE_PASSWORD}', 'DSO', 'cns' from dual  union 
select 'earliest', 'ssl.keystore.password', '${IFT_KAFKA_SSL_KEYSTORE_PASSWORD}', 'IFT', 'cns' from dual  union 
select 'earliest', 'ssl.keystore.password', '${NT_KAFKA_SSL_KEYSTORE_PASSWORD}', 'NT', 'cns' from dual  union 
select 'earliest', 'ssl.keystore.password', '${P0_KAFKA_SSL_KEYSTORE_PASSWORD}', 'P0', 'cns' from dual  union 
select 'earliest', 'ssl.keystore.password', '${REAL_KAFKA_SSL_KEYSTORE_PASSWORD}', 'REAL', 'cns' from dual  union 
select 'earliest', 'ssl.keystore.password', 'kafkauasppassword', 'NOTEBOOK', 'cns' from dual  union 
select 'earliest', 'ssl.truststore.location', 'C:\\Work\\secret\\APD00.13.01-USBP-kafka-cluster-uasp.pfx', 'NOTEBOOK', 'cns' from dual  union 
select 'earliest', 'ssl.truststore.password', '${DSO_KAFKA_SSL_TRUSTSTORE_PASSWORD}', 'DSO', 'cns' from dual  union 
select 'earliest', 'ssl.truststore.password', '${IFT_KAFKA_SSL_TRUSTSTORE_PASSWORD}', 'IFT', 'cns' from dual  union 
select 'earliest', 'ssl.truststore.password', '${NT_KAFKA_SSL_TRUSTSTORE_PASSWORD}', 'NT', 'cns' from dual  union 
select 'earliest', 'ssl.truststore.password', '${P0_KAFKA_SSL_TRUSTSTORE_PASSWORD}', 'P0', 'cns' from dual  union 
select 'earliest', 'ssl.truststore.password', '${REAL_KAFKA_SSL_TRUSTSTORE_PASSWORD}', 'REAL', 'cns' from dual  union 
select 'earliest', 'ssl.truststore.password', 'kafkauasppassword', 'NOTEBOOK', 'cns' from dual  union 
select 'earliest_CARDFL_BOOTSTRAP_SERVERS', 'bootstrap.servers', 'kafka-1:29092,kafka-2:39092,kafka-3:49092', 'NOTEBOOK', 'cns' from dual  union 
select 'earliest_CARDFL_BOOTSTRAP_SERVERS', 'security.protocol', 'PLAINTEXT', 'NOTEBOOK', 'cns' from dual  union 
select 'earliest_CARDFL_BOOTSTRAP_SERVERS', 'ssl.key.password', '${DSO_KAFKA_SSL_KEY_PASSWORD}', 'DSO', 'cns' from dual  union 
select 'earliest_CARDFL_BOOTSTRAP_SERVERS', 'ssl.key.password', '${IFT_KAFKA_SSL_KEY_PASSWORD}', 'IFT', 'cns' from dual  union 
select 'earliest_CARDFL_BOOTSTRAP_SERVERS', 'ssl.key.password', '${NT_KAFKA_SSL_KEY_PASSWORD}', 'NT', 'cns' from dual  union 
select 'earliest_CARDFL_BOOTSTRAP_SERVERS', 'ssl.key.password', '${P0_KAFKA_SSL_KEY_PASSWORD}', 'P0', 'cns' from dual  union 
select 'earliest_CARDFL_BOOTSTRAP_SERVERS', 'ssl.key.password', '${REAL_KAFKA_SSL_KEY_PASSWORD}', 'REAL', 'cns' from dual  union 
select 'earliest_CARDFL_BOOTSTRAP_SERVERS', 'ssl.key.password', 'kafkauasppassword', 'NOTEBOOK', 'cns' from dual  union 
select 'earliest_CARDFL_BOOTSTRAP_SERVERS', 'ssl.keystore.location', 'C:\\Work\\secret\\kafka-trust.pfx', 'NOTEBOOK', 'cns' from dual  union 
select 'earliest_CARDFL_BOOTSTRAP_SERVERS', 'ssl.keystore.password', '${DSO_KAFKA_SSL_KEYSTORE_PASSWORD}', 'DSO', 'cns' from dual  union 
select 'earliest_CARDFL_BOOTSTRAP_SERVERS', 'ssl.keystore.password', '${IFT_KAFKA_SSL_KEYSTORE_PASSWORD}', 'IFT', 'cns' from dual  union 
select 'earliest_CARDFL_BOOTSTRAP_SERVERS', 'ssl.keystore.password', '${NT_KAFKA_SSL_KEYSTORE_PASSWORD}', 'NT', 'cns' from dual  union 
select 'earliest_CARDFL_BOOTSTRAP_SERVERS', 'ssl.keystore.password', '${P0_KAFKA_SSL_KEYSTORE_PASSWORD}', 'P0', 'cns' from dual  union 
select 'earliest_CARDFL_BOOTSTRAP_SERVERS', 'ssl.keystore.password', '${REAL_KAFKA_SSL_KEYSTORE_PASSWORD}', 'REAL', 'cns' from dual  union 
select 'earliest_CARDFL_BOOTSTRAP_SERVERS', 'ssl.keystore.password', 'kafkauasppassword', 'NOTEBOOK', 'cns' from dual  union 
select 'earliest_CARDFL_BOOTSTRAP_SERVERS', 'ssl.truststore.location', 'C:\\Work\\secret\\APD00.13.01-USBP-kafka-cluster-uasp.pfx', 'NOTEBOOK', 'cns' from dual  union 
select 'earliest_CARDFL_BOOTSTRAP_SERVERS', 'ssl.truststore.password', '${DSO_KAFKA_SSL_TRUSTSTORE_PASSWORD}', 'DSO', 'cns' from dual  union 
select 'earliest_CARDFL_BOOTSTRAP_SERVERS', 'ssl.truststore.password', '${IFT_KAFKA_SSL_TRUSTSTORE_PASSWORD}', 'IFT', 'cns' from dual  union 
select 'earliest_CARDFL_BOOTSTRAP_SERVERS', 'ssl.truststore.password', '${NT_KAFKA_SSL_TRUSTSTORE_PASSWORD}', 'NT', 'cns' from dual  union 
select 'earliest_CARDFL_BOOTSTRAP_SERVERS', 'ssl.truststore.password', '${P0_KAFKA_SSL_TRUSTSTORE_PASSWORD}', 'P0', 'cns' from dual  union 
select 'earliest_CARDFL_BOOTSTRAP_SERVERS', 'ssl.truststore.password', '${REAL_KAFKA_SSL_TRUSTSTORE_PASSWORD}', 'REAL', 'cns' from dual  union 
select 'earliest_CARDFL_BOOTSTRAP_SERVERS', 'ssl.truststore.password', 'kafkauasppassword', 'NOTEBOOK', 'cns' from dual  union 
select 'earliest_DATA_PLATFORM', 'bootstrap.servers', 'kafka-1:29092,kafka-2:39092,kafka-3:49092', 'NOTEBOOK', 'cns' from dual  union 
select 'earliest_DATA_PLATFORM', 'security.protocol', 'PLAINTEXT', 'NOTEBOOK', 'cns' from dual  union 
select 'earliest_DATA_PLATFORM', 'ssl.key.password', '${DP_KAFKA_SSL_KEY_PASSWORD}', 'REAL', 'cns' from dual  union 
select 'earliest_DATA_PLATFORM', 'ssl.key.password', '${DSO_KAFKA_SSL_KEY_PASSWORD}', 'DSO', 'cns' from dual  union 
select 'earliest_DATA_PLATFORM', 'ssl.key.password', '${IFT_KAFKA_SSL_KEY_PASSWORD}', 'IFT', 'cns' from dual  union 
select 'earliest_DATA_PLATFORM', 'ssl.key.password', '${NT_KAFKA_SSL_KEY_PASSWORD}', 'NT', 'cns' from dual  union 
select 'earliest_DATA_PLATFORM', 'ssl.key.password', '${P0_KAFKA_SSL_KEY_PASSWORD}', 'P0', 'cns' from dual  union 
select 'earliest_DATA_PLATFORM', 'ssl.key.password', 'kafkauasppassword', 'NOTEBOOK', 'cns' from dual  union 
select 'earliest_DATA_PLATFORM', 'ssl.keystore.location', '${DP_KAFKA_KEYSTORE_LOCATION}', 'REAL', 'cns' from dual  union 
select 'earliest_DATA_PLATFORM', 'ssl.keystore.location', 'C:\\Work\\secret\\kafka-trust.pfx', 'NOTEBOOK', 'cns' from dual  union 
select 'earliest_DATA_PLATFORM', 'ssl.keystore.password', '${DP_KAFKA_SSL_KEYSTORE_PASSWORD}', 'REAL', 'cns' from dual  union 
select 'earliest_DATA_PLATFORM', 'ssl.keystore.password', '${DSO_KAFKA_SSL_KEYSTORE_PASSWORD}', 'DSO', 'cns' from dual  union 
select 'earliest_DATA_PLATFORM', 'ssl.keystore.password', '${IFT_KAFKA_SSL_KEYSTORE_PASSWORD}', 'IFT', 'cns' from dual  union 
select 'earliest_DATA_PLATFORM', 'ssl.keystore.password', '${NT_KAFKA_SSL_KEYSTORE_PASSWORD}', 'NT', 'cns' from dual  union 
select 'earliest_DATA_PLATFORM', 'ssl.keystore.password', '${P0_KAFKA_SSL_KEYSTORE_PASSWORD}', 'P0', 'cns' from dual  union 
select 'earliest_DATA_PLATFORM', 'ssl.keystore.password', 'kafkauasppassword', 'NOTEBOOK', 'cns' from dual  union 
select 'earliest_DATA_PLATFORM', 'ssl.truststore.location', 'C:\\Work\\secret\\APD00.13.01-USBP-kafka-cluster-uasp.pfx', 'NOTEBOOK', 'cns' from dual  union 
select 'earliest_DATA_PLATFORM', 'ssl.truststore.password', '${DSO_KAFKA_SSL_TRUSTSTORE_PASSWORD}', 'DSO', 'cns' from dual  union 
select 'earliest_DATA_PLATFORM', 'ssl.truststore.password', '${IFT_KAFKA_SSL_TRUSTSTORE_PASSWORD}', 'IFT', 'cns' from dual  union 
select 'earliest_DATA_PLATFORM', 'ssl.truststore.password', '${NT_KAFKA_SSL_TRUSTSTORE_PASSWORD}', 'NT', 'cns' from dual  union 
select 'earliest_DATA_PLATFORM', 'ssl.truststore.password', '${P0_KAFKA_SSL_TRUSTSTORE_PASSWORD}', 'P0', 'cns' from dual  union 
select 'earliest_DATA_PLATFORM', 'ssl.truststore.password', '${REAL_KAFKA_SSL_TRUSTSTORE_PASSWORD}', 'REAL', 'cns' from dual  union 
select 'earliest_DATA_PLATFORM', 'ssl.truststore.password', 'kafkauasppassword', 'NOTEBOOK', 'cns' from dual  union 
select 'gf_latest', 'bootstrap.servers', '${IFT_GF_IFWAYN_BOOTSTRAP_SERVERS}', 'IFT', 'cns' from dual  union 
select 'gf_latest', 'bootstrap.servers', '${NT_GF_IFWAYN_BOOTSTRAP_SERVERS}', 'NT', 'cns' from dual  union 
select 'gf_latest', 'bootstrap.servers', '${P0_GF_IFWAYN_BOOTSTRAP_SERVERS}', 'P0', 'cns' from dual  union 
select 'gf_latest', 'bootstrap.servers', '${RR_GF_IFWAYN_BOOTSTRAP_SERVERS}', 'REAL', 'cns' from dual  union 
select 'gf_latest', 'bootstrap.servers', 'kafka-1:29092,kafka-2:39092,kafka-3:49092', 'NOTEBOOK', 'cns' from dual  union 
select 'gf_latest', 'security.protocol', 'PLAINTEXT', 'NOTEBOOK', 'cns' from dual  union 
select 'gf_latest', 'ssl.key.password', '${IFT_GF_IFWAYN_SSL_KEY_PASSWORD}', 'IFT', 'cns' from dual  union 
select 'gf_latest', 'ssl.key.password', '${NT_GF_IFWAYN_SSL_KEY_PASSWORD}', 'NT', 'cns' from dual  union 
select 'gf_latest', 'ssl.key.password', '${P0_GF_IFWAYN_SSL_KEY_PASSWORD}', 'P0', 'cns' from dual  union 
select 'gf_latest', 'ssl.key.password', '${RR_GF_IFWAYN_SSL_KEY_PASSWORD}', 'REAL', 'cns' from dual  union 
select 'gf_latest', 'ssl.keystore.location', '${IFT_GF_IFWAYN_KEYSTORE_LOCATION}', 'IFT', 'cns' from dual  union 
select 'gf_latest', 'ssl.keystore.location', '${NT_GF_IFWAYN_KEYSTORE_LOCATION}', 'NT', 'cns' from dual  union 
select 'gf_latest', 'ssl.keystore.location', '${P0_GF_IFWAYN_KEYSTORE_LOCATION}', 'P0', 'cns' from dual  union 
select 'gf_latest', 'ssl.keystore.location', '${RR_GF_IFWAYN_KEYSTORE_LOCATION}', 'REAL', 'cns' from dual  union 
select 'gf_latest', 'ssl.keystore.password', '${IFT_GF_IFWAYN_SSL_KEYSTORE_PASSWORD}', 'IFT', 'cns' from dual  union 
select 'gf_latest', 'ssl.keystore.password', '${NT_GF_IFWAYN_SSL_KEYSTORE_PASSWORD}', 'NT', 'cns' from dual  union 
select 'gf_latest', 'ssl.keystore.password', '${P0_GF_IFWAYN_SSL_KEYSTORE_PASSWORD}', 'P0', 'cns' from dual  union 
select 'gf_latest', 'ssl.keystore.password', '${RR_GF_IFWAYN_SSL_KEYSTORE_PASSWORD}', 'REAL', 'cns' from dual  union 
select 'gf_latest', 'ssl.truststore.location', '${IFT_GF_IFWAYN_TRUSTSTORE_LOCATION}', 'IFT', 'cns' from dual  union 
select 'gf_latest', 'ssl.truststore.location', '${NT_GF_IFWAYN_TRUSTSTORE_LOCATION}', 'NT', 'cns' from dual  union 
select 'gf_latest', 'ssl.truststore.location', '${P0_GF_IFWAYN_TRUSTSTORE_LOCATION}', 'P0', 'cns' from dual  union 
select 'gf_latest', 'ssl.truststore.location', '${RR_GF_IFWAYN_TRUSTSTORE_LOCATION}', 'REAL', 'cns' from dual  union 
select 'gf_latest', 'ssl.truststore.password', '${IFT_GF_IFWAYN_SSL_TRUSTSTORE_PASSWORD}', 'IFT', 'cns' from dual  union 
select 'gf_latest', 'ssl.truststore.password', '${NT_GF_IFWAYN_SSL_TRUSTSTORE_PASSWORD}', 'NT', 'cns' from dual  union 
select 'gf_latest', 'ssl.truststore.password', '${P0_GF_IFWAYN_SSL_TRUSTSTORE_PASSWORD}', 'P0', 'cns' from dual  union 
select 'gf_latest', 'ssl.truststore.password', '${RR_GF_IFWAYN_SSL_TRUSTSTORE_PASSWORD}', 'REAL', 'cns' from dual  union 
select 'latest', 'bootstrap.servers', 'kafka-1:29092,kafka-2:39092,kafka-3:49092', 'NOTEBOOK', 'cns' from dual  union 
select 'latest', 'security.protocol', 'PLAINTEXT', 'NOTEBOOK', 'cns' from dual  union 
select 'latest', 'ssl.key.password', '${DSO_KAFKA_SSL_KEY_PASSWORD}', 'DSO', 'cns' from dual  union 
select 'latest', 'ssl.key.password', '${IFT_KAFKA_SSL_KEY_PASSWORD}', 'IFT', 'cns' from dual  union 
select 'latest', 'ssl.key.password', '${NT_KAFKA_SSL_KEY_PASSWORD}', 'NT', 'cns' from dual  union 
select 'latest', 'ssl.key.password', '${P0_KAFKA_SSL_KEY_PASSWORD}', 'P0', 'cns' from dual  union 
select 'latest', 'ssl.key.password', '${REAL_KAFKA_SSL_KEY_PASSWORD}', 'REAL', 'cns' from dual  union 
select 'latest', 'ssl.key.password', 'kafkauasppassword', 'NOTEBOOK', 'cns' from dual  union 
select 'latest', 'ssl.keystore.location', 'C:\\Work\\secret\\kafka-trust.pfx', 'NOTEBOOK', 'cns' from dual  union 
select 'latest', 'ssl.keystore.password', '${DSO_KAFKA_SSL_KEYSTORE_PASSWORD}', 'DSO', 'cns' from dual  union 
select 'latest', 'ssl.keystore.password', '${IFT_KAFKA_SSL_KEYSTORE_PASSWORD}', 'IFT', 'cns' from dual  union 
select 'latest', 'ssl.keystore.password', '${NT_KAFKA_SSL_KEYSTORE_PASSWORD}', 'NT', 'cns' from dual  union 
select 'latest', 'ssl.keystore.password', '${P0_KAFKA_SSL_KEYSTORE_PASSWORD}', 'P0', 'cns' from dual  union 
select 'latest', 'ssl.keystore.password', '${REAL_KAFKA_SSL_KEYSTORE_PASSWORD}', 'REAL', 'cns' from dual  union 
select 'latest', 'ssl.keystore.password', 'kafkauasppassword', 'NOTEBOOK', 'cns' from dual  union 
select 'latest', 'ssl.truststore.location', 'C:\\Work\\secret\\APD00.13.01-USBP-kafka-cluster-uasp.pfx', 'NOTEBOOK', 'cns' from dual  union 
select 'latest', 'ssl.truststore.password', '${DSO_KAFKA_SSL_TRUSTSTORE_PASSWORD}', 'DSO', 'cns' from dual  union 
select 'latest', 'ssl.truststore.password', '${IFT_KAFKA_SSL_TRUSTSTORE_PASSWORD}', 'IFT', 'cns' from dual  union 
select 'latest', 'ssl.truststore.password', '${NT_KAFKA_SSL_TRUSTSTORE_PASSWORD}', 'NT', 'cns' from dual  union 
select 'latest', 'ssl.truststore.password', '${P0_KAFKA_SSL_TRUSTSTORE_PASSWORD}', 'P0', 'cns' from dual  union 
select 'latest', 'ssl.truststore.password', '${REAL_KAFKA_SSL_TRUSTSTORE_PASSWORD}', 'REAL', 'cns' from dual  union 
select 'latest', 'ssl.truststore.password', 'kafkauasppassword', 'NOTEBOOK', 'cns' from dual  union 
select 'latest_DATA_PLATFORM', 'bootstrap.servers', '${P0_DATA_PLATFORM_BOOTSTRAP_SERVERS}', 'P0', 'cns' from dual  union 
select 'latest_DATA_PLATFORM', 'bootstrap.servers', 'kafka-1:29092,kafka-2:39092,kafka-3:49092', 'NOTEBOOK', 'cns' from dual  union 
select 'latest_DATA_PLATFORM', 'security.protocol', 'PLAINTEXT', 'NOTEBOOK', 'cns' from dual  union 
select 'latest_DATA_PLATFORM', 'ssl.key.password', '${DSO_KAFKA_SSL_KEY_PASSWORD}', 'DSO', 'cns' from dual  union 
select 'latest_DATA_PLATFORM', 'ssl.key.password', '${IFT_KAFKA_SSL_KEY_PASSWORD}', 'IFT', 'cns' from dual  union 
select 'latest_DATA_PLATFORM', 'ssl.key.password', '${NT_KAFKA_SSL_KEY_PASSWORD}', 'NT', 'cns' from dual  union 
select 'latest_DATA_PLATFORM', 'ssl.key.password', '${P0_KAFKA_SSL_KEY_PASSWORD}', 'P0', 'cns' from dual  union 
select 'latest_DATA_PLATFORM', 'ssl.key.password', '${REAL_KAFKA_SSL_KEY_PASSWORD}', 'REAL', 'cns' from dual  union 
select 'latest_DATA_PLATFORM', 'ssl.key.password', 'kafkauasppassword', 'NOTEBOOK', 'cns' from dual  union 
select 'latest_DATA_PLATFORM', 'ssl.keystore.location', 'C:\\Work\\secret\\kafka-trust.pfx', 'NOTEBOOK', 'cns' from dual  union 
select 'latest_DATA_PLATFORM', 'ssl.keystore.password', '${DSO_KAFKA_SSL_KEYSTORE_PASSWORD}', 'DSO', 'cns' from dual  union 
select 'latest_DATA_PLATFORM', 'ssl.keystore.password', '${IFT_KAFKA_SSL_KEYSTORE_PASSWORD}', 'IFT', 'cns' from dual  union 
select 'latest_DATA_PLATFORM', 'ssl.keystore.password', '${NT_KAFKA_SSL_KEYSTORE_PASSWORD}', 'NT', 'cns' from dual  union 
select 'latest_DATA_PLATFORM', 'ssl.keystore.password', '${P0_KAFKA_SSL_KEYSTORE_PASSWORD}', 'P0', 'cns' from dual  union 
select 'latest_DATA_PLATFORM', 'ssl.keystore.password', '${REAL_KAFKA_SSL_KEYSTORE_PASSWORD}', 'REAL', 'cns' from dual  union 
select 'latest_DATA_PLATFORM', 'ssl.keystore.password', 'kafkauasppassword', 'NOTEBOOK', 'cns' from dual  union 
select 'latest_DATA_PLATFORM', 'ssl.truststore.location', 'C:\\Work\\secret\\APD00.13.01-USBP-kafka-cluster-uasp.pfx', 'NOTEBOOK', 'cns' from dual  union 
select 'latest_DATA_PLATFORM', 'ssl.truststore.password', '${DSO_KAFKA_SSL_TRUSTSTORE_PASSWORD}', 'DSO', 'cns' from dual  union 
select 'latest_DATA_PLATFORM', 'ssl.truststore.password', '${IFT_KAFKA_SSL_TRUSTSTORE_PASSWORD}', 'IFT', 'cns' from dual  union 
select 'latest_DATA_PLATFORM', 'ssl.truststore.password', '${NT_KAFKA_SSL_TRUSTSTORE_PASSWORD}', 'NT', 'cns' from dual  union 
select 'latest_DATA_PLATFORM', 'ssl.truststore.password', '${P0_KAFKA_SSL_TRUSTSTORE_PASSWORD}', 'P0', 'cns' from dual  union 
select 'latest_DATA_PLATFORM', 'ssl.truststore.password', '${REAL_KAFKA_SSL_TRUSTSTORE_PASSWORD}', 'REAL', 'cns' from dual  union 
select 'latest_DATA_PLATFORM', 'ssl.truststore.password', 'kafkauasppassword', 'NOTEBOOK', 'cns' from dual  union 
select 'producer_default', 'bootstrap.servers', 'kafka-1:29092,kafka-2:39092,kafka-3:49092', 'NOTEBOOK', 'prd' from dual  union 
select 'producer_default', 'security.protocol', 'PLAINTEXT', 'NOTEBOOK', 'prd' from dual  union 
select 'producer_default', 'ssl.key.password', '${DSO_KAFKA_SSL_KEY_PASSWORD}', 'DSO', 'prd' from dual  union 
select 'producer_default', 'ssl.key.password', '${IFT_KAFKA_SSL_KEY_PASSWORD}', 'IFT', 'prd' from dual  union 
select 'producer_default', 'ssl.key.password', '${NT_KAFKA_SSL_KEY_PASSWORD}', 'NT', 'prd' from dual  union 
select 'producer_default', 'ssl.key.password', '${P0_KAFKA_SSL_KEY_PASSWORD}', 'P0', 'prd' from dual  union 
select 'producer_default', 'ssl.key.password', '${REAL_KAFKA_SSL_KEY_PASSWORD}', 'REAL', 'prd' from dual  union 
select 'producer_default', 'ssl.key.password', 'kafkauasppassword', 'NOTEBOOK', 'prd' from dual  union 
select 'producer_default', 'ssl.keystore.location', 'C:\\Work\\secret\\kafka-trust.pfx', 'NOTEBOOK', 'prd' from dual  union 
select 'producer_default', 'ssl.keystore.password', '${DSO_KAFKA_SSL_KEYSTORE_PASSWORD}', 'DSO', 'prd' from dual  union 
select 'producer_default', 'ssl.keystore.password', '${IFT_KAFKA_SSL_KEYSTORE_PASSWORD}', 'IFT', 'prd' from dual  union 
select 'producer_default', 'ssl.keystore.password', '${NT_KAFKA_SSL_KEYSTORE_PASSWORD}', 'NT', 'prd' from dual  union 
select 'producer_default', 'ssl.keystore.password', '${P0_KAFKA_SSL_KEYSTORE_PASSWORD}', 'P0', 'prd' from dual  union 
select 'producer_default', 'ssl.keystore.password', '${REAL_KAFKA_SSL_KEYSTORE_PASSWORD}', 'REAL', 'prd' from dual  union 
select 'producer_default', 'ssl.keystore.password', 'kafkauasppassword', 'NOTEBOOK', 'prd' from dual  union 
select 'producer_default', 'ssl.truststore.location', 'C:\\Work\\secret\\APD00.13.01-USBP-kafka-cluster-uasp.pfx', 'NOTEBOOK', 'prd' from dual  union 
select 'producer_default', 'ssl.truststore.password', '${DSO_KAFKA_SSL_TRUSTSTORE_PASSWORD}', 'DSO', 'prd' from dual  union 
select 'producer_default', 'ssl.truststore.password', '${IFT_KAFKA_SSL_TRUSTSTORE_PASSWORD}', 'IFT', 'prd' from dual  union 
select 'producer_default', 'ssl.truststore.password', '${NT_KAFKA_SSL_TRUSTSTORE_PASSWORD}', 'NT', 'prd' from dual  union 
select 'producer_default', 'ssl.truststore.password', '${P0_KAFKA_SSL_TRUSTSTORE_PASSWORD}', 'P0', 'prd' from dual  union 
select 'producer_default', 'ssl.truststore.password', '${REAL_KAFKA_SSL_TRUSTSTORE_PASSWORD}', 'REAL', 'prd' from dual  union 
select 'producer_default', 'ssl.truststore.password', 'kafkauasppassword', 'NOTEBOOK', 'prd' from dual  union 
select 'producer_idempotence', 'bootstrap.servers', 'kafka-1:29092,kafka-2:39092,kafka-3:49092', 'NOTEBOOK', 'prd' from dual  union 
select 'producer_idempotence', 'security.protocol', 'PLAINTEXT', 'NOTEBOOK', 'prd' from dual  union 
select 'producer_idempotence', 'ssl.key.password', '${IFT_KAFKA_SSL_KEY_PASSWORD}', 'IFT', 'prd' from dual  union 
select 'producer_idempotence', 'ssl.key.password', '${NT_KAFKA_SSL_KEY_PASSWORD}', 'NT', 'prd' from dual  union 
select 'producer_idempotence', 'ssl.key.password', '${P0_KAFKA_SSL_KEY_PASSWORD}', 'P0', 'prd' from dual  union 
select 'producer_idempotence', 'ssl.key.password', '${REAL_KAFKA_SSL_KEY_PASSWORD}', 'REAL', 'prd' from dual  union 
select 'producer_idempotence', 'ssl.key.password', 'kafkauasppassword', 'NOTEBOOK', 'prd' from dual  union 
select 'producer_idempotence', 'ssl.keystore.location', 'C:\\Work\\secret\\kafka-trust.pfx', 'NOTEBOOK', 'prd' from dual  union 
select 'producer_idempotence', 'ssl.keystore.password', '${IFT_KAFKA_SSL_KEYSTORE_PASSWORD}', 'IFT', 'prd' from dual  union 
select 'producer_idempotence', 'ssl.keystore.password', '${NT_KAFKA_SSL_KEYSTORE_PASSWORD}', 'NT', 'prd' from dual  union 
select 'producer_idempotence', 'ssl.keystore.password', '${P0_KAFKA_SSL_KEYSTORE_PASSWORD}', 'P0', 'prd' from dual  union 
select 'producer_idempotence', 'ssl.keystore.password', '${REAL_KAFKA_SSL_KEYSTORE_PASSWORD}', 'REAL', 'prd' from dual  union 
select 'producer_idempotence', 'ssl.keystore.password', 'kafkauasppassword', 'NOTEBOOK', 'prd' from dual  union 
select 'producer_idempotence', 'ssl.truststore.location', 'C:\\Work\\secret\\APD00.13.01-USBP-kafka-cluster-uasp.pfx', 'NOTEBOOK', 'prd' from dual  union 
select 'producer_idempotence', 'ssl.truststore.password', '${IFT_KAFKA_SSL_TRUSTSTORE_PASSWORD}', 'IFT', 'prd' from dual  union 
select 'producer_idempotence', 'ssl.truststore.password', '${NT_KAFKA_SSL_TRUSTSTORE_PASSWORD}', 'NT', 'prd' from dual  union 
select 'producer_idempotence', 'ssl.truststore.password', '${P0_KAFKA_SSL_TRUSTSTORE_PASSWORD}', 'P0', 'prd' from dual  union 
select 'producer_idempotence', 'ssl.truststore.password', '${REAL_KAFKA_SSL_TRUSTSTORE_PASSWORD}', 'REAL', 'prd' from dual  union 
select 'producer_idempotence', 'ssl.truststore.password', 'kafkauasppassword', 'NOTEBOOK', 'prd' from dual ;

insert into dict_place_holder_by_service(place_holder_id, profile_id, service_id, stand_id, value) 
select 'PARALLELISM', 'aggregate-bevents', 'bevents-streaming-aggregate-first-salary', 'P0', '8' from dual  union 
select 'PARALLELISM', 'aggregate-bevents-56-57', 'bevents-streaming-aggregate-first-salary', 'P0', '8' from dual  union 
select 'PARALLELISM', 'bevents-filter', 'uasp-streaming-filter', 'P0', '8' from dual  union 
select 'PARALLELISM', 'case-48-concatenate', 'uasp-streaming-mutator', 'P0', '8' from dual  union 
select 'PARALLELISM', 'case-68', 'uasp-streaming-mdm-enrichment', 'P0', '8' from dual  union 
select 'PARALLELISM', 'case-68_agrement', 'uasp-streaming-mdm-enrichment', 'P0', '8' from dual  union 
select 'PARALLELISM', 'customer-package', 'uasp-streaming-input-convertor', 'P0', '8' from dual  union 
select 'PARALLELISM', 'customer-profile-full', 'uasp-streaming-input-convertor', 'P0', '8' from dual  union 
select 'PARALLELISM', 'input-convertor-ca-cardfl', 'uasp-streaming-input-convertor', 'P0', '8' from dual  union 
select 'PARALLELISM', 'input-convertor-ca-depositfl', 'uasp-streaming-input-convertor', 'P0', '8' from dual  union 
select 'PARALLELISM', 'input-convertor-ca-first-salary', 'uasp-streaming-input-convertor', 'P0', '8' from dual  union 
select 'PARALLELISM', 'input-convertor-cardfl', 'uasp-streaming-input-convertor', 'P0', '8' from dual  union 
select 'PARALLELISM', 'input-convertor-cft', 'uasp-streaming-input-convertor', 'P0', '8' from dual  union 
select 'PARALLELISM', 'input-convertor-mdm', 'uasp-streaming-input-convertor', 'P0', '8' from dual  union 
select 'PARALLELISM', 'input-convertor-prof-auth', 'uasp-streaming-input-convertor', 'P0', '8' from dual  union 
select 'PARALLELISM', 'input-convertor-profile', 'uasp-streaming-input-convertor', 'P0', '8' from dual  union 
select 'PARALLELISM', 'input-convertor-udds', 'uasp-streaming-input-convertor', 'P0', '8' from dual  union 
select 'PARALLELISM', 'input-convertor-w4-operation', 'uasp-streaming-input-convertor', 'P0', '8' from dual  union 
select 'PARALLELISM', 'input-convertor-withdraw', 'uasp-streaming-input-convertor', 'P0', '8' from dual  union 
select 'PARALLELISM', 'loyalty', 'uasp-streaming-input-convertor', 'P0', '8' from dual  union 
select 'PARALLELISM', 'main', 'uasp-kriaa-bevents-case-2', 'P0', '8' from dual  union 
select 'PARALLELISM', 'main', 'uasp-kriaa-bevents-case-40', 'P0', '8' from dual  union 
select 'PARALLELISM', 'main', 'uasp-kriaa-bevents-case-55', 'P0', '8' from dual  union 
select 'PARALLELISM', 'main', 'uasp-kriaa-bevents-case-56', 'P0', '8' from dual  union 
select 'PARALLELISM', 'main', 'uasp-kriaa-bevents-case-68', 'P0', '8' from dual  union 
select 'PARALLELISM', 'main', 'uasp-kriaa-bevents-case-84', 'P0', '8' from dual  union 
select 'PARALLELISM', 'main', 'uasp-kriaa-bevents-case-86', 'P0', '8' from dual  union 
select 'PARALLELISM', 'mainInput', 'uasp-streaming-mutator', 'P0', '8' from dual  union 
select 'PARALLELISM', 'main-input-filter', 'uasp-streaming-filter', 'P0', '8' from dual  union 
select 'PARALLELISM', 'mdm-profile', 'uasp-streaming-input-convertor', 'P0', '8' from dual  union 
select 'PARALLELISM', 'model-vector-bevents', 'uasp-streaming-model-vector', 'P0', '8' from dual  union 
select 'PARALLELISM', 'prof-auth', 'uasp-streaming-mdm-enrichment', 'P0', '8' from dual  union 
select 'PARALLELISM', 'prof-auth-packNM', 'uasp-streaming-mdm-enrichment', 'P0', '8' from dual  union 
select 'PARALLELISM', 'profile-tx-step1', 'uasp-streaming-mdm-enrichment', 'P0', '8' from dual  union 
select 'PARALLELISM', 'profile-tx-step2', 'uasp-streaming-mdm-enrichment', 'P0', '8' from dual  union 
select 'PARALLELISM', 'prof-tx-case-71', 'uasp-streaming-mdm-enrichment', 'P0', '8' from dual  union 
select 'PARALLELISM', 'rateMutate', 'uasp-streaming-mutator', 'P0', '8' from dual  union 
select 'PARALLELISM', 'test', 'uasp-kriaa-bevents-monitor', 'P0', '8' from dual  union 
select 'PARALLELISM', 'uddsRate', 'uasp-streaming-mutator', 'P0', '8' from dual  union 
select 'PARALLELISM', 'way4', 'uasp-streaming-mdm-enrichment', 'P0', '8' from dual  union 
select 'PARALLELISM', 'way4-card-agreement', 'uasp-streaming-mdm-enrichment', 'P0', '8' from dual ;

insert into dict_service_group(group_id, profile_id, service_id) 
select 'bevents-streaming-aggregate-first-salary_aggregate-bevents', 'aggregate-bevents', 'bevents-streaming-aggregate-first-salary' from dual  union 
select 'bevents-streaming-aggregate-first-salary_aggregate-bevents-56-57', 'aggregate-bevents-56-57', 'bevents-streaming-aggregate-first-salary' from dual  union 
select 'rto_graph', 'aggregate-bevents', 'bevents-streaming-aggregate-first-salary' from dual  union 
select 'rto_graph', 'aggregate-dko', 'uasp-streaming-aggregate' from dual  union 
select 'rto_graph', 'bevents-filter', 'uasp-streaming-filter' from dual  union 
select 'rto_graph', 'case-68', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'rto_graph', 'case-68_agrement', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'rto_graph', 'input-convertor-ca-cardfl', 'uasp-streaming-input-convertor' from dual  union 
select 'rto_graph', 'input-convertor-ca-depositfl', 'uasp-streaming-input-convertor' from dual  union 
select 'rto_graph', 'input-convertor-ca-first-salary', 'uasp-streaming-input-convertor' from dual  union 
select 'rto_graph', 'input-convertor-cardfl', 'uasp-streaming-input-convertor' from dual  union 
select 'rto_graph', 'input-convertor-cft', 'uasp-streaming-input-convertor' from dual  union 
select 'rto_graph', 'input-convertor-mdm', 'uasp-streaming-input-convertor' from dual  union 
select 'rto_graph', 'input-convertor-prof-auth', 'uasp-streaming-input-convertor' from dual  union 
select 'rto_graph', 'input-convertor-profile', 'uasp-streaming-input-convertor' from dual  union 
select 'rto_graph', 'input-convertor-w4-operation', 'uasp-streaming-input-convertor' from dual  union 
select 'rto_graph', 'input-convertor-withdraw', 'uasp-streaming-input-convertor' from dual  union 
select 'rto_graph', 'main', 'uasp-kriaa-bevents-case-2' from dual  union 
select 'rto_graph', 'main', 'uasp-kriaa-bevents-case-40' from dual  union 
select 'rto_graph', 'main', 'uasp-kriaa-bevents-case-68' from dual  union 
select 'rto_graph', 'main-input-filter', 'uasp-streaming-filter' from dual  union 
select 'rto_graph', 'model-vector-bevents', 'uasp-streaming-model-vector' from dual  union 
select 'rto_graph', 'prof-auth', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'rto_graph', 'prof-auth-packNM', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'rto_graph', 'profile-tx-step1', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'rto_graph', 'profile-tx-step2', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'rto_graph', 'prof-tx-case-71', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'rto_graph', 'way4', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'rto_graph', 'way4-card-agreement', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'uasp_dko_83088_way4_mdm_enrich_2150_way4_new_stream', 'way4_new_stream', 'uasp_dko_83088_way4_mdm_enrich_2150' from dual  union 
select 'uasp_dko_83088_way4_mdm_enrich_2150_way4_old_stream', 'way4_old_stream', 'uasp_dko_83088_way4_mdm_enrich_2150' from dual  union 
select 'uasp_dko_83088_way4_mdm_enrich_way4_new', 'way4_new', 'uasp_dko_83088_way4_mdm_enrich' from dual  union 
select 'uasp_dko_83088_way4_mdm_enrich_way4_old_stream', 'way4_old_stream', 'uasp_dko_83088_way4_mdm_enrich' from dual  union 
select 'uasp-dko-rds-63902-accr-reciver_main', 'main', 'uasp-dko-rds-63902-accr-reciver' from dual  union 
select 'uasp-kriaa-bevents-case-2_main', 'main', 'uasp-kriaa-bevents-case-2' from dual  union 
select 'uasp-kriaa-bevents-case-40_main', 'main', 'uasp-kriaa-bevents-case-40' from dual  union 
select 'uasp-kriaa-bevents-case-55_main', 'main', 'uasp-kriaa-bevents-case-55' from dual  union 
select 'uasp-kriaa-bevents-case-56_main', 'main', 'uasp-kriaa-bevents-case-56' from dual  union 
select 'uasp-kriaa-bevents-case-57_main', 'main', 'uasp-kriaa-bevents-case-57' from dual  union 
select 'uasp-kriaa-bevents-case-68_main', 'main', 'uasp-kriaa-bevents-case-68' from dual  union 
select 'uasp-kriaa-bevents-case-70_main', 'main', 'uasp-kriaa-bevents-case-70' from dual  union 
select 'uasp-kriaa-bevents-case-84_main', 'main', 'uasp-kriaa-bevents-case-84' from dual  union 
select 'uasp-kriaa-bevents-case-86_main', 'main', 'uasp-kriaa-bevents-case-86' from dual  union 
select 'uasp-kriaa-bevents-insurence-cft_main', 'main', 'uasp-kriaa-bevents-insurence-cft' from dual  union 
select 'uasp-kriaa-bevents-insurence-kn_main', 'main', 'uasp-kriaa-bevents-insurence-kn' from dual  union 
select 'uasp-kriaa-bevents-monitor_test', 'test', 'uasp-kriaa-bevents-monitor' from dual  union 
select 'uasp-streaming-aggregate_aggregate-dko', 'aggregate-dko', 'uasp-streaming-aggregate' from dual  union 
select 'uasp-streaming-beg-card-block_credit-card', 'credit-card', 'uasp-streaming-beg-card-block' from dual  union 
select 'uasp-streaming-beg-pincode-change_credit-card', 'credit-card', 'uasp-streaming-beg-pincode-change' from dual  union 
select 'uasp-streaming-cc-activation_credit-card', 'credit-card', 'uasp-streaming-cc-activation' from dual  union 
select 'uasp-streaming-currency-enrichment_case68', 'case68', 'uasp-streaming-currency-enrichment' from dual  union 
select 'uasp-streaming-currency-enrichment_first-salary', 'first-salary', 'uasp-streaming-currency-enrichment' from dual  union 
select 'uasp-streaming-filter_bevents-filter', 'bevents-filter', 'uasp-streaming-filter' from dual  union 
select 'uasp-streaming-filter_main-input-filter', 'main-input-filter', 'uasp-streaming-filter' from dual  union 
select 'uasp-streaming-input-convertor_close_account', 'close_account', 'uasp-streaming-input-convertor' from dual  union 
select 'uasp-streaming-input-convertor_customer-package', 'customer-package', 'uasp-streaming-input-convertor' from dual  union 
select 'uasp-streaming-input-convertor_customer-profile-full', 'customer-profile-full', 'uasp-streaming-input-convertor' from dual  union 
select 'uasp-streaming-input-convertor_input-convertor-ca-cardfl', 'input-convertor-ca-cardfl', 'uasp-streaming-input-convertor' from dual  union 
select 'uasp-streaming-input-convertor_input-convertor-ca-depositfl', 'input-convertor-ca-depositfl', 'uasp-streaming-input-convertor' from dual  union 
select 'uasp-streaming-input-convertor_input-convertor-ca-first-salary', 'input-convertor-ca-first-salary', 'uasp-streaming-input-convertor' from dual  union 
select 'uasp-streaming-input-convertor_input-convertor-cardfl', 'input-convertor-cardfl', 'uasp-streaming-input-convertor' from dual  union 
select 'uasp-streaming-input-convertor_input-convertor-cft', 'input-convertor-cft', 'uasp-streaming-input-convertor' from dual  union 
select 'uasp-streaming-input-convertor_input-convertor-mdm', 'input-convertor-mdm', 'uasp-streaming-input-convertor' from dual  union 
select 'uasp-streaming-input-convertor_input-convertor-prof-auth', 'input-convertor-prof-auth', 'uasp-streaming-input-convertor' from dual  union 
select 'uasp-streaming-input-convertor_input-convertor-profile', 'input-convertor-profile', 'uasp-streaming-input-convertor' from dual  union 
select 'uasp-streaming-input-convertor_input-convertor-udds', 'input-convertor-udds', 'uasp-streaming-input-convertor' from dual  union 
select 'uasp-streaming-input-convertor_input-convertor-w4-operation', 'input-convertor-w4-operation', 'uasp-streaming-input-convertor' from dual  union 
select 'uasp-streaming-input-convertor_input-convertor-withdraw', 'input-convertor-withdraw', 'uasp-streaming-input-convertor' from dual  union 
select 'uasp-streaming-input-convertor_loyalty', 'loyalty', 'uasp-streaming-input-convertor' from dual  union 
select 'uasp-streaming-input-convertor_mdm-profile', 'mdm-profile', 'uasp-streaming-input-convertor' from dual  union 
select 'uasp-streaming-json-validator_insurance', 'insurance', 'uasp-streaming-json-validator' from dual  union 
select 'uasp-streaming-json-validator_kn', 'kn', 'uasp-streaming-json-validator' from dual  union 
select 'uasp-streaming-json-validator_uz', 'uz', 'uasp-streaming-json-validator' from dual  union 
select 'uasp-streaming-mdm-enrichment_case-68', 'case-68', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'uasp-streaming-mdm-enrichment_case-68_agrement', 'case-68_agrement', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'uasp-streaming-mdm-enrichment_prof-auth', 'prof-auth', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'uasp-streaming-mdm-enrichment_prof-auth-packNM', 'prof-auth-packNM', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'uasp-streaming-mdm-enrichment_profile-tx-step1', 'profile-tx-step1', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'uasp-streaming-mdm-enrichment_profile-tx-step2', 'profile-tx-step2', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'uasp-streaming-mdm-enrichment_prof-tx-case-71', 'prof-tx-case-71', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'uasp-streaming-mdm-enrichment_way4', 'way4', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'uasp-streaming-mdm-enrichment_way4-card-agreement', 'way4-card-agreement', 'uasp-streaming-mdm-enrichment' from dual  union 
select 'uasp-streaming-model-vector_model-vector-bevents', 'model-vector-bevents', 'uasp-streaming-model-vector' from dual  union 
select 'uasp-streaming-mutator_case-48-concatenate', 'case-48-concatenate', 'uasp-streaming-mutator' from dual  union 
select 'uasp-streaming-mutator_mainInput', 'mainInput', 'uasp-streaming-mutator' from dual  union 
select 'uasp-streaming-mutator_rateMutate', 'rateMutate', 'uasp-streaming-mutator' from dual  union 
select 'uasp-streaming-mutator_uddsRate', 'uddsRate', 'uasp-streaming-mutator' from dual  union 
select 'uasp-streaming-refunds-event-notifier_main', 'main', 'uasp-streaming-refunds-event-notifier' from dual  union 
select 'uasp-streaming-rto-15_uasp-streaming-rto-15', 'uasp-streaming-rto-15', 'uasp-streaming-rto-15' from dual  union 
select 'uasp-streaming-rto-37_uasp-streaming-rto-37', 'uasp-streaming-rto-37', 'uasp-streaming-rto-37' from dual  union 
select 'uasp-streaming-rto-attempt-close-part2_uasp-streaming-rto-attempt-close-part2', 'uasp-streaming-rto-attempt-close-part2', 'uasp-streaming-rto-attempt-close-part2' from dual  union 
select 'uasp-streaming-rto-bcps-card-emission-digital_uasp-streaming-rto-bcps-card-emission-digital', 'uasp-streaming-rto-bcps-card-emission-digital', 'uasp-streaming-rto-bcps-card-emission-digital' from dual  union 
select 'uasp-streaming-rto-bcps-card-emission-digital_uasp-streaming-rto-bcps-card-emission-digital-mock-test', 'uasp-streaming-rto-bcps-card-emission-digital-mock-test', 'uasp-streaming-rto-bcps-card-emission-digital' from dual  union 
select 'uasp-streaming-rto-bcps-status-change_uasp-streaming-rto-bcps-status-change', 'uasp-streaming-rto-bcps-status-change', 'uasp-streaming-rto-bcps-status-change' from dual  union 
select 'uasp-streaming-rto-bcps-status-change_uasp-streaming-rto-bcps-status-change-mock-test', 'uasp-streaming-rto-bcps-status-change-mock-test', 'uasp-streaming-rto-bcps-status-change' from dual  union 
select 'uasp-streaming-rto-card-activation-way4_uasp-streaming-rto-card-activation-way4', 'uasp-streaming-rto-card-activation-way4', 'uasp-streaming-rto-card-activation-way4' from dual  union 
select 'uasp-streaming-rto-card-activation-way4_uasp-streaming-rto-card-activation-way4-mock-test', 'uasp-streaming-rto-card-activation-way4-mock-test', 'uasp-streaming-rto-card-activation-way4' from dual  union 
select 'uasp-streaming-rto-closing-deposit_uasp-streaming-rto-closing-deposit', 'uasp-streaming-rto-closing-deposit', 'uasp-streaming-rto-closing-deposit' from dual  union 
select 'uasp-streaming-rto-dko-4_62_uasp-streaming-rto-dko-4_62', 'uasp-streaming-rto-dko-4_62', 'uasp-streaming-rto-dko-4_62' from dual  union 
select 'uasp-streaming-rto-mortgage-approval_uasp-streaming-rto-mortgage-approval-prod', 'uasp-streaming-rto-mortgage-approval-prod', 'uasp-streaming-rto-mortgage-approval' from dual  union 
select 'uasp-streaming-rto-ofvs_uasp-streaming-rto-ofvs', 'uasp-streaming-rto-ofvs', 'uasp-streaming-rto-ofvs' from dual  union 
select 'uasp-streaming-rto-open-deposit_uasp-streaming-rto-open-deposit', 'uasp-streaming-rto-open-deposit', 'uasp-streaming-rto-open-deposit' from dual  union 
select 'uasp-streaming-rto-status-execution-goal_uasp-streaming-rto-status-execution-goal', 'uasp-streaming-rto-status-execution-goal', 'uasp-streaming-rto-status-execution-goal' from dual  union 
select 'uasp-streaming-rto-zoc_uasp-streaming-rto-zoc', 'uasp-streaming-rto-zoc', 'uasp-streaming-rto-zoc' from dual  union 
select 'uasp-streaming-unp-convertor_aggregate-ca', 'aggregate-ca', 'uasp-streaming-unp-convertor' from dual  union 
select 'uasp-streaming-unp-convertor_cardfl', 'cardfl', 'uasp-streaming-unp-convertor' from dual  union 
select 'uasp-streaming-unp-convertor_case68', 'case68', 'uasp-streaming-unp-convertor' from dual  union 
select 'uasp-streaming-unp-convertor_cbr-rate', 'cbr-rate', 'uasp-streaming-unp-convertor' from dual  union 
select 'uasp-streaming-unp-convertor_cft-transactions', 'cft-transactions', 'uasp-streaming-unp-convertor' from dual  union 
select 'uasp-streaming-unp-convertor_close_account', 'close_account', 'uasp-streaming-unp-convertor' from dual  union 
select 'uasp-streaming-unp-convertor_outer-cbr-rate', 'outer-cbr-rate', 'uasp-streaming-unp-convertor' from dual  union 
select 'uasp-streaming-unp-convertor_profile-auth', 'profile-auth', 'uasp-streaming-unp-convertor' from dual  union 
select 'uasp-streaming-unp-convertor_profile-transactions', 'profile-transactions', 'uasp-streaming-unp-convertor' from dual  union 
select 'uasp-streaming-unp-convertor_udds-3to8', 'udds-3to8', 'uasp-streaming-unp-convertor' from dual  union 
select 'uasp-streaming-unp-convertor_unp_w4_issuing_card', 'unp_w4_issuing_card', 'uasp-streaming-unp-convertor' from dual  union 
select 'uasp-streaming-unp-convertor_w4-account-balance', 'w4-account-balance', 'uasp-streaming-unp-convertor' from dual  union 
select 'uasp-streaming-unp-convertor_way4-main', 'way4-main', 'uasp-streaming-unp-convertor' from dual  union 
select 'uasp-streaming-unp-convertor_way4-transactions', 'way4-transactions', 'uasp-streaming-unp-convertor' from dual  union 
select 'uasp-streaming-unp-convertor_withdraw-transactions', 'withdraw-transactions', 'uasp-streaming-unp-convertor' from dual ;

