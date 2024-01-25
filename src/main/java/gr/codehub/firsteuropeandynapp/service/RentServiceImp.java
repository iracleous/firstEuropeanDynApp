package gr.codehub.firsteuropeandynapp.service;

import gr.codehub.firsteuropeandynapp.dto.RentDto;
import gr.codehub.firsteuropeandynapp.model.Customer;
import gr.codehub.firsteuropeandynapp.model.Rent;
import gr.codehub.firsteuropeandynapp.model.Room;
import gr.codehub.firsteuropeandynapp.repository.CustomerRepository;
import gr.codehub.firsteuropeandynapp.repository.RentRepository;
import gr.codehub.firsteuropeandynapp.repository.RoomRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class RentServiceImp implements RentService{
    private final CustomerRepository customerRepository;
    private final RoomRepository roomRepository;
    private final RentRepository rentRepository;
    @Override
    public Rent addRent(RentDto rentDto) {
        Customer customer = customerRepository
                .findById(rentDto.getCustomerId())
                .get();
        Room room = roomRepository
                .findById(rentDto.getRoomId())
                .get();
        Rent rent =  Rent
                .builder()
                .customer(customer)
                .room(room)
                .startingDate(rentDto.getStartingDate())
                .endingDate(rentDto.getEndingDate())
                .build()
                ;

//        Rent rent = new Rent();
//        rent.setCustomer(customer);
//        rent.setRoom(room);
//        rent.setStartingDate(rentDto.getStartingDate());
//        rent.setEndingDate(rentDto.getEndingDate());

        rentRepository.save(rent);
        return rent;
    }

    @Override
    public boolean cancelRent(long rentId) {
       Optional<Rent> rent = rentRepository.findById(rentId) ;
       if(rent.isPresent()){
            rentRepository.delete(rent.get());
            return true;
       }
       return false;
    }

    @Override
    public Optional<Rent> getRent(long rentId){

        Optional<Rent> rent =  rentRepository.findById(rentId);

        return rent;
    }
}
