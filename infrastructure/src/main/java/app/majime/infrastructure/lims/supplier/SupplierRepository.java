package app.majime.infrastructure.lims.supplier;

import app.majime.core.supplier.Supplier;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SupplierRepository extends CrudRepository<Supplier,Long> {
    Optional<Supplier> findByName(String name);
}
