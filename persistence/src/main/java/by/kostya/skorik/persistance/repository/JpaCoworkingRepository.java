package by.kostya.skorik.persistance.repository;

import by.kostya.skorik.persistance.entity.CoworkingEntity;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface JpaCoworkingRepository extends JpaRepository<CoworkingEntity, UUID> {
    Optional<CoworkingEntity> findById(UUID id);

}
