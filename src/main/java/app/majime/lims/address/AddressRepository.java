package app.majime.lims.address;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AddressRepository extends CrudRepository<Address,Long> {
    Optional<Address> findById(Long id);
}
