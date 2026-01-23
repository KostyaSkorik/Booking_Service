package by.kostya.skorik.persistance.mapper;

import by.kostya.skorik.domain.model.User;
import by.kostya.skorik.persistance.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserEntity userToUserEntity(User user);
    User userEntityToUser(UserEntity userEntity);
}
