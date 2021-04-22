package app.majime.lims.chart;

import app.majime.lims.sample.SampleStatus;
import lombok.*;

@Getter
@Setter
@Builder
class SampleChartDto {
    String type;
    SampleStatus status;
    Long count;
}
