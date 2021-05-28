package app.majime.lims.manufacturer;

import app.majime.lims.RestConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;
import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(RestConstants.APPLICATION_NAME + RestConstants.API_VERSION_1 + RestConstants.RESOURCE_MANUFACTURER)
@RequiredArgsConstructor
class ManufacturerController {

    private final ManufacturerService manufacturerService;

    @GetMapping
    List<ManufacturerDto> getAll() {
        return manufacturerService.findAll().stream()
                .map(Manufacturer::toDto)
                .collect(toList());
    }

    @GetMapping("/{id}")
    ResponseEntity<ManufacturerDto> getById(@PathVariable(value = "id") Long id) {
        Optional<Manufacturer> manufacturerOptional = manufacturerService.findById(id);
        if (manufacturerOptional.isPresent()) {
            return ok(manufacturerOptional.get().toDto());
        } else {
            return notFound().build();
        }
    }

    @PostMapping()
    ResponseEntity<ManufacturerDto> addNewManufacturer(@RequestBody ManufacturerDto dto) {
        return ok(manufacturerService.create(Manufacturer.buildFrom(dto)).toDto());
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable(value = "id") Long id) {
        manufacturerService.deleteById(id);}

    @PutMapping("/{id}")
    ResponseEntity<ManufacturerDto> updateManufacturer(@PathVariable(value = "id") Long id, @RequestBody ManufacturerDto manufacturerDto) {
        try{
            ManufacturerDto dto = manufacturerService.updateManufacturer(id, manufacturerDto).toDto();
            return ok(dto);
        } catch (EntityNotFoundException enfe) {
            return notFound().build();
        }
    }
    
}
