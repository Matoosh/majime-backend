package app.majime.infrastructure.lims.parameter.repositories;

import app.majime.core.parameter.Parameter;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ParameterRepository extends CrudRepository<Parameter,Long> {
    Optional<Parameter> findByName(String name);
}
