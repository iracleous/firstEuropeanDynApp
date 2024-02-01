package gr.codehub.firsteuropeandynapp.service;

import gr.codehub.firsteuropeandynapp.dto.BookingRequestDto;
import gr.codehub.firsteuropeandynapp.dto.BookingResponseDto;
import gr.codehub.firsteuropeandynapp.model.Booking;

import java.util.List;
import java.util.Optional;

public interface BookingService extends GeneralService<Booking, Long> {
    BookingResponseDto addBooking(BookingRequestDto bookingRequestDto);

    BookingResponseDto deleteBooking(long bookingId);

    BookingResponseDto readBooking(long bookingId);

    List<BookingResponseDto> readBooking();

    List<BookingResponseDto> readBookingsByCustomerId(Long customerId);
    BookingResponseDto readBookingByCustomerId(Long customerId);
}
