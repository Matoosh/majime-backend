package app.majime.lims.sampleLab;

import app.majime.lims.sample.Sample;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

interface SampleLabRepository extends JpaRepository<SampleLab, Long> {
    List<SampleLab> findAllBySample(Sample sample);

    List<SampleLab> findAllBySampleId(Long id);
}
