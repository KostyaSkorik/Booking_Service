package by.kostya.skorik.persistance.adapter;

import by.kostya.skorik.domain.model.User;
import by.kostya.skorik.domain.repository.UserRepositoryPort;
import by.kostya.skorik.persistance.entity.UserEntity;
import by.kostya.skorik.persistance.mapper.UserMapper;
import by.kostya.skorik.persistance.repository.JpaUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
@RequiredArgsConstructor
//адаптер соединяет интерфейс модуля в domain и реализации через Spring data Jpa
public class UserJpaAdapter implements UserRepositoryPort {

    private final JpaUserRepository jpaUserRepository;
    private final UserMapper userMapper;

    @Override
    public User save(User user) {
        UserEntity entity = userMapper.userToUserEntity(user);
        System.out.println("DEBUG: User ID to save: " + entity.getId());
        return userMapper.userEntityToUser(jpaUserRepository.save(entity));
    }

    @Override
    public Optional<User> findByGoogleSub(String googleSub) {
        Optional<UserEntity> optionalUserEntity = jpaUserRepository.findUserEntityByGoogleSub(googleSub);
        return optionalUserEntity.map(userMapper::userEntityToUser);
    }
}
