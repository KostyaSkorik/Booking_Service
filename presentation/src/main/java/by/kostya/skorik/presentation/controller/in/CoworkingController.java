package by.kostya.skorik.presentation.controller.in;

import by.kostya.skorik.presentation.dto.CoworkingDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface CoworkingController {

    @GetMapping("/all")
    ResponseEntity<List<CoworkingDto>> getCoworkings();

    @GetMapping("/get/{id}")
    ResponseEntity<CoworkingDto> getCoworkingById(@PathVariable(name = "id") String id);
}
