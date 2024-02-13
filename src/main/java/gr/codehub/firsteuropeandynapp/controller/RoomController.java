package gr.codehub.firsteuropeandynapp.controller;


import gr.codehub.firsteuropeandynapp.exceptions.EntityException;
import gr.codehub.firsteuropeandynapp.model.Room;
import gr.codehub.firsteuropeandynapp.service.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room")
@AllArgsConstructor
public class RoomController {
    private final RoomService roomService;

    @PostMapping
    public Room createRoom(@RequestBody Room Room) throws EntityException {
        return roomService.create(Room);
    }

    @GetMapping
    public List<Room> getRoom() {
        return roomService.read();
    }

    @GetMapping("/{roomId}")
    public Room getRoom(@PathVariable long roomId) {
        try {
            return roomService.read(roomId);
        }
        catch(Exception e){
            return null;
        }
    }

    @PutMapping("/{roomId}")
    public Room updateRoom(@PathVariable long roomId, @RequestBody Room newRoom) {
        //get all Room
        return roomService.update(roomId, newRoom);
    }

    @DeleteMapping("{RoomId}")
    public Room deleteRoom(@PathVariable long RoomId) {
        //get all Room
        return roomService.delete(RoomId);
    }

}
