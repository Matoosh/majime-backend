package app.majime.lims.manufacturer;

import app.majime.lims.utils.StatusDeleted;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
class ManufacturerService {

    private final ManufacturerRepository repository;

    List<Manufacturer> findAll() {return repository.findAll();}

    Optional<Manufacturer> findById(Long id) {return repository.findById(id);}

    Manufacturer create(Manufacturer manufacturer){
        return repository.save(manufacturer);
    }

    Manufacturer updateStatus(Long id) throws EntityNotFoundException {
        Optional<Manufacturer> manufacturerOptional = repository.findById(id);

        if (manufacturerOptional.isPresent()){
            Manufacturer manufacturer = manufacturerOptional.get();
            return repository.save(manufacturer);
        }

        throw new EntityNotFoundException("Not found Manufacturer id = " + id);
    }

    Manufacturer updateManufacturer(Long id, ManufacturerDto dto) throws EntityNotFoundException {
        Optional<Manufacturer> manufacturerOptional = repository.findById(id);

        if (!manufacturerOptional.isPresent()) throw new EntityNotFoundException("Not found Manufacturer id = " + id);

        Manufacturer manufacturer = manufacturerOptional.get();
        manufacturer = manufacturer.buildFrom(dto);
        return repository.save(manufacturer);
    }

    boolean isExist(ManufacturerDto manufacturerDto){
        return repository.findById(manufacturerDto.getId()).isPresent();
    }

    void deleteById(Long id) throws EntityNotFoundException {
        Optional<Manufacturer> manufacturerOptional = repository.findById(id);

        if (manufacturerOptional.isPresent()){
            Manufacturer manufacturer = manufacturerOptional.get();
            manufacturer.setDeleted(StatusDeleted.TRUE);
            repository.save(manufacturer);
        }
        else throw new EntityNotFoundException("Not found Manufacturer id = " + id);
    }
}
