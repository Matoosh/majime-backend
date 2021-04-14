package app.majime.lims.user;

import app.majime.lims.exception.CustomException;
import app.majime.lims.security.JwtTokenProvider;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManager authenticationManager;

    UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtTokenProvider jwtTokenProvider, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
        this.authenticationManager = authenticationManager;
    }

    String signIn(UserLoginRequest request) {
        Optional<User> user = userRepository.findByEmail(request.getEmail());
        if(user.isEmpty()) throw new CustomException("User doesn't exist!", HttpStatus.NOT_FOUND);
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
            return jwtTokenProvider.generateToken(request.getEmail(), user.get().getRole());
        } catch (AuthenticationException e) {
            throw new CustomException("Invalid username/password supplied", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }


    String signUp(User user) {
        Optional<User> userFromDatabase = userRepository.findByUsername(user.getUsername());
        if (userFromDatabase.isEmpty()) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
            return jwtTokenProvider.generateToken(user.getEmail(), user.getRole());
        } else {
            throw new CustomException("Username is already in use", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    List<User> findAll() {
        return userRepository.findAll();
    }

    String refresh(String remoteUser) {
        return jwtTokenProvider.generateToken(remoteUser, userRepository.findByUsername(remoteUser).get().getRole());
    }
}
