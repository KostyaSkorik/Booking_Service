package by.kostya.skorik.presentation.controller.impl;

import by.kostya.skorik.presentation.controller.in.CoworkingController;
import by.kostya.skorik.presentation.dto.CoworkingDto;
import by.kostya.skorik.presentation.mapper.DtoMapper;
import by.kostya.skorik.service.CoworkingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("coworking/api")
@RequiredArgsConstructor
public class CoworkingControllerImpl implements CoworkingController {
    private final CoworkingService coworkingService;
    private final DtoMapper dtoMapper;




    @Override
    public ResponseEntity<List<CoworkingDto>> getCoworkings() {
        return ResponseEntity.ok(coworkingService.getAllAvailable()
                .stream()
                .map(dtoMapper::coworkingToDto).toList());
    }

    @Override
    public ResponseEntity<CoworkingDto> getCoworkingById(String id) {
        try {
            return ResponseEntity.ok(dtoMapper.coworkingToDto(coworkingService.getById(UUID.fromString(id))));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
