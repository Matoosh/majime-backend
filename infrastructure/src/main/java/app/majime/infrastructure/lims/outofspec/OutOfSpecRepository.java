package app.majime.infrastructure.lims.outofspec;

import app.majime.core.outOfSpec.OutOfSpec;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface OutOfSpecRepository  extends CrudRepository<OutOfSpec,Long> {
    Optional<OutOfSpec> findByName(String name);
}


