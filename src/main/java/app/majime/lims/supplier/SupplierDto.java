package app.majime.lims.supplier;

import app.majime.lims.address.AddressDto;
import app.majime.lims.utils.StatusDeleted;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
class SupplierDto {

    Long id;
    String name;
    StatusDeleted deleted;
    AddressDto address;
}
