package gr.codehub.firsteuropeandynapp.service;

import gr.codehub.firsteuropeandynapp.dto.BookingDto;
import gr.codehub.firsteuropeandynapp.model.Booking;

import java.sql.Date;
import java.util.Optional;

public interface BookingService {
    Booking addBooking(BookingDto bookingDto);
    boolean cancelBooking(long bookingId);
    Optional<Booking> getBooking(long bookingId);
}
