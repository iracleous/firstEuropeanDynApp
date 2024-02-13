package gr.codehub.firsteuropeandynapp.service;

import gr.codehub.firsteuropeandynapp.dto.BookingRequestDto;
import gr.codehub.firsteuropeandynapp.dto.BookingResponseDto;
import gr.codehub.firsteuropeandynapp.dto.HotelApiResult;
import gr.codehub.firsteuropeandynapp.model.Booking;

import java.util.List;

public interface BookingService extends GeneralService<Booking, Long> {

    Booking createBooking(BookingRequestDto bookingRequestDto);

   BookingResponseDto createBookingResponseDto(BookingRequestDto bookingRequestDto);

    BookingResponseDto deleteBooking(long bookingId);

    HotelApiResult<BookingResponseDto> readBookingResponseDto(long bookingId);

    List<BookingResponseDto> readBookingResponseDto();

    List<BookingResponseDto> readBookingsByCustomerId(Long customerId);
    BookingResponseDto readBookingByCustomerId(Long customerId);
}
