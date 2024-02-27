package gr.codehub.firsteuropeandynapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication(exclude = {RedisAutoConfiguration.class})
// @EnableCaching
public class ReservationsApplication {

    public static void main(String[] args) {

        SpringApplication.run(ReservationsApplication.class, args);
    }

}
