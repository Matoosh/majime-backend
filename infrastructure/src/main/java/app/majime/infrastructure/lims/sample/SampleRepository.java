package app.majime.infrastructure.lims.sample;

import app.majime.core.sample.Sample;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;

import java.util.Optional;

public interface SampleRepository extends CrudRepository<Sample,Long> {
    Optional<Sample> findBySampleNo(String sampleNumber);
}
