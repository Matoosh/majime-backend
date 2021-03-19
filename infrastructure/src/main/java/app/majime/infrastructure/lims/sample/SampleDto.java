package app.majime.infrastructure.lims.sample;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
class SampleDto {

    private Long id;
    private String sampleNo;
    private int quantity;
    private SampleStatus status;
}
