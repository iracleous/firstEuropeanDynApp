package gr.codehub.firsteuropeandynapp.controller;

import gr.codehub.firsteuropeandynapp.dto.BookingRequestDto;
import gr.codehub.firsteuropeandynapp.dto.BookingResponseDto;
import gr.codehub.firsteuropeandynapp.dto.HotelApiResult;
import gr.codehub.firsteuropeandynapp.service.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/booking")
public class BookingController {
    private final BookingService bookingService;

    @PostMapping("")
    public BookingResponseDto addBooking(@RequestBody BookingRequestDto bookingRequestDto) {
        return bookingService.createBookingResponseDto(bookingRequestDto);
    }

    @DeleteMapping("/{bookingId}")
    public BookingResponseDto cancelBooking(@PathVariable long bookingId) {
        return bookingService.deleteBooking(bookingId);
    }

    @GetMapping("/{bookingId}")
    public HotelApiResult<BookingResponseDto> getBooking(@PathVariable long bookingId) {
        long startTime = System.currentTimeMillis();
        HotelApiResult<BookingResponseDto> result = bookingService.readBookingResponseDto(bookingId);
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        result.setMessage("The elapsed time is "+elapsedTime);
        return result;
    }

    @GetMapping("")
    public HotelApiResult<List<BookingResponseDto>> getBookingResponseDto() {

        long startTime = System.currentTimeMillis();
        List<BookingResponseDto> bookings = bookingService.readBookingResponseDto();
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        HotelApiResult<List<BookingResponseDto>> result= new HotelApiResult<>();
        result.setData(bookings);
        result.setMessage("The elapsed time is "+elapsedTime);

        return result;
    }

    @GetMapping("/customer/{customerId}")
    public List<BookingResponseDto> getBookingsByCustomerId(@PathVariable Long customerId) {
        return bookingService.readBookingsByCustomerId(customerId);
    }

    @GetMapping("/customerAny/{customerId}")
    public BookingResponseDto getBookingByCustomerId(@PathVariable Long customerId) {
        return bookingService.readBookingByCustomerId(customerId);
    }
}
