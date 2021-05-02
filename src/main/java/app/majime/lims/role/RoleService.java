package app.majime.lims.role;

import app.majime.lims.exception.CustomException;
import app.majime.lims.utils.StatusDeleted;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
class RoleService {
    private final RoleRepository roleRepository;

    RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
    List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    Role create(Role role) {
        Optional<Role> roleFromDatabase = roleRepository.findByName(role.getName());

        if (roleFromDatabase.isPresent()){
            throw new CustomException("Role already exists!", HttpStatus.UNPROCESSABLE_ENTITY);

        }

        return roleRepository.save(role);
    }

    Role update(Role role) {
        Optional<Role> roleFromDatabase = roleRepository.findById(role.getId());
        if(roleFromDatabase.isEmpty()) {
            throw new CustomException("Role doesn't exist!", HttpStatus.UNPROCESSABLE_ENTITY);
        }
        return roleRepository.save(role);

    }
}
