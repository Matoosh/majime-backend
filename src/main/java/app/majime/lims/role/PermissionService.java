package app.majime.lims.role;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
class PermissionService {
    private final PermissionRepository permissionRepository;

    PermissionService(PermissionRepository permissionRepository) {
        this.permissionRepository = permissionRepository;
    }

    List<Permission> getAllPermissions() {
        return permissionRepository.findAll();
    }
}
