package by.kostya.skorik.presentation.controller.impl;

import by.kostya.skorik.domain.model.Booking;
import by.kostya.skorik.presentation.controller.in.BookingController;
import by.kostya.skorik.presentation.dto.BookingDto;
import by.kostya.skorik.presentation.mapper.DtoMapper;
import by.kostya.skorik.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/booking/api")
@RequiredArgsConstructor
public class BookingControllerImpl implements BookingController {
    private final BookingService bookingService;
    private final DtoMapper dtoMapper;

    @Override
    public ResponseEntity<BookingDto> save(BookingDto bookingDto) {
        Booking booking = dtoMapper.bookingDtoToBooking(bookingDto);
        return ResponseEntity.ok(dtoMapper.bookingToBookingDto(bookingService.save(booking)));
    }
}
