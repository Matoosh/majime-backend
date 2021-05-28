package app.majime.lims.role;

import app.majime.lims.RestConstants;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(RestConstants.APPLICATION_NAME + RestConstants.API_VERSION_1 + RestConstants.RESOURCE_PERMISSION)
class PermissionController {
    private final PermissionService permissionService;

    PermissionController(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    @GetMapping()
    @PreAuthorize("hasAuthority('ADMIN')")
    List<Permission> getAllPermissions() {
        return permissionService.getAllPermissions();
    }
}
