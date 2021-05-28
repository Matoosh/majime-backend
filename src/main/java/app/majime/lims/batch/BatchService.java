package app.majime.lims.batch;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
class BatchService {

    private final BatchRepository batchRepository;

    List<Batch> findAll() {
        return batchRepository.findAll();
    }

    Batch create(Batch batch) {
        batch.setDeleted("false");
        return batchRepository.save(batch);
    }

    List<Batch> findByMaterialId(Long id) {
        return batchRepository.findAll()
                .stream().filter(batch -> (batch.getMaterial().getId() == id)).collect(toList());
    }

    boolean isExist(BatchDto sampleDTO) {
        return batchRepository.findByManufacturerBatchNo(sampleDTO.getManufacturerBatchNo()).isPresent();
    }


}
