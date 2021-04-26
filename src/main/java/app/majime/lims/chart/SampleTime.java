package app.majime.lims.chart;

import app.majime.lims.sample.SampleStatus;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@Builder
class SampleTime {
    @Id
    Long id;
    String tekst;

    /*
    String type;
    SampleStatus status;
    Integer year;
    Integer week;
    Integer count;
    Integer avg;
    */


    SampleTimeDto toDto(){
        return SampleTimeDto.builder()
                .tekst(tekst)
                /*
                .type(type)
                .status(status)
                .year(year)
                .week(week)
                .count(count)
                .avg(avg)

                 */
                .build();
    }
}
