package app.majime.usecase.port;

import app.majime.domain.entity.Sample;

import java.util.List;
import java.util.Optional;

public interface SampleRepository {
    Sample create(Sample sample);

    Optional<Sample> findById(Long id);

    List<Sample> findAllSamples();
}
