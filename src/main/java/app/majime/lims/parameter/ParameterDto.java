package app.majime.lims.parameter;

import app.majime.lims.specification.SpecificationDto;
import app.majime.lims.utils.StatusDeleted;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ParameterDto {

    Long id;
    String name;
    String type;
    String border;
    String accuracy;
    String unit;
    StatusDeleted deleted;
    SpecificationDto specification;

}
