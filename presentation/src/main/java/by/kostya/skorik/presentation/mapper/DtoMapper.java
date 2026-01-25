package by.kostya.skorik.presentation.mapper;

import by.kostya.skorik.domain.model.Coworking;
import by.kostya.skorik.presentation.dto.CoworkingDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DtoMapper {
    CoworkingDto coworkingToDto(Coworking coworking);
}
