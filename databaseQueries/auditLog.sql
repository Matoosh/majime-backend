--DROP TABLE audit_log;
--DROP TYPE dml_type;

CREATE TYPE dml_type AS ENUM ('INSERT', 'UPDATE', 'DELETE');

CREATE TABLE IF NOT EXISTS audit_log (
    id SERIAL PRIMARY KEY,
    tab_name varchar(255) NOT NULL,
    element_id bigint NOT NULL,
    old_row_data jsonb,
    new_row_data jsonb,
    dml_type dml_type NOT NULL,
    dml_timestamp timestamp NOT NULL,
    dml_created_by varchar(255) NOT NULL,
    dml_reason varchar(255) NOT NULL
    );

CREATE OR REPLACE FUNCTION audit_trigger_func()
RETURNS trigger AS $body$
BEGIN
   if (TG_OP = 'INSERT') then
       INSERT INTO audit_log (
			tab_name,
    		element_id,
    		old_row_data,
		   	new_row_data,
    		dml_type,
    		dml_timestamp,
    		dml_created_by,
			dml_reason
       )
       VALUES(
           TG_RELNAME,
		   NEW.id,
           null,
           to_jsonb(NEW),
           'INSERT',
           CURRENT_TIMESTAMP,
           CURRENT_USER,
		   'New record'
       );
RETURN NEW;

elsif (TG_OP = 'UPDATE') then
       INSERT INTO audit_log (
			tab_name,
    		element_id,
    		old_row_data,
		   	new_row_data,
    		dml_type,
    		dml_timestamp,
    		dml_created_by,
			dml_reason
       )
       VALUES(
           TG_RELNAME,
		   NEW.id,
           to_jsonb(OLD),
           to_jsonb(NEW),
           'UPDATE',
           CURRENT_TIMESTAMP,
           CURRENT_USER,
		   'Updated record'
       );

RETURN NEW;
elsif (TG_OP = 'DELETE') then
       INSERT INTO audit_log (
			tab_name,
    		element_id,
    		old_row_data,
		   	new_row_data,
    		dml_type,
    		dml_timestamp,
    		dml_created_by,
			dml_reason
       )
       VALUES(
           TG_RELNAME,
		   OLD.id,
           to_jsonb(OLD),
           null,
           'DELETE',
           CURRENT_TIMESTAMP,
           CURRENT_USER,
		   'Deleted record'
       );

RETURN OLD;
end if;

END;
$body$
LANGUAGE plpgsql

