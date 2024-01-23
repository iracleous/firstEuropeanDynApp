package gr.codehub.firsteuropeandynapp.repository;

import gr.codehub.firsteuropeandynapp.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
