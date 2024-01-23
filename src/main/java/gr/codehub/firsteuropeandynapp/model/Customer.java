package gr.codehub.firsteuropeandynapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import java.sql.Date;

@Data
//avoiding boilerplate code
@Entity
//model, entity, domain,
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String name;
//    @Pattern(regexp = ".*([a-zA-Z0-9]{4}$)")
    @NotNull
    private String email;
    private Date registrationDate;
}
