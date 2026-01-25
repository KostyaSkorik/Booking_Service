package by.kostya.skorik.persistance.mapper;

import by.kostya.skorik.domain.model.Coworking;
import by.kostya.skorik.persistance.entity.CoworkingEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CoworkingMapper {

    CoworkingEntity coworkingToCoworkingEntity(Coworking coworking);
    Coworking coworkingEntityToCoworking(CoworkingEntity coworkingEntity);
}
