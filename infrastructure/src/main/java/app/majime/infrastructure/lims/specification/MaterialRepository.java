package app.majime.infrastructure.lims.specification;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MaterialRepository extends CrudRepository<Material,Long>{
    Optional<Material> findByName(String name);

}


