package app.majime.lims.lab;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
class LabDto {

    Long id;
    String name;
}
