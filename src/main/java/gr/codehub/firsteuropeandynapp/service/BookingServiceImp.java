package gr.codehub.firsteuropeandynapp.service;

import gr.codehub.firsteuropeandynapp.dto.BookingDto;
import gr.codehub.firsteuropeandynapp.exceptions.MutableBookingException;
import gr.codehub.firsteuropeandynapp.model.Customer;
import gr.codehub.firsteuropeandynapp.model.Booking;
import gr.codehub.firsteuropeandynapp.model.Room;
import gr.codehub.firsteuropeandynapp.repository.CustomerRepository;
import gr.codehub.firsteuropeandynapp.repository.BookingRepository;
import gr.codehub.firsteuropeandynapp.repository.RoomRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookingServiceImp implements BookingService {
    private final CustomerRepository customerRepository;
    private final RoomRepository roomRepository;
    private final BookingRepository bookingRepository;

    @Override
    public Booking addBooking(BookingDto bookingDto) {
        Customer customer = customerRepository
                .findById(bookingDto.getCustomerId())
                .get();
        Room room = roomRepository
                .findById(bookingDto.getRoomId())
                .get();
        Booking booking = Booking
                .builder()
                .customer(customer)
                .room(room)
                .checkInDate(bookingDto.getCheckInDate())
                .checkOutDate(bookingDto.getCheckOutDate())
                .build();

//        Booking booking = new Booking();
//        booking.setCustomer(customer);
//        booking.setRoom(room);
//        booking.setCheckInDate(bookingDto.getCheckInDate());
//        booking.setCheckOutDate(bookingDto.getCheckOutDate());

        return create(booking);
    }


    public Booking create(Booking  booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public Booking delete(Long bookingId) {
        Optional<Booking> booking = bookingRepository.findById(bookingId);
        if (booking.isPresent()) {
            bookingRepository.delete(booking.get());
            return booking.get();
        }
        return null;
    }

    @Override
    public Booking read(Long bookingId) {
        Optional<Booking> booking = bookingRepository.findById(bookingId);
        return booking.get();
    }


    @Override
    public List<Booking> read() {
        return bookingRepository.findAll();
    }

    public Booking update(Long id, Booking newBooking) {
        throw new MutableBookingException("Bookings cannot be changed - you must cancel and create new");
    }

}
