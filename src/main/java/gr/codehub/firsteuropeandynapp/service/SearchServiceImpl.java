package gr.codehub.firsteuropeandynapp.service;

import gr.codehub.firsteuropeandynapp.model.Room;
import gr.codehub.firsteuropeandynapp.repository.RoomRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

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
}
