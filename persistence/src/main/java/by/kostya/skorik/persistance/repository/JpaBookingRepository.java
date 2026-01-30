package by.kostya.skorik.persistance.repository;

import by.kostya.skorik.persistance.entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaBookingRepository extends JpaRepository<BookingEntity, UUID> {
}
