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
    // TODO pomyslec czy potrzebne - tak, rozmawiałem z Wojtkiem /msk
    // MaterialDto material;

}
