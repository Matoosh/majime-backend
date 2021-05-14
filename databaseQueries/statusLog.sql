DROP TABLE IF EXISTS sample_status_log;

CREATE TABLE IF NOT EXISTS sample_status_log (
                                                 id SERIAL PRIMARY KEY,
                                                 sample_id bigint NOT NULL,
                                                 old_status varchar,
                                                 new_status varchar,
                                                 sample_type varchar,
                                                 old_timestamp timestamp,
                                                 new_timestamp timestamp,
                                                 operation_time bigint,
                                                 dml_year varchar,
                                                 dml_week varchar
);

CREATE OR REPLACE FUNCTION sample_status_trigger_func()
    RETURNS trigger AS $body$
BEGIN

    if (TG_OP = 'INSERT') then
        INSERT INTO sample_status_log (
            sample_id,
            old_status,
            new_status,
            sample_type,
            old_timestamp,
            new_timestamp,
            operation_time,
            dml_year,
            dml_week
        )
        VALUES (
                   NEW.id,
                   null,
                   NEW.status,
                   NEW.type,
                   CURRENT_TIMESTAMP,
                   CURRENT_TIMESTAMP,
                   null,
                   EXTRACT(YEAR FROM CURRENT_TIMESTAMP),
                   EXTRACT(WEEK FROM CURRENT_TIMESTAMP)
               );
        RETURN NEW;

    elsif (TG_OP = 'UPDATE') AND (OLD.status!=NEW.status) then
        INSERT INTO sample_status_log (
            sample_id,
            old_status,
            new_status,
            sample_type,
            old_timestamp,
            new_timestamp,
            operation_time,
            dml_year,
            dml_week
        )
        VALUES (
                   NEW.id,
                   OLD.status,
                   NEW.status,
                   OLD.type,
                   OLD.created_at,
                   CURRENT_TIMESTAMP,
                   DATE_PART('day', AGE(CURRENT_TIMESTAMP, OLD.created_at)),
                   EXTRACT(YEAR FROM CURRENT_TIMESTAMP),
                   EXTRACT(WEEK FROM CURRENT_TIMESTAMP)
               );
        RETURN NEW;
    end if;

    RETURN NEW;
END;
$body$
LANGUAGE plpgsql;

DROP TRIGGER IF EXISTS sample_status_trigger ON sample;
CREATE TRIGGER sample_status_trigger AFTER INSERT OR UPDATE OR DELETE ON sample FOR EACH ROW EXECUTE FUNCTION sample_status_trigger_func();