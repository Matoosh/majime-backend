package app.majime.lims.sample;

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
        sample.setStatus(SampleStatus.CREATED);
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

    boolean isExist(SampleDto sampleDTO) {
        return sampleRepository.findBySampleNo(sampleDTO.getSampleNo()).isPresent();
    }

    void deleteById(Long id) {
        sampleRepository.deleteById(id);
    }
}
