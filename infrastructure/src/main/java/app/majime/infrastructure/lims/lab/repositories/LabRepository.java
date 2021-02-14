package app.majime.infrastructure.lims.lab.repositories;

import app.majime.core.lab.Lab;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface LabRepository extends CrudRepository<Lab,Long> {
    Optional<Lab> findByName(String name);
}
