package app.majime.infrastructure.lims.sample.services;

import app.majime.core.sample.Sample;
import app.majime.infrastructure.lims.sample.DTOs.SampleDTO;

public interface ISampleService {

    Iterable<SampleDTO> allSamples();

    SampleDTO createSample(SampleDTO newSampleDTO);

    Sample convertToEntity(SampleDTO newSampleDTO);

    boolean valid(SampleDTO newSampleDTO);
}
