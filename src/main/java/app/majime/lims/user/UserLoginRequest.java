package app.majime.lims.user;

import lombok.Getter;

@Getter
class UserLoginRequest {
    private String email;
    private String password;
}
