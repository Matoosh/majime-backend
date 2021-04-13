package app.majime.lims.user;

import app.majime.lims.RestConstants;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(RestConstants.APPLICATION_NAME + RestConstants.API_VERSION_1 + RestConstants.RESOURCE_USER)
class UserController {

    private final UserService userService;

    UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    List<User> getAll() {
        return userService.findAll();
    }

    @PostMapping("/signin")
    public String login(@RequestBody UserLoginRequest userLoginRequest) {
        return userService.signIn(userLoginRequest);
    }

    @PostMapping("/signup")
    public String register(@RequestBody UserDto user) {
        return userService.signUp(User.buildFrom(user));
    }

    @GetMapping("/refresh")
    public String refresh(HttpServletRequest req) {
        return userService.refresh(req.getRemoteUser());
    }
}
