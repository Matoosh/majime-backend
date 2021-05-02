package app.majime.lims.role;

import org.springframework.data.jpa.repository.JpaRepository;

interface PermissionRepository extends JpaRepository<Permission, Long> {

}
