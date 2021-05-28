package app.majime.lims.batch;


import app.majime.lims.RestConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasAuthority('SAMPLE')")
    List<BatchDto> getAll() {
        return batchService.findAll().stream()
                .map(Batch::toDto)
                .collect(toList());
    }

    @GetMapping("/material/{id}")
    @PreAuthorize("hasAuthority('SAMPLE')")
    List<BatchDto> getByMaterialId(@PathVariable(value = "id") Long id) {
        List<Batch> batchList = batchService.findByMaterialId(id);
        return batchList.stream().map(Batch::toDto).collect(toList());
    }

    @PostMapping
    @PreAuthorize("hasAuthority('SAMPLE')")
    ResponseEntity<BatchDto> addNewBatch(@RequestBody BatchDto batchDto) {
        if (batchService.isExist(batchDto)) {
            return status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }

        return ok(batchService.create(Batch.buildFrom(batchDto)).toDto());
    }
}
