package app.majime.lims.batch;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

interface BatchRepository extends JpaRepository<Batch,Long> {
    Optional<Batch> findByManufacturerBatchNo(String string);
}
