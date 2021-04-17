package app.majime.lims.sample;

import app.majime.lims.utils.StatusDeleted;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
class SampleService {

    private final SampleRepository sampleRepository;

    List<Sample> findAll() {
        return sampleRepository.findAll();
    }

    Optional<Sample> findById(Long id) {
        return sampleRepository.findById(id);
    }

    Sample create(Sample sample) {
        sample.setDeleted(StatusDeleted.FALSE);
        sample.setStatus(SampleStatus.CREATED);
        return sampleRepository.save(sample);
    }

    Sample updateSample(Long id, SampleDto dto) throws EntityNotFoundException {
        Optional<Sample> sampleOptional = sampleRepository.findById(id);

        if (!sampleOptional.isPresent()) throw new EntityNotFoundException("Not found Sample id = " + id);

        Sample sample = sampleOptional.get();
        sample = sample.buildFrom(dto);
        sample.setDeleted(StatusDeleted.FALSE);
        return sampleRepository.save(sample);
    }

    Sample updateStatus(Long id, SampleStatus newStatus) throws EntityNotFoundException {
        Optional<Sample> sampleOptional = sampleRepository.findById(id);

        if (sampleOptional.isPresent()) {
            Sample sample = sampleOptional.get();
            sample.setStatus(newStatus);
            return sampleRepository.save(sample);
        }

        throw new EntityNotFoundException("Not found Sample id = " + id);
    }

    Sample deleteSample(Long id) throws EntityNotFoundException {
        Optional<Sample> sampleOptional = sampleRepository.findById(id);

        if (sampleOptional.isPresent()){
            Sample sampleDb = sampleOptional.get();
            sampleDb.setDeleted(StatusDeleted.TRUE);
            return sampleRepository.save(sampleDb);
        }
        throw new EntityNotFoundException("Not found material id = " + id);
    }

    boolean isExist(SampleDto sampleDTO) {
        return sampleRepository.findBySampleNo(sampleDTO.getSampleNo()).isPresent();
    }

    void deleteById(Long id) {
        sampleRepository.deleteById(id);
    }
}
