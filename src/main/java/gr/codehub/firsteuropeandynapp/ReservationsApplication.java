package gr.codehub.firsteuropeandynapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ReservationsApplication {

    public static void main(String[] args) {

        SpringApplication.run(ReservationsApplication.class, args);
    }

}
