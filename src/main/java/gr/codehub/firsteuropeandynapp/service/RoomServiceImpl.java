package gr.codehub.firsteuropeandynapp.service;

import gr.codehub.firsteuropeandynapp.exceptions.EntityException;
import gr.codehub.firsteuropeandynapp.model.Room;
import gr.codehub.firsteuropeandynapp.repository.RoomRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RoomServiceImpl implements GeneralService<Room, Long> {
    private final RoomRepository roomRepository;

    @Override
    public Room create(Room model) {
        roomRepository.save(model);
        return model;
    }

    @Override
    public List<Room> read() {
        return roomRepository.findAll();
    }

    @Override
    public Room read(Long id) {
        return roomRepository.findById(id).get();
    }

    @Override
    public Room update(Long id, Room newRoom) {
        Room currentRoom = read(id);
        if (currentRoom == null) {
            return null;
        }
        newRoom.setId(id); // risky, because newRoom might be used somewhere else
        return roomRepository.save(newRoom);
    }

    @Override
    public Room delete(Long id) {
        Room room = read(id);
        if (room != null) {
            roomRepository.delete(room); // throws RuntimeException!!!
        }
        return room;
    }
}
