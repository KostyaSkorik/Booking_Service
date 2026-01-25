package by.kostya.skorik.service;

import by.kostya.skorik.domain.model.User;
import by.kostya.skorik.domain.repository.UserRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepositoryPort userRepositoryPort;


    @Override
    public User saveUser(User user) {
        Optional<User> optionalUser = userRepositoryPort.findByGoogleSub(user.getGoogleSub());

        if (optionalUser.isPresent()) {
            User getUser = optionalUser.get();
            getUser.setLastLogin(user.getLastLogin());
            return userRepositoryPort.save(getUser);
        } else {
            user.setId(UUID.randomUUID());
            return userRepositoryPort.save(user);
        }

    }
}
