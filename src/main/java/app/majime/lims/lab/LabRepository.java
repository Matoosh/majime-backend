package app.majime.lims.lab;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

interface LabRepository extends JpaRepository<Lab,Long> {
    Optional<Lab> findById(Long id);
}
