package app.majime.lims.user;

import lombok.Getter;

@Getter
class UserAuthResponse {
    private final String token;

    UserAuthResponse(String token) {
        this.token = token;
    }
}
