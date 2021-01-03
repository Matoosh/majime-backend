import app.majime.domain.entity.Sample;
import app.majime.usecase.port.SampleRepository;

import java.util.*;

public class SampleRepositoryDBO implements SampleRepository {

    private final Map<Long, Sample> inDb = new HashMap<>();

    @Override
    public Sample create(final Sample sample) {
        inDb.put(sample.getId(),sample);
        return sample;
    }

    @Override
    public Optional<Sample> findById(final Long id) {
        return Optional.ofNullable(inDb.get(id));
    }

    @Override
    public List<Sample> findAllSamples() {
        return new ArrayList<>(inDb.values());
    }
}
