package app.majime.lims.user;

import app.majime.lims.exception.CustomException;
import app.majime.lims.security.JwtTokenProvider;
import app.majime.lims.user.dto.UserAccess;
import app.majime.lims.user.dto.UserChangePasswordRequest;
import app.majime.lims.user.dto.UserWrite;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
class UserService {

    private final UserRepository userRepository;
//    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManager authenticationManager;

    UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtTokenProvider jwtTokenProvider, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
//        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
        this.authenticationManager = authenticationManager;
    }

    String signIn(UserAccess request) {
        Optional<User> user = userRepository.findByEmail(request.getEmail());
        if(user.isEmpty()) throw new CustomException("User doesn't exist!", HttpStatus.NOT_FOUND);
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
            return jwtTokenProvider.generateToken(request.getEmail(), user.get().getRoles());
        } catch (AuthenticationException e) {
            throw new CustomException("Invalid username/password supplied", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }


    User signUp(User user) {
        Optional<User> userFromDatabase = userRepository.findByEmail(user.getEmail());
        if (userFromDatabase.isEmpty()) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            return userRepository.save(user);
        } else {
            throw new CustomException("Username is already in use", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    List<User> findAll() {
        return userRepository.findAll();
    }

    String refresh(String remoteUser) {
        return jwtTokenProvider.generateToken(remoteUser, userRepository.findByEmail(remoteUser).get().getRoles());
    }


    User editUser(Long id, UserWrite user) {
        Optional<User> userFromDb = userRepository.findById(id);
        if(userFromDb.isEmpty()) throw new CustomException("Not found User in db", HttpStatus.UNPROCESSABLE_ENTITY);
        if(!userFromDb.get().getEmail().equals(user.getEmail())) throw new CustomException("Email change is disabled", HttpStatus.UNPROCESSABLE_ENTITY);
        User updatedUser = User.buildFrom(user);
        updatedUser.setId(id);
        return userRepository.save(updatedUser);
    }


    User resetPassword(String remotUser, UserChangePasswordRequest userChangePasswordRequest) {
        Optional<User> userFromDatabase = userRepository.findByEmail(remotUser);
        if(userFromDatabase.isEmpty() || !userChangePasswordRequest.getPassword().equals(userChangePasswordRequest.getConfirmPassword())) {
            throw new CustomException("Something went wrong during changing password.", HttpStatus.UNPROCESSABLE_ENTITY);
        }
        User updatedUser = userFromDatabase.get();
        updatedUser.setPassword(passwordEncoder.encode(userChangePasswordRequest.getPassword()));
        return userRepository.save(updatedUser);
    }
}
