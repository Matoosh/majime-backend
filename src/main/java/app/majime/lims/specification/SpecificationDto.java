package app.majime.lims.specification;

import app.majime.lims.utils.StatusDeleted;
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
    String type;
    MaterialDto material;
    StatusDeleted deleted;

}
