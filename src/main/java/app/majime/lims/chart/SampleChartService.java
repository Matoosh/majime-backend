package app.majime.lims.chart;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class SampleChartService {

    private final SampleChartRepository repository;

    List<SampleChart> getSampleChart(){return repository.getSampleChart();}
}
