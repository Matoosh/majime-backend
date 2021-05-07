package app.majime.lims.result;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

interface OutOfSpecRepository extends JpaRepository<OutOfSpec,Long> {
        Optional<OutOfSpec> findById(Long id);
}
