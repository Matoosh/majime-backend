package app.majime.infrastructure.lims.sample.services;

import app.majime.core.sample.Sample;
import app.majime.infrastructure.lims.sample.DTOs.SampleDTO;
import app.majime.infrastructure.lims.sample.SampleRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class SampleService implements ISampleService{
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
                modelMapper.map(samples, new TypeToken<List<SampleDTO>>() {}.getType());
//        List<SampleDTO> sampleDTOS =
//                samples.stream().map(sample -> modelMapper.map(sample, SampleDTO.class)).collect(Collectors.toList());
        return sampleDTOS;
    }

//    @Override
//    public ResponseEntity<Sample> addNewSample(Sample newSample){
//        Optional<Sample> sampleFromDb = repository.findBySampleNo(newSample.getSampleNo());
//        if(sampleFromDb.isPresent()) {
//            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
//        }
//        Sample savedSample = repository.save(newSample);
//        return ResponseEntity.ok(savedSample);
//    }

    @Override
    public SampleDTO createSample(SampleDTO newSampleDTO) {
        newSampleDTO.setStatus(Long.valueOf(1));
        Sample sample = this.convertToEntity(newSampleDTO);
        Sample sampleNew = repository.save(sample);
        newSampleDTO.setId(sampleNew.getId());
        return newSampleDTO;
    }

    @Override
    public Sample convertToEntity(SampleDTO sampleDTO) {
        Sample sample = modelMapper.map(sampleDTO, Sample.class);
        return sample;
    }

    @Override
    public boolean valid(SampleDTO sampleDTO) {
        Optional<Sample> sampleFromDb = repository.findBySampleNo(sampleDTO.getSampleNo());
        if(sampleFromDb.isPresent()) {
            return false;
        }
        return true;
    }
}
