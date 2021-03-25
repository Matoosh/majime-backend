package app.majime.lims.specification;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

interface MaterialRepository extends CrudRepository<Material, Long> {
    Optional<Material> findById(Long id);
}
