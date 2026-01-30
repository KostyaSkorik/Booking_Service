package by.kostya.skorik.domain.repository;

import by.kostya.skorik.domain.model.Booking;

public interface BookingRepositoryPort {

    Booking save(Booking booking);
}
