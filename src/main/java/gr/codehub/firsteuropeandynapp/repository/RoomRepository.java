package gr.codehub.firsteuropeandynapp.repository;

import gr.codehub.firsteuropeandynapp.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
}
