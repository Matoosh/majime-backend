CREATE OR REPLACE FUNCTION truncTable(tbl text)
returns void language plpgsql as $$
begin
    execute format('TRUNCATE %I CASCADE', tbl);
end $$;

CREATE OR REPLACE FUNCTION disableTriggers(tbl text)
returns void language plpgsql as $$
begin
    execute format('ALTER TABLE %I DISABLE TRIGGER ALL', tbl);
end $$;

CREATE OR REPLACE FUNCTION enableTriggers(tbl text)
returns void language plpgsql as $$
begin
    execute format('ALTER TABLE %I ENABLE TRIGGER ALL', tbl);
end $$;