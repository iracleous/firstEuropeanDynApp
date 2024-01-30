package gr.codehub.firsteuropeandynapp.service;

import gr.codehub.firsteuropeandynapp.dto.BookingDto;
import gr.codehub.firsteuropeandynapp.model.Customer;
import gr.codehub.firsteuropeandynapp.model.Booking;
import gr.codehub.firsteuropeandynapp.model.Room;
import gr.codehub.firsteuropeandynapp.repository.CustomerRepository;
import gr.codehub.firsteuropeandynapp.repository.BookingRepository;
import gr.codehub.firsteuropeandynapp.repository.RoomRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class BookingServiceImp implements BookingService{
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
        Booking booking =  Booking
                .builder()
                .customer(customer)
                .room(room)
                .startingDate(bookingDto.getStartingDate())
                .endingDate(bookingDto.getEndingDate())
                .build()
                ;

//        Booking booking = new Booking();
//        booking.setCustomer(customer);
//        booking.setRoom(room);
//        booking.setStartingDate(bookingDto.getStartingDate());
//        booking.setEndingDate(bookingDto.getEndingDate());

        bookingRepository.save(booking);
        return booking;
    }

    @Override
    public boolean cancelBooking(long bookingId) {
       Optional<Booking> booking = bookingRepository.findById(bookingId) ;
       if(booking.isPresent()){
            bookingRepository.delete(booking.get());
            return true;
       }
       return false;
    }

    @Override
    public Optional<Booking> getBooking(long bookingId){

        Optional<Booking> booking =  bookingRepository.findById(bookingId);

        return booking;
    }
}
