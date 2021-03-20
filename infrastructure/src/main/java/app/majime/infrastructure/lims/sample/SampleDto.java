package app.majime.infrastructure.lims.sample;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
class SampleDto {

    Long id;
    String sampleNo;
    int quantity;
    SampleStatus status;
}
