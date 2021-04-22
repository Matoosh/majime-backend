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
public class SampleChart {
    @Id
    Long id;
    String type;
    SampleStatus status;
    Long count;

    SampleChartDto toDto(){
        return SampleChartDto.builder()
                //.id(id)
                .type(type)
                .status(status)
                .count(count)
                .build();
    }

    static SampleChart buildFrom(SampleChartDto dto){
        return builder()
                //.id(dto.getId())
                .type(dto.getType())
                .status(dto.getStatus())
                .count(dto.getCount())
                .build();
    }
}
