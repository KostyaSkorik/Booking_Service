package by.kostya.skorik.service.impl;

import by.kostya.skorik.domain.model.Coworking;
import by.kostya.skorik.domain.repository.CoworkingRepositoryPort;
import by.kostya.skorik.service.CoworkingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CoworkingServiceImpl implements CoworkingService {
    private final CoworkingRepositoryPort coworkingRepositoryPort;

    @Override
    public Coworking registerNew(Coworking coworking) {
        return null;
    }

    @Override
    public Coworking getById(UUID id) {
        return null;
    }

    @Override
    //добавить проверку на доступность коворкинга
    public List<Coworking> getAllAvailable() {
        return coworkingRepositoryPort.findAll();
    }
}
