package app.majime.lims.user.dto;

import lombok.Getter;

@Getter
public class UserChangePasswordRequest {
    String password;
    String confirmPassword;
}
