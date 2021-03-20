package app.majime.infrastructure.lims.specification;

import app.majime.core.specification.Specification;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SpecificationRepository extends CrudRepository<Specification, Long> {
    Optional<Specification> findByName(String name);
}
