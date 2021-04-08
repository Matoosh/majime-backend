package app.majime.lims.parameter;

import app.majime.lims.utils.StatusDeleted;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

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

        if (!parameterOptional.isPresent()){
            throw new EntityNotFoundException("Not found specification id = " + id);
        }
        Parameter parameter = parameterOptional.get();
        parameter = parameter.buildFrom(parameterDto);
        return parameterRepository.save(parameter);
    }
}