package app.majime.lims.parameter;

import app.majime.lims.result.Result;
import app.majime.lims.utils.StatusDeleted;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
class ParameterService {

    private final ParameterRepository parameterRepository;

    List<Parameter> findAll() {
        return parameterRepository.findAll();
    }

    Optional<Parameter> findById(Long id) {
        return parameterRepository.findById(id);
    }

    Parameter create(Parameter parameter){
        parameter.setDeleted(StatusDeleted.FALSE);
        return parameterRepository.save(parameter);
    }

    Parameter deleteParameter(Long id) throws EntityNotFoundException {
        Optional<Parameter> parameterOptional = parameterRepository.findById(id);

        if (parameterOptional.isPresent()){
            Parameter parameterDb = parameterOptional.get();
            parameterDb.setDeleted(StatusDeleted.TRUE);
            return parameterRepository.save(parameterDb);
        }
        throw new EntityNotFoundException("Not found parameter id = " + id);
    }

    Parameter updateParameter(Long id, ParameterDto parameterDto) throws EntityNotFoundException {
        Optional<Parameter> parameterOptional = parameterRepository.findById(id);

        if (parameterOptional.isEmpty()){
            throw new EntityNotFoundException("Not found parameter id = " + id);
        }
       return parameterRepository.save(Parameter.buildFrom(parameterDto));
    }

    List<Parameter> findBySpecificationId(Long id){
        return parameterRepository.findAll()
                .stream().filter(result -> (result.getSpecification().getId() == id))
                .collect(Collectors.toList());
    }
}
