package by.kostya.skorik.service.impl;

import by.kostya.skorik.domain.kafka.BookingNotificationPort;
import by.kostya.skorik.domain.model.Booking;
import by.kostya.skorik.domain.repository.BookingRepositoryPort;
import by.kostya.skorik.service.BookingService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.ExecutionException;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {
    private final BookingRepositoryPort bookingRepositoryPort;
    private final BookingNotificationPort bookingNotificationPort;

    @Override
    @Transactional
    public Booking save(Booking booking) {
        booking.setId(UUID.randomUUID());
        Booking savedBooking = bookingRepositoryPort.save(booking);
        try {
            bookingNotificationPort.sendBookingCreated(booking);
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException("Ошибка в отправке сообщения в топик");
        }
        return savedBooking;
    }
}
