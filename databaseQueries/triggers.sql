CREATE OR REPLACE FUNCTION createAuditTrigger(tbl text)
returns void language plpgsql as $$

declare
triggerName text:=concat(tbl,'_audit_trigger');

begin
	IF (tbl!='audit_log') THEN
		execute format('DROP TRIGGER IF EXISTS %I ON %I', triggerName, tbl);
        execute format('CREATE TRIGGER %I
			AFTER INSERT OR UPDATE OR DELETE ON %I
			FOR EACH ROW EXECUTE FUNCTION audit_trigger_func();', triggerName, tbl);
    END IF;
end $$;

SELECT createAuditTrigger(TABLE_NAME) FROM information_schema.tables WHERE table_schema = 'public';

DROP TRIGGER IF EXISTS sample_status_trigger ON sample;
CREATE TRIGGER sample_status_trigger AFTER INSERT OR UPDATE OR DELETE ON sample FOR EACH ROW EXECUTE FUNCTION sample_status_trigger_func();