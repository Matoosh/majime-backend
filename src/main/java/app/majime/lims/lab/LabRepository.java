package app.majime.lims.lab;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

interface LabRepository extends CrudRepository<Lab,Long> {
    Optional<Lab> findById(Long id);
}
