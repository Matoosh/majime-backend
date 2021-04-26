package app.majime.lims.log;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

interface LogRepository extends JpaRepository<Log, Long> {
    List<Log> findByTabNameAndElement(String tab_name, Long element);

    //String query = "SELECT id, dml_created_by, dml_reason, old_row_data, new_row_data, dml_timestamp FROM audit_log WHERE tab_name = ?1 and element_id = ?2 ;";
    //@Query(value = query, nativeQuery = true)
    //List<Log> getLog(String tab_name, Long id);
}
