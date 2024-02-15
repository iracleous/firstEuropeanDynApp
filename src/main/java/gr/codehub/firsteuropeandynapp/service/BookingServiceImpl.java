package gr.codehub.firsteuropeandynapp.service;

import gr.codehub.firsteuropeandynapp.dto.BookingRequestDto;
import gr.codehub.firsteuropeandynapp.dto.BookingResponseDto;
import gr.codehub.firsteuropeandynapp.dto.HotelApiResult;
import gr.codehub.firsteuropeandynapp.exceptions.EntityException;
import gr.codehub.firsteuropeandynapp.exceptions.MutableBookingException;
import gr.codehub.firsteuropeandynapp.mapper.BookingMapper;
import gr.codehub.firsteuropeandynapp.metricservice.EventService;
import gr.codehub.firsteuropeandynapp.model.Customer;
import gr.codehub.firsteuropeandynapp.model.Booking;
import gr.codehub.firsteuropeandynapp.model.Room;
import gr.codehub.firsteuropeandynapp.repository.CustomerRepository;
import gr.codehub.firsteuropeandynapp.repository.BookingRepository;
import gr.codehub.firsteuropeandynapp.repository.RoomRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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
    private final EventService eventService;

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    public Booking createBooking(BookingRequestDto bookingRequestDto) {

        logger.trace("---------------tracing booking create event");
        logger.debug("---------------debugging booking create event");
        logger.info("---------------info booking create event");
        logger.warn("-----------------Warning in booking event ");
        logger.error("-----------------Error in booking event");

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
        Booking savedBooking = create(booking);
        return savedBooking;
    }

    @Override
    @CacheEvict(cacheNames = "bookingsCache", allEntries = true)
    public BookingResponseDto createBookingResponseDto(BookingRequestDto bookingRequestDto) {
        Booking savedBooking = createBooking(bookingRequestDto);
        return BookingResponseDto.createDto(savedBooking);
    }

    @Override
    @Cacheable(cacheNames = "bookingCache" , key="#bookingId")
    public HotelApiResult<BookingResponseDto> readBookingResponseDto(long bookingId) {
        logger.info("Entering readBookingResponseDto ");
        HotelApiResult hotelApiResult;

        eventService.processEvent();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


       try {
           var booking = read(bookingId);
           if (booking != null) {

               hotelApiResult = HotelApiResult.<BookingResponseDto>builder()
                       .data(bookingMapper.bookingToBookingDto(booking))
                       .message("")
                       .statusCode(0)
                       .build();
           }
           else hotelApiResult = HotelApiResult.<BookingResponseDto>builder()
                   .message("This book does not exist")
                   .statusCode(1)
                   .build();
       }
       catch(Exception e){
           hotelApiResult = HotelApiResult.<BookingResponseDto>builder()
                   .message("Exception occured "+e.getMessage())
                   .statusCode(5)
                   .build();
       }
        logger.info("ending readBookingResponseDto ");
        return hotelApiResult;
    }

    @Override
    @Cacheable("bookingsCache")
    public List<BookingResponseDto> readBookingResponseDto() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return read()
                .stream()
                .map(booking -> BookingResponseDto.createDto(booking))
                .collect(Collectors.toList());
    }

    @Override
    public List<BookingResponseDto> readBookingsByCustomerId(Long customerId) {
        return bookingRepository
                .getBookingsByCustomerId(customerId)
                .stream()
                .map(BookingResponseDto::createDto)
                .collect(Collectors.toList());
    }

    @Override
    public BookingResponseDto readBookingByCustomerId(Long customerId) {
        // TODO
        var result = bookingRepository.getBookingByCustomerId(customerId);
        return result.map(BookingResponseDto::createDto).orElse(null);
    }


    @Override
    @CacheEvict(cacheNames = {"bookingCache","bookingsCache"} , allEntries = true)
    public BookingResponseDto deleteBooking(long bookingId) {
        var booking = delete(bookingId);
        return BookingResponseDto.createDto(booking);
    }


    public Booking create(Booking booking) {
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
    public Booking read(Long bookingId) throws EntityException {


        try {
            Optional<Booking> booking = bookingRepository.findById(bookingId);
            if (booking.isPresent())
                return booking.get();
            return null;
        }
        catch(Exception ex){
            throw new EntityException("");
        }
    }


    @Override
    public List<Booking> read() {
        return bookingRepository.findAll();
    }

    public Booking update(Long id, Booking newBooking) {
        throw new MutableBookingException("Bookings cannot be changed - you must cancel and create new");
    }

}
