package gr.codehub.firsteuropeandynapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/api")
public class PingController {
    @GetMapping("/ping")
    public String getGreeting(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("DDD dd/MM/yyyy  HH:mm:ss");
        return "The ping service is up.<br/>" + LocalDateTime.now().format(dtf);
    }

}
