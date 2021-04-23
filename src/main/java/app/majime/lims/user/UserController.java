package app.majime.lims.user;

import app.majime.lims.RestConstants;
import app.majime.lims.user.dto.UserAccess;
import app.majime.lims.user.dto.UserAuth;
import app.majime.lims.user.dto.UserWrite;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN_READ') || hasAuthority('ADMIN_WRITE')")
    public String editUser(@PathVariable(value = "id") Long id, @RequestBody UserWrite user) {
        return userService.editUser(id, user);
    }

    @PostMapping("/signin")
    public UserAuth login(@RequestBody UserAccess userLoginRequest) {
        return new UserAuth(userService.signIn(userLoginRequest));
    }

    @PostMapping("/signup")
    public String register(@RequestBody UserWrite user) {
        return userService.signUp(User.buildFrom(user));
    }

    @GetMapping("/refresh")
    public String refresh(HttpServletRequest req) {
        return userService.refresh(req.getRemoteUser());
    }

}
