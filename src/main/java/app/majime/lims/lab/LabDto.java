package app.majime.lims.lab;

import app.majime.lims.address.AddressDto;
import app.majime.lims.utils.StatusDeleted;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
class LabDto {

    Long id;
    String name;
    StatusDeleted deleted;
    AddressDto address;
}
