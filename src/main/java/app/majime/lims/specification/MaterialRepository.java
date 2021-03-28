package app.majime.lims.specification;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

interface MaterialRepository extends JpaRepository<Material, Long> {
    Optional<Material> findById(Long id);
}
