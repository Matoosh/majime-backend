package app.majime.lims.sample;

import app.majime.lims.batch.BatchDto;
import app.majime.lims.specification.SpecificationDto;
import app.majime.lims.utils.StatusDeleted;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
class SampleDto {

    Long id;

    String name;

    LocalDateTime createdAt;

    @NonNull
    BatchDto batch;

    String sampleNo;

    int quantity;

    String type;

    SampleStatus status;

    StatusDeleted deleted;

    SpecificationDto specification;
}
