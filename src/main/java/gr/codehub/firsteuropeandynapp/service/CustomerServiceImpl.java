package gr.codehub.firsteuropeandynapp.service;

import gr.codehub.firsteuropeandynapp.model.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements  GeneralService<Customer, Integer>{
    private static ArrayList<Customer> customers = new ArrayList<>();
    @Override
    public Customer create(Customer customer) {
        customers.add(customer);
        return customer;
    }

    @Override
    public List<Customer> read() {
        return customers;
    }

    @Override
    public Customer read(Integer customerId) {
        return null;
    }

    @Override
    public Customer update(Integer customerId, Customer newCustomerValues) {
        return null;
    }

    @Override
    public boolean delete(Integer customerId) {
        return false;
    }
}
