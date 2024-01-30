package gr.codehub.firsteuropeandynapp.controller;

import gr.codehub.firsteuropeandynapp.dto.BookingDto;
import gr.codehub.firsteuropeandynapp.model.Booking;
import gr.codehub.firsteuropeandynapp.service.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("booking")
public class BookingController {
    private final BookingService bookingService;

    @PostMapping("")
    public Booking addBooking(@RequestBody BookingDto bookingDto) {
        return bookingService.addBooking(bookingDto);
    }

    @DeleteMapping("{bookingId}")
    public Booking cancelBooking(@PathVariable long bookingId) {
        return bookingService.delete(bookingId);
    }

    @GetMapping("{bookingId}")
    public Booking getBooking(@PathVariable long bookingId) {
        return bookingService.read(bookingId);
    }
}
