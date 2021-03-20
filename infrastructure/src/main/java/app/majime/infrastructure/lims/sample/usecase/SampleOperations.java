package app.majime.infrastructure.lims.sample.usecase;

import app.majime.infrastructure.lims.sampleLab.SampleLab;

public interface SampleOperations {

    void addSampleLab(SampleLab sampleLab);
    void removeSampleLab(SampleLab sampleLab);
}
