package app.majime.lims.lab;

import app.majime.lims.address.AddressDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
class LabDto {

    Long id;
    String name;
    AddressDto address;
}
