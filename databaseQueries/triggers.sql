DROP TRIGGER address_audit_trigger ON address;
DROP TRIGGER batch_audit_trigger ON batch;
DROP TRIGGER certificate_audit_trigger ON certificate;
DROP TRIGGER dictionary_audit_trigger ON dictionary;
DROP TRIGGER lab_audit_trigger ON lab;
DROP TRIGGER manufacturer_audit_trigger ON manufacturer;
DROP TRIGGER material_audit_trigger ON material;
DROP TRIGGER out_of_spec_audit_trigger ON out_of_spec;
DROP TRIGGER parameter_audit_trigger ON parameter;
DROP TRIGGER permission_audit_trigger ON permission;
DROP TRIGGER result_audit_trigger ON result;
DROP TRIGGER result_status_history_audit_trigger ON result_status_history;
DROP TRIGGER role_audit_trigger ON role;
DROP TRIGGER role_permission_audit_trigger ON role_permission;
DROP TRIGGER sample_audit_trigger ON sample;
DROP TRIGGER sample_lab_audit_trigger ON sample_lab;
DROP TRIGGER sample_status_history_audit_trigger ON sample_status_history;
DROP TRIGGER specification_audit_trigger ON specification;
DROP TRIGGER specification_status_history_audit_trigger ON specification_status_history;
DROP TRIGGER supplier_audit_trigger ON supplier;
DROP TRIGGER unit_audit_trigger ON unit;

CREATE TRIGGER address_audit_trigger
    AFTER INSERT OR UPDATE OR DELETE ON address
    FOR EACH ROW EXECUTE FUNCTION audit_trigger_func();

CREATE TRIGGER batch_audit_trigger
    AFTER INSERT OR UPDATE OR DELETE ON batch
    FOR EACH ROW EXECUTE FUNCTION audit_trigger_func();

CREATE TRIGGER certificate_audit_trigger
    AFTER INSERT OR UPDATE OR DELETE ON certificate
    FOR EACH ROW EXECUTE FUNCTION audit_trigger_func();

CREATE TRIGGER dictionary_audit_trigger
    AFTER INSERT OR UPDATE OR DELETE ON dictionary
    FOR EACH ROW EXECUTE FUNCTION audit_trigger_func();

CREATE TRIGGER lab_audit_trigger
    AFTER INSERT OR UPDATE OR DELETE ON lab
    FOR EACH ROW EXECUTE FUNCTION audit_trigger_func();

CREATE TRIGGER manufacturer_audit_trigger
    AFTER INSERT OR UPDATE OR DELETE ON manufacturer
    FOR EACH ROW EXECUTE FUNCTION audit_trigger_func();

CREATE TRIGGER material_audit_trigger
    AFTER INSERT OR UPDATE OR DELETE ON material
    FOR EACH ROW EXECUTE FUNCTION audit_trigger_func();

CREATE TRIGGER out_of_spec_audit_trigger
    AFTER INSERT OR UPDATE OR DELETE ON out_of_spec
    FOR EACH ROW EXECUTE FUNCTION audit_trigger_func();

CREATE TRIGGER parameter_audit_trigger
    AFTER INSERT OR UPDATE OR DELETE ON parameter
    FOR EACH ROW EXECUTE FUNCTION audit_trigger_func();

CREATE TRIGGER permission_audit_trigger
    AFTER INSERT OR UPDATE OR DELETE ON permission
    FOR EACH ROW EXECUTE FUNCTION audit_trigger_func();

CREATE TRIGGER result_audit_trigger
    AFTER INSERT OR UPDATE OR DELETE ON result
    FOR EACH ROW EXECUTE FUNCTION audit_trigger_func();

CREATE TRIGGER result_status_history_audit_trigger
    AFTER INSERT OR UPDATE OR DELETE ON result_status_history
    FOR EACH ROW EXECUTE FUNCTION audit_trigger_func();

CREATE TRIGGER role_audit_trigger
    AFTER INSERT OR UPDATE OR DELETE ON role
    FOR EACH ROW EXECUTE FUNCTION audit_trigger_func();

CREATE TRIGGER role_permission_audit_trigger
    AFTER INSERT OR UPDATE OR DELETE ON role_permission
    FOR EACH ROW EXECUTE FUNCTION audit_trigger_func();

CREATE TRIGGER sample_audit_trigger
    AFTER INSERT OR UPDATE OR DELETE ON sample
    FOR EACH ROW EXECUTE FUNCTION audit_trigger_func();

CREATE TRIGGER sample_lab_audit_trigger
    AFTER INSERT OR UPDATE OR DELETE ON sample_lab
    FOR EACH ROW EXECUTE FUNCTION audit_trigger_func();

CREATE TRIGGER sample_status_history_audit_trigger
    AFTER INSERT OR UPDATE OR DELETE ON sample_status_history
    FOR EACH ROW EXECUTE FUNCTION audit_trigger_func();

CREATE TRIGGER specification_audit_trigger
    AFTER INSERT OR UPDATE OR DELETE ON specification
    FOR EACH ROW EXECUTE FUNCTION audit_trigger_func();

CREATE TRIGGER specification_status_history_audit_trigger
    AFTER INSERT OR UPDATE OR DELETE ON specification_status_history
    FOR EACH ROW EXECUTE FUNCTION audit_trigger_func();

CREATE TRIGGER supplier_audit_trigger
    AFTER INSERT OR UPDATE OR DELETE ON supplier
    FOR EACH ROW EXECUTE FUNCTION audit_trigger_func();

CREATE TRIGGER unit_audit_trigger
    AFTER INSERT OR UPDATE OR DELETE ON unit
    FOR EACH ROW EXECUTE FUNCTION audit_trigger_func();
