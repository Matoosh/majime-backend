package app.majime.lims.role;

import app.majime.lims.RestConstants;
import org.springframework.http.ResponseEntity;
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
    @PreAuthorize("hasAuthority('ADMIN')")
    List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }

    @PostMapping()
    @PreAuthorize("hasAuthority('ADMIN')")
    ResponseEntity<Role> createRole(@RequestBody Role role) {
        return ResponseEntity.ok(roleService.create(role));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    ResponseEntity<Role> updateRole(@PathVariable(value = "id") Long id, @RequestBody Role role) {
        return ResponseEntity.ok(roleService.update(role));
    }


}
