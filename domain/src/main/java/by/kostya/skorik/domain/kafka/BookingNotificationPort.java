package by.kostya.skorik.domain.kafka;

import by.kostya.skorik.domain.model.Booking;

import java.util.concurrent.ExecutionException;

public interface BookingNotificationPort {
    void sendBookingCreated(Booking booking) throws ExecutionException, InterruptedException;
}
