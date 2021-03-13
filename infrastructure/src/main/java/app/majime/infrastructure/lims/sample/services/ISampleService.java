package app.majime.infrastructure.lims.sample.services;

import app.majime.core.sample.Sample;
import app.majime.infrastructure.lims.sample.DTOs.SampleDTO;

public interface ISampleService {

    Iterable<SampleDTO> allSamples();

    SampleDTO getById(Long id);

    SampleDTO createSample(SampleDTO newSampleDTO);

    SampleDTO updateStatus(Long id,Long newStatus);

    Sample convertToEntity(SampleDTO newSampleDTO);

    SampleDTO convertToDTO(Sample sample);

    boolean isExist(SampleDTO newSampleDTO);
}
