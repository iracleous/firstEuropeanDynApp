package gr.codehub.firsteuropeandynapp.bootstrap;

import gr.codehub.firsteuropeandynapp.dto.BookingRequestDto;
import gr.codehub.firsteuropeandynapp.model.Booking;
import gr.codehub.firsteuropeandynapp.model.Customer;
import gr.codehub.firsteuropeandynapp.model.Room;
import gr.codehub.firsteuropeandynapp.service.CustomerService;
import gr.codehub.firsteuropeandynapp.service.GeneralService;
import gr.codehub.firsteuropeandynapp.service.BookingService;
import gr.codehub.firsteuropeandynapp.service.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

@Component
@AllArgsConstructor
public class SampleContent implements CommandLineRunner {
    private final RoomService roomService;
    private final CustomerService customerService;
    private  final BookingService bookingService;
    @Override
    public void run(String... args) throws Exception {
        Customer customer1 = createCustomer("John Smith", "john.smith@johnsmith.com", "2024-01-13");
        Customer customer2 = createCustomer("Anne Gray", "anne.gray@annegray.com", "2023-11-17");
        Customer customer3 = createCustomer("Bill Stevens", "bill.stevens01@williamstevens.com", "2024-02-02");

        Room room1 = createRoom("A101", "99.90", 4, 1);
        Room room2 = createRoom("A103", "88.00", 3, 1);
        Room room3 = createRoom("B208", "79.90", 2, 2);
        Room room4 = createRoom("C311", "49.90", 2, 3);
        Room room5 = createRoom("Junior Suite", "250.00", 6, 5);

        createBookingDto(customer1, room1, "2024-02-21", "2024-02-25");
        createBookingDto(customer2, room3, "2024-02-27", "2024-03-11");
        createBookingDto(customer2, room2, "2024-02-27", "2024-03-11");
        createBookingDto(customer3, room4, "2024-02-11", "2024-02-24");
        createBookingDto(customer1, room5, "2024-04-07", "2024-04-09");
        createBookingDto(customer2, room4, "2024-02-25", "2024-03-04");

        createBookingDto(customer3, room1, "2025-01-01", "2025-01-02");
        createBookingDto(customer3, room2, "2025-01-01", "2025-01-02");
        createBookingDto(customer3, room4, "2025-01-01", "2025-01-02");
        createBookingDto(customer3, room5, "2025-01-01", "2025-01-02");

    }

    private Booking createBookingDto(Customer customer, Room room, String checkInDate, String checkOutDate) {
        BookingRequestDto booking = new BookingRequestDto();
        booking.setCustomerId(customer.getId());
        booking.setRoomId(room.getId());
        booking.setCheckInDate(LocalDate.parse(checkInDate));
        booking.setCheckOutDate(LocalDate.parse(checkOutDate));
        return bookingService.createBooking(booking);
    }

    private Room createRoom(String name, String price, int guestCount, int floorNumber) {
        Room room = new Room();
        room.setName(name);
        room.setPrice(new BigDecimal(price));
        room.setGuestCount(guestCount);
        room.setFloorNumber(floorNumber);
        return roomService.create(room);
    }

    private Customer createCustomer(String name, String email, String registrationDate) {
        Customer customer = new Customer();
        customer.setName(name);
        customer.setEmail(email);
        customer.setRegistrationDate(LocalDate.parse(registrationDate));
        return customerService.create(customer);
    }


}
