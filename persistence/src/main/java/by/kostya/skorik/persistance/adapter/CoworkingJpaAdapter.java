package by.kostya.skorik.persistance.adapter;

import by.kostya.skorik.domain.model.Coworking;
import by.kostya.skorik.domain.repository.CoworkingRepositoryPort;
import by.kostya.skorik.persistance.mapper.CoworkingMapper;
import by.kostya.skorik.persistance.repository.JpaCoworkingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class CoworkingJpaAdapter implements CoworkingRepositoryPort {
    private final JpaCoworkingRepository jpaCoworkingRepository;
    private final CoworkingMapper coworkingMapper;

    @Override
    public Coworking save(Coworking coworking) {
        return null;
    }

    @Override
    public Optional<Coworking> findByID(UUID id) {
        return Optional.empty();
    }

    @Override
    public List<Coworking> findAll() {
        return jpaCoworkingRepository.findAll()
                .stream()
                .map(coworkingMapper::coworkingEntityToCoworking)
                .collect(Collectors.toList());
    }
}
