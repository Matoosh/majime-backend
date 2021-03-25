package app.majime.lims.batch;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class BatchService {

    private final BatchRepository batchRepository;

}
