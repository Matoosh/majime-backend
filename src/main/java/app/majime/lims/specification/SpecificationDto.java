package app.majime.lims.specification;

import app.majime.lims.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
class SpecificationDto {

    Long id;
    String specificationNo;
    String name;
    SpecificationStatus status;
    String type;
    Material material;

}
