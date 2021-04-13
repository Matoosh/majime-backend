package app.majime.lims.user;

import lombok.Getter;

@Getter
class UserLoginRequest {
    private String username;
    private String password;
}
