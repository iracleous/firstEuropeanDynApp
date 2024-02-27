package gr.codehub.firsteuropeandynapp.repository;

import gr.codehub.firsteuropeandynapp.model.RoomReview;
import gr.codehub.firsteuropeandynapp.model.RoomReviewKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomReviewRepository extends JpaRepository<RoomReview, RoomReviewKey> {
}
