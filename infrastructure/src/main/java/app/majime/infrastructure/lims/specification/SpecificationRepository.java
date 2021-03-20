package app.majime.infrastructure.lims.specification;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SpecificationRepository extends CrudRepository<Specification, Long> {
    Optional<Specification> findById(Long id);
}
