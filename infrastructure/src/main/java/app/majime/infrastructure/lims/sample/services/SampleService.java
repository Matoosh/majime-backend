package app.majime.infrastructure.lims.sample.services;

import app.majime.core.sample.Sample;
import app.majime.infrastructure.lims.sample.DTOs.SampleDTO;
import app.majime.infrastructure.lims.sample.SampleRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class SampleService implements ISampleService{
    private HashMap<Long, Sample> sampleMap;
    private SampleRepository repository;
    private ModelMapper modelMapper;

    public SampleService(SampleRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Iterable<SampleDTO> allSamples() {
        List<Sample> samples = (List<Sample>) repository.findAll();
        Iterable<SampleDTO> sampleDTOS =
                modelMapper.map(samples, new TypeToken<List<SampleDTO>>() {}.getType());
//        List<SampleDTO> sampleDTOS =
//                samples.stream().map(sample -> modelMapper.map(sample, SampleDTO.class)).collect(Collectors.toList());
        return sampleDTOS;
    }
}
