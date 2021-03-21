package app.majime.lims.sample;

import app.majime.lims.batch.BatchDTO;
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
    BatchDTO batch;

    String sampleNo;

    int quantity;

    SampleStatus status;
}
