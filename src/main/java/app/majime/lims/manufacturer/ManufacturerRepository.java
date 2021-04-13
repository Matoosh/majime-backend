package app.majime.lims.manufacturer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

interface ManufacturerRepository extends JpaRepository<Manufacturer,Long> {
    Optional<Manufacturer> findById(Long id);
}
