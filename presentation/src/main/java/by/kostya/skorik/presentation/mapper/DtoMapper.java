package by.kostya.skorik.presentation.mapper;

import by.kostya.skorik.domain.model.Booking;
import by.kostya.skorik.domain.model.Coworking;
import by.kostya.skorik.presentation.dto.BookingDto;
import by.kostya.skorik.presentation.dto.CoworkingDto;
import by.kostya.skorik.presentation.dto.CoworkingProp;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class DtoMapper {

    @Autowired
    private CoworkingProp coworkingProp;

    @Mapping(target = "imageUrl", source = "imageKey", qualifiedByName = "buildFullUrl")
    public abstract CoworkingDto coworkingToDto(Coworking coworking);

    public abstract BookingDto bookingToBookingDto(Booking booking);
    public abstract Booking bookingDtoToBooking(BookingDto bookingDto);


    @Named("buildFullUrl")
    protected String buildFullUrl(String imageKey){
        if(imageKey == null || imageKey.isEmpty()){
            return null;
        }
        return String.format("%s%s/%s",
                coworkingProp.getImageUrl(),
                coworkingProp.getBucket(),
                imageKey);
    }
}
