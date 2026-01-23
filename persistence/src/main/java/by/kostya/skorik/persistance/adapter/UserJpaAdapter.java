package by.kostya.skorik.persistance.adapter;

import by.kostya.skorik.domain.model.User;
import by.kostya.skorik.domain.repository.UserRepositoryPort;
import by.kostya.skorik.persistance.entity.UserEntity;
import by.kostya.skorik.persistance.mapper.UserMapper;
import by.kostya.skorik.persistance.repository.JpaUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;


@Repository
@RequiredArgsConstructor
//адаптер соединяет интерфейс модуля в domain и реализации через Spring data Jpa
public class UserJpaAdapter implements UserRepositoryPort {

    private final JpaUserRepository jpaUserRepository;
    private final UserMapper userMapper;

    @Override
    public User save(User user) {
        Optional<UserEntity> optionalFindUserEntity = jpaUserRepository.findUserEntityByGoogleSub(user.getGoogleSub());

        if(optionalFindUserEntity.isEmpty()){
            user.setId(UUID.randomUUID());
            //User -> UserEntity
            UserEntity preSave = userMapper.userToUserEntity(user);

            //save is DB
            UserEntity savedUserEntity = jpaUserRepository.save(preSave);

            //UserEntity -> User
            User savedUser = userMapper.userEntityToUser(savedUserEntity);
            return savedUser;
        }else {
            UserEntity findUserEntity = optionalFindUserEntity.get();
            findUserEntity.setLastLogin(LocalDateTime.now());
            return userMapper.userEntityToUser(jpaUserRepository.save(findUserEntity));
        }
    }
}
