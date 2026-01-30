package by.kostya.skorik.persistance.mapper;


import by.kostya.skorik.domain.model.Booking;
import by.kostya.skorik.persistance.entity.BookingEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookingMapper {

    @Mapping(target = "coworkingId", source = "coworking.id")
    Booking bookingEntityToBooking (BookingEntity bookingEntity);

    @Mapping(target = "version", ignore = true)
    BookingEntity bookingToBookingEntity(Booking booking);

}
