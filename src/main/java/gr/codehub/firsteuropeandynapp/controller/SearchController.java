package gr.codehub.firsteuropeandynapp.controller;

import gr.codehub.firsteuropeandynapp.model.Room;
import gr.codehub.firsteuropeandynapp.service.SearchService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/search")
@AllArgsConstructor
public class SearchController {
    private final SearchService searchService;

    @GetMapping("/guests/{guestCount}")
    public List<Room> findRoomsByGuestCount(@PathVariable(value = "guestCount") int guestCount) {
        return searchService.findRoomsByGuestCount(guestCount);
    }

    @GetMapping("/price/{price}")
    public List<Room> findRoomsByPrice_ANY_NAME_I_LIKE(@PathVariable(value = "price") BigDecimal price) {
        return searchService.findRoomsByPrice_ANY_NAME_I_LIKE(price);
    }

    @GetMapping("/offers")
    public List<Room> findRoomsoffers() {
        return searchService.findRoomOffers();
    }
}
