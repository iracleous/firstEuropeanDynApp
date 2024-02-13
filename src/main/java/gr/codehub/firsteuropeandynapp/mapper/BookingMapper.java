package gr.codehub.firsteuropeandynapp.mapper;

import gr.codehub.firsteuropeandynapp.dto.BookingResponseDto;
import gr.codehub.firsteuropeandynapp.model.Booking;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;



@Mapper(componentModel = "spring")
public interface BookingMapper {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "customer.id", target = "customerId")
    BookingResponseDto bookingToBookingDto(Booking source);
}
