package gr.codehub.firsteuropeandynapp.service;

import gr.codehub.firsteuropeandynapp.customexceptions.EntityException;
import gr.codehub.firsteuropeandynapp.model.Room;
import gr.codehub.firsteuropeandynapp.repository.RoomRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
public class RoomServiceImpl implements GeneralService<Room,Long>{
    private final RoomRepository roomRepository;
    @Override
    public Room create(Room model) throws EntityException {
        roomRepository.save(model);
        return model;
    }

    @Override
    public List<Room> read() {
        return roomRepository.findAll();
    }

    @Override
    public Optional<Room> read(Long id) {
        return  roomRepository.findById(id);
    }

    @Override
    public Optional<Room> update(Long id, Room newRoomValues) {
        Optional<Room> optionalRoom = read(id);
        if (optionalRoom.isEmpty())
            return Optional.empty();
        Room room = optionalRoom.get();
        room.setPrice(newRoomValues.getPrice() );
        roomRepository.save(room);
        return Optional.of(room);
    }

    @Override
    public boolean delete(Long id) {
        Optional<Room> room = read(id);
        if (room.isPresent()){
            roomRepository.delete(room.get());
            return true;
        }
        return false;
    }
}
