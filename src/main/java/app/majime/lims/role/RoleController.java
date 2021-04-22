package app.majime.lims.role;

import app.majime.lims.RestConstants;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(RestConstants.APPLICATION_NAME + RestConstants.API_VERSION_1 + RestConstants.RESOURCE_ROLE)
@PreAuthorize("hasAuthority('ADMIN_READ') || hasAuthority('ADMIN_WRITE')")
class RoleController {
    private final RoleService roleService;

    RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping()
    List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }


}
