package app.majime.lims.specification;

import app.majime.lims.utils.StatusDeleted;
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

    Specification findById(Long id) {
        return specificationRepository.findById(id).get();
    }

    Optional<Material> findMaterialById(Long id) {
        return materialRepository.findById(id);
    }

    List<Specification> findByMaterialId(Long id) {
        return specificationRepository.findAll()
                .stream().filter(spec -> (spec.getMaterial().getId() == id)).collect(toList());
    }

    Specification create(Specification specification){
        specification.setDeleted(StatusDeleted.FALSE);
        specification.setStatus(SpecificationStatus.CREATED);
        specification.setConfirmed("F");
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
        throw new EntityNotFoundException("Not found material id = " + id);
    }

    Specification updateSpecificationStatus(Long id) throws EntityNotFoundException {
        Optional<Specification> specificationOptional = specificationRepository.findById(id);

        if (specificationOptional.isPresent()){
            Specification specification = specificationOptional.get();
            specification.setStatus(SpecificationStatus.EDITED);
            return specificationRepository.save(specification);
        }
        throw new EntityNotFoundException("Not found specification id = " + id);
    }

    Material updateMaterial(Long id, Material material) throws EntityNotFoundException {
        Optional<Material> materialOptional = materialRepository.findById(id);

        if (materialOptional.isPresent()){
            Material materialDb = materialOptional.get();
            materialDb.setName(material.getName());
            return materialRepository.save(materialDb);
        }
        throw new EntityNotFoundException("Not found material id = " + id);
    }

    Material deleteMaterial(Long id) throws EntityNotFoundException {
        Optional<Material> materialOptional = materialRepository.findById(id);

        if (materialOptional.isPresent()){
            Material materialDb = materialOptional.get();
            materialDb.setDeleted(StatusDeleted.TRUE);
            return materialRepository.save(materialDb);
        }
        throw new EntityNotFoundException("Not found material id = " + id);
    }

    Specification deleteSpecification(Long id) throws EntityNotFoundException {
        Optional<Specification> specificationOptional = specificationRepository.findById(id);

        if (specificationOptional.isPresent()){
            Specification specificationDb = specificationOptional.get();
            specificationDb.setDeleted(StatusDeleted.TRUE);
            return specificationRepository.save(specificationDb);
        }
        throw new EntityNotFoundException("Not found specification id = " + id);
    }

    Specification updateSpecification(Long id, SpecificationDto specificationDto) throws EntityNotFoundException {
        Optional<Specification> specificationOptional = specificationRepository.findById(id);

        if (specificationOptional.isEmpty()){
            throw new EntityNotFoundException("Not found specification id = " + id);
        }
        return specificationRepository.save(Specification.buildFrom(specificationDto));
    }


    boolean isExist(SpecificationDto specificationDto){
        return specificationRepository.findById(specificationDto.getId()).isPresent();
    }

    void deleteById(Long id) {
        specificationRepository.deleteById(id);
    }
}
