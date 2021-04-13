package app.majime.lims.result;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

interface ResultRepository extends JpaRepository<Result,Long>{
    Optional<Result> findById(Long id);
}
