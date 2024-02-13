package gr.codehub.firsteuropeandynapp.service;

import gr.codehub.firsteuropeandynapp.dto.BookingRequestDto;
import gr.codehub.firsteuropeandynapp.dto.BookingResponseDto;
import gr.codehub.firsteuropeandynapp.exceptions.MutableBookingException;
import gr.codehub.firsteuropeandynapp.mapper.BookingMapper;
import gr.codehub.firsteuropeandynapp.model.Customer;
import gr.codehub.firsteuropeandynapp.model.Booking;
import gr.codehub.firsteuropeandynapp.model.Room;
import gr.codehub.firsteuropeandynapp.repository.CustomerRepository;
import gr.codehub.firsteuropeandynapp.repository.BookingRepository;
import gr.codehub.firsteuropeandynapp.repository.RoomRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Primary
@AllArgsConstructor
public class BookingServiceImpl implements BookingService {
    private final CustomerRepository customerRepository;
    private final RoomRepository roomRepository;
    private final BookingRepository bookingRepository;
    private final BookingMapper bookingMapper;


    @Override
    public BookingResponseDto addBooking(BookingRequestDto bookingRequestDto) {
      try {
          Customer customer = customerRepository
                  .findById(bookingRequestDto.getCustomerId())
                  .get();
          Room room = roomRepository
                  .findById(bookingRequestDto.getRoomId())
                  .get();
          Booking booking = Booking
                  .builder()
                  .customer(customer)
                  .room(room)
                  .checkInDate(bookingRequestDto.getCheckInDate())
                  .checkOutDate(bookingRequestDto.getCheckOutDate())
                  .build();

          return bookingMapper.bookingToBookingDto(booking);
      }
      catch(Exception e){
          return null;
      }
    }

    @Override
    public BookingResponseDto readBooking(long bookingId) {
        var booking = read(bookingId);
        return BookingResponseDto.createDto(booking);
    }

    @Override
    public List<BookingResponseDto> readBooking() {
        return read()
                .stream()
                .map( booking -> bookingMapper.bookingToBookingDto(booking))
                .collect(Collectors.toList());
    }

    @Override
    public List<BookingResponseDto> readBookingsByCustomerId(Long customerId) {
        return bookingRepository
                .getBookingsByCustomerId(customerId)
                .stream()
                .map( booking ->bookingMapper.bookingToBookingDto(booking))
                .collect(Collectors.toList());
    }

    @Override
    public BookingResponseDto readBookingByCustomerId(Long customerId) {
//TODO
        var result = bookingRepository.getBookingByCustomerId(customerId);
        if (result.isEmpty())
            return null;
        return  BookingResponseDto.createDto(result.get() );
    }


    @Override
    public BookingResponseDto deleteBooking(long bookingId) {
        var booking = delete(bookingId);
        return bookingMapper.bookingToBookingDto(booking);
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
        if(booking.isPresent())
            return booking.get();
        return null;
    }


    @Override
    public List<Booking> read() {
        return bookingRepository.findAll();
    }

    public Booking update(Long id, Booking newBooking) {
        throw new MutableBookingException("Bookings cannot be changed - you must cancel and create new");
    }

}
