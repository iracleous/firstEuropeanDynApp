package gr.codehub.firsteuropeandynapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.sql.Date;


@Setter
@Getter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Customer customer;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Room room;
    private Date startingDate;
    private Date endingDate;


}
