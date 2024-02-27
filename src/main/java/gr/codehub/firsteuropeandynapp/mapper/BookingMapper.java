package gr.codehub.firsteuropeandynapp.mapper;

import gr.codehub.firsteuropeandynapp.dto.BookingResponseDto;
import gr.codehub.firsteuropeandynapp.dto.CustomerDto;
import gr.codehub.firsteuropeandynapp.model.Booking;
import gr.codehub.firsteuropeandynapp.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;



@Mapper(componentModel = "spring")
public interface BookingMapper {
    @Mapping(source = "customer.id", target = "customerId")
    @Mapping(source = "room.id", target = "roomId")
    @Mapping(source = "customer.name", target = "customerName")
    BookingResponseDto bookingToBookingDto(Booking source);


    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "registrationDate", target = "registrationDate")
    @Mapping(source = "bookings", target = "bookings")
    CustomerDto customerToCustomerDto(Customer customer);

}
