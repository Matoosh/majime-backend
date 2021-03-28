package app.majime.lims.batch;

import app.majime.lims.specification.MaterialDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BatchDto {
    Long id;
    String internalBatchNo;
    String manufacturerBatchNo;
    String deleted;
    MaterialDto material;

}
