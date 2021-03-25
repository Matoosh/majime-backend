package app.majime.lims.address;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
class AddressService {

    private final AddressRepository addressRepository;

    List<Address> findAll() {return addressRepository.findAll();}

    Address create(Address address) {return addressRepository.save(address);}

    Optional<Address> findById(Long id) {return addressRepository.findById(id);}

    Address updateAddress(Long id, AddressDto addressDto) throws EntityNotFoundException {
        Optional<Address> addressOptional = addressRepository.findById(id);

        if (!addressOptional.isPresent()) throw new EntityNotFoundException("Nod found Address id = " +id);

        Address address = addressOptional.get();
        //address.setApartmentNumber(addressDto.getApartmentNumber());
        address.buildFrom(addressDto);
        return addressRepository.save(address);
    }

    boolean isExist(AddressDto addressDto) {return addressRepository.findById(addressDto.getId()).isPresent();}

    void deleteById(Long id) throws EntityNotFoundException {
        Optional<Address> addressOptional = addressRepository.findById(id);

        if (!addressOptional.isPresent()) throw new EntityNotFoundException("Nod found Address id = " +id);

        Address address = addressOptional.get();
        address.setDeleted("true");
        addressRepository.save(address);
    }
}
