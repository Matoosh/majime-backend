package app.majime.lims.supplier;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

interface SupplierRepository extends JpaRepository<Supplier,Long> {
    Optional<Supplier> findById(Long id);
}
