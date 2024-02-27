package gr.codehub.firsteuropeandynapp.service;

import gr.codehub.firsteuropeandynapp.exceptions.EntityException;
import gr.codehub.firsteuropeandynapp.model.RoomReview;
import gr.codehub.firsteuropeandynapp.model.RoomReviewKey;
import gr.codehub.firsteuropeandynapp.repository.RoomReviewRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RoomReviewServiceImpl implements RoomReviewService {
    private final RoomReviewRepository roomReviewRepository;

    @Override
    public RoomReview create(RoomReview model) {
        return roomReviewRepository.save(model);
    }

    @Override
    public List<RoomReview> read() {
        return roomReviewRepository.findAll();
    }

    @Override
    public RoomReview read(RoomReviewKey key) throws EntityException {
        return roomReviewRepository.findById(key).get();
    }

    @Override
    public RoomReview update(RoomReviewKey id, RoomReview newValues) {
        throw new RuntimeException("Reviews cannot be updated!");
    }

    @Override
    public RoomReview delete(RoomReviewKey id) {
        throw new RuntimeException("Reviews cannot be updated!");
    }
}
