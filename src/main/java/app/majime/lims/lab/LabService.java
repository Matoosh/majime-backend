package app.majime.lims.lab;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
class LabService {

    private final LabRepository labRepository;

    List<Lab> findAll() {return labRepository.findAll();}

    Optional<Lab> findById(Long id) {return labRepository.findById(id);}

    Lab create(Lab lab){
        return labRepository.save(lab);
    }

    Lab updateStatus(Long id) throws EntityNotFoundException {
        Optional<Lab> labOptional = labRepository.findById(id);

        if (labOptional.isPresent()){
            Lab lab = labOptional.get();
            return labRepository.save(lab);
        }

        throw new EntityNotFoundException("Not found Lab id = " + id);
    }

    Lab updateLab(Long id, LabDto dto) throws EntityNotFoundException {
        Optional<Lab> labOptional = labRepository.findById(id);

        if (!labOptional.isPresent()) throw new EntityNotFoundException("Not found Lab id = " + id);

        Lab lab = labOptional.get();

        /*
        lab.setName(dto.getName());
        //lab.getAddress().setId(dto.getAddress().getId());
        lab.getAddress().setCity(dto.getAddress().getCity());
        lab.getAddress().setApartmentNumber(dto.getAddress().getApartmentNumber());
        lab.getAddress().setDistrict(dto.getAddress().getDistrict());
        lab.getAddress().setHouseNumber(dto.getAddress().getHouseNumber());
        lab.getAddress().setPostCode(dto.getAddress().getPostCode());
        lab.getAddress().setStreet(dto.getAddress().getStreet());
        lab.getAddress().setPostOffice(dto.getAddress().getPostOffice());
        lab.getAddress().setCountryCode(dto.getAddress().getCountryCode());
        */

        lab = lab.buildFrom(dto);
        return labRepository.save(lab);
    }

    boolean isExist(LabDto labDto){
        return labRepository.findById(labDto.getId()).isPresent();
    }

    //void deleteById(Long id) {labRepository.deleteById(id);}

    void deleteById(Long id) throws EntityNotFoundException {
        Optional<Lab> labOptional = labRepository.findById(id);

        if (labOptional.isPresent()){
            Lab lab = labOptional.get();
            lab.setDeleted("true");
            labRepository.save(lab);
        }
        else throw new EntityNotFoundException("Not found Lab id = " + id);
    }
}
