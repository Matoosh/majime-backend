package app.majime.lims.chart;

import app.majime.lims.sample.SampleStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
class SampleTimeDto {
    String tekst;
    /*
    String type;
    SampleStatus status;
    Integer year;
    Integer week;
    Integer count;
    Integer avg;
     */
}
