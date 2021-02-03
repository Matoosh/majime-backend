package app.majime.infrastructure.lims.result.repositories;

import app.majime.core.result.Result;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ResultRepository extends CrudRepository<Result,Long>{
    Optional<Result> findByValue(String name);
}
