package app.majime.lims.parameter;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UnitRepository extends CrudRepository<Unit,Long> {
    Optional<Unit> findById(Long id);
}
