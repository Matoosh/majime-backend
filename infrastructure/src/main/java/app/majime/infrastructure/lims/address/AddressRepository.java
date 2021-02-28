package app.majime.infrastructure.lims.address;

import app.majime.core.address.Address;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AddressRepository extends CrudRepository<Address,Long> {
    Optional<Address> findById(Long id);
}
