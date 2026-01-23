package by.kostya.skorik.service;

import by.kostya.skorik.domain.model.User;
import by.kostya.skorik.domain.repository.UserRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepositoryPort userRepositoryPort;


    @Override
    public User saveUser(User user) {
        return userRepositoryPort.save(user);
    }
}
