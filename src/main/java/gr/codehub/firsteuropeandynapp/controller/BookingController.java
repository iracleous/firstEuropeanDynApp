package gr.codehub.firsteuropeandynapp.controller;

import gr.codehub.firsteuropeandynapp.dto.BookingRequestDto;
import gr.codehub.firsteuropeandynapp.dto.BookingResponseDto;
import gr.codehub.firsteuropeandynapp.model.Booking;
import gr.codehub.firsteuropeandynapp.service.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("booking")
public class BookingController {
    private final BookingService bookingService;

    @PostMapping("")
    public BookingResponseDto addBooking(@RequestBody BookingRequestDto bookingRequestDto) {
        return bookingService.addBooking(bookingRequestDto);
    }

    @DeleteMapping("{bookingId}")
    public BookingResponseDto cancelBooking(@PathVariable long bookingId) {
        return bookingService.deleteBooking(bookingId);
    }

    @GetMapping("{bookingId}")
    public BookingResponseDto getBooking(@PathVariable long bookingId) {
        return bookingService.readBooking(bookingId);
    }

    @GetMapping("all")
    public List<BookingResponseDto> getBooking() {
        return bookingService.readBooking();
    }

    @GetMapping("all2")
    public List<Booking> getBooking2() {
        return bookingService.read();
    }

}
