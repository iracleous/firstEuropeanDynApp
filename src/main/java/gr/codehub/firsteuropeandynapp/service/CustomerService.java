package gr.codehub.firsteuropeandynapp.service;

import gr.codehub.firsteuropeandynapp.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    Customer createCustomer(Customer customer);
    List<Customer> readCustomer();
    Optional<Customer> readCustomer(long customerId);
    Customer updateCustomer(long customerId, Customer newCustomerValues);
    boolean deleteCustomer(long customerId);
}
