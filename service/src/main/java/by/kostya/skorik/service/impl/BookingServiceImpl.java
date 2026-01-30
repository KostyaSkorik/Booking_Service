package by.kostya.skorik.service.impl;

import by.kostya.skorik.domain.model.Booking;
import by.kostya.skorik.domain.repository.BookingRepositoryPort;
import by.kostya.skorik.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {
    private final BookingRepositoryPort bookingRepositoryPort;

    @Override
    public Booking save(Booking booking) {
        booking.setId(UUID.randomUUID());
        return bookingRepositoryPort.save(booking);
    }
}
