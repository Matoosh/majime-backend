package app.majime.lims.specification;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
class SpecificationService {

    private final SpecificationRepository specificationRepository;

    List<Specification> findAll() {
        return specificationRepository.findAll();
    }

    Optional<Specification> findById(Long id) {
        return specificationRepository.findById(id);
    }

    Specification create(Specification specification){
        return specificationRepository.save(specification);
    }

    Specification updateStatus(Long id) throws EntityNotFoundException {
        Optional<Specification> specificationOptional = specificationRepository.findById(id);

        if (specificationOptional.isPresent()){
            Specification specification = specificationOptional.get();
            return specificationRepository.save(specification);
        }

        throw new EntityNotFoundException("Not found Lab id = " + id);
    }

    Specification updateSpecification(Long id, SpecificationDto newSpecification) throws EntityNotFoundException {
        Optional<Specification> specificationOptional = specificationRepository.findById(id);

        if (specificationOptional.isPresent()){
            Specification oldSpecification = specificationOptional.get();
            oldSpecification.setName(newSpecification.getName());
            return specificationRepository.save(oldSpecification);
        }

        throw new EntityNotFoundException("Not found specification id = " + id);
    }

    boolean isExist(SpecificationDto specificationDto){
        return specificationRepository.findById(specificationDto.getId()).isPresent();
    }

    void deleteById(Long id) {
        specificationRepository.deleteById(id);
    }
}
