package gr.codehub.firsteuropeandynapp.controller;

import gr.codehub.firsteuropeandynapp.dto.RentDto;
import gr.codehub.firsteuropeandynapp.model.Rent;
import gr.codehub.firsteuropeandynapp.service.RentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("rent")
public class RentController {
    private final RentService rentService;

    @PostMapping("")
    public Rent addRent(@RequestBody RentDto rentDto) {
        return rentService.addRent(rentDto);
    }

    @DeleteMapping("{rentId}")
    public boolean cancelRent(@PathVariable long rentId) {
        return rentService.cancelRent(rentId);
    }

    @GetMapping("{rentId}")
    public Optional<Rent> getRent(@PathVariable long rentId) {
        return rentService.getRent(rentId);
    }
}
