DO $$
    declare
        tuple2_v record;
        v varchar;
    begin
        for tuple2_v in
--     select 'graph_1' GRAPH_ID, 'Additional_enrich' SERVICE_ID, 'case_65' PROFILE_ID, 'MainClass1' MAIN_CLASS from dual union
--     select 'graph_1', 'Filter', 'case_65', 'MainClass2' from dual union
--     select 'graph_1', 'Mutator', 'case_65', 'MainClass3' from dual union

    select 'rto_graph' GRAPH_ID, 'uasp-streaming-mdm-enrichment' SERVICE_ID, 'way4' PROFILE_ID, 'ru.vtb.uasp.mdm.enrichment.EnrichmentJob' MAIN_CLASS from dual union
    select 'rto_graph', 'uasp-streaming-mdm-enrichment', 'way4-card-agreement', 'ru.vtb.uasp.mdm.enrichment.EnrichmentJob' from dual union

    select 'rto_graph', 'bevents-streaming-aggregate-first-salary', 'aggregate-bevents', 'ru.vtb.bevent.first.salary.aggregate.UaspStreamingAggregateFirstSalary' from dual union
    select 'rto_graph', 'uasp-streaming-input-convertor', 'input-convertor-ca-cardfl', 'ru.vtb.uasp.inputconvertor.Convertor' from dual union
    select 'rto_graph', 'uasp-streaming-input-convertor', 'input-convertor-ca-depositfl', 'ru.vtb.uasp.inputconvertor.Convertor' from dual union
    select 'rto_graph', 'uasp-streaming-input-convertor', 'input-convertor-ca-first-salary', 'ru.vtb.uasp.inputconvertor.Convertor' from dual union
    select 'rto_graph', 'uasp-streaming-input-convertor', 'input-convertor-cardfl', 'ru.vtb.uasp.inputconvertor.Convertor' from dual union
    select 'rto_graph', 'uasp-streaming-input-convertor', 'input-convertor-cft', 'ru.vtb.uasp.inputconvertor.Convertor' from dual union
    select 'rto_graph', 'uasp-streaming-input-convertor', 'input-convertor-mdm', 'ru.vtb.uasp.inputconvertor.Convertor' from dual union
    select 'rto_graph', 'uasp-streaming-input-convertor', 'input-convertor-prof-auth', 'ru.vtb.uasp.inputconvertor.Convertor' from dual union
    select 'rto_graph', 'uasp-streaming-input-convertor', 'input-convertor-profile', 'ru.vtb.uasp.inputconvertor.Convertor' from dual union
    select 'rto_graph', 'uasp-streaming-input-convertor', 'input-convertor-withdraw', 'ru.vtb.uasp.inputconvertor.Convertor' from dual union
    select 'rto_graph', 'uasp-streaming-model-vector', 'model-vector-bevents', 'ru.vtb.uasp.pilot.model.vector.UaspStreamingModelVector' from dual union

    select 'rto_graph', 'uasp-streaming-filter', 'bevents-filter', 'ru.vtb.uasp.filter.FilterJob' from dual union
    select 'rto_graph', 'uasp-streaming-filter', 'main-input-filter', 'ru.vtb.uasp.filter.FilterJob' from dual union


    select 'rto_graph', 'uasp-kriaa-bevents-case-40', 'main', 'ru.vtb.uasp.packacge.PackageServiceJob' from dual union
    select 'rto_graph', 'uasp-kriaa-bevents-case-68', 'main', 'ru.vtb.bevent.UaspStreamingCase68' from dual union
    select 'rto_graph', 'uasp-kriaa-bevents-case-2', 'main', 'ru.vtb.uasp.packacge.PackageServiceJob' from dual union

    select 'rto_graph', 'uasp-streaming-input-convertor', 'way4-convertor', 'ru.vtb.uasp.inputconvertor.Convertor' from dual union
    select 'rto_graph', 'uasp-streaming-input-convertor', 'input-convertor-w4-operation', 'ru.vtb.uasp.inputconvertor.Convertor' from dual union
    select 'rto_graph', 'uasp-streaming-aggregate', 'aggregate-dko', 'ru.vtb.uasp.aggregate.UaspStreamingAggregate' from dual union

    select 'rto_graph', 'uasp-streaming-mdm-enrichment', 'case-68', 'ru.vtb.uasp.mdm.enrichment.EnrichmentJob' from dual union
    select 'rto_graph', 'uasp-streaming-mdm-enrichment', 'case-68_agrement', 'ru.vtb.uasp.mdm.enrichment.EnrichmentJob' from dual union
    select 'rto_graph', 'uasp-streaming-mdm-enrichment', 'prof-auth', 'ru.vtb.uasp.mdm.enrichment.EnrichmentJob' from dual union
    select 'rto_graph', 'uasp-streaming-mdm-enrichment', 'prof-auth-packNM', 'ru.vtb.uasp.mdm.enrichment.EnrichmentJob' from dual union
    select 'rto_graph', 'uasp-streaming-mdm-enrichment', 'prof-tx-case-71', 'ru.vtb.uasp.mdm.enrichment.EnrichmentJob' from dual union
    select 'rto_graph', 'uasp-streaming-mdm-enrichment', 'profile-tx-step1', 'ru.vtb.uasp.mdm.enrichment.EnrichmentJob' from dual union
    select 'rto_graph', 'uasp-streaming-mdm-enrichment', 'profile-tx-step2', 'ru.vtb.uasp.mdm.enrichment.EnrichmentJob' from dual

            loop
            --                 null;
--                 call DICT_SERVICE_INS_trg(tuple2_v.GRAPH_ID, tuple2_v.SERVICE_ID, tuple2_v.PROFILE_ID, tuple2_v.MAIN_CLASS);
                select '1' into v from DICT_SERVICE_INS_trg(tuple2_v.GRAPH_ID, tuple2_v.SERVICE_ID, tuple2_v.PROFILE_ID, tuple2_v.MAIN_CLASS);
            end loop;

    end;
$$;
/
