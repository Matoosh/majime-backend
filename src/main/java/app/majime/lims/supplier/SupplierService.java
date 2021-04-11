package app.majime.lims.supplier;

import app.majime.lims.utils.StatusDeleted;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
class SupplierService {

    private final SupplierRepository repository;

    List<Supplier> findAll() {return repository.findAll();}

    Optional<Supplier> findById(Long id) {return repository.findById(id);}

    Supplier create(Supplier supplier){
        return repository.save(supplier);
    }

    Supplier updateStatus(Long id) throws EntityNotFoundException {
        Optional<Supplier> supplierOptional = repository.findById(id);

        if (supplierOptional.isPresent()){
            Supplier supplier = supplierOptional.get();
            return repository.save(supplier);
        }

        throw new EntityNotFoundException("Not found Supplier id = " + id);
    }

    Supplier updateSupplier(Long id, SupplierDto dto) throws EntityNotFoundException {
        Optional<Supplier> supplierOptional = repository.findById(id);

        if (!supplierOptional.isPresent()) throw new EntityNotFoundException("Not found Supplier id = " + id);

        Supplier supplier = supplierOptional.get();
        supplier = supplier.buildFrom(dto);
        return repository.save(supplier);
    }

    boolean isExist(SupplierDto supplierDto){
        return repository.findById(supplierDto.getId()).isPresent();
    }

    //void deleteById(Long id) {supplierRepository.deleteById(id);}
    void deleteById(Long id) throws EntityNotFoundException {
        Optional<Supplier> supplierOptional = repository.findById(id);

        if (supplierOptional.isPresent()){
            Supplier supplier = supplierOptional.get();
            supplier.setDeleted(StatusDeleted.TRUE);
            repository.save(supplier);
        }
        else throw new EntityNotFoundException("Not found Supplier id = " + id);
    }
}
