package by.kostya.skorik.persistance.repository;

import by.kostya.skorik.persistance.entity.UserEntity;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;
public interface JpaUserRepository extends JpaRepository<UserEntity, UUID> {

    Optional<UserEntity> findUserEntityByGoogleSub(@NotNull String googleSub);
}
