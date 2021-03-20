package app.majime.lims.address;

import app.majime.lims.RestConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping(RestConstants.APPLICATION_NAME + RestConstants.API_VERSION_1 + RestConstants.RESOURCE_ADDRESS)


public class AddressController {

    private AddressRepository repository;

    @Autowired
    public AddressController(AddressRepository addressRepository) {
        this.repository = addressRepository;
    }

    @GetMapping()
    public Iterable<Address> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> getById(@PathVariable(value = "id") Long id) {
        Optional<Address> address = repository.findById(id);
        if (address.isPresent()) {
            return ResponseEntity.ok(address.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    public ResponseEntity<Address> addNewAddress(@RequestBody Address newAddress) {
        Optional<Address> addressFromDb = repository.findById(newAddress.getId());
        if (addressFromDb.isPresent()) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }
        Address savedAddress = repository.save(newAddress);
        return ResponseEntity.ok(savedAddress);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException exc) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Address Not Found", exc);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Address> updateDeleted(@PathVariable(value = "id") Long id, @RequestBody Address newAddress) {
        Optional<Address> addressOptional = repository.findById(id);
        if (addressOptional.isPresent()) {
            Address address = addressOptional.get();
            address.setDeleted(newAddress.getDeleted());
            repository.save(address);
            return ResponseEntity.ok(address);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
