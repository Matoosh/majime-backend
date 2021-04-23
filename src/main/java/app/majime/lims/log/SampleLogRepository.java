package app.majime.lims.log;

import app.majime.lims.address.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

interface SampleLogRepository extends JpaRepository<SampleLog, Long> {
    List<SampleLog> findByTabNameAndElement(String tab_name, Long element);

    //String query = "SELECT id, dml_created_by, dml_reason, old_row_data, new_row_data, dml_timestamp FROM audit_log WHERE tab_name = ?1 and element_id = ?2 ;";
    //@Query(value = query, nativeQuery = true)
    //List<SampleLog> getSampleLog(String tab_name, Long id);
}
