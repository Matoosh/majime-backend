package app.majime.lims.address;

import app.majime.lims.RestConstants;
import app.majime.lims.lab.Lab;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;
import static org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping(RestConstants.APPLICATION_NAME + RestConstants.API_VERSION_1 + RestConstants.RESOURCE_ADDRESS)
@RequiredArgsConstructor
class AddressController {

    private final AddressService service;

    @GetMapping()
    @PreAuthorize("hasAuthority('LAB') || hasAuthority('MANUFACTURER') || hasAuthority('SUPPLIER')")
    List<AddressDto> getAll() {
        return service.findAll().stream().map(Address::toDto).collect(toList());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('LAB') || hasAuthority('MANUFACTURER') || hasAuthority('SUPPLIER')")
    ResponseEntity<Address> getById(@PathVariable(value = "id") Long id) {
        Optional<Address> address = service.findById(id);
        if (!address.isPresent()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(address.get());
    }

    @PostMapping()
    @PreAuthorize("hasAuthority('LAB') || hasAuthority('MANUFACTURER') || hasAuthority('SUPPLIER')")
    ResponseEntity<AddressDto> addNewAddress(@RequestBody AddressDto dto) {
        if (service.isExist(dto)) return status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        return ok(service.create(Address.buildFrom(dto)).toDto());
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('LAB') || hasAuthority('MANUFACTURER') || hasAuthority('SUPPLIER')")
    void delete(@PathVariable(value = "id") Long id) {service.deleteById(id);};

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('LAB') || hasAuthority('MANUFACTURER') || hasAuthority('SUPPLIER')")
    ResponseEntity<AddressDto> updateAddress(@PathVariable(value = "id") Long id, @RequestBody AddressDto addressDto) {
        try {
            AddressDto dto = service.updateAddress(id, addressDto).toDto();
            return ok(dto);
        } catch (EntityNotFoundException enfe) {
            return notFound().build();
        }
    }
}
