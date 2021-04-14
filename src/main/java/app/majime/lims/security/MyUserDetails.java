package app.majime.lims.security;

import app.majime.lims.user.User;
import app.majime.lims.user.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static java.lang.String.format;

@Service
public class MyUserDetails implements UserDetailsService {

    private final UserRepository userRepository;

    MyUserDetails(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByEmail(email);

        if (user.isEmpty()) {
            throw new UsernameNotFoundException(format("User s% not found", email));
        }

        return org.springframework.security.core.userdetails.User
                .withUsername(email)
                .password(user.get().getPassword())
                .authorities(user.get().getRole().getName())
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)
                .build();
    }
}
