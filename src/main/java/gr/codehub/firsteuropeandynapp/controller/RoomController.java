package gr.codehub.firsteuropeandynapp.controller;


import gr.codehub.firsteuropeandynapp.exceptions.EntityException;
import gr.codehub.firsteuropeandynapp.model.Room;
import gr.codehub.firsteuropeandynapp.service.GeneralService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Room")
@AllArgsConstructor
public class RoomController {
    private final GeneralService<Room,Long> roomService ;
    @PostMapping
    public Room createRoom(@RequestBody Room Room) throws EntityException {
        //save Room
        return roomService.create(Room);
    }
    @GetMapping
    public List<Room> getRoom(){
        //get all Room
        return roomService.read();
    }
    @GetMapping("{RoomId}")
    public Room getRoom(@PathVariable long RoomId){
        //get all Room
        return roomService.read(RoomId);
    }

    @PutMapping("{RoomId}")
    public  Room updateRoom(@PathVariable long RoomId,@RequestBody Room newRoomValues){
        //get all Room
        return roomService.update(RoomId, newRoomValues);
    }

    @DeleteMapping ("{RoomId}")
    public Room deleteRoom(@PathVariable long RoomId){
        //get all Room
        return roomService.delete(RoomId);
    }

}
