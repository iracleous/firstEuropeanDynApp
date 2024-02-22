package gr.codehub.firsteuropeandynapp.service;

import gr.codehub.firsteuropeandynapp.model.Room;
import gr.codehub.firsteuropeandynapp.repository.RoomRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SearchServiceImpl implements SearchService {

    private final RoomRepository roomRepository;

    @Override
    public List<Room> findRoomsByGuestCount(int guestCount) {
        return roomRepository.findByGuestCountGreaterThan(guestCount);
    }

    @Override
    public List<Room> findRoomsByPrice_ANY_NAME_I_LIKE(BigDecimal price) {
        return roomRepository.findByPriceLessThanEqual(price);
    }

    @Override
    public List<Room> findRoomOffers() {
        return roomRepository.findByPriceLessThanEqualAndGuestCountGreaterThanEqual(new BigDecimal("59.90"), 2);
    }

    @Override
    public List<Room> findRoomByDate(LocalDate bookingDate) {
        // return roomRepository.findAvailableByDate(bookingDate);
        List<Room> unavailableRoomsOnDate = roomRepository.findUnavailableByDate(bookingDate);
        List<Room> availableForBooking = roomRepository
                .findAll()
                .stream()
//                .filter(r -> !unavailableRoomsOnDate.contains(r))
                .filter( Predicate.not(unavailableRoomsOnDate::contains))
                .collect(Collectors.toList());
        return availableForBooking;
    }
}
