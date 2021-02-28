package app.majime.infrastructure.lims.batch;

import app.majime.core.batch.Batch;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BatchRepository extends CrudRepository<Batch,Long> {
    Optional<Batch> findById(Long id);
}
