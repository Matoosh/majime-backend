package app.majime.lims.chart;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

interface SampleTimeRepository extends JpaRepository<SampleTime,Long> {
    String query = "SELECT ROW_NUMBER() OVER (ORDER BY sample_type ASC) AS id, sample_type AS type, " +
            "new_status AS status, dml_year AS year, dml_week AS week, COUNT(*) AS count, AVG(operation_time) AS avg  " +
            "FROM sample_status_log " +
            //"WHERE DATE_PART('day', AGE(CURRENT_TIMESTAMP, old_timestamp))<366 " +
            "WHERE DATE_PART('year',old_timestamp)=DATE_PART('year',CURRENT_TIMESTAMP) " +
            "GROUP BY new_status, sample_type, dml_year, dml_week ; ";
    @Query(value = query, nativeQuery = true)
    List<SampleTime> getSampleTime();
}
