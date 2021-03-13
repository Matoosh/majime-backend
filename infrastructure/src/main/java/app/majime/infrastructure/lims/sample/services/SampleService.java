package app.majime.infrastructure.lims.sample.services;

import app.majime.core.sample.Sample;
import app.majime.infrastructure.lims.sample.DTOs.SampleDTO;
import app.majime.infrastructure.lims.sample.SampleRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class SampleService implements ISampleService {
    private SampleRepository repository;
    private ModelMapper modelMapper;

    public SampleService(SampleRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Iterable<SampleDTO> allSamples() {
        Iterable<Sample> samples = repository.findAll();
        Iterable<SampleDTO> sampleDTOS =
                modelMapper.map(samples, new TypeToken<List<SampleDTO>>() {
                }.getType());
//        List<SampleDTO> sampleDTOS =
//                samples.stream().map(sample -> modelMapper.map(sample, SampleDTO.class)).collect(Collectors.toList());
        return sampleDTOS;
    }

    @Override
    public SampleDTO getById(Long id) throws NoSuchElementException {
        Optional<Sample> sample = repository.findById(id);
        SampleDTO sampleDTO = this.convertToDTO(sample.get());
        return sampleDTO;
    }

    @Override
    public SampleDTO createSample(SampleDTO newSampleDTO) {
        newSampleDTO.setStatus(Long.valueOf(1));
        Sample sample = this.convertToEntity(newSampleDTO);
        Sample sampleNew = repository.save(sample);
        newSampleDTO.setId(sampleNew.getId());
        return newSampleDTO;
    }

    @Override
    public SampleDTO updateStatus(Long id,Long newStatus) throws NoSuchElementException {
        Optional<Sample> sample = repository.findById(id);
        Sample sampleRepo = sample.get();
        sampleRepo.setStatus(Long.valueOf(newStatus));
        //TODO exception save to repo
        repository.save(sampleRepo);
        SampleDTO sampleDTO = this.convertToDTO(sampleRepo);
        return sampleDTO;
    }

    @Override
    public Sample convertToEntity(SampleDTO sampleDTO) {
        Sample sample = modelMapper.map(sampleDTO, Sample.class);
        return sample;
    }

    @Override
    public SampleDTO convertToDTO(Sample sample) {
        SampleDTO sampleDTO = modelMapper.map(sample, SampleDTO.class);
        return sampleDTO;
    }

    @Override
    public boolean isExist(SampleDTO sampleDTO) {
        Optional<Sample> sampleFromDb = repository.findBySampleNo(sampleDTO.getSampleNo());
        if (sampleFromDb.isPresent()) {
            return true;
        }
        return false;
    }
}
