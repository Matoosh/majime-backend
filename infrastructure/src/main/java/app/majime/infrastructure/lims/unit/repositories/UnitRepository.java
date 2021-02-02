package app.majime.infrastructure.lims.unit.repositories;

import app.majime.core.unit.Unit;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UnitRepository extends CrudRepository<Unit,Long> {
    Optional<Unit> findByName(String name);
}
