package app.majime.lims.user.dto;

import lombok.Getter;

@Getter
public class UserAuth {
    private final String token;

    public UserAuth(String token) {
        this.token = token;
    }
}
