package gr.codehub.firsteuropeandynapp.service;

import gr.codehub.firsteuropeandynapp.customexceptions.EntityException;
import gr.codehub.firsteuropeandynapp.model.Customer;
import gr.codehub.firsteuropeandynapp.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements  GeneralService<Customer, Long>{
    private final CustomerRepository customerRepository;

    @Override
    public Customer create(Customer customer) throws EntityException {
        if (customer == null || customer.getEmail() == null){
            throw new EntityException("null input customer");
        }
        if(!customer.getEmail().endsWith("@gmail.com") ){
            return null;
        }
        customerRepository.save(customer);
        return customer;
    }

    @Override
    public List<Customer> read() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> read(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public Optional<Customer> update(Long id, Customer newCustomerValues) {
        Optional<Customer> customer = read(id);
        if (customer.isPresent()){
            Customer currentCustomer = customer.get();
            currentCustomer.setEmail(newCustomerValues.getEmail());
            customerRepository.save(currentCustomer);
            return Optional.of(currentCustomer);
        }
        return  Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        Optional<Customer> customer = read(id);
        if (customer.isPresent()){
            customerRepository.delete(customer.get());
            return true;
        }
        return false;
    }


}
