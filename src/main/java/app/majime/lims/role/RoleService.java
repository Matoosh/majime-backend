package app.majime.lims.role;

import app.majime.lims.utils.StatusDeleted;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class RoleService {
    private final RoleRepository roleRepository;

    RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
    List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    String create(Role role) {
        System.out.println(role.toString());
//        role.setDeleted(StatusDeleted.FALSE);
        roleRepository.save(role);
        return "Created";
    }

    String update(Role role) {
        return "Updated";
    }
}
