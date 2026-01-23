package by.kostya.skorik.presentation.controller.in;

import by.kostya.skorik.presentation.dto.CoworkingDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public interface CoworkingController {

    @GetMapping("/all")
    ResponseEntity<List<CoworkingDto>> getCoworkings();
}
