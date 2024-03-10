DO $$
begin

INSERT INTO dict_topic_owner (id, is_our, description_for_report) VALUES ('DKO_COMMAND', 1, 'Интеграция: ссылка на ПМИ');

end;
$$;
/

commit
/