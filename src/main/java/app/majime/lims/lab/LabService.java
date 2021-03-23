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

    Lab updateLab(Long id, LabDto newLab) throws EntityNotFoundException {
        Optional<Lab> labOptional = labRepository.findById(id);

        if (labOptional.isPresent()){
            Lab oldLab = labOptional.get();
            oldLab.setName(newLab.getName());
            return labRepository.save(oldLab);
        }

        throw new EntityNotFoundException("Not found Lab id = " + id);
    }

    boolean isExist(LabDto labDto){
        return labRepository.findById(labDto.getId()).isPresent();
    }

    void deleteById(Long id) {labRepository.deleteById(id);}
}
