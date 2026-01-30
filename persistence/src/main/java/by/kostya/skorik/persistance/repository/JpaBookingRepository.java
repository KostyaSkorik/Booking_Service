package by.kostya.skorik.persistance.repository;

import by.kostya.skorik.persistance.entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.UUID;


public interface JpaBookingRepository extends JpaRepository<BookingEntity, UUID> {

    @Query("""
            SELECT COUNT(b) > 0 FROM BookingEntity b
                        WHERE b.coworking.id = ?1 AND ?2 < b.endTime AND ?3 > b.startTime
            """)
    boolean isExistIntersections(UUID coworkingId,
                                 LocalDateTime startTime,
                                 LocalDateTime endTime);
}
