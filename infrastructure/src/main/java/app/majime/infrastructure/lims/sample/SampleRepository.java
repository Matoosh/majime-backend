package app.majime.infrastructure.lims.sample;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

interface SampleRepository extends JpaRepository<SampleNew, Long> {

    Optional<SampleNew> findBySampleNo(String sampleNumber);
}
