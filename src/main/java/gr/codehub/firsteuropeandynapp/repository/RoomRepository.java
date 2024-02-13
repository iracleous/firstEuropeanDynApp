package gr.codehub.firsteuropeandynapp.repository;

import gr.codehub.firsteuropeandynapp.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    List<Room> findByGuestCountGreaterThan(int guestCount);

    List<Room> findByPriceLessThanEqual(BigDecimal price);

//    @Query("""
//        select room
//        from Room room
//        where room.price<=:price and room.guestCount<=:guestCount
//        """)
    List<Room> findByPriceLessThanEqualAndGuestCountGreaterThanEqual(BigDecimal price, int guestCount);
}
