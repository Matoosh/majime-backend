package app.majime.core.user.usecase;

import app.majime.core.sample.Sample;

public interface UserOperations {

    void addSample(Sample sample);
    void removeSample(Sample sample);
}
