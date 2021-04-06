package app.majime.lims.specification;

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
    // @TODO to be discussed, how to implement it on FE
    //String deleted

}
