package app.majime.lims.chart;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

interface SampleChartRepository extends JpaRepository<SampleChart,Long> {
    String query = "SELECT ROW_NUMBER() OVER (ORDER BY type ASC) AS id, type, status, COUNT(*) " +
            "FROM sample WHERE (status!='PRINTED')AND(status!='CANCELED') GROUP BY type, status;";
    @Query(value = query, nativeQuery = true)
    List<SampleChart> getSampleChart();
}
