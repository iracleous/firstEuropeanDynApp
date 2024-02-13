package gr.codehub.firsteuropeandynapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int floorNumber;
    private int guestCount;
    private BigDecimal price;
    private Date renovationDate;
    private boolean hasShower;

    @OneToMany(mappedBy = "room")
    @JsonIgnore
    private List<Booking> bookings;
}
