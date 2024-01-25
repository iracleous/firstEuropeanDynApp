package gr.codehub.firsteuropeandynapp.service;

import gr.codehub.firsteuropeandynapp.dto.RentDto;
import gr.codehub.firsteuropeandynapp.model.Rent;

import java.sql.Date;
import java.util.Optional;

public interface RentService {
    Rent addRent(RentDto rentDto);
    boolean cancelRent(long rentId);
    Optional<Rent> getRent(long rentId);
}
