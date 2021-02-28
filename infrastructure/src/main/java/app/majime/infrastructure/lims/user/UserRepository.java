package app.majime.infrastructure.lims.user;

import app.majime.core.sample.Sample;
import app.majime.core.user.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User,Long> {
    Optional<User> findByEmail(String email);
}
