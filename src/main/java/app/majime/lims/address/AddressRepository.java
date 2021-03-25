package app.majime.lims.address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

interface AddressRepository extends JpaRepository<Address,Long> {
    Optional<Address> findById(Long id);
}
