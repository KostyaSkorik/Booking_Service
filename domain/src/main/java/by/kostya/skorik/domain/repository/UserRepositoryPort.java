package by.kostya.skorik.domain.repository;

import by.kostya.skorik.domain.model.User;

public interface UserRepositoryPort {
    User save(User user);
}
