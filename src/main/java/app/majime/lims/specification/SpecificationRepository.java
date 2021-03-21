package app.majime.lims.specification;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

interface SpecificationRepository extends CrudRepository<Specification, Long> {
    Optional<Specification> findById(Long id);
}
