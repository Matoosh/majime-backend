package app.majime.lims.role;

import app.majime.lims.RestConstants;
import app.majime.lims.user.dto.UserWrite;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(RestConstants.APPLICATION_NAME + RestConstants.API_VERSION_1 + RestConstants.RESOURCE_ROLE)
class RoleController {
    private final RoleService roleService;

    RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping()
    @PreAuthorize("hasAuthority('ADMIN_READ') || hasAuthority('ADMIN_WRITE')")
    List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }

    @PostMapping()
    @PreAuthorize("hasAuthority('ADMIN_READ') || hasAuthority('ADMIN_WRITE')")
    String createRole(@RequestBody Role role) {
        return roleService.create(role);
    }

    @PutMapping()
    @PreAuthorize("hasAuthority('ADMIN_READ') || hasAuthority('ADMIN_WRITE')")
    String updateRole(@RequestBody Role role) {
        return roleService.update(role);
    }


}
