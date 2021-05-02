package app.majime.lims.sampleLab;

import app.majime.lims.utils.StatusDeleted;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
class SampleLabService {
    private final SampleLabRepository repository;

    List<SampleLab> findAllBySample(Long id) {
        return repository.findAllBySampleId(id);
    }

    SampleLab create(SampleLab sampleLab) {
        sampleLab.setDeleted(StatusDeleted.FALSE);
        return repository.save(sampleLab);
    }

    SampleLab update(Long id, SampleLab sampleLab) {
        Optional<SampleLab> sampleLabFromDatabase = repository.findById(id);

        if(sampleLabFromDatabase.isEmpty()) {
            throw new EntityNotFoundException("Not found sampleLab id = " + id);
        }

        return repository.save(sampleLab);
    }
}
