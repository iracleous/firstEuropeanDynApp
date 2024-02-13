package gr.codehub.firsteuropeandynapp.repository;

import gr.codehub.firsteuropeandynapp.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Long> {

    //JPQL
    @Query("""
            select b 
            from Booking b 
            where b.customer.id= :customerId
            """)
    List<Booking> getBookingsByCustomerId(Long customerId);

    @Query("""
            select b 
            from Booking b 
            where b.customer.id= :customerId
            """)
    Optional<Booking> getBookingByCustomerId(Long customerId);

}
