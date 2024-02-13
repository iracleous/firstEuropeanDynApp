package gr.codehub.firsteuropeandynapp.service;

import gr.codehub.firsteuropeandynapp.model.Room;

import java.math.BigDecimal;
import java.util.List;

public interface SearchService {

    List<Room> findRoomsByGuestCount(int guestCount);

    List<Room> findRoomsByPrice_ANY_NAME_I_LIKE(BigDecimal price);

    List<Room> findRoomOffers();
}
