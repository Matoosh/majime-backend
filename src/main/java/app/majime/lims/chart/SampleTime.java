package app.majime.lims.chart;

import app.majime.lims.sample.SampleStatus;
import lombok.*;

import javax.persistence.*;

import static javax.persistence.EnumType.STRING;

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

    String type;

    @Enumerated(STRING)
    SampleStatus status;

    Integer year;
    Integer week;
    Integer count;
    Float avg;

    SampleTimeDto toDto(){
        return SampleTimeDto.builder()
                .type(type)
                .status(status)
                .year(year)
                .week(week)
                .count(count)
                .avg(avg)
                .build();
    }
}
