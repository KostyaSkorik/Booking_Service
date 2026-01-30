package by.kostya.skorik.persistance.adapter;

import by.kostya.skorik.domain.model.Booking;
import by.kostya.skorik.domain.repository.BookingRepositoryPort;
import by.kostya.skorik.persistance.entity.BookingEntity;
import by.kostya.skorik.persistance.entity.CoworkingEntity;
import by.kostya.skorik.persistance.entity.UserEntity;
import by.kostya.skorik.persistance.mapper.BookingMapper;
import by.kostya.skorik.persistance.repository.JpaBookingRepository;
import by.kostya.skorik.persistance.repository.JpaCoworkingRepository;
import by.kostya.skorik.persistance.repository.JpaUserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BookingJpaAdapter implements BookingRepositoryPort {
    private final JpaBookingRepository jpaBookingRepository;
    private final JpaCoworkingRepository jpaCoworkingRepository;
    private final JpaUserRepository jpaUserRepository;

    private final BookingMapper bookingMapper;

    @Override
    public Booking save(Booking booking) {
        BookingEntity bookingEntity = bookingMapper.bookingToBookingEntity(booking);
        CoworkingEntity coworkingEntity = jpaCoworkingRepository.findById(booking.getCoworkingId())
                .orElseThrow(() -> new EntityNotFoundException("Coworking not found"));
        UserEntity userEntity = jpaUserRepository.findUserEntityByGoogleSub(booking.getUserSub())
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        bookingEntity.setCoworking(coworkingEntity);
        bookingEntity.setUserId(userEntity.getId());
        return bookingMapper.bookingEntityToBooking(jpaBookingRepository.save(bookingEntity));
    }
}
