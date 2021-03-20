package app.majime.lims.sample;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

interface SampleRepository extends JpaRepository<Sample, Long> {

    Optional<Sample> findBySampleNo(String sampleNumber);
}
