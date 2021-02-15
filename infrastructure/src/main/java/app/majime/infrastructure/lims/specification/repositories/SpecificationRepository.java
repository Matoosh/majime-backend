package app.majime.infrastructure.lims.specification.repositories;

import app.majime.core.specification.Specification;
import org.springframework.data.repository.CrudRepository;

public interface SpecificationRepository extends CrudRepository<Specification, Long> {
}
