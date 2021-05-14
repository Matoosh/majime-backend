package app.majime.lims.specification;

import app.majime.lims.utils.StatusDeleted;
import app.majime.lims.utils.Type;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SpecificationDto {

    Long id;
    String specificationNo;
    String name;
    SpecificationStatus status;
    Type type;
    String unit;
    MaterialDto material;
    StatusDeleted deleted;

}
