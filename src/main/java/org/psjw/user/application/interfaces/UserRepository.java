package org.psjw.user.application.interfaces;

import java.util.Optional;
import org.psjw.user.domain.User;

public interface UserRepository {

    User save(User user);
    Optional<User> findById(Long Id);
}
