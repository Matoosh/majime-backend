CREATE OR REPLACE FUNCTION sample_status_by_result_func()
    RETURNS trigger AS $body$
DECLARE cnt INTEGER;
BEGIN
    if (TG_OP = 'INSERT') then
        if (NEW.STATUS = 'OOS') then
            UPDATE sample SET sample.status='OOS' WHERE sample.id=NEW.sample_id;
        end if;

        if (NEW.STATUS = 'ENTERED') then
            SELECT INTO cnt count(*) FROM sample WHERE (sample.id=NEW.sample_id) AND (sample.status='ENTERED');
            if (cnt=0) then --lub 1 do wyjaśnienia
                UPDATE sample SET sample.status='CHECK' WHERE sample.id=NEW.sample_id;
            end if;
        end if;

        if (NEW.STATUS = 'NEW') then --usunąć jak zmienimy NEW na ENTERED w BE i FE
            SELECT INTO cnt count(*) FROM sample WHERE (sample.id=NEW.sample_id) AND (sample.status='NEW');
            if (cnt=0) then --lub 1 do wyjaśnienia
                UPDATE sample SET sample.status='CHECK' WHERE sample.id=NEW.sample_id;
            end if;
        end if;

        RETURN NEW;

    elsif (TG_OP = 'UPDATE') then

        RETURN NEW;

    elsif (TG_OP = 'DELETE') then

        RETURN OLD;
    end if;

END;
$body$
LANGUAGE plpgsql;

DROP TRIGGER IF EXISTS sample_status_by_result_trigger ON result;
CREATE TRIGGER sample_status_by_result_trigger AFTER INSERT OR UPDATE OR DELETE ON result FOR EACH ROW EXECUTE FUNCTION sample_status_by_result_func();