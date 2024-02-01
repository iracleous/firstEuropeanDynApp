package gr.codehub.firsteuropeandynapp.bootstrap;

import gr.codehub.firsteuropeandynapp.dto.BookingRequestDto;
import gr.codehub.firsteuropeandynapp.model.Booking;
import gr.codehub.firsteuropeandynapp.model.Customer;
import gr.codehub.firsteuropeandynapp.model.Room;
import gr.codehub.firsteuropeandynapp.service.GeneralService;
import gr.codehub.firsteuropeandynapp.service.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

@Component
@AllArgsConstructor
public class SampleContent implements CommandLineRunner {
    private final GeneralService<Room,Long> roomService;
    private final GeneralService<Customer,Long> customerService;
    private  final BookingService bookingService;
    @Override
    public void run(String... args) throws Exception {
        Customer customer1 = new Customer();
        customer1.setName("John Smith");
        customer1.setEmail("john.smith@johnsmith.com");
        customer1.setRegistrationDate(LocalDate.of(2024, Month.JANUARY, 22));
        customer1 = customerService.create(customer1);

        Customer customer2 = new Customer();
        customer2.setName("Anne Gray");
        customer2.setEmail("anne.gray@annegray.com");
        customer2.setRegistrationDate(LocalDate.of(2023, Month.DECEMBER, 12));
        customer2 = customerService.create(customer2);

        Room room1 = new Room();
        room1.setPrice(new BigDecimal("100.05"));
        room1.setName("A101");
        room1.setGuestCount(4);
        room1.setFloor(1);
        room1 = roomService.create(room1);

        BookingRequestDto booking1 = new BookingRequestDto();
        booking1.setCustomerId(customer1.getId());
        booking1.setRoomId(room1.getId());
        booking1.setCheckInDate(LocalDate.of(2024, Month.FEBRUARY, 21));
        booking1.setCheckOutDate(LocalDate.of(2024, Month.FEBRUARY, 24));
        bookingService.addBooking(booking1);

        Booking booking2 = new Booking();
        booking2.setCustomer(customer2);
        booking2.setRoom(room1);
        booking2.setCheckInDate(LocalDate.of(2024, Month.FEBRUARY, 26));
        booking2.setCheckOutDate(LocalDate.of(2024, Month.FEBRUARY, 28));
        bookingService.create(booking2);
    }
}
