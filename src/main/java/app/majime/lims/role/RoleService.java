package app.majime.lims.role;

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
}
