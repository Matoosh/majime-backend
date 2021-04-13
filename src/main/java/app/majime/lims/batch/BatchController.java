package app.majime.lims.batch;


import app.majime.lims.RestConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping(RestConstants.APPLICATION_NAME + RestConstants.API_VERSION_1 + RestConstants.RESOURCE_BATCH)
@RequiredArgsConstructor
class BatchController {
    private final BatchService batchService;

    @GetMapping
    List<BatchDto> getAll() {
        return batchService.findAll().stream()
                .map(Batch::toDto)
                .collect(toList());
    }

//    @GetMapping("/{id}")
//    ResponseEntity<Batch> getById(@PathVariable(value = "id") Long id) {
//        Optional<Batch> batch = repository.findById(id);
//        if (batch.isPresent()) {
//            return ResponseEntity.ok(batch.get());
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }

    @GetMapping("/material/{id}")
    List<BatchDto> getByMaterialId(@PathVariable(value = "id") Long id) {
        List<Batch> batchList = batchService.findByMaterialId(id);
        return batchList.stream().map(Batch::toDto).collect(toList());
    }

    @PostMapping
    ResponseEntity<BatchDto> addNewBatch(@RequestBody BatchDto batchDto) {
        if (batchService.isExist(batchDto)) {
            return status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }

        return ok(batchService.create(Batch.buildFrom(batchDto)).toDto());
    }

//    @DeleteMapping("/{id}")
//    void delete(@PathVariable(value = "id") Long id) {
//        try {
//            repository.deleteById(id);
//        } catch (EmptyResultDataAccessException exc) {
//            throw new ResponseStatusException(
//                    HttpStatus.NOT_FOUND, "Batch Not Found", exc);
//        }
//    }
//
//    @PutMapping("/{id}")
//    ResponseEntity<Batch> updateDeleted(@PathVariable(value = "id") Long id, @RequestBody Batch newBatch) {
//        Optional<Batch> batchOptional = repository.findById(id);
//        if (batchOptional.isPresent()) {
//            Batch batch = batchOptional.get();
//            batch.setDeleted(newBatch.getDeleted());
//            repository.save(batch);
//            return ResponseEntity.ok(batch);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
}
