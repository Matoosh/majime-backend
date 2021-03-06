package app.majime.lims.user;

import app.majime.lims.RestConstants;
import app.majime.lims.user.dto.*;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static org.springframework.http.ResponseEntity.ok;


@RestController
@RequestMapping(RestConstants.APPLICATION_NAME + RestConstants.API_VERSION_1 + RestConstants.RESOURCE_USER)
class UserController {

    private final UserService userService;

    UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    @PreAuthorize("hasAuthority('ADMIN')")
    List<User> getAll() {
        return userService.findAll();
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<UserRead> editUser(@PathVariable(value = "id") Long id, @RequestBody UserWrite user) {
        return ResponseEntity.ok(User.toUserRead(userService.editUser(id, user)));
    }

    @PostMapping("/signin")
    public UserAuth login(@RequestBody UserAccess userLoginRequest) {
        return new UserAuth(userService.signIn(userLoginRequest));
    }

    @PostMapping("/signup")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<UserRead> register(@RequestBody UserWrite user) {
        return ResponseEntity.ok(User.toUserRead(userService.signUp(User.buildFrom(user))));
    }

    @PutMapping("/change-password")
    @PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<UserRead> resetPassword(HttpServletRequest req, @RequestBody UserChangePasswordRequest userChangePasswordRequest) {
        return ResponseEntity.ok(User.toUserRead(userService.resetPassword(req.getRemoteUser(), userChangePasswordRequest)));
    }

    @GetMapping("/refresh")
    @PreAuthorize("hasAuthority('USER')")
    public UserAuth refresh(HttpServletRequest req) {
        return new UserAuth(userService.refresh(req.getRemoteUser()));
    }

}
