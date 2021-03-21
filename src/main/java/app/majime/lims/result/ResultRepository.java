package app.majime.lims.result;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

interface ResultRepository extends CrudRepository<Result,Long>{
    Optional<Result> findById(Long id);
}
