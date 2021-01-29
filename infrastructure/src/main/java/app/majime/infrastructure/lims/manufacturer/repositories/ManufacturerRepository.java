package app.majime.infrastructure.lims.manufacturer.repositories;
import app.majime.core.manufacturer.Manufacturer;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

public interface ManufacturerRepository extends CrudRepository<Manufacturer,Long> {
    Optional<Manufacturer> findByManufacturerByName(String name);
}