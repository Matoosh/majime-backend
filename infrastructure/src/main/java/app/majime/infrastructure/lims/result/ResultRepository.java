package app.majime.infrastructure.lims.result;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ResultRepository extends CrudRepository<Result,Long>{
    Optional<Result> findById(Long id);
}
