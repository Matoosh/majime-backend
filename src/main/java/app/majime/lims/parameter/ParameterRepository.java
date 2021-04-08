package app.majime.lims.parameter;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

interface ParameterRepository extends JpaRepository<Parameter,Long> {
    Optional<Parameter> findById(String id);
}
