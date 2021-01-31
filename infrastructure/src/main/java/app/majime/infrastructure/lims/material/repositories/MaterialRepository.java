package app.majime.infrastructure.lims.material.repositories;

import app.majime.core.material.Material;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MaterialRepository extends CrudRepository<Material,Long>{
    Optional<Material> findByName(String name);

}


