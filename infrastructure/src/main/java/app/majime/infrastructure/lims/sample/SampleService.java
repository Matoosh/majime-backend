package app.majime.infrastructure.lims.sample;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

import static app.majime.infrastructure.lims.sample.SampleStatus.NEW;

@Service
@RequiredArgsConstructor
class SampleService {

    private final SampleRepository sampleRepository;

    List<SampleNew> findAll() {
        return sampleRepository.findAll();
    }

    Optional<SampleNew> findById(Long id) {
        return sampleRepository.findById(id);
    }

    SampleNew create(SampleNew sampleNew) {
        sampleNew.setStatus(NEW);
        return sampleRepository.save(sampleNew);
    }

    SampleNew updateStatus(Long id, Long newStatus) throws EntityNotFoundException {
        Optional<SampleNew> sampleOptional = sampleRepository.findById(id);

        if (sampleOptional.isPresent()) {
            SampleNew sampleNew = sampleOptional.get();
            sampleNew.setStatus(SampleStatus.fromValue(newStatus));
            return sampleRepository.save(sampleNew);
        }

        throw new EntityNotFoundException("Not found SampleNew id = " + id);
    }

    boolean isExist(SampleDto sampleDTO) {
        return sampleRepository.findBySampleNo(sampleDTO.getSampleNo()).isPresent();
    }

    void deleteById(Long id) {
        sampleRepository.deleteById(id);
    }
}
