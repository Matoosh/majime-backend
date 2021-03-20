package app.majime.infrastructure.lims.supplier;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SupplierRepository extends CrudRepository<Supplier,Long> {
    Optional<Supplier> findByName(String name);
}
