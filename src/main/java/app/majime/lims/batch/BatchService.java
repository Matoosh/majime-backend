package app.majime.lims.batch;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class BatchService {

    private final BatchRepository batchRepository;

    List<Batch> findAll() {
        return batchRepository.findAll();
    }

//    Optional<Batch> findById(Long id) {
//        return batchRepository.findById(id);
//    }

    Batch create(Batch sample) {
        sample.setDeleted("false");
        return batchRepository.save(sample);
    }

    boolean isExist(BatchDto sampleDTO) {
        return batchRepository.findByManufacturerBatchNo(sampleDTO.getManufacturerBatchNo()).isPresent();
    }

}
