package app.majime.lims.sampleLab;

import app.majime.lims.lab.LabDto;
import app.majime.lims.sample.SampleDto;
import app.majime.lims.utils.StatusDeleted;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
class SampleLabDto {
    Long id;
    StatusDeleted deleted;
    String createdBy;
    String reason;
    String quantity;
    SampleDto sample;
    LabDto lab;
}
