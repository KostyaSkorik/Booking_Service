package by.kostya.skorik.domain.repository;

import by.kostya.skorik.domain.model.User;

import java.util.Optional;

public interface UserRepositoryPort {
    User save(User user);
    Optional<User> findByGoogleSub(String googleSub);
}
