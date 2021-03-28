package app.majime.lims.specification;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MaterialDto {
    Long id;
    String name;
    String deleted;
}
