package app.majime.lims.batch;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BatchRepository extends CrudRepository<Batch,Long> {
    Optional<Batch> findById(Long id);
}
