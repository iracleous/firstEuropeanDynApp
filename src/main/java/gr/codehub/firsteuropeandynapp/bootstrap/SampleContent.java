package gr.codehub.firsteuropeandynapp.bootstrap;

import gr.codehub.firsteuropeandynapp.dto.RentDto;
import gr.codehub.firsteuropeandynapp.model.Customer;
import gr.codehub.firsteuropeandynapp.model.Rent;
import gr.codehub.firsteuropeandynapp.model.Room;
import gr.codehub.firsteuropeandynapp.service.CustomerService;
import gr.codehub.firsteuropeandynapp.service.GeneralService;
import gr.codehub.firsteuropeandynapp.service.RentService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.Date;

@Component
@AllArgsConstructor
public class SampleContent implements CommandLineRunner {
    private final GeneralService<Room,Long> roomService;
    private final GeneralService<Customer,Long> customerService;
    private  final RentService rentService;
    @Override
    public void run(String... args) throws Exception {
        Customer customer = new Customer();
        customer.setName("Lefteris");
        customer.setEmail("lef@gmail.com");
        customer.setRegistrationDate( new Date(100,10,28));
        customer = customerService.create(customer);

        Room room = new Room();
        room.setPrice(new BigDecimal("100.05"));
        room.setSize(1);
        room.setFloor(1);
        room = roomService.create(room);

        RentDto rent = new RentDto();
        rent.setCustomerId(customer.getId());
        rent.setRoomId(room.getId());
        rent.setStartingDate(new Date(124,1,1));
        rent.setEndingDate(new Date(124,1,2));
        rentService.addRent(rent);
    }
}
