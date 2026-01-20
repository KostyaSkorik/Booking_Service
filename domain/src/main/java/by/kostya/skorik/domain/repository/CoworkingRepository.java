package by.kostya.skorik.domain.repository;

import by.kostya.skorik.domain.model.Coworking;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CoworkingRepository {
    Coworking save(Coworking coworking);
    Optional<Coworking> findByID(UUID id);
    List<Coworking> findAll(); //позже добавить пагинацию
}