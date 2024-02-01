package gr.codehub.firsteuropeandynapp.controller;

import gr.codehub.firsteuropeandynapp.model.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/")
public class DynController {
    @GetMapping("ping")
    public String getGreeting(){
        return "The is service is up.";
    }

}
