package by.kostya.skorik.service;

import by.kostya.skorik.domain.model.Coworking;

import java.util.List;
import java.util.UUID;

public interface CoworkingService{
    Coworking registerNew(Coworking coworking);
    Coworking getById(UUID id) throws Exception;
    List<Coworking> getAllAvailable();
}
