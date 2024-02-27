package gr.codehub.firsteuropeandynapp.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class RoomReview {

    @EmbeddedId
    private RoomReviewKey key;

    private int reviewStars;
    private String reviewText;




}
