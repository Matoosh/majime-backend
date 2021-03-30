package app.majime.lims.specification;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
class SpecificationService {

    private final SpecificationRepository specificationRepository;
    private final MaterialRepository materialRepository;

    List<Specification> findAll() {
        return specificationRepository.findAll();
    }

    List<Material> findAllMaterials() {
        return materialRepository.findAll();
    }

    Optional<Specification> findById(Long id) {
        return specificationRepository.findById(id);
    }

    Optional<Material> findMaterialById(Long id) {
        return materialRepository.findById(id);
    }

    List<Specification> findByMaterialId(Long id) {
        return specificationRepository.findAll()
                .stream().filter(spec -> (spec.getMaterial().getId() == id)).collect(toList());
    }

    Specification create(Specification specification){
        specification.setDeleted("false");
        specification.setStatus(SpecificationStatus.CREATED);
        return specificationRepository.save(specification);
    }

    Material createMaterial(Material material){
        return materialRepository.save(material);
    }

    Specification updateStatus(Long id) throws EntityNotFoundException {
        Optional<Specification> specificationOptional = specificationRepository.findById(id);

        if (specificationOptional.isPresent()){
            Specification specification = specificationOptional.get();
            return specificationRepository.save(specification);
        }

        throw new EntityNotFoundException("Not found Lab id = " + id);
    }

    Specification updateSpecificationStatus(Long id, SpecificationStatus newStatus) throws EntityNotFoundException {
        Optional<Specification> specificationOptional = specificationRepository.findById(id);

        if (specificationOptional.isPresent()){
            Specification specification = specificationOptional.get();
            specification.setStatus(newStatus);
            return specificationRepository.save(specification);
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
