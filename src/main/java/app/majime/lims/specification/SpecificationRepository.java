package app.majime.lims.specification;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

interface SpecificationRepository extends JpaRepository<Specification, Long> {
    Optional<Specification> findById(Long id);
}
