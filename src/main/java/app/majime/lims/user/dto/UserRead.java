package app.majime.lims.user.dto;

import app.majime.lims.user.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter
@Builder
public class UserRead {
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String phone;
    private String deleted;
    private Collection<Role> roles;
}
