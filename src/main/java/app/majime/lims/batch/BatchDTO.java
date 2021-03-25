package app.majime.lims.batch;

import app.majime.lims.specification.Material;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BatchDTO {
    Long id;
    String internalBatchNo;
    String manufacturerBatchNo;
    String deleted;
    Material material;
}
