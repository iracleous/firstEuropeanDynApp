package gr.codehub.firsteuropeandynapp.service;

import gr.codehub.firsteuropeandynapp.exceptions.EntityException;
import gr.codehub.firsteuropeandynapp.model.Customer;
import gr.codehub.firsteuropeandynapp.model.Room;
import gr.codehub.firsteuropeandynapp.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements  CustomerService {
    private final CustomerRepository customerRepository;
    protected final Logger logger = LoggerFactory.getLogger(getClass());
    @Override
    public Customer create(Customer model) {

        logger.info("--------Info for customer create");

        customerRepository.save(model);
        return model;
    }

    @Override
    public List<Customer> read() {
        return customerRepository.findAll();
    }

    @Override
    public Customer read(Long id) {
        return customerRepository.findById(id).get();
    }

    @Override
    public Customer update(Long id, Customer newCustomer) {
        Customer currentCustomer = read(id);
        if (currentCustomer == null) {
            return null;
        }
        newCustomer.setId(id); // risky, because newCustomer might be used somewhere else
        return customerRepository.save(newCustomer);
    }

    @Override
    public Customer delete(Long id) {
        Customer customer = read(id);
        if (customer != null) {
            customerRepository.delete(customer); // throws RuntimeException!!!
        }
        return customer;
    }

}
