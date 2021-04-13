package app.majime.lims.supplier;

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
@RequestMapping(RestConstants.APPLICATION_NAME + RestConstants.API_VERSION_1 + RestConstants.RESOURCE_SUPPLIER)
@RequiredArgsConstructor
class SupplierController {

    private final SupplierService supplierService;

    @GetMapping
    List<SupplierDto> getAll() {
        return supplierService.findAll().stream()
                .map(Supplier::toDto)
                .collect(toList());
    }

    @GetMapping("/{id}")
    ResponseEntity<SupplierDto> getById(@PathVariable(value = "id") Long id) {
        Optional<Supplier> supplierOptional = supplierService.findById(id);
        if (supplierOptional.isPresent()) {
            return ok(supplierOptional.get().toDto());
        } else {
            return notFound().build();
        }
    }

    @PostMapping()
    ResponseEntity<SupplierDto> addNewSupplier(@RequestBody SupplierDto dto) {
// Wyłączono weryfikację, bo front wymagał id, natomiast id jest nadawane automatycznie
//        if (supplierService.isExist(supplierDto)) {
//            return status(HttpStatus.UNPROCESSABLE_ENTITY).build();
//        }
        return ok(supplierService.create(Supplier.buildFrom(dto)).toDto());
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable(value = "id") Long id) {
        supplierService.deleteById(id);}

    @PutMapping("/{id}")
    ResponseEntity<SupplierDto> updateSupplier(@PathVariable(value = "id") Long id, @RequestBody SupplierDto supplierDto) {
        try{
            SupplierDto dto = supplierService.updateSupplier(id, supplierDto).toDto();
            return ok(dto);
        } catch (EntityNotFoundException enfe) {
            return notFound().build();
        }
    }
    
}
