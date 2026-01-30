package by.kostya.skorik.presentation.controller.in;

import by.kostya.skorik.presentation.dto.BookingDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface BookingController {

    @PostMapping("/save")
    ResponseEntity<BookingDto> save(@RequestBody BookingDto bookingDto);
}
